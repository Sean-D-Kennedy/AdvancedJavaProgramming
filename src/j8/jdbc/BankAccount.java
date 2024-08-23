package j8.jdbc;

public class BankAccount {
    private String branchCode, accountNo, custName, custAddress;
    private double balance;

    public BankAccount() {
    }

    public BankAccount(String branchCode, String accountNo, String custName, String custAddress, double balance) {
        this.branchCode = branchCode;
        this.accountNo = accountNo;
        this.custName = custName;
        this.custAddress = custAddress;
        this.balance = balance;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "BankAccount{ branchCode=" + branchCode + ", accountNo=" + accountNo + ", custName=" + custName + ", custAddress=" + custAddress + ", balance=" + balance + '}';
    }


    
    
}
