public class Queen extends piece{
 //Properties 
  
  
  
  
  
  //Methods
  public int[][] checkMove(int intX,int intY,piece[][] object){
    int[][] intMoves=new int[8][8];
    intMoves[intX][intY]=7;
    int intCount;
    int intCount2;
    int intHolder;
    boolean bln1 = true;
    boolean bln2 = true;
    boolean bln3 = true;
    boolean bln4 = true;
    boolean bln5 = true;
    boolean bln6 = true;
    boolean bln7 = true;
    boolean bln8 = true;
    
    if(object[intX][intY].col().equalsIgnoreCase("b")){
      for(intCount=1;intCount<8;intCount++){
        if(intX+intCount<8&&bln5==true&&intY+intCount<8){
          if(object[intX+intCount][intY+intCount]==null){
            intMoves[intX+intCount][intY+intCount]=1;
          }
          if(object[intX+intCount][intY+intCount]!=null){
            if(object[intX+intCount][intY+intCount].col().equalsIgnoreCase("w")){
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
            if(object[intX-intCount][intY+intCount].col().equalsIgnoreCase("w")){
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
            if(object[intX+intCount][intY-intCount].col().equalsIgnoreCase("w")){
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
            if(object[intX-intCount][intY-intCount].col().equalsIgnoreCase("w")){
              intMoves[intX-intCount][intY-intCount]=2;
            }
            bln8=false;
          }
        }
      }
    }
    if(object[intX][intY].col().equalsIgnoreCase("w")){
      System.out.println("white");
      for(intCount=1;intCount<8;intCount++){
        if(intX+intCount<8&&bln5==true&&intY+intCount<8){
          System.out.println("white");
          System.out.println(intX+" "+intY+" "+intCount);
          if(object[intX+intCount][intY+intCount]==null){
            System.out.println("white");
            intMoves[intX+intCount][intY+intCount]=1;
          }
          if(object[intX+intCount][intY+intCount]!=null){
            if(object[intX+intCount][intY+intCount].col().equalsIgnoreCase("b")){
              intMoves[intX+intCount][intY+intCount]=2;
            }
            bln5=false;
          }
        }
        if(intX-intCount>-1&&bln6==true&&intY+intCount<8){
          if(object[intX-intCount][intY+intCount]==null){
            System.out.println("white");
            intMoves[intX-intCount][intY+intCount]=1;
          }
          if(object[intX-intCount][intY+intCount]!=null){
            if(object[intX-intCount][intY+intCount].col().equalsIgnoreCase("b")){
              intMoves[intX-intCount][intY+intCount]=2;
            }
            bln6=false;
          }
        }
        if(intX+intCount<8&&bln7==true&&intY-intCount>-1){
          if(object[intX+intCount][intY-intCount]==null){
            System.out.println("white");
            intMoves[intX+intCount][intY-intCount]=1;
          }
          if(object[intX+intCount][intY-intCount]!=null){
            if(object[intX+intCount][intY-intCount].col().equalsIgnoreCase("b")){
              intMoves[intX+intCount][intY-intCount]=2;
            }
            bln7=false;
          }
        }
        if(intX-intCount>-1&&bln8==true&&intY-intCount>-1){
          if(object[intX-intCount][intY-intCount]==null){
            System.out.println("white");
            intMoves[intX-intCount][intY-intCount]=1;
          }
          if(object[intX-intCount][intY-intCount]!=null){
            if(object[intX-intCount][intY-intCount].col().equalsIgnoreCase("b")){
              intMoves[intX-intCount][intY-intCount]=2;
            }
            bln8=false;
          }
        }
        
      }
    
    if(object[intX][intY].col().equalsIgnoreCase("b")){
      for(intCount=1;intCount<8;intCount++){
        if(intX+intCount<8&&bln1==true){
          if(object[intX+intCount][intY]==null){
            intMoves[intX+intCount][intY]=1;
          }
          if(object[intX+intCount][intY]!=null){
            if(object[intX+intCount][intY].col().equalsIgnoreCase("w")){
              intMoves[intX+intCount][intY]=2;
            }
            bln1=false;
          }
        }
        if(intX-intCount>-1&&bln2==true){
          if(object[intX-intCount][intY]==null){
            intMoves[intX-intCount][intY]=1;
          }
          if(object[intX-intCount][intY]!=null){
            if(object[intX-intCount][intY].col().equalsIgnoreCase("w")){
              intMoves[intX-intCount][intY]=2;
            }
            bln2=false;
          }
        }
        if(intY+intCount<8&&bln3==true){
          if(object[intX][intY+intCount]==null){
            intMoves[intX][intY+intCount]=1;
          }
          if(object[intX][intY+intCount]!=null){
            if(object[intX][intY+intCount].col().equalsIgnoreCase("w")){
              intMoves[intX][intY+intCount]=2;
            }
            bln3=false;
          }
        }
        if(intY-intCount>-1&&bln4==true){
          if(object[intX][intY-intCount]==null){
            intMoves[intX][intY-intCount]=1;
          }
          if(object[intX][intY-intCount]!=null){
            if(object[intX][intY-intCount].col().equalsIgnoreCase("w")){
              intMoves[intX][intY-intCount]=2;
            }
            bln4=false;
          }
        }
      }
      
    }
    if(object[intX][intY].col().equalsIgnoreCase("w")){
      for(intCount=0;intCount<8;intCount++){
        if(intX+intCount<8&&bln1==true){
          if(object[intX+intCount][intY]==null){
            intMoves[intX+intCount][intY]=1;
          }
          if(object[intX+intCount][intY]!=null){
            if(object[intX+intCount][intY].col().equalsIgnoreCase("b")){
              intMoves[intX+intCount][intY]=2;
              bln1=false;
            }
            else if(object[intX+intCount][intY]==object[intX][intY]){
              
            }
            else{
              bln1=false;
            }
          }
        }
        if(intX-intCount>-1&&bln2==true){
          if(object[intX-intCount][intY]==null){
            intMoves[intX-intCount][intY]=1;
          }
          if(object[intX-intCount][intY]!=null){
            if(object[intX-intCount][intY].col().equalsIgnoreCase("b")){
              intMoves[intX-intCount][intY]=2;
              bln2=false;
            }
            else if(object[intX-intCount][intY]==object[intX][intY]){
              
            }
            else{
              bln2=false;
            }
          }
        }
        if(intY+intCount<8&&bln3==true){
          if(object[intX][intY+intCount]==null){
            intMoves[intX][intY+intCount]=1;
          }
          if(object[intX][intY+intCount]!=null){
            if(object[intX][intY+intCount].col().equalsIgnoreCase("b")){
              intMoves[intX][intY+intCount]=2;
              bln3=false;
            }
            else if(object[intX][intY+intCount]==object[intX][intY]){
            }
            else{
              bln3=false;
            }
          }
        }
        if(intY-intCount>-1&&bln4==true){
          if(object[intX][intY-intCount]==null){
            intMoves[intX][intY-intCount]=1;
          }
          if(object[intX][intY-intCount]!=null){
            if(object[intX][intY-intCount].col().equalsIgnoreCase("b")){
              intMoves[intX][intY-intCount]=2;
              bln4=false;
            }
            else if(object[intX][intY-intCount]==object[intX][intY]){
            }
            else{
              bln4=false;
            }
          }
        }
      }
      
    }
    
    for(intCount=0;intCount<8;intCount++){
      for(intCount2=0;intCount2<8;intCount2++){
        System.out.print(intMoves[intCount][intCount2]);
      }
      System.out.println();
    }
    }
    
    
    return intMoves;
  };
  
  
  
  
  //Constructor
  public Queen(String strC, int pi, boolean blnMove){
   super(strC, pi, blnMove); 
    
  }
  
  
}