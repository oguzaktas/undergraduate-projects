# MySQL-and-JDBC-GUI-Java
This project creates a MySQL database for automobile shopping management system and connects to it through the JDBC API.

This project uses interactive GUIs that is connected to a MySQL database. Users can insert, update, delete or filter and search datas for any tables and any records in all GUIs, and these modifications be done to the underlying database as well. After any modifications are done, the GUIs will be updated to reflect the changes in the database. GUI classes was created using NetBeans and IntelliJ IDEA.

## Requirements

This program requires Java, MySQL, and JDBC API. I used Java 8 (with JDK 8u172) and MySQL Community Server 5.7.22 (including MySQL Server and MySQL Workbench) to create this project. Connector/J (Default JDBC driver of NetBeans IDE already including MySQL Connector/J 5.1.23 version) is also needed for Java to work with MySQL. Also I used JCalendar library for date type inputs in IlanWindow GUI.

## Instructions

After everything has been installed you will need to create the database. Start MySQL in Terminal or on MySQL Workbench, and use `create-db-tables.sql` file to create a database called `arac_alisveris` and tables are needed for this database. You can then use the database with `USE arac_alisveris;`. After the database is in use, you can create records for all tables by running the `insert-records.sql` file. The database, tables and all records should be created, and the data should now be present in the database. You can use `SELECT * FROM Tbl_Ilan;` to verify.

To run the Java program, you will need to edit ```conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/arac_alisveris", "root", "123456");``` part in `getConnection()` methods in all GUI classes except `MainWindow.java` so they match your MySQL database name, username and password. If this is not done, then the program will not be able to connect to MySQL. After these steps have been done, you can compile and run the Java code. When the program begins, you should see a Main GUI with the menu, then choose a table and database records will displayed. You can insert, delete, and update records with table GUIs (IlanWindow, ArabaWindow, YakitTuruWindow, VitesTuruWindow, RenkWindow, SehirWindow), filter and search with FiltrelemeWindow GUI. Running this program using NetBeans IDE 8.2 or JetBrains IntelliJ IDEA is highly recommended.

## Demonstration

The MainWindow GUI is displayed when the program begins. Then choose a table GUI, for example ArabaWindow GUI. Notice that when the user clicks on a row, the text fields and comboboxes are updated.

<img width="660" src="https://user-images.githubusercontent.com/29024000/40292900-abf2982e-5cd6-11e8-8971-c8145d976584.png">

This data in the GUI matches the data in the MySQL database.

<img width="597" src="https://user-images.githubusercontent.com/29024000/40292899-abd1f0ba-5cd6-11e8-9804-657d4eaa212d.png">

We will now insert a record. We fill in the text fields (if ID field don't filled it's auto setted through auto increment option of database) and click "Insert". You can see that the new record has been added to the bottom of the table, and the database reflects the changes.

<img width="660" src="https://user-images.githubusercontent.com/29024000/40292901-ac14a6bc-5cd6-11e8-84cf-fbad3c846c58.png">

<img width="597" src="https://user-images.githubusercontent.com/29024000/40292902-ac37bdd2-5cd6-11e8-9ace-8693a378ec8c.png">

We can update a row in the table by clicking on the row in the table, modifying the text field(s), and clicking update.

We can delete a row by clicking on the row in the table (or fill ID text field) and clicking "Delete" button.

Finally, we can use FiltrelemeWindow GUI to filter and search all tables for needed attribute and order with ascending and descending options.

<img width="680" src="https://user-images.githubusercontent.com/29024000/40292898-ab43b7dc-5cd6-11e8-8ff2-4661b00135e1.png">

## Contributors
Oğuz Aktaş
