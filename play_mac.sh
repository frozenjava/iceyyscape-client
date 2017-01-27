#!/bin/bash

#
# This script lets you play iceyyscape on mac or linux!
# Make sure to have Java 8 installed on your system or this will not work!
#

# if the cache doesn't exist in the users home directory then copy it over there
if [ ! -d ~/Icache31 ]; then
    if [ -d ./Icache31 ]; then
        cp -r ./Icache31 ~/
        echo 'Copied cache to users home directory...'
    else
        echo '[ERROR] Unable to locate cache!'
        exit 0
    fi
fi

# check if the jar exists and run it
if [ -f iceyyscape-client.jar ]; then
    echo 'Starting IceyyScape...'
    java -jar iceyyscape-client.jar
else
    echo '[ERROR] Unable to locate jar file!'
fi