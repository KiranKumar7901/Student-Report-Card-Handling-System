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
		f.setVgap(80);
		JPanel p;
		p=new JPanel(new GridLayout(4,1));
		mmenu=new JLabel("Main Menu",JLabel.CENTER);
		mmenu.setFont(new Font("times new roman",Font.PLAIN,28));
		result = new JButton("Result Menu");
		entedit = new JButton("Entry / Edit Menu");
		exit = new JButton("Exit");
		p.add(mmenu);
		p.add(result);
		p.add(entedit);
		p.add(exit);
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
