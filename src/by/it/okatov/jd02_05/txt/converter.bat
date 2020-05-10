SET PATH="C:\Program Files\Java\jdk1.8.0_161\bin"
FOR %%I IN (*.TXT) DO (
native2ascii -encoding utf-8 %%I ../Resources/%%~nI.properties
)