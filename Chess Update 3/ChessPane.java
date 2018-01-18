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
  boolean blnPieceMove=false;
  boolean blnClick=true;
  //blnTiles will be activated after the spots where the piece can move is determined.
  boolean blnTiles=false;
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
            break;
          }
          g.setColor(Color.GREEN);
          if(pieceArray[intCount][intCount2].Num()==2){
            g.setColor(Color.GREEN);
            g.fillRect(intCount*90,intCount2*90,90,90);
            break;
          }
          g.setColor(Color.RED);
          if(pieceArray[intCount][intCount2].Num()==3){
            g.setColor(Color.RED);
            g.fillRect(intCount*90,intCount2*90,90,90);
            break;
          }
          g.setColor(Color.ORANGE);
          if(pieceArray[intCount][intCount2].Num()==4){
            g.setColor(Color.ORANGE);
            g.fillRect(intCount*90,intCount2*90,90,90);
            break;
          }
          g.setColor(Color.CYAN);
          if(pieceArray[intCount][intCount2].Num()==5){
            g.setColor(Color.CYAN);
            g.fillRect(intCount*90,intCount2*90,90,90);
            break;
          }
          if(pieceArray[intCount][intCount2].Num()==6){
            g.setColor(Color.YELLOW);
            g.fillRect(intCount*90,intCount2*90,90,90);
            break;
          }
        }
        if(blnTiles){
          try{
            if(higlightArray[intCount][intCount2]==1){
              g.setColor(Color.PINK);
              g.fillRect(intCount*90,intCount2*90,90,90);
            }
          }catch(NullPointerException e){
          }try{
            if(higlightArray[intCount][intCount2]==2){
              System.out.println("attack!!!!");
              g.setColor(Color.BLACK);
              g.fillRect(intCount*90,intCount2*90,90,90);
            }
          }catch(NullPointerException e){
          }
        }
        g.setColor(Color.BLACK);
      }
    }
    
    
    /*if(move[intX][intY]==1){
     pieceArray[intX][intY]=pieceArray[intX1][intY1];
     pieceArray[intX1][intY1]=null;
     }*/
    
    //Activated if a tile is clicked
    
    //Check that tile has a piece
    if(blnMovement){
      if(blnPieceMove){
        try{
          if(higlightArray[intXMouseClicked][intYMouseClicked]==1){
            pieceArray[intXMouseClicked][intYMouseClicked]=pieceArray[intX1PieceSelected][intY1PieceSelected];
            pieceArray[intX1PieceSelected][intY1PieceSelected]=null;
            pieceArray[intXMouseClicked][intYMouseClicked].blnMove=false;
            blnTiles=false;
            higlightArray=null;
            blnMovement=false;
            blnPieceMove=false;
          }
        }catch(NullPointerException e){
          
        }
        
        try{
          if(higlightArray[intXMouseClicked][intYMouseClicked]==2){
            pieceArray[intXMouseClicked][intYMouseClicked]=pieceArray[intX1PieceSelected][intY1PieceSelected];
            pieceArray[intX1PieceSelected][intY1PieceSelected]=null;
            pieceArray[intXMouseClicked][intYMouseClicked].blnMove=false;
            blnTiles=false;
            higlightArray=null;
            blnMovement=false;
            blnPieceMove=false;
          }
        }catch(NullPointerException e){
          
        }
        try{
          if(pieceArray[intXMouseClicked][intYMouseClicked]==pieceArray[intX1PieceSelected][intY1PieceSelected]){
            blnMovement=false;
            blnTiles=false;
            higlightArray=null;
            blnPieceMove=false;
          }
        }catch(NullPointerException e){
          
        }
        if(pieceArray[intXMouseClicked][intYMouseClicked]!=null){
          blnTiles=false;
          higlightArray=null;
          blnPieceMove=false;
          blnClick=true;
        }
        
      }
      if(blnClick){
        System.out.println("yo");
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
                intY1PieceSelected=intYMouseClicked;
                blnMovement=false;
                blnTiles=true;
              }
              if(movementArray[intCount][intCount2]==2){
                System.out.println("whatt whatt");
                higlightArray=movementArray;
                intX1PieceSelected=intXMouseClicked;
                intY1PieceSelected=intYMouseClicked;
                blnMovement=false;
                blnTiles=true;
                g.setColor(Color.BLACK);
                g.fillRect(intCount*90,intCount2*90,45,45);
              }
            }
          }
          blnClick=false;
          blnPieceMove=true;
        }
        /*for(intCount=0;intCount<8;intCount++){
          for(intCount2=0;intCount2<8;intCount2++){
            System.out.print(higlightArray[intCount][intCount2]);
            
          }
          System.out.println("");
        }*/
      }
      if(blnPieceMove==false){
        blnClick=true;
      }
      blnMovement=false;
      System.out.println("blnClick "+blnClick);
      System.out.println("blnPieceMove "+blnPieceMove);
      System.out.println("blnMovement "+blnMovement);
      
    }
      
      
  }
  
  
  
  //Constructor
  public ChessPane(){
    super();
  }
  
}