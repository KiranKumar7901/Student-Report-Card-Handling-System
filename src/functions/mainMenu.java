package functions;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class mainMenu extends JFrame implements ActionListener{
	JLabel mmenu;
	JButton result,entedit,exit;
	JFrame fr=new JFrame();
	public mainMenu()
	{
		FlowLayout f = new FlowLayout();
		setLayout(f);
		setVisible(true);
		setSize(1080,540);
		f.setVgap(140);
		setTitle("Main Menu");
		
		JPanel p,p1,p2,p3;
		p=new JPanel(new GridLayout(3,1));
		p1 = new JPanel(new GridLayout(1,1));
		p2 = new JPanel(new GridLayout(1,2));
		p3 = new JPanel(new GridLayout(1,1));
		mmenu=new JLabel("Main Menu",JLabel.CENTER);
		mmenu.setFont(new Font("amasis mt pro black",Font.BOLD,36));
		result = new JButton("Result Menu");
		result.setFont(new Font("amasis mt pro black",Font.BOLD,20));
		entedit = new JButton("Entry / Edit Menu");
		entedit.setFont(new Font("amasis mt pro black",Font.BOLD,20));
		exit = new JButton("Exit");
		exit.setFont(new Font("amasis mt pro black",Font.BOLD,26));
		p1.add(mmenu);
		p2.add(result);
		p2.add(entedit);
		p3.add(exit);
		p.add(p1);
		p.add(p2);
		p.add(p3);
		add(p);
		exit.addActionListener(e -> {
			System.exit(0);
		});
		result.addActionListener(e -> {
			resultMenu rs = new resultMenu();
			setVisible(false);
		});
		entedit.addActionListener(e -> {
			entry_editMenu eem = new entry_editMenu();
			setVisible(false);
		});
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
