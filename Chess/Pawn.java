public class Pawn extends piece{
  //Properties 
  public boolean fmove;
  
  
  
  
  //Methods
  public int[][] checkMove(int intX,int intY,piece[][] object){
    int[][] intMoves=new int[8][8];
    intMoves[intX][intY]=0;
    if(object[intX][intY].col().equalsIgnoreCase("b")){
      if(intY+1<8){
        if(object[intX][intY+1]==null){
          intMoves[intX][intY+1]=1;
          if(fmove&&intY+2<8){
            if(object[intX][intY+2]==null){
              intMoves[intX][intY+2]=1;
            }
          }
          
        }
      }
    }
    if(object[intX][intY].col().equalsIgnoreCase("w")){
      if(intY-1>0){
        if(object[intX][intY-1]==null){
          intMoves[intX][intY-1]=1;
          if(fmove&&intY-2>0){
            if(object[intX][intY-2]==null){
              intMoves[intX][intY-2]=1;
            }
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
  public Pawn(String strC, int pi){
   super(strC, pi); 
   this.fmove = true;
   this.strMove = true;
  }
  
  
}