package clarktribegames;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

// <editor-fold defaultstate="collapsed" desc="credits">
/**
 * 
 * @author  Geoff Clark
 * @e-mail  info@clarktribegames.com
 * @game    Save The World
 * 
 */
// </editor-fold>

public class GameGUI extends javax.swing.JFrame {
    
    String appTitle;
    String appPackage;
    String defaultName = "Earthling";
    String playerName;
    String dataDir = "data";
    String dataPath = "./" + dataDir + "/";
    String ogcatPath = dataDir + "/quotes.dat";
    String catPath = dataDir + "/quotes.dat";
    String highPath = dataDir + "/High.dat";
    String lastusedPath = dataDir + "/.lastused";
    String lastcatPath = dataDir + "/.lastcat";
    String playersPath = dataDir + "/Players.dat";
    String miscLib = dataDir + "/misc.lib";
    String customDir = "phrases/";
    String customExt = ".phrases";
    String firststartText = "<html><center>Click START to begin a NEW GAME.<br>"
            + "<br>Click on RULES to learn how to play.</center></html>";
    String newgameText = "<html><center>Click START OVER to begin a NEW GAME.<b"
            + "r><br>Click on MAIN MENU to EXIT.</center></html>";
    int missCount = 0;
    int correctCount = 0;
    char guess;
    int count = 0;
    char lowercaseGuess;
    String incorrectGuesses = "";
    String correctGuesses = "";
    String lowercaseString = "";
    int guessesReq = 0;
    String pickedPhrase = "";
    boolean isitHint = false;
    URL iconURL = getClass().getResource("/clarktribegames/title.png");
    ImageIcon imageIcon = new ImageIcon(iconURL);
    
    public GameGUI() throws IOException, Exception {
        this.appTitle = new StartGUI().getTitle();
        this.appPackage = new StartGUI().packagename;
        initComponents();
        setLocationRelativeTo(null);
        yourphaseText.setText("");
        customCheck(true);
        introLook();
    }
    
    // <editor-fold defaultstate="collapsed" desc="Intro + Show/Hide Methods">
    private void introLook() throws IOException, InterruptedException {
        introText();
        hideAlpha();
        getFields();
        spotCheck(playerName);
        newButton.setEnabled(true);
    }
    
    private void introText() {
        gameBox.setIcon(new javax.swing.ImageIcon(getClass().
                getResource("/" +  appPackage + "/title.png")));
        bottomText.setText(firststartText);
    }
    
    private void getFields() throws IOException {
        processFields(highPath,1,hscoreBox);
        processFields(lastusedPath,0,playerBox);
        playerName = playerBox.getText();
        processFields(lastusedPath,1,cscoreBox);
        getCat();
    }
    
    private void getCat() {
        if(catPath.equals(ogcatPath)) {
            catBox.setText("Famous Quotes");
        } else {
            catBox.setText(processcatName(catPath));
        }
    }
    
    private String processcatName(String filepath) {
        String[] filenamearray;
        if(filepath.contains("/")) {
            filenamearray = filepath.split("\\/",0);
            filepath = filenamearray[filenamearray.length - 1];
        }
        if(filepath.contains("\\")) {
            filenamearray = filepath.split("\\\\",0);
            filepath = filenamearray[filenamearray.length - 1];
        }
        if(filepath.contains(".")) {
            filenamearray = filepath.split("\\.",0);
            filepath = filenamearray[filenamearray.length - 2];
        }
        return (new Converters().capFirstLetter(filepath));
    }
    
    private void processFields(String filePath,int playerorScore,JTextField box)
            throws IOException {
        try {
            File filename = new File (filePath);
            String string = (new ChecksBalances().getLast(filename));
            String player = string.substring(0,string.indexOf(','));
            String score = string.substring(string.indexOf(',') + 1,string
                    .length());
            if(playerorScore == 1) {
                box.setText(score);
            } else {
                box.setText(player);
            }
        } catch (IOException ex) {
            logFile("severe","Process Fields Error.  Ex: " + ex);
        }
    }
    
    private void hideAlpha() {
        usedA.setSelected(true);
        usedB.setSelected(true);
        usedC.setSelected(true);
        usedD.setSelected(true);
        usedE.setSelected(true);
        usedF.setSelected(true);
        usedG.setSelected(true);
        usedH.setSelected(true);
        usedI.setSelected(true);
        usedJ.setSelected(true);
        usedK.setSelected(true);
        usedL.setSelected(true);
        usedM.setSelected(true);
        usedN.setSelected(true);
        usedO.setSelected(true);
        usedP.setSelected(true);
        usedQ.setSelected(true);
        usedR.setSelected(true);
        usedS.setSelected(true);
        usedT.setSelected(true);
        usedU.setSelected(true);
        usedV.setSelected(true);
        usedW.setSelected(true);
        usedX.setSelected(true);
        usedY.setSelected(true);
        usedZ.setSelected(true);
        usedA.setEnabled(false);
        usedB.setEnabled(false);
        usedC.setEnabled(false);
        usedD.setEnabled(false);
        usedE.setEnabled(false);
        usedF.setEnabled(false);
        usedG.setEnabled(false);
        usedH.setEnabled(false);
        usedI.setEnabled(false);
        usedJ.setEnabled(false);
        usedK.setEnabled(false);
        usedL.setEnabled(false);
        usedM.setEnabled(false);
        usedN.setEnabled(false);
        usedO.setEnabled(false);
        usedP.setEnabled(false);
        usedQ.setEnabled(false);
        usedR.setEnabled(false);
        usedS.setEnabled(false);
        usedT.setEnabled(false);
        usedU.setEnabled(false);
        usedV.setEnabled(false);
        usedW.setEnabled(false);
        usedX.setEnabled(false);
        usedY.setEnabled(false);
        usedZ.setEnabled(false);
        hintButton.setEnabled(false);                
    }
    
    private void showAlpha() {
        usedA.setSelected(false);
        usedB.setSelected(false);
        usedC.setSelected(false);
        usedD.setSelected(false);
        usedE.setSelected(false);
        usedF.setSelected(false);
        usedG.setSelected(false);
        usedH.setSelected(false);
        usedI.setSelected(false);
        usedJ.setSelected(false);
        usedK.setSelected(false);
        usedL.setSelected(false);
        usedM.setSelected(false);
        usedN.setSelected(false);
        usedO.setSelected(false);
        usedP.setSelected(false);
        usedQ.setSelected(false);
        usedR.setSelected(false);
        usedS.setSelected(false);
        usedT.setSelected(false);
        usedU.setSelected(false);
        usedV.setSelected(false);
        usedW.setSelected(false);
        usedX.setSelected(false);
        usedY.setSelected(false);
        usedZ.setSelected(false);
        usedA.setEnabled(true);
        usedB.setEnabled(true);
        usedC.setEnabled(true);
        usedD.setEnabled(true);
        usedE.setEnabled(true);
        usedF.setEnabled(true);
        usedG.setEnabled(true);
        usedH.setEnabled(true);
        usedI.setEnabled(true);
        usedJ.setEnabled(true);
        usedK.setEnabled(true);
        usedL.setEnabled(true);
        usedM.setEnabled(true);
        usedN.setEnabled(true);
        usedO.setEnabled(true);
        usedP.setEnabled(true);
        usedQ.setEnabled(true);
        usedR.setEnabled(true);
        usedS.setEnabled(true);
        usedT.setEnabled(true);
        usedU.setEnabled(true);
        usedV.setEnabled(true);
        usedW.setEnabled(true);
        usedX.setEnabled(true);
        usedY.setEnabled(true);
        usedZ.setEnabled(true);
        hintButton.setEnabled(true);   
        newButton.setEnabled(true);
    }

