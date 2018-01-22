import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import javax.imageio.*;

/**
 * This class contains the view of the program. It handles the animation and graphics component of the program.
 * 
 * @author John Amalraj
 * @author Thomas Aryawan
 * @author Jakob Bruhn
 * @see ChessModel
 * @see Controller 
 * @version 1.0
 */

public class ChessPaneView extends JPanel{
  //Properties
  Piece[][] pieceArray = new Piece[8][8];
  int[][] highlightArray = new int[8][8];
  boolean blnGame = false;
  String strCurrentColour;
  
  //Graphics Variables
  BufferedImage imgWhitePawn;
  BufferedImage imgWhiteKnight;
  BufferedImage imgWhiteBishop;
  BufferedImage imgWhiteRook;
  BufferedImage imgWhiteQueen;
  BufferedImage imgWhiteKing;
  BufferedImage imgBlackPawn;
  BufferedImage imgBlackKnight;
  BufferedImage imgBlackBishop;
  BufferedImage imgBlackRook;
  BufferedImage imgBlackQueen;
  BufferedImage imgBlackKing;
  BufferedImage imgBackground;
  BufferedImage imgHighlightMove;
  BufferedImage imgHighlightCapture;
  BufferedImage imgHighlightSelf;
  
  //Colors
  Color cooldownBG = new Color(255, 255, 255, 119);
  Color cooldownFG = new Color(36, 153, 36);
  
  /**
   * Displays and animates the non-Swing elements onto the screen, such as BufferedImages.
   * @param g is the Graphics object for the method.
   */
  public void paintComponent(Graphics g){
    if(blnGame == false){
      //--Main Menu Screen--
      
    }else if(blnGame == true){
      //--Game Screen--
      //Draws the background.
      g.drawImage(imgBackground, 0, 0, null);
      
      //Draws the components of the chessboard.
      for(int intRow = 0; intRow < 8; intRow++){
        for(int intColumn = 0; intColumn < 8; intColumn++){
          
          //Draws the pieces on the board.
          while(pieceArray[intRow][intColumn] != null){
            String strPieceType = pieceArray[intRow][intColumn].strName;
            String strColourType = pieceArray[intRow][intColumn].strColour;  
            
            if(strColourType.equals(strCurrentColour)){
              if(strPieceType.equals("PAWN")){
                g.drawImage(imgWhitePawn, intRow*90, intColumn*90, null);   
              }else if(strPieceType.equals("KNIGHT")){
                g.drawImage(imgWhiteKnight, intRow*90, intColumn*90, null);
              }else if(strPieceType.equals("BISHOP")){
                g.drawImage(imgWhiteBishop, intRow*90, intColumn*90, null);
              }else if(strPieceType.equals("ROOK")){
                g.drawImage(imgWhiteRook, intRow*90, intColumn*90, null);
              }else if(strPieceType.equals("QUEEN")){
                g.drawImage(imgWhiteQueen, intRow*90, intColumn*90, null);
              }else if(strPieceType.equals("KING")){
                g.drawImage(imgWhiteKing, intRow*90, intColumn*90, null);
              }
            }else{
              if(strPieceType.equals("PAWN")){
                g.drawImage(imgBlackPawn, intRow*90, intColumn*90, null);
              }else if(strPieceType.equals("KNIGHT")){
                g.drawImage(imgBlackKnight, intRow*90, intColumn*90, null);
              }else if(strPieceType.equals("BISHOP")){
                g.drawImage(imgBlackBishop, intRow*90, intColumn*90, null);
              }else if(strPieceType.equals("ROOK")){
                g.drawImage(imgBlackRook, intRow*90, intColumn*90, null);
              }else if(strPieceType.equals("QUEEN")){
                g.drawImage(imgBlackQueen, intRow*90, intColumn*90, null);
              }else if(strPieceType.equals("KING")){
                g.drawImage(imgBlackKing, intRow*90, intColumn*90, null);
              }
            }
            break;
          }
          
          //Draws the highlights.
          try{
            if(highlightArray[intRow][intColumn] == 1){
              //Legal Move Highlight
              g.drawImage(imgHighlightMove, intRow*90, intColumn*90, null);
            }else if(highlightArray[intRow][intColumn] == 2){
              //Legal Capture Highlight
              g.drawImage(imgHighlightCapture, intRow*90, intColumn*90, null);
            }else if(highlightArray[intRow][intColumn] == 7){
              //Selected Piece Highlight
              g.drawImage(imgHighlightSelf, intRow*90, intColumn*90, null);
            }
          }catch(NullPointerException e){
          }
        }
      }
      repaint();
    }
  }
  
  /**
   * Loads every element of a skin from their folders. This includes images, fonts, etc.
   * @param strSkinName the name of the skin.
   * @see loadImage
   */
  public void loadSkin(String strSkinName){
    //Load Background Image
    imgBackground = loadImage(strSkinName, "background.png");
    
    //Load Piece Images
    imgWhitePawn = loadImage(strSkinName, "wPawn.png");
    imgWhiteKnight = loadImage(strSkinName, "wKnight.png");
    imgWhiteBishop = loadImage(strSkinName, "wBishop.png");
    imgWhiteRook = loadImage(strSkinName, "wRook.png");
    imgWhiteQueen = loadImage(strSkinName, "wQueen.png");
    imgWhiteKing = loadImage(strSkinName, "wKing.png");
    imgBlackPawn = loadImage(strSkinName, "bPawn.png");
    imgBlackKnight = loadImage(strSkinName, "bKnight.png");
    imgBlackBishop = loadImage(strSkinName, "bBishop.png");
    imgBlackRook = loadImage(strSkinName, "bRook.png");
    imgBlackQueen = loadImage(strSkinName, "bQueen.png");
    imgBlackKing = loadImage(strSkinName, "bKing.png");
    
    //Load Highlight Images
    imgHighlightMove = loadImage(strSkinName, "hlMove.png");
    imgHighlightCapture = loadImage(strSkinName, "hlCapture.png");
    imgHighlightSelf = loadImage(strSkinName, "hlSelf.png");
  }
    
  /**
   * Loads a specific element from a skin folder.
   * @param strSkinName the name of the skin.
   * @param strFileName the name of the skin element, which is the same across every skin.
   * @return a BufferedImage skin element.
   * @throws IOException if the skin element is not found.
   */
  public BufferedImage loadImage(String strSkinName, String strFileName){
    BufferedImage image = null;
    try{
      image = ImageIO.read(new File("Skins\\" + strSkinName + "\\" + strFileName));
    }catch (IOException e){
    }
    return image;
  }
  
  public ChessPaneView(){
  }
}