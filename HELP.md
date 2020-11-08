# Munro Library Challenge

    A CSV file containing information about munros and munro tops within Scotland. The goal of this solution is to create 
    a simple API which other software can use to sort and filter the munro data. The solution is developed using Java. 
    I used Spring boot framework to create the Restful endpoint.

##The API provides the following functionality and example end points:
    ● Filtering of search by hill category (i.e. Munro, Munro Top or either). If this information is not provided by the 
    user it should default to either. This should use the “post 1997” column and if it is blank the hill should be always 
    excluded from results.
        e.g: http://localhost:8091/api/munro?year1891=MUN
             http://localhost:8091/api/munro?year1891=TOP
             http://localhost:8091/api/munro?year1891
             http://localhost:8091/api/munro?year1921=TOP
             http://localhost:8091/api/munro?year1921
             http://localhost:8091/api/munro?year1933=TOP
             http://localhost:8091/api/munro?year1933 
        
    ● The ability to sort the results by height in meters and alphabetically by name. For both options it should be 
    possibly to specify if this should be done in ascending or descending order.
        e.g: http://localhost:8091/api/munro?sort=heightInMeter,desc
            http://localhost:8091/api/munro?sort=heightInFeet,asc
            http://localhost:8091/api/munro?sort=munroName,desc
            http://localhost:8091/api/munro?sort=munroName,asc
    ● The ability to limit the total number of results returned, e.g. only show the top 10
        Used JPA Pageable to return limit the total number of record.
        e.g http://localhost:8091/api/munro?heightInMeterMin=500.00
        set Page-Size and Page-Number in HttpHeader.
    ● The ability to specify a minimum height in meters
        e.g http://localhost:8091/api/munro?heightInMeterMin=500.00
    ● The ability to specify a maximum height in meters
        e.g http://localhost:8091/api/munro?heightInMeterMax=1000.00
    ● Queries may include any combination of the above features and none are mandatory.
        e.g http://localhost:8091/api/munro?heightInMeterMax=1000.00&sort=heightInMeter,asc
    ● Suitable error responses for invalid queries (e.g. when the max height is less than the minimum height)

## Pre-Requisite Software:
    * Apache Maven
    * JDK 8
    * Java Developement IDE (Intelij, Eclipse)
    * Postman or SoapUI for Request and Response testing.
---

## Important commands
    * Run the test: case mvn clean test
    Copy the JAR in local machine and execute the below command from command prompt or terminal.
    * Start Spring boot application: java -jar munro.library-0.0.1-SNAPSHOT.jar
---

## In Memory database used H2Database.
    * On startup Loading the provided munro data into TBL_MUNRO tables. 
    * Copied provided CSV file into resource folder.
    * Script to load data into in memory data base is schema.sql
---

## Reporting with code coverage
    * Run below command to generate reporting:
    e.g: /Users/atulkumar/workspace/assessment> mvn cobertura:cobertura
    * You can find report inside target folder under jaococo-ut folder (index.html).
    * Used Spock testing framework for integration testing.
    * Junit and Mockito framework for unit testing.
    * Configured code coverage 80% which is defined into pom.xml

## Future Enhancement
    * Include Swagger for API documentation
    * More scenario and test coverage.
    * Suitable error response for invalid query.
---

### Reference
    Used third party library:
    * net.kaczmarzyk's specification-arg-resolver library
    * com.h2database's h2 database library



