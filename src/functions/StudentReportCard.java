package functions;

import java.awt.*;
import javax.swing.*;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StudentReportCard extends JFrame {
	Student st = new Student();
	JLabel rc, name, rollno, sub, p, m, c, e1, comp, marks, per, grade;
	JLabel rn, tmarks, tname, trn, tp, tm, tc, te, tcomp, tp100, tm100, tc100, te100, tcs100, tper, tgrade;
	TextField rn1;
	JButton rn2, back;
	JPanel p1, p2, p3, p4, p5, p6, mainpanel, p7;

	int rn3;		//roll no 
	String nam;
	int ph, ch, ma, en, cs;

	PreparedStatement ps;
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
		
		GridLayout gr=new GridLayout(3,1);

		mainpanel = new JPanel(gr);
		p1 = new JPanel(new GridLayout(1,3));
		p2 = new JPanel(new GridLayout(1, 1));
		p3 = new JPanel(new GridLayout(1, 4));
		p4 = new JPanel(new GridLayout(6, 3));
		p5 = new JPanel(new GridLayout(1, 1));
		p7 = new JPanel(new GridLayout(1, 1));

		rn = new JLabel(" Roll No: ",JLabel.RIGHT);
		rn.setFont(new Font("Times New Roman",Font.BOLD,20));
		rn1 = new TextField();
		rn2 = new JButton("Search for Report Card Of a Student");
		p1.add(rn);
		p1.add(rn1);
		p1.add(rn2);
		add(p1);

		rc = new JLabel(":----------: Student Report Card :----------:",JLabel.CENTER);
		rc.setFont(new Font("Times New Roman", Font.PLAIN, 40));

		name = new JLabel("Name: ",JLabel.RIGHT);
		name.setFont(new Font("Times New Roman", Font.BOLD, 36));
		tname = new JLabel();
		tname.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		rollno = new JLabel("Roll No: ",JLabel.RIGHT);
		rollno.setFont(new Font("Times New Roman", Font.BOLD, 36));
		trn = new JLabel();
		trn.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		sub = new JLabel("Subjects");
		sub.setFont(new Font("Times New Roman", Font.BOLD, 28));
		marks = new JLabel("Marks Obtained", JLabel.CENTER);
		marks.setFont(new Font("Times New Roman", Font.BOLD, 28));
		tmarks = new JLabel("Total Marks", JLabel.CENTER);
		tmarks.setFont(new Font("Times New Roman", Font.BOLD, 28));
		p = new JLabel("Physics");
		p.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		tp = new JLabel();
		tp.setHorizontalAlignment(SwingConstants.CENTER);
		tp.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		tp100 = new JLabel("100", JLabel.CENTER);
		tp100.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		m = new JLabel("Mathematics");
		m.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		tm = new JLabel();
		tm.setHorizontalAlignment(SwingConstants.CENTER);
		tm.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		tm100 = new JLabel("100", JLabel.CENTER);
		tm100.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		c = new JLabel("Chemistry");
		c.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		tc = new JLabel();
		tc.setHorizontalAlignment(SwingConstants.CENTER);
		tc.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		tc100 = new JLabel("100", JLabel.CENTER);
		tc100.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		e1 = new JLabel("English");
		e1.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		te = new JLabel();
		te.setHorizontalAlignment(SwingConstants.CENTER);
		te.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		te100 = new JLabel("100", JLabel.CENTER);
		te100.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		comp = new JLabel("Computer");
		comp.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		tcomp = new JLabel();
		tcomp.setHorizontalAlignment(SwingConstants.CENTER);
		tcomp.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		tcs100 = new JLabel("100", JLabel.CENTER);
		tcs100.setFont(new Font("Times New Roman", Font.PLAIN, 24));

		per = new JLabel("Percentage: ", JLabel.RIGHT);
		per.setFont(new Font("Times New Roman", Font.BOLD, 28));
		tper = new JLabel();
		tper.setHorizontalAlignment(SwingConstants.CENTER);
		tper.setFont(new Font("Times New Roman", Font.PLAIN, 26));
		grade = new JLabel("Grade: ", JLabel.RIGHT);
		grade.setFont(new Font("Times New Roman", Font.BOLD, 28));
		tgrade = new JLabel();
		tgrade.setHorizontalAlignment(SwingConstants.CENTER);
		tgrade.setFont(new Font("Times New Roman", Font.PLAIN, 26));

		back = new JButton("Back");
		back.setFont(new Font("Times New Roman",Font.BOLD,26));

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

				float pert = (float) (ph + ch + ma + en + cs) / 5;
				char grad = st.calculate(Integer.toString(rn3), nam, Integer.toString(ph), Integer.toString(ma),
						Integer.toString(ch), Integer.toString(en), Integer.toString(cs));
				tname.setText(nam);
				trn.setText(Integer.toString(rn3));
				tp.setText(Integer.toString(ph));
				tm.setText(Integer.toString(ma));
				tc.setText(Integer.toString(ch));
				te.setText(Integer.toString(en));
				tcomp.setText(Integer.toString(cs));
				tper.setText(Float.toString(pert));
				tgrade.setText(String.valueOf(grad));

				p2.add(rc);
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
				
//				mainpanel.add(p2);
				mainpanel.add(p3);
				mainpanel.add(p4);
				mainpanel.add(p5);
				
				p7.add(back);

				con.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			p1.setVisible(false);
		});

		

		back.addActionListener(e -> {
			resultMenu rs = new resultMenu();
			setVisible(false);
		});

		add(p2);
		add(mainpanel);
		add(p7);

	}
}
