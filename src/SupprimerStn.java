import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class SupprimerStn extends JPanel implements ActionListener {
    private BaseDonnee bd;
    private static JButton btnSupprimerStn;
    private static JTextField spStnDate,spStnLocale;
    private static JComboBox spStnHeure;
    public SupprimerStn(BaseDonnee bd){
        this.bd=bd;
        this.setLayout(null);
        this.setBackground(new Color(36, 47, 65));

        JLabel lblNewLabel_3_3 = new JLabel("Suppression de Soutenance");
        lblNewLabel_3_3.setForeground(Color.WHITE);
        lblNewLabel_3_3.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 22));
        lblNewLabel_3_3.setBounds(421, 51, 308, 25);
        this.add(lblNewLabel_3_3);

        JSeparator separator_19_3 = new JSeparator();
        separator_19_3.setForeground(Color.WHITE);
        separator_19_3.setBounds(414, 87, 327, 7);
        this.add(separator_19_3);

        JSeparator separator_20_3 = new JSeparator();
        separator_20_3.setForeground(Color.WHITE);
        separator_20_3.setBounds(452, 105, 265, 18);
        this.add(separator_20_3);

        btnSupprimerStn = new JButton();
        btnSupprimerStn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnSupprimerStn.setText("Supprimer");
        btnSupprimerStn.setForeground(Color.WHITE);
        btnSupprimerStn.setFont(new Font("Century Gothic", Font.BOLD, 14));
        btnSupprimerStn.setBackground(new Color(97, 212, 195));
        btnSupprimerStn.setBounds(510, 401, 166, 42);
        this.add(btnSupprimerStn);

        JSeparator separator_17_5_1 = new JSeparator();
        separator_17_5_1.setForeground(new Color(97, 212, 195));
        separator_17_5_1.setBackground(new Color(97, 212, 195));
        separator_17_5_1.setBounds(190, 209, 306, 11);
        this.add(separator_17_5_1);

        JLabel lblDate_1 = new JLabel();
        lblDate_1.setText("Date :");
        lblDate_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblDate_1.setForeground(new Color(97, 212, 195));
        lblDate_1.setFont(new Font("Century Gothic", Font.BOLD, 16));
        lblDate_1.setBounds(206, 180, 82, 20);
        this.add(lblDate_1);

        spStnDate = new JTextField();
        spStnDate.setForeground(Color.WHITE);
        spStnDate.setFont(new Font("Century Gothic", Font.BOLD, 13));
        spStnDate.setDisabledTextColor(Color.WHITE);
        spStnDate.setBorder(null);
        spStnDate.setBackground(new Color(36, 47, 65));
        spStnDate.setBounds(298, 180, 116, 23);
        spStnDate.addFocusListener(new FocusTextField(spStnDate));
        spStnDate.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    btnSupprimerStn.doClick();
            }
        });
        this.add(spStnDate);

        JLabel lblHeure_1 = new JLabel();
        lblHeure_1.setText("Heure :");
        lblHeure_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblHeure_1.setForeground(new Color(97, 212, 195));
        lblHeure_1.setFont(new Font("Century Gothic", Font.BOLD, 16));
        lblHeure_1.setBounds(672, 180, 98, 20);
        this.add(lblHeure_1);

        JSeparator separator_17_2_4_1 = new JSeparator();
        separator_17_2_4_1.setForeground(new Color(97, 212, 195));
        separator_17_2_4_1.setBackground(new Color(97, 212, 195));
        separator_17_2_4_1.setBounds(672, 209, 306, 11);
        this.add(separator_17_2_4_1);

        JLabel lblNewLabel_9_2 = new JLabel("(jj/mm/aaaa)");
        lblNewLabel_9_2.setForeground(new Color(255, 60, 60));
        lblNewLabel_9_2.setFont(new Font("Century Gothic", Font.BOLD, 10));
        lblNewLabel_9_2.setBounds(424, 186, 72, 14);
        this.add(lblNewLabel_9_2);

        spStnHeure = new JComboBox();
        spStnHeure.setModel(new DefaultComboBoxModel(new String[] {"", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17"}));
        spStnHeure.setMaximumRowCount(5);
        spStnHeure.setForeground(Color.WHITE);
        spStnHeure.setFont(new Font("Century Gothic", Font.BOLD, 13));
        spStnHeure.setBorder(null);
        spStnHeure.setBackground(new Color(36, 47, 65));
        spStnHeure.setBounds(788, 180, 144, 24);
        spStnHeure.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    btnSupprimerStn.doClick();
            }
        });
        this.add(spStnHeure);

        JLabel lblLocale_1 = new JLabel();
        lblLocale_1.setText("Locale :");
        lblLocale_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblLocale_1.setForeground(new Color(97, 212, 195));
        lblLocale_1.setFont(new Font("Century Gothic", Font.BOLD, 16));
        lblLocale_1.setBounds(437, 276, 98, 20);
        this.add(lblLocale_1);

        spStnLocale = new JTextField();
        spStnLocale.setForeground(Color.WHITE);
        spStnLocale.setFont(new Font("Century Gothic", Font.BOLD, 13));
        spStnLocale.setDisabledTextColor(Color.WHITE);
        spStnLocale.setBorder(null);
        spStnLocale.setBackground(new Color(36, 47, 65));
        spStnLocale.setBounds(545, 276, 198, 23);
        spStnLocale.addFocusListener(new FocusTextField(spStnLocale));
        spStnLocale.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    btnSupprimerStn.doClick();
            }
        });
        this.add(spStnLocale);

        JSeparator separator_17_1_3_4 = new JSeparator();
        separator_17_1_3_4.setForeground(new Color(97, 212, 195));
        separator_17_1_3_4.setBackground(new Color(97, 212, 195));
        separator_17_1_3_4.setBounds(437, 307, 306, 11);
        this.add(separator_17_1_3_4);
        this.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{spStnDate, spStnHeure, spStnLocale}));
        btnSupprimerStn.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnSupprimerStn){
            String date=spStnDate.getText();
            String heure=spStnHeure.getSelectedItem().toString();
            String loc=spStnLocale.getText();
            try {
                if (date.isEmpty() || heure.isEmpty() || loc.isEmpty())
                    throw new Exceptions("il y a un champ vide");
                Date d;
                try {
                    SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
                    d = new Date((f.parse(date)).getTime());
                } catch (Exception r) {
                    throw new Exceptions("date incorrecte");
                }
                if (!checkDate(date))
                    throw new Exceptions("date incorrecte");
                try {
                    bd.updateSoutenance("delete from soutenance where date_=? and heure=" + Integer.parseInt(heure) + " and locale='" + loc + "'",d);
                    bd.soutenances.remove(bd.findSoutenance((Soutenance s)->s.getDate().equals(d)&&s.getHeure()==Integer.parseInt(heure)&&s.getLocale().equalsIgnoreCase(loc)));
                    JOptionPane.showMessageDialog(this,"Suppresion effectuée avec succès","Succès",JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception r) {
                    System.out.println(r.getMessage());
                    throw new Exceptions("Soutenance n'existe pas");
                }
            }catch (Exceptions r) {
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
