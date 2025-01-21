
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
// defined class




public class PlayPage extends JFrame {
    private int width;
    private int height;
    private JPanel main_play;
    private JPanel header_play;
    private JPanel hint;
    private JTextField[] letters;
    private JPanel letters_panel;
    private JButton[] buttons;
    private JPanel buttons_panel;
    private BackgroundPanel backgroundPanel;
    private JPanel footer_play;
    private JLabel life;
    private JLabel question;
    // constructor
    public PlayPage(int width, int height, String background_path) {
        // frame
        super("BrainBusters");
        this.width = width;
        this.height = height;
        this.main_play = new JPanel();
        //this.main_play;
        this.header_play = new JPanel();
        this.footer_play = new JPanel();
        this.hint = new JPanel();
        //main panel
        this.main_play.setLayout(new BoxLayout(this.main_play,BoxLayout.Y_AXIS));

        // create the background
        backgroundPanel = new BackgroundPanel(background_path);
        backgroundPanel.setSize(width, height);
        backgroundPanel = setHeader(3, 8);
        backgroundPanel = setHint("this is the hint you actually need i need a lot of text to test it acrually");
        backgroundPanel = setLetters("Ihssane");
        backgroundPanel = setButtons("ihssane" + "FSGGSJHHSHH");
        backgroundPanel = setMenu();

        this.add(backgroundPanel);
        this.setVisible(true);
        this.setSize(width, height);
    }

    public void centerFrame(Dimension screen) {
        this.setLocation(screen.width/2 - this.getWidth()/2, screen.height/2 - this.getHeight()/2);
    }

    public void setWelocomIcon(String img) {
        ImageIcon img_icon = new ImageIcon(img);
        this.setIconImage(img_icon.getImage());
    }
    public BackgroundPanel setHeader(int nbr_life, int nbr_qu) {
        this.header_play.setLayout(new FlowLayout());
        JLabel title = new JLabel("BrainBusters");
        life = new JLabel(Integer.toString(nbr_life));
        question = new JLabel(Integer.toString(nbr_qu));
        life.setIcon(new ImageIcon("./Icon/heart.png"));
        question.setIcon(new ImageIcon("./Icon/question.png"));
        Font font = new Font("Serif", Font.BOLD + Font.ITALIC, 25);
        title.setFont(font);
        life.setFont(font);
        question.setFont(font);
        this.header_play.add(title);
        this.header_play.add(life);
        this.header_play.add(question);

        this.main_play.add(header_play, BorderLayout.NORTH);
        this.backgroundPanel.add(this.main_play);
        return backgroundPanel;
    }

    public BackgroundPanel setHint(String hint) {
        JTextArea hint_box  = new JTextArea(hint);
        // Set preferred size
        hint_box.setPreferredSize(new Dimension(500, 200));
        JScrollPane scroll = new JScrollPane(hint_box);

        Font hint_font = new Font("Serif", Font.ITALIC, 30);
        hint_box.setEditable(false);
        hint_box.setFont(hint_font);
        hint_box.setLineWrap(true);
        hint_box.setWrapStyleWord(true);
        this.hint.add(scroll);
        this.main_play.add(this.hint,BorderLayout.CENTER);
        this.backgroundPanel.add(this.main_play);
        return backgroundPanel;
    }


    //
    public BackgroundPanel setButtons(String word) {
        buttons_panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttons_panel.setPreferredSize(new Dimension(200,100));
        Font button_font = new Font("Serif", Font.ITALIC + Font.BOLD, 40);
        int nbr_char = word.length();
        buttons = new JButton[nbr_char];
        for (int i = 0; i < nbr_char; i++) {
            buttons[i] = new JButton("?");
            buttons[i].setFont(button_font);
            buttons[i].setPreferredSize(new Dimension(40,40));

            buttons_panel.add(buttons[i]);

        }
        this.main_play.add(buttons_panel);
        this.backgroundPanel.add(main_play);
        return backgroundPanel;
    }

    public BackgroundPanel setLetters(String word) {
        letters_panel = new JPanel();
        //letters_panel.setLayout(new FlowLayout());
        Font letter_font = new Font("Serif", Font.ITALIC + Font.BOLD, 40);
        int nbr_char = word.length();
        letters = new JTextField[nbr_char];
        for (int i = 0; i < nbr_char; i++) {
            letters[i] = new JTextField("?");
            letters[i].setFont(letter_font);
            letters[i].setPreferredSize(new Dimension(50,50));

            letters_panel.add(letters[i]);

        }
        this.main_play.add(letters_panel);
        this.backgroundPanel.add(main_play);
        return backgroundPanel;
    }

    public BackgroundPanel setMenu() {
        // add option to the meni

        JButton quit = new JButton("Exit");
        JButton next = new JButton("Next");
        JButton previous= new JButton("Previous");
        next.setIcon(new ImageIcon("./Icon/next.png"));
        previous.setIcon(new ImageIcon("./Icon/previous.png"));
        quit.setIcon(new ImageIcon("./Icon/logout.png"));
        // style the button text
        quit.setFont(new Font("Serif", Font.ITALIC + Font.BOLD, 20));
        next.setFont(new Font("Serif", Font.ITALIC + Font.BOLD, 20));
        previous.setFont(new Font("Serif", Font.ITALIC + Font.BOLD, 20));
        footer_play.add(quit);
        footer_play.add(previous);
        footer_play.add(next);
        this.main_play.add(footer_play);

        this.backgroundPanel.add(this.main_play);
        return backgroundPanel;
    }







    public static void main(String args[]) {
        PlayPage play = new PlayPage(900, 700,"./Background/History.png");
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        play.centerFrame(dim);
        String img_path = "./Background/Logo.png";
        play.setWelocomIcon(img_path);
        //play.setHeader(3,5);


    }

}
