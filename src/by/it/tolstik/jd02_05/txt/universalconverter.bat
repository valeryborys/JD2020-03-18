set path="C:\Program Files\Java\jdk1.8.0_251\bin"
cd D:\projectjava\JD2020-03-18\src\by\it\tolstik\jd02_05\txt
FOR %%I In (*.txt) DO (
native2ascii.exe -encoding utf-8 %%I ../res/%%~nI.properties
)