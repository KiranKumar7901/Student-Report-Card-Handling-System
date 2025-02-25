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
	JButton back;
	JPanel p1, p2, p3,main;
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
			// con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
			con=DriverManager.getConnection("mysql://uwfsctyutchk44qa:HhXHnP4xtx4DSbaCgIsN@b5ybjb0rguk9bnfnm3qr-mysql.services.clever-cloud.com:3306/b5ybjb0rguk9bnfnm3qr","uwfsctyutchk44qa","uwfsctyutchk44qa");
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from student order by rollno");
			while (rs.next()) {
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
		setTitle("Result of All Students");
		setVisible(true);
		setSize(1080, 540);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		main = new JPanel(new GridLayout(2,1));
		p1 = new JPanel(new GridLayout(1, 1));
		p2 = new JPanel(new GridLayout(i , 9));
		p3 = new JPanel(new GridLayout(1,1));

		head = new JLabel(":----------------------------: All Students Result :----------------------------:",
				JLabel.CENTER);
		head.setFont(new Font("amasis mt pro black", Font.BOLD, 34));
		p1.add(head);
		main.add(p1);

		rno = new JLabel("Roll No ",JLabel.CENTER);
		rno.setFont(new Font("amasis mt pro black", Font.BOLD, 16));
		name = new JLabel("Name ");
		name.setFont(new Font("amasis mt pro black", Font.BOLD, 16));
		p = new JLabel("Physics ",JLabel.CENTER);
		p.setFont(new Font("amasis mt pro black", Font.BOLD, 16));
		c = new JLabel("Chemistry ",JLabel.CENTER);
		c.setFont(new Font("amasis mt pro black", Font.BOLD, 16));
		m = new JLabel("Mathematics  ",JLabel.CENTER);
		m.setFont(new Font("amasis mt pro black", Font.BOLD, 16));
		e = new JLabel("English  ",JLabel.CENTER);
		e.setFont(new Font("amasis mt pro black", Font.BOLD, 16));
		cs = new JLabel("Computer  ",JLabel.CENTER);
		cs.setFont(new Font("amasis mt pro black", Font.BOLD, 16));
		per = new JLabel("Percentage  ",JLabel.CENTER);
		per.setFont(new Font("amasis mt pro black", Font.BOLD, 16));
		grade = new JLabel("Grade  ",JLabel.CENTER);
		grade.setFont(new Font("amasis mt pro black", Font.BOLD, 16));

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
			tr.setFont(new Font("amasis mt pro black", Font.PLAIN, 14));
			tn = new JLabel(nam[k]);
			tn.setFont(new Font("amasis mt pro black", Font.PLAIN, 14));
			tp = new JLabel(Integer.toString(ph[k]),JLabel.CENTER);
			tp.setFont(new Font("amasis mt pro black", Font.PLAIN, 14));
			tc = new JLabel(Integer.toString(ch[k]),JLabel.CENTER);
			tc.setFont(new Font("amasis mt pro black", Font.PLAIN, 14));
			tm = new JLabel(Integer.toString(ma[k]),JLabel.CENTER);
			tm.setFont(new Font("amasis mt pro black", Font.PLAIN, 14));
			te = new JLabel(Integer.toString(en[k]),JLabel.CENTER);
			te.setFont(new Font("amasis mt pro black", Font.PLAIN, 14));
			tcs = new JLabel(Integer.toString(com[k]),JLabel.CENTER);
			tcs.setFont(new Font("amasis mt pro black", Font.PLAIN, 14));
			tper = new JLabel(Integer.toString(pert[k])+" %",JLabel.CENTER);
			tper.setFont(new Font("amasis mt pro black", Font.PLAIN, 14));
			tgrade = new JLabel(String.valueOf(gr[k]),JLabel.CENTER);
			tgrade.setFont(new Font("amasis mt pro black", Font.PLAIN, 14));
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

		main.add(p2);
		
		back = new JButton("Back");
		back.setFont(new Font("amasis mt pro black",Font.BOLD,24));
		back.setPreferredSize(new Dimension(200,40));
		p3.add(back);
		add(main);
		add(p3);
		
		back.addActionListener(e -> {
			resultMenu rm = new resultMenu();
			setVisible(false);
		});

		try {
			con.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
}
