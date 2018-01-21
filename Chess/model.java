


public class model {
  // Properties 
  SuperSocketMaster ssm;
  
  // Methods
  public void connect(){
    ssm = new SuperSocketMaster(6112,this);
    ssm.connect();
    
  }
  public void join(String strIP){
    ssm = new SuperSocketMaster(strIP,6112,this);
    ssm.connect();
    
  }
  
  //Constructor
  
  
}