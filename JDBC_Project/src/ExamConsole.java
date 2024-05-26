
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExamConsole {

	private QuestionDB qdb;
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		public ExamConsole() {
			super();
			// TODO Auto-generated constructor stub
			qdb= new  QuestionDB();
		}
		int teacherMenu() throws  IOException
		{
			System.out.println("~~Teacher Menus~~");
			System.out.println("1-->Add a question");
			System.out.println("2-->Delete a question");
			System.out.println("3--> Show all questions");		
			System.out.println("4--> Back to Main Menu");
			System.out.println("\t\tEnter your choice");
			int choice=Integer.parseInt(br.readLine());
			return choice;		
		}
		int studentMenus() throws  IOException
		{
			System.out.println("~~Student Menus~~");
			System.out.println("1--> Start Exam");
			System.out.println("2--> Back to Main Menu");
			System.out.println("\t\tEnter your choice");
			int choice=Integer.parseInt(br.readLine());
			return choice;		
		}
		int mainMenu() throws  IOException
		{
			System.out.println("~~Menu-driven program~~");
			System.out.println("1-->Teacher Login");
			System.out.println("2-->Student Login");		
			System.out.println("3--> Exit");
			System.out.println("\t\tEnter your choice");
			int choice=Integer.parseInt(br.readLine());
			return choice;		
		}
		void start() throws  IOException
		{
			int choice;
			String userName;
			int password;
			while(true)
			{		
				choice=mainMenu();
				switch(choice)
				{
				case 1:	//Teacher Login
								System.out.println("Teacher - Enter user-name and password");
								userName=br.readLine();
								password=Integer.parseInt(br.readLine());
								if(userName.equals("abcd") && password==1234)
								{
									System.out.println("Login Success");
									showTeacherMenus();
								}
								else
								{
									System.out.println("Sorry... wrong credentials");
								}
								break;
				case 2:	//Student Login		
								System.out.println("Student - Enter user-name and password");
								userName=br.readLine();
								password=Integer.parseInt(br.readLine());
								if(userName.equals("xyz") && password==5678)
								{
									System.out.println("Login Success");
									showStudentMenus();
								}
								else
								{
									System.out.println("Sorry... wrong credentials");
								}
								break;
				case 3: //Exit
								System.out.println("Program ends");
					return;									
				}//switch
			}//while
		}//start
		void showTeacherMenus() throws IOException
		{
			int choice;
			String target;
			Question qu;
			while(true)
			{		
				choice=teacherMenu();
				switch(choice)
				{
				case 1:	//Add a question
								qu=readQuestion();
								qdb.add(qu);
								System.out.println("Question added successfully");
								break;
				case 2:	//delete a question
								System.out.println("Enter some text from the question");
								target=br.readLine();
								qu=qdb.findByQuestion(target);
								if(qu==null)
									System.out.println("No such question");
								else
								{
										System.out.println("Present... the data is");
										System.out.println(qu);
										qdb.remove(qu);
										System.out.println("Delete operation successful");
								}
							break;
				case 3:	//show all questions
					
					break;						
				case 4: //Exit
							return;						
				}//switch
			}//while	
		}//showTeacherMenus
		void showStudentMenus() throws IOException
		{
			int choice;		
			while(true)
			{		
				choice=studentMenus();
				switch(choice)
				{
				case 1:	//Start exam
								examStart();
								break;
				case 2: //Exit
							return;						
				}//switch
			}//while	
		}//showStudentMenus

		public void examStart() throws IOException
		{
			//code of exam
			// display 10 questions
			int i, score=0;
			Question qu;
			if(qdb.size()==0)
			{
				System.out.println("No questions yet !");
				return;
			}
			if(qdb.size()==1)
			{
				System.out.println("There is one question.");
			}
			else
			{
				System.out.println("There are total "+qdb.size() +" questions");
			}		
			for (i = 0; i <qdb.size()  ; i++) {
				System.out.println("\t\tQuestion No. "+(i+1));
				qu=qdb.get(i);
				System.out.println(qu);
				// ask user to enter answer
				System.out.println("Enter your answer\t");
				String userAnswer = br.readLine();
				//check answer
				String correctAnswer=qu.getAnswer();
				if(userAnswer.equalsIgnoreCase(correctAnswer))
				{
					System.out.println("\t\tCorrect");
					score++;
				}
				else
				{
					System.out.println("\t\tWrong... Correct answer is "+correctAnswer);				
				}
			}//for
			System.out.println("You scored "+score +" marks ouf of "+qdb.size()+" marks");
		}//main
		Question readQuestion()
		{
			String q,o1,o2,o3,o4,answer;
			Question qu=null;
			try {
				System.out.println("Enter the question");
				q=br.readLine();
				System.out.println("Enter option A");
				o1=br.readLine();
				System.out.println("Enter option B");
				o2=br.readLine();
				System.out.println("Enter option C");
				o3=br.readLine();
				System.out.println("Enter option D");
				o4=br.readLine();
				System.out.println("Enter answer");
				answer=br.readLine();
				qu=new Question(q, o1, o2, o3, o4, answer); 			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return qu;
		}
}
