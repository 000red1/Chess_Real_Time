public class Pawn extends piece{
  //Properties 
  
  
  
  
  //Methods
  public int[][] checkMove(int intX,int intY,piece[][] object){
    int[][] intMoves=new int[8][8];
    intMoves[intX][intY]=7;
    if(object[intX][intY].col().equalsIgnoreCase("b")){
      if(intY+1<8){
        if(object[intX][intY+1]==null){
          intMoves[intX][intY+1]=1;
          if(blnMove&&intY+2<8){
            if(object[intX][intY+2]==null){
              intMoves[intX][intY+2]=1;
            }
          }
          
        }
      }
      if(intX+1<8&&intY+1<8){
        if(object[intX+1][intY+1]!=null){
          if(object[intX+1][intY+1].col().equalsIgnoreCase("w")){
            intMoves[intX+1][intY+1]=2;
          }
        }
      }
      if(intX-1>-1&&intY+1<8){
        if(object[intX-1][intY+1]!=null){
          if(object[intX-1][intY+1].col().equalsIgnoreCase("w")){
            intMoves[intX-1][intY+1]=2;
          }
        }
      }
    }
    if(object[intX][intY].col().equalsIgnoreCase("w")){
      if(intY-1>-1){
        if(object[intX][intY-1]==null){
          intMoves[intX][intY-1]=1;
          if(blnMove&&intY-2>-1){
            if(object[intX][intY-2]==null){
              intMoves[intX][intY-2]=1;
            }
          }
          
        }
      }
      if(intX+1<8&&intY-1>-1){
        if(object[intX+1][intY-1]!=null){
          if(object[intX+1][intY-1].col().equalsIgnoreCase("b")){
            intMoves[intX+1][intY-1]=2;
          }
        }
      }
      if(intX-1>-1&&intY-1>-1){
        if(object[intX-1][intY-1]!=null){
          if(object[intX-1][intY-1].col().equalsIgnoreCase("b")){
            intMoves[intX-1][intY-1]=2;
          }
        }
      }
    }
    for(int intCount=0;intCount<8;intCount++){
      for(int intCount2=0;intCount2<8;intCount2++){
        System.out.print(intMoves[intCount][intCount2]);
      }
      System.out.println();
    }
    
    
    return intMoves;
  };
  
  
  
  
  //Constructor
  public Pawn(String strC, int pi, boolean blnMove){
   super(strC, pi, blnMove); 
   this.blnMove=true;
  }
  
  
}