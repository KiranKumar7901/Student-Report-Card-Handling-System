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
		
		p1 = new JPanel(new GridLayout(1,1));
		p2 = new JPanel(new GridLayout(6,1));
		
		ened = new JLabel("Entry / Edit Menu",JLabel.CENTER);
		p1.add(ened);
		add(p1);
		
		create = new JButton("Create Student Record ");
		display = new JButton("Display Student Record ");
		modify = new JButton("Modify Student Record ");
		search = new JButton("Search Student Record ");
		delete = new JButton("Delete Student Record ");
		main = new JButton("Back to Main Menu...");
		
		p2.add(create);
		p2.add(display);
		p2.add(modify);
		p2.add(search);
		p2.add(delete);
		p2.add(main);
		add(p2);
		
		create.addActionListener(e -> {
			createRecord cr = new createRecord();
			setVisible(false);
		});
		modify.addActionListener(e -> {
			modifyRecord cr = new modifyRecord();
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
