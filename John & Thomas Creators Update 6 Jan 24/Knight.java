public class Knight extends Piece{
  //Methods
  public int[][] checkMove(int intX, int intY, Piece[][] object){
    int[][] intMoves = new int[8][8];
    intMoves[intX][intY] = 7;

    if(object[intX][intY].strColour.equals("BLACK")){
      try{
        if(object[intX+2][intY+1]==null){
          intMoves[intX+2][intY+1]=1;
        }
        if(object[intX+2][intY+1]!=null){
          if(object[intX+2][intY+1].strColour.equals("WHITE")){
            intMoves[intX+2][intY+1]=2;
          }
        }
      }catch(ArrayIndexOutOfBoundsException e){
      }
      try{
        if(object[intX+2][intY-1]==null){
          intMoves[intX+2][intY-1]=1;
        }
        if(object[intX+2][intY-1]!=null){
          if(object[intX+2][intY-1].strColour.equals("WHITE")){
            intMoves[intX+2][intY-1]=2;
          }
        }
      }catch(ArrayIndexOutOfBoundsException e){
      }
      try{
        if(object[intX-2][intY+1]==null){
          intMoves[intX-2][intY+1]=1;
        }
        if(object[intX-2][intY+1]!=null){
          if(object[intX-2][intY+1].strColour.equals("WHITE")){
            intMoves[intX-2][intY+1]=2;
          }
        }
      }catch(ArrayIndexOutOfBoundsException e){
      }
      try{
        if(object[intX-2][intY-1]==null){
          intMoves[intX-2][intY-1]=1;
        }
        if(object[intX-2][intY-1]!=null){
          if(object[intX-2][intY-1].strColour.equals("WHITE")){
            intMoves[intX-2][intY-1]=2;
          }
        }
      }catch(ArrayIndexOutOfBoundsException e){
      }
      try{
        if(object[intX+1][intY+2]==null){
          intMoves[intX+1][intY+2]=1;
        }
        if(object[intX+1][intY+2]!=null){
          if(object[intX+1][intY+2].strColour.equals("WHITE")){
            intMoves[intX+1][intY+2]=2;
          }
        }
      }catch(ArrayIndexOutOfBoundsException e){
      }
      try{
        if(object[intX+1][intY-2]==null){
          intMoves[intX+1][intY-2]=1;
        }
        if(object[intX+1][intY-2]!=null){
          if(object[intX+1][intY-2].strColour.equals("WHITE")){
            intMoves[intX+1][intY-2]=2;
          }
        }
      }catch(ArrayIndexOutOfBoundsException e){
      }
      try{
        if(object[intX-1][intY+2]==null){
          intMoves[intX-1][intY+2]=1;
        }
        if(object[intX-1][intY+2]!=null){
          if(object[intX-1][intY+2].strColour.equals("WHITE")){
            intMoves[intX-1][intY+2]=2;
          }
        }
      }catch(ArrayIndexOutOfBoundsException e){
      }
      try{
        if(object[intX-1][intY-2]==null){
          intMoves[intX-1][intY-2]=1;
        }
        if(object[intX-1][intY-2]!=null){
          if(object[intX-1][intY-2].strColour.equals("WHITE")){
            intMoves[intX-1][intY-2]=2;
          }
        }
      }catch(ArrayIndexOutOfBoundsException e){
      }
    }
    
    if(object[intX][intY].strColour.equals("WHITE")){
      try{
        if(object[intX+2][intY+1]==null){
          intMoves[intX+2][intY+1]=1;
        }
        if(object[intX+2][intY+1]!=null){
          if(object[intX+2][intY+1].strColour.equals("BLACK")){
            intMoves[intX+2][intY+1]=2;
          }
        }
      }catch(ArrayIndexOutOfBoundsException e){
      }
      try{
        if(object[intX+2][intY-1]==null){
          intMoves[intX+2][intY-1]=1;
        }
        if(object[intX+2][intY-1]!=null){
          if(object[intX+2][intY-1].strColour.equals("BLACK")){
            intMoves[intX+2][intY-1]=2;
          }
        }
      }catch(ArrayIndexOutOfBoundsException e){
      }
      try{
        if(object[intX-2][intY+1]==null){
          intMoves[intX-2][intY+1]=1;
        }
        if(object[intX-2][intY+1]!=null){
          if(object[intX-2][intY+1].strColour.equals("BLACK")){
            intMoves[intX-2][intY+1]=2;
          }
        }
      }catch(ArrayIndexOutOfBoundsException e){
      }
      try{
        if(object[intX-2][intY-1]==null){
          intMoves[intX-2][intY-1]=1;
        }
        if(object[intX-2][intY-1]!=null){
          if(object[intX-2][intY-1].strColour.equals("BLACK")){
            intMoves[intX-2][intY-1]=2;
          }
        }
      }catch(ArrayIndexOutOfBoundsException e){
      }
      try{
        if(object[intX+1][intY+2]==null){
          intMoves[intX+1][intY+2]=1;
        }
        if(object[intX+1][intY+2]!=null){
          if(object[intX+1][intY+2].strColour.equals("BLACK")){
            intMoves[intX+1][intY+2]=2;
          }
        }
      }catch(ArrayIndexOutOfBoundsException e){
      }
      try{
        if(object[intX+1][intY-2]==null){
          intMoves[intX+1][intY-2]=1;
        }
        if(object[intX+1][intY-2]!=null){
          if(object[intX+1][intY-2].strColour.equals("BLACK")){
            intMoves[intX+1][intY-2]=2;
          }
        }
      }catch(ArrayIndexOutOfBoundsException e){
      }
      try{
        if(object[intX-1][intY+2]==null){
          intMoves[intX-1][intY+2]=1;
        }
        if(object[intX-1][intY+2]!=null){
          if(object[intX-1][intY+2].strColour.equals("BLACK")){
            intMoves[intX-1][intY+2]=2;
          }
        }
      }catch(ArrayIndexOutOfBoundsException e){
      }
      try{
        if(object[intX-1][intY-2]==null){
          intMoves[intX-1][intY-2]=1;
        }
        if(object[intX-1][intY-2]!=null){
          if(object[intX-1][intY-2].strColour.equals("BLACK")){
            intMoves[intX-1][intY-2]=2;
          }
        }
      }catch(ArrayIndexOutOfBoundsException e){
      }
    }  
    return intMoves;
  }  

  //Constructor
  public Knight(String strC){
   super(strC); 
    this.strName = "KNIGHT";
  }
  
  
}