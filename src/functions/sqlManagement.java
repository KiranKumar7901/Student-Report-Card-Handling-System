package functions;
import java.sql.*;

public class sqlManagement {
	
	public sqlManagement() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
		
//Use of Insert Query
		
/*		PreparedStatement ps=con.prepareStatement("insert into Student values(?,?)");
		ps.setInt(1, 2);
		ps.setString(2, "Aryan");
		ps.executeUpdate();
*/
		
// Use of Select Query
		
/*		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("Select * from student");
		
		while(rs.next())
			System.out.println(rs.getInt(1)+" "+rs.getString(2));
*/
		
//Use of Update Query
		
/*		PreparedStatement ps = con.prepareStatement("update Student set name=? where rollno=?");
		ps.setString(1, "Arun");
		ps.setInt(2, 1);
		ps.executeUpdate();
*/
		
// Use of delete query
		
/*		PreparedStatement ps=con.prepareStatement("delete from Student where rollno=?");
		ps.setInt(1, 1);
		ps.executeUpdate();
*/
		PreparedStatement ps = con.prepareStatement("Select * from Student where rollno=?");
		ps.setInt(1, 6);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getString(2));
		}
		con.close();
	}

}
