package functions;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StudentReportCard extends JFrame{
	Student st =new Student();
	JLabel rc,rc1,name,rollno,sub,p,m,c,e1,comp,marks,per,grade;
	JLabel rn,tmarks,tname,trn,tp,tm,tc,te,tcomp,tp100,tm100,tc100,te100,tcs100,tper,tgrade;
	TextField rn1;
	JButton rn2;
	JPanel p1,p2,p3,p4,p5,p6,mainpanel;
	
	int rn3;
	String nam;
	int ph,ch,ma,en,cs;
	
	PreparedStatement ps ;
	Connection con;
	ResultSet rs;
	
	public StudentReportCard() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
			ps = con.prepareStatement("Select * from Student where rollno=?");
		} catch (ClassNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		FlowLayout f = new FlowLayout();
		setLayout(f);
		setVisible(true);
		setSize(1080, 640);
		f.setVgap(5);

		mainpanel =new JPanel(new GridLayout(5,1));
		p1 = new JPanel(new GridLayout());
		p6 = new JPanel(new GridLayout());
		p2 = new JPanel(new GridLayout(1, 3));
		p3 = new JPanel(new GridLayout(1, 4));
		p4 = new JPanel(new GridLayout(6, 3));
		p5 = new JPanel(new GridLayout(1,4));
		
		rn = new JLabel("Enter Roll No: ");
		rn1 = new TextField();
		rn2 = new JButton("Search for a Report Card Of a Student");
		p2.add(rn);
		p2.add(rn1);
		p2.add(rn2);
		
		rc = new JLabel(":----------------------------: Student Report Card :----------------------------:", JLabel.CENTER);
		rc1 = new JLabel(":---------------------------------------::-------------------------------------:", JLabel.CENTER);
		rc.setFont(new Font("Times New Roman", Font.PLAIN, 36));
		rc1.setFont(new Font("Times New Roman", Font.PLAIN, 36));
		
		
		
		name = new JLabel("<html><style>div{color: blue; font-size: 18px; font-weight: bold; font-family: 'times new roman';}</style><div>Name: </div></html>",JLabel.RIGHT);
		tname = new JLabel();
		tname.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		rollno = new JLabel("<html><style>div{color: blue; font-size: 18px; font-weight: bold; font-family: 'times new roman';}</style><div>Roll No: </div></html>",JLabel.RIGHT);
		rollno.setFont(new Font("Times New Roman", Font.BOLD, 18));
		trn = new JLabel();
		trn.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		sub = new JLabel("Subjects");
		sub.setFont(new Font("Times New Roman", Font.BOLD, 18));
		marks = new JLabel("Marks Obtained",JLabel.CENTER);
		marks.setFont(new Font("Times New Roman", Font.BOLD, 18));
		tmarks = new JLabel("Total Marks",JLabel.CENTER);
		tmarks.setFont(new Font("Times New Roman", Font.BOLD, 18));
		p = new JLabel("Physics");
		p.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		tp = new JLabel();
		tp.setAlignmentX(5000f);
		tp.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		tp100 = new JLabel("100",JLabel.CENTER);
		tp100.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		m = new JLabel("Mathematics");
		m.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		tm = new JLabel();
		tm.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		tm100 = new JLabel("100",JLabel.CENTER);
		tm100.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		c = new JLabel("Chemistry");
		c.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		tc = new JLabel();
		tc.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		tc100 = new JLabel("100",JLabel.CENTER);
		tc100.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		e1 = new JLabel("English");
		e1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		te = new JLabel();
		te.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		te100 = new JLabel("100",JLabel.CENTER);
		te100.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		comp = new JLabel("Computer");
		comp.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		tcomp = new JLabel();
		tcomp.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		tcs100 = new JLabel("100",JLabel.CENTER);
		tcs100.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		
		per = new JLabel("Percentage: ",JLabel.RIGHT);
		per.setFont(new Font("Times New Roman", Font.BOLD, 18));
		tper = new JLabel();
		tper.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		grade = new JLabel("Grade: ",JLabel.RIGHT);
		grade.setFont(new Font("Times New Roman", Font.BOLD, 18));
		tgrade = new JLabel();
		tgrade.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		
		rn2.addActionListener(e -> {
			rn3 = Integer.parseInt(rn1.getText());
			System.out.println(rn3);

			try {
				ps.setInt(1, rn3);
				rs = ps.executeQuery();
				while (rs.next()) {
					nam = rs.getString(2);
					ph = rs.getInt(3);
					ch = rs.getInt(4);
					ma = rs.getInt(5);
					en = rs.getInt(6);
					cs = rs.getInt(7);
					
				}
				
				float pert = (float)(ph+ch+ma+en+cs)/5;
				char grad = st.calculate(Integer.toString(rn3), nam, Integer.toString(ph), Integer.toString(ma), Integer.toString(ch), Integer.toString(en), Integer.toString(cs));
				tname.setText(nam);
				trn.setText(Integer.toString(rn3));
				tp.setText(Integer.toString(ph));
				tm.setText(Integer.toString(ma));
				tc.setText(Integer.toString(ch));
				te.setText(Integer.toString(en));
				tcomp.setText(Integer.toString(cs));
				tper.setText(Float.toString(pert));
				tgrade.setText(String.valueOf(grad));		
				
				
				p1.add(rc);
				p3.add(name);
				p3.add(tname);
				p3.add(rollno);
				p3.add(trn);
				p4.add(sub);
				p4.add(marks);
				p4.add(tmarks);
				p4.add(p);
				p4.add(tp);
				p4.add(tp100);
				p4.add(m);
				p4.add(tm);
				p4.add(tm100);
				p4.add(c);
				p4.add(tc);
				p4.add(tc100);
				p4.add(e1);
				p4.add(te);
				p4.add(te100);
				p4.add(comp);
				p4.add(tcomp);
				p4.add(tcs100);
				
				p5.add(per);
				p5.add(tper);
				p5.add(grade);
				p5.add(tgrade);
				
				p6.add(rc1);

				con.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			p2.setVisible(false);
		});
		
		mainpanel.add(p1);
//		mainpanel.add(p2);
		mainpanel.add(p3);
		mainpanel.add(p4);
		mainpanel.add(p5);
		mainpanel.add(p6);
		
		add(p2);
		add(mainpanel);
	}
}
