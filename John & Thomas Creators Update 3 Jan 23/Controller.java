import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.geom.*;

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
  
  JLabel timerLabel = new JLabel();
  JLabel cooldownLabel = new JLabel();
  
  JTextField text = new JTextField("Enter the IP Address you wish to connect to");
  
  JTextArea chatArea = new JTextArea();
  JButton clientButton = new JButton("Play as Client");
  JButton serverButton = new JButton("Play as Server");
  JButton helpButton = new JButton("Help");
  JButton settingsButton = new JButton("Settings");
  
  JScrollPane scrollPane = new JScrollPane(chatArea);
  JScrollBar scrollBar = scrollPane.getVerticalScrollBar();
  
  String strColour;
  
  boolean blnCheckIP=false;
  
  //Methods
  /* Performs any action from the ActionListener.
   * <p>The client button and server button allows players to connect via SuperSocketMaster.
   * <p>The timer performs tasks at a regular interval, such as repainting the Panel.
   * @param evt is an ActionEvent object.
   */
  public void actionPerformed(ActionEvent evt){
    if(model.blnGame==true&&panel.blnGame==true){
      panel.blnGame=false;
      model.blnGame=false;
      panel.blnWinner=model.blnWinner;
      panel.pieceArray=model.pieceArray;
    }
    if(blnCheckIP){
      if(model.blnConnect==false){
        text.setText("Invaild IP");
        blnCheckIP=false;
      }
    }
    if(evt.getSource()==text){
      String strIP=text.getText();
      model.join(strIP,strColour);
      text.setText("Checking IP");
      blnCheckIP=true;
    }
    if(model.blnConnect==true){
      text.setText("Connection Success!");
      text.setVisible(false);
      model.startGame();
      blnCheckIP=false;
      model.ssm.sendText("0");
      model.blnConnect=false;
    }
    if(evt.getSource()==clientButton){
      strColour="WHITE";
      text.setVisible(true);
      //model.join("127.0.0.1");
    }
    if(evt.getSource()==serverButton){
      strColour="BLACK";
      
      model.connect();
      panel.blnIP=true;
      panel.strIP=model.ssm.getMyAddress();
      serverButton.setText(panel.strIP);
      
    }
    if(evt.getSource()==time){
      if(model.blnGame==true&&panel.blnGame==false){
        model.blnGame=false;
        panel.blnMainMenu=false;
        panel.blnGame=true;
        model.loadGame(strColour);
        panel.loadSkin("Samoht"); //Temporary
        panel.strCurrentColour = strColour;
        chatArea.setText("Welcome to Real Time Chess!");
        chatArea.requestFocusInWindow();
        setMenuVisible(true);
      }
      if(panel.blnGame==true&&model.blnGame==false){
        panel.pieceArray = model.pieceArray;
        panel.highlightArray = model.highlightArray;
        scrollBar.setValue(scrollBar.getMaximum());
        
        if(!model.strCurrentMessage.equals("")){
          chatArea.append("\n"+model.strCurrentMessage);
          model.strCurrentMessage = "";
        }
      }
      panel.repaint();
    }  
  }
  
  
  /* Disables the menu JElements and enables game JElements when game begins, and vice versa when the game ends.
   * @param blnInitializeType is to be used depending on whether the game begins or ends. true - Game start. false - Game reset.
   */
  public void setMenuVisible(boolean blnInitializeType){
    serverButton.setVisible(!blnInitializeType);
    clientButton.setVisible(!blnInitializeType);
    helpButton.setVisible(!blnInitializeType);
    settingsButton.setVisible(!blnInitializeType);
    scrollPane.setVisible(blnInitializeType);
    timerLabel.setVisible(blnInitializeType);
    cooldownLabel.setVisible(blnInitializeType);
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
  
  public void mouseMoved(MouseEvent evt){
    if(panel.blnGame == false){
      panel.intMouseX = evt.getX();
      panel.intMouseY = evt.getY();
    }
  }
  
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
    
    text.setSize(230, 80);
    text.setLocation(320, 580);
    text.setFont(new Font(Font.DIALOG, Font.BOLD, 24));
    text.setOpaque(true);
    text.setVisible(false);
    text.setBackground(Color.WHITE);
    panel.add(text);
    text.addActionListener(this);
    
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
    
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setContentPane(panel);
    frame.setResizable(false);
    frame.pack();
    frame.setVisible(true);
    frame.addKeyListener(this);
    
    time.start();
    
    panel.pieceArray=model.pieceArray;
    panel.highlightArray=model.highlightArray;
    
  }
  
  public static void main(String [] args){
    new Controller();
  }
  
}