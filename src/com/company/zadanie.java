package com.company;

import java.sql.*;

public class zadanie {
    public static void main() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");

        Connection con = DriverManager.getConnection
                ("jdbc:postgresql://msz-test.chq8qedm9jee.eu-west-1.rds.amazonaws.com/postgres"
                        , "postgres", "1dQxvBLTEpKTfgxQGD5FN"
                        );
        System.out.println("Database Connected ..");

        Statement st = con.createStatement();

        st.execute("DROP TABLE student_Witkowski");

        st.execute("CREATE TABLE student_Witkowski(id int primary key, " +
                "first_name varchar, last_name varchar )");

        st.execute
                ("INSERT INTO student_Witkowski(id,first_name,last_name) VALUES" +
                        "('0','Michal','Witkowski')");

        ResultSet rs = st.executeQuery("SELECT id,first_name,last_name FROM student_Witkowski");

        while(rs.next()) {
            System.out.println(rs.getInt("id"));
            System.out.println(rs.getString("first_name"));
            System.out.println(rs.getString("last_name"));
        }
        st.close();
        con.close();
    }
}
