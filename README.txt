=====================================
SAVE THE WORLD by Geoff Clark
VERSION ALPHA 0.0.2 / 2020.11.15.2218
=====================================

This program was written with JDK 1.8.  It does require a minimum of JRE 52 to run.

Java can be downloaded from:  https://www.java.com/en/

====================================

RULES

(Placeholder for now -- traditional "hangman" rules, five turns).

=========================

THE HINT BUTTON

The Hint button can only be used if you have at least two guesses left on the
Hangman.  (If you only have one guess left, the Hint button is not available.)

The Hint will give you a "free" correct letter in exchange for a "miss turn".
The correct letter is guaranteed.  (more detail needed).

=========================

DEFAULT CATEGORIES

Placeholder data for alpha testing.

=========================

HOW TO ADD CUSTOM CATEGORIES

Create a new text file with the title of the Category in the first line.  Every line
after that will be considered a possible phrase for the game.

Name the text file one of the following names:  

Category1.txt, Category2.txt, Category3.txt

Depending on the filename chosen, this will override the default category.

=========================

SCORING

The Current Score is calculated based on the current session of games played.

To continue a session after a game is over, click START OVER to reset while
retaining your Current Score.

For each game won, the Score will increase by 1 point.  For each game lost, the
Score decreases by 1 point.

The High Score is the highest score obtained in one session.  This is retained
through an external file HighScore.dat with the game files.

=========================

ABOUT THIS APPLICATION

The original concept of this application was originally built for the Charleston 
Southern University class CSCI 325 by Professor Julie Henderson.

This game was a revamp of the code built by Geoff Clark was rebuilt as a new
game.  There was a revamp of all the code including dozens of additions for this 
free release version.  (IN PROGRESS)

Copy of this code without the content of the Author is prohibited.

Contact the author:  gclark82@gmail.com

====================================

RELEASE NOTES

alpha v0.0.2 / 2020.11.15.2218

-implemented category drop down that finds txt files to generate phrase files from
-removed hard coded 3 categories and buttons
-change score files to be hidden from user
-added exception logging feature
-updated placeholder graphics to a new globe
-phrase is now revealed if the user loses (added reveal phrase process)
-removed used draw for miss count 5.
-updated some wording to reflect new narrative of saving the world.

alpha v0.0.1 / 2020.11.15.1630

- initial baseline commit
- converted from og code to be rewritten for commercial release
- changed to "Save The World"
- placeholder images put in place
- placeholder database put in place

====================================