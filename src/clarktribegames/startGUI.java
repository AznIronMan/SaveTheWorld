// <editor-fold defaultstate="collapsed" desc="Header and Credits">
package clarktribegames;

import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 * 
 * @author  Geoff Clark
 * @e-mail  info@clarktribegames.com
 * @game    Save The World
 * 
 */

public class startGUI extends javax.swing.JFrame {
// </editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Initial Variables">
    String appName = "Save The World";
    String appVer = "0.0.003";
    String packagename = (((GameGUI.class).toString()).replaceAll("class ", "")).
            replaceAll(".STWGUI", "");
    String playerName = "Earthling";
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="GUI Launcher">
    public startGUI() throws Exception {
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
        setMaximumSize(new java.awt.Dimension(600, 800));
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
        changeButton();
    }//GEN-LAST:event_changeButtonActionPerformed

    private void topscoreButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_topscoreButtonActionPerformed
        topscoreButton();
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
                    new startGUI().setVisible(true);
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
            FileCheck.ifexistDelete("data/Score.dat");
            new FileCheck().newdirCheck("./phrases/", false);
            new FileCheck().newdirCheck("./data/", true);
            new FileCheck().fileCheck("greets.dat","data/greets.dat",true,true);
            new FileCheck().fileCheck("default.dat","data/default.dat",true,
                    true);
            new FileCheck().newfileCheck("data/.lastused", true, "Earthling\n");
            new FileCheck().newfileCheck("data/Score.dat", true, "");
            new FileCheck().newfileCheck("data/HOF.dat", true, "Earthling,0\n");
        } catch(Exception ex) {
            logFile("severe",("Saves Check Exception: " + ex.toString()));
        }
    }
    
    public String getPlayer() throws IOException {
        File filename = new File("data/.lastused");
        try {
            playerName = new FileCheck().getLast(filename);
            
        } catch(IOException ex) {
            logFile("severe",("Retrieve Player IOException: " + ex.toString()));
        }
        return playerName;
    }
    
    private void setPlayer(String name) {
        nameLabel.setText("<Current Hero: " + name + ">");
    }
    
    private void messageBox() {
        new TypeEffect(mainText,greetingSelector() + ", " + playerName + ".\n\n"
                + "Are you ready to Save the World...  ?").start();
    }

    private String greetingSelector() {
        //add randomizer with dictionary of greetings file
        //need to build greets.dat
        return "Hello";
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

    private void changeButton() {
        //popup GUI for switching to existing player name
    }

    private void topscoreButton() {
        //popup (no decoration) to pull from HOF and list top 5 scores in order
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
    
    private void exitProcess() {
        cleanUp();
        System.exit(0);
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