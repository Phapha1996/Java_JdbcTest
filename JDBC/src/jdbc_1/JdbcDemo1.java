package jdbc_1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemo1 {

	public static void main(String[] args) throws SQLException, Exception {
		
		String url="jdbc:mysql://localhost:3306/fage?useUnicode=true&characterEncoding=utf-8";
		String username="root";
		String password="root";
		
		//1.加载驱动
		
			Class.forName("com.mysql.jdbc.Driver");

		//2.得到连接数据库的对象并且连接
			
		Connection con = DriverManager.getConnection(url, username, password);
		
		//3.获取可以向数据库发送sql语句的statement
		
		Statement st = con.createStatement();

		
		
		//4.向数据库发sql语句，并且获得一个代表结果集的resultset
	
		String sql = "SELECT * FROM student";
		ResultSet rs = st.executeQuery(sql);
		
		
		//5.取出结果集的数据
		
		while(rs.next()){
			System.out.println("id:"+rs.getObject("id"));
			System.out.println("name:"+rs.getObject("name"));
			System.out.println("chinese:"+rs.getObject("chinese"));
			System.out.println("english:"+rs.getObject("english"));
			System.out.println("math:"+rs.getObject("math"));
		}
		
		//6.关闭各种对象

		con.close();
		st.close();
		rs.close();
	}

}
