import java.util.Objects;

public class Question {

	int questionId;
	private String q, o1,o2,o3,o4,answer;

	public String getQ() {
		return q;
	}

	public void setQ(String q) {
		this.q = q;
	}
	

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getO1() {
		return o1;
	}

	public void setO1(String o1) {
		this.o1 = o1;
	}

	public String getO2() {
		return o2;
	}

	public void setO2(String o2) {
		this.o2 = o2;
	}

	public String getO3() {
		return o3;
	}

	public void setO3(String o3) {
		this.o3 = o3;
	}

	public String getO4() {
		return o4;
	}

	public void setO4(String o4) {
		this.o4 = o4;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Question(String q, String o1, String o2, String o3, String o4, String answer) {
		super();
		this.q = q;
		this.o1 = o1;
		this.o2 = o2;
		this.o3 = o3;
		this.o4 = o4;
		this.answer = answer;
	}

	public Question(int questionId, String q, String o1, String o2, String o3, String o4, String answer) {
		super();
		this.questionId = questionId;
		this.q = q;
		this.o1 = o1;
		this.o2 = o2;
		this.o3 = o3;
		this.o4 = o4;
		this.answer = answer;
	}

	public String toString()
	{
		return q+"\n"+o1+"\n"+o2+"\n"+o3+"\n"+o4;
		
}

	@Override
	public int hashCode() {
		return Objects.hash(answer, o1, o2, o3, o4, q);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Question other = (Question) obj;
		return Objects.equals(answer, other.answer) && Objects.equals(o1, other.o1) && Objects.equals(o2, other.o2)
				&& Objects.equals(o3, other.o3) && Objects.equals(o4, other.o4) && Objects.equals(q, other.q);
	}
}
