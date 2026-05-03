#!/usr/bin/env sh
echo "Downloading Gradle..."
curl -L https://services.gradle.org/distributions/gradle-8.7-bin.zip -o gradle.zip
unzip gradle.zip
./gradle-8.7/bin/gradle assembleDebug
