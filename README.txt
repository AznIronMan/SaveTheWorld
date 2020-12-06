=================---====================
SAVE THE WORLD by ClarkTribeGames
VERSION ALPHA v0.0.007 / 2020.12.05-2238
==============---=======================

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

HOW TO ADD CUSTOM CATEGORIES (TO BE REPLACED WITH FILE MENU OPTION)

Create a new text file with the title of the Category in the first line.  Every line
after that will be considered a possible phrase for the game.

Name the text file one of the following names:  

Category1.txt, Category2.txt, Category3.txt

Depending on the filename chosen, this will override the default category.

=========================

SCORING (NOT ACCURATE ANYMORE..)

The Current Score is calculated based on the current session of games played.

To continue a session after a game is over, click START OVER to reset while
retaining your Current Score.

For each game won, the Score will increase by 1 point.  For each game lost, the
Score decreases by 1 point.

The High Score is the highest score obtained in one session.  This is retained
through an external file HighScore.dat with the game files.

(ACCURATE VERSION: Win score = 5 - missedcount / Lose Score = missedcount * -1)

=========================

ABOUT THIS APPLICATION

The original concept of this application was originally built for the Charleston 
Southern University class CSCI 325 by Professor Julie Henderson.

This game was a revamp of the code built by Geoff Clark was rebuilt as a new
game.  There was a revamp of all the code including dozens of additions for this 
free release version.  (IN PROGRESS)

The game is now under development through ClarkTribeGames as of 2020.12.01.

Copy of this code without the content of the Author is prohibited.

Contact the author:  info@clarktribegames.com

====================================

RELEASE NOTES

FINAL ALPHA v0.0.007 / 2020.12.05-2238

- removed custom settings, not needed
- customized the miss count graphics and added new game over art
- added new globe icon to windows and .exe
- fixed update URL going nowhere -- corrected
- preparing for beta release

ALPHA v0.0.006 / 2020.12.04-2351

- added menu options for both the start and game guis
- added settings, change category, import custom file in menus
- activated all other (except settings) menu options
- added in quit early penalty if trying to start over or during game
- added change category feature for imported categories
- cleaned up a few comestic ideas around buttons
- disabled import/change category during active games
- added penalty if improper quit occurs during a game
- added check to confirm penalty for specific user for improper quit
- added check if last category was custom and no longer exists, switch default
- added import warning notice when trying to import from menu
- adjusted spacing for hidden and revealed letters to make it easier to read
- added ability to delete players
- added various checked for file integrity

ALPHA v0.0.005 / 2020.12.03-1358

- add player name passthrough to game gui
- updated high score process
- updated scoring process
- changed scoring for wins and losses to be based on the remaining missed count
- set built in quotes as default
- restructured game gui for optimization
- optimized last used player and scoring methods
- added lib check and support
- added import category file selection (txt only)
- added check if import attempt already exist to cancel

ALPHA v0.0.004 / 2020.12.02-2311

- major updates to the new Main Menu GUI
- over 150 different randomized greetings
- added customizable player name known as "heroes"
- added default "earthling" name if any duplicates or errors in input for names
- redid scoring maintenances
- added high score board -- known as the heroes of fame
- added players list to retain players that have played
- added last player played so the game remembers who you are and the last score you had
- score is retained even when the application is closed now (lifetime score)
- added over 72k quotes from a free quotes database as default phrases
- quotes will be embedded into the releases
- added ability to switch players and add new players from main menu

ALPHA v0.0.003 / 2020.12.02-0106

- rebranded under ClarkTribeGames
- created new main menu
- imported bundled methods for ClarkTribeGame standards
- created greeting box with custom greeting variable
- created last used data holder and the game pulls from that to greet the player
- new score file
- new high score file - renamed heroes of fame
- created buttons for new game (save the world), change hero (change player), heroes of fame (high scores), about, donate, and exit
- made about, donate, and exit fully functional
- put old gui as place holder for new game
- exit button asks if you want to exit
- added file check/dir check and build if not existing
- moved score resetter
- added version checker and update redirect if not current
- added logging with log files for troubleshooting
- added variable based naming for windows and various other features for portablity
- skeleton for file menu options added

ALPHA v0.0.002 / 2020.11.15.2218

-implemented category drop down that finds txt files to generate phrase files from
-removed hard coded 3 categories and buttons
-change score files to be hidden from user
-added exception logging feature
-updated placeholder graphics to a new globe
-phrase is now revealed if the user loses (added reveal phrase process)
-removed used draw for miss count 5.
-updated some wording to reflect new narrative of saving the world.

ALPHA v0.0.001 / 2020.11.15.1630

- initial baseline commit
- converted from og code to be rewritten for commercial release
- changed to "Save The World"
- placeholder images put in place
- placeholder database put in place

====================================

REMAINING ITEMS TO DO BEFORE BETA

// update readme
// set to beta
// add publisher info
// wrap file
// sourceforge
