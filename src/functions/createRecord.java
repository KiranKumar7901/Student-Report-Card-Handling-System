package functions;
import java.sql.*;
import java.awt.*;
import javax.swing.*;

public class createRecord extends JFrame {
	Student st = new Student();
	JButton titl, back;
	JLabel rn, name, p, m, c, e, com, ed;
	TextField trn, tname, tp, tm, tc, te, tcom;
	JPanel p1, p2;
	String rollno;
	String nam;
	String ph, ma, ch, en, comp;
	Connection con;
	PreparedStatement ps;
	public createRecord(){
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
			con=DriverManager.getConnection("b5ybjb0rguk9bnfnm3qr-mysql.services.clever-cloud.com","uwfsctyutchk44qa","uwfsctyutchk44qa");
			ps = con.prepareStatement("insert into Student values (?,?,?,?,?,?,?)");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		FlowLayout f = new FlowLayout();
		setLayout(f);
		setTitle("Create Student Record");
		setVisible(true);
		setSize(1080, 540);
		f.setVgap(30);
		f.setHgap(400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		p1 = new JPanel(new GridLayout(1, 2));
		p2 = new JPanel(new GridLayout(7, 2));

		titl = new JButton("Create Student Record");
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
		back = new JButton("Back");

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
		
		add(p2);
		add(p1);

		titl.addActionListener(e -> {
			rollno = trn.getText();
			nam = tname.getText();
			ph = tp.getText();
			ma = tm.getText();
			ch = tc.getText();
			en = te.getText();
			comp = tcom.getText();
			try {
				ps.setInt(1, Integer.parseInt(rollno));
				ps.setString(2, nam);
				ps.setInt(3, Integer.parseInt(ph));
				ps.setInt(4, Integer.parseInt(ch));
				ps.setInt(5, Integer.parseInt(ma));
				ps.setInt(6, Integer.parseInt(en));
				ps.setInt(7, Integer.parseInt(comp));
				ps.executeUpdate();
				JOptionPane.showMessageDialog(null, "Student Record Created","Student Record",JOptionPane.PLAIN_MESSAGE);
				con.close();
			} catch (NumberFormatException | SQLException e1) {
				JOptionPane.showMessageDialog(null, "Record with Roll No "+rollno+" already exists","Student Record",JOptionPane.WARNING_MESSAGE);
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
