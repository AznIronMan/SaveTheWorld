package com.clarktribe.qtn;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @author  Geoff Clark
 * @e-mail  gclark82@gmail.com
 * @version alpha 0.0.1
 * 
 */

public class STWGUI extends javax.swing.JFrame {
    String cat1Path = "default.dat";
    String cat2Path = "default.dat";
    String cat3Path = "default.dat";
    String cat1Res = "/com/clarktribe/qtn/default.dat";
    String cat2Res = "/com/clarktribe/qtn/default.dat";
    String cat3Res = "/com/clarktribe/qtn/default.dat";
    String cscorePath = "Score.dat";
    String hscorePath = "HighScore.dat";
    String custPath1 = "Category1.txt";
    String custPath2 = "Category2.txt";
    String custPath3 = "Category3.txt";
    String cat1Name = "";
    String cat2Name = "";
    String cat3Name = "";
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
    
    public STWGUI() throws IOException {
        try {
            initComponents();
            datFiles();
            scoreFiles();
            customCats();
            introLook();
        } catch (IOException ex) {
                    ex.printStackTrace();
                }
    }
    
    public final void introLook() {
        introText();
        hideAlpha();
        hideCat();
        hideCato();
        newButton.setEnabled(true);
    }
    
    public void introText() {
        gameBox.setIcon(new javax.swing.ImageIcon(getClass().
                getResource("/com/clarktribe/qtn/title.png")));
        phraseWindow.setFocusable(true);
        phraseWindow.setFont(new java.awt.Font("Tahoma", 0, 12));
        phraseWindow.setRows(5);
        phraseWindow.setText("\n\n\n\n\n\n\n                    C L I C K      "
                + "    S T A R T          T O          B E G I N          G A M"
                + " E\n\n\n                    C L I C K          R U L E S    "
                + "      F O R          I N S T R U C T I O N S");
        phraseWindow.setAlignmentX(0.0F);
        phraseWindow.setAlignmentY(0.0F);
    }
    
    public void rulesText() {
        phraseWindow.setColumns(20);
        phraseWindow.setRows(5);
        phraseWindow.setFont(new java.awt.Font("Tahoma", 0, 12));
        phraseWindow.setText("***Rules***\n\nGuess the phrase before STW ge"
                + "ts loses!\n\nEnter an alphabet you think that is a part of th"
                + "e answer.\n\nIf your guessing letter is correct, the blank w"
                + "ill be replaced with the letter.\n\nIf your guessing alphabe"
                + "t is incorrect, STW will be drawn step by step.\n\nSTW"
                + " has FIVE tries before losing, in which, you will lose the g"
                + "ame.\n\nGood luck!!\n\n\n\nC L I C K     S T A R T     T O  "
                + "   B E G I N     G A M E.");
        rulesButton.setEnabled(false);
    }
    
