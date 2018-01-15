import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class ChessPane extends JPanel{
  //Properties
  //Piece array is same as one in main program
  piece[][] pieceArray = new piece[8][8];
  //blnMovement will be activated if a piece is clicked upon
  boolean blnMovement=false;
  //X coordinate of mouse click
  int intXMouseClicked;
  //Y coordinate of mouse click
  int intYMouseClicked;
  //Array that will receieve the array from the movement method, is constantly run
  int[][] movementArray;
  //Array that will store the movement array
  int[][] higlightArray;
  //Stores the clicked piece X location on board
  int intX1PieceSelected;
  //Stores the clicked piece Y location on board
  int intY1PieceSelected;
  //Methods
  public void paintComponent(Graphics g){
    g.setColor(Color.BLACK);
    g.fillRect(0,0,1000,1000);
    g.setColor(Color.WHITE);
    //Draws lines on the chessboard
    g.drawLine(0,0,720,0);
    g.drawLine(0,0,0,720);
    g.drawLine(0,90,720,90);
    g.drawLine(0,180,720,180);
    g.drawLine(0,270,720,270);
    g.drawLine(0,360,720,360);
    g.drawLine(0,450,720,450);
    g.drawLine(0,540,720,540);
    g.drawLine(0,630,720,630);
    g.drawLine(0,720,720,720);
    g.drawLine(0,0,0,720);
    g.drawLine(90,0,90,720);
    g.drawLine(180,0,180,720);
    g.drawLine(270,0,270,720);
    g.drawLine(360,0,360,720);
    g.drawLine(450,0,450,720);
    g.drawLine(540,0,540,720);
    g.drawLine(630,0,630,720);
    g.drawLine(720,0,720,720);
    int intCount=0;
    int intCount2=0;
    //The for loop draws all the pieces on the board
    for(intCount=0;intCount<8;intCount++){
      for(intCount2=0;intCount2<8;intCount2++){
        while(pieceArray[intCount][intCount2]!=null){
          g.setColor(Color.BLUE);
          if(pieceArray[intCount][intCount2].Num()==1){
            g.setColor(Color.BLUE);
            g.fillRect(intCount*90,intCount2*90,90,90);
          }
          g.setColor(Color.GREEN);
          if(pieceArray[intCount][intCount2].Num()==2){
            g.setColor(Color.GREEN);
            g.fillRect(intCount*90,intCount2*90,90,90);
          }
          g.setColor(Color.RED);
          if(pieceArray[intCount][intCount2].Num()==3){
            g.setColor(Color.RED);
            g.fillRect(intCount*90,intCount2*90,90,90);
          }
          g.setColor(Color.ORANGE);
          if(pieceArray[intCount][intCount2].Num()==4){
            g.setColor(Color.ORANGE);
            g.fillRect(intCount*90,intCount2*90,90,90);
          }
          g.setColor(Color.CYAN);
          if(pieceArray[intCount][intCount2].Num()==5){
            g.setColor(Color.CYAN);
            g.fillRect(intCount*90,intCount2*90,90,90);
          }
          if(pieceArray[intCount][intCount2].Num()==6){
            g.setColor(Color.YELLOW);
            g.fillRect(intCount*90,intCount2*90,90,90);
          }
          break;
        }
        g.setColor(Color.BLACK);
      }
    }

     
    /*if(move[intX][intY]==1){
      pieceArray[intX][intY]=pieceArray[intX1][intY1];
      pieceArray[intX1][intY1]=null;
    }*/
    
    //Activated if a tile is clicked
    if(blnMovement){
      //Check that tile has a piece
      if(pieceArray[intXMouseClicked][intYMouseClicked]!=null){
        //Determines movement of the piece
        movementArray=pieceArray[intXMouseClicked][intYMouseClicked].checkMove(intXMouseClicked,intYMouseClicked,pieceArray);
        for(intCount=0;intCount<8;intCount++){
          for(intCount2=0;intCount2<8;intCount2++){
            //For loops will highlight tiles piece can move
            if(movementArray[intCount][intCount2]==1){
              g.setColor(Color.PINK);
              g.fillRect(intCount*90,intCount2*90,90,90);
              //Stores highlight array
              higlightArray=movementArray;
              intX1PieceSelected=intXMouseClicked;
              intY1PieceSelected=intXMouseClicked;
              blnMovement=false;
            }
          }
        } 
      }
    }
  }
  
  
  //Constructor
  public ChessPane(){
    super();
  }
  
}