package j8.jdbc;

import java.sql.DriverManager;      // factory class for creating the db Connection
import java.sql.Connection;         // required interface
import java.sql.PreparedStatement;  // required interface
import java.sql.ResultSet;          // required interface

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BankService {

    private static Connection con;
    private static BankService bank = new BankService(); // connect to db
    
    public BankService() {
        try {
            con = DriverManager 
                    .getConnection("j8.jdbc:derby://localhost:1527/BANK_DB",
                    "sean", "sean"); // don't expose your password!
            //System.out.println("DB connection OK!");
        } catch (SQLException ex) { // SQLEXception is a checked exception
            System.err.println("Exception.");
            ex.printStackTrace();
        }
    }
    
    public void retrieveUsingStatement(String branchCode) {
        String selectSQL = "SELECT * FROM APP.BANK_TABLE WHERE BRANCH_CODE = "+branchCode+"" ;
        BankAccount bankAccount = null;

        try (Statement stmt = con.createStatement()) {

            ResultSet rs = stmt.executeQuery(selectSQL);   
            
            while (rs.next()) {
                // process the record
                bankAccount = new BankAccount(
                        rs.getString("BRANCH_CODE"),
                        rs.getString(2),    // "ACCOUNT_NUMBER"
                        rs.getString("CUST_NAME"),
                        rs.getString("CUST_ADDRESS"),
                        rs.getDouble("BALANCE"));
                System.out.println(bankAccount);
            }

        } catch (SQLException sqle) {
            System.err.println("SQLException in getAccountDetails()");
            sqle.printStackTrace();
        }
    }
    public void retrieveUsingPreparedStatement(String branchCode) {
        String selectSQL = "SELECT * FROM APP.BANK_TABLE WHERE BRANCH_CODE = ?";
        BankAccount bankAccount = null;

        try (PreparedStatement ps = con.prepareStatement(selectSQL)) {

            ps.setString(1, branchCode); // columns start at 1 in JDBC!

            ResultSet rs = ps.executeQuery();   // implies SELECT
            
            while (rs.next()) {
                // process the record
                bankAccount = new BankAccount(
                        rs.getString("BRANCH_CODE"),
                        rs.getString(2),    // "ACCOUNT_NUMBER"
                        rs.getString("CUST_NAME"),
                        rs.getString("CUST_ADDRESS"),
                        rs.getDouble("BALANCE"));
                System.out.println(bankAccount);
            }

        } catch (SQLException sqle) {
            System.err.println("SQLException in getAccountDetails()");
            sqle.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // This next method uses a Statement. Statement's can be exposed to SQL injection attacks.
//        bank.retrieveUsingStatement("'123456'");// ok
        
//        bank.retrieveUsingStatement("'123456' OR BRANCH_CODE IS NOT NULL");// NOT ok
        
        // Uses a PreparedStatement with bind variables. We will try the nefarious SQL again...
//        bank.retrieveUsingPreparedStatement("123456");// ok
        bank.retrieveUsingPreparedStatement("123456 OR BRANCH_CODE IS NOT NULL");// 

    }

    

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
// old main()
    /*
        public static void main(String[] args) {
        // This next method uses a Statement. Statement's can be exposed to SQL injection attacks.
//        bank.retrieveUsingStatement("'123456'");// ok
        
//        bank.retrieveUsingStatement("'123456' OR BRANCH_CODE IS NOT NULL");// NOT ok
        
        // Uses a PreparedStatement with bind variables. We will try the nefarious SQL again...
//        bank.retrieveUsingPreparedStatement("123456");// ok
        bank.retrieveUsingPreparedStatement("123456 OR BRANCH_CODE IS NOT NULL");// 
        
 //       bank.retrieveOne();
 //       System.out.println();
 //       bank.retrieveAll();
 //       bank.deleteOne();
//        System.out.println();
//        bank.deleteAll();
//        bank.add();
//        bank.update();
    }

    */
    public void retrieveOne(){
        // retrieve one bank account
        System.out.println(bank.getAccountDetails("123456", "12345678"));
    }
    public void retrieveAll(){
        // retrieve all bank accounts
        for(BankAccount bankAccount: bank.getAllAccounts()){
            System.out.println(bankAccount);
        }
    }
    public void deleteOne(){
        // delete one bank account
        int nRows = bank.deleteBankAccount("123456", "12345678");
        if(nRows == 1 ){
            System.out.println("Delete OK: "+ nRows);
        }else{
            System.out.println("Delete error: "+ nRows);
        }
    }
    public void deleteAll(){
        // delete all bank accounts
        bank.deleteAllAccounts();
    }
    public void add(){
        // add a bank account
        int nRows = bank.addBankAccount(
                        new BankAccount("999999", "88888888",
                        "SK", "Dublin", 100));
        if(nRows == 1 ){
            System.out.println("Add OK: "+ nRows);
        }else{
            System.out.println("Add error: "+ nRows);
        }
    }
    public void update(){
        // Update
        BankAccount bankAccount = bank.getAccountDetails("123456", "12345678");
        System.out.println("BEFORE Update: "+bankAccount);
        bankAccount.setCustName("J. Bloggs");
        bankAccount.setCustAddress("London");
        int nRows = bank.updateBankAccount(bankAccount);
        if(nRows == 1 ){
            System.out.println("Update OK: "+ nRows);
             System.out.println("AFTER Update: "+bank.getAccountDetails("123456", "12345678"));
        }else{
            System.out.println("Add error: "+ nRows);
        }
    }

    // SELECT one account
    public BankAccount getAccountDetails(String branchCode, String accountNo) {
        // A '?' is called a 'bind variable'. It is a placeholder that we can populate at runtime.
        String selectSQL = "SELECT * FROM APP.BANK_TABLE WHERE (BRANCH_CODE = ? AND ACCOUNT_NUMBER=?)";
        BankAccount bankAccount = null;

        // Cannot put the prepareStatement() and executeQuery() in the try-with-resources braces
        // as we have bind variables that must be set in between these 2 commands
        try (PreparedStatement ps = con.prepareStatement(selectSQL)) {

            ps.setString(1, branchCode); // columns start at 1 in JDBC!
            ps.setString(2, accountNo);

            ResultSet rs = ps.executeQuery();   // implies SELECT

            // Move the cursor to the first row
            if (!rs.next()) {  // !F==T  i.e. no record there at all.
                return bankAccount; // null
            }

            // process the record
            bankAccount = new BankAccount(
                    // API:
                    // boolean rs.getBoolean(String columnLabel) also overloaded: boolean getBoolean(int columnIndex)
                    // double rs.getDouble(String columnLabel) also overloaded: double getDouble(int columnIndex)
                    // int rs.getInt(String columnLabel) also overloaded: int getInt(int columnIndex)
                    // long rs.getLong(String columnLabel) also overloaded: long getLong(int columnIndex)
                    // T rs.getObject(String columnLabel, Class<T> type ) also overloaded: 
                    //      T rs.getObject(int columnIndex, Class<T> type )
                    rs.getString("BRANCH_CODE"),
                    rs.getString(2),    // "ACCOUNT_NUMBER"
                    rs.getString("CUST_NAME"),
                    rs.getString("CUST_ADDRESS"),
                    rs.getDouble("BALANCE"));

        } catch (SQLException sqle) {
            System.err.println("SQLException in getAccountDetails()");
            sqle.printStackTrace();
        }

        return bankAccount;
    }

    // SELECT all accounts
    public ArrayList<BankAccount> getAllAccounts() {
        ArrayList<BankAccount> bankAccounts  = new ArrayList<>();

        String selectSQL = "SELECT * FROM APP.BANK_TABLE"; // no WHERE clause this time => get all records/rows
        try (PreparedStatement ps = con.prepareStatement(selectSQL)) {
            boolean isResultSet = ps.execute();
            if(isResultSet){ // yes, as we did a SELECT
                ResultSet rs = ps.getResultSet();
                while (rs.next()) {
                    // process the record
                    BankAccount bankAccount = new BankAccount(
                            rs.getString(1),    // "BRANCH_CODE"
                            rs.getString("ACCOUNT_NUMBER"),
                            rs.getString("CUST_NAME"),
                            rs.getString("CUST_ADDRESS"),
                            rs.getDouble("BALANCE"));

                    bankAccounts.add(bankAccount);
                }
            }else{
                System.out.println("Did an update!");
            }
        } catch (SQLException sqle) {
            System.err.println("SQLException in getAllAccounts()");
            sqle.printStackTrace();
        }

        return bankAccounts;

    }
    
    // DELETE one account
    public int deleteBankAccount(String branchCode, String accountNo) {
        int nRows  = -1;
        String deleteSQL = "DELETE FROM APP.BANK_TABLE WHERE (BRANCH_CODE = ? AND ACCOUNT_NUMBER=?)";

        try (PreparedStatement ps = con.prepareStatement(deleteSQL)) {
            ps.setString(1, branchCode);
            ps.setString(2, accountNo);

            nRows = ps.executeUpdate();

        } catch (SQLException sqle) {
            System.err.println("SQLException in deleteBankAccount()");
            sqle.printStackTrace();
        }
        return nRows;
    }

    // DELETE all accounts
    public void deleteAllAccounts() {
        String deleteSQL = "DELETE FROM APP.BANK_TABLE";

        try (PreparedStatement ps = con.prepareStatement(deleteSQL)){
            ps.executeUpdate();

        } catch (SQLException sqle) {
            System.err.println("SQLException in deleteAllAccounts()");
            sqle.printStackTrace();
        }

    }
    // INSERT a bank account
    public int addBankAccount(BankAccount ba) {
        int nRows  = -1;
        String insertSQL = "INSERT INTO APP.BANK_TABLE "
                            + "(BRANCH_CODE, ACCOUNT_NUMBER,"
                            + "CUST_NAME, CUST_ADDRESS, BALANCE) "
                            + "VALUES (?,?,?,?,?)";
        try (PreparedStatement ps = con.prepareStatement(insertSQL)){
            // ps.setBoolean(int parameterIndex, boolean x);    ps.setDouble(int parameterIndex, double x);
            // ps.setInt(int parameterIndex, int x);            ps.setLong(int parameterIndex, long x);
            // ps.setObject(int parameterIndex, Object x);
            ps.setString(1, ba.getBranchCode()); // bind variables start at 1
            ps.setString(2, ba.getAccountNo());
            ps.setString(3, ba.getCustName());
            ps.setString(4, ba.getCustAddress());
            ps.setDouble(5, ba.getBalance());
            nRows = ps.executeUpdate();
        } catch (SQLException sqle) {
            System.err.println("SQLException in addBankAccount()");
            sqle.printStackTrace();
        }
        
        return nRows;
    }
    
    // UPDATE a bank account
    public int updateBankAccount(BankAccount ba) {
        int nRows  = -1;
        String updateSQL = "UPDATE APP.BANK_TABLE "
                     + "SET CUST_NAME=?, CUST_ADDRESS=?, BALANCE=? "
                     + "WHERE (BRANCH_CODE = ? AND ACCOUNT_NUMBER=?)";

        try (PreparedStatement ps = con.prepareStatement(updateSQL)){
            ps.setString(1, ba.getCustName());
            ps.setString(2, ba.getCustAddress());
            ps.setDouble(3, ba.getBalance());
            ps.setString(4, ba.getBranchCode());
            ps.setString(5, ba.getAccountNo());

            nRows = ps.executeUpdate();
        } catch (SQLException sqle) {
            System.err.println("SQLException in updateBankAccount()");
            sqle.printStackTrace();
            return nRows;
        }
        
        return nRows;
    }
}


























//            con = DriverManager
//                            .getConnection("j8.jdbc:derby://localhost/BANK_DB",  // port is optional when using localhost
//            con = DriverManager
//                            .getConnection("j8.jdbc:derby://127.0.0.1/BANK_DB",    // ip address for localhost

            // Note: 'var ps = con.prepareStatement(selectSQL)' is ok too.
            // Failure to pass SQL (a String) into prepareStatement() 
            // is a compiler error i.e. con.prepareStatement() is a compiler error
            // Do something with 'ps'...
/*
 public ArrayList<BankAccount> getAllAccounts() {
        ArrayList<BankAccount> bankAccounts  = new ArrayList<>();

        String selectSQL = "SELECT * FROM APP.BANK_TABLE";
        try (PreparedStatement ps = con.prepareStatement(selectSQL);                
            ResultSet rs = ps.executeQuery()) {
            // We can put the prepareStatement() and executeQuery() in the try-with-resources braces
            // (no bind variables here).
            while (rs.next()) {
                // process the record
                BankAccount bankAccount = new BankAccount(
                        rs.getString("BRANCH_CODE"),
                        rs.getString("ACCOUNT_NUMBER"),
                        rs.getString("CUST_NAME"),
                        rs.getString("CUST_ADDRESS"),
                        rs.getDouble("BALANCE"));

                bankAccounts.add(bankAccount);
            }

        } catch (SQLException sqle) {
            System.err.println("SQLException in getAllAccounts()");
            sqle.printStackTrace();
        }

        return bankAccounts;

    }
*/