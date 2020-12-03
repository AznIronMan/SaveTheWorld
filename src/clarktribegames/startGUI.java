// <editor-fold defaultstate="collapsed" desc="Header and Credits">
package clarktribegames;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;


/**
 * 
 * @author  Geoff Clark
 * @e-mail  info@clarktribegames.com
 * @game    Save The World
 * 
 */

public class StartGUI extends javax.swing.JFrame {
// </editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Initial Variables">
    String appName = "Save The World";
    String appVer = "0.0.004";
    String packagename = (((GameGUI.class).toString()).replaceAll("class ", ""))
            .replaceAll(".STWGUI", "");
    String playerName = "Earthling";
    int playerScore = 0;
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="GUI Launcher">
    public StartGUI() throws Exception {
        initComponents();
        setLocationRelativeTo(null);
        startupChecks();
        messageBox();
        //reminder : add options menu stuff
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Swing Code">
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nameLabel = new javax.swing.JLabel();
        mainTitle = new javax.swing.JLabel();
        mainLogo = new javax.swing.JLabel();
        maintextPane = new javax.swing.JScrollPane();
        mainText = new javax.swing.JTextArea();
        startButton = new javax.swing.JButton();
        changeButton = new javax.swing.JButton();
        topscoreButton = new javax.swing.JButton();
        aboutButton = new javax.swing.JButton();
        donateButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        mainMenu = new javax.swing.JMenuBar();
        optionsMenu = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(appName + " [ALPHA v" + appVer + "]");
        setBackground(new java.awt.Color(0, 0, 0));
        setFont(new java.awt.Font("Lucida Console", 1, 12)); // NOI18N
        setMinimumSize(new java.awt.Dimension(600, 800));
        setName("startFrame"); // NOI18N
        setResizable(false);
        setSize(new java.awt.Dimension(600, 800));

        nameLabel.setFont(new java.awt.Font("Lucida Console", 1, 12)); // NOI18N
        nameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nameLabel.setText("<Current Hero Name>");

        mainTitle.setFont(new java.awt.Font("Stencil Std", 0, 16)); // NOI18N
        mainTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mainTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clarktribegames/header.png"))); // NOI18N
        mainTitle.setFocusable(false);

        mainLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mainLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clarktribegames/title.png"))); // NOI18N
        mainLogo.setFocusable(false);

        mainText.setEditable(false);
        mainText.setColumns(20);
        mainText.setFont(new java.awt.Font("Lucida Console", 1, 12)); // NOI18N
        mainText.setLineWrap(true);
        mainText.setRows(2);
        mainText.setWrapStyleWord(true);
        mainText.setAutoscrolls(false);
        mainText.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        mainText.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        mainText.setEnabled(false);
        mainText.setFocusable(false);
        mainText.setHighlighter(null);
        mainText.setMargin(new java.awt.Insets(0, 0, 0, 0));
        maintextPane.setViewportView(mainText);

        startButton.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        startButton.setText("Save The World");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        changeButton.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        changeButton.setText("Change Hero");
        changeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeButtonActionPerformed(evt);
            }
        });

        topscoreButton.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        topscoreButton.setText("Heroes Of Fame");
        topscoreButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                topscoreButtonActionPerformed(evt);
            }
        });

        aboutButton.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        aboutButton.setText("About This Game");
        aboutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutButtonActionPerformed(evt);
            }
        });

        donateButton.setBackground(new java.awt.Color(255, 0, 0));
        donateButton.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        donateButton.setForeground(new java.awt.Color(255, 0, 0));
        donateButton.setText("Donate To The Cause");
        donateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                donateButtonActionPerformed(evt);
            }
        });

        exitButton.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        exitButton.setText("Exit");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        optionsMenu.setText("Options");
        mainMenu.add(optionsMenu);

        setJMenuBar(mainMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(212, 212, 212)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(exitButton, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                    .addComponent(donateButton, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                    .addComponent(aboutButton, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                    .addComponent(topscoreButton, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                    .addComponent(changeButton, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                    .addComponent(startButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(212, 212, 212))
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(mainTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                    .addComponent(mainLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(maintextPane)
                    .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(100, 100, 100))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addComponent(mainTitle)
                .addGap(6, 6, 6)
                .addComponent(mainLogo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(maintextPane, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(changeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(topscoreButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(aboutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(donateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        try {
            startButton();
        } catch (IOException ex) {
            try {
                logFile("severe","New Button Error.  Exception: " + ex);
            } catch (IOException ex1) {
                ex1.printStackTrace();
            }
        }
    }//GEN-LAST:event_startButtonActionPerformed

    private void changeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeButtonActionPerformed
        try {
            changeButton();
        } catch (IOException ex) {
            try {
                logFile("severe","Change Button Error.  Exception: " + ex);
            } catch (IOException ex1) {
                ex1.printStackTrace();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_changeButtonActionPerformed

    private void topscoreButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_topscoreButtonActionPerformed
        try {
            topscoreButton();
        } catch (IOException ex) {
            try {
                logFile("severe","HOF Button Error.  Exception: " + ex);
            } catch (IOException ex1) {
                ex1.printStackTrace();
            }
        }
    }//GEN-LAST:event_topscoreButtonActionPerformed

    private void aboutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutButtonActionPerformed
        try {
            aboutButton();
        } catch (IOException ex) {
            try {
                logFile("severe","About Button Error.  Exception: " + ex);
            } catch (IOException ex1) {
                ex1.printStackTrace();
            }
        }
    }//GEN-LAST:event_aboutButtonActionPerformed

    private void donateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_donateButtonActionPerformed
        try {
            donateButton();
        } catch (IOException ex) {
            try {
                logFile("severe","Donate Button Error.  Exception: " + ex);
            } catch (IOException ex1) {
                ex1.printStackTrace();
            }
        }
    }//GEN-LAST:event_donateButtonActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        exitButton();
    }//GEN-LAST:event_exitButtonActionPerformed

    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Main Launch Method">
    public static void main(String args[]) throws IOException {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : 
                    javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | 
                IllegalAccessException | 
                javax.swing.UnsupportedLookAndFeelException ex) {
            logFile("severe","Start Main Error.\nEx:" + ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new StartGUI().setVisible(true);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Main Menu Methods">
    private void startupChecks() throws Exception {
        try {
            checkVersion(appName,appName.replaceAll(" ",""),appVer);
            checkFiles();
            setPlayer(getPlayer());
            } catch(Exception ex) {
                logFile("severe",("Startup Check Exception: " + ex.toString()));
            }
        
    }
    
    private static void checkVersion (String name, String filename, String ver) 
            throws IOException {
        boolean needUpdate = new verCheck().checkVersion(filename, ver);
        if(needUpdate == true)
            new Updater().updateMessage(name, ver);
    }    
    
    private void checkFiles() throws IOException, Exception {
        try {
            ChecksBalances.ifexistDelete("data/Score.dat");
            new ChecksBalances().newdirCheck("./phrases/", false);
            new ChecksBalances().newdirCheck("./data/", true);
            new ChecksBalances().newfileCheck("data/.lastused", true, "Earthlin"
                    + "g,0\n");
            new ChecksBalances().newfileCheck("data/Players.dat", true, "Earthl"
                    + "ing,0\n");
            new ChecksBalances().newfileCheck("data/Score.dat", true, "Earthlin"
                    + "g,0\n"
                    + "");
            new ChecksBalances().newfileCheck("data/High.dat", true, "");
            defaultquotesFile("./data/","quotes");
        } catch(Exception ex) {
            logFile("severe",("Saves Check Exception: " + ex.toString()));
        }
    }
    
    private void defaultquotesFile(String path,String root) throws IOException {
        File quotesfile = new File((path + root) + ".dat");
        try {
            if (!quotesfile.exists()) {
                new Unzipper().unzip(root + ".zip",path,true);
            }
        } catch(IOException ex) {
            logFile("severe",("Quotes File Exception: " + ex.toString()));
        }
    }
    
    public String getPlayer() throws IOException {
        File filename = new File("data/.lastused");
        try {
            playerName = new ChecksBalances().getLast(filename);
            
        } catch(IOException ex) {
            logFile("severe",("Retrieve Player IOException: " + ex.toString()));
        }
        playerName = playerName.substring(0, playerName.indexOf(','));
        return playerName;
    }
    
    private void setPlayer(String name) {
        nameLabel.setText("<Current Hero: " + name + ">");
    }
    
    private void buildPlayers() throws IOException, Exception {
        try {
            String playerString = playerPopup();
            playerName = playerString.substring(0, playerString.indexOf(','));
            playerScore = Integer.parseInt(playerString.substring(playerString
                    .indexOf(',') +1,playerString.length()));
            resetLastUsed(playerName,playerScore);
        } catch (Exception ex) {
            logFile("severe",("Build Player IOException: " + ex.toString()));
        }
    }
    
    private void resetLastUsed(String name, int score) throws IOException, 
            Exception {
        try {
            cleanUp();
            ChecksBalances.ifexistDelete("data/.lastused");
            new ChecksBalances().newfileCheck("data/.lastused", true, (name + ""
                    + "," +score));
            resetGUI();
        } catch (Exception ex) {
            logFile("severe",("Reset LU Exception: " + ex.toString()));
        }
    }
    
    private String playerPopup() throws IOException {
        JComboBox playerPoplist = new JComboBox();
        String selectedPlayer = "Earthling";
        String path = "./data/Players.dat";
        String delim = "\n";
        comboMaker(new Converters().filelistToList(path,delim),playerPoplist,0
        );
        JOptionPane.showMessageDialog(null, playerPoplist, "Your New Hero",
                JOptionPane.QUESTION_MESSAGE);
        int index = playerPoplist.getSelectedIndex();
        if(index == 0) {
            if(!newplayerPopup(new Converters().filelistToList(path,delim))) {
                selectedPlayer = listitemFinder(new Converters().filelistToList(
                path,delim),"Earthling");
            } else {
                selectedPlayer = listitemFinder(new Converters().filelistToList(
                path,delim),playerName);
            }
        } else {
            String playername = (playerPoplist.getItemAt(index)).toString();
            selectedPlayer = listitemFinder(new Converters().filelistToList(
                path,delim),playername);
        }
        return selectedPlayer;
    }
    
    private boolean newplayerPopup(List<String> list) throws IOException {        
        String s = (String)JOptionPane.showInputDialog(null,"Enter New Hero Nam"
                + "e\n\n**No Special Characters or Spaces please**\n ","Create "
                + "a New Hero",JOptionPane.PLAIN_MESSAGE,null,null,null);
        if (s.equals("Earthling")) {
            JOptionPane.showMessageDialog(null,"You are a special kind of being"
                    + " to just want to be the default Earthling.");
            return false;
        } else {
            if ((s != null) && (s.length() > 0)) {
                boolean invalidChars = new ChecksBalances().nameCheck(list,s,0);
                if (invalidChars) {
                    JOptionPane.showMessageDialog(null,"Since you decided to us"
                            + "e special characters, we will just got with Eart"
                            + "hling.");
                    return false;
                } else {
                    boolean pExists = new ChecksBalances().nameCheck(list,s,1);
                    if (pExists) {
                        JOptionPane.showMessageDialog(null,"That name already e"
                                + "xists, so we will just go with Earthling.");
                        return false;
                    } else {
                        Files.write(Paths.get("data/Players.dat"), ("\n" + s + 
                                ",0").getBytes(), StandardOpenOption.APPEND);
                        playerName = s;
                        return true;
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null,"You decided not to give a n"
                        + "ame...  So we will just go with Earthling.");
                return false;
            }
        }
    }

    private void comboMaker(List<String> list,JComboBox dropdown,int type) {
            DefaultComboBoxModel dml= new DefaultComboBoxModel();
            dml.addElement("<Create New>");
            Collections.sort(list);
            for (int i=0; i < list.size(); i++ ) {
                String listitem = (list.get(i));
                String item;
                if(type==0) {
                    item = listitem.substring(0, listitem.indexOf(','));
                } else {
                    if(type == 1) {
                        item = listitem.substring((list.indexOf(',') + 1),
                                (list.size()));
                    } else {
                        item = listitem;
                    }
                }
                dml.addElement(item);
                dropdown.setModel(dml);
            }
        }
    
    private String listitemFinder(List<String> list,String search) {
            List<String> result = new ArrayList<>();
            for (String s : list) {
                if (s.contains(search)) {
                    result.add(s);
                }
            }
            String finalString = (result.toString());
            return (finalString.substring(1,finalString.length() -1));
        }
    
    private void hofPopup() throws IOException {
        String path = "./data/Players.dat";
        String delim = "\n";
        List playerlist = (new Converters().filelistToList(path,delim));
        String imported = String.join(";", playerlist);
        String[] arrayed = imported.split(";");
        StringBuilder first = new StringBuilder();
        for(int i = 0; i <arrayed.length; i++) {
            first.append(arrayed[i].substring(arrayed[i].indexOf(",")+1,
                arrayed[i].length())).append("-").append(arrayed[i].substring(0,
                (arrayed[i].indexOf(",")))).append("\n");
        }
        String unsorted = first.toString();
        String sorted = Arrays.stream(unsorted.split("\n")).map(String::valueOf)
            .sorted().collect(Collectors.joining("\n"));
        String[] newarray = sorted.split("\n");
        List<String> newlist = Arrays.asList(newarray);
        Collections.reverse(newlist);
        String ordered = String.join(";", newlist);
        String[] lastarray = ordered.split(";");
        StringBuilder second = new StringBuilder();
        int topNo = 5;
        if(lastarray.length < 5) {
            for(int i = 0; i < lastarray.length; i++) {
                second.append(lastarray[i].substring(lastarray[i].indexOf("-")+1
                    ,lastarray[i].length())).append(" (").append(lastarray[i].
                    substring(0,lastarray[i].indexOf("-"))).append(")\n");                
        }
            topNo = lastarray.length;
        } else {
            for(int i = 0; i < 5; i++) {
                second.append(lastarray[i].substring(lastarray[i].indexOf("-")+1
                    ,lastarray[i].length())).append(" (").append(lastarray[i].
                    substring(0,lastarray[i].indexOf("-"))).append(")\n");
            }
        }
        String finalList = second.toString();
        String top = ("Top " + topNo + " Heroes:");
        if(topNo <= 1) {
            top = "The Only Hero:";
        }
        
        
        JOptionPane.showMessageDialog(null, top + "\n\n" + finalList, "The Hero"
                + "es of Fame",JOptionPane.PLAIN_MESSAGE);
    }
    
    private void messageBox() throws IOException {
        new TypeEffect(mainText,greetingSelector("greets.dat") + ", " + 
                playerName + ".\n\n" + "Are you ready to Save the World...  ?")
                .start();
    }

    private String greetingSelector(String source) throws IOException {
        List<String> list = new Converters().resourcefileToList(source);
        String finalstring = list.get((new Random()).nextInt(list.size()));
        return (new Converters().capFirstLetter(finalstring));
    }    
   
    //</editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Button Methods">
    private void startButton() throws IOException {
        try {
            cleanUp();
            new GameGUI().setVisible(true);
        } catch(Exception ex) {
            logFile("severe","New Button Error.  Exception: " + ex);
        }
    }

    private void changeButton() throws IOException, Exception {
        try {
            buildPlayers();
        } catch(Exception ex) {
            logFile("severe","Change Button Error.  IOException: " + ex);
        }
    }

    private void topscoreButton() throws IOException {
        try {
            hofPopup();
        } catch (IOException ex) {
            logFile("severe","HOF Button Error.  Exception: " + ex);
        }
    }

    private void aboutButton() throws IOException {
        try {
            aboutPopup();
        } catch(IOException ex) {
            logFile("severe","About Button Error.  Exception: " + ex);
        }
    }

    private void donateButton() throws IOException {
        try {
            donatePopup();
        } catch(IOException ex) {
            logFile("severe","Donate Button Error.  Exception: " + ex);
        }
    }
    
    private void exitButton() {
        boolean exitChoice = yesorNo("Are you sure you want to exit?","Exit the"
                + " Game?");
        if(exitChoice == true)
            exitProcess();
    }
    //</editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Popup Methods">
    private void aboutPopup() throws IOException {
        try {
            String[] options = new String[] {"Facebook","Discord","YouTube","OK"
                    };
            String message = ("<html>This application was created by ClarkTribe"
                    + "Games.<br><br>The original concept was a class assignmen"
                    + "t of the creator.<br>After the class, it was decided to "
                    + "turn it into a free game<br>for distribution.<br><br>Ple"
                    + "ase consider supporting the cause with a donation<br>via"
                    + " the <font color=red><b>Donate To The Cause</b></font> b"
                    + "utton.<br><br>Thank you for your continued support!<br><"
                    + "br>- Geoff @ ClarkTribeGames<br><br></html>");
            int aboutChoice = popupResponse(options, "About This Game",message);

            switch(aboutChoice) {
                case 0:
                    openWeb("https://www.facebook.com/clarktribe.games");
                    break;
                case 1:
                    openWeb("https://discord.gg/6kW4der");
                    break;
                case 2:
                    openWeb("https://www.youtube.com/channel/UCjcPw3ApuFduiETId"
                            + "mAhFAQ");
                    break;
                default:
                    break;
            }
        } catch(IOException ex) {
            logFile("severe","About Popup Error.  Exception: " + ex);
        }
    }
    
    private void donatePopup() throws IOException {
        try {
            String[] options = new String[] {"Patreon","PayPal","Maybe Later"};
            String message = ("<html><b>This application was created by ClarkTr"
                    + "ibeGames.</b><br><br>If you found this game fun and/or w"
                    + "ant to help with the<br>development of this game, please"
                    + " consider a donation,<br>even if it is $1 to keep projec"
                    + "ts like this alive.\n\nThank you! - Geoff @ ClarkTribeGa"
                    + "mes");
        int donateChoice = popupResponse(options, "Please Donate. :)", message);
        switch(donateChoice) {
            case 0:
                openWeb("https://www.patreon.com/clarktribegames");
                break;
            case 1:
                openWeb("https://www.paypal.me/aznblusuazn");
                break;
            default:
                break;
            }
        } catch(IOException ex) {
            logFile("severe","Donate Popup Error.  Exception: " + ex);
        }
    }
    
    private void openWeb(String website) throws IOException {
        String command = "rundll32 url.dll,FileProtocolHandler " + website;
            try {
                Process p = Runtime.getRuntime().exec(command);
            } catch (IOException ex) {
                logFile("severe",("Cannot access website.  " + ex.toString()));
            }
    }
    
    private int popupResponse(String[] options, String title, String message) {
        int response = JOptionPane.showOptionDialog(null, message, title, 
                JOptionPane.DEFAULT_OPTION, JOptionPane.
                PLAIN_MESSAGE,null, options, options[0]);
        return response;
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
    //</editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="CleanUp and Exit Methods">   
    private void cleanUp() {
        System.gc();
        dispose();
    }
    
    public void resetGUI() throws Exception {
        cleanUp();
        try {
            new StartGUI().setVisible(true);
        } catch (Exception ex) {
            logFile("severe","Reset GUI Exception:" + ex);
        }
    }
    
    private void exitProcess() {
        cleanUp();
        System.exit(0);
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Log File Method">
    private static void logFile (String type, String loginfo) throws IOException
    {
        try {
            new LogWriter().writeLog(type,loginfo);
        } catch(IOException ioex) {
            logFile("severe","logFile cannot fine log file (infinite loop)!");
        }
    }
    //</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Footer">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aboutButton;
    private javax.swing.JButton changeButton;
    private javax.swing.JButton donateButton;
    private javax.swing.JButton exitButton;
    private javax.swing.JLabel mainLogo;
    private javax.swing.JMenuBar mainMenu;
    private javax.swing.JTextArea mainText;
    private javax.swing.JLabel mainTitle;
    private javax.swing.JScrollPane maintextPane;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JMenu optionsMenu;
    private javax.swing.JButton startButton;
    private javax.swing.JButton topscoreButton;
    // End of variables declaration//GEN-END:variables
}
//</editor-fold>