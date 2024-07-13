import java.sql.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws SQLException {
        selectDemo();
        insertIntoDemo();
        updateDemo();
        deleteDemo();

    }

    public static void selectDemo() throws SQLException{
        Connection connection = null;
        Dbhelper helper = new Dbhelper();
        Statement statement = null;
        ResultSet resultSet;

        try{
            connection = helper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM world.country;");
            ArrayList<Country> countries = new ArrayList<Country>();
            while(resultSet.next()){
                countries.add(new Country(
                        resultSet.getString("Code"),
                        resultSet.getString("Name"),
                        resultSet.getString("Continent"),
                        resultSet.getString("Region")));
            }
            System.out.println(countries.size());


        } catch (SQLException exception){
            helper.showErrorMessage(exception);
        }finally {
            connection.close();
            statement.close();
        }
    }

    public static void insertIntoDemo() throws SQLException {
        Connection connection = null;
        Dbhelper helper = new Dbhelper();
        PreparedStatement statement = null;

        try{
            connection = helper.getConnection();
            String sql = "insert into city(Name,CountryCode,District,Population) values(?,?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1,"Yozgat");
            statement.setString(2,"TUR");
            statement.setString(3,"Türkiye");
            statement.setInt(4,66000);
            statement.executeUpdate();
            System.out.println("Kayıt eklendi");

        } catch (SQLException exception){
            helper.showErrorMessage(exception);

        }finally {
            statement.close();
            connection.close();
        }
    }

    public static void updateDemo() throws SQLException{
        Connection connection = null;
        Dbhelper helper = new Dbhelper();
        PreparedStatement statement = null;

        try{
            connection = helper.getConnection();
            String sql = "update city set population = 66666 where id = 4082 ";
            statement = connection.prepareStatement(sql);
            statement.executeUpdate();
            System.out.println("Kayıt güncellendi");

        } catch (SQLException exception){
            helper.showErrorMessage(exception);

        }finally {
            statement.close();
            connection.close();
        }
    }

    public static void deleteDemo() throws SQLException{
        Connection connection = null;
        Dbhelper helper = new Dbhelper();
        PreparedStatement statement = null;

        try{
            connection = helper.getConnection();
            String sql = "delete from city where id = ? ";
            statement = connection.prepareStatement(sql);
            statement.setInt(1,4082);
            statement.executeUpdate();
            System.out.println("Kayıt silindi");

        } catch (SQLException exception){
            helper.showErrorMessage(exception);

        }finally {
            statement.close();
            connection.close();
        }
    }


}