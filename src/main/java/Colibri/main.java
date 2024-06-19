package Colibri;

import java.sql.*;

public class main {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydbtest";
    private static final String USER = "root";
    private static final String PWD = "root";

    public static void main(String[] args) {



        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL,USER,PWD);
            if(!connection.isClosed()){
                System.out.println("yes");
            }
            Statement statement = connection.createStatement();
           // statement.execute("INSERT INTO animal(anim_name, anim_desc) VALUES ('name','desc');");

           // int res = statement.executeUpdate("UPDATE animal SET anim_name='New Name' WHERE id=1;");
            //System.out.println(res);

           // ResultSet set = statement.executeQuery("SELECT * FROM animal;");

            statement.addBatch("INSERT INTO animal(anim_name, anim_desc) VALUES ('name1','desc1');");
            statement.addBatch("INSERT INTO animal(anim_name, anim_desc) VALUES ('name2','desc2');");
            statement.addBatch("INSERT INTO animal(anim_name, anim_desc) VALUES ('name3','desc3');");

            statement.executeBatch();

            statement.clearBatch();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
