import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SupprimerGrp extends JPanel implements ActionListener {
    private BaseDonnee bd;
    private static JButton btnSupprimerGrp;
    private static JTextField spGrp;
    public SupprimerGrp(BaseDonnee bd){
        this.bd=bd;
        this.setLayout(null);
        this.setBackground(new Color(36, 47, 65));

        JLabel lblNewLabel_3_2 = new JLabel("Suppression de Group");
        lblNewLabel_3_2.setForeground(Color.WHITE);
        lblNewLabel_3_2.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 22));
        lblNewLabel_3_2.setBounds(427, 51, 269, 25);
        this.add(lblNewLabel_3_2);

        JSeparator separator_19_2 = new JSeparator();
        separator_19_2.setForeground(Color.WHITE);
        separator_19_2.setBounds(421, 87, 287, 7);
        this.add(separator_19_2);

        JSeparator separator_20_2 = new JSeparator();
        separator_20_2.setForeground(Color.WHITE);
        separator_20_2.setBounds(431, 105, 265, 18);
        this.add(separator_20_2);

        JLabel lblNewLabel_4_2 = new JLabel("N° de Group :");
        lblNewLabel_4_2.setForeground(new Color(97, 212, 195));
        lblNewLabel_4_2.setFont(new Font("Century Gothic", Font.BOLD, 16));
        lblNewLabel_4_2.setBounds(507, 188, 109, 25);
        this.add(lblNewLabel_4_2);

        spGrp = new JTextField();
        spGrp.setForeground(Color.WHITE);
        spGrp.setFont(new Font("Century Gothic", Font.BOLD, 13));
        spGrp.setColumns(10);
        spGrp.setBorder(null);
        spGrp.setBackground(new Color(36, 47, 65));
        spGrp.setBounds(470, 213, 194, 25);
        spGrp.addFocusListener(new FocusTextField(spGrp));
        spGrp.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    btnSupprimerGrp.doClick();
            }
        });
        this.add(spGrp);

        JSeparator separator_21_2 = new JSeparator();
        separator_21_2.setForeground(new Color(97, 212, 195));
        separator_21_2.setBackground(new Color(97, 212, 195));
        separator_21_2.setBounds(470, 240, 194, 25);
        this.add(separator_21_2);

        btnSupprimerGrp = new JButton();
        btnSupprimerGrp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnSupprimerGrp.setText("Supprimer");
        btnSupprimerGrp.setForeground(Color.WHITE);
        btnSupprimerGrp.setFont(new Font("Century Gothic", Font.BOLD, 14));
        btnSupprimerGrp.setBackground(new Color(97, 212, 195));
        btnSupprimerGrp.setBounds(483, 401, 166, 42);
        this.add(btnSupprimerGrp);
        btnSupprimerGrp.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnSupprimerGrp){
            try{
                String nb=spGrp.getText();
                if(nb.isEmpty())
                    throw new Exceptions("le champ est vide");
                else if(!nb.matches("\\d+"))
                    throw new Exceptions("le numero doit etre numerique");
                int n=Integer.parseInt(nb);
                int index=bd.findGroup((Group g)->g.getNb()==n);
                if(index==-1){
                    throw new Exceptions("Group n'existe pas");
                }
                try{
                    bd.executeSQLUpdate("Delete from Groups where nbgroup="+nb);
                    bd.getDATA();
                    JOptionPane.showMessageDialog(this,"Suppresion effectuée avec succès\n(le PFE et le soutenance reliee a cet group seront aussi supprimer s'ils exitent)","Succès",JOptionPane.INFORMATION_MESSAGE);
                }catch (Exception r){
                    System.out.println(r.getMessage());
                    throw new Exceptions("Group n'existe pas");
                }
            }catch (Exceptions r){
                r.exec(this);
            }
        }
    }
}
