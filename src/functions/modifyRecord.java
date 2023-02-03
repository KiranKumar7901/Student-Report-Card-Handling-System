package functions;
import java.sql.*;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class modifyRecord extends JFrame {
	Student st = new Student();
	JButton rn3,titl, back;
	JLabel rn1,rn, name, p, m, c, e, com, ed;
	TextField rn2,trn, tname, tp, tm, tc, te, tcom;
	JPanel p1, p2, p3,p4;
	String rollno;
	String nam;
	String ph, ma, ch, en, comp;
	Connection con;
	PreparedStatement ps;
	int rn4;
	public modifyRecord(){
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
			ps = con.prepareStatement("update student set Name=?,Physics=?,Chemistry=?,maths=?,english=?,computer=? where rollno=?");
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
		f.setVgap(150);

		p1 = new JPanel(new GridLayout(1, 2));
		p2 = new JPanel(new GridLayout(7, 2));
		p3 = new JPanel(new GridLayout(1, 1));
		p4 = new JPanel(new GridLayout(1,3));
		
		rn1 = new JLabel("Enter RollNo: ");
		rn2 = new TextField();
		rn3 = new JButton("Update entered record");
		p4.add(rn1);
		p4.add(rn2);
		p4.add(rn3);
		
		add(p4);		

		titl = new JButton("Modify Student Record");
		rn = new JLabel("Enter Roll No ");
		trn = new TextField();
		name = new JLabel("Enter Name ");
		tname = new TextField();
		p = new JLabel("Enter Physics Marks ");
		tp = new TextField();
		m = new JLabel("Enter Maths Marks ");
		tm = new TextField();
		c = new JLabel("Enter Chemistry Marks ");
		tc = new TextField();
		e = new JLabel("Enter English Marks ");
		te = new TextField();
		com = new JLabel("Enter Computer Marks ");
		tcom = new TextField();
		ed = new JLabel();
		back = new JButton("Back");
		
		rn3.addActionListener(e -> {
			rn4=Integer.valueOf(rn2.getText());
			rollno = String.valueOf(rn4);
			trn.setText(rollno);
			trn.setEditable(false);
			System.out.println(rn4);
			try {
				ps.setInt(7, Integer.parseInt(rollno));
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			p4.setVisible(false);
		});

		p2.add(rn);
		p2.add(trn);
		p2.add(name);
		p2.add(tname);
		p2.add(p);
		p2.add(tp);
		p2.add(m);
		p2.add(tm);
		p2.add(c);
		p2.add(tc);
		p2.add(e);
		p2.add(te);
		p2.add(com);
		p2.add(tcom);
		p1.add(titl);
		p1.add(back);
		p3.add(ed);
		add(p2);
		add(p1);
		add(p3);

		titl.addActionListener(e -> {
			ed.setText(" Student Record Updated");
			nam = tname.getText();
			ph = tp.getText();
			ma = tm.getText();
			ch = tc.getText();
			en = te.getText();
			comp = tcom.getText();
			System.out.println(rollno + "\t" + nam + "\t" + ph + "\t" + ma + "\t" + ch + "\t" + en + "\t" + comp);
			try {
				ps.setString(1, nam);
				ps.setInt(2, Integer.parseInt(ph));
				ps.setInt(3, Integer.parseInt(ch));
				ps.setInt(4, Integer.parseInt(ma));
				ps.setInt(5, Integer.parseInt(en));
				ps.setInt(6, Integer.parseInt(comp));
				ps.executeUpdate();
			} catch (NumberFormatException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			entry_editMenu eem = new entry_editMenu();
			setVisible(false);
		});
		back.addActionListener(e -> {
			entry_editMenu eem = new entry_editMenu();
			setVisible(false);
		});
	}
}