    private void disableAlpha() {
        usedA.setFocusable(false);
        usedB.setFocusable(false);
        usedC.setFocusable(false);
        usedD.setFocusable(false);
        usedE.setFocusable(false);
        usedF.setFocusable(false);
        usedG.setFocusable(false);
        usedH.setFocusable(false);
        usedI.setFocusable(false);
        usedJ.setFocusable(false);
        usedK.setFocusable(false);
        usedL.setFocusable(false);
        usedM.setFocusable(false);
        usedN.setFocusable(false);
        usedO.setFocusable(false);
        usedP.setFocusable(false);
        usedQ.setFocusable(false);
        usedR.setFocusable(false);
        usedS.setFocusable(false);
        usedT.setFocusable(false);
        usedU.setFocusable(false);
        usedV.setFocusable(false);
        usedW.setFocusable(false);
        usedX.setFocusable(false);
        usedY.setFocusable(false);
        usedZ.setFocusable(false);
        usedA.setEnabled(false);
        usedB.setEnabled(false);
        usedC.setEnabled(false);
        usedD.setEnabled(false);
        usedE.setEnabled(false);
        usedF.setEnabled(false);
        usedG.setEnabled(false);
        usedH.setEnabled(false);
        usedI.setEnabled(false);
        usedJ.setEnabled(false);
        usedK.setEnabled(false);
        usedL.setEnabled(false);
        usedM.setEnabled(false);
        usedN.setEnabled(false);
        usedO.setEnabled(false);
        usedP.setEnabled(false);
        usedQ.setEnabled(false);
        usedR.setEnabled(false);
        usedS.setEnabled(false);
        usedT.setEnabled(false);
        usedU.setEnabled(false);
        usedV.setEnabled(false);
        usedW.setEnabled(false);
        usedX.setEnabled(false);
        usedY.setEnabled(false);
        usedZ.setEnabled(false);
        hintButton.setEnabled(false);                
    }
    //</editor-fold>
   
    private void scoreChange(int change) {
        int score = Integer.parseInt(cscoreBox.getText());
        int newScore = score + change;
        cscoreBox.setText(String.valueOf(newScore));
        checkHigh();
    }
    
    private void checkHigh() {
        int high = Integer.parseInt(hscoreBox.getText());
        int score = Integer.parseInt(cscoreBox.getText());
        if(score > high){
            hscoreBox.setText(cscoreBox.getText());
        }
    }
    
    private void saveHigh() throws IOException, InterruptedException {
        try {
            File highfile = new File(highPath);
            int newhigh = Integer.parseInt(hscoreBox.getText());
            String string = (new ChecksBalances().getLast(highfile));
            String score = string.substring(string.indexOf(',') + 1,string.
                    length());
            int oldhigh = Integer.parseInt(score);
            if(newhigh > oldhigh){
                System.gc();
                String newhighscore = String.valueOf(newhigh);
                ChecksBalances.ifexistDelete(highPath);
                String finalstring = playerBox.getText() +","+newhighscore;
                System.gc();
                new ChecksBalances().newfileCheck(highPath,true,finalstring,
                        true);
            }
            } catch (IOException | NumberFormatException ex) {
                logFile("severe","Save High Score Error.  Ex: " +ex.toString());
        }
    }

    private void saveScore() throws IOException, InterruptedException {
        try {
            System.gc();
            String finalstring = playerBox.getText() +","+ cscoreBox.getText();
            ChecksBalances.ifexistDelete(lastusedPath);
            new ChecksBalances().newfileCheck(lastusedPath, true, finalstring,
                    true);
            String s1 = updateLine(new Converters().filelistToList
                ("./" + playersPath,"\n"),playerBox.getText());
            String s2 = s1 + ", " + finalstring;
            String newplayerslist = (s2.replaceAll(", ", "\n"));
            System.gc();
            ChecksBalances.ifexistDelete(playersPath);
            new ChecksBalances().newfileCheck(playersPath,true,newplayerslist,
                    true);
            } catch (IOException | InterruptedException ex) {
                logFile("severe","Save Score Error.  Ex: " +ex.toString());
            }
        }
    
    private String updateLine(List<String> list,String search) {
            List<String> result = new ArrayList<>();
            for (String s : list) {
                if (!s.contains(search)) {
                    result.add(s);
                }
            }
            String finalString = (result.toString());
            return (finalString.substring(1,finalString.length() -1));
        }

    private String getPhrase(String fileName) throws FileNotFoundException, 
            IOException {
        try {
            FileReader fileRead = new FileReader(fileName);
            Random rand = new Random();
            int randPick = rand.nextInt((fileRead.getLineCount()));
            if (randPick < 0) {
                randPick = 1;
            }
            pickedPhrase = Files.readAllLines(Paths.get(fileName)).
                    get(randPick);
        } catch (IOException ex) {
            logFile("severe","Get Phrase Error.  Ex: " +ex.toString());
        }
        return pickedPhrase;   
    }
    
    private void startButton() throws IOException, InterruptedException {
        yourphaseText.setText("Your Phrase is . . .");
        bottomText.setText(newgameText);
        newButton.setText("Start Over");
        newButton.setEnabled(false);
        try {
            startGame(getPhrase(catPath));
        } catch (IOException | InterruptedException ex) {
            logFile("severe","Start Button Error.  Ex: " + ex.toString());
        }
    }
    
    private void startGame(String phrase) throws InterruptedException {
        showAlpha();
        gameBox.setIcon(new javax.swing.ImageIcon(getClass().
                getResource("/" +  appPackage + "/miss0.png")));
        newButton.setEnabled(true);
        refreshPhrase(phrase,correctGuesses);
    }
    
    private void guessingGame(char guess) throws InterruptedException, 
            IOException, Exception {
        refreshPhrase(pickedPhrase,correctGuesses);
        lowercaseString = (pickedPhrase).toLowerCase();
        changeWorld(missCount);
        String lowercaseGuess = "";
        lowercaseGuess = (String.valueOf(guess)).toLowerCase();
        if (isitHint == true) {
            correctGuesses += lowercaseGuess;
            ++correctCount;
            ++missCount;
            changeWorld(missCount);
            isitHint = false;
            } else {
            if (!lowercaseString.contains(lowercaseGuess)) {
                    if (!incorrectGuesses.contains(lowercaseGuess)) {
                        incorrectGuesses += lowercaseGuess;
                        ++missCount;
                    }
            }
                else {
                    if (!correctGuesses.contains(lowercaseGuess)) {
                        correctGuesses += lowercaseGuess;
                        ++correctCount;
                    }
            }
            changeWorld(missCount);
            }
            guessesReq = uniqueLetterCount(pickedPhrase);
            if (correctCount == guessesReq) {
		changeWorld(missCount);
		postGame(true);
            }
            refreshPhrase(pickedPhrase, correctGuesses);
            if (missCount == 5) {
		changeWorld(5);
                postGame(false);
            }
    }
    
    private void refreshPhrase(String phrase, String guesses) {
        String puzzledPhrase = phraseBlanks(phrase, guesses);
        phraseWindow.setText("\n" + puzzledPhrase);
    }

    private int uniqueLetterCount(final String text) {
	String uniqueString = "";
	char ch;
	for (int index = 0; index < text.length(); ++index) 
	{
		ch = Character.toLowerCase(text.charAt(index));
		String chString = Character.toString(ch);
		if (!uniqueString.contains(chString) && Character.isLetter(ch)) 
		{
			uniqueString += ch;
		}
	}
	return uniqueString.length();
	}
    
    private void changeWorld(int countMissed) throws InterruptedException {
        String step = String.valueOf(countMissed);
        if(step.equals("0")) {
            gameBox.setIcon(new javax.swing.ImageIcon(getClass().
            getResource("/" +  appPackage + "/miss0.png")));
        }
        if(step.equals("1")) {
            gameBox.setIcon(new javax.swing.ImageIcon(getClass().
            getResource("/" +  appPackage + "/miss1.png")));
        }
        if(step.equals("2")) {
            gameBox.setIcon(new javax.swing.ImageIcon(getClass().
            getResource("/" +  appPackage + "/miss2.png")));
        }
        if(step.equals("3")) {
            gameBox.setIcon(new javax.swing.ImageIcon(getClass().
            getResource("/" +  appPackage + "/miss3.png")));
        }
        if(step.equals("4")) {
            gameBox.setIcon(new javax.swing.ImageIcon(getClass().
            getResource("/" +  appPackage + "/miss4.png")));
            hintButton.setSelected(true);
            hintButton.setEnabled(false);
        }
        if(step.equals("5")) {
            gameBox.setIcon(new javax.swing.ImageIcon(getClass().
            getResource("/" +  appPackage + "/miss5.png")));
            Thread.sleep(150);
        }              
    }
    
    private char hintLetter(String phrase, String letters) {
        String hintOptions = "";
        char chAll;
        for (int index = 0; index < phrase.length(); ++index) {
            chAll = Character.toLowerCase(phrase.charAt(index));
            String chString = Character.toString(chAll);
            if (Character.isLetter(chAll) && !letters.contains(chString)) {
                hintOptions += chAll;
            }
            if (!Character.isLetter(chAll) && !letters.contains(chString)) {
		hintOptions += phrase.charAt(index);
            }
            if (index < phrase.length() - 1) {
                hintOptions += "";
            }
	}
        hintOptions = keepLetters(hintOptions);
        char chHint;
        String hintOption = "";
	for (int index = 0; index < hintOptions.length(); ++index) 
	{
		chHint = Character.toLowerCase(hintOptions.charAt(index));
		String chString = Character.toString(chHint);
		if (!hintOption.contains(chString) && 
                        Character.isLetter(chHint)) 
		{
			hintOption += chHint;
		}
	}
        Random randChar = new Random();
        int index = randChar.nextInt(hintOptions.length());
        char hintLetter = hintOptions.charAt(index);
	return hintLetter;
	}
    
