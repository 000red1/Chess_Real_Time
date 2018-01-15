import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.geom.*;

public class chess implements MouseListener, ActionListener{
  //Properties
  
  //Variable names
  JFrame frame = new JFrame();
  ChessPane panel = new ChessPane();
  Timer time = new Timer(1000/60,this);
  piece[][] pieceArray = new piece[8][8];
  
  //Methods
  public void actionPerformed(ActionEvent evt){
    //Repaints Panel
    
    if(evt.getSource()==time){
      panel.repaint();
    }
  }
  public void mouseExited(MouseEvent evt){
    System.out.println("Exit");
  }
  public void mousePressed(MouseEvent evt){
    System.out.println("Pressed");
  }
  public void mouseReleased(MouseEvent evt){
  }
  public void mouseClicked(MouseEvent evt){
    //Test for where mouse is clicked
    //Gets mouse x and y coordinate, prints both to the system
    //Divides the coordinates by 90, to get exact tile on board prints the tile numbers to system
    //Sends coordinates to the panel
    //Sets the Moveboolean true, so that the movement method can be triggered
    
    System.out.println("Clicked");
    int intX=evt.getX();
    int intY=evt.getY();
    System.out.println(intX+","+intY);
    panel.intXMouseClicked=intX/90;
    panel.intYMouseClicked=intY/90;
    panel.blnMovement=true;
    System.out.println(panel.intXMouseClicked+","+panel.intYMouseClicked);
  }
  public void mouseEntered(MouseEvent evt){
    System.out.println("Enter");
  }
  
  
  
  
  //Constructor
  public chess(){
    //Usually stuff
    
    panel.setLayout(null);
    panel.setPreferredSize(new Dimension(720,720));
    frame.setResizable(false);
    panel.addMouseListener(this);
    
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setContentPane(panel);
    frame.pack();
    frame.setVisible(true);
    
    //Timer
    time.start();
    
    //Inalizing objects in the piece array
    pieceArray[0][0] = new Rook("b",1);
    pieceArray[7][0] = new Rook("b",1);
    pieceArray[1][0] = new Knight("b",2);
    pieceArray[6][0] = new Knight("b",2);
    pieceArray[2][0] = new Bishop("b",3);
    pieceArray[5][0] = new Bishop("b",3);
    pieceArray[3][0] = new King("b",4);
    pieceArray[4][0] = new Queen("b",5);
    pieceArray[0][1] = new Pawn("b",6);
    pieceArray[1][1] = new Pawn("b",6);
    pieceArray[2][1] = new Pawn("b",6);
    pieceArray[3][1] = new Pawn("b",6);
    pieceArray[4][1] = new Pawn("b",6);
    pieceArray[5][1] = new Pawn("b",6);
    pieceArray[6][1] = new Pawn("b",6);
    pieceArray[7][1] = new Pawn("b",6);
    
    pieceArray[0][7] = new Rook("w",1);
    pieceArray[7][7] = new Rook("w",1);
    pieceArray[1][7] = new Knight("w",2);
    pieceArray[6][7] = new Knight("w",2);
    pieceArray[2][7] = new Bishop("w",3);
    pieceArray[5][7] = new Bishop("w",3);
    pieceArray[3][7] = new King("w",4);
    pieceArray[4][7] = new Queen("w",5);
    pieceArray[0][6] = new Pawn("w",6);
    pieceArray[1][6] = new Pawn("w",6);
    pieceArray[2][6] = new Pawn("w",6);
    pieceArray[3][6] = new Pawn("w",6);
    pieceArray[4][6] = new Pawn("w",6);
    pieceArray[5][6] = new Pawn("w",6);
    pieceArray[6][6] = new Pawn("w",6);
    pieceArray[7][6] = new Pawn("w",6);
    //Move boolean is set false
    panel.blnMovement=false;
    //pieceArray is sent to panel
    panel.pieceArray=pieceArray;
  }
  
  public static void main(String [] args){
    
   new chess(); 
    
    
  }
  
  
}