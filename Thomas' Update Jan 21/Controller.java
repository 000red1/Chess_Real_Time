import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.geom.*;

public class Controller implements MouseListener, ActionListener{
  // Properties
  JFrame frame = new JFrame();
  ChessPaneView panel = new ChessPaneView();
  Timer time = new Timer(1000/60,this);
  Piece[][] pieceArray = new Piece[8][8];
  JButton clientmode = new JButton("Client");;
  JButton servermode = new JButton("Server");
  ChessModel model = new ChessModel(); 
  
  // Methods
  public void actionPerformed(ActionEvent evt){
    if(evt.getSource()==clientmode){
      model.join("127.0.0.1");
      panel.loadSkin("Samoht"); //Temporary
      model.loadPieces("WHITE");
      panel.strCurrentColour = "WHITE";
      servermode.setVisible(false);
      clientmode.setVisible(false);
    }
    if(evt.getSource()==servermode){
      model.connect();
      panel.loadSkin("Samoht"); //Temporary
      model.loadPieces("BLACK");
      panel.strCurrentColour = "BLACK";
      servermode.setVisible(false);
      clientmode.setVisible(false);
    }
    if(evt.getSource()==time){
      if(model.blnGame==true){
        model.blnGame=false;
        panel.blnGame=true;
      }
      if(panel.blnGame==true){
        panel.pieceArray = model.pieceArray;
        panel.repaint();
      }
    }
  
  }
  
  public void mouseExited(MouseEvent evt){
  }
  
  public void mousePressed(MouseEvent evt){
  }
  
  public void mouseReleased(MouseEvent evt){
    if(panel.blnGame){
      int intX=evt.getX();
      int intY=evt.getY();
      if((intX/90)>-1 && (intX/90)<8 && (intY/90)>-1 && (intY/90)<8){
        panel.pieceArray = model.move(intX/90,intY/90);
        panel.highlightArray = model.getMove(intX/90,intY/90);
      }
    }
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
    
    time.start();
    
    panel.pieceArray=model.pieceArray;
    panel.highlightArray=model.highlightArray;
    
  }
  
  public static void main(String [] args){
    new Controller();
  }
  
}