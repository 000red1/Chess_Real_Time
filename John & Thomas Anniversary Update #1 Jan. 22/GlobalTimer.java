public class GlobalTimer implements Runnable{
 /**
 * This class contains the global timer which keeps track of time in the main game.
 */

  //Properties
  int intGlobalTimer;
  int intPieceMaxTimer;
  
  public void run(){
    intGlobalTimer = 5400;
    intPieceMaxTimer = 300;
    
    while(true){
      if(intGlobalTimer <= 0){
        break;
      }
      try{
        Thread.sleep(1000/60);
      }catch(InterruptedException e){
      }
      
      intGlobalTimer--;
      
      if(intGlobalTimer % 20 == 0){
        intPieceMaxTimer--;
      }
    }
  }
  
  public void pause(){
  }
  
  //Constructor
  public GlobalTimer(){
  }
}