package functions;

import java.awt.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

public class classResult extends JFrame {
	
	Student st= new Student();
	JLabel head, rno, name, p, c, m, e, cs, per, grade, tr, tn, tp, tc, tm, te, tcs,tper,tgrade;
	JPanel p1, p2, p3;
	int rln[] = new int[50];
	int ph[] = new int[50];
	int ch[] = new int[50];
	int ma[] = new int[50];
	int en[] = new int[50];
	int com[] = new int[50];
	String nam[] = new String[50];
	int pert[] = new int[50];
	char gr[] = new char[50];
	int i = 1, k = 1;

	Connection con;
	ResultSet rs;
	Statement stmt;

	public classResult() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from student order by rollno");
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2));
				rln[i] = rs.getInt(1);
				nam[i] = rs.getString(2);
				ph[i] = rs.getInt(3);
				ch[i] = rs.getInt(4);
				ma[i] = rs.getInt(5);
				en[i] = rs.getInt(6);
				com[i] = rs.getInt(7);
				pert[i] = (ph[i]+ch[i]+ma[i]+en[i]+com[i])/5;
				gr[i] = st.calculate(Integer.toString(rln[i]),nam[i],Integer.toString(ph[i]),Integer.toString(ma[i]),Integer.toString(ch[i]),Integer.toString(en[i]),Integer.toString(com[i]));
				i++;
			}
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		FlowLayout f = new FlowLayout();
		setLayout(f);
		setVisible(true);
		setSize(1080, 540);
		p1 = new JPanel(new GridLayout(1, 1));
		p2 = new JPanel(new GridLayout(i , 9));
		p3 = new JPanel(new GridLayout());

		head = new JLabel(":----------------------------: All Students Result :----------------------------:",
				JLabel.CENTER);
		head.setFont(new Font("Times New Roman", Font.PLAIN, 36));
		p1.add(head);
		add(p1);

		rno = new JLabel("Roll No ",JLabel.CENTER);
		rno.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		name = new JLabel("Name ",JLabel.CENTER);
		name.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		p = new JLabel("Physics ",JLabel.CENTER);
		p.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		c = new JLabel("Chemistry ",JLabel.CENTER);
		c.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		m = new JLabel("Mathematics  ",JLabel.CENTER);
		m.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		e = new JLabel("English  ",JLabel.CENTER);
		e.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		cs = new JLabel("Computer  ",JLabel.CENTER);
		cs.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		per = new JLabel("Percentage  ",JLabel.CENTER);
		per.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		grade = new JLabel("Grade  ",JLabel.CENTER);
		grade.setFont(new Font("Times New Roman", Font.PLAIN, 18));

		p2.add(rno);
		p2.add(name);
		p2.add(p);
		p2.add(c);
		p2.add(m);
		p2.add(e);
		p2.add(cs);
		p2.add(per);
		p2.add(grade);

		while (k < i) {
			tr = new JLabel(Integer.toString(rln[k]),JLabel.CENTER);
			tn = new JLabel(nam[k],JLabel.CENTER);
			tp = new JLabel(Integer.toString(ph[k]),JLabel.CENTER);
			tc = new JLabel(Integer.toString(ch[k]),JLabel.CENTER);
			tm = new JLabel(Integer.toString(ma[k]),JLabel.CENTER);
			te = new JLabel(Integer.toString(en[k]),JLabel.CENTER);
			tcs = new JLabel(Integer.toString(com[k]),JLabel.CENTER);
			tper = new JLabel(Integer.toString(pert[k])+" %",JLabel.CENTER);
			tgrade = new JLabel(String.valueOf(gr[k]),JLabel.CENTER);
			p2.add(tr);
			p2.add(tn);
			p2.add(tp);
			p2.add(tc);
			p2.add(tm);
			p2.add(te);
			p2.add(tcs);
			p2.add(tper);
			p2.add(tgrade);
			k++;
		}

		add(p2);

		try {
			con.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
}