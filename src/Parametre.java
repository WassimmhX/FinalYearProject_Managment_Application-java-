import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Parametre extends JPanel implements ActionListener {
    private JButton btnChanger;
    private JTextField Nom;
    private JTextField newNom;
    private JPasswordField pass;
    private JPasswordField newPass;
    private JPasswordField confPas;
    private BaseDonnee bd;
    Parametre(BaseDonnee bd) {
        this.bd=bd;
        this.setBackground(new Color(36, 47, 65));
        this.setLayout(null);

        JLabel lblNewLabel_3 = new JLabel("Changer le Mote de passe");
        lblNewLabel_3.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 22));
        lblNewLabel_3.setForeground(new Color(255, 255, 255));
        lblNewLabel_3.setBounds(421, 43, 287, 33);
        this.add(lblNewLabel_3);

        JSeparator separator_19 = new JSeparator();
        separator_19.setForeground(new Color(255, 255, 255));
        separator_19.setBounds(421, 87, 287, 7);
        this.add(separator_19);

        JSeparator separator_20 = new JSeparator();
        separator_20.setForeground(new Color(255, 255, 255));
        separator_20.setBounds(431, 105, 265, 18);
        this.add(separator_20);

        JLabel lblNewLabel_4 = new JLabel("Name :");
        lblNewLabel_4.setForeground(new Color(97, 212, 195));
        lblNewLabel_4.setFont(new Font("Century Gothic", Font.BOLD, 13));
        lblNewLabel_4.setBounds(431, 154, 52, 14);
        this.add(lblNewLabel_4);

        Nom = new JTextField();
        Nom.setForeground(new Color(255, 255, 255));
        Nom.setBackground(new Color(36, 47, 65));
        Nom.setBorder(null);
        Nom.setFont(new Font("Century Gothic", Font.BOLD, 13));
        Nom.setBounds(476, 152, 220, 20);
        this.add(Nom);
        Nom.setColumns(10);
        Nom.addFocusListener(new FocusTextField(Nom));
        Nom.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER)
                    btnChanger.doClick();
            }
        });

        JSeparator separator_21 = new JSeparator();
        separator_21.setBackground(new Color(97, 212, 195));
        separator_21.setForeground(new Color(97, 212, 195));
        separator_21.setBounds(431, 172, 265, 8);
        this.add(separator_21);

        btnChanger = new JButton();
        btnChanger.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnChanger.setText("Confirmer");
        btnChanger.setForeground(Color.WHITE);
        btnChanger.setFont(new Font("Century Gothic", Font.BOLD, 14));
        btnChanger.setBackground(new Color(97, 212, 195));
        btnChanger.setBounds(476, 400, 166, 42);
        this.add(btnChanger);

        JLabel lblNewLabel_4_1 = new JLabel("New Name :");
        lblNewLabel_4_1.setForeground(new Color(97, 212, 195));
        lblNewLabel_4_1.setFont(new Font("Century Gothic", Font.BOLD, 13));
        lblNewLabel_4_1.setBounds(431, 229, 86, 14);
        add(lblNewLabel_4_1);

        newNom = new JTextField();
        newNom.setForeground(Color.WHITE);
        newNom.setFont(new Font("Century Gothic", Font.BOLD, 13));
        newNom.setColumns(10);
        newNom.setBorder(null);
        newNom.setBackground(new Color(36, 47, 65));
        newNom.setBounds(516, 227, 180, 20);
        newNom.addFocusListener(new FocusTextField(newNom));
        newNom.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    btnChanger.doClick();
                }
            }
        });
        add(newNom);

        JSeparator separator_21_1 = new JSeparator();
        separator_21_1.setForeground(new Color(97, 212, 195));
        separator_21_1.setBackground(new Color(97, 212, 195));
        separator_21_1.setBounds(431, 248, 265, 4);
        add(separator_21_1);

        JLabel lblNewLabel_4_2 = new JLabel("Password :");
        lblNewLabel_4_2.setForeground(new Color(97, 212, 195));
        lblNewLabel_4_2.setFont(new Font("Century Gothic", Font.BOLD, 13));
        lblNewLabel_4_2.setBounds(434, 191, 68, 14);
        add(lblNewLabel_4_2);

        pass = new JPasswordField();
        pass.setForeground(Color.WHITE);
        pass.setFont(new Font("Century Gothic", Font.BOLD, 13));
        pass.setColumns(10);
        pass.setBorder(null);
        pass.setBackground(new Color(36, 47, 65));
        pass.setBounds(503, 190, 193, 20);
        pass.addFocusListener(new FocusTextField(pass));
        pass.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    btnChanger.doClick();
                }
            }
        });
        add(pass);

        JSeparator separator_21_2 = new JSeparator();
        separator_21_2.setForeground(new Color(97, 212, 195));
        separator_21_2.setBackground(new Color(97, 212, 195));
        separator_21_2.setBounds(431, 210, 265, 18);
        add(separator_21_2);

        JLabel lblNewLabel_4_4 = new JLabel("New Password:");
        lblNewLabel_4_4.setForeground(new Color(97, 212, 195));
        lblNewLabel_4_4.setFont(new Font("Century Gothic", Font.BOLD, 13));
        lblNewLabel_4_4.setBounds(431, 270, 96, 14);
        add(lblNewLabel_4_4);

        newPass = new JPasswordField();
        newPass.setForeground(Color.WHITE);
        newPass.setFont(new Font("Century Gothic", Font.BOLD, 13));
        newPass.setColumns(10);
        newPass.setBorder(null);
        newPass.setBackground(new Color(36, 47, 65));
        newPass.setBounds(530, 268, 166, 20);
        newPass.addFocusListener(new FocusTextField(newPass));
        newPass.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    btnChanger.doClick();
                }
            }
        });
        add(newPass);

        JSeparator separator_21_4 = new JSeparator();
        separator_21_4.setForeground(new Color(97, 212, 195));
        separator_21_4.setBackground(new Color(97, 212, 195));
        separator_21_4.setBounds(431, 288, 265, 18);
        add(separator_21_4);

        JLabel lblNewLabel_4_4_1 = new JLabel("Confirm Password :");
        lblNewLabel_4_4_1.setForeground(new Color(97, 212, 195));
        lblNewLabel_4_4_1.setFont(new Font("Century Gothic", Font.BOLD, 13));
        lblNewLabel_4_4_1.setBounds(429, 310, 123, 14);
        add(lblNewLabel_4_4_1);

        confPas = new JPasswordField();
        confPas.setForeground(Color.WHITE);
        confPas.setFont(new Font("Century Gothic", Font.BOLD, 13));
        confPas.setColumns(10);
        confPas.setBorder(null);
        confPas.setBackground(new Color(36, 47, 65));
        confPas.setBounds(555, 308, 141, 20);
        confPas.addFocusListener(new FocusTextField(confPas));
        confPas.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    btnChanger.doClick();
                }
            }
        });
        add(confPas);

        JSeparator separator_21_4_1 = new JSeparator();
        separator_21_4_1.setForeground(new Color(97, 212, 195));
        separator_21_4_1.setBackground(new Color(97, 212, 195));
        separator_21_4_1.setBounds(429, 328, 267, 18);
        add(separator_21_4_1);
        setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{Nom, newNom, pass, newPass, confPas}));
        btnChanger.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String nom=Nom.getText();
        String nNom=newNom.getText();
        String pas=pass.getText();
        String nPas=newPass.getText();
        String cPas=confPas.getText();
        String PASSWORD=bd.login[0];
        String NAME=bd.login[1];
        try{
            if(nom.isEmpty()||nNom.isEmpty()||pas.isEmpty()||nPas.isEmpty()||cPas.isEmpty())
                throw new Exceptions("il y a un champ vide");
            if(!nom.equals(NAME))
                throw new Exceptions("Nom est incorrect");
            if(!pas.equals(PASSWORD)) {
                pass.setText("");
                throw new Exceptions("Password est incorrect");
            }
            if(!cPas.equals(nPas)) {
                confPas.setText("");
                throw new Exceptions("confirmer le password!!");
            }
            try {
                int b=JOptionPane.showConfirmDialog(this,"Confirmer!!!");
                if(b==JOptionPane.YES_OPTION){
                    bd.executeSQLUpdate("truncate table login");
                    bd.executeSQLUpdate("insert into login values('"+nPas+"','"+nNom+"')");
                    JOptionPane.showMessageDialog(this,"login est modifiée avec succées","Succès",JOptionPane.INFORMATION_MESSAGE);
                }
            }catch (Exception b){
                throw new Exceptions("something went wrong!!");
            }
        }catch (Exceptions r){
            r.exec(this);
        }
    }
}
