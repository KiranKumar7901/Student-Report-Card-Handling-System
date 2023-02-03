package functions;

public class Student{
	int p_marks, m_marks, c_marks, e_marks, com_marks;
	String name;
	int RollNo;
	float per;
	char grade;
	
	public char calculate(String rollno, String nam, String p_marks,String m_marks,String c_marks,String e_marks,String com_marks ) {
		RollNo = Integer.parseInt(rollno);
		name = nam;
		this.p_marks = Integer.parseInt(p_marks);
		this.m_marks = Integer.parseInt(m_marks);
		this.c_marks = Integer.parseInt(c_marks);
		this.e_marks = Integer.parseInt(e_marks);
		this.com_marks = Integer.parseInt(com_marks);
		per = (this.p_marks + this.m_marks + this.c_marks + this.e_marks + this.com_marks)/5;
		if(per>=90)
			grade='A';
		else if(per>=80)
			grade = 'B';
		else if(per>=65)
			grade='C';
		else if(per>=50)
			grade='D';
		else if(per>=33)
			grade='E';
		else
			grade='F';
		return grade;
	}
}
