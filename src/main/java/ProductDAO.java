import java.sql.*;

public class ProductDAO implements DAO<Product, String> {
    private Connection connection;

    ProductDAO(String url, String user, String password){
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void create(Product product) {
        try(PreparedStatement statement = connection.prepareStatement(SQLCommands.CREATE.command)){
            statement.setString(1, product.getName());
            statement.setInt(2, product.getCost());
            statement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Product read(String name) {
        Product product = new Product();
        try(PreparedStatement statement = connection.prepareStatement(SQLCommands.READ.command)) {
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                product.setId(resultSet.getInt("id"));
                product.setName(resultSet.getString("name"));
                product.setCost(resultSet.getInt("cost"));

            }
        } catch (SQLException e) {
          e.printStackTrace();
        }
        return product;
    }

    @Override
    public void update(Product product) {

    }

    @Override
    public void delete(Product product) {

    }

    enum SQLCommands{
        CREATE("INSERT INTO products(name, cost) VALUES((?), (?));"),
        READ("SELECT * FROM products WHERE name = (?);"),
        UPDATE("UPDATE products SET (?) WHERE (?);"),
        DELETE("DELETE FROM products WHERE (?);");
        String command;
        SQLCommands(String command){
            this.command = command;
        }
    }

}
