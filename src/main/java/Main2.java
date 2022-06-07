import java.sql.*;

public class Main2 {
    public static void main(String[] args) throws SQLException {

        //DBUrl Database String
        String dbUrl="jdbc:mysql://3.237.189.167:3306/syntaxhrm_mysql";
        String userName="syntax_hrm";
        String password="syntaxhrm123";
        //Always protected by some kind of extra security layers so that no one can access
        // the database easily
        Connection connection= DriverManager.getConnection(dbUrl,userName,password);
        Statement statement=connection.createStatement();
        String query="select * from person;";
        ResultSet rs=statement.executeQuery(query);
        ResultSetMetaData resultSetMetaData= rs.getMetaData();
        for(int i=1;i<=resultSetMetaData.getColumnCount();i++){
            System.out.print(resultSetMetaData.getColumnLabel(i)+" ");
        }
        System.out.println();
        while (rs.next()){

            // with while loop we go through the rows one by one
            for(int i=1;i<=resultSetMetaData.getColumnCount();i++){
                //with for loop we go through all the columns one by one
               String nameOfColumn= resultSetMetaData.getColumnLabel(i);
               String columnValue=rs.getString(nameOfColumn);
                System.out.print(columnValue+" ");
            }
            System.out.println();
        }

        //Break till 9:00





    }
}
