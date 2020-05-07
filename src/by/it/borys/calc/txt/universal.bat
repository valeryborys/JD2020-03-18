set path=C:\Program Files\Java\jdk1.8.0_201\bin
FOR %%I In (*.txt) DO (
native2ascii.exe -encoding utf-8 %%I ../res/%%~nI.properties
)
