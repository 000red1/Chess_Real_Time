public abstract class piece implements Runnable {
  //Properties
  public String strColour;
  public int PiNum;
  public boolean blnMove;
  public int sint;
  public boolean canMove = false;
  public int intCount;
  //Methods
  public abstract int[][] checkMove(int intX,int intY,piece[][] object);
  
  public String col(){
    return this.strColour;
  }
  public int Num(){
    return this.PiNum;
  }
  public void run(){
    this.canMove=false;
    intCount=0;
    while(true){
      pause();
      intCount++;
      System.out.println(intCount);
      if(intCount>=30){
        break;
      }
    }
    intCount=0;
    this.canMove=true;
  }
  
  public void pause(){
    try{
      Thread.sleep(1000);
    }catch(InterruptedException e){
    }
  }
  
  //Constructor
  public piece(String strC,int pi,boolean blnMove){
    this.strColour=strC;
    this.PiNum=pi;
    this.canMove=blnMove;
    this.sint=1;
  }
  
}