all: compile

run: compile
	@mvn exec:java

compile:
	@mvn compile

eclipse-project: clean
	@mvn eclipse:eclipse

package:
	@mvn package

clean:
	@rm -Rf *~

mrproper: clean
	@mvn clean
