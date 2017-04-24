# Requirements
1. Latest Java
2. MySQL

***

# UserGuide

You can watch the [Demo](http://youtu.be/OL6WtJMRzHc?hd=1) to see how to use the app or follow the steps below.

Once the user has installed Wamp64 and is using the database provided(see [Technology used and why](https://github.com/RobertKiliszewski/JobTracker/wiki/Technology-Used-and-Why)) to get the database running

When presented with the login screen the user needs to input their username and password but since they will most likely be a first time user they will need to Register.

When registering the user is required to put in all the  details that are asked for and choose a unique username in order to sign up as existing usernames are not allowed to be created.

Once the user is created they can then log in and start using the application.

When in the main page of the application the user is asked to  input their Rate (eg.9.25 or 10) and their tax amounts they get deducted which must be written in a decimal format so for example if the user is taxed 10% the number they would use is 1 or if they are taxed 5% they would input .5 so on and so forth along with the week number they want the calculation for (eg. April 24th is week 17) and their hours worked (eg. If the user worked 30 hours and 30 min their input will be 30.5)

They can use the calculator in the bottom of the app in order to get the decimal number for their minutes worked.

After filling out the information required the user can then check their earnings before tax and after tax(after tax saves to the database) and then display their saved weeks using the show earnings button.

If the user wishes to view their daily earnings they can use Count your day earnings page where they are asked to input their hourly rate, the date of the day, the start time(eg.9:30 would be 9.5) finish time and if they had a break(eg. 30 min would be .5) and if they got paid for that break.

After clicking Calculate the user gets the earnings for that day and that is saved to the database where then they can be viewed at any time.

When the user is finished they can close the application and be done or click logout and switch to any user.
