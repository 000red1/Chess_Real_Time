import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.geom.*;
import java.io.*;

/**
 * This class contains the main program of the file. It contains the JElements of the programs, such as the frame, buttons, labels etc.
 * 
 * @author John Amalraj
 * @author Thomas Aryawan
 * @author Jakob Bruhn
 * @see ChessPaneView
 * @see ChessModel 
 * @version 1.0
 */


public class Controller implements MouseListener, MouseMotionListener, ActionListener, KeyListener{
  //Properties
  JFrame frame = new JFrame("Real Time Chess V1.0");
  ChessPaneView panel = new ChessPaneView();
  ChessModel model = new ChessModel(); 
  Timer time = new Timer(1000/60,this);
    
  //Main Menu
  JButton clientButton = new JButton("Play as White");
  JButton serverButton = new JButton("Play as Black");
  JButton helpButton = new JButton("Help");
  JButton settingsButton = new JButton("Settings");
  JTextField ipField = new JTextField("");
  
  //Settings
  JTextField skinField = new JTextField();
  JTextField qcField[] = new JTextField[10];
  JButton backButton = new JButton();
  
  //Game
  JTextArea chatArea = new JTextArea();
  JScrollPane scrollPane = new JScrollPane(chatArea);
  JScrollBar scrollBar = scrollPane.getVerticalScrollBar();
  JLabel timerLabel = new JLabel();
  JLabel cooldownLabel = new JLabel();
  
  //Miscellaneous
  String strColour;
  String strMenuMode = "mainMenu";
  
  boolean blnCheckIP=false;
  
  //Methods
  /* Performs any action from the ActionListener.
   * <p>The client button and server button allows players to connect via SuperSocketMaster.
   * <p>The timer performs tasks at a regular interval, such as repainting the Panel.
   * @param evt is an ActionEvent object.
   */
  public void actionPerformed(ActionEvent evt){
    //Menu Buttons    
    if(evt.getSource() == backButton){
      if(panel.strMenuMode.equals("settings")){
        setSettingsVisible(false);
      }else if(panel.strMenuMode.equals("help")){
        setHelpVisible(false);
      }
      setMenuVisible(true);
      panel.strMenuMode = "mainMenu";
    }
    
    if(evt.getSource() == settingsButton){
      setMenuVisible(false);
      setSettingsVisible(true);
      panel.strMenuMode = "settings";
    }
    
    if(evt.getSource() == helpButton){
      setMenuVisible(false);
      setHelpVisible(true);
      panel.strMenuMode = "help";
    }
    
    if(evt.getSource() == clientButton){
      strColour = "WHITE";
      ipField.setVisible(true);
      setMenuVisible(false);
      setClientVisible(true);
      panel.strMenuMode = "client";
    }
    
    if(evt.getSource() == serverButton){
      strColour = "BLACK";    
      panel.strMenuMode = "server";
      
      model.connect();
      panel.blnIP = true;
      panel.strIP = model.ssm.getMyAddress();
      
      setMenuVisible(false);
      setServerVisible(true);
    }
    
    //IP Connection
    if(evt.getSource() == ipField){
      String strIP = ipField.getText();
      model.join(strIP, strColour);
      ipField.setText("Checking IP");
      blnCheckIP = true;
    }
    
    if(blnCheckIP == true){
      if(model.blnConnect == false){
        ipField.setText("Invaild IP");
        blnCheckIP = false;
      }
    }
    
    if(model.blnConnect == true){
      ipField.setText("Connection Success!");
      model.startGame();
 
      blnCheckIP = false;
      model.ssm.sendText("0");
      model.blnConnect = false;
    }
    
    //Main Game
    if(evt.getSource() == time){
      if(model.blnGame == true && panel.blnGame == false){
        setServerVisible(false);
        setClientVisible(false);
        setGameVisible(true);
        System.out.println("Meow");
        model.blnGame = false;
        panel.blnGameEnd = false;
        panel.blnGame = true;
        
        model.loadGame(strColour);
        panel.loadSkin();
        
        panel.strCurrentColour = strColour;
        chatArea.setText("Welcome to Real Time Chess!");
        chatArea.requestFocusInWindow();
      }
      
      if(model.blnGame == true && panel.blnGame == true){
        panel.blnGame=false;
        model.blnGame=false;
        panel.blnWinner = model.blnWinner;
        panel.pieceArray = model.pieceArray;
      }      
      
      if(panel.blnGame == true && model.blnGame == false){
        panel.pieceArray = model.pieceArray;
        panel.highlightArray = model.highlightArray;
        scrollBar.setValue(scrollBar.getMaximum());
        
        //Transfer message from model to panel.
        if(!model.strCurrentMessage.equals("")){
          chatArea.append("\n"+model.strCurrentMessage);
          model.strCurrentMessage = "";
        }
        
        //Displays and formats the timers.
        double dblCooldown = Math.round(Double.valueOf(model.globalTimer.intPieceMaxTimer) / 60.0 * 10.0) / 10.0;
        int intMinutes = model.globalTimer.intGlobalTimer / 60 / 60;
        int intSeconds = model.globalTimer.intGlobalTimer / 60 % 60;
        
        if(intSeconds <= 9){
          cooldownLabel.setText("" + dblCooldown);
          timerLabel.setText("" + intMinutes + ":0" + intSeconds);
        }else{
          cooldownLabel.setText("" + dblCooldown);
          timerLabel.setText("" + intMinutes + ":" + intSeconds);
        }
      }
      panel.repaint();
    }  
  }
  
  
  /* Toggles the menu JElements
   * @param blnToggle is to be used depending on whether the elements are visible.
   */
  public void setMenuVisible(boolean blnToggle){
    serverButton.setVisible(blnToggle);
    clientButton.setVisible(blnToggle);
    helpButton.setVisible(blnToggle);
    settingsButton.setVisible(blnToggle);
  }
  
