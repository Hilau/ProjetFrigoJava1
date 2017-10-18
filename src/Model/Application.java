package Model;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Application
{
    private String url = "jdbc:mysql://localhost:3306/projetjavafrigo";
    private String user = "root";
    private String password = "";
    private java.sql.Connection connection = null;
    private Requests request;
    private Statement statement;
    private ResultSet data;

    public Application()
    {
        this.loadDriver();
        try
        {
            this.connection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        this.request = new Requests();
    }

    /**
     * This method is used to load driver JDBC for MySQL
     */
    private void loadDriver()
    {
        /* Chargement du driver JDBC pour MySQL */
        try
        {
            Class.forName( "com.mysql.jdbc.Driver" );
        }
        catch ( ClassNotFoundException e )
        {
            System.out.print(e);
        }
    }

    /**
     * This method is used to establish connection to the database
     */
    private void connection() throws SQLException
    {
        this.connection = DriverManager.getConnection(this.url, this.user, this.password);
        this.statement = connection.createStatement();
    }

    public void insert(int temperature, int hygrometry)
    {
        this.request.setTemperature(temperature);
        this.request.setHygrometry(hygrometry);

        try
        {
            statement.executeUpdate(this.request.insert());
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void selectAll()
    {
        try
        {
            this.data = this.statement.executeQuery(this.request.selectAll());

            while (data.next())
            {
                int id = data.getInt( "id" );
                int temperature = data.getInt( "temperature" );
                int hygrometry = data.getInt( "hygrometry" );
                int time = data.getInt( "time" );

                System.out.println("Temperature = " + temperature);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void selectLast()
    {
        try
        {
            this.data = this.statement.executeQuery(this.request.selectLast());

            while (data.next())
            {
                int id = data.getInt( "id" );
                int temperature = data.getInt( "temperature" );
                int hygrometry = data.getInt( "hygrometry" );
                int time = data.getInt( "time" );

                System.out.println("Temperature = " + temperature);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
