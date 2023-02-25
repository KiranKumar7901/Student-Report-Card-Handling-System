package functions;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class intro extends JFrame implements ActionListener{
	
	public intro(){
		FlowLayout f = new FlowLayout();
		setLayout(f);
		f.setVgap(100);
		setVisible(true);
		setSize(1080, 540);
		setTitle("HomePage");
		
		JPanel p1, p2;
		p1 = new JPanel(new GridLayout(6, 1));
		JLabel project = new JLabel("Mini Project",JLabel.CENTER);
		project.setFont(new Font("times new roman",Font.PLAIN,32));
		JLabel Uname = new JLabel("Graphic Era Hill University",JLabel.CENTER);
		Uname.setFont(new Font("times new roman",Font.PLAIN,28));
		JLabel Pname = new JLabel("Student Report Card Handling System",JLabel.CENTER);
		Pname.setFont(new Font("times new roman",Font.PLAIN,26));
		JLabel Aname = new JLabel("Name: Kiran Kumar     Student ID.: 200111015",JLabel.CENTER);
		Aname.setFont(new Font("times new roman",Font.PLAIN,20));
		JLabel RNS = new JLabel("Roll No.: 23               Section: I",JLabel.CENTER);
		RNS.setFont(new Font("times new roman",Font.PLAIN,20));
		JButton b = new JButton("Click Me to See The Project....");
		b.setForeground(new Color(0x000033));
		b.setBackground(new Color(0xC1C8E4));
		Aname.setForeground(new Color(0x003366));
		Uname.setForeground(new Color(0x330066));
		project.setForeground(new Color(0x660000));
		Pname.setForeground(new Color(0x330000));
		RNS.setForeground(new Color(0x330066));
		p1.add(project);
		p1.add(Uname);
		p1.add(Pname);
		p1.add(Aname);
		p1.add(RNS);
		p1.add(b);
		add(p1);
		b.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
			mainMenu rs=new mainMenu();
			setVisible(false);
	}
}