  /* Toggles the client JElements
   * @param blnToggle is to be used depending on whether the elements are visible.
   */
  public void setClientVisible(boolean blnToggle){
    ipField.setVisible(blnToggle);
    
    if(blnToggle == true){
      ipField.addActionListener(this);
    }else{
      ipField.removeActionListener(this);
    }
  }
  
  public void setServerVisible(boolean blnToggle){
    ipField.setVisible(blnToggle);
    ipField.setEditable(false);
    
    if(blnToggle == true){
      ipField.setText(model.ssm.getMyAddress());
      ipField.removeActionListener(this);
    }
  }
  
  /* Toggles the help JElements
   * @param blnToggle is to be used depending on whether the elements are visible.
   */
  public void setHelpVisible(boolean blnToggle){
    backButton.setVisible(blnToggle);
  }
  
  /* Toggles the settings JElements
   * @param blnToggle is to be used depending on whether the elements are visible.
   */
  public void setSettingsVisible(boolean blnToggle){
    //Opening the settings page
    if(blnToggle == true){
      String strQuickChatArray[] = new String[10];
      String strSplit = "";
      String strSkin = "";
      
      //Loads the settings file.
      try{
        FileReader theFile = new FileReader("settings.txt");
        BufferedReader theFileData = new BufferedReader(theFile);
        strSplit = theFileData.readLine();
        strSkin = theFileData.readLine();
        
        theFileData.close();
        theFile.close();
      }catch(IOException e){
      }
      strQuickChatArray = strSplit.split("\\|");
      
      //Initializes the text on the buttons, and sets them true.
      backButton.setVisible(true);
      skinField.setVisible(true);
      skinField.setText(strSkin);
      
      for(int intQCField = 0; intQCField < 10; intQCField++){
        qcField[intQCField].setVisible(true);
        qcField[intQCField].setText(strQuickChatArray[intQCField]);
      }
      
    //Closing the settings page
    }else if(blnToggle == false){
      String strQuickChatSetting = "";
      String strSkinSetting = "";
      
      //Writes the data to the settings file.
      try{
        FileWriter theFile = new FileWriter("settings.txt");
        PrintWriter theFileData = new PrintWriter(theFile);
        
        for(int intQCField = 0; intQCField < 10; intQCField++){
          strQuickChatSetting = strQuickChatSetting + qcField[intQCField].getText() + "|";
        } 
        strSkinSetting = skinField.getText();
        
        theFileData.println(strQuickChatSetting);
        theFileData.println(strSkinSetting);
        
        theFileData.close();
        theFile.close();
      }catch(IOException e){
      }
      
      //Sets button invisible.
      backButton.setVisible(false);
      skinField.setVisible(false);
      
      for(int intQCField = 0; intQCField < 10; intQCField++){
        qcField[intQCField].setVisible(false);
      } 
    }
  }
  

