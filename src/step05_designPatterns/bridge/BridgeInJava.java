package step05_designPatterns.bridge;

import java.sql.*;

public class BridgeInJava {
    public static void main(String[] args) throws ClassNotFoundException {
        //JDBC
        Class.forName("org.h2.Driver");//구체적 코드 위치


        //추상적 브릿지 사용
        try (
                Connection conn = DriverManager.getConnection(
                        "jdbc:h2:mem:~/test",
                        "sa",
                        ""
                )
        ) {

            String sql = "CREATE TABLE ACCOUNT " +
                    "(" +
                    "id INTEGER NOT NULL AUTO_INCREMENT, " +
                    "email VARCHAR(255), " +
                    "name VARCHAR(255), " +
                    "address VARCHAR(255), " +
                    "PRIMARY KEY ( id )" +
                    ")";

            Statement statement = conn.createStatement();
            statement.execute(sql);

//            PreparedStatement preparedStatement = conn.prepareStatement(sql);
//            ResultSet resultSet = preparedStatement.executeQuery(sql);

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
