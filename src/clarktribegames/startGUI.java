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
import java.util.logging.Level;
import java.util.logging.Logger;
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
    String appVer = "0.0.006";
    String packagename = (((GameGUI.class).toString()).replaceAll("class ", ""))
            .replaceAll(".GameGUI", "");
    String playerName = "Earthling";
    int playerScore = 0;
    String defaultName = "Earthling";
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
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="GUI Launcher">
    public StartGUI() throws Exception {
        checkLibs();
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
        newMenu = new javax.swing.JMenuItem();
        heroMenu = new javax.swing.JMenuItem();
        fameMenu = new javax.swing.JMenuItem();
        settingsMenu = new javax.swing.JMenuItem();
        aboutMenu = new javax.swing.JMenuItem();
        donateMenu = new javax.swing.JMenuItem();
        exitMenu = new javax.swing.JMenuItem();

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

        newMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        newMenu.setText("Save The World");
        newMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newMenuActionPerformed(evt);
            }
        });
        optionsMenu.add(newMenu);

        heroMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        heroMenu.setText("Change Hero");
        heroMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                heroMenuActionPerformed(evt);
            }
        });
        optionsMenu.add(heroMenu);

        fameMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        fameMenu.setText("Heroes of Fame");
        fameMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fameMenuActionPerformed(evt);
            }
        });
        optionsMenu.add(fameMenu);

        settingsMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        settingsMenu.setText("Settings");
        settingsMenu.setEnabled(false);
        settingsMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settingsMenuActionPerformed(evt);
            }
        });
        optionsMenu.add(settingsMenu);

        aboutMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        aboutMenu.setText("About This Game");
        aboutMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenuActionPerformed(evt);
            }
        });
        optionsMenu.add(aboutMenu);

        donateMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        donateMenu.setText("Donate To The Cause");
        donateMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                donateMenuActionPerformed(evt);
            }
        });
        optionsMenu.add(donateMenu);

        exitMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        exitMenu.setText("Exit The Game");
        exitMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuActionPerformed(evt);
            }
        });
        optionsMenu.add(exitMenu);

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
        } catch (Exception ex) {
            try {
                logFile("severe","HOF Button Error.  Exception: " + ex);
            } catch (Exception ex1) {
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

    private void newMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newMenuActionPerformed
        try {
            startButton();
        } catch (IOException ex) {
            try {
                logFile("severe","New Game Menu Exception: " + ex.toString());
            } catch (IOException ex1) {
                ex1.printStackTrace();
            }
        }
    }//GEN-LAST:event_newMenuActionPerformed

    private void heroMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_heroMenuActionPerformed
        try {
            changeButton();
        } catch (IOException ex) {
            try {
                logFile("severe","Hero Menu Exception: " + ex.toString());
            } catch (IOException ex1) {
                ex1.printStackTrace();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_heroMenuActionPerformed

    private void fameMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fameMenuActionPerformed
        try {
            topscoreButton();
        } catch (IOException | InterruptedException ex) {
            try {
                logFile("severe","Fame Menu Exception: " + ex.toString());
            } catch (IOException ex1) {
                ex1.printStackTrace();
            }
        }
    }//GEN-LAST:event_fameMenuActionPerformed

    private void settingsMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settingsMenuActionPerformed
        settingsButton();
    }//GEN-LAST:event_settingsMenuActionPerformed

    private void aboutMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenuActionPerformed
        try {
            aboutButton();
        } catch (IOException ex) {
            try {
                logFile("severe","About Menu Exception: " + ex.toString());
            } catch (IOException ex1) {
                ex1.printStackTrace();
            }
        }
    }//GEN-LAST:event_aboutMenuActionPerformed

    private void donateMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_donateMenuActionPerformed
        try {
            donateButton();
        } catch (IOException ex) {
            try {
                logFile("severe","Donate Menu Exception: " + ex.toString());
            } catch (IOException ex1) {
                ex1.printStackTrace();
            }
        }
    }//GEN-LAST:event_donateMenuActionPerformed

    private void exitMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuActionPerformed
        exitButton();
    }//GEN-LAST:event_exitMenuActionPerformed

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
            setPlayer(getPlayerinfo(0));
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
            new ChecksBalances().newdirCheck("./" + customDir, true);
            new ChecksBalances().newdirCheck(dataPath, true);
            new ChecksBalances().newfileCheck(lastusedPath, true, defaultName + 
                ",0\n",true);
            new ChecksBalances().newfileCheck(playersPath, true, defaultName + 
                ",0",true);
            new ChecksBalances().checkforBlanks(playersPath, true);
            gettopScores(false);
            defaultquotesFile(dataPath,"quotes");
        } catch(Exception ex) {
            logFile("severe",("Saves Check Exception: " + ex.toString()));
        }
    }
    
    private void checkLibs() throws IOException {
        try {
            boolean result = (new LibImport().libImport());
            if(!result) {
                JOptionPane.showMessageDialog(null,"Initializing Default Databa"
                        + "se.\n\nPlease restart the game.","Alert!",JOptionPane
                        .WARNING_MESSAGE);
                exitProcess();
            }
        } catch(IOException ex) {
            logFile("severe",("checkLib IOException: " + ex.toString()));
        }
    }
    
    private void defaultquotesFile(String path,String root) throws IOException {
        File quotesfile = new File((path + root) + ".dat");
        try {
            if (!quotesfile.exists()) {
                new Unzipper().unzip(root + ".cmp",path,true);
            }
        } catch(IOException ex) {
            logFile("severe",("Quotes File Exception: " + ex.toString()));
        }
    }
    
    public String getPlayerinfo(int type) throws IOException {
        File filename = new File(lastusedPath);
        try {
            playerName = new ChecksBalances().getLast(filename);
        } catch(IOException ex) {
            logFile("severe",("Retrieve Player IOException: " + ex.toString()));
        }
        String playerScorestr = (playerName.substring(playerName.indexOf(",") +1
                ,playerName.length()));
        playerName = playerName.substring(0, playerName.indexOf(','));
        if(type == 1) {
            return playerScorestr;
        }
        return playerName;
    }
        
    private void setPlayer(String name) throws IOException {
        nameLabel.setText("<Current Hero: " + name + ">");
        playerScore = Integer.parseInt(getPlayerinfo(1));
    }
    
    private void buildPlayers() throws IOException, Exception {
        String playerString = "";
        try {
            playerString = playerPopup();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,"You decided not to give a name."
                    + "..  So we will just go with " + defaultName + ".");
            reverttoDefault();
        }
        if(playerString.equals("_+_+_")) {
            System.gc();
            resetGUI();
        } else {
            if(!playerString.equals("_-_-_")) {

            playerName = playerString.substring(0, playerString.indexOf(','));
            playerScore = Integer.parseInt(playerString.substring(playerString
                    .indexOf(',') + 1,playerString.length()));
            resetLastUsed(playerName,playerScore);
            }
        }
    }
    
    private void resetLastUsed(String name, int score) throws IOException, 
            Exception {
        try {
            cleanUp();
            ChecksBalances.ifexistDelete(lastusedPath);
            new ChecksBalances().newfileCheck(lastusedPath, true, (name + "," +
                    score),true);
            resetGUI();
        } catch (Exception ex) {
            logFile("severe",("Reset LU Exception: " + ex.toString()));
        }
    }
    
    private String deletePlayer(String player) throws IOException {
        List<String> tlist = new Converters().filelistToList(("./"+playersPath),
                "\n");
        List<String> newlist = new ChecksBalances().deletePlayer(tlist,player);
        return new Converters().listtoString(newlist);
    }
    
    private String playerPopup() throws IOException, Exception {
        JComboBox playerPoplist = new JComboBox();
        String selectedPlayer = defaultName;
        String path = "./" + playersPath;
        String delim = "\n";
        String[] options = new String[] {"Select Hero", "Create New Hero", "Del"
                + "ete Hero"};
        comboMaker(new Converters().filelistToList(path,delim),playerPoplist,0
        );
        int newheroChoice = JOptionPane.showOptionDialog(null,playerPoplist,"Yo"
            + "ur New Hero",JOptionPane.DEFAULT_OPTION,JOptionPane.PLAIN_MESSAGE
            ,null,options, options[0]);
            int index = playerPoplist.getSelectedIndex();
        if(newheroChoice == 0) {
            String playername = (playerPoplist.getItemAt(index)).toString();
            selectedPlayer = listitemFinder(new Converters().filelistToList(path
                    ,delim),playername);
            } else {
                if(newheroChoice == 1) {
                    if(!newplayerPopup(new Converters().filelistToList(path,delim)))
                    {
                        selectedPlayer = listitemFinder(new Converters()
                            .filelistToList(path,delim),defaultName);
                    } else {
                        selectedPlayer = listitemFinder(new Converters()
                            .filelistToList(path,delim),playerName);
                    }
                } if(newheroChoice == 2) {
                    if((playerPoplist.getSelectedItem().toString()).equals(defaultName)) 
                    {
                        plainpopupBox(defaultName + " is immortal",defaultName + " cann"
                            + "ot be deleted!");
                        selectedPlayer = "_+_+_";
                    } else {
                        String playername = (playerPoplist.getItemAt(index)).toString();
                        selectedPlayer = listitemFinder(new Converters().filelistToList(
                                path,delim),playername);
                        String byebyePlayer = selectedPlayer.substring(0, selectedPlayer.indexOf(","));
                        boolean deleteChoice = yesorNo("Are you sure you want to delete " + 
                            byebyePlayer + " from the game?","Delete " + byebyePlayer);
                        if(deleteChoice == true) {
                            String listwithdelete = deletePlayer(selectedPlayer);
                            System.gc();
                            ChecksBalances.ifexistDelete(playersPath);
                            new ChecksBalances().newfileCheck(playersPath, true,
                                listwithdelete,true);
                            plainpopupBox(byebyePlayer + " is Deleted!",byebyePlayer + " is gone forever!\n\nYou are now " + defaultName);
                            reverttoDefault();
                            selectedPlayer = "_-_-_";
                        } else {
                            selectedPlayer = "_+_+_";
                        }
                    }
                } else {
                    selectedPlayer = "_+_+_";
                }
            }
        return selectedPlayer;
    }
    
    private void reverttoDefault() throws IOException, Exception {
        String path = "./" + playersPath;
        String delim = "\n";
        String playerString = listitemFinder(new Converters()
            .filelistToList(path,delim),defaultName);
        playerName = playerString.substring(0, playerString.indexOf(','));
        playerScore = Integer.parseInt(playerString.substring(playerString
            .indexOf(',') + 1,playerString.length()));
            resetLastUsed(playerName,playerScore);
    }
    
    private boolean newplayerPopup(List<String> list) throws IOException {        
        String s = (String)JOptionPane.showInputDialog(null,"Enter New Hero Nam"
                + "e\n\n**No Special Characters or Spaces please**\n ","Create "
                + "a New Hero",JOptionPane.PLAIN_MESSAGE,null,null,null);
        if (s.equals(defaultName)) {
            JOptionPane.showMessageDialog(null,"You are a special kind of being"
                    + " to just want to be the default " + defaultName + ".");
            return false;
        } else {
            if ((s.isEmpty() || s == (null) || s.length() <= 0)) {
                JOptionPane.showMessageDialog(null,"You decided not to give a n"
                        + "ame...  So we will just go with "+defaultName+".");
                return false;
            } else {
                boolean invalidChars = new ChecksBalances().nameCheck(list,s,0);
                if (invalidChars) {
                    JOptionPane.showMessageDialog(null,"Since you decided to us"
                            + "e special characters, we will just go with " +
                            defaultName + ".");
                    return false;
                } else {
                    boolean pExists = new ChecksBalances().nameCheck(list,s,1);
                    if (pExists) {
                        JOptionPane.showMessageDialog(null,"That name already e"
                                + "xists, so we will just go with " + 
                                defaultName + ".");
                        return false;
                    } else {
                        Files.write(Paths.get(playersPath), ("\n" + s + ",0").
                                getBytes(), StandardOpenOption.APPEND);
                        playerName = s;

                        return true;
                    }
                }
            }
        }
    }

    private void comboMaker(List<String> list,JComboBox dropdown,int type) {
            DefaultComboBoxModel dml= new DefaultComboBoxModel();
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
    
    private void gettopScores(boolean showPopup) throws IOException, 
            InterruptedException {
        try {
            String path = "./" + playersPath;
            String delim = "\n";
            String highpath = "data/High.dat";
            List playerlist = (new Converters().filelistToList(path,delim));
            String imported = String.join(";", playerlist);
            String[] arrayed = imported.split(";");
            StringBuilder first = new StringBuilder();
            for(int i = 0; i <arrayed.length; i++) {
                first.append(arrayed[i].substring(arrayed[i].indexOf(",")+1,
                    arrayed[i].length())).append("-").append(arrayed[i]
                    .substring(0,(arrayed[i].indexOf(",")))).append(delim);
            }
            String unsorted = first.toString();
            String sorted = Arrays.stream(unsorted.split(delim))
                .map(String::valueOf).sorted().collect(Collectors
                .joining(delim));
            String[] newarray = sorted.split(delim);
            List<String> newlist = Arrays.asList(newarray);
            Collections.reverse(newlist);
            String ordered = String.join(";", newlist);
            String[] lastarray = ordered.split(";");
            StringBuilder second = new StringBuilder();
            int topNo = 5;
            String highscoreString = "";
            if(lastarray.length < 5) {
                for(int i = 0; i < lastarray.length; i++) {
                    second.append(lastarray[i].substring(lastarray[i]
                    .indexOf("-")+1,lastarray[i].length())).append(" (")
                    .append(lastarray[i].substring(0,lastarray[i].indexOf("-")))
                    .append(")").append(delim);
                    if(i==0) {
                        ChecksBalances.ifexistDelete(highpath);
                        highscoreString = ((second.toString()).replaceAll(" \\("
                            + "", ",")).replaceAll("\\)","");
                        new ChecksBalances().newfileCheck(highpath, true, 
                            highscoreString.toString(),true);
                    }
            }
                topNo = lastarray.length;
            } else {
                for(int i = 0; i < 5; i++) {
                    second.append(lastarray[i].substring(lastarray[i]
                    .indexOf("-")+1,lastarray[i].length())).append(" (")
                    .append(lastarray[i].substring(0,lastarray[i].indexOf("-")))
                    .append(")").append(delim);
                    if(i==0) {
                        ChecksBalances.ifexistDelete(highpath);
                        highscoreString = ((second.toString()).replaceAll(" //("
                            + "", ",")).replaceAll("//)","");
                        new ChecksBalances().newfileCheck(highpath, true, 
                            highscoreString.toString(),true);
                    }
                }
            }
            String finalList = second.toString();
            String top = ("Top " + topNo + " Heroes:");
            if(topNo <= 1) {
                top = "The Only Hero:";
            }
            if(showPopup == true) {
                String title = "The Heroes of Fame";
                String message = top + "\n\n" + finalList;
                plainpopupBox(title,message);
            }
        } catch (IOException | InterruptedException ex) {
        logFile("severe","Get HOF Error.  Exception: " + ex);
        }
    }
    
    private void plainpopupBox(String title, String txt) {
        JOptionPane.showMessageDialog(null,txt,title,JOptionPane.PLAIN_MESSAGE);
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

    private void topscoreButton() throws IOException, InterruptedException {
        try {
            gettopScores(true);
        } catch (Exception ex) {
            logFile("severe","HOF Button Error.  Exception: " + ex);
        }
    }
    
    private void settingsButton() {
        //future settings options go here
    }

    public void aboutButton() throws IOException {
        try {
            aboutPopup();
        } catch(IOException ex) {
            logFile("severe","About Button Error.  Exception: " + ex);
        }
    }

    public void donateButton() throws IOException {
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
    private javax.swing.JMenuItem aboutMenu;
    private javax.swing.JButton changeButton;
    private javax.swing.JButton donateButton;
    private javax.swing.JMenuItem donateMenu;
    private javax.swing.JButton exitButton;
    private javax.swing.JMenuItem exitMenu;
    private javax.swing.JMenuItem fameMenu;
    private javax.swing.JMenuItem heroMenu;
    private javax.swing.JLabel mainLogo;
    private javax.swing.JMenuBar mainMenu;
    private javax.swing.JTextArea mainText;
    private javax.swing.JLabel mainTitle;
    private javax.swing.JScrollPane maintextPane;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JMenuItem newMenu;
    private javax.swing.JMenu optionsMenu;
    private javax.swing.JMenuItem settingsMenu;
    private javax.swing.JButton startButton;
    private javax.swing.JButton topscoreButton;
    // End of variables declaration//GEN-END:variables
}
//</editor-fold>