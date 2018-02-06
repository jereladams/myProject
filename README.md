# Jerel Adams Individual Project

Automobile Maintenance Archive.

### Problem Statement

The average age of a light vehicle in the United States is estimated at around 11.6 years in 2016. In light of an aging vehicle fleet and increasing shop rates ($80-$125 /hr.) many car owners have turned into do-it-yourself (DIY) shade tree mechanics.

While maintaining your own vehicle helps save money, it also creates a disconnect between the auto manufacturer and the consumer. Since owners are making fewer visits to the shop or dealership for repairs, there is less information available about your car's history. Even those repairs done by a mechanic can be overlooked, since each shop has it's own system for tracking repairs and this information is not shared with manufacturers or other shops.

I would like to create an Automobile Maintenance Archive website to serve as repository for those looking to track repairs, parts, warranties and recall history for their vehicles.


Save below for template.....

Screenshots from Automobile Maintenance Archive:

![Example Description](images/Example.png)

![Example Report](images/Example.png)


### Project Technologies/Techniques

* Security/Authentication - tba
  * Tomcat's JDBC Realm Authentication
  * Admin role: create/read/update/delete (crud) of all data
  * User role: save vehicle repairs, parts list and warranties, edit data they have entered previously
  * All: anyone can view their vehicle info and recall notices (no login)
* Database
  * MySQL
  * Store users and roles
  * Store all data for the repairs,parts list warranties.
* ORM Framework
  * Hibernate 5
* Dependency Management
  * Maven
* Web Services consumed using Java
  * https://vpic.nhtsa.dot.gov/api/ to decode VIN
  * https://one.nhtsa.gov/webapi/Default.aspx?Recalls/API/83 to lookup recalls
* CSS
  * Bootstrap
* Data Validation
  * Bootstrap Validator for front end
  * Explore Hibernate's validation
* Logging
  * Configurable logging using Log4J2. In production, only errors will normally be logged, but logging at a debug level can be turned on to facilitate trouble-shooting.
* Hosting
  * AWS
* Independent Research Topic/s
  * CI tools in AWS
  * Hibernate Validation
  * Hibernat Search
* Project Lombok to eliminate boilerplate code like getters/setters/equals
* Unit Testing
  * JUnit tests to achieve 80%+ code coverage
* IDE: IntelliJ IDEA


### Design

* [Screen Design](DesignDocuments/Screens.md)
* [Application Flow](DesignDocuments/applicationFlow.md)
* [Database Design](DesignDocuments/databaseDiagram.png)

### [Project Plan](ProjectPlan.md)

### [Development TimeLog](TimeLog.md)