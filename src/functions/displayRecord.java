package functions;
import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class displayRecord extends JFrame {

	JLabel dr, name,nam,rln ,roll, subject, marks, tmarks,p,c,m,e,cs,pm,cm,mm,em,csm,ph1,c1,m1,e1,cs1;
	JButton next, previous,back;
	JPanel p1, p2, p3, mainpanel;

	Connection con;
	Statement stmt;
	ResultSet rs;

	public displayRecord() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
			con=DriverManager.getConnection("b5ybjb0rguk9bnfnm3qr-mysql.services.clever-cloud.com","uwfsctyutchk44qa","uwfsctyutchk44qa");
			stmt =con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			rs = stmt.executeQuery("Select * from Student");
		} catch (ClassNotFoundException e2) {
			e2.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		FlowLayout f = new FlowLayout();
		setLayout(f);
		setSize(1080, 540);
		setVisible(true);
		setTitle("Display Record");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		mainpanel = new JPanel(new GridLayout(2, 1));
		p1 = new JPanel(new GridLayout(1, 4));
		p2 = new JPanel(new GridLayout(6, 3));
		p3 = new JPanel(new GridLayout(1, 2));
		p3.setPreferredSize(new Dimension(800,30));

		dr = new JLabel(
				":-:-:-:-:-:-:-:-:-:-:-:-:-:-:-:-:-:-:-: Display Record :-:-:-:-:-:-:-:-:-:-:-:-:-:-:-:-:-:-:-:");
		dr.setFont(new Font("Times new roman",Font.BOLD,28));
		name = new JLabel("Name: ");
		name.setFont(new Font("Times new roman",Font.BOLD,24));
		nam = new JLabel();
		nam.setFont(new Font("Times new roman",Font.PLAIN,22));
		roll = new JLabel("Roll No.: ");
		roll.setFont(new Font("Times new roman",Font.BOLD,24));
		rln = new JLabel();
		rln.setFont(new Font("Times new roman",Font.PLAIN,22));
		subject = new JLabel("Subject");
		subject.setFont(new Font("Times new roman",Font.BOLD,24));
		marks = new JLabel("Obtained Marks",JLabel.CENTER);
		marks.setFont(new Font("Times new roman",Font.BOLD,24));
		tmarks = new JLabel("Total Marks",JLabel.CENTER);
		tmarks.setFont(new Font("Times new roman",Font.BOLD,24));
		p = new JLabel("Physics");
		p.setFont(new Font("Times new roman",Font.PLAIN,22));
		c = new JLabel("Chemistry");
		c.setFont(new Font("Times new roman",Font.PLAIN,22));
		m = new JLabel("Mathematics");
		m.setFont(new Font("Times new roman",Font.PLAIN,22));
		e = new JLabel("English");
		e.setFont(new Font("Times new roman",Font.PLAIN,22));
		cs = new JLabel("Computer");
		cs.setFont(new Font("Times new roman",Font.PLAIN,22));
		pm = new JLabel();
		pm.setHorizontalAlignment(JLabel.CENTER);
		pm.setFont(new Font("Times new roman",Font.PLAIN,22));
		cm = new JLabel();
		cm.setHorizontalAlignment(JLabel.CENTER);
		cm.setFont(new Font("Times new roman",Font.PLAIN,22));
		mm = new JLabel();
		mm.setHorizontalAlignment(JLabel.CENTER);
		mm.setFont(new Font("Times new roman",Font.PLAIN,22));
		em = new JLabel();
		em.setHorizontalAlignment(JLabel.CENTER);
		em.setFont(new Font("Times new roman",Font.PLAIN,22));
		csm = new JLabel();
		csm.setHorizontalAlignment(JLabel.CENTER);
		csm.setFont(new Font("Times new roman",Font.PLAIN,22));
		ph1 = new JLabel("100");
		ph1.setHorizontalAlignment(JLabel.CENTER);
		ph1.setFont(new Font("Times new roman",Font.PLAIN,22));
		c1 = new JLabel("100");
		c1.setHorizontalAlignment(JLabel.CENTER);
		c1.setFont(new Font("Times new roman",Font.PLAIN,22));
		m1 = new JLabel("100");
		m1.setHorizontalAlignment(JLabel.CENTER);
		m1.setFont(new Font("Times new roman",Font.PLAIN,22));
		e1 = new JLabel("100");
		e1.setHorizontalAlignment(JLabel.CENTER);
		e1.setFont(new Font("Times new roman",Font.PLAIN,22));
		cs1 = new JLabel("100");
		cs1.setHorizontalAlignment(JLabel.CENTER);
		cs1.setFont(new Font("Times new roman",Font.PLAIN,22));
		next = new JButton("Next");
		next.setFont(new Font("Times new roman",Font.PLAIN,26));
		previous = new JButton("Previous");
		previous.setFont(new Font("Times new roman",Font.PLAIN,26));
		back = new JButton("Back to Entry / Edit Menu");
		back.setFont(new Font("Times new roman",Font.PLAIN,26));
		try {
			rs.first();				
			rln.setText(rs.getString(1));
			nam.setText(rs.getString(2));
			pm.setText(rs.getString(3));
			cm.setText(rs.getString(4));
			mm.setText(rs.getString(5));
			em.setText(rs.getString(6));
			csm.setText(rs.getString(7));
			
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		previous.addActionListener( e->{
				try {
					if (!rs.isFirst()) {
						rs.previous();
						rln.setText(rs.getString(1));
						nam.setText(rs.getString(2));
						pm.setText(rs.getString(3));
						cm.setText(rs.getString(4));
						mm.setText(rs.getString(5));
						em.setText(rs.getString(6));
						csm.setText(rs.getString(7));
					}
				} catch (SQLException ae) {
					System.out.println(ae);
				}
		});
		next.addActionListener(e ->{
				try {
					if (!rs.isLast()) {
						rs.next();
						rln.setText(rs.getString(1));
						nam.setText(rs.getString(2));
						pm.setText(rs.getString(3));
						cm.setText(rs.getString(4));
						mm.setText(rs.getString(5));
						em.setText(rs.getString(6));
						csm.setText(rs.getString(7));
					}
				} catch (SQLException ae) {
					System.out.println(ae);
			}
		});
		
		back.addActionListener(e -> {
			entry_editMenu er = new entry_editMenu();
			setVisible(false);
		});

		p1.add(name);
		p1.add(nam);
		p1.add(roll);
		p1.add(rln);
		
		p2.add(subject);
		p2.add(marks);
		p2.add(tmarks);
		p2.add(p);
		p2.add(pm);
		p2.add(ph1);
		p2.add(c);
		p2.add(cm);
		p2.add(c1);
		p2.add(m);
		p2.add(mm);
		p2.add(m1);
		p2.add(e);
		p2.add(em);
		p2.add(e1);
		p2.add(cs);
		p2.add(csm);
		p2.add(cs1);
		
		p3.add(previous);
		p3.add(next);
		
		add(dr);
		mainpanel.add(p1);
		mainpanel.add(p2);
		add(mainpanel);
		add(p3);
		add(back);

	}

}
