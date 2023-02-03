package functions;

import java.awt.FlowLayout;
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
		JPanel p;
		p=new JPanel(new GridLayout(4,1));
		rmenu=new JLabel("Result Menu",JLabel.CENTER);
		cresult = new JButton("Class Result");
		src = new JButton("Student Report Card");
		back = new JButton("Back to Main Menu");
		p.add(rmenu);
		p.add(cresult);
		p.add(src);
		p.add(back);
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
