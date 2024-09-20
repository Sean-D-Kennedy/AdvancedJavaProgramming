package j11.ocp.exception_handling;


class LowBalanceException extends WithdrawalException{ //1     
    public LowBalanceException(String msg){ super(msg);    } 
    
}  
class WithdrawalException extends RuntimeException{ //2     
    public WithdrawalException(String msg){ super(msg);    } 
} 
class Account{     
    double balance;     
    public void withdraw(double amount) {   // no throws clause here => RuntimeException      
        try{             
            throw new LowBalanceException("Not Implemented");         
        }catch(WithdrawalException e){             
            throw new RuntimeException(e.getMessage());         
        }     
    }     
    public static void main(String[] args) {         
        try{             
            Account a = new Account();             
            a.withdraw(100.0);         
        }catch(WithdrawalException e){             
            System.out.println(e.getMessage());         
        }catch(Exception e){             
            System.out.println(e.getMessage());         
        }     
    } 
}

public class Q2_3356 {
    
}
