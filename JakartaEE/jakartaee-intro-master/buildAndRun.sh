#!/bin/sh
mvn clean package && docker build -t it.tss/jakartaee .
docker rm -f jakartaee || true && docker run -d -p 8080:8080 -p 4848:4848 --name jakartaee it.tss/jakartaee 
