package functions;
import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class displayRecord extends JFrame{
	
	JLabel dr,name,roll,subject,marks,tmarks;
	JButton next,previous;
	
	public displayRecord(){
		FlowLayout f = new FlowLayout();
		setLayout(f);
		setSize(1080,540);
		setVisible(true);
		setTitle("Display Record");
		
		dr = new JLabel(":-:-:-:-:-:-:-:-:-:-:-:-:-:-:-:-:-:-:-: Display Record :-:-:-:-:-:-:-:-:-:-:-:-:-:-:-:-:-:-:-:");
		name = new JLabel("Name: ");
		roll = new JLabel("Roll No.: ");
		subject = new JLabel("Subject");
		marks = new JLabel("Obtained Marks");
		tmarks = new JLabel("Total Marks");
		next = new JButton("Next");
		previous = new JButton("Previous");
		add(dr);
		add(name);
		add(roll);
		add(subject);
		add(marks);
		add(tmarks);
		add(previous);
		add(next);
		
	}
}