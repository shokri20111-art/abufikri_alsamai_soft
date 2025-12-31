#!/usr/bin/env bash

# محرك بناء أندرويد للأنظمة الذكية
APP_HOME=$(pwd)
gradle_version="8.0"

if [ ! -f "$APP_HOME/gradlew" ]; then
    echo "إعداد محرك البناء..."
fi

exec bash ./app/gradlew "$@"