import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;
import javax.swing.event.*;

public class Controller implements MouseListener, ActionListener, KeyListener{
  // Properties
  JFrame frame = new JFrame();
  ChessPaneView panel = new ChessPaneView();
  Timer time = new Timer(1000/60,this);
  JButton clientmode = new JButton("Client");;
  JButton servermode = new JButton("Server");
  ChessModel model = new ChessModel(); 
  
  // Methods
  public void actionPerformed(ActionEvent evt){
    if(evt.getSource()==clientmode){
      model.join("127.0.0.1");
      panel.loadSkin("Samoht"); //Temporary
      model.loadPieces("WHITE");
      model.strCurrentColour = "WHITE";
      panel.strCurrentColour = "WHITE";
      servermode.setVisible(false);
      clientmode.setVisible(false);
      servermode.addKeyListener(this);
      clientmode.addKeyListener(this);
    }
    if(evt.getSource()==servermode){
      model.connect();
      panel.loadSkin("Samoht"); //Temporary
      model.loadPieces("BLACK");
      model.strCurrentColour = "BLACK";
      panel.strCurrentColour = "BLACK";
      servermode.setVisible(false);
      clientmode.setVisible(false);
      servermode.addKeyListener(this);
      clientmode.addKeyListener(this);
    }
    if(evt.getSource()==time){
      if(model.blnGame==true){
        model.blnGame=false;
        panel.blnGame=true;
      }
      if(panel.blnGame==true){
        panel.pieceArray = model.pieceArray;
        panel.highlightArray = model.highlightArray;
        panel.repaint();
      }
    }
    
  }
  public void keyReleased(KeyEvent evt){
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
  public void keyPressed(KeyEvent evt){
  }
  public void keyTyped(KeyEvent evt){
  }
  public void mouseExited(MouseEvent evt){
  }
  
  public void mousePressed(MouseEvent evt){
    if(panel.blnGame == true){
      int intX=evt.getX();
      int intY=evt.getY();
      if((intX/90) >= 0 && (intX/90) <= 7 && (intY/90) >= 0 && (intY/90) <= 7){
        model.move(intX/90,intY/90);
      }
    }
  }
  
  public void mouseReleased(MouseEvent evt){
    
  }
  public void mouseClicked(MouseEvent evt){
  }
  
  public void mouseEntered(MouseEvent evt){
  }
  
  
  // Constructor
  
  public Controller(){
    panel.setLayout(null);
    panel.setPreferredSize(new Dimension(1280,720));
    panel.addMouseListener(this);
    
    clientmode.setSize(200,200);
    clientmode.setLocation(200,500);
    panel.add(clientmode);
    clientmode.addActionListener(this);
    
    servermode.setSize(200,200);
    servermode.setLocation(400,500);
    panel.add(servermode);
    servermode.addActionListener(this);
    
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