import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
// defined class 




public class WelcomePage extends JFrame {
	private int width; 
	private int height;
	private JPanel main;
	private JPanel header;
	private JPanel category;
	private JPanel level;
	private JPanel content;	
	private BackgroundPanel backgroundPanel;
	private JPanel footer;
	// constructor
	public WelcomePage(int width, int height, String background_path) {
		// frame
		this.width = width; 
		this.height = height;
		this.main = new JPanel();
		this.header = new JPanel();
		this.category = new JPanel();
		this.content = new JPanel();
		this.level = new JPanel();
		this.footer = new JPanel();
		//main panel
		this.main.setLayout(new BorderLayout());
		
		// create the background
		backgroundPanel = new BackgroundPanel("./Background/Logo.png");
		this.add(backgroundPanel);
        this.setSize(width,height);
		this.setVisible(true);
	}
	
	public void centerFrame(Dimension screen) {
		this.setLocation(screen.width/2 - this.getWidth()/2, screen.height/2 - this.getHeight()/2);
	}
	
	public void setWelocomIcon(String img) {
		ImageIcon img_icon = new ImageIcon(img);
		this.setIconImage(img_icon.getImage());
		
	}
	public void setHeader(String img) {
		JLabel title = new JLabel("BrainBusters");
		Font font = new Font("Serif", Font.BOLD + Font.ITALIC, 80);
		title.setFont(font);
		this.header.add(title);
		this.main.add(header, BorderLayout.NORTH);
	}
	
	public void setCategories(String[] cat) {
		this.content.setLayout(new GridLayout(1, 2,20,20));
		this.category.setLayout(new BoxLayout(category, BoxLayout.Y_AXIS));
		this.category.setBorder(new EmptyBorder(50, 100, 50, 50));
		JLabel  categoryTitle = new JLabel("CATEGORY");
		this.category.add(categoryTitle);
		//add style to the  title
		Font title_font = new Font("Serif", Font.BOLD, 40);
		categoryTitle.setFont(title_font);
		Font category_font = new Font("Serif", Font.ITALIC, 30);
		// create a list of catagories
		JCheckBox[] categories = new JCheckBox[cat.length];
		ButtonGroup group_button = new ButtonGroup();
		// adding the categories the the JPanel
		for (int count=0; count < cat.length; count++) {
			categories[count] = new JCheckBox(cat[count]);
			this.category.add(categories[count]);
			group_button.add(categories[count]);
			categories[count].setFont(category_font);
		}
		
		this.content.add(category);
			
	}
	
	public void setLevel(String[] levels_names) {
		this.level.setLayout(new BoxLayout(level, BoxLayout.Y_AXIS));
		this.level.setBorder(new EmptyBorder(50, 100, 50, 50));
		JLabel  levelTitle = new JLabel("LEVEL");
		this.level.add(levelTitle);
		//add style to the  title
		Font title_font = new Font("Serif", Font.BOLD, 40);
		levelTitle.setFont(title_font);
		Font level_font = new Font("Serif", Font.ITALIC, 30);
		// create a list of catagories
		JCheckBox[] levels = new JCheckBox[levels_names.length];
		ButtonGroup group_button = new ButtonGroup();
		// adding the categories the the JPanel
		// add button listeners 
		for (int count=0; count < levels_names.length; count++) {
			levels[count] = new JCheckBox(levels_names[count]);
			this.level.add(levels[count]);
			group_button.add(levels[count]);
			levels[count].setFont(level_font);
		}
		
		this.content.add(level);
		this.main.add(content,BorderLayout.CENTER);	
	}
	public void setMenu() {
		// add option to the meni
		JButton exit = new JButton("EXIT");
		JButton play = new JButton("PLAY");
		exit.setIcon(new ImageIcon("./Icon/logout.png"));
		play.setIcon(new ImageIcon("./Icon/play.png"));
		// style the button text
		exit.setFont(new Font("Serif", Font.ITALIC + Font.BOLD, 20));
		play.setFont(new Font("Serif", Font.ITALIC + Font.BOLD, 20));
		footer.add(exit);
		footer.add(play);
		
		this.main.add(footer, BorderLayout.SOUTH);
		
		this.backgroundPanel.add(this.main,BorderLayout.CENTER);
	}
	
	
	
	
	
	
	
	public static void main(String args[]) {
		WelcomePage welcome = new WelcomePage(900, 700,"./Background/Logo.png");
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		welcome.centerFrame(dim);
		String img_path = "./Background/Logo.png";
		welcome.setWelocomIcon(img_path);
		welcome.setHeader(img_path);
		String[] categories= {"History", "Biology", "Sport", "ComputerScience","Math"};
		welcome.setCategories(categories);
		String[] levels = {"Easy", "Medium", "Hard"};
		welcome.setLevel(levels);
		welcome.setMenu();
		
	}
	
}
