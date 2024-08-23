package j8.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class CallingStoredProcedures {
    private static Connection con;
    private static CallingStoredProcedures bank = new CallingStoredProcedures(); // connect to db
    
    public CallingStoredProcedures() {
        try {
            con = DriverManager 
                    .getConnection("j8.jdbc:derby://localhost:1527/BANK_DB",
                    "sean", "sean"); // don't expose your password!
            System.out.println("DB connection OK!");
        } catch (SQLException ex) { // SQLEXception is a checked exception
            System.err.println("Exception.");
            ex.printStackTrace();
        }
    }
    public static void main(String[] args) {
        noParams();
    }
    
    public static void noParams(){
        // DB - "CREATE PROCEDURE read_dublin_addresses()"
        String noParamsSQL = "{call read_dublin_addresses()}";
        // try-with-resources will tidy up
        // PreparedStatement ps = con.prepareStatement(sql)
        try(CallableStatement cs = con.prepareCall(noParamsSQL);
            ResultSet rs = cs.executeQuery()){  
                
            while (rs.next()) {
                System.out.println(rs.getString("CUST_ADDRESS"));
            }
        } catch (SQLException ex) {
             ex.printStackTrace();
        }
    }
    
    public static void inParam(){
        String inParamSQL = "{call read_addresses(?)}"; 
        // DB - "CREATE PROCEDURE read_addresses(IN address VARCHAR(50))"
        try(CallableStatement cs = con.prepareCall(inParamSQL)){

            cs.setString(1, "Dublin");              // PreparedStatement can do this
            // cs.setString("address", "Dublin");   // CallableStatement only

            try(ResultSet rs = cs.executeQuery()){   
                while (rs.next()) {
                    System.out.println(rs.getString("CUST_ADDRESS"));
                }
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }

    public static void outParam(){
        String outParamSQL = "{?= call count_customers(?)}"; 
        // DB - "CREATE PROCEDURE count_customers(OUT count INT)"
        try(CallableStatement cs = con.prepareCall(outParamSQL)){

            cs.registerOutParameter(1, Types.INTEGER); // do this for each OUT, INOUT parameter
            cs.execute(); // no ResultSet coming back this time
            System.out.println(cs.getInt("count"));
            
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }

    public static void inOutParam(){
        String inOutParamSQL = "{call square_number(?)}"; 
        // DB - "CREATE PROCEDURE square_number(INOUT number INT)"
        try(CallableStatement cs = con.prepareCall(inOutParamSQL)){

            cs.setInt(1, 5);
            cs.registerOutParameter(1, Types.INTEGER); 
            cs.execute(); 
            System.out.println(cs.getInt("number"));
            
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }
}