    private String keepLetters(String fullString) {
        String[] sa = fullString.split("\\W+");
        String lettersOnly = new String();
        for(int i = 0; i < sa.length; i++) {
            lettersOnly = lettersOnly+ sa[i];
        }
        return lettersOnly;
    }
    
    private void displayHint() throws InterruptedException, IOException, 
            Exception {
        char hintChar = hintLetter(pickedPhrase, correctGuesses);
        findButton(hintChar);
        isitHint = true;
        guessingGame(hintChar);
    }
    
    private void rulesButton() {
        String title = "Save The World " + playerName + "!";
        String message = " . . . . . . . . . . . . . . . . . Save The World! . "
            + ". . . . . . . . . . . . . . . .\n\n" + playerName + " . . . \n\n"
            + "You have been chosen to save the world from the alien\nforces th"
            + "at are trying to destory our planet!\n\nTo save our planet from "
            + "the attacks, you must use your\nsuperior intellect to solve the "
            + "word puzzles to fight\noff the alien invaders!\n\nIf you guess c"
            + "orrectly, the blank will be replaced with\nthe letter.\n\nIf you"
            + " guess incorrectly, the alien invaders will be one\nstep close t"
            + "o our planet!\n\nYou are allowed five mistakes before the alien "
            + "invaders\ndestroy our world.\n\nIf you use the HINT button, this"
            + " will give you a correct\nguess, but will allow the invaders one"
            + " step closer.\n\nIn victory, the Hero will be awarded the number"
            + " of\nremaining guesses as points.\n\nIn defeat, the Hero will lo"
            + "se five points.\n\nQuitting during a round will result in an aut"
            + "omatic loss.\n\nGood luck, " + playerName + "!\n\nThe fate of th"
            + "e world is in your hands . . .";
        plainpopupBox(title,message);
    }
    
    // <editor-fold defaultstate="collapsed" desc="Find Method">    
    private void findButton(char c) {
        String letter = (String.valueOf(c)).toUpperCase();
        if(letter.equals("A")) {
            usedA.setSelected(true);
            usedA.setEnabled(false);
        }
        if(letter.equals("B")) {
            usedB.setSelected(true);
            usedB.setEnabled(false);
        }
        if(letter.equals("C")) {
            usedC.setSelected(true);
            usedC.setEnabled(false);
        }
        if(letter.equals("D")) {
            usedD.setSelected(true);
            usedD.setEnabled(false);
        }
        if(letter.equals("E")) {
            usedE.setSelected(true);
            usedE.setEnabled(false);
        }
        if(letter.equals("F")) {
            usedF.setSelected(true);
            usedF.setEnabled(false);
        }
        if(letter.equals("G")) {
            usedG.setSelected(true);
            usedG.setEnabled(false);
        }
        if(letter.equals("H")) {
            usedH.setSelected(true);
            usedH.setEnabled(false);
        }
        if(letter.equals("I")) {
            usedI.setSelected(true);
            usedI.setEnabled(false);
        }
        if(letter.equals("J")) {
            usedJ.setSelected(true);
            usedJ.setEnabled(false);
        }
        if(letter.equals("K")) {
            usedK.setSelected(true);
            usedK.setEnabled(false);
        }
        if(letter.equals("L")) {
            usedL.setSelected(true);
            usedL.setEnabled(false);
        }
        if(letter.equals("M")) {
            usedM.setSelected(true);
            usedM.setEnabled(false);
        }
        if(letter.equals("N")) {
            usedN.setSelected(true);
            usedN.setEnabled(false);
        }
        if(letter.equals("O")) {
            usedO.setSelected(true);
            usedO.setEnabled(false);
        }
        if(letter.equals("P")) {
            usedP.setSelected(true);
            usedP.setEnabled(false);
        }
        if(letter.equals("Q")) {
            usedQ.setSelected(true);
            usedQ.setEnabled(false);
        }
        if(letter.equals("R")) {
            usedR.setSelected(true);
            usedR.setEnabled(false);
        }
        if(letter.equals("S")) {
            usedS.setSelected(true);
            usedS.setEnabled(false);
        }
        if(letter.equals("T")) {
            usedT.setSelected(true);
            usedT.setEnabled(false);
        }
        if(letter.equals("U")) {
            usedU.setSelected(true);
            usedU.setEnabled(false);
        }
        if(letter.equals("V")) {
            usedV.setSelected(true);
            usedV.setEnabled(false);
        }
        if(letter.equals("W")) {
            usedW.setSelected(true);
            usedW.setEnabled(false);
        }
        if(letter.equals("X")) {
            usedX.setSelected(true);
            usedX.setEnabled(false);
        }
        if(letter.equals("Y")) {
            usedY.setSelected(true);
            usedY.setEnabled(false);
        }
        if(letter.equals("Z")) {
            usedZ.setSelected(true);
            usedZ.setEnabled(false);
        }
    }
    //</editor-fold>
    
    private String phraseBlanks(String phrase, String correctLetters) {
        String wordUnguessed = "";
        char ch;
        int counter = 0;
        for (int index = 0; index < phrase.length(); ++index) {
            ch = Character.toLowerCase(phrase.charAt(index));
            String chString = Character.toString(ch);
            if(chString.contains("-")) {
                wordUnguessed += "\n\n" + "-";
            } else {
            
            if (!Character.isLetter(ch)) {
                wordUnguessed += ch;
            }
            
            
            if (Character.isLetter(ch) && !correctLetters.contains(chString)) {
                if(counter == 0 || counter %2 == 0) {
                    wordUnguessed += "_";
                } else {
                    wordUnguessed += " _ ";
                }
                counter += 1;
            }
            if (Character.isLetter(ch) && correctLetters.contains(chString)) {
		wordUnguessed += phrase.charAt(index);
            }
            if (index < phrase.length() - 1) {
                wordUnguessed += " ";
            }
            }
	}
        String s1 = wordUnguessed.replaceAll("   ", "\\~");
        String s2 = s1.replaceAll(" _ ", "===");
        String s3 = s2.replaceAll(" ","");
        String s4 = s3.replaceAll("===", " _ ");
        String finalUnguessed = s4.replace("~"," ");
        return finalUnguessed;
    }
    
    private String phraseRevealed(String phrase) {
        String wordRevealed = "";
        char ch;
        for (int index = 0; index < phrase.length(); ++index) {
            ch = phrase.charAt(index);
            String chString = Character.toString(ch);
            if(chString.contains("-")) {
                wordRevealed += "\n\n" + "-";
            } else {
            if (!Character.isLetter(ch)) {
                wordRevealed += ch;
            }
            if (Character.isLetter(ch)) {
                wordRevealed += ch;
            }
            if (index < phrase.length() - 1) {
                wordRevealed += " ";
            }
	}
        }
        String s1 = wordRevealed.replaceAll("   ", "\\~");
        String s2 = s1.replaceAll(" ","");
        String finalReveal = s2.replace("~"," ");
        return finalReveal;
    }
        
    private void postGame(boolean wasitVictory) throws InterruptedException, 
            IOException, Exception {
        disableAlpha();
        if (wasitVictory == true) { 
            scoreChange(5 - missCount);
            Thread.sleep(300);
            yourphaseText.setText("YOU HAVE SAVED THE WORLD, " + playerName + ""
                    + "!");
            gameBox.setIcon(new javax.swing.ImageIcon(getClass().
                getResource("/" +  appPackage + "/youwin.png")));
            newButton.setText("Play Again");
        } else {
            scoreChange(missCount * -1);
            Thread.sleep(150);
            yourphaseText.setText("YOU FAILED TO SAVE THE WORLD!");
            gameBox.setIcon(new javax.swing.ImageIcon(getClass().
                getResource("/" +  appPackage + "/youlose.png")));
            newButton.setText("Play Again");
            newMenu.setText("Play Again");
            customCheck(true);
            importMenu.setEnabled(true);
        }
        gentleClose();
        playAgain();        
    }
    
    private void exitwithPenalty() {
        scoreChange(-5);
    }
    
