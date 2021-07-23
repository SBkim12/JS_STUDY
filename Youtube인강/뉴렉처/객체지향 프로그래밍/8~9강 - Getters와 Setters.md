Getter & Setter

ex)
public class Exam{
	int kor;
	int eng;
	int math;
}

Exam exam = new Exam();
int korea = exam.kor;
int english = exam.eng;
int math = exam.math;

exam.kor = 80;
exam.eng = 100;
exam.math = 50;

//캡슐화가 잘 되지 않음

=>
//getter & setter의 사용으로 캡슐화
//수정으로인한 구조변경시 구조가 깊어져 코드 수정이 많아지는 것을 방지할수 있음

public class Exam{
	private int kor;
	private int eng;
	private int math;
	
	public int getKor(){
		return kor;
	}
	public void setKor(int kor){
		this.kor = kor;
	}
	
	public int getEng(){
		return eng;
	}
	public void setEng(int eng){
		this.eng = eng;
	}
	
	public int getMath(){
		return math;
	}
	public void setMath(int math){
		this.math = math;
	}
	
}