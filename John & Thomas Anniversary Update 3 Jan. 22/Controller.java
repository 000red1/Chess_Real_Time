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
  
  JTextArea chatArea = new JTextArea();
  JButton clientButton = new JButton("Play as Client");
  JButton serverButton = new JButton("Play as Server");
  JButton helpButton = new JButton("Help");
  JButton settingsButton = new JButton("Settings");
  
  JScrollPane scrollPane = new JScrollPane(chatArea);
  JScrollBar scrollBar = scrollPane.getVerticalScrollBar();
  
  //Methods
  /* Performs any action from the ActionListener.
   * <p>The client button and server button allows players to connect via SuperSocketMaster.
   * <p>The timer performs tasks at a regular interval, such as repainting the Panel.
   * @param evt is an ActionEvent object.
   */
  public void actionPerformed(ActionEvent evt){
    if(evt.getSource()==clientButton){
      model.join("127.0.0.1");
      model.loadGame("WHITE");
      panel.loadSkin("Samoht");
      panel.strCurrentColour = "WHITE";
      chatArea.setText("Welcome to Real Time Chess!");
      
      chatArea.requestFocusInWindow();
      
      serverButton.setVisible(false);
      clientButton.setVisible(false);
      helpButton.setVisible(false);
      settingsButton.setVisible(false);
      scrollPane.setVisible(true);
    }
    if(evt.getSource()==serverButton){
      model.connect();
      model.loadGame("BLACK");
      panel.loadSkin("Samoht"); //Temporary
      panel.strCurrentColour = "BLACK";
      chatArea.setText("Welcome to Real Time Chess!");
      
      chatArea.requestFocusInWindow();
      
      serverButton.setVisible(false);
      clientButton.setVisible(false);
      helpButton.setVisible(false);
      settingsButton.setVisible(false);
      scrollPane.setVisible(true);
      scrollPane.setVisible(true);
    }
    if(evt.getSource()==time){
      if(model.blnGame==true){
        model.blnGame=false;
        panel.blnGame=true;
      }
      if(panel.blnGame==true){
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
    clientButton.setFont(new Font(Font.MONOSPACED, Font.BOLD, 48));
    clientButton.setOpaque(false);
    clientButton.setContentAreaFilled(false);
    clientButton.setBorderPainted(false);
    panel.add(clientButton);
    clientButton.addActionListener(this);
    
    serverButton.setSize(500, 160);
    serverButton.setLocation(680,350);
    serverButton.setFont(new Font(Font.MONOSPACED, Font.BOLD, 48));
    serverButton.setOpaque(false);
    serverButton.setContentAreaFilled(false);
    serverButton.setBorderPainted(false);
    panel.add(serverButton);
    serverButton.addActionListener(this);
    
    helpButton.setSize(230, 80);
    helpButton.setLocation(680, 580);
    helpButton.setFont(new Font(Font.MONOSPACED, Font.BOLD, 24));
    helpButton.setOpaque(false);
    helpButton.setContentAreaFilled(false);
    helpButton.setBorderPainted(false);
    panel.add(helpButton);
    helpButton.addActionListener(this);
    
    settingsButton.setSize(230, 80);
    settingsButton.setLocation(950, 580);
    settingsButton.setFont(new Font(Font.MONOSPACED, Font.BOLD, 24));
    settingsButton.setOpaque(false);
    settingsButton.setContentAreaFilled(false);
    settingsButton.setBorderPainted(false);
    panel.add(settingsButton);
    settingsButton.addActionListener(this);
    
       
    
    scrollPane.setLocation(770, 430);
    scrollPane.setSize(460, 240);
    scrollPane.setBackground(new Color(0, 0, 0, 0));
    scrollPane.setBorder(BorderFactory.createEmptyBorder());
    scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    scrollPane.setWheelScrollingEnabled(false);
    scrollPane.addKeyListener(this);
    scrollBar.setPreferredSize(new Dimension(0, 0));
    
    chatArea.setBackground(new Color(0, 0, 0, 0));
    chatArea.setForeground(new Color(229, 229, 229));
    chatArea.setFont(new Font(Font.MONOSPACED, Font.BOLD, 18));
    chatArea.setEditable(false);
    chatArea.setLineWrap(true);
    chatArea.addKeyListener(this);
    
    scrollPane.setVisible(false);
    
    panel.add(scrollPane);
    
    
    
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