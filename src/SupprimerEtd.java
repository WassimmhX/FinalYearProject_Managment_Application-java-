import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SupprimerEtd extends JPanel implements ActionListener {
    private BaseDonnee bd;
    private static JButton btnSupprimerEtd;
    private static JTextField spCINEtd;
    public SupprimerEtd(BaseDonnee bd){
        this.bd=bd;

        this.setBackground(new Color(36, 47, 65));
        this.setLayout(null);

        JLabel lblNewLabel_3 = new JLabel("Suppression d'Etudiant");
        lblNewLabel_3.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 22));
        lblNewLabel_3.setForeground(new Color(255, 255, 255));
        lblNewLabel_3.setBounds(427, 51, 269, 25);
        this.add(lblNewLabel_3);

        JSeparator separator_19 = new JSeparator();
        separator_19.setForeground(new Color(255, 255, 255));
        separator_19.setBounds(421, 87, 287, 7);
        this.add(separator_19);

        JSeparator separator_20 = new JSeparator();
        separator_20.setForeground(new Color(255, 255, 255));
        separator_20.setBounds(431, 105, 265, 18);
        this.add(separator_20);

        JLabel lblNewLabel_4 = new JLabel("CIN :");
        lblNewLabel_4.setForeground(new Color(97, 212, 195));
        lblNewLabel_4.setFont(new Font("Century Gothic", Font.BOLD, 16));
        lblNewLabel_4.setBounds(540, 193, 46, 14);
        this.add(lblNewLabel_4);

        spCINEtd = new JTextField();
        spCINEtd.setForeground(new Color(255, 255, 255));
        spCINEtd.setBackground(new Color(36, 47, 65));
        spCINEtd.setBorder(null);
        spCINEtd.setFont(new Font("Century Gothic", Font.BOLD, 13));
        spCINEtd.setBounds(470, 218, 194, 20);
        this.add(spCINEtd);
        spCINEtd.setColumns(10);
        spCINEtd.addFocusListener(new FocusTextField(spCINEtd));
        spCINEtd.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    btnSupprimerEtd.doClick();
            }
        });

        JSeparator separator_21 = new JSeparator();
        separator_21.setBackground(new Color(97, 212, 195));
        separator_21.setForeground(new Color(97, 212, 195));
        separator_21.setBounds(470, 240, 194, 25);
        this.add(separator_21);

        btnSupprimerEtd = new JButton();
        btnSupprimerEtd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnSupprimerEtd.setText("Supprimer");
        btnSupprimerEtd.setForeground(Color.WHITE);
        btnSupprimerEtd.setFont(new Font("Century Gothic", Font.BOLD, 14));
        btnSupprimerEtd.setBackground(new Color(97, 212, 195));
        btnSupprimerEtd.setBounds(483, 401, 166, 42);
        this.add(btnSupprimerEtd);
        btnSupprimerEtd.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnSupprimerEtd){
            String cin=spCINEtd.getText();
            try{
                if(cin==""){
                    throw new Exceptions("le champ est vide");
                }
                int index=bd.findEtudiant((Etudiant x)->x.getCIN().equals(cin));
                if(index==-1)
                    throw new Exceptions("Etudiant n'existe pas");
                try{
                    bd.executeSQLUpdate("delete from Etudiant where CIN="+cin);
                    bd.getDATA();
                    JOptionPane.showMessageDialog(this,"Suppresion effectuée avec succès\n(le group reliee a cet etudiant sera aussi supprimer s'il exite)","Succès",JOptionPane.INFORMATION_MESSAGE);
                }catch (Exception r){
                    System.out.println(r.getMessage());
                    throw new Exceptions("Etudiant n'existe pas");
                }
            }catch (Exceptions r){
                r.exec(this);
            }
        }
    }
}
