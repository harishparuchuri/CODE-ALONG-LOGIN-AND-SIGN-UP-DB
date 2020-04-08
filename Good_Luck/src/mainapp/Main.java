package mainapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		System.out.println("1. Register Here");
		System.out.println("2. Log In");
		int x;
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		x=Integer.parseInt(br.readLine());
		
		//objects
		Registerpojo registerpoja=new Registerpojo();
		RegisterDAO registerdao=new RegisterDAO();
		Loginpojo loginpojo=new Loginpojo();
		LoginDAO logindao=new LoginDAO();
		switch(x)
		{
		case 1:
			System.out.println("enter First Name");
			String firstname=br.readLine();
			System.out.println("Enter Last Name");
			String lastname=br.readLine();
			System.out.println("Enter the user name");
			String username=br.readLine();
			System.out.println("Enter password");
			String password=br.readLine();
			System.out.println("Entr Email");
			String email=br.readLine();
			
			registerpoja.setFirstname(firstname);
			registerpoja.setLastname(lastname);
			registerpoja.setUsername(username);
			registerpoja.setPassword(password);
			registerpoja.setEmail(email);
			registerdao.addUser(registerpoja);
			break;
		case 2:
			
			System.out.println("Enter the user name");
			String name=br.readLine();
			System.out.println("Enter password");
			String pass=br.readLine();
			
			loginpojo.setUsername(name);
			loginpojo.setPassword(pass);
			
			if(logindao.Validate(loginpojo)==true)
			{
				Luck luck=new Luck();
				luck.display(name);
			}
			else
			{
				System.out.println("Incorect USername OR PAssword");
			}
			
			break;
		}

	}

}
