import java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Program started");
        String url = "JDBC:mysql://localhost:3306/scott";
        String username = "root";
        String password = "asdf";

        System.out.println("Connecting to database.....");
        Connection con = DriverManager.getConnection(url, username, password);
        System.out.println("✅ Database connection successful.");

        String getEmp = "select * from emp";
        String insertQuery = "INSERT INTO EMP VALUES(9999, 'Kshitij', 'DEVELOPER', 7522, '2026-01-01', 1000, null, 10)";

        Statement st = con.createStatement();

        int rows = st.executeUpdate(insertQuery);
        System.out.println("Rows: " + rows);

        ResultSet rset = st.executeQuery(getEmp);

        while (rset.next()) {
            System.out.println(
                    rset.getInt("EMPNO") + " " +
                    rset.getString("ENAME") + " " +
                    rset.getString("JOB") + " " +
                    rset.getInt("SAL") +  " " + rset.getDate(5)
            );
        }

        rset.close();
        st.close();
        con.close();

    }
}