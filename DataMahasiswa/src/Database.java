import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class Database {
    private Connection connection;
    private Statement statement;

    public   Database(){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_mahasiswa","root","");
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    // query untuk select
    public ResultSet selectQuery(String sql){
        try {
            statement.executeQuery(sql);
            return  statement.getResultSet();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    // query untuk create update delete
    public   int crudQuery(String sql){
        try {
            return  statement.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Statement getStatement() {
        return statement;
    }

    // Untuk mengembalikan jumlah count sebuah query yang berdampak ke sebuah tabel di database
    public int getCount(String query) {
        int count = 0;
        try {
            ResultSet resultSet = statement.executeQuery(query);

            // Membaca jumlah baris yang dikembalikan oleh query
            if (resultSet.next()) {
                count = resultSet.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
}
