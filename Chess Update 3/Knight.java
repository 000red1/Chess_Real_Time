public class Knight extends piece{
 //Properties 
  
  
  
  
  
  //Methods
  public int[][] checkMove(int intX,int intY,piece[][] object){
    int[][] intMoves=new int[8][8];
    intMoves[intX][intY]=7;
    int intCount;
    int intCount2;
    if(object[intX][intY].col().equalsIgnoreCase("b")){
      try{
        if(object[intX+2][intY+1]==null){
          intMoves[intX+2][intY+1]=1;
        }
        if(object[intX+2][intY+1]!=null){
          if(object[intX+2][intY+1].col().equalsIgnoreCase("w")){
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
          if(object[intX+2][intY-1].col().equalsIgnoreCase("w")){
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
          if(object[intX-2][intY+1].col().equalsIgnoreCase("w")){
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
          if(object[intX-2][intY-1].col().equalsIgnoreCase("w")){
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
          if(object[intX+1][intY+2].col().equalsIgnoreCase("w")){
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
          if(object[intX+1][intY-2].col().equalsIgnoreCase("w")){
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
          if(object[intX-1][intY+2].col().equalsIgnoreCase("w")){
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
          if(object[intX-1][intY-2].col().equalsIgnoreCase("w")){
            intMoves[intX-1][intY-2]=2;
          }
        }
      }catch(ArrayIndexOutOfBoundsException e){
      }
    }
    
    if(object[intX][intY].col().equalsIgnoreCase("w")){
      try{
        if(object[intX+2][intY+1]==null){
          intMoves[intX+2][intY+1]=1;
        }
        if(object[intX+2][intY+1]!=null){
          if(object[intX+2][intY+1].col().equalsIgnoreCase("b")){
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
          if(object[intX+2][intY-1].col().equalsIgnoreCase("b")){
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
          if(object[intX-2][intY+1].col().equalsIgnoreCase("b")){
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
          if(object[intX-2][intY-1].col().equalsIgnoreCase("b")){
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
          if(object[intX+1][intY+2].col().equalsIgnoreCase("b")){
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
          if(object[intX+1][intY-2].col().equalsIgnoreCase("b")){
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
          if(object[intX-1][intY+2].col().equalsIgnoreCase("b")){
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
          if(object[intX-1][intY-2].col().equalsIgnoreCase("b")){
            intMoves[intX-1][intY-2]=2;
          }
        }
      }catch(ArrayIndexOutOfBoundsException e){
      }
    }
    
    for(intCount=0;intCount<8;intCount++){
      for(intCount2=0;intCount2<8;intCount2++){
        System.out.print(intMoves[intCount][intCount2]);
      }
      System.out.println();
    }
    
    return intMoves;
  };
  
  
  
  
  //Constructor
  public Knight(String strC, int pi){
   super(strC, pi); 
    
  }
  
  
}