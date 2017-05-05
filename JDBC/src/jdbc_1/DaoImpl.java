package jdbc_1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;
//数据库增删改查
public class DaoImpl {
	
	//增
	@Test
	public void insert(){
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			 con = JdbcUtils.getConnection();
			 st = con.createStatement();
			 String sql = "INSERT INTO user (id,username,password,email,birthday,nickname) VALUES ('456455549','fageqq5','12356','111qww@qq.com','1999-4-8','发哥');";
			 int num = st.executeUpdate(sql);
			 if(num>0){
				 System.out.print("插入成功");
			 }
			
		} catch (SQLException e) {
	
			e.printStackTrace();
		}finally{
			JdbcUtils.release(con, st, rs);
		}
	}
	
	//删
	@Test
	public void delete(){
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			 con = JdbcUtils.getConnection();
			 st = con.createStatement();
			 String sql = "DELETE FROM student WHERE name='wjofoo'";
			 int num = st.executeUpdate(sql);
			 if(num>0){
				 System.out.print("删除成功！");
			 }
			
		} catch (SQLException e) {
	
			e.printStackTrace();
		}finally{
			JdbcUtils.release(con, st, rs);
		}
	}
	
	//改
	@Test
	public void update(){
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			 con = JdbcUtils.getConnection();
			 st = con.createStatement();
			 String sql = "UPDATE student SET name='wjofoo' WHERE name='Hmamama'";
			 int num = st.executeUpdate(sql);
			 if(num>0){
				 System.out.println("更新成功！");
			 }
			 
		} catch (SQLException e) {
	
			e.printStackTrace();
		}finally{
			JdbcUtils.release(con, st, rs);
		}
	}
	
	//查
	@Test
	public void find(){
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			 con = JdbcUtils.getConnection();
			 st = con.createStatement();
			 String sql = "SELECT name FROM student";
			 rs = st.executeQuery(sql);
			 if(rs.next()){
				 System.out.println(rs.getString("name"));
			 }
		} catch (SQLException e) {
	
			e.printStackTrace();
		}finally{
			JdbcUtils.release(con, st, rs);
		}
	}
	
}
