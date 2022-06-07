import com.sun.org.apache.bcel.internal.generic.RETURN;
import com.sun.prism.shader.Solid_Color_AlphaTest_Loader;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main4 {
    public static void main(String[] args) {

        //DBUrl Database String
        String dbUrl = "jdbc:mysql://3.237.189.167:3306/syntaxhrm_mysql";
        String userName = "syntax_hrm";
        String password = "syntaxhrm123";
        //Always protected by some kind of extra security layers so that no one can access
        // the database easily
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            connection = DriverManager.getConnection(dbUrl, userName, password);
            statement = connection.createStatement();
            String query = "select * from person;";
            rs = statement.executeQuery(query);
            List<Map<String, String>> tableData = new ArrayList<>();
            tableData = DBUtils.getListOfMapFromRS(rs);
            System.out.println(tableData);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeConnection(connection);
            DBUtils.closeStatement(statement);
            DBUtils.closeResultSet(rs);
        }
    }


}