  /* Toggles the game JElements
   * @param blnToggle is to be used depending on whether the elements are visible.
   */
  public void setGameVisible(boolean blnToggle){
    scrollPane.setVisible(blnToggle);
    
    timerLabel.setVisible(blnToggle);
    cooldownLabel.setVisible(blnToggle);
  }

  
  /* Performs any action from the KeyListener when the key is pressed
   * <p>It detects key inputs from non-Swing elements, used mainly Quick Chat.
   * @param evt is an KeyEvent object.
   */
  public void keyPressed(KeyEvent evt){
    if(evt.getKeyChar()=='1'){
      model.sendMessage(1);
    }
    if(evt.getKeyChar()=='2'){
      model.sendMessage(2);
    }
    if(evt.getKeyChar()=='3'){
      model.sendMessage(3);
    }
    if(evt.getKeyChar()=='4'){
      model.sendMessage(4);
    }
    if(evt.getKeyChar()=='5'){
      model.sendMessage(5);
    }
    if(evt.getKeyChar()=='6'){
      model.sendMessage(6);
    }
    if(evt.getKeyChar()=='7'){
      model.sendMessage(7);
    }
    if(evt.getKeyChar()=='8'){
      model.sendMessage(8);
    }
    if(evt.getKeyChar()=='9'){
      model.sendMessage(9);
    }
    if(evt.getKeyChar()=='0'){
      model.sendMessage(0);
    }
  }
  
  
  /* Performs any action when the mouse is pressed.
   * <p>It detects mouse inputs from non-Swing elements, such as the chessboard.
   * @param evt is an MouseEvent object.
   */
  public void mousePressed(MouseEvent evt){
    if(panel.blnGame == true){
      int intX=evt.getX();
      int intY=evt.getY();
      if((intX/90) >= 0 && (intX/90) <= 7 && (intY/90) >= 0 && (intY/90) <= 7){
        model.move(intX/90,intY/90);
      }
    }
  }
  
  
  /* Performs any action when the mouse is pressed.
   * <p>It detects mouse inputs from non-Swing elements, such as the chessboard.
   * @param evt is an MouseEvent object.
   */
  public void mouseMoved(MouseEvent evt){
    if(panel.blnGame == false){
      panel.intMouseX = evt.getX();
      panel.intMouseY = evt.getY();
    }
  }
  
  
  /* Performs any action when the mouse is pressed.
   * <p>It detects mouse inputs from non-Swing elements, such as the chessboard.
   * @param evt is an MouseEvent object.
   */
  public void mouseDragged(MouseEvent evt){
    if(panel.blnGame == false){
      panel.intMouseX = evt.getX();
      panel.intMouseY = evt.getY();
    }
  }
  

  
  //Unused Methods
  public void mouseExited(MouseEvent evt){
  }

  public void mouseReleased(MouseEvent evt){

  }
  public void mouseClicked(MouseEvent evt){
  }
  
  public void mouseEntered(MouseEvent evt){
  }
  
  public void keyReleased(KeyEvent evt){
    
  }
  public void keyTyped(KeyEvent evt){
    
  }
  
  //Constructor
  
