package mainapp;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDAO {

	public void addUser(Registerpojo registerpoja) throws ClassNotFoundException, SQLException {
		
		String firstname=registerpoja.getFirstname();
		String lastname=registerpoja.getLastname();
		String username=registerpoja.getUsername();
		String password=registerpoja.getPassword();
		String email=registerpoja.getEmail();
		
		ConnectionManager cm=new ConnectionManager();
		
		//insert all the details into database
		String sql="insert into userdetails(firstname,lastname,username,password,email)values(?,?,?,?,?)";
		//create statement object
		PreparedStatement st=cm.getConnection().prepareStatement(sql);
		st.setString(1,firstname);
		st.setString(2,lastname);
		st.setString(3,username);
		st.setString(4,password);
		st.setString(5,email);
		
		//execute statement
		st.executeUpdate();
		cm.getConnection().close();
	}

}