    private void spotCheck(String playername) throws IOException, 
            InterruptedException {
        File miscfile = new File(miscLib);
        boolean miscexists = miscfile.exists();
        String dataname = null;
        String libname = null;
        if(miscexists) {
            dataname = new ChecksBalances().getFirstLine(miscfile);
            libname = "data/" + dataname + ".pen";
            new ChecksBalances().newfileCheck((libname), true, 
                    playername, true);
            gentleClose();
        } else {
            dataname = playerName;
            libname = "data/" + dataname + ".pen";
        }
        File libfile = new File(libname);
        boolean libexists = libfile.exists();
        if(libexists) {
            if(playerName.equals(dataname)) {
                String title = "Improper Close";
                String message = "Looks like you did an improper shut down duri"
                        + "ng a game.\n\nUnfortunately, there's a 5 point penal"
                        + "ty for that.\n\nPlease be more careful, " + 
                        playerName;
                plainpopupBox(title,message);
                scoreChange(-5);
                System.gc();
                ChecksBalances.ifexistDelete(libname);
            }
        }
    }
    
    private void gentleOpen() throws IOException {
        new ChecksBalances().newfileCheck(miscLib,true,playerName,true);
    }
    
    private void gentleClose() throws IOException, InterruptedException {
        System.gc();
        ChecksBalances.ifexistDelete(miscLib);
    }
    
    private void playAgain() {
        String revealedPhrase = phraseRevealed(pickedPhrase);
        bottomText.setText(newgameText);
        phraseWindow.setText("\n" + revealedPhrase + "");
    }

    private void plainpopupBox(String title, String txt) {
        JOptionPane.showMessageDialog(null,txt,title,JOptionPane.PLAIN_MESSAGE);
    }
    
