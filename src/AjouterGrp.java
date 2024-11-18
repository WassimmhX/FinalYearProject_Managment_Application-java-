import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AjouterGrp extends JPanel implements ActionListener {
    private BaseDonnee bd;
    private static JButton btnAjouterGrp;
    private static JTextField grpEtd1,grpEtd2,grpEncdr;
    public AjouterGrp(BaseDonnee bd){
        this.bd=bd;
        this.setBackground(new Color(36, 47, 65));

        JLabel lblNewLabel_2_2 = new JLabel("Ajouter Group");
        lblNewLabel_2_2.setBounds(440, 48, 218, 27);
        lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2_2.setForeground(Color.WHITE);
        lblNewLabel_2_2.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 22));
        lblNewLabel_2_2.setBackground(Color.WHITE);

        JSeparator separator_15_2 = new JSeparator();
        separator_15_2.setBounds(431, 86, 236, 6);

        JSeparator separator_16_2 = new JSeparator();
        separator_16_2.setBounds(463, 98, 175, 11);

        btnAjouterGrp = new JButton();
        btnAjouterGrp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnAjouterGrp.setBounds(471, 421, 166, 40);
        btnAjouterGrp.setText("Ajouter");
        btnAjouterGrp.setForeground(Color.WHITE);
        btnAjouterGrp.setFont(new Font("Century Gothic", Font.BOLD, 14));
        btnAjouterGrp.setBackground(new Color(97, 212, 195));

        JSeparator separator_17_4 = new JSeparator();
        separator_17_4.setBounds(159, 203, 267, 11);
        separator_17_4.setForeground(new Color(97, 212, 195));
        separator_17_4.setBackground(new Color(97, 212, 195));

        JLabel lblEtudiantcin = new JLabel();
        lblEtudiantcin.setBounds(159, 174, 123, 20);
        lblEtudiantcin.setText("Etudiant 1(CIN) :");
        lblEtudiantcin.setForeground(new Color(97, 212, 195));
        lblEtudiantcin.setFont(new Font("Century Gothic", Font.BOLD, 16));

        grpEtd1 = new JTextField();
        grpEtd1.setBounds(286, 174, 140, 23);
        grpEtd1.setForeground(Color.WHITE);
        grpEtd1.setFont(new Font("Century Gothic", Font.BOLD, 13));
        grpEtd1.setDisabledTextColor(Color.WHITE);
        grpEtd1.setBorder(null);
        grpEtd1.setBackground(new Color(36, 47, 65));
        grpEtd1.addFocusListener(new FocusTextField(grpEtd1));
        grpEtd1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    btnAjouterGrp.doClick();
            }
        });

        JLabel lblEncadreurcin = new JLabel();
        lblEncadreurcin.setBounds(407, 292, 129, 20);
        lblEncadreurcin.setText("Encadreur(CIN):");
        lblEncadreurcin.setHorizontalAlignment(SwingConstants.CENTER);
        lblEncadreurcin.setForeground(new Color(97, 212, 195));
        lblEncadreurcin.setFont(new Font("Century Gothic", Font.BOLD, 16));

        grpEncdr = new JTextField();
        grpEncdr.setBounds(546, 292, 166, 23);
        grpEncdr.setForeground(Color.WHITE);
        grpEncdr.setFont(new Font("Century Gothic", Font.BOLD, 13));
        grpEncdr.setDisabledTextColor(Color.WHITE);
        grpEncdr.setBorder(null);
        grpEncdr.setBackground(new Color(36, 47, 65));
        grpEncdr.addFocusListener(new FocusTextField(grpEncdr));
        grpEncdr.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    btnAjouterGrp.doClick();
            }
        });

        JSeparator separator_17_1_2 = new JSeparator();
        separator_17_1_2.setBounds(407, 323, 305, 11);
        separator_17_1_2.setForeground(new Color(97, 212, 195));
        separator_17_1_2.setBackground(new Color(97, 212, 195));

        JLabel lblEtudiantcin_1 = new JLabel();
        lblEtudiantcin_1.setBounds(640, 174, 123, 20);
        lblEtudiantcin_1.setText("Etudiant 2(CIN) :");
        lblEtudiantcin_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblEtudiantcin_1.setForeground(new Color(97, 212, 195));
        lblEtudiantcin_1.setFont(new Font("Century Gothic", Font.BOLD, 16));

        grpEtd2 = new JTextField();
        grpEtd2.setBounds(771, 174, 137, 23);
        grpEtd2.setForeground(Color.WHITE);
        grpEtd2.setFont(new Font("Century Gothic", Font.BOLD, 13));
        grpEtd2.setDisabledTextColor(Color.WHITE);
        grpEtd2.setBorder(null);
        grpEtd2.setBackground(new Color(36, 47, 65));
        grpEtd2.addFocusListener(new FocusTextField(grpEtd2));
        grpEtd2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    btnAjouterGrp.doClick();
            }
        });

        JSeparator separator_17_2_3 = new JSeparator();
        separator_17_2_3.setBounds(640, 203, 268, 11);
        separator_17_2_3.setForeground(new Color(97, 212, 195));
        separator_17_2_3.setBackground(new Color(97, 212, 195));
        this.setLayout(null);
        this.add(lblNewLabel_2_2);
        this.add(separator_15_2);
        this.add(separator_16_2);
        this.add(btnAjouterGrp);
        this.add(separator_17_4);
        this.add(lblEtudiantcin);
        this.add(grpEtd1);
        this.add(lblEncadreurcin);
        this.add(grpEncdr);
        this.add(separator_17_1_2);
        this.add(lblEtudiantcin_1);
        this.add(grpEtd2);
        this.add(separator_17_2_3);

        JLabel lblNewLabel_7 = new JLabel("New label");
        lblNewLabel_7.setBounds(418, 174, 8, 6);
        this.add(lblNewLabel_7);

        JLabel lblNewLabel_8 = new JLabel("(Obligatoire)");
        lblNewLabel_8.setFont(new Font("Century Gothic", Font.BOLD, 10));
        lblNewLabel_8.setForeground(new Color(255, 79, 79));
        lblNewLabel_8.setBounds(428, 178, 61, 27);
        this.add(lblNewLabel_8);

        JLabel lblNewLabel_8_1 = new JLabel("(Optionnel)");
        lblNewLabel_8_1.setForeground(new Color(0, 187, 0));
        lblNewLabel_8_1.setFont(new Font("Century Gothic", Font.BOLD, 10));
        lblNewLabel_8_1.setBounds(909, 180, 61, 27);
        this.add(lblNewLabel_8_1);
        this.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{grpEtd1, grpEtd2, grpEncdr}));
        btnAjouterGrp.addActionListener(this);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnAjouterGrp){
            String ch1=grpEtd1.getText();
            String ch2=grpEtd2.getText();
            String ch3=grpEncdr.getText();
            try{
                if(ch1.isEmpty()){
                    throw new Exceptions("le group doit avoir au moins un etudiant");
                }
                else if(ch3.isEmpty()){
                    throw new Exceptions("le group doit avoir un encadreur");
                }
                else if(!ch1.matches("\\d+")||ch1.length()!=8||!ch3.matches("\\d+")||ch3.length()!=8)
                    throw new Exceptions("CIN doit etre 8 chiffres");
                else if(!ch2.isEmpty() && (!ch2.matches("\\d+")||ch2.length()!=8))
                    throw new Exceptions("CIN doit etre 8 chiffres");
                int s1=bd.findEtudiant((Etudiant r)->r.getCIN().equals(ch1));
                int s2=bd.findEtudiant((Etudiant r)->r.getCIN().equals(ch2));
                if(s1==-1)
                    throw new Exceptions("etudiant 1 n'existe pas");
                else if(!ch2.isEmpty()&&s2==-1)
                    throw new Exceptions("etudiant 2 n'existe pas");
                else if(!ch2.isEmpty()&& !bd.etudiants.get(s1).getEd().equals(bd.etudiants.get(s2).getEd()))
                    throw new Exceptions("les etudiant doient avoir la meme formation");
                int x=bd.findEnseignant((Enseignant r)->r.getCIN().equals(ch3));
                if(x==-1)
                    throw new Exceptions("encadreur n'existe pas");
                int index=bd.findGroup((Group g)->{
                    for(String i:g.getEtds()){
                        if(i.equals(ch1)||i.equals(ch2))
                            return true;
                    }
                    return false;
                });
                if(index!=-1) {
                    throw new Exceptions("Group existe deja");
                }
                try{
                    Group grp=new Group(bd.groups.size()+1,new String[]{ch1,ch2.isEmpty()?"-":ch2},ch3);
                    bd.insertInto("Groups",grp);
                    bd.groups.add(grp);
                    JOptionPane.showMessageDialog(this,"l'Ajout est effectuée avec succès","Succès",JOptionPane.INFORMATION_MESSAGE);
                    grpEtd1.setText("");
                    grpEtd2.setText("");
                    grpEncdr.setText("");

                    bd.enseignants.get(x).addGrp(bd.groups.size());
                    bd.updateEnseignant(bd.enseignants.get(x));

                }catch (Exception r){
                    System.out.println(r.getMessage());
                    throw new Exceptions("Group existe deja");
                }
            }catch (Exceptions r){
                r.exec(this);
            }
        }
    }
}
