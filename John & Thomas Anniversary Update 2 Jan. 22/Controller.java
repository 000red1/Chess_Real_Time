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


public class Controller implements MouseListener, ActionListener, KeyListener{
  //Properties
  JFrame frame = new JFrame("Real Time Chess V1.0");
  ChessPaneView panel = new ChessPaneView();
  ChessModel model = new ChessModel(); 
  Timer time = new Timer(1000/60,this);
  
  JButton playbutt = new JButton("Play");
  JButton helpbutt = new JButton("Help");
  JButton configbutt = new JButton("Config");
  
  JTextArea chatArea = new JTextArea();
  JButton clientMode = new JButton("Join a Game");
  JButton serverMode = new JButton("Start a Game");
  
  JScrollPane scrollPane = new JScrollPane(chatArea);
  JScrollBar scrollBar = scrollPane.getVerticalScrollBar();
  
  String strColour;
  String strIP = "";
  JTextField text;
  
  //Methods
  /* Performs any action from the ActionListener.
   * <p>The client button and server button allows players to connect via SuperSocketMaster.
   * <p>The timer performs tasks at a regular interval, such as repainting the Panel.
   * @param evt is an ActionEvent object.
   */
  public void actionPerformed(ActionEvent evt){
    if(evt.getSource()==text){
      strIP=text.getText();
      model.join(strIP);
      text.setVisible(false);
      
    }
    
    if(evt.getSource()==clientMode){
      strColour="WHITE";
      
      
      //model.join("127.0.0.1");
      
      
      serverMode.setVisible(false);
      clientMode.setVisible(false);
      serverMode.addKeyListener(this);
      clientMode.addKeyListener(this);
      
      text = new JTextField("Enter IP Address");
      text.setSize(400,400);
      text.setLocation(200,200);
      panel.add(text);
      panel.repaint();
      text.addActionListener(this);
      scrollPane.setVisible(true);
    }
    if(evt.getSource()==serverMode){
      strColour="BLACK";
      
      model.connect();
      strIP=model.ssm.getMyAddress();
      panel.strIP=strIP;
      serverMode.setVisible(false);
      clientMode.setVisible(false);
      serverMode.addKeyListener(this);
      clientMode.addKeyListener(this);
      scrollPane.setVisible(true);
    }
    
    if(evt.getSource()==playbutt){
        playbutt.setVisible(false);
        helpbutt.setVisible(false);
        configbutt.setVisible(false);
        frame.remove(playbutt);
        frame.remove(helpbutt);
        frame.remove(configbutt);
        serverMode.setVisible(true);
        clientMode.setVisible(true);
        panel.repaint();
      }
    
    if(evt.getSource()==time){
      if(model.blnGame==true){
        model.blnGame=false;
        panel.blnGame=true;
        model.loadGame(strColour);
        panel.loadSkin("Samoht"); //Temporary
        panel.strCurrentColour = strColour;
        chatArea.setText("Welcome to Real Time Chess!");
      }
      if(panel.blnGame==true){
        panel.pieceArray = model.pieceArray;
        panel.highlightArray = model.highlightArray;
        scrollBar.setValue(scrollBar.getMaximum());
        panel.repaint();
        
        if(!model.strCurrentMessage.equals("")){
          chatArea.append("\n"+model.strCurrentMessage);
          model.strCurrentMessage = "";
        }
      }
    }
  
  }
  
  /* Performs any action from the KeyListener when the key is pressed
   * <p>It detects key inputs from non-Swing elements, used mainly Quick Chat.
   * @param evt is an KeyEvent object.
   */
  public void keyPressed(KeyEvent evt){
    if(evt.getKeyChar()=='1'){
      model.sendMessage(1);
      System.out.println("1");
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
    
    clientMode.setSize(200,200);
    clientMode.setLocation(200,500);
    panel.add(clientMode);
    clientMode.addActionListener(this);
    
    serverMode.setSize(200,200);
    serverMode.setLocation(400,500);
    panel.add(serverMode);
    serverMode.addActionListener(this);
    serverMode.setVisible(false);
    clientMode.setVisible(false);
    
    playbutt.setSize(400,100);
    playbutt.setLocation(410,100);
    playbutt.addActionListener(this);
    panel.add(playbutt);
    
    helpbutt.setSize(400,100);
    helpbutt.setLocation(410,300);
    helpbutt.addActionListener(this);
    panel.add(helpbutt);
    
    configbutt.setSize(400,100);
    configbutt.setLocation(410,500);
    configbutt.addActionListener(this);
    panel.add(configbutt);
    
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
    chatArea.setFont(new Font(Font.DIALOG, Font.BOLD, 18));
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
