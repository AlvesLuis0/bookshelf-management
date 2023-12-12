#!/usr/bin/bash
COMMAND=$1

case $COMMAND in
  "install")
    mvn package -DskipTests
    ;;

  "run")
    env $(cat .env) java -jar target/bookshelf-management-1.0.0.jar
    ;;

  "clean")
    mvn clean
    ;;

  *)
    echo "[WARNING] Unknown command."
    ;;
esac