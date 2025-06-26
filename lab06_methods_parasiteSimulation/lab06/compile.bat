
@echo off

set REPOSITORY=..\repositories\maven
set GROUP_XJTLU=xjtlu\cpt111

set SOURCE_PATH=src
set DESTINATION_PATH=build


javac -sourcepath %SOURCE_PATH% ^
  -d %DESTINATION_PATH% ^
  -p . ^
  %SOURCE_PATH%\xjtlu\cpt111\methods\simulation\*.java

