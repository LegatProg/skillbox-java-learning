import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/skillbox";
        String usr = "root";
        String pass = "rfhntkmfkjuj";
        try {
            Connection connection = DriverManager.getConnection(url, usr, pass);
            Statement statement = connection.createStatement();
            String sqlQuery = "SELECT course_name,\n" +
                    "count(course_name) / (max(month(subscription_date)) - min(month(subscription_date)) + 1) as Average_sales\n" +
                    "FROM purchaseList \n" +
                    "group by course_name;";
            ResultSet set = statement.executeQuery(sqlQuery);
            while (set.next()) {
                System.out.println(set.getString(1) + " - " + set.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
