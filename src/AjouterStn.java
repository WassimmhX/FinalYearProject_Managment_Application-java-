import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Arrays;

public class AjouterStn extends JPanel implements ActionListener {
    private BaseDonnee bd;
    private static JButton btnAjouterStn,ajouterEnStn;
    private static JTextField stnDate,stnLoc,stnPr,stnRp,stnNGrp,stnEx;
    private static JComboBox stnEncdr,stnHeure;
    public AjouterStn(BaseDonnee bd){
        this.bd=bd;

        this.setBackground(new Color(36, 47, 65));

        JLabel lblNewLabel_2_3 = new JLabel("Ajouter Soutenance");
        lblNewLabel_2_3.setBounds(440, 48, 220, 27);
        lblNewLabel_2_3.setForeground(Color.WHITE);
        lblNewLabel_2_3.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 22));
        lblNewLabel_2_3.setBackground(Color.WHITE);

        JSeparator separator_15_3 = new JSeparator();
        separator_15_3.setBounds(431, 86, 238, 6);

        JSeparator separator_16_3 = new JSeparator();
        separator_16_3.setBounds(463, 98, 177, 11);

        btnAjouterStn = new JButton();
        btnAjouterStn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnAjouterStn.setBounds(472, 459, 168, 40);
        btnAjouterStn.setText("Ajouter");
        btnAjouterStn.setForeground(Color.WHITE);
        btnAjouterStn.setFont(new Font("Century Gothic", Font.BOLD, 14));
        btnAjouterStn.setBackground(new Color(97, 212, 195));

        JSeparator separator_17_5 = new JSeparator();
        separator_17_5.setBounds(164, 158, 306, 11);
        separator_17_5.setForeground(new Color(97, 212, 195));
        separator_17_5.setBackground(new Color(97, 212, 195));

        JLabel lblDate = new JLabel();
        lblDate.setHorizontalAlignment(SwingConstants.CENTER);
        lblDate.setBounds(180, 129, 82, 20);
        lblDate.setText("Date :");
        lblDate.setForeground(new Color(97, 212, 195));
        lblDate.setFont(new Font("Century Gothic", Font.BOLD, 16));

        stnDate = new JTextField();
        stnDate.setBounds(272, 129, 116, 23);
        stnDate.setForeground(Color.WHITE);
        stnDate.setFont(new Font("Century Gothic", Font.BOLD, 13));
        stnDate.setDisabledTextColor(Color.WHITE);
        stnDate.setBorder(null);
        stnDate.setBackground(new Color(36, 47, 65));
        stnDate.addFocusListener(new FocusTextField(stnDate));
        stnDate.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    btnAjouterStn.doClick();
            }
        });

        JLabel lblLocale = new JLabel();
        lblLocale.setBounds(164, 207, 98, 20);
        lblLocale.setText("Locale :");
        lblLocale.setHorizontalAlignment(SwingConstants.CENTER);
        lblLocale.setForeground(new Color(97, 212, 195));
        lblLocale.setFont(new Font("Century Gothic", Font.BOLD, 16));

        stnLoc = new JTextField();
        stnLoc.setBounds(272, 207, 198, 23);
        stnLoc.setForeground(Color.WHITE);
        stnLoc.setFont(new Font("Century Gothic", Font.BOLD, 13));
        stnLoc.setDisabledTextColor(Color.WHITE);
        stnLoc.setBorder(null);
        stnLoc.setBackground(new Color(36, 47, 65));
        stnLoc.addFocusListener(new FocusTextField(stnLoc));
        stnLoc.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    btnAjouterStn.doClick();
            }
        });

        JSeparator separator_17_1_3 = new JSeparator();
        separator_17_1_3.setBounds(164, 238, 306, 11);
        separator_17_1_3.setForeground(new Color(97, 212, 195));
        separator_17_1_3.setBackground(new Color(97, 212, 195));

        JLabel lblHeure = new JLabel();
        lblHeure.setBounds(646, 129, 98, 20);
        lblHeure.setText("Heure :");
        lblHeure.setHorizontalAlignment(SwingConstants.CENTER);
        lblHeure.setForeground(new Color(97, 212, 195));
        lblHeure.setFont(new Font("Century Gothic", Font.BOLD, 16));

        JSeparator separator_17_2_4 = new JSeparator();
        separator_17_2_4.setBounds(646, 158, 306, 11);
        separator_17_2_4.setForeground(new Color(97, 212, 195));
        separator_17_2_4.setBackground(new Color(97, 212, 195));

        JLabel lblEncadreurs = new JLabel();
        lblEncadreurs.setBounds(646, 377, 98, 20);
        lblEncadreurs.setText("Encadreurs :");
        lblEncadreurs.setHorizontalAlignment(SwingConstants.CENTER);
        lblEncadreurs.setForeground(new Color(97, 212, 195));
        lblEncadreurs.setFont(new Font("Century Gothic", Font.BOLD, 16));

        stnEncdr = new JComboBox();
        stnEncdr.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        stnEncdr.setBounds(762, 378, 144, 24);
        stnEncdr.setForeground(Color.WHITE);
        stnEncdr.setFont(new Font("Century Gothic", Font.BOLD, 13));
        stnEncdr.setModel(new DefaultComboBoxModel(new String[]{""}));
        stnEncdr.setBorder(null);
        stnEncdr.setBackground(new Color(36, 47, 65));
        stnEncdr.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    btnAjouterStn.doClick();
            }
        });

        JSeparator separator_17_2_1_2 = new JSeparator();
        separator_17_2_1_2.setBounds(646, 408, 306, 11);
        separator_17_2_1_2.setForeground(new Color(97, 212, 195));
        separator_17_2_1_2.setBackground(new Color(97, 212, 195));
        this.setLayout(null);
        this.add(lblNewLabel_2_3);
        this.add(separator_15_3);
        this.add(separator_16_3);
        this.add(btnAjouterStn);
        this.add(separator_17_5);
        this.add(lblDate);
        this.add(stnDate);
        this.add(lblLocale);
        this.add(stnLoc);
        this.add(separator_17_1_3);
        this.add(lblHeure);
        this.add(separator_17_2_4);
        this.add(lblEncadreurs);
        this.add(stnEncdr);
        this.add(separator_17_2_1_2);

        JLabel lblNewLabel_9 = new JLabel("(jj/mm/aaaa)");
        lblNewLabel_9.setForeground(new Color(255, 60, 60));
        lblNewLabel_9.setFont(new Font("Century Gothic", Font.BOLD, 10));
        lblNewLabel_9.setBounds(398, 135, 72, 14);
        this.add(lblNewLabel_9);

        stnHeure = new JComboBox();
        stnHeure.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        stnHeure.setModel(new DefaultComboBoxModel(new String[] {"", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17"}));
        stnHeure.setMaximumRowCount(5);
        stnHeure.setForeground(Color.WHITE);
        stnHeure.setFont(new Font("Century Gothic", Font.BOLD, 13));
        stnHeure.setBorder(null);
        stnHeure.setBackground(new Color(36, 47, 65));
        stnHeure.setBounds(762, 129, 144, 24);
        stnHeure.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    btnAjouterStn.doClick();
            }
        });
        this.add(stnHeure);

        JLabel lblPresident = new JLabel();
        lblPresident.setText("President :");
        lblPresident.setHorizontalAlignment(SwingConstants.CENTER);
        lblPresident.setForeground(new Color(97, 212, 195));
        lblPresident.setFont(new Font("Century Gothic", Font.BOLD, 16));
        lblPresident.setBounds(646, 207, 98, 20);
        this.add(lblPresident);

        stnPr = new JTextField();
        stnPr.setForeground(Color.WHITE);
        stnPr.setFont(new Font("Century Gothic", Font.BOLD, 13));
        stnPr.setDisabledTextColor(Color.WHITE);
        stnPr.setBorder(null);
        stnPr.setBackground(new Color(36, 47, 65));
        stnPr.setBounds(754, 207, 144, 23);
        stnPr.addFocusListener(new FocusTextField(stnPr));
        stnPr.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    btnAjouterStn.doClick();
            }
        });
        this.add(stnPr);

        JSeparator separator_17_1_3_1 = new JSeparator();
        separator_17_1_3_1.setForeground(new Color(97, 212, 195));
        separator_17_1_3_1.setBackground(new Color(97, 212, 195));
        separator_17_1_3_1.setBounds(646, 238, 306, 11);
        this.add(separator_17_1_3_1);

        JLabel lblRapporteur = new JLabel();
        lblRapporteur.setText("Rapporteur :");
        lblRapporteur.setHorizontalAlignment(SwingConstants.CENTER);
        lblRapporteur.setForeground(new Color(97, 212, 195));
        lblRapporteur.setFont(new Font("Century Gothic", Font.BOLD, 16));
        lblRapporteur.setBounds(164, 300, 98, 20);
        this.add(lblRapporteur);

        stnRp = new JTextField();
        stnRp.setForeground(Color.WHITE);
        stnRp.setFont(new Font("Century Gothic", Font.BOLD, 13));
        stnRp.setDisabledTextColor(Color.WHITE);
        stnRp.setBorder(null);
        stnRp.setBackground(new Color(36, 47, 65));
        stnRp.setBounds(272, 300, 144, 23);
        stnRp.addFocusListener(new FocusTextField(stnRp));
        stnRp.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    btnAjouterStn.doClick();
            }
        });
        this.add(stnRp);

        JSeparator separator_17_1_3_2 = new JSeparator();
        separator_17_1_3_2.setForeground(new Color(97, 212, 195));
        separator_17_1_3_2.setBackground(new Color(97, 212, 195));
        separator_17_1_3_2.setBounds(164, 331, 306, 11);
        this.add(separator_17_1_3_2);

        JLabel lblNewLabel_9_1 = new JLabel("(CIN)");
        lblNewLabel_9_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_9_1.setForeground(new Color(255, 60, 60));
        lblNewLabel_9_1.setFont(new Font("Century Gothic", Font.BOLD, 10));
        lblNewLabel_9_1.setBounds(426, 306, 44, 14);
        this.add(lblNewLabel_9_1);

        JLabel lblNewLabel_9_1_1 = new JLabel("(CIN)");
        lblNewLabel_9_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_9_1_1.setForeground(new Color(255, 60, 60));
        lblNewLabel_9_1_1.setFont(new Font("Century Gothic", Font.BOLD, 10));
        lblNewLabel_9_1_1.setBounds(909, 213, 43, 14);
        this.add(lblNewLabel_9_1_1);

        ajouterEnStn = new JButton("");
        ajouterEnStn.setBorder(null);
        ajouterEnStn.setIcon(new ImageIcon(Menu.class.getResource("/image/ajouter2.png")));
        ajouterEnStn.setBounds(916, 379, 36, 23);
        ajouterEnStn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        this.add(ajouterEnStn);

        JLabel lblNGroup = new JLabel();
        lblNGroup.setText("N° Group:");
        lblNGroup.setHorizontalAlignment(SwingConstants.CENTER);
        lblNGroup.setForeground(new Color(97, 212, 195));
        lblNGroup.setFont(new Font("Century Gothic", Font.BOLD, 16));
        lblNGroup.setBounds(164, 377, 98, 20);
        this.add(lblNGroup);

        stnNGrp = new JTextField();
        stnNGrp.setForeground(Color.WHITE);
        stnNGrp.setFont(new Font("Century Gothic", Font.BOLD, 13));
        stnNGrp.setDisabledTextColor(Color.WHITE);
        stnNGrp.setBorder(null);
        stnNGrp.setBackground(new Color(36, 47, 65));
        stnNGrp.setBounds(272, 377, 198, 23);
        stnNGrp.addFocusListener(new FocusTextField(stnNGrp));
        stnNGrp.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    btnAjouterStn.doClick();
            }
        });
        this.add(stnNGrp);

        JSeparator separator_17_1_3_3 = new JSeparator();
        separator_17_1_3_3.setForeground(new Color(97, 212, 195));
        separator_17_1_3_3.setBackground(new Color(97, 212, 195));
        separator_17_1_3_3.setBounds(164, 408, 306, 11);
        this.add(separator_17_1_3_3);

        JLabel lblExaminateur = new JLabel();
        lblExaminateur.setText("Examinateur :");
        lblExaminateur.setHorizontalAlignment(SwingConstants.CENTER);
        lblExaminateur.setForeground(new Color(97, 212, 195));
        lblExaminateur.setFont(new Font("Century Gothic", Font.BOLD, 16));
        lblExaminateur.setBounds(646, 300, 116, 20);
        this.add(lblExaminateur);

        stnEx = new JTextField();
        stnEx.setForeground(Color.WHITE);
        stnEx.setFont(new Font("Century Gothic", Font.BOLD, 13));
        stnEx.setDisabledTextColor(Color.WHITE);
        stnEx.setBorder(null);
        stnEx.setBackground(new Color(36, 47, 65));
        stnEx.setBounds(762, 300, 136, 23);
        stnEx.addFocusListener(new FocusTextField(stnEx));
        stnEx.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    btnAjouterStn.doClick();
            }
        });
        this.add(stnEx);

        JSeparator separator_17_1_3_1_1 = new JSeparator();
        separator_17_1_3_1_1.setForeground(new Color(97, 212, 195));
        separator_17_1_3_1_1.setBackground(new Color(97, 212, 195));
        separator_17_1_3_1_1.setBounds(646, 331, 306, 11);
        this.add(separator_17_1_3_1_1);

        JLabel lblNewLabel_9_1_1_1 = new JLabel("(CIN)");
        lblNewLabel_9_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_9_1_1_1.setForeground(new Color(255, 60, 60));
        lblNewLabel_9_1_1_1.setFont(new Font("Century Gothic", Font.BOLD, 10));
        lblNewLabel_9_1_1_1.setBounds(909, 306, 43, 14);
        this.add(lblNewLabel_9_1_1_1);
        this.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{stnDate, stnHeure, stnLoc, stnPr, stnRp, stnEncdr, lblNGroup, stnNGrp, separator_17_1_3_3, lblExaminateur, stnEx, separator_17_1_3_1_1, lblNewLabel_9_1_1_1}));
        btnAjouterStn.addActionListener(this);
        ajouterEnStn.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==ajouterEnStn){
            String ch=JOptionPane.showInputDialog(this,"ajouter Encadreur:(cin)","ajouter Encadreur",JOptionPane.INFORMATION_MESSAGE);
            int v= stnEncdr.getItemCount();
            String[] it=new String[v+1];
            for(int i=0; i<v;i++)
                it[i]=stnEncdr.getItemAt(i).toString();
            it[v]="";
            if(!ch.isEmpty()) {
                try {
                    if (ch.length() != 8 || !ch.matches("\\d+"))
                        throw new Exceptions("CIN doit etre 8 chiffres");
                    if(bd.enseignants.stream().filter((Enseignant ens)->ens.getCIN().equals(ch)).findAny().orElse(null)==null)
                        throw new Exceptions("Cette enseignant n'existe pas");
                    if (Arrays.stream(it).filter((String s) -> s.equals(ch)).findAny().orElse(null) == null) {
                        it[v] = ch;
                        stnEncdr.setModel(new DefaultComboBoxModel(it));
                    }
                } catch (Exceptions r) {
                    r.exec(this);
                }
            }
        }

        else if(e.getSource()==btnAjouterStn){
            String date=stnDate.getText();
            String heure=stnHeure.getSelectedItem().toString();
            String locale=stnLoc.getText();
            String pr=stnPr.getText();
            String rp=stnRp.getText();
            String ex=stnEx.getText();
            String grp=stnNGrp.getText();
            String[] encdr=new String[stnEncdr.getItemCount()-1];
            for(int i=0;i<stnEncdr.getItemCount()-1;i++)
                encdr[i]=(String) stnEncdr.getItemAt(i+1);
            try{
                if(date.isEmpty()|| heure.isEmpty()||pr.isEmpty()|| locale.isEmpty()||rp.isEmpty()|| grp.isEmpty()){
                    throw new Exceptions("il y a un champ vide");
                }
                if(pr.length()!=8||!pr.matches("\\d+")||rp.length()!=8||!rp.matches("\\d+")||ex.length()!=8||!ex.matches("\\d+"))
                    throw new Exceptions("CIN doit etre 8 chiffres");
                if(!grp.matches("\\d+"))
                    throw new Exceptions("Numero de group doit etre numerique");
                if(bd.findEnseignant((Enseignant p)->p.getCIN().equals(pr))==-1)
                    throw new Exceptions("President n'est pas un enseignant existant");
                int nGrp=Integer.parseInt(grp);
                if(bd.findEnseignant((Enseignant p)->p.getCIN().equals(rp))==-1)
                    throw new Exceptions("Rapporteur n'est pas un enseignant existant");
                if(bd.findEnseignant((Enseignant p)->p.getCIN().equals(ex))==-1)
                    throw new Exceptions("Examinateur n'est pas un enseignant existant");
                if(bd.findGroup((Group g)->g.getNb()==nGrp)==-1)
                    throw new Exceptions("Group n'existe pas");
                if(bd.findPfe((Pfe p)->p.getGrp()==nGrp)==-1)
                    throw new Exceptions("Cet group n'admet pas un PFE");
                if(bd.findSoutenance((Soutenance p)->p.getGrp()==nGrp)!=-1)
                    throw new Exceptions("Cet groupe a deja une soutenance");
                Date d;
                try {
                    SimpleDateFormat f=new SimpleDateFormat("dd/MM/yyyy");
                    d=new Date((f.parse(date)).getTime());
                }catch (Exception r){
                    throw new Exceptions("date incorrecte");
                }
                if(!checkDate(date))
                    throw new Exceptions("date incorrecte");
                try{
                    Soutenance s=new Soutenance(d,Integer.parseInt(heure),locale,pr,rp,ex,encdr,nGrp,bd.pfes.get(bd.findPfe((Pfe p)->p.getGrp()==nGrp)).getName(),"en attend",-1);
                    bd.insertInto("Soutenance",s);
                    bd.soutenances.add(s);
                    JOptionPane.showMessageDialog(this,"l'Ajout est effectuée avec succès","Succès",JOptionPane.INFORMATION_MESSAGE);
                    stnDate.setText("");
                    stnEx.setText("");
                    stnRp.setText("");
                    stnPr.setText("");
                    stnLoc.setText("");
                    stnNGrp.setText("");
                    stnHeure.setSelectedIndex(0);
                    stnEncdr.setModel(new DefaultComboBoxModel(new String[]{""}));
                }catch (Exception r){
                    System.out.println(r.getMessage());
                    throw new Exceptions("Soutenance existe deja dans cette date");
                }
            }catch (Exceptions r){
                r.exec(this);
            }
        }
    }
    public boolean checkDate(String ch){
        String[]s= ch.split("/");
        int[]d={31,29,31,30,31,30,31,31,30,31,30,31};
        if(s.length!=3)
            return false;
        else{
            int j=Integer.parseInt(s[0]);
            int m=Integer.parseInt(s[1]);
            if(m>12)
                return false;
            if(j>d[m-1])
                return false;
            return true;
        }
    }
}
