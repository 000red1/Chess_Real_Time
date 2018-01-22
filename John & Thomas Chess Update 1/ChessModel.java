import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.geom.*;
import java.io.*;

public class ChessModel implements ActionListener{
  // Properties 
  /**
   * The highlight (overlay) array displays the legal moves to the player:
   * 0 - Unavailable / Deselect
   * 1 - Legal Move
   * 2 - Legal Capture
   * 7 - Your Own Piece / Deselect
   */
  SuperSocketMaster ssm;
  Piece[][] pieceArray = new Piece[8][8];
  int[][] highlightArray = new int[8][8];
  
  String strCurrentColour;
  
  int intX1Selected;
  int intY1Selected;
  
  FileReader thefile;
  BufferedReader thefiledata;
  String[] messageArray = new String[10];
  
  boolean blnGame=false;
  
  // Methods
  public void actionPerformed(ActionEvent evt){
    if(evt.getSource() == ssm){
      String strLine = ssm.readText();
      String[] strSplit = strLine.split(",");
      
      if(strSplit[0].equals("0")){
        blnGame = true;
      }else if(strSplit[0].equals("1")){
        //The seven is subtracted by intNumY in order to flip the chessboard by player.
        int intX1 = 7 - Integer.parseInt(strSplit[4]);
        int intY1 = 7 - Integer.parseInt(strSplit[5]);
        int intX2 = 7 - Integer.parseInt(strSplit[2]);
        int intY2 = 7 - Integer.parseInt(strSplit[3]);

        pieceArray[intX2][intY2] = pieceArray[intX1][intY1];
        pieceArray[intX1][intY1] = null;
        
        Thread t3 = new Thread(pieceArray[intX2][intY2]);
        t3.start();
      }else if(strSplit[0].equals("2")){
        System.out.println(strSplit[1]+": "+strSplit[2]);
      }
    } 
  }
  
  public void sendMessage(int intMessageNumber){
    String strMessage="2,"+strCurrentColour+","+messageArray[intMessageNumber];
    ssm.sendText(strMessage);
    System.out.println(strCurrentColour+": "+messageArray[intMessageNumber]);
  }
  
  public void connect(){
    ssm = new SuperSocketMaster(6112,this);
    ssm.connect();
  }
  
  public void join(String strIP){
    ssm = new SuperSocketMaster(strIP,6112,this);
    ssm.connect();
    ssm.sendText("0");
    blnGame = true;
  }
  
  public int[][] getMove(int intX, int intY){
    if(intX >= 0 && intX <= 7 && intY >= 0 && intY <= 7){
      if(pieceArray[intX][intY] != null){  
        if(pieceArray[intX][intY].blnCanMove == false){
          highlightArray = new int[8][8];
        }else{
          highlightArray = pieceArray[intX][intY].checkMove(intX, intY, pieceArray);        
          intX1Selected = intX;
          intY1Selected = intY;
        }
        return highlightArray;
      }
    }
    return new int[8][8];
  }
  
  public void move(int intX, int intY){
    //Case 1: Unhighlighted square.
    if(highlightArray[intX][intY] == 0){
      
      //Check if square is empty. If empty, remove highlight.
      if(pieceArray[intX][intY] == null){
        highlightArray = new int[8][8];
      }else{
        //Check if piece belongs to enemy. If it does, remove highlight.
        if(!pieceArray[intX][intY].strColour.equals("WHITE")){
          highlightArray = new int[8][8];
        }else{
          //Check if your piece is under a cooldown. If it is, remove highlighting.
          if(pieceArray[intX][intY].blnCanMove == false){
            highlightArray = new int[8][8];
          }else{
            //If your own piece is not under a cooldown, check valid moves and send it to the highlight array.
            highlightArray = pieceArray[intX][intY].checkMove(intX, intY, pieceArray);        
            intX1Selected = intX;
            intY1Selected = intY;
          }
        }
      }
    }
      
    //Case 2: Highlighted square.
    else if(highlightArray[intX][intY] == 1 || highlightArray[intX][intY] == 2){
      //1. Moves the piece
      pieceArray[intX][intY] = pieceArray[intX1Selected][intY1Selected]; 
      pieceArray[intX1Selected][intY1Selected] = null;
      
      //2. Sends the network message
      String strsend="1,120,"+intX+","+intY+","+intX1Selected+","+intY1Selected; 
      ssm.sendText(strsend);
      
      //3. Starts the cooldown timer thread.
      Thread t1 = new Thread (pieceArray[intX][intY]);
      t1.start();
      
      //4. Disable the blnNotMoved variable.
      pieceArray[intX][intY].blnNotMoved = false; 
      
      //5. Removes the highlighting.
      highlightArray = new int[8][8];
    }
      
    //Case 3: The current piece.
    else if(highlightArray[intX][intY] == 7){
      //Removes highlighting.
      highlightArray = new int[8][8];
    }
  }
  
  public void loadPieces(String strCurrentColour){
    if(strCurrentColour.equals("WHITE")){
      pieceArray[3][0] = new Queen("BLACK");
      pieceArray[4][0] = new King("BLACK");
      pieceArray[3][7] = new Queen("WHITE");
      pieceArray[4][7] = new King("WHITE");
    }else if(strCurrentColour.equals("BLACK")){
      pieceArray[3][0] = new King("BLACK");
      pieceArray[4][0] = new Queen("BLACK");
      pieceArray[3][7] = new King("WHITE");
      pieceArray[4][7] = new Queen("WHITE");
    }
    
    pieceArray[0][0] = new Rook("BLACK");
    pieceArray[7][0] = new Rook("BLACK");
    pieceArray[1][0] = new Knight("BLACK");
    pieceArray[6][0] = new Knight("BLACK");
    pieceArray[2][0] = new Bishop("BLACK");
    pieceArray[5][0] = new Bishop("BLACK");
    pieceArray[0][1] = new Pawn("BLACK");
    pieceArray[1][1] = new Pawn("BLACK");
    pieceArray[2][1] = new Pawn("BLACK");
    pieceArray[3][1] = new Pawn("BLACK");
    pieceArray[4][1] = new Pawn("BLACK");
    pieceArray[5][1] = new Pawn("BLACK");
    pieceArray[6][1] = new Pawn("BLACK");
    pieceArray[7][1] = new Pawn("BLACK");
    
    pieceArray[0][7] = new Rook("WHITE");
    pieceArray[7][7] = new Rook("WHITE");
    pieceArray[1][7] = new Knight("WHITE");
    pieceArray[6][7] = new Knight("WHITE");
    pieceArray[2][7] = new Bishop("WHITE");
    pieceArray[5][7] = new Bishop("WHITE");

    pieceArray[0][6] = new Pawn("WHITE");
    pieceArray[1][6] = new Pawn("WHITE");
    pieceArray[2][6] = new Pawn("WHITE");
    pieceArray[3][6] = new Pawn("WHITE");
    pieceArray[4][6] = new Pawn("WHITE");
    pieceArray[5][6] = new Pawn("WHITE");
    pieceArray[6][6] = new Pawn("WHITE");
    pieceArray[7][6] = new Pawn("WHITE");
  }
  
  
  //Constructor
  public ChessModel(){
    String strSplit="";
    try{
      thefile = new FileReader("QuickChat.txt");
      thefiledata = new BufferedReader(thefile);
      strSplit = thefiledata.readLine();
    }catch(IOException e){
  }
    messageArray=strSplit.split(",");
  }
}