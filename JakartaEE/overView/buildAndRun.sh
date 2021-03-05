#!/bin/sh
mvn clean package && docker build -t tss.ciac/overView .
docker rm -f overView || true && docker run -d -p 8080:8080 -p 4848:4848 --name overView tss.ciac/overView 
