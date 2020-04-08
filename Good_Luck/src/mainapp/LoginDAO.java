package mainapp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDAO {

	public boolean Validate(Loginpojo loginpojo) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		String username=loginpojo.getUsername();
		String password=loginpojo.getPassword();
		
		ConnectionManager con=new ConnectionManager();
		Statement st=con.getConnection().createStatement();
		int flag=0;
		ResultSet rs=st.executeQuery("select * from userdetails");
		
		while(rs.next())
		{
			if(username.equals(rs.getString("username")) && password.equals(rs.getString("password")))
			{
				con.getConnection().close();
				flag=1;
			}
			else
			{
				con.getConnection().close();
				flag=0;
			}
		}
		if(flag==1)
			return true;
		else
			return false;
		
		
	}

}
