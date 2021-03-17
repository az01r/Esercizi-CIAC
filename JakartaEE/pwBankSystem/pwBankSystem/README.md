# Build
mvn clean package && docker build -t tss.ciac/pwBankSystem .

# RUN

docker rm -f pwBankSystem || true && docker run -d -p 8080:8080 -p 4848:4848 --name pwBankSystem tss.ciac/pwBankSystem 

# System Test

Switch to the "-st" module and perform:

mvn compile failsafe:integration-test