public class King extends piece{
  //Properties 
  
  
  
  
  
  //Methods
  public int[][] checkMove(int intX,int intY,piece[][] object){
    int[][] intMoves=new int[8][8];
    intMoves[intX][intY]=7;
    
    if(object[intX][intY].col().equalsIgnoreCase("b")){
      try{
        if(object[intX][intY+1]==null){
          intMoves[intX][intY+1]=1;
        }
        if(object[intX][intY+1]!=null){
          if(object[intX][intY+1].col().equalsIgnoreCase("w")){
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
          if(object[intX][intY-1].col().equalsIgnoreCase("w")){
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
          if(object[intX-1][intY].col().equalsIgnoreCase("w")){
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
          if(object[intX+1][intY].col().equalsIgnoreCase("w")){
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
          if(object[intX+1][intY+1].col().equalsIgnoreCase("w")){
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
          if(object[intX+1][intY-1].col().equalsIgnoreCase("w")){
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
          if(object[intX-1][intY+1].col().equalsIgnoreCase("w")){
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
          if(object[intX-1][intY-1].col().equalsIgnoreCase("w")){
            intMoves[intX-1][intY-1]=2;
          }
        }
      }catch(ArrayIndexOutOfBoundsException e){
      }
    }
    
    if(object[intX][intY].col().equalsIgnoreCase("w")){
      try{
        if(object[intX][intY+1]==null){
          intMoves[intX][intY+1]=1;
        }
        if(object[intX][intY+1]!=null){
          if(object[intX][intY+1].col().equalsIgnoreCase("b")){
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
          if(object[intX][intY-1].col().equalsIgnoreCase("b")){
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
          if(object[intX-1][intY].col().equalsIgnoreCase("b")){
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
          if(object[intX+1][intY].col().equalsIgnoreCase("b")){
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
          if(object[intX+1][intY+1].col().equalsIgnoreCase("b")){
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
          if(object[intX+1][intY-1].col().equalsIgnoreCase("b")){
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
          if(object[intX-1][intY+1].col().equalsIgnoreCase("b")){
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
          if(object[intX-1][intY-1].col().equalsIgnoreCase("b")){
            intMoves[intX-1][intY-1]=2;
          }
        }
      }catch(ArrayIndexOutOfBoundsException e){
      }
    }
    
    return intMoves;
  };
  
  
  
  
  //Constructor
  public King(String strC, int pi){
    super(strC, pi); 
    
  }
  
  
}