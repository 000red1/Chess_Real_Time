public abstract class Piece implements Runnable {
  //Properties
  public String strName;
  public String strColour;
  public boolean blnNotMoved = true;
  public boolean blnCanMove = true;
  public int intCount;
  
  //Methods
  public abstract int[][] checkMove(int intX, int intY, Piece[][] object);

  public void run(){
    blnCanMove = false;
    intCount = 0;
    
    while(true){
      pause();
      intCount++;
      if(intCount >= 10*1000/60){
        break;
      }
    }
    
    intCount = 0;
    blnCanMove = true;
  }
  
  public void pause(){
    try{
      Thread.sleep(1000/60);
    }catch(InterruptedException e){
    }
  }
  
  //Constructor
  public Piece(String strC){
    this.strColour = strC;
  }  
}