import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JPanel jPanel2;
    private JLabel jLabel2 ;
    private JLabel jLabel3 ;
    private JLabel jLabel4;
    private JSeparator jSeparator2;
    private JSeparator jSeparator3 ;
    private JSeparator jSeparator4 ;
    private JPanel jPanel1;
    private JLabel jLabel1 ;
    private JSeparator jSeparator1 ;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JPasswordField jPasswordField1 ;
    private JSeparator jSeparator5 ;
    private JTextField name ;
    private JSeparator jSeparator7 ;
    private JButton jButton1 ;
    private BaseDonnee bd;
    public Login() {
        //bd=new BaseDonnee();
        bd=null;
        setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/image/pfe.jpg")));
        setTitle("Gestion de PFE");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 900, 510);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(36, 47, 65));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        jPanel2 = new JPanel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jSeparator2 = new JSeparator();
        jSeparator3 = new JSeparator();
        jSeparator4 = new JSeparator();
        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        jSeparator1 = new JSeparator();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        jPasswordField1 = new JPasswordField();
        jPasswordField1.addFocusListener(new FocusTextField(jPasswordField1));
        jPasswordField1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    jButton1.doClick();
                }
            }
        });
        jSeparator5 = new JSeparator();
        name = new JTextField();
        name.addFocusListener(new FocusTextField(name));
        name.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    jButton1.doClick();
                }
            }
        });
        jSeparator7 = new JSeparator();
        jButton1 = new JButton();

        jPanel2.setBackground(new Color(97, 212, 195));
        jPanel2.setLayout(null);
        jPanel2.setBounds(0,0,440,510);
        contentPane.add(jPanel2);

        jLabel2.setBounds(130,270,220,40);
        jLabel2.setFont(new Font("Century Schoolbook", 3, 30)); // NOI18N
        jLabel2.setForeground(new Color(255, 255, 255));
        jLabel2.setText("FIN D'ETUDE");
        jPanel2.add(jLabel2);

        jLabel3.setBounds(40,150,220,40);
        jLabel3.setFont(new Font("Century Schoolbook", 3, 30)); // NOI18N
        jLabel3.setForeground(new Color(255, 255, 255));
        jLabel3.setText("GESTION DE");
        jPanel2.add(jLabel3);

        jLabel4.setBounds(100,210,220,40);
        jLabel4.setFont(new Font("Century Schoolbook", 3, 30)); // NOI18N
        jLabel4.setForeground(new Color(255, 255, 255));
        jLabel4.setText("PROJET DE");
        jPanel2.add(jLabel4);

        jSeparator2.setBounds(40,190,220,10);
        jSeparator2.setBackground(new Color(255, 255, 255));
        jSeparator2.setForeground(new Color(255, 255, 255));
        jPanel2.add(jSeparator2);

        jSeparator3.setBounds(90,250,220,10);
        jSeparator3.setBackground(new Color(255, 255, 255));
        jSeparator3.setForeground(new Color(255, 255, 255));
        jPanel2.add(jSeparator3);

        jSeparator4.setBounds(130,310,220,10);
        jSeparator4.setBackground(new Color(255, 255, 255));
        jSeparator4.setForeground(new Color(255, 255, 255));
        jPanel2.add(jSeparator4);

        jPanel1.setBackground(new Color(36, 47, 65));
        jPanel1.setLayout(null);
        jPanel1.setBounds(440,0,460,510);
        contentPane.add(jPanel2);

        jLabel1.setBounds(100,234,90,20);
        jLabel1.setFont(new Font("Century Gothic", 1, 16)); // NOI18N
        jLabel1.setForeground(new Color(255, 255, 255));
        jLabel1.setText("Password :");
        jPanel1.add(jLabel1);

        jSeparator1.setBounds(100,282,270,8);
        jSeparator1.setBackground(new Color(255, 255, 255));
        jSeparator1.setForeground(new Color(255, 255, 255));
        jPanel1.add(jSeparator1);

        jLabel5.setBounds(210,60,60,30);
        jLabel5.setFont(new Font("Century Gothic", 1, 16)); // NOI18N
        jLabel5.setForeground(new Color(255, 255, 255));
        jLabel5.setText("Sign in");
        jPanel1.add(jLabel5);

        jLabel6.setBounds(100,140,90,20);
        jLabel6.setFont(new Font("Century Gothic", 1, 16)); // NOI18N
        jLabel6.setForeground(new Color(255, 255, 255));
        jLabel6.setText("Full Name :");
        jPanel1.add(jLabel6);

        jPasswordField1.setBounds(100,253,270,30);
        jPasswordField1.setBackground(new Color(36, 47, 65));
        jPasswordField1.setForeground(new Color(255, 255, 255));
        jPasswordField1.setBorder(null);
        jPanel1.add(jPasswordField1);

        jSeparator5.setBounds(100,190,270,20);
        jSeparator5.setBackground(new Color(255, 255, 255));
        jSeparator5.setForeground(new Color(255, 255, 255));
        jPanel1.add(jSeparator5);

        name.setBounds(100,160,270,30);
        name.setBackground(new Color(36, 47, 65));
        name.setFont(new Font("Century Gothic", 0, 12)); // NOI18N
        name.setForeground(new Color(255, 255, 255));
        name.setBorder(null);
        name.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        name.setDisabledTextColor(new Color(255, 255, 255));

        jPanel1.add(name);

        jSeparator7.setBounds(200,90,70,20);
        jSeparator7.setBackground(new Color(255, 255, 255));
        jSeparator7.setForeground(new Color(255, 255, 255));
        jPanel1.add(jSeparator7);

        jButton1.setBounds(170,370,140,40);
        jButton1.setBackground(new Color(97, 212, 195));
        jButton1.setFont(new Font("Century Gothic", 1, 14)); // NOI18N
        jButton1.setForeground(new Color(255, 255, 255));
        jButton1.setText("Sign in");
        jButton1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jPanel1.add(jButton1);
        contentPane.add(jPanel1);

        JSeparator separator = new JSeparator();
        separator.setForeground(new Color(36, 47, 65));
        separator.setBackground(new Color(121, 121, 121));
        separator.setBounds(175, 336, 125, 2);

        JLabel lblNewLabel = new JLabel("mot de passe oublier");
        lblNewLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                lblNewLabel.setForeground(new Color(0,0,220));
                separator.setBackground(new Color(0,0,220));
            }
            public void mouseExited(MouseEvent e) {
                lblNewLabel.setForeground(new Color(121, 121, 121));
                separator.setBackground(new Color(121, 121, 121));
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                int b=JOptionPane.showConfirmDialog(contentPane,"le mot de passe sera reinitialiser à 'test'/'test' mais toute les données seront perdus");
                if(b==JOptionPane.YES_OPTION){
                    try {
                        bd.executeSQLUpdate("truncate table etudiant");
                        bd.executeSQLUpdate("truncate table enseignant");
                        bd.executeSQLUpdate("truncate table groups");
                        bd.executeSQLUpdate("truncate table pfe");
                        bd.executeSQLUpdate("truncate table soutenance");
                        bd.executeSQLUpdate("truncate table login");
                        bd.executeSQLUpdate("insert into login values('test','test')");
                    }catch (Exception r){
                    }
                }
            }
        });
        lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblNewLabel.setForeground(new Color(121, 121, 121));
        lblNewLabel.setFont(new Font("Century Schoolbook", Font.BOLD, 11));
        lblNewLabel.setBounds(178, 317, 125, 14);
        jPanel1.add(lblNewLabel);
        jPanel1.add(separator);
        jPanel1.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{jLabel1, jSeparator1, jLabel5, jLabel6, jPasswordField1, jSeparator5, name, jSeparator7, jButton1, lblNewLabel, lblNewLabel, separator}));
        jButton1.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==jButton1){
            String PASSWORD=bd.login[0];
            String NAME=bd.login[1];
            String fullname=name.getText();
            String pass=jPasswordField1.getText();
            if(fullname.equals(NAME)&&pass.equals(PASSWORD)){
                Menu.begin();
                dispose();
            }
            else {
                JOptionPane.showMessageDialog(this,"il y a un champ vide ou incorrecte","ERROR",JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}