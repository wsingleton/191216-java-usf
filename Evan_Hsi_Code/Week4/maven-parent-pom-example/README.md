# Maven Parent POM
---

Remember that a Project Object Model (POM) is the fundamental unit of work in Maven. It is an XML file that contains information about the project and configuration details used by Maven to build the project. In order to avoid duplicating common configuration we can create a base POM which can be inherited by other POMs.

This directory contains a base POM which we can include for our future Maven projects. Within the terminal of your choice, navigate to this directory and execute the following command:

`mvn install:install-file -Dfile=./pom.xml -DgroupId=com.revature -DartifactId=reva-pom -Dversion=1.0.0 -Dpackaging=pom`

This command will install the POM file in this directory to your local M2 repository (`~/.m2/repository/com/revature/reva-pom/1.0.0/reva-pom.xml`). Once this is complete, you will be able to inherit the configuration of this POM in any project you create on this machine, by including the following XML inside of your project's POM file:

```
<parent>
        <groupId>com.revature</groupId>
        <artifactId>reva-pom</artifactId>
	<version>1.0.0</version>
</parent>
```
