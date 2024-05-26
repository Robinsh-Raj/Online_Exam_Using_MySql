import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class QuestionDbmsService {

	static Connection con ;
	static Statement sm;
	static PreparedStatement psm;
	static PreparedStatement psm1;
	static String query;
	static ResultSet rs;
	
	static String connectionUrl="jdbc:mysql://localhost:3306/?", userName="root", password="1234";
	
	
	
	public QuestionDbmsService() {

		init();
	}
	public void init() {
		 try {
			con=DriverManager.getConnection(connectionUrl, userName, password);
			sm=con.createStatement();
			
			//create database
			query="create database if not exists college";
			sm.execute(query);
			query="use college";
			sm.execute(query);
			
			//create table if not exists
			query="create table if not exists exam (questionId int primary key auto_increment, q varchar (1000), o1 varchar (500), o2 varchar (500),o3 varchar (500),o4 varchar (500), answer varchar (500) )";
			sm.execute(query);
			
			// Create a preparedStatement object also
						query="insert into exam (q, o1 , o2 , o3 , o4 , answer) values (?,?,?,?,?,?)";
						psm=con.prepareStatement(query);
						//
						//query="update exam set rollno=?, name=?, marks=? where questionId=?";
						//psm1=con.prepareStatement(query);
		} catch (SQLException e) {
			System.out.println(e);
			e.printStackTrace();
		}

	}

	public ArrayList<Question> findAll() {
		ArrayList<Question> qtList=new ArrayList<Question>();
		query="select * from exam";
		try {
			rs=sm.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int questionId;
		String q,o1,o2,o3,o4,answer ;
		Question qt;
		try {
			while(rs.next())
			{
				questionId=rs.getInt("questionId");
				q=rs.getString("q");
				o1=rs.getString("o1");
				o2=rs.getString("o2");
				o3=rs.getString("o3");
				o4=rs.getString("o4");
				answer=rs.getString("answer");
				qt=new Question(questionId, q, o1, o2,o3,o4,answer);
				qtList.add(qt);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//while	
		return qtList;
	}
	boolean add(Question q)
	{
		try {
			psm.setString(1, q.getQ() );
			psm.setString(2, q.getO1() );
			psm.setString(3, q.getO2() );
			psm.setString(4, q.getO3() );
			psm.setString(5, q.getO4() );
			psm.setString(6, q.getAnswer() );
			psm.execute();
		} catch (SQLException e) {
			System.out.println(e);
			// TODO Auto-generated catch block
				return false;
		}
		return true; //success
	}
	void remove(Question qt)
	{
		query="delete from exam where questionId="+qt.getQuestionId();
		try {
			sm.execute(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
