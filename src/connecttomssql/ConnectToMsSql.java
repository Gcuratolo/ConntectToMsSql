/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connecttomssql;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Administrator
 */
public class ConnectToMsSql {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Connection conn = null;

        try {
            int cnt = 0;

            String dbURL = "jdbc:sqlserver://localhost:1433;database=Dentrix;user=sa;password=Hancock@019";
            conn = DriverManager.getConnection(dbURL);
            if (conn != null) {
                DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
                System.out.println("Driver name: " + dm.getDriverName());
                System.out.println("Driver version: " + dm.getDriverVersion());
                System.out.println("Product name: " + dm.getDatabaseProductName());
                System.out.println("Product version: " + dm.getDatabaseProductVersion());

                ResultSet resultSet = null;

                try {
                    Statement statement = conn.createStatement();
                    // Create and execute a SELECT SQL statement.
                    String selectSql = "SELECT * from dbo.DDB_PAT_BASE order by LASTNAME";
                    resultSet = statement.executeQuery(selectSql);
                    // Print results from select statement
                    while (resultSet.next()) {
                        System.out.println(resultSet.getString("LASTNAME") + "," + resultSet.getString("FIRSTNAME") + "," + resultSet.getString("BIRTHDATE") + "," + resultSet.getString("SS"));
                        cnt++;
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
            System.out.println("TOTAL PAT: " + cnt);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

}
