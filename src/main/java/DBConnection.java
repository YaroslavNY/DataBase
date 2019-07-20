import javax.sql.ConnectionPoolDataSource;
import java.sql.*;

public class DBConnection {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:h2:~/test";
        String user = "sa";
        String password = "";

        ProductDAO dao = new ProductDAO(url, user, password);
        Product product = new Product("Кружка", 100);
        dao.create(product);
        Product product2 = dao.read("Огурцы Б");
        System.out.println(product2.getName() + " " + product2.getCost());

//        try(PreparedStatement statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS  products(id int  NOT NULL auto_increment, name  VARCHAR(15) NOT NULL, PRIMARY KEY(id));")){
//            statement.executeUpdate();
//        }
//       try(PreparedStatement statement = connection.prepareStatement("INSERT INTO products(name) VALUES ((?));")){
//            statement.setString(1, "Помидоры");
//            statement.executeUpdate();
//        }
//        try(PreparedStatement statement = connection.prepareStatement("ALTER TABLE products ADD cost int DEFAULT 0;")){
//            statement.executeUpdate();
//        }
//        try(PreparedStatement statement = connection.prepareStatement("UPDATE products SET cost = 50 WHERE name = (?)")){
//            statement.setString(1,"Помидоры");
//            statement.executeUpdate();
//        }
//        try(PreparedStatement statement = connection.prepareStatement("SELECT name ,SUM(cost) as sumCost FROM products GROUP  BY name ORDER BY  name ASC, sumCost  ASC;")){
//            ResultSet resultSet = statement.executeQuery();
//            while(resultSet.next()){
//                System.out.println(resultSet.getString("name") + " " + resultSet.getString("sumCost"));
//            }
//        }

       // connection.close();

    }
}
