package functions;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class resultMenu extends JFrame{
	JLabel rmenu;
	JButton cresult,src,back;
	public resultMenu()
	{
		FlowLayout f = new FlowLayout();
		setLayout(f);
		setVisible(true);
		setSize(1080,540);
		f.setVgap(140);
		
		JPanel p,p1,p2,p3;
		p=new JPanel(new GridLayout(3,1));
		p1 = new JPanel(new GridLayout(1,1));
		p2 = new JPanel(new GridLayout(1,2));
		p3 = new JPanel(new GridLayout(1,1));
		rmenu=new JLabel("Result Menu",JLabel.CENTER);
		rmenu.setFont(new Font("amasis mt pro black",Font.BOLD,30));
		cresult = new JButton("Class Result");
		cresult.setFont(new Font("amasis mt pro black",Font.BOLD,20));
		src = new JButton("Student Report Card");
		src.setFont(new Font("amasis mt pro black",Font.BOLD,20));
		back = new JButton("Back to Main Menu");
		back.setFont(new Font("amasis mt pro black",Font.BOLD,26));
		p1.add(rmenu);
		p2.add(cresult);
		p2.add(src);
		p3.add(back);
		p.add(p1);
		p.add(p2);
		p.add(p3);
		add(p);
		
		src.addActionListener(e -> {
			StudentReportCard src = new StudentReportCard();
			setVisible(false);
		});
		
		cresult.addActionListener(e -> {
			classResult cr = new classResult();
			setVisible(false);
		});
		
		back.addActionListener(e -> {
			mainMenu mn= new mainMenu();
			setVisible(false);
		});
		
	}
}
