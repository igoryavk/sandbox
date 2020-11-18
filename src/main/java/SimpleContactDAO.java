import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SimpleContactDAO implements ContactDAO {
    static {
        try{
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://localhost/mybase","spring","yavkin85");
    }
    private void closeConnection(Connection connection)
    {
        if (connection==null)
        {
            return;
        }
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    @Override
    public List<Contact> findAll() {
        List<Contact> result=new ArrayList<>();
        Connection connection=null;

        try {
            connection=getConnection();
            PreparedStatement statement=
                    connection.prepareStatement("select * from contacts");
            ResultSet resultSet=statement.executeQuery();
            while (resultSet.next())
            {
               Contact contact=new Contact();
               contact.setId(resultSet.getInt("id"));
               contact.setName(resultSet.getString("name"));
               contact.setPhone(resultSet.getString("phone"));
               result.add(contact);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Contact> findByFirstName(String firstName) {
        return null;
    }

    @Override
    public void insert(Contact contact) {

    }

    @Override
    public void update(Contact contact) {

    }

    @Override
    public void delete(Contact contact) {

    }
}
