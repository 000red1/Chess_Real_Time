import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.geom.*;

public class ChessModel implements ActionListener{
  // Properties 
  SuperSocketMaster ssm;
  piece[][] pieceArray = new piece[8][8];
  int[][] highlightArray = new int[8][8];
  int[][] nothingArray = new int[8][8];
  
  int intCount;
  int intCount2;
  
  int intX1PieceSelected;
  int intY1PieceSelected;
  
  boolean blnGame=false;
  // Methods
  public void actionPerformed(ActionEvent evt){
    if(evt.getSource()==ssm){
      String strLine=ssm.readText();
      String[] strSplit =strLine.split(",");
      if(strSplit[0].equals("0")){
        blnGame=true;
      }
      if(strSplit[0].equals("1")){
        int intNumX = 7-Integer.parseInt(strSplit[2]);
        int intNumY = 7-Integer.parseInt(strSplit[3]);
        int intNumX1 = 7-Integer.parseInt(strSplit[4]);
        int intNumY1 = 7-Integer.parseInt(strSplit[5]);
        
        pieceArray[intNumX][intNumY]=pieceArray[intNumX1][intNumY1];
        pieceArray[intNumX1][intNumY1]=null;
        Thread t3 = new Thread (pieceArray[intNumX][intNumY]);
        t3.start();
      }
    }
    
  }
  
  public void connect(){
    ssm = new SuperSocketMaster(6112,this);
    ssm.connect();
    
  }
  public void join(String strIP){
    ssm = new SuperSocketMaster(strIP,6112,this);
    ssm.connect();
    ssm.sendText("0");
    blnGame=true;
  }
  public int[][] getmove(int intX, int intY){
    int[][] moveArray = new int[8][8];
    if(intX>-1&&intX<8&&intY>-1&&intY<8){
      if(pieceArray[intX][intY]!=null){
        moveArray=pieceArray[intX][intY].checkMove(intX,intY,pieceArray);
        highlightArray=moveArray;
        intX1PieceSelected=intX;
        intY1PieceSelected=intY;
        if(pieceArray[intX][intY].canMove == false){
          highlightArray=nothingArray;
          return nothingArray;
        }
      }
    }
    return moveArray;
    
  }
  
  public piece[][] move(int intX, int intY){
    if(highlightArray[intX][intY]==1){
      pieceArray[intX][intY]=pieceArray[intX1PieceSelected][intY1PieceSelected];
      pieceArray[intX1PieceSelected][intY1PieceSelected]=null;
      String strsend="1,120,"+intX+","+intY+","+intX1PieceSelected+","+intY1PieceSelected;
      ssm.sendText(strsend);
      System.out.println("pleasee work ~ move");
      pieceArray[intX][intY].sint=0;
      Thread t1 = new Thread (pieceArray[intX][intY]);
      t1.start();
    }
    else if(highlightArray[intX][intY]==2){
      pieceArray[intX][intY]=pieceArray[intX1PieceSelected][intY1PieceSelected];
      pieceArray[intX1PieceSelected][intY1PieceSelected]=null;
      String strsend="1,120,"+intX+","+intY+","+intX1PieceSelected+","+intY1PieceSelected;
      ssm.sendText(strsend);
      System.out.println("pleasee work ~ enemy");
      pieceArray[intX][intY].sint=0;
      Thread t2 = new Thread (pieceArray[intX][intY]);
      t2.start();
    }
    return pieceArray;
  }
  
  public piece[][] update(){
    return pieceArray;
  }
  
  //Constructor
  public ChessModel(){
    pieceArray[0][0] = new Rook("b",1,true);
    pieceArray[7][0] = new Rook("b",1,true);
    pieceArray[1][0] = new Knight("b",2,true);
    pieceArray[6][0] = new Knight("b",2,true);
    pieceArray[2][0] = new Bishop("b",3,true);
    pieceArray[5][0] = new Bishop("b",3,true);
    pieceArray[3][0] = new King("b",4,true);
    pieceArray[4][0] = new Queen("b",5,true);
    pieceArray[0][1] = new Pawn("b",6,true);
    pieceArray[1][1] = new Pawn("b",6,true);
    pieceArray[2][1] = new Pawn("b",6,true);
    pieceArray[3][1] = new Pawn("b",6,true);
    pieceArray[4][1] = new Pawn("b",6,true);
    pieceArray[5][1] = new Pawn("b",6,true);
    pieceArray[6][1] = new Pawn("b",6,true);
    pieceArray[7][1] = new Pawn("b",6,true);
    
    pieceArray[0][7] = new Rook("w",1,true);
    pieceArray[7][7] = new Rook("w",1,true);
    pieceArray[1][7] = new Knight("w",2,true);
    pieceArray[6][7] = new Knight("w",2,true);
    pieceArray[2][7] = new Bishop("w",3,true);
    pieceArray[5][7] = new Bishop("w",3,true);
    pieceArray[3][7] = new King("w",4,true);
    pieceArray[4][7] = new Queen("w",5,true);
    pieceArray[0][6] = new Pawn("w",6,true);
    pieceArray[1][6] = new Pawn("w",6,true);
    pieceArray[2][6] = new Pawn("w",6,true);
    pieceArray[3][6] = new Pawn("w",6,true);
    pieceArray[4][6] = new Pawn("w",6,true);
    pieceArray[5][6] = new Pawn("w",6,true);
    pieceArray[6][6] = new Pawn("w",6,true);
    pieceArray[7][6] = new Pawn("w",6,true);
    
    for(intCount = 0;intCount<8;intCount++){
      for(intCount2 = 0;intCount2<8;intCount2++){
        highlightArray[intCount][intCount2]=0;
      }
    }
    nothingArray=highlightArray;
  }
  
}