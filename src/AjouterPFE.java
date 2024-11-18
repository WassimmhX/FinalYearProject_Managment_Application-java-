import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AjouterPFE extends JPanel implements ActionListener {
    private BaseDonnee bd;
    private static JButton btnAjouterPfe;
    private static JTextField pfeNom,pfeNgrp;
    public AjouterPFE(BaseDonnee bd){
        this.bd=bd;
        this.setLayout(null);
        this.setBackground(new Color(36, 47, 65));

        JLabel lblNewLabel_2_2_1 = new JLabel("Ajouter PFE");
        lblNewLabel_2_2_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2_2_1.setForeground(Color.WHITE);
        lblNewLabel_2_2_1.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 22));
        lblNewLabel_2_2_1.setBackground(Color.WHITE);
        lblNewLabel_2_2_1.setBounds(440, 48, 218, 27);
        this.add(lblNewLabel_2_2_1);

        JSeparator separator_15_2_1 = new JSeparator();
        separator_15_2_1.setBounds(431, 86, 236, 6);
        this.add(separator_15_2_1);

        JSeparator separator_16_2_1 = new JSeparator();
        separator_16_2_1.setBounds(463, 98, 175, 11);
        this.add(separator_16_2_1);

        btnAjouterPfe = new JButton();
        btnAjouterPfe.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnAjouterPfe.setText("Ajouter");
        btnAjouterPfe.setForeground(Color.WHITE);
        btnAjouterPfe.setFont(new Font("Century Gothic", Font.BOLD, 14));
        btnAjouterPfe.setBackground(new Color(97, 212, 195));
        btnAjouterPfe.setBounds(471, 421, 166, 40);
        this.add(btnAjouterPfe);

        JSeparator separator_17_4_1 = new JSeparator();
        separator_17_4_1.setForeground(new Color(97, 212, 195));
        separator_17_4_1.setBackground(new Color(97, 212, 195));
        separator_17_4_1.setBounds(418, 218, 267, 11);
        this.add(separator_17_4_1);

        JLabel lblNom = new JLabel();
        lblNom.setHorizontalTextPosition(SwingConstants.CENTER);
        lblNom.setText("NOM :");
        lblNom.setForeground(new Color(97, 212, 195));
        lblNom.setFont(new Font("Century Gothic", Font.BOLD, 16));
        lblNom.setBounds(418, 189, 61, 20);
        this.add(lblNom);

        pfeNom = new JTextField();
        pfeNom.setForeground(Color.WHITE);
        pfeNom.setFont(new Font("Century Gothic", Font.BOLD, 13));
        pfeNom.setDisabledTextColor(Color.WHITE);
        pfeNom.setBorder(null);
        pfeNom.setBackground(new Color(36, 47, 65));
        pfeNom.setBounds(503, 189, 182, 23);
        pfeNom.addFocusListener(new FocusTextField(pfeNom));
        pfeNom.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    btnAjouterPfe.doClick();
            }
        });
        this.add(pfeNom);

        JLabel lblEtudiantcin_1_1 = new JLabel();
        lblEtudiantcin_1_1.setText("N° Group :");
        lblEtudiantcin_1_1.setForeground(new Color(97, 212, 195));
        lblEtudiantcin_1_1.setFont(new Font("Century Gothic", Font.BOLD, 16));
        lblEtudiantcin_1_1.setBounds(418, 265, 85, 27);
        this.add(lblEtudiantcin_1_1);

        pfeNgrp = new JTextField();
        pfeNgrp.setForeground(Color.WHITE);
        pfeNgrp.setFont(new Font("Century Gothic", Font.BOLD, 13));
        pfeNgrp.setDisabledTextColor(Color.WHITE);
        pfeNgrp.setBorder(null);
        pfeNgrp.setBackground(new Color(36, 47, 65));
        pfeNgrp.setBounds(503, 268, 183, 23);
        pfeNgrp.addFocusListener(new FocusTextField(pfeNgrp));
        pfeNgrp.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    btnAjouterPfe.doClick();
            }
        });
        this.add(pfeNgrp);

        JSeparator separator_17_2_3_1 = new JSeparator();
        separator_17_2_3_1.setForeground(new Color(97, 212, 195));
        separator_17_2_3_1.setBackground(new Color(97, 212, 195));
        separator_17_2_3_1.setBounds(418, 297, 268, 11);
        this.add(separator_17_2_3_1);

        JLabel lblNewLabel_7_1 = new JLabel("New label");
        lblNewLabel_7_1.setBounds(677, 189, 8, 6);
        this.add(lblNewLabel_7_1);
        this.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{pfeNom, pfeNgrp}));
        btnAjouterPfe.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnAjouterPfe){
            String ch1=pfeNom.getText().toUpperCase();
            String ch2=pfeNgrp.getText();
            try{
                if(ch1.isEmpty()||ch2.isEmpty())
                    throw new Exceptions("il y a un champ vide!");
                if(!ch2.matches("\\d+"))
                    throw new Exceptions("numero de group doit etre numerique");
                int n=Integer.parseInt(ch2);
                int index=bd.findGroup((Group g)->g.getNb()==n);
                if(index==-1)
                    throw new Exceptions("Le group n'existe pas");
                if(bd.findPfe((Pfe p)->p.getName().equalsIgnoreCase(ch1))!=-1){
                    throw new Exceptions("le nom de Pfe deja existe");
                }
                if(bd.findPfe((Pfe p)->p.getGrp()==Integer.parseInt(ch2))!=-1){
                    throw new Exceptions("cet group deja admet un PFE");
                }
                try{
                    Pfe p=new Pfe(ch1,Integer.parseInt(ch2),bd.groups.get(index).getEncadreur());
                    bd.insertInto("pfe",p);
                    bd.pfes.add(p);
                    JOptionPane.showMessageDialog(this,"l'Ajout est effectuée avec succès","Succès",JOptionPane.INFORMATION_MESSAGE);
                    pfeNgrp.setText("");
                    pfeNom.setText("");
                }catch (Exception r){
                    System.out.println(r.getMessage());
                    throw new Exceptions("le nom de Pfe deja existe");
                }
            }catch (Exceptions r){
                r.exec(this);
            }
        }
    }
}
