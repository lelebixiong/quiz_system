#!/bin/sh


REPOSITORY=../repositories/maven
GROUP_XJTLU=xjtlu/cpt111

SOURCE_PATH=src
DESTINATION_PATH=build


javac -sourcepath ${SOURCE_PATH} \
  -d "${DESTINATION_PATH}" \
  -p . \
  ${SOURCE_PATH}/xjtlu/cpt111/methods/simulation/*.java

