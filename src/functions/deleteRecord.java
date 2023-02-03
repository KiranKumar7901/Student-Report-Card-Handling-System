package functions;

import java.sql.*;
import java.awt.*;
import javax.swing.*;

public class deleteRecord extends JFrame {
	
	Connection con;
	PreparedStatement ps;
	
	JLabel rn,d;
	TextField trn;
	JButton brn,back;
	
	int rollno;
	
	JPanel p1,p2,p3,m;

	public deleteRecord(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
			ps = con.prepareStatement("delete from student where rollno=?");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		FlowLayout f =new FlowLayout();
		setLayout(f);
		setVisible(true);
		setSize(1080,540);
		f.setVgap(200);
		
		p1 = new JPanel(new GridLayout(1,3));
		p2 = new JPanel(new GridLayout(1,1));
		p3 = new JPanel(new GridLayout(1,1));
		m = new JPanel(new GridLayout(3,1));
		
		rn = new JLabel("Enter Roll No ");
		trn = new TextField();
		brn = new JButton("Delete Record");
		d = new JLabel();
		d.setHorizontalAlignment(SwingConstants.CENTER);
		back = new JButton("Back");
		
		p1.add(rn);
		p1.add(trn);
		p1.add(brn);
		p2.add(d);
		p3.add(back);
		
		m.add(p1);
		m.add(p2);
		m.add(p3);
		
		brn.addActionListener(e -> {
			rollno = Integer.parseInt(trn.getText());
			try {
				ps.setInt(1, rollno);
				ps.executeUpdate();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println(rollno);
			d.setText("Record Successfully Deleted !!!");
		});
		back.addActionListener(e -> {
			entry_editMenu e1 = new entry_editMenu();
			setVisible(false);
		});
		
		add(m);
		
	}
}
