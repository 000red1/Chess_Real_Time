public class Pawn extends Piece{
  //Methods
  public int[][] checkMove(int intX, int intY, Piece[][] object){
    int[][] intMoves = new int[8][8];
    intMoves[intX][intY] = 7;
    
    if(object[intX][intY].strColour.equals("BLACK")){
      if(intY+1<8){
        if(object[intX][intY+1]==null){
          intMoves[intX][intY+1]=1;
          if(blnNotMoved&&intY+2<8){
            if(object[intX][intY+2]==null){
              intMoves[intX][intY+2]=1;
            }
          }      
        }
      }
      if(intX+1<8&&intY+1<8){
        if(object[intX+1][intY+1]!=null){
          if(object[intX+1][intY+1].strColour.equals("WHITE")){
            intMoves[intX+1][intY+1]=2;
          }
        }
      }
      if(intX-1>-1&&intY+1<8){
        if(object[intX-1][intY+1]!=null){
          if(object[intX-1][intY+1].strColour.equals("WHITE")){
            intMoves[intX-1][intY+1]=2;
          }
        }
      }
    }
    if(object[intX][intY].strColour.equals("WHITE")){
      if(intY-1>-1){
        if(object[intX][intY-1]==null){
          intMoves[intX][intY-1]=1;
          if(blnNotMoved&&intY-2>-1){
            if(object[intX][intY-2]==null){
              intMoves[intX][intY-2]=1;
            }
          }
        }
      }
      if(intX+1<8&&intY-1>-1){
        if(object[intX+1][intY-1]!=null){
          if(object[intX+1][intY-1].strColour.equals("BLACK")){
            intMoves[intX+1][intY-1]=2;
          }
        }
      }
      if(intX-1>-1&&intY-1>-1){
        if(object[intX-1][intY-1]!=null){
          if(object[intX-1][intY-1].strColour.equals("BLACK")){
            intMoves[intX-1][intY-1]=2;
          }
        }
      }
    }   
    return intMoves;
  }
  
  //Constructor
  public Pawn(String strC){
   super(strC); 
   this.strName = "PAWN";
  }
}