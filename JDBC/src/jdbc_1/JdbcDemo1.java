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
		
		//1.��������
		
			Class.forName("com.mysql.jdbc.Driver");

		//2.�õ��������ݿ�Ķ���������
			
		Connection con = DriverManager.getConnection(url, username, password);
		
		//3.��ȡ���������ݿⷢ��sql����statement
		
		Statement st = con.createStatement();

		
		
		//4.�����ݿⷢsql��䣬���һ��һ������������resultset
	
		String sql = "SELECT * FROM student";
		ResultSet rs = st.executeQuery(sql);
		
		
		//5.ȡ�������������
		
		while(rs.next()){
			System.out.println("id:"+rs.getObject("id"));
			System.out.println("name:"+rs.getObject("name"));
			System.out.println("chinese:"+rs.getObject("chinese"));
			System.out.println("english:"+rs.getObject("english"));
			System.out.println("math:"+rs.getObject("math"));
		}
		
		//6.�رո��ֶ���

		con.close();
		st.close();
		rs.close();
	}

}
