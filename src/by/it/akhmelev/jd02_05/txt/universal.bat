set path=D:\Java\jdk\jdk1.8.0_144\bin
FOR %%I In (*.txt) DO (
native2ascii.exe -encoding utf-8 %%I ../res/%%~nI.properties
)
