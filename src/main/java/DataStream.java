public class DataStream {
    private static final int[] BIT_MASK_OUT = new int[32];
    static {
        for (int i = 0; i < 32; i++) {
            BIT_MASK_OUT[i] = (1 << i) - 1;
        }
    }
    private int bitPosition = 0;
    public byte[] inBuffer;
    private int opcodeStart = 0;
    public byte[] outBuffer;
    private int readLength = 0;
    private int readOffset = 0;
    private int writeLength = 0;

    private int writeOffset = 0;

    public DataStream(int inCapacity, int outCapacity) {
        inBuffer = new byte[inCapacity];
        outBuffer = new byte[outCapacity];
        readLength = inCapacity;
        writeLength = outCapacity;
    }

    public int avail() {
        return remaining();
    }

    public void checkWriteCapacity(int length) {
        if ((writeOffset + length) >= outBuffer.length) {
            byte[] tempBuffer = outBuffer;
            outBuffer = new byte[(writeOffset + length) * 2];
            System.arraycopy(tempBuffer, 0, outBuffer, 0, writeOffset);
        }
    }

    public DataStream clear() {
        readOffset = readLength = 0;
        return this;
    }

    public DataStream endOpcodeVarByte() {
        writeByte(writeOffset - (opcodeStart + 2) + 1, opcodeStart);
        return this;
    }

    public DataStream endOpcodeVarShort() {
        int size = writeOffset - (opcodeStart + 2);
        writeByte(size >> 8, opcodeStart++);
        writeByte(size, opcodeStart);
        return this;
    }

    public DataStream finishBitAccess() {
        writeOffset = (bitPosition + 7) / 8;
        return this;
    }

    public DataStream initBitAccess() {
        bitPosition = writeOffset * 8;
        return this;
    }

    public byte read128Byte() {
        return (byte) (128 - readByte());
    }

    public byte readByte() {
        if (remaining() < 1) {
            return (byte) 0;
        }
        return inBuffer[readOffset++];
    }

    public byte readByte128() {
        return (byte) (readByte() - 128);
    }

    public DataStream readBytes(byte[] array, int endOffset, int startOffset) {
        for (int i = startOffset; i < startOffset + endOffset; i++) {
            array[i] = readByte();
        }
        return this;
    }

    public DataStream readBytesReverse(byte[] array, int endOffset,
            int startOffset) {
        for (int i = (startOffset + endOffset) - 1; i >= startOffset; i--) {
            array[i] = readByte();
        }
        return this;
    }

    public DataStream readBytesReverse128(byte[] array, int endOffset,
            int startOffset) {
        for (int i = (startOffset + endOffset) - 1; i >= startOffset; i--) {
            array[i] = readByte128();
        }
        return this;
    }

    public int readInt() {
        return (readUnsignedByte() << 24) + (readUnsignedByte() << 16)
                + (readUnsignedByte() << 8) + readUnsignedByte();
    }

    public int readIntBigEndian() {
        return readUnsignedByte() + (readUnsignedByte() << 8)
                + (readUnsignedByte() << 16) + (readUnsignedByte() << 24);
    }

    public int readIntV1() {
        return (readUnsignedByte() << 8) + readUnsignedByte()
                + (readUnsignedByte() << 24) + (readUnsignedByte() << 16);
    }

    public int readIntV2() {
        return (readUnsignedByte() << 16) + (readUnsignedByte() << 24)
                + readUnsignedByte() + (readUnsignedByte() << 8);
    }

    public int readLength() {
        return this.readLength;
    }

    public long readLong() {
        long l = readInt() & 0xffffffffL;
        long l1 = readInt() & 0xffffffffL;
        return (l << 32) + l1;
    }

    public int readOffset() {
        return this.readOffset;
    }

    public byte readReversedByte() {
        return (byte) (-readByte());
    }

    public short readShort() {
        int i = (readUnsignedByte() << 8) + readUnsignedByte();
        if (i > 32767) {
            i -= 0x10000;
        }
        return (short) i;
    }

    public short readShort128() {
        int i = (readUnsignedByte() << 8) + (readByte() - 128 & 0xff);
        if (i > 32767) {
            i -= 0x10000;
        }
        return (short) i;
    }

    public short readShortBigEndian() {
        int i = readUnsignedByte() + (readUnsignedByte() << 8);
        if (i > 32767) {
            i -= 0x10000;
        }
        return (short) i;
    }

    public short readShortBigEndian128() {
        int i = (readByte() - 128 & 0xff) + (readUnsignedByte() << 8);
        if (i > 32767) {
            i -= 0x10000;
        }
        return (short) i;
    }

    public DataStream readSkip(int length) {
        readOffset += length;
        return this;
    }

    public String readString() {
        StringBuffer sb = new StringBuffer();
        byte b;
        while ((b = readByte()) != 0) {
            sb.append((char) b);
        }
        return sb.toString().trim();
    }

    public int readUnsigned128Byte() {
        return (128 - readUnsignedByte() & 0xff);
    }

    public int readUnsignedByte() {
        return (readByte() & 0xff);
    }

    public int readUnsignedByte128() {
        return (readUnsignedByte() - 128 & 0xff);
    }

    public int readUnsignedReversedByte() {
        return -(readUnsignedByte() & 0xff);
    }

    public int readUnsignedShort() {
        return (readUnsignedByte() << 8) + readUnsignedByte();
    }

    public int readUnsignedShort128() {
        return (readUnsignedByte() << 8) + (readByte() - 128 & 0xff);
    }

    public int readUnsignedShortBigEndian() {
        return readUnsignedByte() + (readUnsignedByte() << 8);
    }

    public int readUnsignedShortBigEndian128() {
        return (readByte() - 128 & 0xff) + (readUnsignedByte() << 8);
    }

    public int remaining() {
        return readLength - readOffset;
    }

    public void setReadLength(int length) {
        readLength = length;
    }

    public void setReadPos(int pos) {
        readOffset = pos;
    }

    public void setwriteLength(int length) {
        writeLength = length;
    }

    public void setWritePos(int pos) {
        writeOffset = pos;
    }

    public DataStream write128Byte(int i) {
        writeByte(128 - i);
        return this;
    }

    public DataStream writeBits(int numBits, int value) {
        int bytePos = bitPosition >> 3;
        int bitOffset = 8 - (bitPosition & 7);
        bitPosition += numBits;
        for (; numBits > bitOffset; bitOffset = 8) {
            checkWriteCapacity(2);
            outBuffer[bytePos] &= ~BIT_MASK_OUT[bitOffset];
            outBuffer[bytePos++] |= ((value >> (numBits - bitOffset)) & BIT_MASK_OUT[bitOffset]);
            numBits -= bitOffset;
        }
        if (numBits == bitOffset) {
            outBuffer[bytePos] &= ~BIT_MASK_OUT[bitOffset];
            outBuffer[bytePos] |= (value & BIT_MASK_OUT[bitOffset]);
        } else {
            outBuffer[bytePos] &= ~(BIT_MASK_OUT[numBits] << (bitOffset - numBits));
            outBuffer[bytePos] |= (value & BIT_MASK_OUT[numBits]) << (bitOffset - numBits);
        }
        return this;
    }

    public DataStream writeByte(int i) {
        writeByte(i, writeOffset++);
        return this;
    }

    public DataStream writeByte(int i, int position) {
        checkWriteCapacity(1);
        outBuffer[position] = (byte) i;
        return this;
    }

    public DataStream writeByte128(int i) {
        writeByte(i + 128);
        return this;
    }

    public DataStream writeBytes(byte[] array, int endOffset, int startOffset) {
        for (int i = startOffset; i < startOffset + endOffset; i++) {
            writeByte(array[i]);
        }
        return this;
    }

    public DataStream writeBytesReverse(byte[] array, int endOffset,
            int startOffset) {
        for (int i = (startOffset + endOffset) - 1; i >= startOffset; i--) {
            writeByte(array[i]);
        }
        return this;
    }

    public DataStream writeInt(int i) {
        writeByte(i >> 24);
        writeByte(i >> 16);
        writeByte(i >> 8);
        writeByte(i);
        return this;
    }

    public DataStream writeIntBigEndian(int i) {
        writeByte(i);
        writeByte(i >> 8);
        writeByte(i >> 16);
        writeByte(i >> 24);
        return this;
    }

    public DataStream writeIntV1(int i) {
        writeByte(i >> 8);
        writeByte(i);
        writeByte(i >> 24);
        writeByte(i >> 16);
        return this;
    }

    public DataStream writeIntV2(int i) {
        writeByte(i >> 16);
        writeByte(i >> 24);
        writeByte(i);
        writeByte(i >> 8);
        return this;
    }

    public int writeLength() {
        return this.writeLength;
    }

    public DataStream writeLong(long l) {
        writeByte((int) (l >> 56));
        writeByte((int) (l >> 48));
        writeByte((int) (l >> 40));
        writeByte((int) (l >> 32));
        writeByte((int) (l >> 24));
        writeByte((int) (l >> 16));
        writeByte((int) (l >> 8));
        writeByte((int) l);
        return this;
    }

    public int writeOffset() {
        return this.writeOffset;
    }

    public DataStream writeOpcode(int id) {
        writeByte(id);
        return this;
    }

    public DataStream writeOpcodeVarByte(int id) {
        writeOpcode(id);
        writeByte(0);
        opcodeStart = writeOffset - 1;
        return this;
    }

    public DataStream writeOpcodeVarShort(int id) {
        writeOpcode(id);
        writeShort(0);
        opcodeStart = writeOffset - 2;
        return this;
    }

    public DataStream writeReversedByte(int i) {
        writeByte(-i);
        return this;
    }

    public DataStream writeRSString(String s) {
        checkWriteCapacity(s.length() + 1);
        System.arraycopy(s.getBytes(), 0, outBuffer, writeOffset, s.length());
        writeOffset += s.length();
        return this;
    }

    public DataStream writeShort(int i) {
        writeByte(i >> 8);
        writeByte(i);
        return this;
    }

    public DataStream writeShort128(int i) {
        writeByte(i >> 8);
        writeByte(i + 128);
        return this;
    }

    public DataStream writeShortBigEndian(int i) {
        writeByte(i);
        writeByte(i >> 8);
        return this;
    }

    public DataStream writeShortBigEndian128(int i) {
        writeByte(i + 128);
        writeByte(i >> 8);
        return this;
    }

    public DataStream writeString(String s) {
        checkWriteCapacity(s.length() + 1);
        System.arraycopy(s.getBytes(), 0, outBuffer, writeOffset, s.length());
        writeOffset += s.length();
        writeByte(0);
        return this;
    }

    public DataStream writeVarSizeByte(int i) {
        if ((i & 0xff) >= 128) {
            writeShort(i - 32768);
        } else {
            writeByte(i);
        }
        return this;
    }
}