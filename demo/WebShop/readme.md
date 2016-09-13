This solution is good in the following ways:

* There are domain model object which correspond to the tables in the database
* The jsp pages do not access the database directly
*

There are a number of things in this solution which could and should be improved.
Mentioned, but in no particular order:

* The solution should use POST actions, not GET for logging-in.
* The password should not show in plain text
* The user object should not keep the password around
* The layout and use of CSS can be nothing but improved (it is really bad)
* Invoice seems not to be stored properly
* The SQL update elements should use prepared statements, not string concatenation.


