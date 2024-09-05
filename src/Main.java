import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main {
    public static void main(String[] args) {
        // SQLite 连接 URL
        String url = "jdbc:sqlite:database.db";

        // SQL 语句用于创建表
        String sql = "CREATE TABLE IF NOT EXISTS user (\n"
                + " id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                + " name TEXT NOT NULL\n"
                + ");";

        // 连接数据库并执行 SQL 语句
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            // 执行创建表的 SQL 语句
            stmt.execute(sql);
            System.out.println("Table 'user' created successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        // SQL 语句，用于插入数据
        String insertSql = "INSERT INTO user(name) VALUES(?)";

        // 连接数据库并插入几条用户数据
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(insertSql)) {

            // 插入第一个用户
            pstmt.setString(1, "Alice");
            pstmt.executeUpdate();

            // 插入第二个用户
            pstmt.setString(1, "Bob");
            pstmt.executeUpdate();

            // 插入第三个用户
            pstmt.setString(1, "Charlie");
            pstmt.executeUpdate();

            System.out.println("Users inserted successfully.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        // 连接数据库并执行查询
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM user")) {

            // 遍历结果集并打印每一行
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                System.out.println("ID: " + id + ", Name: " + name);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}