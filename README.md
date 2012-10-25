Esper Quick Start
=================

Esper Quick Start Application

See http://esper.codehaus.org/tutorials/tutorial/quickstart.html


Prerequisites for Building
-------------------

Java JDK 1.6

Maven 2.2 or higher (http://maven.apache.org/)



Build
-------------------

$ mvn clean package



Run
-------------------

$ mvn compile exec:java -Dexec.classpathScope=compile -Dexec.mainClass=com.tedwon.cep.esper.EsperQuickStartMainClass