import javax.swing.*;
import java.awt.*;

public class BackgroundPanel extends JPanel {
    private Image backgroundImage;

    public BackgroundPanel(String imgPath) {
        backgroundImage = new ImageIcon(imgPath).getImage();
        this.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }
    public  static void main(String[] args) {
    	JFrame frame = new JFrame("Background Panel Example");
        BackgroundPanel background = new BackgroundPanel("./Background/Logo.png");

        frame.add(background);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setVisible(true);
    
    	
    }
}