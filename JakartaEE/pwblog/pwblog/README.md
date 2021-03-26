# Build
mvn clean package && docker build -t tss.ciac/pwblog .

# RUN

docker rm -f pwblog || true && docker run -d -p 8080:8080 -p 4848:4848 --name pwblog tss.ciac/pwblog 

# System Test

Switch to the "-st" module and perform:

mvn compile failsafe:integration-test