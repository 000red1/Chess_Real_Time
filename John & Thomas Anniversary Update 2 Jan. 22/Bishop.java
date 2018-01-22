public class Bishop extends Piece{
  //Methods
  public int[][] checkMove(int intX, int intY, Piece[][] object){
    int[][] intMoves = new int[8][8];
    intMoves[intX][intY] = 7;
    int intCount;
    int intCount2;
    boolean bln5 = true;
    boolean bln6 = true;
    boolean bln7 = true;
    boolean bln8 = true;
    
    if(object[intX][intY].strColour.equals("BLACK")){
      for(intCount=1;intCount<8;intCount++){
        if(intX+intCount<8&&bln5==true&&intY+intCount<8){
          if(object[intX+intCount][intY+intCount]==null){
            intMoves[intX+intCount][intY+intCount]=1;
          }
          if(object[intX+intCount][intY+intCount]!=null){
            if(object[intX+intCount][intY+intCount].strColour.equals("WHITE")){
              intMoves[intX+intCount][intY+intCount]=2;
            }
            bln5=false;
          }
        }
        if(intX-intCount>-1&&bln6==true&&intY+intCount<8){
          if(object[intX-intCount][intY+intCount]==null){
            intMoves[intX-intCount][intY+intCount]=1;
          }
          if(object[intX-intCount][intY+intCount]!=null){
            if(object[intX-intCount][intY+intCount].strColour.equals("WHITE")){
              intMoves[intX-intCount][intY+intCount]=2;
            }
            bln6=false;
          }
        }
        if(intX+intCount<8&&bln7==true&&intY-intCount>-1){
          if(object[intX+intCount][intY-intCount]==null){
            intMoves[intX+intCount][intY-intCount]=1;
          }
          if(object[intX+intCount][intY-intCount]!=null){
            if(object[intX+intCount][intY-intCount].strColour.equals("WHITE")){
              intMoves[intX+intCount][intY-intCount]=2;
            }
            bln7=false;
          }
        }
        if(intX-intCount>-1&&bln8==true&&intY-intCount>-1){
          if(object[intX-intCount][intY-intCount]==null){
            intMoves[intX-intCount][intY-intCount]=1;
          }
          if(object[intX-intCount][intY-intCount]!=null){
            if(object[intX-intCount][intY-intCount].strColour.equals("WHITE")){
              intMoves[intX-intCount][intY-intCount]=2;
            }
            bln8=false;
          }
        }
      }
    }
    if(object[intX][intY].strColour.equals("WHITE")){
      ////System.out.println("white");
      for(intCount=1;intCount<8;intCount++){
        if(intX+intCount<8&&bln5==true&&intY+intCount<8){
          ////System.out.println("white");
          ////System.out.println(intX+" "+intY+" "+intCount);
          if(object[intX+intCount][intY+intCount]==null){
            ////System.out.println("white");
            intMoves[intX+intCount][intY+intCount]=1;
          }
          if(object[intX+intCount][intY+intCount]!=null){
            if(object[intX+intCount][intY+intCount].strColour.equals("BLACK")){
              intMoves[intX+intCount][intY+intCount]=2;
            }
            bln5=false;
          }
        }
        if(intX-intCount>-1&&bln6==true&&intY+intCount<8){
          if(object[intX-intCount][intY+intCount]==null){
            ////System.out.println("white");
            intMoves[intX-intCount][intY+intCount]=1;
          }
          if(object[intX-intCount][intY+intCount]!=null){
            if(object[intX-intCount][intY+intCount].strColour.equals("BLACK")){
              intMoves[intX-intCount][intY+intCount]=2;
            }
            bln6=false;
          }
        }
        if(intX+intCount<8&&bln7==true&&intY-intCount>-1){
          if(object[intX+intCount][intY-intCount]==null){
            ////System.out.println("white");
            intMoves[intX+intCount][intY-intCount]=1;
          }
          if(object[intX+intCount][intY-intCount]!=null){
            if(object[intX+intCount][intY-intCount].strColour.equals("BLACK")){
              intMoves[intX+intCount][intY-intCount]=2;
            }
            bln7=false;
          }
        }
        if(intX-intCount>-1&&bln8==true&&intY-intCount>-1){
          if(object[intX-intCount][intY-intCount]==null){
            ////System.out.println("white");
            intMoves[intX-intCount][intY-intCount]=1;
          }
          if(object[intX-intCount][intY-intCount]!=null){
            if(object[intX-intCount][intY-intCount].strColour.equals("BLACK")){
              intMoves[intX-intCount][intY-intCount]=2;
            }
            bln8=false;
          }
        }     
      }
    }
    return intMoves;
  }
  
  
//Constructor
  public Bishop(String strC){
    super(strC); 
    this.strName = "BISHOP";
  }
  
  
}