    public void hideAlpha() {
        usedTitle.setEnabled(false);
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
    
    public void showAlpha() {
        usedTitle.setEnabled(true);
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

    public void disableAlpha() {
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

    public void hideCscore() {
        cscoreBox.setEnabled(false);
        cscoreLabel.setEnabled(false);
    }
    
    public void showCscore() {
        cscoreBox.setEnabled(true);
        cscoreLabel.setEnabled(true);
    }
    
    public void hideCat() {
        catBox.setEnabled(false);
        catLabel.setEnabled(false);
    }
    
    public void showCat() {
        catBox.setEnabled(true);
        catLabel.setEnabled(true);
    }
    
    public void hideCato() {
        cat1Button.setEnabled(false);
        cat2Button.setEnabled(false);
        cat3Button.setEnabled(false);
    }
    
    public void showCato() {
        phraseWindow.setText("Which genre would you like to play:\n\n1 - " +
                cat1Name + "\n2 - " + cat2Name + "\n3 - " + cat3Name + "\n\n  C"
                + "LICK YOUR CHOICE\n\n                  ||\n                  "
                + "||\n                _||_\n                 \\  /\n          "
                + "        \\/");
        cat1Button.setEnabled(true);
        cat2Button.setEnabled(true);
        cat3Button.setEnabled(true);
    }
    
    public void restartGUI() throws IOException {
        try {
            endProcesses();
            dispose();
            new STWGUI().setVisible(true);
        } catch (IOException ex) {
                ex.printStackTrace();
        }
    }
    
    public String getLast(File filename) throws IOException {
        String last = new String();  
        try {
            InputStreamReader sr = new InputStreamReader(new 
                FileInputStream(filename));
            BufferedReader br = new BufferedReader(sr);
            while (br.ready()) {
                last = br.readLine();
            }
        } catch (IOException ex) {
                    ex.printStackTrace();
                }
        return last;
    }
    
    public void scoreChange(int change) {
        int score = Integer.parseInt(cscoreBox.getText());
        int newScore = score + change;
        cscoreBox.setText(String.valueOf(newScore));
        checkHigh();
    }
    
    public void checkHigh() {
        int high = Integer.parseInt(hscoreBox.getText());
        int score = Integer.parseInt(cscoreBox.getText());
        if(score > high){
            hscoreBox.setText(cscoreBox.getText());
        }
    }
    
    public void saveHigh() throws IOException {
        try {
            File hscoreFile = new File(hscorePath);
            int newHigh = Integer.parseInt(hscoreBox.getText());
            int oldHigh = Integer.parseInt(getLast(hscoreFile));

            if(newHigh > oldHigh){
                String newHighScore = String.valueOf(newHigh);
                    Files.write(Paths.get(hscorePath), ("\n" + 
                            newHighScore).getBytes(), 
                            StandardOpenOption.APPEND);
            }
            } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void saveScore() throws IOException {
        int newScore = Integer.parseInt(cscoreBox.getText());
        String finalScore = String.valueOf(newScore);
            try {
                Files.write(Paths.get(cscorePath), ("\n" + 
                        finalScore).getBytes(), StandardOpenOption.APPEND);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    public class FileReader {
        BufferedReader reader = null;
        
    public FileReader(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        FileInputStream fileStream = new FileInputStream(file);
        InputStreamReader input = new InputStreamReader(fileStream);
        reader = new BufferedReader(input);
    }
    
    public int getLineCount() throws IOException {
        int lineCount = 0;
        String data;
        while((data = reader.readLine()) != null) {
            lineCount++;
        }
        return lineCount;
    }
}
    
    public final void scoreFiles() throws IOException {
        try {
            File hscoreFile = new File(hscorePath);
            File cscoreFile = new File(cscorePath);
            sfileCheck(hscoreFile);
            sfileCheck(cscoreFile);
            hscoreBox.setText(getLast(hscoreFile));
            cscoreBox.setText(getLast(cscoreFile));
            } catch (IOException ex) {
                    ex.printStackTrace();
                }
    }
    
    public final void datFiles() throws IOException {
        try {
            File cat1File = new File(cat1Path);
            File cat2File = new File(cat2Path);
            File cat3File = new File(cat3Path);
            dfileCheck(cat1File,cat1Res);
            dfileCheck(cat2File,cat2Res);
            dfileCheck(cat3File,cat3Res);
            } catch (IOException ex) {
                    ex.printStackTrace();
                }
    }
    
    private void dfileCheck(File filename, String resource) throws IOException {
        try {
            boolean exists = filename.exists();
            if (exists == false) {
                filename.createNewFile();
                String body = new Scanner
                    (STWGUI.class.getResourceAsStream(resource)).
                        useDelimiter("\\A").next();
                try (BufferedWriter writer = new BufferedWriter(new
                FileWriter(filename))) {
                    writer.flush();
                    writer.write(body);
                    writer.close();
                hideFile(filename);
                }
            }
        } catch (IOException ex) {
                    ex.printStackTrace();
                }
    }
    
    private void sfileCheck(File filename) throws IOException {
        try{
            boolean exists = filename.exists();
            if (exists == false) {
                filename.createNewFile();
                String zero = "0";
                try (BufferedWriter writer = new BufferedWriter(new
                FileWriter(filename))) {
                    writer.flush();
                    writer.write(zero);
                    writer.close();
                }
            }
        } catch (IOException ex) {
                    ex.printStackTrace();
                }
    }
    
    private static void hideFile(File hide) {
        try {
          Process p = Runtime.getRuntime().exec("attrib +H " + hide.getPath());
          p.waitFor(); 
        } catch (IOException | InterruptedException e) {
          e.printStackTrace();
        }
      }
    
    public String catName(String catPath) throws IOException {
        String catName = "";
        try{
            catName = Files.readAllLines(Paths.get(catPath)).get(0);
            phraseWindow.append(catName);
            
        } catch (IOException ex) {
                    ex.printStackTrace();
                }
        return catName;
    }
    
    public final void customCats() throws IOException {
        try{
            customCheck(custPath1,cat1Path);
            customCheck(custPath2,cat2Path);
            customCheck(custPath3,cat3Path);
            cat1Name = catName(cat1Path);
            cat2Name = catName(cat2Path);
            cat3Name = catName(cat3Path);
        } catch (IOException ex) {
                    ex.printStackTrace();
                }
    }
    
    public void customCheck(String custPath, String origCat) throws 
            IOException {

        File filename = new File(custPath);
        boolean exists = filename.exists();
        
        if (exists == true) {
            if(origCat.equalsIgnoreCase(cat1Path)) {
                cat1Path = filename.toString();
            }
            if(origCat.equalsIgnoreCase(cat2Path)) {
                cat2Path = filename.toString();
            }
            if(origCat.equalsIgnoreCase(cat3Path)) {
                cat3Path = filename.toString();
            }
        }
    }

    public void catButton(String custPath) throws IOException, 
            InterruptedException {
        try {
        if(custPath.equalsIgnoreCase(cat1Path)) {
            setCat(cat1Name,cat1Path);
        }
        if(custPath.equalsIgnoreCase(cat2Path)) {
            setCat(cat2Name,cat2Path);
        }
        if(custPath.equalsIgnoreCase(cat3Path)) {
            setCat(cat3Name,cat3Path);
        }
        } catch (IOException ex) {
                    ex.printStackTrace();
        } catch (InterruptedException ex2) {
                    ex2.printStackTrace();
                }
    }
    
    public String getPhrase(String fileName) throws FileNotFoundException, 
            IOException {
        try {
            FileReader fileRead = new FileReader(fileName);
            Random rand = new Random();
            int randPick = rand.nextInt((fileRead.getLineCount()));
            if (randPick < 1) {
                randPick = randPick + 1;
            }
            pickedPhrase = Files.readAllLines(Paths.get(fileName)).
                    get(randPick);
        } catch (IOException ex) {
                    ex.printStackTrace();
                }
        return pickedPhrase;   
    }
    
    public void pickCat() {
        showCat();
        showCscore();
        showCato();
        rulesButton.setEnabled(false);
        newButton.setText("Start Over");
        newButton.setEnabled(false);
    }
        
    public void setCat(String catName, String catPath) throws IOException, 
            InterruptedException {
        try {
            hideCato();
            showCat();
            catBox.setText(catName);
            String phrase = getPhrase(catPath);
            startGame(phrase);
        } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (InterruptedException ex2) {
                    ex2.printStackTrace();
                }
    }
    
    public void startGame(String phrase) throws InterruptedException {
        showAlpha();
        gameBox.setIcon(new javax.swing.ImageIcon(getClass().
                getResource("/com/clarktribe/qtn/miss0.png"))); 
        newButton.setEnabled(true);
        refreshPhrase(pickedPhrase,correctGuesses);
    }
    
    public void guessingGame(char guess) throws InterruptedException {
        refreshPhrase(pickedPhrase,correctGuesses);
        lowercaseString = (pickedPhrase).toLowerCase();
        drawGallow(missCount);
        String lowercaseGuess = (String.valueOf(guess)).toLowerCase();
        if (isitHint == true) {
            correctGuesses += lowercaseGuess;
            ++correctCount;
            ++missCount;
            drawGallow(missCount);
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
            drawGallow(missCount);
            }
            guessesReq = uniqueLetterCount(pickedPhrase);
            if (correctCount == guessesReq) {
		drawGallow(missCount);
		postGame(true);
            }
            if (missCount == 5) {
		drawGallow(5);
                postGame(false);
            }
            refreshPhrase(pickedPhrase, correctGuesses);
    }
    
    public void refreshPhrase(String phrase, String correctGuesses) {
        String puzzledPhrase = phraseBlanks(phrase, correctGuesses);
        phraseWindow.setFont(new java.awt.Font("Arial Black", 1, 12));
        phraseWindow.setRows(5);
        phraseWindow.setText("\n\n\nY O U R   P H R A S E   I S :\n\n\n" +
                puzzledPhrase + "\n\n\n\nC L I C K   A   L E T T E R   B E L O "
                + "W   T O   G U E S S\n\nC L I C K   O N   H I N T   T O   U S"
                + " E   A   G U E S S   T O   R E V E A L   A    L E T T E R");
    }

    public int uniqueLetterCount(final String text) {
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
    
    public void drawGallow(int countMissed) {
        String step = String.valueOf(countMissed);
        if(step.equals("0")) {
            gameBox.setIcon(new javax.swing.ImageIcon(getClass().
            getResource("/com/clarktribe/qtn/miss0.png")));
        }
        if(step.equals("1")) {
            gameBox.setIcon(new javax.swing.ImageIcon(getClass().
            getResource("/com/clarktribe/qtn/miss1.png")));
        }
        if(step.equals("2")) {
            gameBox.setIcon(new javax.swing.ImageIcon(getClass().
            getResource("/com/clarktribe/qtn/miss2.png")));
        }
        if(step.equals("3")) {
            gameBox.setIcon(new javax.swing.ImageIcon(getClass().
            getResource("/com/clarktribe/qtn/miss3.png")));
        }
        if(step.equals("4")) {
            gameBox.setIcon(new javax.swing.ImageIcon(getClass().
            getResource("/com/clarktribe/qtn/miss4.png")));
            hintButton.setSelected(true);
            hintButton.setEnabled(false);
        }
        if(step.equals("5")) {
            gameBox.setIcon(new javax.swing.ImageIcon(getClass().
            getResource("/com/clarktribe/qtn/miss5.png")));
        }              
    }
    
    public char hintLetter(String phrase, String letters) {
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
		if (!hintOption.contains(chString) && Character.isLetter(chHint)) 
		{
			hintOption += chHint;
		}
	}
        Random randChar = new Random();
        int index = randChar.nextInt(hintOptions.length());
        char hintLetter = hintOptions.charAt(index);
	return hintLetter;
	}
    
    public String keepLetters(String fullString) {
        String[] sa = fullString.split("\\W+");
        String lettersOnly = new String();
        for(int i = 0; i < sa.length; i++) {
            lettersOnly = lettersOnly+ sa[i];
        }
        return lettersOnly;
    }
    
    public void displayHint() throws InterruptedException {
        char hintChar = hintLetter(pickedPhrase, correctGuesses);
        findButton(hintChar);
        isitHint = true;
        guessingGame(hintChar);
    }
    
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
    
    public String phraseBlanks(String phrase, String correctLetters) {
        String wordUnguessed = "";
        char ch;
        for (int index = 0; index < phrase.length(); ++index) {
            ch = Character.toLowerCase(phrase.charAt(index));
            String chString = Character.toString(ch);
            
            if (!Character.isLetter(ch)) {
                wordUnguessed += ch;
            }
            
            if (Character.isLetter(ch) && !correctLetters.contains(chString)) {
                wordUnguessed += "_";
            }
            if (Character.isLetter(ch) && correctLetters.contains(chString)) {
		wordUnguessed += phrase.charAt(index);
            }
            if (index < phrase.length() - 1) {
                wordUnguessed += " ";
            }
	}
        return wordUnguessed;
    }
        
    public void postGame(boolean wasitVictory) throws InterruptedException {
        disableAlpha();
        if (wasitVictory == true) { 
            scoreChange(1);
            TimeUnit.SECONDS.sleep(1);
            gameBox.setIcon(new javax.swing.ImageIcon(getClass().
                getResource("/com/clarktribe/qtn/youwin.png")));
        } else {
            scoreChange(-1);
            TimeUnit.SECONDS.sleep(1);
            gameBox.setIcon(new javax.swing.ImageIcon(getClass().
                getResource("/com/clarktribe/qtn/youlose.png")));
        }
        playAgain();        
    }
    
    public void playAgain() {
        phraseWindow.setText("\n\n\n\n\n\n\n C L I C K         S T A R T       "
                + "   O V E R        T O         B E G I N         A         N "
                + "E W         G A M E\n\n\n                 C L I C K         "
                + "E X I T         T O         E N D         Y O U R         S "
                + "E S S I O N");
    }
    
    private void endProcesses() throws IOException {
        try{
            checkHigh();
            saveScore();
            saveHigh();
        } catch (IOException ex) {
                    ex.printStackTrace();
                } 
    }
    
    private void flushOut() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        System.gc();
        try {
            Files.deleteIfExists(Paths.get(cscorePath));
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    
    private void exitProcesses() throws IOException, InterruptedException {
        try{
            endProcesses();
            System.gc();
            flushOut();
            System.exit(0);
        } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (InterruptedException ex2) {
                    ex2.printStackTrace();
                }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainTitle = new javax.swing.JLabel();
        gameBox = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        phraseWindow = new javax.swing.JTextArea();
        newButton = new javax.swing.JButton();
        rulesButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        cscoreLabel = new javax.swing.JLabel();
        cscoreBox = new javax.swing.JTextField();
        catLabel = new javax.swing.JLabel();
        catBox = new javax.swing.JTextField();
        hscoreLabel = new javax.swing.JLabel();
        hscoreBox = new javax.swing.JTextField();
        hintButton = new javax.swing.JToggleButton();
        usedTitle = new javax.swing.JLabel();
        cat1Button = new javax.swing.JButton();
        cat2Button = new javax.swing.JButton();
        cat3Button = new javax.swing.JButton();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Save The World");
        setResizable(false);

        mainTitle.setFont(new java.awt.Font("Stencil Std", 0, 16)); // NOI18N
        mainTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mainTitle.setText("SAVE THE WORLD");
        mainTitle.setFocusable(false);

        gameBox.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gameBox.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/clarktribe/qtn/title.png"))); // NOI18N
        gameBox.setFocusable(false);

        phraseWindow.setEditable(false);
        phraseWindow.setColumns(20);
        phraseWindow.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        phraseWindow.setLineWrap(true);
        phraseWindow.setRows(5);
        phraseWindow.setText("\n\n\n\n\n\n\n                    C L I C K          S T A R T          T O          B E G I N          G A M E\n\n\n                    C L I C K          R U L E S          F O R          I N S T R U C T I O N S");
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

        rulesButton.setText("Rules");
        rulesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rulesButtonActionPerformed(evt);
            }
        });

        exitButton.setText("Exit");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        cscoreLabel.setText("Current Score");
        cscoreLabel.setFocusable(false);

        cscoreBox.setEditable(false);
        cscoreBox.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cscoreBox.setAutoscrolls(false);
        cscoreBox.setFocusable(false);

        catLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        catLabel.setText("Category");
        catLabel.setFocusable(false);

        catBox.setEditable(false);
        catBox.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        catBox.setAutoscrolls(false);
        catBox.setFocusable(false);

        hscoreLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hscoreLabel.setText("High Score");
        hscoreLabel.setFocusable(false);

        hscoreBox.setEditable(false);
        hscoreBox.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        hscoreBox.setAutoscrolls(false);
        hscoreBox.setFocusable(false);

        hintButton.setText("Hint");
        hintButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hintButtonActionPerformed(evt);
            }
        });

        usedTitle.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        usedTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        usedTitle.setText("AVAILABLE CHARACTERS");

        cat1Button.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cat1Button.setText("Category 1");
        cat1Button.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cat1Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cat1ButtonActionPerformed(evt);
            }
        });

        cat2Button.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cat2Button.setText("Category 2");
        cat2Button.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cat2Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cat2ButtonActionPerformed(evt);
            }
        });

        cat3Button.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cat3Button.setText("Category 3");
        cat3Button.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cat3Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cat3ButtonActionPerformed(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(mainTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(hscoreBox, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(catBox))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(hscoreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(catLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(cscoreBox, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cscoreLabel))))
                            .addComponent(gameBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rulesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(newButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(cat2Button, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                                    .addComponent(cat1Button, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(cat3Button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(usedA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(usedB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(usedC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(usedD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(usedE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(usedF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(usedG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(usedH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(usedI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(usedJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(usedK, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(usedL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(usedM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(usedN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(usedO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(usedP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(usedQ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(usedR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(usedS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(usedT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(usedU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(usedV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(usedW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(usedX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(usedY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(usedZ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(usedTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hintButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(mainTitle)
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cscoreLabel)
                    .addComponent(catLabel)
                    .addComponent(hscoreLabel))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hscoreBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(catBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cscoreBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(gameBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(cat1Button)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cat2Button)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cat3Button)
                        .addGap(11, 11, 11)
                        .addComponent(rulesButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(exitButton)
                            .addComponent(newButton)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(usedTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(usedA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usedB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usedC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usedD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usedE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usedF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usedG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usedH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usedI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hintButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(usedJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usedK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usedL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usedM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usedN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usedO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usedP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usedQ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usedR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(usedS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usedT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usedU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usedV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usedW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usedX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usedY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usedZ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void hintButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hintButtonActionPerformed
        try {
            displayHint();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        hintButton.setSelected(true);
        hintButton.setEnabled(false);
    }//GEN-LAST:event_hintButtonActionPerformed

    private void rulesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rulesButtonActionPerformed
        rulesText();
    }//GEN-LAST:event_rulesButtonActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        try {
            exitProcesses();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_exitButtonActionPerformed

    private void newButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButtonActionPerformed
        String newName = newButton.getText();
        if(newName.equals("Start")) {
            pickCat();
        } else {
            try {
                restartGUI();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_newButtonActionPerformed

    private void cat1ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cat1ButtonActionPerformed
        try {
            catButton(cat1Path);
        } catch (IOException | InterruptedException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_cat1ButtonActionPerformed

    private void cat2ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cat2ButtonActionPerformed
        try {
            catButton(cat2Path);
        } catch (IOException | InterruptedException ex) {
            ex.printStackTrace();
        }                      
    }//GEN-LAST:event_cat2ButtonActionPerformed

    private void cat3ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cat3ButtonActionPerformed
        try {
            catButton(cat3Path);
        } catch (IOException | InterruptedException ex) {
            ex.printStackTrace();
        }   
    }//GEN-LAST:event_cat3ButtonActionPerformed

    private void usedAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usedAActionPerformed
        usedA.setSelected(true);
        usedA.setEnabled(false);
        try {
            guessingGame('A');
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        
    }//GEN-LAST:event_usedAActionPerformed

    private void usedBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usedBActionPerformed
        usedB.setSelected(true);
        usedB.setEnabled(false);
        try {
            guessingGame('B');
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_usedBActionPerformed

    private void usedCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usedCActionPerformed
        usedC.setSelected(true);
        usedC.setEnabled(false);
        try {
            guessingGame('C');
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_usedCActionPerformed

    private void usedDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usedDActionPerformed
        usedD.setSelected(true);
        usedD.setEnabled(false);
        try {
            guessingGame('D');
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_usedDActionPerformed

    private void usedEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usedEActionPerformed
        usedE.setSelected(true);
        usedE.setEnabled(false);
        try {
            guessingGame('E');
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_usedEActionPerformed

    private void usedFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usedFActionPerformed
        usedF.setSelected(true);
        usedF.setEnabled(false);
        try {
            guessingGame('F');
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_usedFActionPerformed

    private void usedGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usedGActionPerformed
        usedG.setSelected(true);
        usedG.setEnabled(false);
        try {
            guessingGame('G');
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_usedGActionPerformed

    private void usedHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usedHActionPerformed
        usedH.setSelected(true);
        usedH.setEnabled(false);
        try {
            guessingGame('H');
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_usedHActionPerformed

    private void usedIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usedIActionPerformed
        usedI.setSelected(true);
        usedI.setEnabled(false);
        try {
            guessingGame('I');
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_usedIActionPerformed

    private void usedJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usedJActionPerformed
        usedJ.setSelected(true);
        usedJ.setEnabled(false);
        try {
            guessingGame('J');
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_usedJActionPerformed

    private void usedKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usedKActionPerformed
        usedK.setSelected(true);
        usedK.setEnabled(false);
        try {
            guessingGame('K');
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_usedKActionPerformed

    private void usedLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usedLActionPerformed
        usedL.setSelected(true);
        usedL.setEnabled(false);
        try {
            guessingGame('L');
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_usedLActionPerformed

    private void usedMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usedMActionPerformed
        usedM.setSelected(true);
        usedM.setEnabled(false);
        try {
            guessingGame('M');
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_usedMActionPerformed

    private void usedNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usedNActionPerformed
        usedN.setSelected(true);
        usedN.setEnabled(false);
        try {
            guessingGame('N');
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_usedNActionPerformed

    private void usedOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usedOActionPerformed
        usedO.setSelected(true);
        usedO.setEnabled(false);
        try {
            guessingGame('O');
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_usedOActionPerformed

    private void usedPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usedPActionPerformed
        usedP.setSelected(true);
        usedP.setEnabled(false);
        try {
            guessingGame('P');
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_usedPActionPerformed

    private void usedQActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usedQActionPerformed
        usedQ.setSelected(true);
        usedQ.setEnabled(false);
        try {
            guessingGame('Q');
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_usedQActionPerformed

    private void usedRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usedRActionPerformed
        usedR.setSelected(true);
        usedR.setEnabled(false);
        try {
            guessingGame('R');
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_usedRActionPerformed

    private void usedSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usedSActionPerformed
        usedS.setSelected(true);
        usedS.setEnabled(false);
        try {
            guessingGame('S');
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_usedSActionPerformed

    private void usedTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usedTActionPerformed
        usedT.setSelected(true);
        usedT.setEnabled(false);
        try {
            guessingGame('T');
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_usedTActionPerformed

    private void usedUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usedUActionPerformed
        usedU.setSelected(true);
        usedU.setEnabled(false);
        try {
            guessingGame('U');
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_usedUActionPerformed

    private void usedVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usedVActionPerformed
        usedV.setSelected(true);
        usedV.setEnabled(false);
        try {
            guessingGame('V');
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_usedVActionPerformed

    private void usedWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usedWActionPerformed
        usedW.setSelected(true);
        usedW.setEnabled(false);
        try {
            guessingGame('W');
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_usedWActionPerformed

    private void usedXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usedXActionPerformed
        usedX.setSelected(true);
        usedX.setEnabled(false);
        try {
            guessingGame('X');
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_usedXActionPerformed

    private void usedYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usedYActionPerformed
        usedY.setSelected(true);
        usedY.setEnabled(false);
        try {
            guessingGame('Y');
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_usedYActionPerformed

    private void usedZActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usedZActionPerformed
        usedZ.setSelected(true);
        usedZ.setEnabled(false);
        try {
            guessingGame('Z');
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_usedZActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new STWGUI().setVisible(true);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cat1Button;
    private javax.swing.JButton cat2Button;
    private javax.swing.JButton cat3Button;
    private javax.swing.JTextField catBox;
    private javax.swing.JLabel catLabel;
    private javax.swing.JTextField cscoreBox;
    private javax.swing.JLabel cscoreLabel;
    private javax.swing.JButton exitButton;
    private javax.swing.JLabel gameBox;
    private javax.swing.JToggleButton hintButton;
    private javax.swing.JTextField hscoreBox;
    private javax.swing.JLabel hscoreLabel;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel mainTitle;
    private javax.swing.JButton newButton;
    private javax.swing.JTextArea phraseWindow;
    private javax.swing.JButton rulesButton;
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
    private javax.swing.JLabel usedTitle;
    private javax.swing.JToggleButton usedU;
    private javax.swing.JToggleButton usedV;
    private javax.swing.JToggleButton usedW;
    private javax.swing.JToggleButton usedX;
    private javax.swing.JToggleButton usedY;
    private javax.swing.JToggleButton usedZ;
    // End of variables declaration//GEN-END:variables
}