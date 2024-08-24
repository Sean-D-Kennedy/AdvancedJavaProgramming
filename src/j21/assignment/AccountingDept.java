package j21.assignment;

public final class AccountingDept extends Department{
    public void accounting(){
        System.out.println("Custom accounting");
    }
    @Override
    public String toString(){
        return "Accounting";
    }
}
