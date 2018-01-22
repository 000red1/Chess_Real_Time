public abstract class Piece implements Runnable {
  //Properties
  public String strName;
  public String strColour;
  public boolean blnNotMoved = true;
  public boolean blnCanMove = true;
  public int intCount;
  public int intMaxCount = 10*10000/60;
  
  //Methods
  /* Checks the legal moves a piece could take and returns an integer array for the highlight array:
   * 0 - Unavailable / Deselect,
   * 1 - Legal Move,
   * 2 - Legal Capture,
   * 7 - Your Own Piece / Deselect,
   * @param intX is the row of the selected tile (0-7).
   * @param intY is the column of the selected tile (0-7).
   * @param object is the entire chessboard of pieces.
   */
  public abstract int[][] checkMove(int intX, int intY, Piece[][] object);

  /* Keeps track of the cooldown of the pieces after having it moved.
   * This is utilizes multithreading.
   */
  public void run(){
    blnCanMove = false;
    intCount = 0;
    
    while(true){
      if(intCount >= intMaxCount){
        break;
      }
      try{
        Thread.sleep(1000/60);
      }catch(InterruptedException e){
      }
      intCount++;   
    }
    
    intCount = 0;
    blnCanMove = true;
  }
  
  public void pause(){
  }
  
  //Constructor
  public Piece(String strC){
    this.strColour = strC;
  }  
}