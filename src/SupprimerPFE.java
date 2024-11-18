import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SupprimerPFE extends JPanel implements ActionListener {
    private BaseDonnee bd;
    private static JButton btnSupprimerPfe;
    private static JTextField spPfe;
    public SupprimerPFE(BaseDonnee bd){
        this.bd=bd;
        this.setLayout(null);
        this.setBackground(new Color(36, 47, 65));

        JLabel lblNewLabel_3_2_1 = new JLabel("Suppression de PFE");
        lblNewLabel_3_2_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_3_2_1.setForeground(Color.WHITE);
        lblNewLabel_3_2_1.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 22));
        lblNewLabel_3_2_1.setBounds(431, 51, 269, 25);
        this.add(lblNewLabel_3_2_1);

        JSeparator separator_19_2_1 = new JSeparator();
        separator_19_2_1.setForeground(Color.WHITE);
        separator_19_2_1.setBounds(421, 87, 287, 7);
        this.add(separator_19_2_1);

        JSeparator separator_20_2_1 = new JSeparator();
        separator_20_2_1.setForeground(Color.WHITE);
        separator_20_2_1.setBounds(431, 105, 265, 18);
        this.add(separator_20_2_1);

        JLabel lblNewLabel_4_2_1 = new JLabel("Nom de PFE :");
        lblNewLabel_4_2_1.setForeground(new Color(97, 212, 195));
        lblNewLabel_4_2_1.setFont(new Font("Century Gothic", Font.BOLD, 16));
        lblNewLabel_4_2_1.setBounds(507, 188, 109, 25);
        this.add(lblNewLabel_4_2_1);

        spPfe = new JTextField();
        spPfe.setForeground(Color.WHITE);
        spPfe.setFont(new Font("Century Gothic", Font.BOLD, 13));
        spPfe.setColumns(10);
        spPfe.setBorder(null);
        spPfe.setBackground(new Color(36, 47, 65));
        spPfe.setBounds(470, 213, 194, 25);
        spPfe.addFocusListener(new FocusTextField(spPfe));
        spPfe.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    btnSupprimerPfe.doClick();
            }
        });
        this.add(spPfe);

        JSeparator separator_21_2_1 = new JSeparator();
        separator_21_2_1.setForeground(new Color(97, 212, 195));
        separator_21_2_1.setBackground(new Color(97, 212, 195));
        separator_21_2_1.setBounds(470, 240, 194, 25);
        this.add(separator_21_2_1);

        btnSupprimerPfe = new JButton();
        btnSupprimerPfe.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnSupprimerPfe.setText("Supprimer");
        btnSupprimerPfe.setForeground(Color.WHITE);
        btnSupprimerPfe.setFont(new Font("Century Gothic", Font.BOLD, 14));
        btnSupprimerPfe.setBackground(new Color(97, 212, 195));
        btnSupprimerPfe.setBounds(483, 401, 166, 42);
        this.add(btnSupprimerPfe);
        btnSupprimerPfe.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnSupprimerPfe){
            String ch=spPfe.getText().toUpperCase();
            try{
                if(ch.isEmpty())
                    throw new Exceptions("le champ est vide");
                int index =bd.findPfe((Pfe p)->p.getName().equalsIgnoreCase(ch));
                if(index==-1){
                    throw new Exceptions("PFE n'existe pas");
                }
                try{
                    bd.executeSQLUpdate("delete from pfe where name='"+ch+"'");
                    bd.getDATA();
                    JOptionPane.showMessageDialog(this,"Suppresion effectuée avec succès","Succès",JOptionPane.INFORMATION_MESSAGE);
                }catch (Exception r){
                    System.out.println(r.getMessage());
                    throw new Exceptions("Pfe n'existe pas");
                }
            }catch (Exceptions r){
                r.exec(this);
            }
        }
    }
}
