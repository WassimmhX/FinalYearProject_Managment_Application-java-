import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Home extends JPanel{
    public Home(){

        this.setBackground(new Color(36, 47, 65));
        JLabel lblNewLabel = new JLabel("Bienvenue à");
        lblNewLabel.setBounds(463, 188, 192, 46);
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 30));

        JLabel lblNewLabel_1 = new JLabel("Gestionnaire de PFE");
        lblNewLabel_1.setBounds(396, 253, 320, 37);
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 30));

        JSeparator separator = new JSeparator();
        separator.setBounds(450, 240, 213, 2);

        JSeparator separator_1 = new JSeparator();
        separator_1.setBounds(385, 296, 344, 2);
        separator_1.setBackground(new Color(255, 255, 255));
        setLayout(null);
        BufferedImage img=null;
        try {
            img= ImageIO.read(Home.class.getResource("/image/isimm.png"));
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("hh");
        }
        JLabel picLabel=new JLabel(new ImageIcon(img.getScaledInstance(150,150,Image.SCALE_FAST)));
        picLabel.setBounds(930,430,150,150);
        add(picLabel);
        add(lblNewLabel);
        add(separator);
        add(lblNewLabel_1);
        add(separator_1);
    }
}
