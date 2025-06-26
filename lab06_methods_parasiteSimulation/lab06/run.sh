#!/bin/sh


REPOSITORY=../repositories/maven
GROUP_XJTLU=xjtlu/cpt111

SOURCE_PATH=src
DESTINATION_PATH=build


java -cp .:${DESTINATION_PATH} xjtlu.cpt111.methods.simulation.ParasiteSimulation