  public Controller(){
    panel.setLayout(null);
    panel.setPreferredSize(new Dimension(1280,720));
    panel.addMouseListener(this);
    panel.addMouseMotionListener(this);
    
    clientButton.setSize(500, 160);
    clientButton.setLocation(680,150);
    clientButton.setFont(new Font(Font.DIALOG, Font.BOLD, 48));
    clientButton.setOpaque(false);
    clientButton.setContentAreaFilled(false);
    clientButton.setBorderPainted(false);
    panel.add(clientButton);
    clientButton.addActionListener(this);
    
    serverButton.setSize(500, 160);
    serverButton.setLocation(680,350);
    serverButton.setFont(new Font(Font.DIALOG, Font.BOLD, 48));
    serverButton.setOpaque(false);
    serverButton.setContentAreaFilled(false);
    serverButton.setBorderPainted(false);
    panel.add(serverButton);
    serverButton.addActionListener(this);
    
    helpButton.setSize(230, 80);
    helpButton.setLocation(680, 580);
    helpButton.setFont(new Font(Font.DIALOG, Font.BOLD, 24));
    helpButton.setOpaque(false);
    helpButton.setContentAreaFilled(false);
    helpButton.setBorderPainted(false);
    panel.add(helpButton);
    helpButton.addActionListener(this);
    
    settingsButton.setSize(230, 80);
    settingsButton.setLocation(950, 580);
    settingsButton.setFont(new Font(Font.DIALOG, Font.BOLD, 24));
    settingsButton.setOpaque(false);
    settingsButton.setContentAreaFilled(false);
    settingsButton.setBorderPainted(false);
    panel.add(settingsButton);
    settingsButton.addActionListener(this);
    
    backButton.setSize(120, 50);
    backButton.setLocation(100, 580);
    backButton.setOpaque(false);
    backButton.setContentAreaFilled(false);
    backButton.setBorderPainted(false);
    backButton.addActionListener(this);
    backButton.setVisible(false);
    panel.add(backButton);
    
    ipField.setSize(780, 64);
    ipField.setLocation(250, 320);
    ipField.setFont(new Font(Font.DIALOG, Font.BOLD, 32));
    ipField.setOpaque(true);
    ipField.setBackground(Color.WHITE);
    ipField.setHorizontalAlignment(SwingConstants.CENTER);
    ipField.setVisible(false);
    panel.add(ipField);

    scrollPane.setLocation(770, 430);
    scrollPane.setSize(460, 240);
    scrollPane.setBackground(new Color(0, 0, 0, 0));
    scrollPane.setBorder(BorderFactory.createEmptyBorder());
    scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    scrollPane.setWheelScrollingEnabled(false);
    scrollPane.addKeyListener(this);
    scrollBar.setPreferredSize(new Dimension(0, 0));
    scrollPane.setVisible(false);
    panel.add(scrollPane);
    
    chatArea.setBackground(new Color(0, 0, 0, 0));
    chatArea.setForeground(new Color(229, 229, 229));
    chatArea.setFont(new Font(Font.DIALOG, Font.BOLD, 18));
    chatArea.setEditable(false);
    chatArea.setLineWrap(true);
    chatArea.addKeyListener(this);

    cooldownLabel.setSize(480, 360);
    cooldownLabel.setLocation(760, 40);
    cooldownLabel.setHorizontalAlignment(SwingConstants.CENTER);
    cooldownLabel.setForeground(new Color(230, 230, 230));
    cooldownLabel.setFont(new Font(Font.DIALOG, Font.BOLD, 120));
    cooldownLabel.setVisible(false);
    cooldownLabel.setText("10.0");
    panel.add(cooldownLabel);
    
    timerLabel.setSize(480, 80);
    timerLabel.setLocation(760, 320);
    timerLabel.setHorizontalAlignment(SwingConstants.CENTER);
    timerLabel.setForeground(new Color(230, 230, 230));
    timerLabel.setFont(new Font(Font.DIALOG, Font.BOLD, 32));
    timerLabel.setVisible(false);
    timerLabel.setText("1:30");
    panel.add(timerLabel);
    
    skinField.setLocation(200, 100);
    skinField.setSize(400, 40);
    skinField.setFont(new Font(Font.DIALOG, Font.BOLD, 32));
    skinField.setVisible(false);
    panel.add(skinField);
    
    //QuickChat settings field
    for(int intQCField = 0; intQCField < 10; intQCField++){
      qcField[intQCField] = new JTextField();
      qcField[intQCField].setSize(400, 32);
      qcField[intQCField].setFont(new Font(Font.DIALOG, Font.BOLD, 24));
      qcField[intQCField].setVisible(false);
      
      if(intQCField < 5){
        qcField[intQCField].setLocation(200, intQCField * 50 + 250);
      }else{
        qcField[intQCField].setLocation(665, intQCField * 50);
      }
      
      qcField[intQCField].setVisible(false);
      panel.add(qcField[intQCField]);
    }
    
    
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setContentPane(panel);
    frame.setResizable(false);
    frame.pack();
    frame.setVisible(true);
    frame.addKeyListener(this);
    
    time.start();
    
    panel.pieceArray = model.pieceArray;
    panel.highlightArray = model.highlightArray;
    
  }
  
  public static void main(String [] args){
    new Controller();
  }
  
}