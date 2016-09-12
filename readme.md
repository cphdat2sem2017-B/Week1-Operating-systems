![Alt text](img/lotussm.png)
# 4th week of the 2nd semester
Topics: Operatingsystems & Linux, Webserver og MySQL in the cloud

##Day 1: Linux in the cloud
We will look at how to set up a linux server on digitalocean, how to manage users on the machine, and how to navigate the server from the command prompt.

* [Powerpoint slides](slides/Day_1.pdf)
* [Exercises](week-4-Operating-systems/study/day1exercises.md)

Readings:

* <http://ryanstutorials.net/linuxtutorial/commandline.php>
* <http://ryanstutorials.net/linuxtutorial/cheatsheet.php>
* Nano: <http://www.howtogeek.com/howto/42980/the-beginners-guide-to-nano-the-linux-command-line-text-editor>
* Nano: <http://www.tutorialspoint.com/unix_commands/nano.htm>


##Day 2: SSH & bash scripting
Using passwords to secure a server is considered insecure. Instead one use ssh-keys.
Also, we will take a look at bash-scripting to automate things on linux. In particular we will automate setting up a linux server with users for your group.

* [Powerpoint slides](url)
* [Exercises](url)

Readings:

* Scripting: <http://ryanstutorials.net/linuxtutorial/scripting.php>
* Bash on Lynda.com: <https://www.lynda.com/Bash-tutorials/Up-Running-Bash-Scripting/142989-2.html>
* SSH on Lynda.com: <https://www.lynda.com/Developer-Network-Administration-tutorials/Welcome/189066/365610-4.html>
* SSH: <https://www.youtube.com/watch?v=svRWcx7dT8g>
* SSH: http://blakesmith.me/2010/02/08/understanding-public-key-private-key-concepts.html
* SSH & connecting to ubuntu: <https://www.digitalocean.com/community/tutorials/understanding-the-ssh-encryption-and-connection-process>

##Day 3: MySQL in the cloud
We will setup MySQL on the ubunto server, set up users on MySQL with different rights, and work with SQL from the sql prompt. Also, we will connect to the server from MySQLWorkbench and from Java.

* [Exercises](url)

Readings:

* Installing MySQL: <https://www.digitalocean.com/community/tutorials/how-to-install-mysql-on-ubuntu-14-04>

##Day 4: Setting up tomcat, deploying your webpages
We will get tomcat up in the cloud, and show how to deploy (by hand) the war files you created last week.

##Day 5: SP assignment - copy databases using Java
Later in the semester we will look at testing. One of the important things in testing using databases is to write tests where one know the state of the database, and also to make sure the tests do not damage important user data. Hence there is a need for *test databases*. This studypoint assignment is about writing a java program which can copy two tables from one database to an other to allow us to have a copy of a database which we can manipulate from java to test if our programs work correctly.

* [Full assignment](url)

