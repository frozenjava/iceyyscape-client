import java.io.RandomAccessFile;
import java.io.IOException;

/**
 * @author tom
 */
public class Cache {

    public Cache(RandomAccessFile dataFile, RandomAccessFile indexFile, int cacheNo)
    {
        maxFileSize = 6500000;
        this.cacheNo = cacheNo;
        this.dataFile = dataFile;
        this.indexFile = indexFile;
    }

    public int getNumFiles() {
        try {
            return ((int) indexFile.length()/6);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public synchronized byte[] getFile(int fileNumber)
    {
        try
        {
            seekTo(indexFile, fileNumber * 6);
            int readThisCycle;
            for(int totalRead = 0; totalRead < 6; totalRead += readThisCycle) // Read 6 bytes from index into readBuffer
            {
                readThisCycle = indexFile.read(readBuffer, totalRead, 6 - totalRead);
                if(readThisCycle == -1) {
                    return null;
                }

            }

            int totalFileSize = ((readBuffer[0] & 0xff) << 16) + ((readBuffer[1] & 0xff) << 8) + (readBuffer[2] & 0xff);
            int nextSectorId = ((readBuffer[3] & 0xff) << 16) + ((readBuffer[4] & 0xff) << 8) + (readBuffer[5] & 0xff);
            if(totalFileSize < 0 || totalFileSize > maxFileSize) {
                return null;
            }
            if(nextSectorId <= 0 || (long)nextSectorId > dataFile.length() / 520L) {
                return null;
            }
            byte fileBuffer[] = new byte[totalFileSize];
            int dataReadSoFar = 0;
            int expectedFilePartitionNo = 0;
            while(totalFileSize > dataReadSoFar)
            {
                if(nextSectorId == 0) {
                    return null;
                }
                seekTo(dataFile, nextSectorId * 520); // 1 sector = 520 bytes
                int totalRead = 0;
                int amountToReadThisCycle = totalFileSize - dataReadSoFar;
                if(amountToReadThisCycle > 512)
                    amountToReadThisCycle = 512;
                for(; totalRead < amountToReadThisCycle + 8; totalRead += readThisCycle) // Read the file + 8 bytes header
                {
                    readThisCycle = dataFile.read(readBuffer, totalRead, (amountToReadThisCycle + 8) - totalRead);
                    if(readThisCycle == -1)
                        return null;
                }

                int nextSectorsFileNo = ((readBuffer[0] & 0xff) << 8) + (readBuffer[1] & 0xff);
                int filePartitionNo = ((readBuffer[2] & 0xff) << 8) + (readBuffer[3] & 0xff);
                int nextSectorsId = ((readBuffer[4] & 0xff) << 16) + ((readBuffer[5] & 0xff) << 8) + (readBuffer[6] & 0xff);
                int nextSectorsCacheNo = readBuffer[7] & 0xff;
                if(nextSectorsFileNo != fileNumber || filePartitionNo != expectedFilePartitionNo || nextSectorsCacheNo != cacheNo) {
                    return null;
                }
                if(nextSectorsId < 0 || (long)nextSectorsId > dataFile.length() / 520L) {
                    return null;
                }
                for(int copyCaret = 0; copyCaret < amountToReadThisCycle; copyCaret++)
                    fileBuffer[dataReadSoFar++] = readBuffer[copyCaret + 8];

                nextSectorId = nextSectorsId;
                expectedFilePartitionNo++;
            }

            return fileBuffer;
        }
        catch(IOException _ex)
        {
            return null;
        }
    }

    public synchronized boolean addOrEditFile(int fileNo, int fileLength, byte fileBuffer[])
    {
        boolean fileExists = addFile(fileNo, fileLength, fileBuffer, true);
        if(!fileExists)
            fileExists = addFile(fileNo, fileLength, fileBuffer, false);
        return fileExists;
    }

    private synchronized boolean addFile(int fileNo, int fileLength, byte fileBuffer[], boolean fileExists)
    {
        try
        {
            int curSectorId;
            if(fileExists)
            {
                seekTo(indexFile, fileNo * 6);
                int k1;
                for(int i1 = 0; i1 < 6; i1 += k1) // Read the previous file index
                {
                    k1 = indexFile.read(readBuffer, i1, 6 - i1);
                    if(k1 == -1) {
                        return false;
                    }
                }

                curSectorId = ((readBuffer[3] & 0xff) << 16) + ((readBuffer[4] & 0xff) << 8) + (readBuffer[5] & 0xff);
                if(curSectorId <= 0 || (long)curSectorId > dataFile.length() / 520L) {
                    return false;
                }
            } else
            {
                curSectorId = (int)((dataFile.length() + 519L) / 520L);
                if(curSectorId == 0)
                    curSectorId = 1;
            }
            readBuffer[0] = (byte)(fileLength >> 16);
            readBuffer[1] = (byte)(fileLength >> 8);
            readBuffer[2] = (byte)fileLength;
            readBuffer[3] = (byte)(curSectorId >> 16);
            readBuffer[4] = (byte)(curSectorId >> 8);
            readBuffer[5] = (byte)curSectorId;
            seekTo(indexFile, fileNo * 6);
            indexFile.write(readBuffer, 0, 6);
            int dataWrittenSoFar = 0;
            for(int expectedFilePartitionNo = 0; dataWrittenSoFar < fileLength; expectedFilePartitionNo++)
            {
                int nextSectorId = 0;
                if(fileExists)
                {
                    seekTo(dataFile, curSectorId * 520);
                    int j2;
                    int l2;
                    for(j2 = 0; j2 < 8; j2 += l2)
                    {
                        l2 = dataFile.read(readBuffer, j2, 8 - j2);
                        if(l2 == -1)
                            break;
                    }

                    if(j2 == 8)
                    {
                        int amountOfDataWrittenThisCycle = ((readBuffer[0] & 0xff) << 8) + (readBuffer[1] & 0xff);
                        int prevFilePartitionNo = ((readBuffer[2] & 0xff) << 8) + (readBuffer[3] & 0xff);
                        nextSectorId = ((readBuffer[4] & 0xff) << 16) + ((readBuffer[5] & 0xff) << 8) + (readBuffer[6] & 0xff);
                        int prevCacheNo = readBuffer[7] & 0xff;
                        if(amountOfDataWrittenThisCycle != fileNo || prevFilePartitionNo != expectedFilePartitionNo || prevCacheNo != cacheNo)
                            return false;
                        if(nextSectorId < 0 || (long)nextSectorId > dataFile.length() / 520L)
                            return false;
                    }
                }
                if(nextSectorId == 0)
                {
                    fileExists = false;
                    nextSectorId = (int)((dataFile.length() + 519L) / 520L);
                    if(nextSectorId == 0)
                        nextSectorId++;
                    if(nextSectorId == curSectorId)
                        nextSectorId++;
                }
                if(fileLength - dataWrittenSoFar <= 512)
                    nextSectorId = 0;
                readBuffer[0] = (byte)(fileNo >> 8);
                readBuffer[1] = (byte)fileNo;
                readBuffer[2] = (byte)(expectedFilePartitionNo >> 8);
                readBuffer[3] = (byte)expectedFilePartitionNo;
                readBuffer[4] = (byte)(nextSectorId >> 16);
                readBuffer[5] = (byte)(nextSectorId >> 8);
                readBuffer[6] = (byte)nextSectorId;
                readBuffer[7] = (byte) cacheNo;
                seekTo(dataFile, curSectorId * 520);
                dataFile.write(readBuffer, 0, 8);
                int amountOfDataWrittenThisCycle = fileLength - dataWrittenSoFar;
                if(amountOfDataWrittenThisCycle > 512)
                    amountOfDataWrittenThisCycle = 512;
                dataFile.write(fileBuffer, dataWrittenSoFar, amountOfDataWrittenThisCycle);
                dataWrittenSoFar += amountOfDataWrittenThisCycle;
                curSectorId = nextSectorId;
            }

            return true;
        }
        catch(IOException _ex)
        {
            return false;
        }
    }

    public synchronized void seekTo(RandomAccessFile randomaccessfile, int position)
        throws IOException
    {
        if(position < 0 || position > 0x3c00000)
        {
            position = 0x3c00000;
            try
            {
                Thread.sleep(1000L);
            }
            catch(Exception ignored) { }
        }
        randomaccessfile.seek(position);
    }

    private boolean aBoolean307;
    static byte readBuffer[] = new byte[520];
    RandomAccessFile dataFile;
    RandomAccessFile indexFile;
    int cacheNo;
    int maxFileSize;
}