import java.util.ArrayList;

public class QuestionDB {

	private ArrayList<Question> qtList;
	private QuestionDbmsService qds;
	
	public QuestionDB( )
	  {
		  qds=new QuestionDbmsService ();
		  qtList=qds.findAll();
	  }//

	public void remove(Question qu) {
		// TODO Auto-generated method stub
		//delete from ArrayList
		qtList.remove(qu);
	//delete from mysql
		qds.remove(qu);
	}

	public Question findByQuestion(String target) 
		{
			for (int i = 0; i < qtList.size(); i++) {
				Question qt = qtList.get(i);
				if(qt.getQ().equals(target))
						return qt;		//found		
			}//for
			return null;		//not found
		}

	 Question get(int i) {
		// TODO Auto-generated method stub
		return qtList.get(i);
	}

	public int size() {
		// TODO Auto-generated method stub
		return qtList.size();
	}

	 boolean add(Question qu) {
		// TODO Auto-generated method stub
		 if(qds.add(qu))
		 {
			 qtList=qds.findAll();
				return true;
		 }
		
			return false;
		 
	}
	
}
