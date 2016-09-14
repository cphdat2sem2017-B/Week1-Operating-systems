![Alt text](../img/lotussm.png)
#Studypoint exercise of week 4 of the 2nd semester
This exercise is meant to be individual, that is, each student should hand in their own solution.
Hand-in instructions at the end of this document.

This studypoint exercise has as its purpose to be able to deploy a web-application on a web-server running in your digitalocean linux server.

To that end, you need three things:

* A web site to be deployed 
* A database for that web site
* A webserver to deploy it on

##Task 1 - ensure you have a web application
While any web application can be used, it is suggested to use the one from the studypoint exercise from last week. If you did not manage to get it to work, you can use the one which is [available as demo solution](../demo/WebShop). 

To make the webshop run on your machine, you need to change the program in such a manner that it uses your own database. This can either be done by setting up the right tables on MySQL on your laptop, and then using localhose as your database, or you can move to task 2 below.

##Task 2 - deploy the database on the linux server
As part of your web site, you should have an SQL script which can be used to set up the tables and insert relevant data into those. Use that sql script to set up the right tables on your MySQL server on your linux machine. You can either do this by connecting to your MySQL server using MySQLWorkbench, or by logging onto your linux server and running the script from the command prompt. Using MySQLWorkbench might be easier, but you will learn more by doing it from the command prompt.

Change the web application to use the database on your linux server. Run the web application from netbeans to see that it works.

##Task 3
Add a database user named "reader" with the password "bookworm#17laesehest" which has select rights to the database you are using.

##Task 4
Follow the instructions in the document [Tomcat On Your Server.pdf](Tomcat On Your Server.pdf) to get the web-server tomcat installed and get the web application deployed.

#Handin instructions
You need to hand in by writing an email to **aflevering2sem@gmail.com** no later than Sunday 18th of September 2016 at 29:59.

The email should contain the following information

* The top of the email should have your name in full.
* There must be a link to your deployed web application
* The database user "reader" with the above mentioned password should be available in the database

If you are not able to finish your exercise you should send an email explaining in detail what caused you to fail to do so. **If you are not able to finish the exercise and you were not present on friday to get help, you will not be granted studypoints.**

