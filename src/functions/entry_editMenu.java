package functions;
import javax.swing.*;
import java.awt.*;

public class entry_editMenu extends JFrame{
	JLabel ened;
	JButton create,display,modify,search,delete,main;
	JPanel p1,p2,p3;
	public entry_editMenu(){
		FlowLayout f =new FlowLayout();
		setLayout(f);
		setVisible(true);
		setSize(1080,540);
		f.setVgap(120);
		
		p3= new JPanel(new GridLayout(2,1));
		p1 = new JPanel(new GridLayout(1,1));
		p2 = new JPanel(new GridLayout(3,2));
		
		ened = new JLabel("Entry / Edit Menu",JLabel.CENTER);
		ened.setFont(new Font("times new roman",Font.BOLD,30));
		p1.add(ened);
		p3.add(p1);
		
		create = new JButton("Create Student Record ");
		create.setFont(new Font("amasis mt pro black",Font.BOLD,14));
		display = new JButton("Display Student Record ");
		display.setFont(new Font("amasis mt pro black",Font.BOLD,14));
		modify = new JButton("Modify Student Record ");
		modify.setFont(new Font("amasis mt pro black",Font.BOLD,14));
		search = new JButton("Search Student Record ");
		search.setFont(new Font("amasis mt pro black",Font.BOLD,14));
		delete = new JButton("Delete Student Record ");
		delete.setFont(new Font("amasis mt pro black",Font.BOLD,14));
		main = new JButton("Back to Main Menu...");
		main.setFont(new Font("amasis mt pro black",Font.BOLD,14));
		
		p2.add(create);
		p2.add(display);
		p2.add(modify);
		p2.add(search);
		p2.add(delete);
		p2.add(main);
		p3.add(p2);
		add(p3);
		
		create.addActionListener(e -> {
			createRecord cr = new createRecord();
			setVisible(false);
		});
		
		display.addActionListener(e -> {
			displayRecord drr = new displayRecord();
		});
		
		modify.addActionListener(e -> {
			modifyRecord mr = new modifyRecord();
			setVisible(false);
		});
		
		search.addActionListener(e -> {
			searchRecord sr= new searchRecord();
			setVisible(false);
		});
		
		delete.addActionListener(e -> {
			deleteRecord dr = new deleteRecord();
			setVisible(false);
		});
		
		main.addActionListener(e -> {
			mainMenu mn = new mainMenu();
			setVisible(false);
		});
	}
}
