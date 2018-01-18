public abstract class piece implements Runnable {
  //Properties
  public String strColour;
  public int PiNum;
  public boolean blnMove;
  public boolean CanMove;
  
  //Methods
  public abstract int[][] checkMove(int intX,int intY,piece[][] object);
  
  public String col(){
    return this.strColour;
  }
  public int Num(){
    return this.PiNum;
  }
  public void run(){
    
  }
  //Constructor
  public piece(String strC,int pi){
    this.strColour=strC;
    this.PiNum=pi;
  }
  
}