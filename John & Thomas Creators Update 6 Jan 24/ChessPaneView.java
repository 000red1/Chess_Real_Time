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
  
  /* Menu Modes:
   * mainMenu - Main Menu
   * settings - Settings
   * help - Help Page
   * server - Server
   * client - Client
   */
  String strMenuMode = "mainMenu";
  
  boolean blnGame = false;
  boolean blnIP = false;
  boolean blnWinner = false;
  boolean blnGameEnd = false;
  
  String strIP="";
  String strCurrentColour;
  
  //Graphics Variables
  BufferedImage imgMenuBackground = loadImage("titleBackground.png");
  BufferedImage imgMenuParallax = loadImage("titleParallax.png");
  BufferedImage imgMenuOverlay = loadImage("titleOverlay.png");
  BufferedImage imgSettingsOverlay = loadImage("settingsOverlay.png");
  BufferedImage imgHelpOverlay = loadImage("helpOverlay.png");
  BufferedImage imgClientOverlay = loadImage("clientOverlay.png");
  BufferedImage imgServerOverlay = loadImage("serverOverlay.png");
  int intMouseX;
  int intMouseY;
  
  //Skin-Dependent
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
      int intParallaxX = (int)(Double.valueOf(intMouseX) * 0.05 - 480.0);
      int intParallaxY = (int)(Double.valueOf(intMouseY) * 0.05 - 270.0);
      
      g.drawImage(imgMenuBackground, 0, 0, null);
      g.drawImage(imgMenuParallax, intParallaxX, intParallaxY, null);
      
      if(strMenuMode.equals("mainMenu")){
        g.drawImage(imgMenuOverlay, 0, 0, null);
      }else if(strMenuMode.equals("settings")){
        g.drawImage(imgSettingsOverlay, 0, 0, null);
      }else if(strMenuMode.equals("help")){
        g.drawImage(imgHelpOverlay, 0, 0, null);
      }else if(strMenuMode.equals("client")){
        g.drawImage(imgClientOverlay, 0, 0, null);
      }else if(strMenuMode.equals("server")){
        g.drawImage(imgServerOverlay, 0, 0, null);
      }
        
        
     
    }else if(blnGame == true){
      //--Game Screen--
      //Draws the backButtonground.
      g.drawImage(imgBackground, 0, 0, null);
      
      //Draws the components of the chessboard.
      for(int intX = 0; intX < 8; intX++){
        for(int intY = 0; intY < 8; intY++){
          
          //Draws the pieces on the board.
          while(pieceArray[intX][intY] != null){
            String strPieceType = pieceArray[intX][intY].strName;
            String strColourType = pieceArray[intX][intY].strColour;  
            int intCooldown = pieceArray[intX][intY].intCount;
            int intMaxCooldown = pieceArray[intX][intY].intMaxCount;
            int intCooldownElapsed = intMaxCooldown - intCooldown;
            int intAnimateOffsetX = 0;
            int intAnimateOffsetY = 0;
            
            if(intCooldownElapsed < 10){
              intAnimateOffsetX = (pieceArray[intX][intY].intOldX * 90 - intX * 90) / 10 * (10 - intCooldownElapsed);
              intAnimateOffsetY = (pieceArray[intX][intY].intOldY * 90 - intY * 90) / 10 * (10 - intCooldownElapsed); 
            }
            
            if(strColourType.equals(strCurrentColour)){
              if(strPieceType.equals("PAWN")){
                g.drawImage(imgWhitePawn, intX*90 + intAnimateOffsetX, intY*90 + intAnimateOffsetY, null);   
              }else if(strPieceType.equals("KNIGHT")){
                g.drawImage(imgWhiteKnight, intX*90 + intAnimateOffsetX, intY*90 + intAnimateOffsetY, null);
              }else if(strPieceType.equals("BISHOP")){
                g.drawImage(imgWhiteBishop, intX*90 + intAnimateOffsetX, intY*90 + intAnimateOffsetY, null);
              }else if(strPieceType.equals("ROOK")){
                g.drawImage(imgWhiteRook, intX*90 + intAnimateOffsetX, intY*90 + intAnimateOffsetY, null);
              }else if(strPieceType.equals("QUEEN")){
                g.drawImage(imgWhiteQueen, intX*90 + intAnimateOffsetX, intY*90 + intAnimateOffsetY, null);
              }else if(strPieceType.equals("KING")){
                g.drawImage(imgWhiteKing, intX*90 + intAnimateOffsetX, intY*90 + intAnimateOffsetY, null);
              }
            }else{
              if(strPieceType.equals("PAWN")){
                g.drawImage(imgBlackPawn, intX*90 + intAnimateOffsetX, intY*90 + intAnimateOffsetY, null);
              }else if(strPieceType.equals("KNIGHT")){
                g.drawImage(imgBlackKnight, intX*90 + intAnimateOffsetX, intY*90 + intAnimateOffsetY, null);
              }else if(strPieceType.equals("BISHOP")){
                g.drawImage(imgBlackBishop, intX*90 + intAnimateOffsetX, intY*90 + intAnimateOffsetY, null);
              }else if(strPieceType.equals("ROOK")){
                g.drawImage(imgBlackRook, intX*90 + intAnimateOffsetX, intY*90 + intAnimateOffsetY, null);
              }else if(strPieceType.equals("QUEEN")){
                g.drawImage(imgBlackQueen, intX*90 + intAnimateOffsetX, intY*90 + intAnimateOffsetY, null);
              }else if(strPieceType.equals("KING")){
                g.drawImage(imgBlackKing, intX*90 + intAnimateOffsetX, intY*90 + intAnimateOffsetY, null);
              }
            }
            
            if(intCooldown > 0 && intCooldownElapsed > 10){
              //Displays the action timer.
              int intCooldownMeter = 74 * intCooldown / intMaxCooldown;
              
              g.setColor(cooldownBG);
              g.fillRect(intX*90 + 8, intY*90 + 8, 74, 8);
              g.setColor(cooldownFG);
              g.fillRect(intX*90 + 8, intY*90 + 8, intCooldownMeter, 8);
            }
            
            
            
            break;
          }
          
          //Draws the highlights.
          try{
            if(highlightArray[intX][intY] == 1){
              //Legal Move Highlight
              g.drawImage(imgHighlightMove, intX*90, intY*90, null);
            }else if(highlightArray[intX][intY] == 2){
              //Legal Capture Highlight
              g.drawImage(imgHighlightCapture, intX*90, intY*90, null);
            }else if(highlightArray[intX][intY] == 7){
              //Selected Piece Highlight
              g.drawImage(imgHighlightSelf, intX*90, intY*90, null);
            }
          }catch(NullPointerException e){
          }
        }
      }
    }else if(blnGame == false && blnGameEnd == true){
      if(blnWinner == true){
        //code was accidentally put backButtonwards
        //It still works properly
        g.setColor(Color.BLACK);
        g.fillRect(0,0,1280,720);
        g.setColor(Color.WHITE);
        g.drawString("You Suck",500,500);
      }else if(blnWinner == false){
        g.setColor(Color.BLACK);
        g.fillRect(0,0,1280,720);
        g.setColor(Color.WHITE);
        g.drawString("You Won",500,500);
      }
    }
  }
  
  /**
   * Loads every element of a skin from their folders. This includes images, fonts, etc.
   * @param strSkinName the name of the skin.
   * @see loadImage
   */
  public void loadSkin(){
    String strSkinName = "Samoth";
    
    try{
      FileReader theFile = new FileReader("settings.txt");
      BufferedReader theFileData = new BufferedReader(theFile);
      theFileData.readLine();
      strSkinName = theFileData.readLine();
      theFileData.close();
      theFile.close();
    }catch(IOException e){
    }    
    
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
  
  /**
   * Loads a specific element from the skin folder.
   * @param strFileName the name of the skin element, which is the same across every skin.
   * @return a BufferedImage skin element.
   * @throws IOException if the skin element is not found.
   */
  public BufferedImage loadImage(String strFileName){
    BufferedImage image = null;
    try{
      image = ImageIO.read(new File("Skins\\" + strFileName));
    }catch (IOException e){
    }
    return image;
  }
  
  public ChessPaneView(){
  }
}