package functions;
import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class displayRecord extends JFrame{
	
	JLabel Rc,rn,rN,Name,Phy,Che,Math,Eng,Com,sub,mark;
	JLabel RN,nam,ph,ch,ma,en,cp;
	JTextField trn;
	JButton brn;
	
	int rrn,phy,che,math,eng,com;
	String name;
	
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	public displayRecord() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
			ps = con.prepareStatement("select * from student");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		FlowLayout f = new FlowLayout();
		setVisible(true);
		setLayout(f);
		setSize(1080, 540);

		JPanel m = new JPanel(new GridLayout(4, 1));
		JPanel p1 = new JPanel(new GridLayout(1, 1));
		JPanel p2 = new JPanel(new GridLayout(1, 3));
		JPanel p3 = new JPanel(new GridLayout(1, 4));
		JPanel p4 = new JPanel(new GridLayout(6, 2));

		Rc = new JLabel("Record of all Student", JLabel.CENTER);
		Rc.setFont(new Font("", Font.BOLD, 24));
		m.add(Rc);

		Name = new JLabel("Name: ");
		nam = new JLabel();
		rN = new JLabel("Roll No.: ");
		RN = new JLabel();
		p3.add(Name);
		p3.add(nam);
		p3.add(rN);
		p3.add(RN);

		sub = new JLabel("Subjects", JLabel.CENTER);
		sub.setFont(new Font("", Font.BOLD, 16));
		mark = new JLabel("Marks", JLabel.CENTER);
		mark.setFont(new Font("", Font.BOLD, 16));
		Phy = new JLabel("Physics", JLabel.CENTER);
		ph = new JLabel();
		ph.setHorizontalAlignment(SwingConstants.CENTER);
		Che = new JLabel("Chemistry", JLabel.CENTER);
		ch = new JLabel();
		ch.setHorizontalAlignment(SwingConstants.CENTER);
		Math = new JLabel("Mathematics", JLabel.CENTER);
		ma = new JLabel();
		ma.setHorizontalAlignment(SwingConstants.CENTER);
		Eng = new JLabel("English", JLabel.CENTER);
		en = new JLabel();
		en.setHorizontalAlignment(SwingConstants.CENTER);
		Com = new JLabel("Computer", JLabel.CENTER);
		cp = new JLabel();
		cp.setHorizontalAlignment(SwingConstants.CENTER);
		p4.add(sub);
		p4.add(mark);
		p4.add(Phy);
		p4.add(ph);
		p4.add(Che);
		p4.add(ch);
		p4.add(Math);
		p4.add(ma);
		p4.add(Eng);
		p4.add(en);
		p4.add(Com);
		p4.add(cp);

		m.add(p2);

		try {
			rs = ps.executeQuery();
			while (rs.next()) {
				rrn = rs.getInt(1);
				name = rs.getString(2);
				phy = rs.getInt(3);
				che = rs.getInt(4);
				math = rs.getInt(5);
				eng = rs.getInt(6);
				com = rs.getInt(7);
			}
			nam.setText(name);
			RN.setText(Integer.toString(rrn));
			ph.setText(Integer.toString(phy));
			ch.setText(Integer.toString(che));
			ma.setText(Integer.toString(math));
			en.setText(Integer.toString(eng));
			cp.setText(Integer.toString(com));

			con.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		System.out.println(rrn);

		add(m);

	}
}