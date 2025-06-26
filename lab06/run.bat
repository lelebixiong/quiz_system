
@echo off

set REPOSITORY=..\repositories\maven
set GROUP_XJTLU=xjtlu\cpt111

set SOURCE_PATH=src
set DESTINATION_PATH=build


java -cp .;%DESTINATION_PATH% ^
  xjtlu\cpt111\methods\simulation\ParasiteSimulation

