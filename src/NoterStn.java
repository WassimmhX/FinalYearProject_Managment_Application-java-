import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class NoterStn extends JPanel implements ActionListener {
    private BaseDonnee bd;
    private static JButton btnStnNote;
    private static JComboBox vldStnHeure;
    private static JTextField vldStnDate,vldStnLocal,vldStnNote;
    private static JRadioButton rdbStnVld,rdbStnNVld;
    public NoterStn(BaseDonnee bd){
        this.bd=bd;
        this.setLayout(null);
        this.setBackground(new Color(36, 47, 65));

        JLabel lblNewLabel_3_4 = new JLabel("Noter Soutenance");
        lblNewLabel_3_4.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_3_4.setForeground(Color.WHITE);
        lblNewLabel_3_4.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 22));
        lblNewLabel_3_4.setBounds(427, 51, 269, 25);
        this.add(lblNewLabel_3_4);

        JSeparator separator_19_4 = new JSeparator();
        separator_19_4.setForeground(Color.WHITE);
        separator_19_4.setBounds(421, 87, 287, 7);
        this.add(separator_19_4);

        JSeparator separator_20_4 = new JSeparator();
        separator_20_4.setForeground(Color.WHITE);
        separator_20_4.setBounds(431, 105, 265, 18);
        this.add(separator_20_4);

        btnStnNote = new JButton();
        btnStnNote.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnStnNote.setText("Enregistrer");
        btnStnNote.setForeground(Color.WHITE);
        btnStnNote.setFont(new Font("Century Gothic", Font.BOLD, 14));
        btnStnNote.setBackground(new Color(97, 212, 195));
        btnStnNote.setBounds(483, 401, 166, 42);
        this.add(btnStnNote);

        JLabel lblDate_2 = new JLabel();
        lblDate_2.setText("Date :");
        lblDate_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblDate_2.setForeground(new Color(97, 212, 195));
        lblDate_2.setFont(new Font("Century Gothic", Font.BOLD, 16));
        lblDate_2.setBounds(223, 144, 82, 20);
        this.add(lblDate_2);

        vldStnDate = new JTextField();
        vldStnDate.setForeground(Color.WHITE);
        vldStnDate.setFont(new Font("Century Gothic", Font.BOLD, 13));
        vldStnDate.setDisabledTextColor(Color.WHITE);
        vldStnDate.setBorder(null);
        vldStnDate.setBackground(new Color(36, 47, 65));
        vldStnDate.setBounds(315, 144, 116, 23);
        vldStnDate.addFocusListener(new FocusTextField(vldStnDate));
        vldStnDate.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    btnStnNote.doClick();
            }
        });
        this.add(vldStnDate);

        JSeparator separator_17_5_2 = new JSeparator();
        separator_17_5_2.setForeground(new Color(97, 212, 195));
        separator_17_5_2.setBackground(new Color(97, 212, 195));
        separator_17_5_2.setBounds(207, 173, 306, 11);
        this.add(separator_17_5_2);

        JLabel lblNewLabel_9_3 = new JLabel("(jj/mm/aaaa)");
        lblNewLabel_9_3.setForeground(new Color(255, 60, 60));
        lblNewLabel_9_3.setFont(new Font("Century Gothic", Font.BOLD, 10));
        lblNewLabel_9_3.setBounds(441, 150, 72, 14);
        this.add(lblNewLabel_9_3);

        JLabel lblHeure_2 = new JLabel();
        lblHeure_2.setText("Heure :");
        lblHeure_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblHeure_2.setForeground(new Color(97, 212, 195));
        lblHeure_2.setFont(new Font("Century Gothic", Font.BOLD, 16));
        lblHeure_2.setBounds(640, 144, 98, 20);
        this.add(lblHeure_2);

        JSeparator separator_17_2_4_2 = new JSeparator();
        separator_17_2_4_2.setForeground(new Color(97, 212, 195));
        separator_17_2_4_2.setBackground(new Color(97, 212, 195));
        separator_17_2_4_2.setBounds(640, 173, 306, 11);
        this.add(separator_17_2_4_2);

        vldStnHeure = new JComboBox();
        vldStnHeure.setMaximumRowCount(5);
        vldStnHeure.setForeground(Color.WHITE);
        vldStnHeure.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        vldStnHeure.setFont(new Font("Century Gothic", Font.BOLD, 13));
        vldStnHeure.setBorder(null);
        vldStnHeure.setModel(new DefaultComboBoxModel(new String[] {"", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17"}));
        vldStnHeure.setBackground(new Color(36, 47, 65));
        vldStnHeure.setBounds(756, 144, 144, 24);
        vldStnHeure.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    btnStnNote.doClick();
            }
        });
        this.add(vldStnHeure);

        JLabel lblLocale_2 = new JLabel();
        lblLocale_2.setText("Locale :");
        lblLocale_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblLocale_2.setForeground(new Color(97, 212, 195));
        lblLocale_2.setFont(new Font("Century Gothic", Font.BOLD, 16));
        lblLocale_2.setBounds(418, 204, 98, 20);
        this.add(lblLocale_2);

        vldStnLocal = new JTextField();
        vldStnLocal.setForeground(Color.WHITE);
        vldStnLocal.setFont(new Font("Century Gothic", Font.BOLD, 13));
        vldStnLocal.setDisabledTextColor(Color.WHITE);
        vldStnLocal.setBorder(null);
        vldStnLocal.setBackground(new Color(36, 47, 65));
        vldStnLocal.setBounds(526, 204, 198, 23);
        vldStnLocal.addFocusListener(new FocusTextField(vldStnLocal));
        vldStnLocal.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    btnStnNote.doClick();
            }
        });
        this.add(vldStnLocal);

        JSeparator separator_17_1_3_5 = new JSeparator();
        separator_17_1_3_5.setForeground(new Color(97, 212, 195));
        separator_17_1_3_5.setBackground(new Color(97, 212, 195));
        separator_17_1_3_5.setBounds(418, 235, 306, 11);
        this.add(separator_17_1_3_5);

        JLabel notelabel = new JLabel();
        notelabel.setText("Note :");
        notelabel.setHorizontalAlignment(SwingConstants.CENTER);
        notelabel.setForeground(new Color(97, 212, 195));
        notelabel.setFont(new Font("Century Gothic", Font.BOLD, 16));
        notelabel.setBounds(418, 332, 98, 20);
        this.add(notelabel);

        vldStnNote = new JTextField();
        vldStnNote.setForeground(Color.WHITE);
        vldStnNote.setFont(new Font("Century Gothic", Font.BOLD, 13));
        vldStnNote.setDisabledTextColor(Color.WHITE);
        vldStnNote.setBorder(null);
        vldStnNote.setBackground(new Color(36, 47, 65));
        vldStnNote.setBounds(526, 332, 198, 23);
        vldStnNote.addFocusListener(new FocusTextField(vldStnNote));
        vldStnNote.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    btnStnNote.doClick();
            }
        });
        this.add(vldStnNote);

        JSeparator separator_17_1_3_6 = new JSeparator();
        separator_17_1_3_6.setForeground(new Color(97, 212, 195));
        separator_17_1_3_6.setBackground(new Color(97, 212, 195));
        separator_17_1_3_6.setBounds(418, 363, 306, 11);
        this.add(separator_17_1_3_6);

        rdbStnVld = new JRadioButton("validée");
        rdbStnVld.setBackground(new Color(36, 48, 65));
        rdbStnVld.setForeground(new Color(0, 176, 0));
        rdbStnVld.setFont(new Font("Century Gothic", Font.BOLD, 12));
        rdbStnVld.setBounds(452, 283, 98, 23);
        this.add(rdbStnVld);

        rdbStnNVld = new JRadioButton("non validée");
        rdbStnNVld.setForeground(new Color(255, 55, 55));
        rdbStnNVld.setFont(new Font("Century Gothic", Font.BOLD, 12));
        rdbStnNVld.setBackground(new Color(36, 48, 65));
        rdbStnNVld.setBounds(595, 283, 109, 23);
        ButtonGroup group=new ButtonGroup();
        group.add(rdbStnVld);
        group.add(rdbStnNVld);
        this.add(rdbStnNVld);
        this.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{vldStnDate, vldStnHeure, vldStnLocal, vldStnNote}));
        btnStnNote.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnStnNote){
            String date=vldStnDate.getText();
            String heure=vldStnHeure.getSelectedItem().toString();
            String local=vldStnLocal.getText();
            String note=vldStnNote.getText();
            try {
                if(date.isEmpty()||heure.isEmpty()||local.isEmpty()||note.isEmpty())
                    throw new Exceptions("il ya un champ vide");
                Date d;
                try {
                    SimpleDateFormat f=new SimpleDateFormat("dd/MM/yyyy");
                    d=new Date((f.parse(date)).getTime());
                }catch (Exception r){
                    throw new Exceptions("date incorrecte");
                }
                if(!checkDate(date))
                    throw new Exceptions("date incorrecte");
                if(!rdbStnNVld.isSelected()&&!rdbStnVld.isSelected())
                    throw new Exceptions("choisir la validiter");
                Double n;
                try{
                    n=Double.parseDouble(note);
                }catch (Exception r){
                    throw new Exceptions("note doit etre un reel entre 0 et 20");
                }
                if(n<0||n>20)
                    throw new Exceptions("note doit etre un reel entre 0 et 20");
                String v;
                if(rdbStnVld.isSelected())
                    v=rdbStnVld.getText();
                else
                    v=rdbStnNVld.getText();
                try{

                    bd.updateSoutenance("update soutenance set passee='"+v+"' , note="+n+" where date_=? and heure=" + Integer.parseInt(heure) + " and locale='" + local + "'",d);
                    bd.soutenances.get(bd.findSoutenance((Soutenance s)->s.getDate().equals(d)&&s.getHeure()==Integer.parseInt(heure)&&s.getLocale().equalsIgnoreCase(local))).setPassee(v);
                    bd.soutenances.get(bd.findSoutenance((Soutenance s)->s.getDate().equals(d)&&s.getHeure()==Integer.parseInt(heure)&&s.getLocale().equalsIgnoreCase(local))).setNote(n);
                    JOptionPane.showMessageDialog(this,"Enregistrer avec succès","Succès",JOptionPane.INFORMATION_MESSAGE);
                }catch (Exception r){
                    System.out.println(r.getMessage());
                    throw new Exceptions("Soutenance n'existe pas");
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
