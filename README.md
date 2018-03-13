# jee-8-learn


This project is kind of discovery of Java EE 8 features.

We may find the following point in practice :
  
  Core JEE Components
  JAX-RS (JSON-P, JSON-B)
  
  
# build-run.sh
	
	This script basicly generate the package & Deploy it manually on a glassfish5 server.
	
	In fact Glassfish 5 is not yet supported on Eclispe, so this tricky way is from this  stackoverflow 	post:	https://stackoverflow.com/questions/46584107/eclipse-support-for-glassfish-5
	
	So you may also need to download Glassfish 5 server from here : https://javaee.github.io/glassfish/downloads/ri/README
	
	Finally customize the file to fit your need.
	

# Run the some test :

	To run this app, you may first launch "build-run.sh"
	
	Then for REST API check : http://localhost:8080/Car/resources/cars
