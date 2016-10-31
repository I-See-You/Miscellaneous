import java.io.*;  
import java.sql.*;

public class DatabaseConnection
{
	static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	static final String DB_URL= "jdbc:oracle:thin:@localhost:1521";
	static final String USER="bakhtiar";
	static final String PASS="hasan";
	public int index;
	DatabaseConnection()
	{
		try
		{
			Class.forName(JDBC_DRIVER);
			Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = con.createStatement();
			String sql = "Select count(*) as c from problems";
			ResultSet rs = stmt.executeQuery(sql);
			rs.next();
			index = rs.getInt("C");
			con.close();
			stmt.close();
			rs.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public boolean store()
	{
		FileReceiver fr = new FileReceiver();
		fr.problemReceive();
		fr.inputReceive();
		fr.outputReceive();
		try
		{
			Class.forName(JDBC_DRIVER);
			Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
			index++;
			String sql = "Insert into problems values(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			File problem = new File("problem.txt");
			FileReader frp = new FileReader(problem);
			File input = new File("input.txt");
			FileReader finp = new FileReader(input);
			File output = new File("expected_output.txt");
			FileReader fout = new FileReader(output);
			ps.setInt(1, index);
			ps.setCharacterStream(2, frp, (int)problem.length());
			ps.setCharacterStream(3, finp, (int)input.length());
			ps.setCharacterStream(4, fout, output.length());
			ps.executeQuery();
			con.close();
			ps.close();
			problem.delete();
			input.delete();
			output.delete();
			return true;
		}
		catch(SQLException e)
		{
			return false;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	public boolean retrieveProblem(int id)
	{
		try
		{
			Class.forName(JDBC_DRIVER);
			Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
			PreparedStatement ps = con.prepareStatement("Select * from problems where id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			Clob problem = rs.getClob(2);
			Reader pr = problem.getCharacterStream();
			FileWriter fp = new FileWriter("problem.txt");
			int i;
			while((i=pr.read())!=-1)
				fp.write((char)i);
			fp.close();
			con.close();
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	public boolean retrieveIO(int id)
	{
		try
		{
			Class.forName(JDBC_DRIVER);
			Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
			PreparedStatement ps = con.prepareStatement("Select * from problems where id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			Clob input = rs.getClob(3);
			Reader ir = input.getCharacterStream();
			Clob output = rs.getClob(4);
			Reader or = output.getCharacterStream();
			FileWriter fi = new FileWriter("input.txt");
			FileWriter fo = new FileWriter("expected_output.txt");
			int i;
			while((i=ir.read())!=-1)
				fi.write((char)i);
			while((i=or.read())!=-1)
				fo.write((char)i);
			fi.close();
			fo.close();
			con.close();
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
}
