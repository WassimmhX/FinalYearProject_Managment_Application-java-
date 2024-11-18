import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SupprimerEns extends JPanel implements ActionListener {
    private BaseDonnee bd;
    private static JButton btnSupprimerEns;
    private static JTextField spCINEns;
    public SupprimerEns(BaseDonnee bd){
        this.bd=bd;
        this.setLayout(null);
        this.setBackground(new Color(36, 47, 65));

        JLabel lblNewLabel_3_1 = new JLabel("Suppression d'Enseignant");
        lblNewLabel_3_1.setForeground(Color.WHITE);
        lblNewLabel_3_1.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 22));
        lblNewLabel_3_1.setBounds(413, 51, 310, 25);
        this.add(lblNewLabel_3_1);

        JSeparator separator_19_1 = new JSeparator();
        separator_19_1.setForeground(Color.WHITE);
        separator_19_1.setBounds(405, 87, 315, 7);
        this.add(separator_19_1);

        JSeparator separator_20_1 = new JSeparator();
        separator_20_1.setForeground(Color.WHITE);
        separator_20_1.setBounds(431, 105, 265, 18);
        this.add(separator_20_1);

        JLabel lblNewLabel_4_1 = new JLabel("CIN :");
        lblNewLabel_4_1.setForeground(new Color(97, 212, 195));
        lblNewLabel_4_1.setFont(new Font("Century Gothic", Font.BOLD, 16));
        lblNewLabel_4_1.setBounds(542, 191, 46, 14);
        this.add(lblNewLabel_4_1);

        spCINEns = new JTextField();
        spCINEns.setForeground(Color.WHITE);
        spCINEns.setFont(new Font("Century Gothic", Font.BOLD, 13));
        spCINEns.setColumns(10);
        spCINEns.setBorder(null);
        spCINEns.setBackground(new Color(36, 47, 65));
        spCINEns.setBounds(470, 216, 194, 22);
        spCINEns.addFocusListener(new FocusTextField(spCINEns));
        spCINEns.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    btnSupprimerEns.doClick();
            }
        });
        this.add(spCINEns);

        JSeparator separator_21_1 = new JSeparator();
        separator_21_1.setForeground(new Color(97, 212, 195));
        separator_21_1.setBackground(new Color(97, 212, 195));
        separator_21_1.setBounds(470, 240, 194, 25);
        this.add(separator_21_1);

        btnSupprimerEns = new JButton();
        btnSupprimerEns.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnSupprimerEns.setText("Supprimer");
        btnSupprimerEns.setForeground(Color.WHITE);
        btnSupprimerEns.setFont(new Font("Century Gothic", Font.BOLD, 14));
        btnSupprimerEns.setBackground(new Color(97, 212, 195));
        btnSupprimerEns.setBounds(483, 401, 166, 42);
        this.add(btnSupprimerEns);
        btnSupprimerEns.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnSupprimerEns){
            String cin=spCINEns.getText();
            try{
                if(cin.isEmpty()){
                    throw new Exceptions("le champ est vide");
                }
                int index=bd.findEnseignant((Enseignant x)->x.getCIN().equals(cin));
                if(index==-1) {
                    throw new Exceptions("Enseignant n'existe pas");
                }
                try{
                    bd.executeSQLUpdate("delete from Enseignant where CIN="+cin);
                    bd.getDATA();
                    JOptionPane.showMessageDialog(this,"Suppresion effectuée avec succès\n(les groups et les soutenances reliee a cet enseignant seront aussi supprimer s'ils exitent)","Succès",JOptionPane.INFORMATION_MESSAGE);
                }catch (Exception r){
                    System.out.println(r.getMessage());
                    throw new Exceptions("Enseignant n'existe pas");
                }
            }catch (Exceptions r){
                r.exec(this);
            }
        }
    }
}
