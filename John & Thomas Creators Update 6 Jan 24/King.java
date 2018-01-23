public class King extends Piece{
  //Methods
  public int[][] checkMove(int intX, int intY, Piece[][] object){
    int[][] intMoves = new int[8][8];
    intMoves[intX][intY] = 7;
    
    if(object[intX][intY].strColour.equals("BLACK")){
      try{
        if(object[intX][intY+1]==null){
          intMoves[intX][intY+1]=1;
        }
        if(object[intX][intY+1]!=null){
          if(object[intX][intY+1].strColour.equals("WHITE")){
            intMoves[intX][intY+1]=2;
          }
        }
      }catch(ArrayIndexOutOfBoundsException e){
      }
      try{
        if(object[intX][intY-1]==null){
          intMoves[intX][intY-1]=1;
        }
        if(object[intX][intY-1]!=null){
          if(object[intX][intY-1].strColour.equals("WHITE")){
            intMoves[intX][intY-1]=2;
          }
        }
      }catch(ArrayIndexOutOfBoundsException e){
      }
      try{
        if(object[intX-1][intY]==null){
          intMoves[intX-1][intY]=1;
        }
        if(object[intX-1][intY]!=null){
          if(object[intX-1][intY].strColour.equals("WHITE")){
            intMoves[intX-1][intY]=2;
          }
        }
      }catch(ArrayIndexOutOfBoundsException e){
      }
      try{
        if(object[intX+1][intY]==null){
          intMoves[intX+1][intY]=1;
        }
        if(object[intX+1][intY]!=null){
          if(object[intX+1][intY].strColour.equals("WHITE")){
            intMoves[intX+1][intY]=2;
          }
        }
      }catch(ArrayIndexOutOfBoundsException e){
      }
      try{
        if(object[intX+1][intY+1]==null){
          intMoves[intX+1][intY+1]=1;
        }
        if(object[intX+1][intY+1]!=null){
          if(object[intX+1][intY+1].strColour.equals("WHITE")){
            intMoves[intX+1][intY+1]=2;
          }
        }
      }catch(ArrayIndexOutOfBoundsException e){
      }
      try{
        if(object[intX+1][intY-1]==null){
          intMoves[intX+1][intY-1]=1;
        }
        if(object[intX+1][intY-1]!=null){
          if(object[intX+1][intY-1].strColour.equals("WHITE")){
            intMoves[intX+1][intY-1]=2;
          }
        }
      }catch(ArrayIndexOutOfBoundsException e){
      }
      try{
        if(object[intX-1][intY+1]==null){
          intMoves[intX-1][intY+1]=1;
        }
        if(object[intX-1][intY+1]!=null){
          if(object[intX-1][intY+1].strColour.equals("WHITE")){
            intMoves[intX-1][intY+1]=2;
          }
        }
      }catch(ArrayIndexOutOfBoundsException e){
      }
      try{
        if(object[intX-1][intY-1]==null){
          intMoves[intX-1][intY-1]=1;
        }
        if(object[intX-1][intY-1]!=null){
          if(object[intX-1][intY-1].strColour.equals("WHITE")){
            intMoves[intX-1][intY-1]=2;
          }
        }
      }catch(ArrayIndexOutOfBoundsException e){
      }
    }
    
    if(object[intX][intY].strColour.equals("WHITE")){
      try{
        if(object[intX][intY+1]==null){
          intMoves[intX][intY+1]=1;
        }
        if(object[intX][intY+1]!=null){
          if(object[intX][intY+1].strColour.equals("BLACK")){
            intMoves[intX][intY+1]=2;
          }
        }
      }catch(ArrayIndexOutOfBoundsException e){
      }
      try{
        if(object[intX][intY-1]==null){
          intMoves[intX][intY-1]=1;
        }
        if(object[intX][intY-1]!=null){
          if(object[intX][intY-1].strColour.equals("BLACK")){
            intMoves[intX][intY-1]=2;
          }
        }
      }catch(ArrayIndexOutOfBoundsException e){
      }
      try{
        if(object[intX-1][intY]==null){
          intMoves[intX-1][intY]=1;
        }
        if(object[intX-1][intY]!=null){
          if(object[intX-1][intY].strColour.equals("BLACK")){
            intMoves[intX-1][intY]=2;
          }
        }
      }catch(ArrayIndexOutOfBoundsException e){
      }
      try{
        if(object[intX+1][intY]==null){
          intMoves[intX+1][intY]=1;
        }
        if(object[intX+1][intY]!=null){
          if(object[intX+1][intY].strColour.equals("BLACK")){
            intMoves[intX+1][intY]=2;
          }
        }
      }catch(ArrayIndexOutOfBoundsException e){
      }
      try{
        if(object[intX+1][intY+1]==null){
          intMoves[intX+1][intY+1]=1;
        }
        if(object[intX+1][intY+1]!=null){
          if(object[intX+1][intY+1].strColour.equals("BLACK")){
            intMoves[intX+1][intY+1]=2;
          }
        }
      }catch(ArrayIndexOutOfBoundsException e){
      }
      try{
        if(object[intX+1][intY-1]==null){
          intMoves[intX+1][intY-1]=1;
        }
        if(object[intX+1][intY-1]!=null){
          if(object[intX+1][intY-1].strColour.equals("BLACK")){
            intMoves[intX+1][intY-1]=2;
          }
        }
      }catch(ArrayIndexOutOfBoundsException e){
      }
      try{
        if(object[intX-1][intY+1]==null){
          intMoves[intX-1][intY+1]=1;
        }
        if(object[intX-1][intY+1]!=null){
          if(object[intX-1][intY+1].strColour.equals("BLACK")){
            intMoves[intX-1][intY+1]=2;
          }
        }
      }catch(ArrayIndexOutOfBoundsException e){
      }
      try{
        if(object[intX-1][intY-1]==null){
          intMoves[intX-1][intY-1]=1;
        }
        if(object[intX-1][intY-1]!=null){
          if(object[intX-1][intY-1].strColour.equals("BLACK")){
            intMoves[intX-1][intY-1]=2;
          }
        }
      }catch(ArrayIndexOutOfBoundsException e){
      }
    }    
    return intMoves;
  }  
  
  
  //Constructor
  public King(String strC){
    super(strC); 
    this.strName = "KING";
  }
  
  
}