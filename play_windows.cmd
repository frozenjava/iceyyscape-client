
@ECHO OFF

IF NOT EXIST %HOMEPATH%\Icache31 (
  IF EXIST .\Icache31 (
    ECHO Copied cache to users home directory...
    XCOPY .\Icache31\* %HOMEPATH%\Icache31\ /s /e /h
    GOTO RUNJAR
  ) ELSE (
    ECHO [ERROR] Unable to locate cache!
    GOTO END
  )
) ELSE (
    GOTO RUNJAR
)

:RUNJAR
  IF EXIST .\iceyyscape-client.jar (
    ECHO Starting IceyyScape...
    java -jar .\iceyyscape-client.jar
  ) ELSE (
    ECHO [ERROR] Unable to locate jar file!
    GOTO END
  )

:END
  ECHO ALL DONE.

Pause
