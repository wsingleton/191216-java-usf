package com.revature.quizzard.models;

public enum Category {


    CORE_JAVA(1, "Core Java"), JAVA_THREADS(2, "Java Thread"), JAVA_REFLECTION(3, "Java Reflection"),
    JAVA_COLLECTIONS(4, "Java Collections"), JAVA_STREAMS(5, "Java Streams"), ORACLE_SQL(6, "Oracle SQL"),
    POSTGRE_SQL(7, "PostgreSQL"), ORACLE_PLSQL(8, "Oracle PL/SQL"), POSTGRE_PLPGSQL(9, "PostGre PL/pgSQL"),
    JDBC(10, "JDBC"), HTML(11, "HTML"), CSS(12, "CSS"), CORE_JS(13, "Core JavaScript"),
    JS_DOM_MANIPULATION(14, "JS DOM Manipulation"), AJAX(15, "AJAX"), FETCH_API(16, "Fetch API"), AXIOS(17, "Axios"),
    JAVA_SERVLETS(18, "Java Servlets"), TYPESCRIPT(19, "TypeScript"), NODE_JS(20, "Node.js"),
    ANGULAR(21, "Angular"), REACT(22, "React"), REDUX(23, "Redux"), EXPRESS(24, "Express"), AWS_CLOUD(25, "AWS Cloud"),
    MS_AZURE_CLOUD(26, "MS Azure Cloud"), DEVOPS_PRINCIPLES(27, "DevOps Principles"), JENKINS(28, "Jenkins"),
    CONTAINERIZATION(29, "Containerization"), CONTAINER_ORCHESTRATION(30, "Container Orchestration"),
    HIBERNATE(31, "Hibernate"), CORE_SPRING(32, "Core Spring Framework"), SPRING_BOOT(33, "Spring Boot"),
    SPRING_DATA(34, "Spring Data"), SOA(35, "Service Oriented Architecture"), REST_WS(36, "REST Web Services"),
    SOAP_WS(37, "SOAP Web Services"), MICROSERVICES(38, "Microservice Architecture"),
    MESSAGING_QUEUE(39, "Messaging Queue"), OTHER(40, "Other");

    private Integer id;
    private String name;

    Category(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Category getById(int id) {
        for (Category category : Category.values()) {
            if (category.id == id) {
                return category;
            }
        }
        return Category.OTHER;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return name;
    }

}
