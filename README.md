# Retail_DB_CoreJava
This Project created on Cloudera 5.4.2 VM. It used the MySQL Database. retail_dba is the DataBase name.
JDBC,Collections,Exceptions,MultiThreading,Concurrency etc conecpts are tried to impliment in this project.

Data retrieval:-
Retail_DB_CoreJava/src/mySql/dBStage/exeQuery.java  -->JDBC Connection stage
Retail_DB_CoreJava/src/retail/tables/objects/                  -->All table objects
Retail_DB_CoreJava/src/staging/Stage_Tables.java           -->Stage all tables into files using Object Serialization and Multithreading concepts.
Analytics Pattern using Java Collections and Concurrency:-
Retail_DB_CoreJava/src/pattern/summarization/MaxPricedProduct.java    -->Highest priced Product
Retail_DB_CoreJava/src/pattern/summarization/OdersPerDay.java              -->Order Per Day
Retail_DB_CoreJava/src/pattern/join/SalesPerDay.java                                    --> Sales Per Day. Used join between two stages in java layer.

Retail_DB_CoreJava/src/pattern/join/SalesPerDayUsingThread_Callable.java --->Sales Per Day. Used join between two stages in java layer and Java Concurrency
Retail_DB_CoreJava/src/pattern/filtering/TopTenProductsSoldPerMonth.java--->Top Ten Products sold on a particular month. Used join between two stages in java layer and Java Concurrency.


References:-
http://www.javatpoint.com/
http://www.tutorialspoint.com
http://stackoverflow.com/
http://www.javapractices.com/topic/TopicAction.do?Id=65
https://blogs.oracle.com/CoreJavaTechTips/entry/get_netbeans_6
http://www.java2novice.com/java-collections-and-util/hashmap/find-object/

MapReduce Design Pattern book
