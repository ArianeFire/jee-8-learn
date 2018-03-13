#!bin/bash

set -eu

mvn clean package

cp target/jee-8-learn-1.0.0.war D:/glassfish5/glassfish/domains/domain1/autodeploy/

cd D:/glassfish5/bin

asadmin start-domain domain1


#docker run -rm \
#	-p 8080:8080 \
#	-v $(pwd)/target/jee-8-learn-1.0.0.war:/glassfish5/glassfish/domains/domain1/autodeploy/jee-8-learn-1.0.0.war \
#	oracle/glassfish:5.0