    private boolean yesorNo(String message, String popup) {
        int answer = JOptionPane.showConfirmDialog(null,message,popup,
                JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            if(answer == JOptionPane.NO_OPTION) {
                return false;
            } else {
                return true;
            }
    }
    
    private int popupResponse(String[] options, String title, String message) {
        int response = JOptionPane.showOptionDialog(null, message, title, 
                JOptionPane.DEFAULT_OPTION, JOptionPane.
                PLAIN_MESSAGE,null, options, options[0]);
        return response;
    }
    
    private void menuOption() throws IOException, Exception {
        try {
            endProcesses();
            dispose();
            new StartGUI().setVisible(true);
        } catch(IOException ex) {
            logFile("severe","MenuOption Error.\nIOEx: " + ex.toString());
        }
    }
    
    private void customCheck(boolean justCheck) throws IOException, 
            InterruptedException, Exception {
        String pName = customDir.replaceAll("/", "");
        List<Path> pathlist = new Converters().foldertoList(pName+"\\",pName);
        String defaultpath = ogcatPath;
        if(pathlist.size() > 0) {
            changeMenu.setEnabled(true);
        } else {
            changeMenu.setEnabled(false);
        }
        File lastcatFile = new File(lastcatPath);
        boolean exists = lastcatFile.exists();
        if(!exists) {
            new ChecksBalances().newfileCheck(lastcatPath,true,defaultpath,
                true);
        } else {
            catPath = (new ChecksBalances().getLast(lastcatFile));
            File currentcatFile = new File(catPath);
            boolean currentExists = currentcatFile.exists();
            if(!currentExists) {
                System.gc();
                ChecksBalances.ifexistDelete(lastcatPath);
                System.gc();
                new ChecksBalances().newfileCheck(lastcatPath,true,defaultpath,
                    true);
                catPath = (new ChecksBalances().getLast(lastcatFile));
            }
        }
        if(!justCheck) {
            List<String> filelist = pathlist.stream().map(p -> p.toString())
                    .collect(Collectors.toList());
            JComboBox customBox = new JComboBox();
            customcomboMaker(filelist, customBox);
            JOptionPane.showMessageDialog(null, customBox,"Change Phrase Categ"
                    + "ory",JOptionPane.QUESTION_MESSAGE);
            int index = customBox.getSelectedIndex();
            if(index == 0) {
                System.gc();
                ChecksBalances.ifexistDelete(lastcatPath);
                new ChecksBalances().newfileCheck(lastcatPath,true,defaultpath,
                        true);
            } else {
                if(index == customBox.getItemCount() -1) {
                    importButton(false);
                    System.gc();
                    ChecksBalances.ifexistDelete(lastcatPath);
                    new ChecksBalances().newfileCheck(lastcatPath,true,catPath,
                        true);
                } else {
                    String selection = customBox.getSelectedItem().toString();
                    catPath = customDir + selection + customExt;
                    System.gc();
                    ChecksBalances.ifexistDelete(lastcatPath);
                    new ChecksBalances().newfileCheck(lastcatPath,true,catPath,
                           true);
                }
            }
            restartGUI();
        }
    }
    
    private void customcomboMaker(List<String> list,JComboBox dropdown) {
            DefaultComboBoxModel dml= new DefaultComboBoxModel();
            Collections.sort(list);
            dml.addElement("Famous Quotes <Default>");
            for (int i=0; i < list.size(); i++ ) {
                String y = (list.get(i));
                String x;
                x = new Converters().capFirstLetter(y.substring(y.indexOf("\\")
                        +1,y.lastIndexOf(".")));
                dml.addElement(x);
                dropdown.setModel(dml);
            }
            dml.addElement("<Import New>");
        }
    
    private void importData(boolean fromMenu, boolean roundtwo) throws IOException, 
            InterruptedException, Exception {
        System.out.println(fromMenu);
        JFileChooser jf = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("All Suppo"
            + "rted Files", "txt", "text");
        jf.setFileFilter(filter);
        int result;
        int rounds = 0;
        if(roundtwo == true) {
            result = JFileChooser.CANCEL_OPTION;
        } else {
            result = jf.showOpenDialog(this);
        }
        if(result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jf.getSelectedFile();
            String newfilename = (new Converters().filenamefromPath(selectedFile
                ,true));
            String newPath = customDir + newfilename + customExt;
            File newFile = new File(newPath);
            try {
                Files.copy(selectedFile.toPath(), newFile.toPath());
            } catch (IOException ex) {
                importData(fromMenu, true);
                rounds += 1;
            }
            if(result == JFileChooser.APPROVE_OPTION && rounds < 1) {
                Process p = Runtime.getRuntime().exec("attrib +H " + newFile
                .getPath());
                p.waitFor(); 
                System.gc();
                ChecksBalances.ifexistDelete(lastcatPath);
                new ChecksBalances().newfileCheck(lastcatPath,true,newPath,
                        true);
                String poptitle = "Import Complete";
                String message="Your Import is Complete.\n\n"+(new Converters()
                    .capFirstLetter(newfilename)) + " will be your new selected"
                    + " category.";
                plainpopupBox(poptitle,message);
                if(fromMenu) {
                    restartGUI();
                }
                catPath = newPath;
            }
        } else {
            if(rounds < 2) {
                String poptitle = "Import Cancelled";
                String message = "You have cancelled the import.";
                plainpopupBox(poptitle,message);
            }
        }
    }
    
    private void newButton() {
        String newName = newButton.getText();
        if(newName.equals("Start")) {
            try {
                gentleOpen();
                startButton();
                newMenu.setText("Start Over");
                importMenu.setEnabled(false);
                changeMenu.setEnabled(false);
            } catch (IOException | InterruptedException ex) {
                try {
                    logFile("severe","New Button Error.  Ex: " + ex.toString());
                } catch (IOException ex1) {
                    ex1.printStackTrace();
                }
            }
        } else {
            try {
                try {
                    
                    Thread.sleep(250);
                    exitButton(true);
                } catch (Exception ex) {
                    logFile("severe","NewRestart Error.  Ex: " + ex.toString());
                }
            } catch (IOException ex) {
                try {
                    logFile("severe","New Button Error.  Ex: " + ex.toString());
                } catch (IOException ex1) {
                    ex1.printStackTrace();
                }
            }
        }
    }
    
    private void changeButton() throws IOException, InterruptedException, 
            Exception {
        try {
            customCheck(false);
        } catch (IOException | InterruptedException ex) {
            logFile("severe","Change Button IOEX: " + ex);
        }
    }
    
    private void importButton(boolean fromMenu) throws IOException, 
            InterruptedException, Exception {
        String title = "IMPORTANT! About Importing...";
        String message = "Be sure when importing that the file is in .txt forma"
                + "t and\nhas each phrase on one line (when not line wrapping)."
                + "\n\nFiles in other formats will not work.\n\nThank you.";
        plainpopupBox(title,message);
        importData(fromMenu,false);
    }
    
    private void aboutButton() throws Exception {
        try {
            new StartGUI().aboutButton();
        } catch (Exception ex) {
            logFile("severe", "About Button Exception" + ex.toString());
        }
    }
    
    private void donateButton() throws Exception {
        try {
            new StartGUI().donateButton();
        } catch (Exception ex) {
            logFile("severe", "Donate Button Exception" + ex.toString());
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Log + Exit Processes"> 

    private void restartGUI() throws IOException, Exception {
        try {
            System.gc();
            endProcesses();
            dispose();
            new GameGUI().setVisible(true);
        } catch (IOException ex) {
                logFile("severe","Restart GameGUI Error.  Ex: " +ex.toString());
        }
    }
    
    private void endProcesses() throws IOException, InterruptedException {
        try{
            System.gc();
            gentleClose();
            System.gc();
            checkHigh();
            System.gc();
            saveScore();
            System.gc();
            saveHigh();
            System.gc();
        } catch (IOException | InterruptedException ex) {
            logFile("severe","Game End Pros Error.  Ex: " +ex.toString());
        }
    }
    
    private void exitButton(boolean restarttheGUI) throws IOException, 
            Exception {
        int menuchoice;
        boolean skipPenalty = true;
        boolean gotPenalty = false;
        boolean exitchoice = false;
        String text = "Do you want to go back to the Main Menu or Exit the Game"
                + "?";
        String[] options = new String[] {"Back To Menu","Exit The Game"};

        if(newButton.getText().toString().equals("Start Over")) {
            skipPenalty = false;
            String warning = "Quitting in the middle of a game will result in a"
                    + " 5 point penalty.\nAre you sure you want to quit?";
            String[] choices = new String [] {"Quit and Lose 5 Points","I want "
                    + "to finish this game"};
            int warningchoice;
            warningchoice = popupResponse(choices, "Quit Penalty", warning);
            if(warningchoice == 0) {
                exitwithPenalty();
                gotPenalty = true;
            } else {
                skipPenalty = false;
                restarttheGUI = false;
            }
        }

        if(restarttheGUI) {
            restartGUI();
        } else {
            if(skipPenalty == true) {
                exitchoice = yesorNo("Are you sure you want to exit?","Exit the"
                        + " Game?");
            } else {
                if(gotPenalty == false) {
                    exitchoice = false;
                } else {
                    exitchoice = true;
                }
            }
            if(exitchoice == true) {
                menuchoice = popupResponse(options, "Exit the Game?", text);
                switch(menuchoice) {
                case 0:
                    try {
                        menuOption();
                    } catch (IOException ex) {
                        logFile("severe","New Exit Button Error.\nIOEx: " + ex.
                                toString());
                        endProcesses();
                        System.gc();
                        System.exit(0);
                    }
                    break;
                default:
                    endProcesses();
                    System.gc();
                    System.exit(0);
                    break;
                }
            }
        }
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Swing Code">
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainTitle = new javax.swing.JLabel();
        gameBox = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        phraseWindow = new javax.swing.JTextArea();
        newButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        cscoreLabel = new javax.swing.JLabel();
        cscoreBox = new javax.swing.JTextField();
        catLabel = new javax.swing.JLabel();
        catBox = new javax.swing.JTextField();
        playerLabel = new javax.swing.JLabel();
        playerBox = new javax.swing.JTextField();
        hscoreLabel = new javax.swing.JLabel();
        hscoreBox = new javax.swing.JTextField();
        hintButton = new javax.swing.JToggleButton();
        usedA = new javax.swing.JToggleButton();
        usedB = new javax.swing.JToggleButton();
        usedC = new javax.swing.JToggleButton();
        usedD = new javax.swing.JToggleButton();
        usedE = new javax.swing.JToggleButton();
        usedF = new javax.swing.JToggleButton();
        usedG = new javax.swing.JToggleButton();
        usedH = new javax.swing.JToggleButton();
        usedI = new javax.swing.JToggleButton();
        usedJ = new javax.swing.JToggleButton();
        usedK = new javax.swing.JToggleButton();
        usedL = new javax.swing.JToggleButton();
        usedM = new javax.swing.JToggleButton();
        usedN = new javax.swing.JToggleButton();
        usedO = new javax.swing.JToggleButton();
        usedP = new javax.swing.JToggleButton();
        usedQ = new javax.swing.JToggleButton();
        usedR = new javax.swing.JToggleButton();
        usedS = new javax.swing.JToggleButton();
        usedT = new javax.swing.JToggleButton();
        usedU = new javax.swing.JToggleButton();
        usedV = new javax.swing.JToggleButton();
        usedW = new javax.swing.JToggleButton();
        usedX = new javax.swing.JToggleButton();
        usedY = new javax.swing.JToggleButton();
        usedZ = new javax.swing.JToggleButton();
        rulesButton = new javax.swing.JButton();
        bottomText = new javax.swing.JLabel();
        yourphaseText = new javax.swing.JTextField();
        gameMenubar = new javax.swing.JMenuBar();
        optionMenu = new javax.swing.JMenu();
        newMenu = new javax.swing.JMenuItem();
        changeMenu = new javax.swing.JMenuItem();
        importMenu = new javax.swing.JMenuItem();
        rulesMenu = new javax.swing.JMenuItem();
        aboutMenu = new javax.swing.JMenuItem();
        donateMenu = new javax.swing.JMenuItem();
        quitMenu = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle(appTitle);
        setIconImage(imageIcon.getImage());
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        mainTitle.setFont(new java.awt.Font("Stencil Std", 0, 16)); // NOI18N
        mainTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mainTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clarktribegames/header.png"))); // NOI18N
        mainTitle.setFocusable(false);

        gameBox.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gameBox.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clarktribegames/title.png"))); // NOI18N
        gameBox.setFocusable(false);

        phraseWindow.setEditable(false);
        phraseWindow.setColumns(20);
        phraseWindow.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        phraseWindow.setLineWrap(true);
        phraseWindow.setRows(6);
        phraseWindow.setAlignmentX(0.0F);
        phraseWindow.setAlignmentY(0.0F);
        phraseWindow.setAutoscrolls(false);
        phraseWindow.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane2.setViewportView(phraseWindow);

        newButton.setText("Start");
        newButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newButtonActionPerformed(evt);
            }
        });

        exitButton.setText("Exit");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        cscoreLabel.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        cscoreLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cscoreLabel.setText("SCORE");
        cscoreLabel.setFocusable(false);

        cscoreBox.setEditable(false);
        cscoreBox.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cscoreBox.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cscoreBox.setAutoscrolls(false);
        cscoreBox.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cscoreBox.setFocusable(false);

        catLabel.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        catLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        catLabel.setText("CATEGORY");
        catLabel.setFocusable(false);

        catBox.setEditable(false);
        catBox.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        catBox.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        catBox.setAutoscrolls(false);
        catBox.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        catBox.setFocusable(false);

        playerLabel.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        playerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        playerLabel.setText("HERO");
        playerLabel.setFocusable(false);

        playerBox.setEditable(false);
        playerBox.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        playerBox.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        playerBox.setAutoscrolls(false);
        playerBox.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        playerBox.setFocusable(false);

        hscoreLabel.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        hscoreLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hscoreLabel.setText("HIGH SCORE");
        hscoreLabel.setFocusable(false);

        hscoreBox.setEditable(false);
        hscoreBox.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        hscoreBox.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        hscoreBox.setAutoscrolls(false);
        hscoreBox.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        hscoreBox.setFocusable(false);

        hintButton.setText("Hint");
        hintButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hintButtonActionPerformed(evt);
            }
        });

        usedA.setText("A");
        usedA.setMaximumSize(new java.awt.Dimension(40, 23));
        usedA.setMinimumSize(new java.awt.Dimension(40, 23));
        usedA.setPreferredSize(new java.awt.Dimension(40, 23));
        usedA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usedAActionPerformed(evt);
            }
        });

        usedB.setText("B");
        usedB.setMaximumSize(new java.awt.Dimension(40, 23));
        usedB.setMinimumSize(new java.awt.Dimension(40, 23));
        usedB.setPreferredSize(new java.awt.Dimension(40, 23));
        usedB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usedBActionPerformed(evt);
            }
        });

        usedC.setText("C");
        usedC.setMaximumSize(new java.awt.Dimension(40, 23));
        usedC.setMinimumSize(new java.awt.Dimension(40, 23));
        usedC.setPreferredSize(new java.awt.Dimension(40, 23));
        usedC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usedCActionPerformed(evt);
            }
        });

        usedD.setText("D");
        usedD.setMaximumSize(new java.awt.Dimension(40, 23));
        usedD.setMinimumSize(new java.awt.Dimension(40, 23));
        usedD.setPreferredSize(new java.awt.Dimension(40, 23));
        usedD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usedDActionPerformed(evt);
            }
        });

        usedE.setText("E");
        usedE.setMaximumSize(new java.awt.Dimension(40, 23));
        usedE.setMinimumSize(new java.awt.Dimension(40, 23));
        usedE.setPreferredSize(new java.awt.Dimension(40, 23));
        usedE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usedEActionPerformed(evt);
            }
        });

        usedF.setText("F");
        usedF.setMaximumSize(new java.awt.Dimension(40, 23));
        usedF.setMinimumSize(new java.awt.Dimension(40, 23));
        usedF.setPreferredSize(new java.awt.Dimension(40, 23));
        usedF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usedFActionPerformed(evt);
            }
        });

        usedG.setText("G");
        usedG.setMaximumSize(new java.awt.Dimension(40, 23));
        usedG.setMinimumSize(new java.awt.Dimension(40, 23));
        usedG.setPreferredSize(new java.awt.Dimension(40, 23));
        usedG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usedGActionPerformed(evt);
            }
        });

        usedH.setText("H");
        usedH.setMaximumSize(new java.awt.Dimension(40, 23));
        usedH.setMinimumSize(new java.awt.Dimension(40, 23));
        usedH.setPreferredSize(new java.awt.Dimension(40, 23));
        usedH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usedHActionPerformed(evt);
            }
        });

        usedI.setText("I");
        usedI.setMaximumSize(new java.awt.Dimension(40, 23));
        usedI.setMinimumSize(new java.awt.Dimension(40, 23));
        usedI.setPreferredSize(new java.awt.Dimension(40, 23));
        usedI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usedIActionPerformed(evt);
            }
        });

        usedJ.setText("J");
        usedJ.setMaximumSize(new java.awt.Dimension(40, 23));
        usedJ.setMinimumSize(new java.awt.Dimension(40, 23));
        usedJ.setPreferredSize(new java.awt.Dimension(40, 23));
        usedJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usedJActionPerformed(evt);
            }
        });

        usedK.setText("K");
        usedK.setMaximumSize(new java.awt.Dimension(40, 23));
        usedK.setMinimumSize(new java.awt.Dimension(40, 23));
        usedK.setPreferredSize(new java.awt.Dimension(40, 23));
        usedK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usedKActionPerformed(evt);
            }
        });

        usedL.setText("L");
        usedL.setMaximumSize(new java.awt.Dimension(40, 23));
        usedL.setMinimumSize(new java.awt.Dimension(40, 23));
        usedL.setPreferredSize(new java.awt.Dimension(40, 23));
        usedL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usedLActionPerformed(evt);
            }
        });

        usedM.setText("M");
        usedM.setMaximumSize(new java.awt.Dimension(40, 23));
        usedM.setMinimumSize(new java.awt.Dimension(40, 23));
        usedM.setPreferredSize(new java.awt.Dimension(40, 23));
        usedM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usedMActionPerformed(evt);
            }
        });

        usedN.setText("N");
        usedN.setMaximumSize(new java.awt.Dimension(40, 23));
        usedN.setMinimumSize(new java.awt.Dimension(40, 23));
        usedN.setPreferredSize(new java.awt.Dimension(40, 23));
        usedN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usedNActionPerformed(evt);
            }
        });

        usedO.setText("O");
        usedO.setMaximumSize(new java.awt.Dimension(40, 23));
        usedO.setMinimumSize(new java.awt.Dimension(40, 23));
        usedO.setPreferredSize(new java.awt.Dimension(40, 23));
        usedO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usedOActionPerformed(evt);
            }
        });

        usedP.setText("P");
        usedP.setMaximumSize(new java.awt.Dimension(40, 23));
        usedP.setMinimumSize(new java.awt.Dimension(40, 23));
        usedP.setPreferredSize(new java.awt.Dimension(40, 23));
        usedP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usedPActionPerformed(evt);
            }
        });

        usedQ.setText("Q");
        usedQ.setMaximumSize(new java.awt.Dimension(40, 23));
        usedQ.setMinimumSize(new java.awt.Dimension(40, 23));
        usedQ.setPreferredSize(new java.awt.Dimension(40, 23));
        usedQ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usedQActionPerformed(evt);
            }
        });

        usedR.setText("R");
        usedR.setMaximumSize(new java.awt.Dimension(40, 23));
        usedR.setMinimumSize(new java.awt.Dimension(40, 23));
        usedR.setPreferredSize(new java.awt.Dimension(40, 23));
        usedR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usedRActionPerformed(evt);
            }
        });

        usedS.setText("S");
        usedS.setMaximumSize(new java.awt.Dimension(42, 23));
        usedS.setMinimumSize(new java.awt.Dimension(42, 23));
        usedS.setPreferredSize(new java.awt.Dimension(42, 23));
        usedS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usedSActionPerformed(evt);
            }
        });

        usedT.setText("T");
        usedT.setMaximumSize(new java.awt.Dimension(42, 23));
        usedT.setMinimumSize(new java.awt.Dimension(42, 23));
        usedT.setPreferredSize(new java.awt.Dimension(42, 23));
        usedT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usedTActionPerformed(evt);
            }
        });

        usedU.setText("U");
        usedU.setMaximumSize(new java.awt.Dimension(42, 23));
        usedU.setMinimumSize(new java.awt.Dimension(42, 23));
        usedU.setPreferredSize(new java.awt.Dimension(42, 23));
        usedU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usedUActionPerformed(evt);
            }
        });

        usedV.setText("V");
        usedV.setMaximumSize(new java.awt.Dimension(42, 23));
        usedV.setMinimumSize(new java.awt.Dimension(42, 23));
        usedV.setPreferredSize(new java.awt.Dimension(42, 23));
        usedV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usedVActionPerformed(evt);
            }
        });

        usedW.setText("W");
        usedW.setMaximumSize(new java.awt.Dimension(42, 23));
        usedW.setMinimumSize(new java.awt.Dimension(42, 23));
        usedW.setPreferredSize(new java.awt.Dimension(42, 23));
        usedW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usedWActionPerformed(evt);
            }
        });

        usedX.setText("X");
        usedX.setMaximumSize(new java.awt.Dimension(42, 23));
        usedX.setMinimumSize(new java.awt.Dimension(42, 23));
        usedX.setPreferredSize(new java.awt.Dimension(42, 23));
        usedX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usedXActionPerformed(evt);
            }
        });

        usedY.setText("Y");
        usedY.setMaximumSize(new java.awt.Dimension(42, 23));
        usedY.setMinimumSize(new java.awt.Dimension(42, 23));
        usedY.setPreferredSize(new java.awt.Dimension(42, 23));
        usedY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usedYActionPerformed(evt);
            }
        });

        usedZ.setText("Z");
        usedZ.setMaximumSize(new java.awt.Dimension(42, 23));
        usedZ.setMinimumSize(new java.awt.Dimension(42, 23));
        usedZ.setPreferredSize(new java.awt.Dimension(42, 23));
        usedZ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usedZActionPerformed(evt);
            }
        });

        rulesButton.setText("Rules");
        rulesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rulesButtonActionPerformed(evt);
            }
        });

        bottomText.setFont(new java.awt.Font("Lucida Console", 1, 14)); // NOI18N
        bottomText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bottomText.setText(firststartText);

        yourphaseText.setEditable(false);
        yourphaseText.setFont(new java.awt.Font("Lucida Console", 1, 18)); // NOI18N
        yourphaseText.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        yourphaseText.setBorder(null);
        yourphaseText.setFocusable(false);

        optionMenu.setText("Options");

        newMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        newMenu.setText("Start New Game");
        newMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newMenuActionPerformed(evt);
            }
        });
        optionMenu.add(newMenu);

        changeMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        changeMenu.setText("Change Category");
        changeMenu.setEnabled(false);
        changeMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeMenuActionPerformed(evt);
            }
        });
        optionMenu.add(changeMenu);

        importMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        importMenu.setText("Import Custom File");
        importMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importMenuActionPerformed(evt);
            }
        });
        optionMenu.add(importMenu);

        rulesMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        rulesMenu.setText("Rules of This Game");
        rulesMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rulesMenuActionPerformed(evt);
            }
        });
        optionMenu.add(rulesMenu);

        aboutMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        aboutMenu.setText("About This Game");
        aboutMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenuActionPerformed(evt);
            }
        });
        optionMenu.add(aboutMenu);

        donateMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        donateMenu.setText("Donate To The Cause");
        donateMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                donateMenuActionPerformed(evt);
            }
        });
        optionMenu.add(donateMenu);

        quitMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        quitMenu.setText("Exit to Main Menu");
        quitMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitMenuActionPerformed(evt);
            }
        });
        optionMenu.add(quitMenu);

        gameMenubar.add(optionMenu);

        setJMenuBar(gameMenubar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(mainTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(hscoreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(catLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(177, 177, 177)
                                .addComponent(cscoreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(playerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(hscoreBox, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(catBox, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(playerBox, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(cscoreBox, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(usedA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(usedB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(usedC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(usedD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(usedE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(usedF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(usedG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(usedH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(usedI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(usedJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(usedK, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11)
                                .addComponent(usedL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(usedM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(usedN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(usedO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(usedP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(usedQ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(usedR, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(usedS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addComponent(usedT, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(usedU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addComponent(usedV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addComponent(usedW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addComponent(usedX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addComponent(usedY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addComponent(usedZ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hintButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bottomText, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(newButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rulesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(yourphaseText, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(gameBox, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainTitle)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(hscoreLabel)
                    .addComponent(catLabel)
                    .addComponent(cscoreLabel)
                    .addComponent(playerLabel))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(hscoreBox, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(catBox, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(playerBox, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cscoreBox, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addComponent(gameBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(yourphaseText, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bottomText, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(newButton)
                        .addGap(7, 7, 7)
                        .addComponent(rulesButton)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(usedA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usedB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usedC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usedD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usedE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usedF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usedG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usedH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usedI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(usedJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usedK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usedL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usedM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usedN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usedO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usedP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usedQ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usedR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(usedS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usedT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usedU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usedV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usedW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usedX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usedY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usedZ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(exitButton)
                        .addGap(7, 7, 7)
                        .addComponent(hintButton, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Swing Actions">    
    private void hintButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hintButtonActionPerformed
        try {
            displayHint();
        } catch (InterruptedException ex) {
            try {
                logFile("severe","Hint Button Error.  Ex: " + ex.toString());
            } catch (IOException ex1) {
                ex1.printStackTrace();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        hintButton.setSelected(true);
        hintButton.setEnabled(false);
    }//GEN-LAST:event_hintButtonActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        try {
            exitButton(false);
        } catch (IOException | InterruptedException ex) {
            try {
                logFile("severe","Exit Button Error.  Ex: " + ex.toString());
            } catch (IOException ex1) {
                ex1.printStackTrace();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_exitButtonActionPerformed

    private void newButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButtonActionPerformed
        newButton();
    }//GEN-LAST:event_newButtonActionPerformed

    private void usedAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usedAActionPerformed
        usedA.setSelected(true);
        usedA.setEnabled(false);
        try {
            guessingGame('A');
        } catch (InterruptedException ex) {
            try {
                logFile("severe","A Button Error.  Ex: " + ex.toString());
            } catch (IOException ex1) {
                ex1.printStackTrace();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }//GEN-LAST:event_usedAActionPerformed

    private void usedBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usedBActionPerformed
        usedB.setSelected(true);
        usedB.setEnabled(false);
        try {
            guessingGame('B');
        } catch (InterruptedException ex) {
            try {
                logFile("severe","B Button Error.  Ex: " + ex.toString());
            } catch (IOException ex1) {
                ex1.printStackTrace();
            }
        }  catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_usedBActionPerformed

    private void usedCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usedCActionPerformed
        usedC.setSelected(true);
        usedC.setEnabled(false);
        try {
            guessingGame('C');
        } catch (InterruptedException ex) {
            try {
                logFile("severe","C Button Error.  Ex: " + ex.toString());
            } catch (IOException ex1) {
                ex1.printStackTrace();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_usedCActionPerformed

    private void usedDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usedDActionPerformed
        usedD.setSelected(true);
        usedD.setEnabled(false);
        try {
            guessingGame('D');
        } catch (InterruptedException ex) {
            try {
                logFile("severe","D Button Error.  Ex: " + ex.toString());
            } catch (IOException ex1) {
                ex1.printStackTrace();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_usedDActionPerformed

    private void usedEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usedEActionPerformed
        usedE.setSelected(true);
        usedE.setEnabled(false);
        try {
            guessingGame('E');
        } catch (InterruptedException ex) {
            try {
                logFile("severe","E Button Error.  Ex: " + ex.toString());
            } catch (IOException ex1) {
                ex1.printStackTrace();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_usedEActionPerformed

    private void usedFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usedFActionPerformed
        usedF.setSelected(true);
        usedF.setEnabled(false);
        try {
            guessingGame('F');
        } catch (InterruptedException ex) {
            try {
                logFile("severe","F Button Error.  Ex: " + ex.toString());
            } catch (IOException ex1) {
                ex1.printStackTrace();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_usedFActionPerformed

    private void usedGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usedGActionPerformed
        usedG.setSelected(true);
        usedG.setEnabled(false);
        try {
            guessingGame('G');
        } catch (InterruptedException ex) {
            try {
                logFile("severe","G Button Error.  Ex: " + ex.toString());
            } catch (IOException ex1) {
                ex1.printStackTrace();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_usedGActionPerformed

    private void usedHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usedHActionPerformed
        usedH.setSelected(true);
        usedH.setEnabled(false);
        try {
            guessingGame('H');
        } catch (InterruptedException ex) {
            try {
                logFile("severe","H Button Error.  Ex: " + ex.toString());
            } catch (IOException ex1) {
                ex1.printStackTrace();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_usedHActionPerformed

    private void usedIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usedIActionPerformed
        usedI.setSelected(true);
        usedI.setEnabled(false);
        try {
            guessingGame('I');
        } catch (InterruptedException ex) {
            try {
                logFile("severe","I Button Error.  Ex: " + ex.toString());
            } catch (IOException ex1) {
                ex1.printStackTrace();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_usedIActionPerformed

    private void usedJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usedJActionPerformed
        usedJ.setSelected(true);
        usedJ.setEnabled(false);
        try {
            guessingGame('J');
        } catch (InterruptedException ex) {
            try {
                logFile("severe","J Button Error.  Ex: " + ex.toString());
            } catch (IOException ex1) {
                ex1.printStackTrace();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_usedJActionPerformed

    private void usedKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usedKActionPerformed
        usedK.setSelected(true);
        usedK.setEnabled(false);
        try {
            guessingGame('K');
        } catch (InterruptedException ex) {
            try {
                logFile("severe","K Button Error.  Ex: " + ex.toString());
            } catch (IOException ex1) {
                ex1.printStackTrace();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_usedKActionPerformed

    private void usedLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usedLActionPerformed
        usedL.setSelected(true);
        usedL.setEnabled(false);
        try {
            guessingGame('L');
        } catch (InterruptedException ex) {
            try {
                logFile("severe","L Button Error.  Ex: " + ex.toString());
            } catch (IOException ex1) {
                ex1.printStackTrace();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_usedLActionPerformed

    private void usedMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usedMActionPerformed
        usedM.setSelected(true);
        usedM.setEnabled(false);
        try {
            guessingGame('M');
        } catch (InterruptedException ex) {
            try {
                logFile("severe","M Button Error.  Ex: " + ex.toString());
            } catch (IOException ex1) {
                ex1.printStackTrace();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_usedMActionPerformed

    private void usedNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usedNActionPerformed
        usedN.setSelected(true);
        usedN.setEnabled(false);
        try {
            guessingGame('N');
        } catch (InterruptedException ex) {
            try {
                logFile("severe","N Button Error.  Ex: " + ex.toString());
            } catch (IOException ex1) {
                ex1.printStackTrace();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_usedNActionPerformed

    private void usedOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usedOActionPerformed
        usedO.setSelected(true);
        usedO.setEnabled(false);
        try {
            guessingGame('O');
        } catch (InterruptedException ex) {
            try {
                logFile("severe","O Button Error.  Ex: " + ex.toString());
            } catch (IOException ex1) {
                ex1.printStackTrace();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_usedOActionPerformed

    private void usedPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usedPActionPerformed
        usedP.setSelected(true);
        usedP.setEnabled(false);
        try {
            guessingGame('P');
        } catch (InterruptedException ex) {
            try {
                logFile("severe","P Button Error.  Ex: " + ex.toString());
            } catch (IOException ex1) {
                ex1.printStackTrace();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_usedPActionPerformed

    private void usedQActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usedQActionPerformed
        usedQ.setSelected(true);
        usedQ.setEnabled(false);
        try {
            guessingGame('Q');
        } catch (InterruptedException ex) {
            try {
                logFile("severe","Q Button Error.  Ex: " + ex.toString());
            } catch (IOException ex1) {
                ex1.printStackTrace();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_usedQActionPerformed

    private void usedRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usedRActionPerformed
        usedR.setSelected(true);
        usedR.setEnabled(false);
        try {
            guessingGame('R');
        } catch (InterruptedException ex) {
            try {
                logFile("severe","R Button Error.  Ex: " + ex.toString());
            } catch (IOException ex1) {
                ex1.printStackTrace();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_usedRActionPerformed

    private void usedSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usedSActionPerformed
        usedS.setSelected(true);
        usedS.setEnabled(false);
        try {
            guessingGame('S');
        } catch (InterruptedException ex) {
            try {
                logFile("severe","S Button Error.  Ex: " + ex.toString());
            } catch (IOException ex1) {
                ex1.printStackTrace();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_usedSActionPerformed

    private void usedTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usedTActionPerformed
        usedT.setSelected(true);
        usedT.setEnabled(false);
        try {
            guessingGame('T');
        } catch (InterruptedException ex) {
            try {
                logFile("severe","T Button Error.  Ex: " + ex.toString());
            } catch (IOException ex1) {
                ex1.printStackTrace();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_usedTActionPerformed

    private void usedUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usedUActionPerformed
        usedU.setSelected(true);
        usedU.setEnabled(false);
        try {
            guessingGame('U');
        } catch (InterruptedException ex) {
            try {
                logFile("severe","U Button Error.  Ex: " + ex.toString());
            } catch (IOException ex1) {
                ex1.printStackTrace();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_usedUActionPerformed

    private void usedVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usedVActionPerformed
        usedV.setSelected(true);
        usedV.setEnabled(false);
        try {
            guessingGame('V');
        } catch (InterruptedException ex) {
            try {
                logFile("severe","V Button Error.  Ex: " + ex.toString());
            } catch (IOException ex1) {
                ex1.printStackTrace();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_usedVActionPerformed

    private void usedWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usedWActionPerformed
        usedW.setSelected(true);
        usedW.setEnabled(false);
        try {
            guessingGame('W');
        } catch (InterruptedException ex) {
            try {
                logFile("severe","W Button Error.  Ex: " + ex.toString());
            } catch (IOException ex1) {
                ex1.printStackTrace();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_usedWActionPerformed

    private void usedXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usedXActionPerformed
        usedX.setSelected(true);
        usedX.setEnabled(false);
        try {
            guessingGame('X');
        } catch (InterruptedException ex) {
            try {
                logFile("severe","X Button Error.  Ex: " + ex.toString());
            } catch (IOException ex1) {
                ex1.printStackTrace();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_usedXActionPerformed

    private void usedYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usedYActionPerformed
        usedY.setSelected(true);
        usedY.setEnabled(false);
        try {
            guessingGame('Y');
        } catch (InterruptedException ex) {
            try {
                logFile("severe","Y Button Error.  Ex: " + ex.toString());
            } catch (IOException ex1) {
                ex1.printStackTrace();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_usedYActionPerformed

    private void usedZActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usedZActionPerformed
        usedZ.setSelected(true);
        usedZ.setEnabled(false);
        try {
            guessingGame('Z');
        } catch (InterruptedException ex) {
            try {
                logFile("severe","Z Button Error.  Ex: " + ex.toString());
            } catch (IOException ex1) {
                ex1.printStackTrace();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_usedZActionPerformed

    private void rulesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rulesButtonActionPerformed
        rulesButton();
    }//GEN-LAST:event_rulesButtonActionPerformed

    private void aboutMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenuActionPerformed
        try {
            aboutButton();
        } catch (Exception ex) {
            try {
                logFile("severe","About Button Exception: " + ex.toString());
            } catch (IOException ex1) {
                ex1.printStackTrace();
            }
        }
    }//GEN-LAST:event_aboutMenuActionPerformed

    private void quitMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitMenuActionPerformed
        try {
            exitButton(false);
        } catch (Exception ex) {
            try {
                logFile("severe","Exit Button Exception: " + ex.toString());
            } catch (IOException ex1) {
                ex1.printStackTrace();
            }
        }
    }//GEN-LAST:event_quitMenuActionPerformed

    private void rulesMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rulesMenuActionPerformed
        rulesButton();
    }//GEN-LAST:event_rulesMenuActionPerformed

    private void newMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newMenuActionPerformed
        newButton();
    }//GEN-LAST:event_newMenuActionPerformed

    private void changeMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeMenuActionPerformed
        try {
            changeButton();
        } catch (Exception ex) {
            try {
                logFile("severe","Change Button Exception: " + ex.toString());
            } catch (IOException ex1) {
                ex1.printStackTrace();
            }
        }        
    }//GEN-LAST:event_changeMenuActionPerformed

    private void importMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importMenuActionPerformed
        try {
            importButton(true);
        } catch (Exception ex) {
            try {
                logFile("severe","Import Button Exception: " + ex.toString());
            } catch (IOException ex1) {
                ex1.printStackTrace();
            }
        }
    }//GEN-LAST:event_importMenuActionPerformed

    private void donateMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_donateMenuActionPerformed
        try {
            donateButton();
        } catch (Exception ex) {
            try {
                logFile("severe","Donate Button Exception: " + ex.toString());
            } catch (IOException ex1) {
                ex1.printStackTrace();
            }
        }
    }//GEN-LAST:event_donateMenuActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            exitButton(false);
        } catch (Exception ex) {
            try {
                logFile("severe","Exit Button Exception: " + ex.toString());
            } catch (IOException ex1) {
                ex1.printStackTrace();
            }
        }
    }//GEN-LAST:event_formWindowClosing
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Main Launcher Method">
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | 
                IllegalAccessException | 
                javax.swing.UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new GameGUI().setVisible(true);
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Log File Method">
    private static void logFile (String type, String loginfo) throws IOException {
        try {
            new LogWriter().writeLog(type,loginfo);
        } catch(IOException ioex) {
            logFile("severe","logFile cannot fine log file (infinite loop)!");
        }
    }
    //</editor-fold>

//<editor-fold defaultstate="collapsed" desc="FileReader Class">
public class FileReader {
        BufferedReader reader = null;
        
    public FileReader(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        FileInputStream fileStream = new FileInputStream(file);
        InputStreamReader input = new InputStreamReader(fileStream);
        reader = new BufferedReader(input);
    }
    
    private int getLineCount() throws IOException {
        int lineCount = 0;
        String data;
        while((data = reader.readLine()) != null) {
            lineCount++;
        }
        return lineCount;
    }
}
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Footer Info">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenu;
    private javax.swing.JLabel bottomText;
    private javax.swing.JTextField catBox;
    private javax.swing.JLabel catLabel;
    private javax.swing.JMenuItem changeMenu;
    private javax.swing.JTextField cscoreBox;
    private javax.swing.JLabel cscoreLabel;
    private javax.swing.JMenuItem donateMenu;
    private javax.swing.JButton exitButton;
    private javax.swing.JLabel gameBox;
    private javax.swing.JMenuBar gameMenubar;
    private javax.swing.JToggleButton hintButton;
    private javax.swing.JTextField hscoreBox;
    private javax.swing.JLabel hscoreLabel;
    private javax.swing.JMenuItem importMenu;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel mainTitle;
    private javax.swing.JButton newButton;
    private javax.swing.JMenuItem newMenu;
    private javax.swing.JMenu optionMenu;
    private javax.swing.JTextArea phraseWindow;
    private javax.swing.JTextField playerBox;
    private javax.swing.JLabel playerLabel;
    private javax.swing.JMenuItem quitMenu;
    private javax.swing.JButton rulesButton;
    private javax.swing.JMenuItem rulesMenu;
    private javax.swing.JToggleButton usedA;
    private javax.swing.JToggleButton usedB;
    private javax.swing.JToggleButton usedC;
    private javax.swing.JToggleButton usedD;
    private javax.swing.JToggleButton usedE;
    private javax.swing.JToggleButton usedF;
    private javax.swing.JToggleButton usedG;
    private javax.swing.JToggleButton usedH;
    private javax.swing.JToggleButton usedI;
    private javax.swing.JToggleButton usedJ;
    private javax.swing.JToggleButton usedK;
    private javax.swing.JToggleButton usedL;
    private javax.swing.JToggleButton usedM;
    private javax.swing.JToggleButton usedN;
    private javax.swing.JToggleButton usedO;
    private javax.swing.JToggleButton usedP;
    private javax.swing.JToggleButton usedQ;
    private javax.swing.JToggleButton usedR;
    private javax.swing.JToggleButton usedS;
    private javax.swing.JToggleButton usedT;
    private javax.swing.JToggleButton usedU;
    private javax.swing.JToggleButton usedV;
    private javax.swing.JToggleButton usedW;
    private javax.swing.JToggleButton usedX;
    private javax.swing.JToggleButton usedY;
    private javax.swing.JToggleButton usedZ;
    private javax.swing.JTextField yourphaseText;
    // End of variables declaration//GEN-END:variables
    //</editor-fold>
}