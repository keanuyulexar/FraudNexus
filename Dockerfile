FROM ubuntu:latest
LABEL authors="keanu"

ENTRYPOINT ["top", "-b"]