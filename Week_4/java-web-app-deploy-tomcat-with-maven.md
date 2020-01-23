# Deploying a Java Web Application to a Tomcat Web Server With Maven

### Prerequisites:
  - Java 8 JDK installed configured
  - Maven 3 installed and configured
  - Tomcat 9 installed and configured
	
	
### Instructions:
  - Step 1: Edit Tomcat's `tomcat-users.xml` file (found in the `$CATALINA_HOME/conf` directory) to include the following within the `<tomcat-users>` tag:

	```
	<role rolename="manager-gui"/>
	<role rolename="manager-script"/>
	<role rolename="manager-status"/>
	<role rolename="manager-jmx"/>
	<user username="admin" password="revature" roles="manager-gui,manager-script,manager-status,manager-jmx"/>
	<user username="maven-tomcat" password="revature" roles="manager-script"/>
	```


  - Step 2: Edit Maven's `settings.xml` file (found in the `$M2_HOME/conf` directory) to include the following within the `<servers>` tag:

	```
	<server>
	  <id>LocalTomcat</id>
	  <username>maven-tomcat</username>
	  <password>revature</password>
	</server>
	```

  - Step 3: Start the Tomcat Web Server by running the command: `sh $CATALINA_HOME/conf/startup.sh`. Check `https://localhost:8080` for success, you should see the Tomcat landing page.


  - Step 4: Create a Maven Project (no archetype required), configure project to Java 8, and change packaging to WAR


  - Step 5: Add `javax-servlet:javax.servlet-api:4.0.1` as a dependency to the newly created project


  - Step 6: Include the following `<build>` tag and all of its contents within the root `<project>` tag of the `pom.xml`

	```
	<build>
            <pluginManagement>
              <plugins>
                  <plugin>
                      <groupId>org.apache.tomcat.maven</groupId>
                      <artifactId>tomcat7-maven-plugin</artifactId>
                      <version>2.2</version>
                      <configuration>
                          <url>http://localhost:8080/manager/text</url>
                          <server>LocalTomcat</server>
                          <path>/test-app</path>
                      </configuration>
                  </plugin>
              </plugins>
            </pluginManagement>
	</build>
	```


  - Step 7: Create the following directory structure: `./src/main/webapp/WEB-INF`. Within the `webapp` directory include an `index.html` file, and within the `WEB-INF` directory include a `web.xml` file.


  - Step 8: Configure your `web.xml` file to include the following:

	```
	<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
                 xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                 xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee
                 http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd"
                 version="3.1">

            <display-name>Hello, Servlets!</display-name>
            
            <welcome-file-list>
                <welcome-file>index.html</welcome-file>
            </welcome-file-list>

            <servlet>
                <servlet-name>TestServlet</servlet-name>
                <servlet-class>com.revature.servlets.TestServlet</servlet-class>
            </servlet>

            <servlet-mapping>
                <servlet-name>TestServlet</servlet-name>
                <url-pattern>/test</url-pattern>
            </servlet-mapping>

        </web-app>
	```


  - Step 9: Create the `com.revature.servlets` package structure and include a class named `TestServlet` within in it. Configure the servlet to include the following:

	```
        package com.revature.servlets;

        import javax.servlet.ServletException;
        import javax.servlet.http.HttpServlet;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import java.io.IOException;
        
        public class TestServlet extends HttpServlet {
        
            @Override
            protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                resp.getWriter().write("<h1>/test works!</h1>");
            }
            
        }
	```

  - Step 10: Use the command `mvn tomcat7:deploy` to execute the Maven goal to build and deploy the application to the locally running Tomcat Web Server. The application can be managed through the use of other Maven goal commands provided by the `tomcat7-maven-plugin` or through the Tomcat Web App Manager GUI found at `http://localhost:8080/manager/html`.


