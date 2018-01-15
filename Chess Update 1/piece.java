public abstract class piece {
  //Properties
  public String strColour;
  public int PiNum;
  public boolean strMove;
  
  
  //Methods
  public abstract int[][] checkMove(int intX,int intY,piece[][] object);
  
  public String col(){
    return this.strColour;
  }
  public int Num(){
    return this.PiNum;
  }
  
  //Constructor
  public piece(String strC,int pi){
    this.strColour=strC;
    this.PiNum=pi;
  }
  
}