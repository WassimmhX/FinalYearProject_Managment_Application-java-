import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AjouterEtd extends JPanel implements ActionListener {
    private BaseDonnee bd;
    private static JButton btnAjouterEtd;
    private static JComboBox FormationEtd;
    private static JTextField etdName,CINEtd,AgeEtd;
    public AjouterEtd(BaseDonnee bd){
        this.setBackground(new Color(36, 47, 65));
        this.bd=bd;
        JLabel lblNewLabel_2 = new JLabel("Ajouter Etudiant");
        lblNewLabel_2.setForeground(new Color(255, 255, 255));
        lblNewLabel_2.setBackground(new Color(255, 255, 255));
        lblNewLabel_2.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 22));

        JSeparator separator_15 = new JSeparator();

        JSeparator separator_16 = new JSeparator();

        JSeparator separator_17 = new JSeparator();
        separator_17.setForeground(new Color(97, 212, 195));
        separator_17.setBackground(new Color(97, 212, 195));

        etdName = new JTextField();
        etdName.setForeground(Color.WHITE);
        etdName.setFont(new Font("Century Gothic", Font.BOLD, 13));
        etdName.setDisabledTextColor(Color.WHITE);
        etdName.setBorder(null);
        etdName.setBackground(new Color(36, 47, 65));
        etdName.addFocusListener(new FocusTextField(etdName));
        etdName.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    btnAjouterEtd.doClick();
                }
            }
        });

        JLabel jLabel6 = new JLabel();
        jLabel6.setText("Full Name :");
        jLabel6.setForeground(new Color(97, 212, 195));
        jLabel6.setFont(new Font("Century Gothic", Font.BOLD, 16));

        JLabel lblCin = new JLabel();
        lblCin.setHorizontalAlignment(SwingConstants.CENTER);
        lblCin.setText("CIN :");
        lblCin.setForeground(new Color(97, 212, 195));
        lblCin.setFont(new Font("Century Gothic", Font.BOLD, 16));

        JSeparator separator_17_1 = new JSeparator();
        separator_17_1.setForeground(new Color(97, 212, 195));
        separator_17_1.setBackground(new Color(97, 212, 195));

        CINEtd = new JTextField();
        CINEtd.setForeground(Color.WHITE);
        CINEtd.setFont(new Font("Century Gothic", Font.BOLD, 13));
        CINEtd.setDisabledTextColor(Color.WHITE);
        CINEtd.setBorder(null);
        CINEtd.setBackground(new Color(36, 47, 65));
        CINEtd.addFocusListener(new FocusTextField(CINEtd));
        CINEtd.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    btnAjouterEtd.doClick();
                }
            }
        });

        JLabel lblAge = new JLabel();
        lblAge.setHorizontalAlignment(SwingConstants.CENTER);
        lblAge.setText("Age :");
        lblAge.setForeground(new Color(97, 212, 195));
        lblAge.setFont(new Font("Century Gothic", Font.BOLD, 16));

        JSeparator separator_17_2 = new JSeparator();
        separator_17_2.setForeground(new Color(97, 212, 195));
        separator_17_2.setBackground(new Color(97, 212, 195));

        AgeEtd = new JTextField();
        AgeEtd.setForeground(Color.WHITE);
        AgeEtd.setFont(new Font("Century Gothic", Font.BOLD, 13));
        AgeEtd.setDisabledTextColor(Color.WHITE);
        AgeEtd.setBorder(null);
        AgeEtd.setBackground(new Color(36, 47, 65));
        AgeEtd.addFocusListener(new FocusTextField(AgeEtd));
        AgeEtd.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    btnAjouterEtd.doClick();
                }
            }
        });

        JLabel lblFormation = new JLabel();
        lblFormation.setText("Formation :");
        lblFormation.setHorizontalAlignment(SwingConstants.CENTER);
        lblFormation.setForeground(new Color(97, 212, 195));
        lblFormation.setFont(new Font("Century Gothic", Font.BOLD, 16));

        JSeparator separator_17_2_1 = new JSeparator();
        separator_17_2_1.setForeground(new Color(97, 212, 195));
        separator_17_2_1.setBackground(new Color(97, 212, 195));

        FormationEtd = new JComboBox();
        FormationEtd.setModel(new DefaultComboBoxModel(new String[] {"", "Master", "Engineer", "Licence"}));
        FormationEtd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        FormationEtd.setBackground(new Color(36, 47, 65));
        FormationEtd.setFont(new Font("Century Gothic", Font.BOLD, 13));
        FormationEtd.setForeground(new Color(255, 255, 255));
        FormationEtd.setBorder(null);
        FormationEtd.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    btnAjouterEtd.doClick();
                }
            }
        });
        btnAjouterEtd = new JButton();
        btnAjouterEtd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnAjouterEtd.setText("Ajouter");
        btnAjouterEtd.setForeground(Color.WHITE);
        btnAjouterEtd.setFont(new Font("Century Gothic", Font.BOLD, 14));
        btnAjouterEtd.setBackground(new Color(97, 212, 195));
        GroupLayout gl_ajouterEtd = new GroupLayout(this);
        gl_ajouterEtd.setHorizontalGroup(
                gl_ajouterEtd.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_ajouterEtd.createSequentialGroup()
                                .addGroup(gl_ajouterEtd.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(gl_ajouterEtd.createSequentialGroup()
                                                .addGap(440)
                                                .addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(9))
                                        .addGroup(gl_ajouterEtd.createSequentialGroup()
                                                .addGap(431)
                                                .addComponent(separator_15, GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE))
                                        .addGroup(gl_ajouterEtd.createSequentialGroup()
                                                .addGap(463)
                                                .addComponent(separator_16, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                                                .addGap(29)))
                                .addGap(1672))
                        .addGroup(gl_ajouterEtd.createSequentialGroup()
                                .addGap(159)
                                .addGroup(gl_ajouterEtd.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(gl_ajouterEtd.createSequentialGroup()
                                                .addGroup(gl_ajouterEtd.createSequentialGroup()
                                                        .addGroup(gl_ajouterEtd.createSequentialGroup()
                                                                .addGap(312)
                                                                .addComponent(btnAjouterEtd, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                                        .addGap(29))
                                                .addGap(279))
                                        .addGroup(gl_ajouterEtd.createSequentialGroup()
                                                .addGroup(gl_ajouterEtd.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(separator_17, GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
                                                        .addGroup(gl_ajouterEtd.createSequentialGroup()
                                                                .addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 90, Short.MAX_VALUE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(etdName, 192, 192, 192))
                                                        .addGroup(gl_ajouterEtd.createSequentialGroup()
                                                                .addComponent(lblCin, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                                                .addGap(10)
                                                                .addComponent(CINEtd, GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE))
                                                        .addComponent(separator_17_1, GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE))
                                                .addGap(176)
                                                .addGroup(gl_ajouterEtd.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(gl_ajouterEtd.createSequentialGroup()
                                                                .addComponent(lblAge, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                                                .addGap(10)
                                                                .addComponent(AgeEtd, GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE))
                                                        .addComponent(separator_17_2, GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
                                                        .addGroup(gl_ajouterEtd.createSequentialGroup()
                                                                .addComponent(lblFormation, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                                                .addGap(18)
                                                                .addComponent(FormationEtd, 0, 159, Short.MAX_VALUE)
                                                                .addGap(25))
                                                        .addComponent(separator_17_2_1, GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE))))
                                .addGap(1394))
        );
        gl_ajouterEtd.setVerticalGroup(
                gl_ajouterEtd.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(gl_ajouterEtd.createSequentialGroup()
                                .addGap(48)
                                .addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(separator_15, GroupLayout.PREFERRED_SIZE, 6, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(separator_16, GroupLayout.PREFERRED_SIZE, 11, GroupLayout.PREFERRED_SIZE)
                                .addGap(65)
                                .addGroup(gl_ajouterEtd.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(gl_ajouterEtd.createSequentialGroup()
                                                .addGroup(gl_ajouterEtd.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(lblAge, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(AgeEtd, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
                                                .addGap(6)
                                                .addComponent(separator_17_2, GroupLayout.PREFERRED_SIZE, 11, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(gl_ajouterEtd.createSequentialGroup()
                                                .addGroup(gl_ajouterEtd.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(etdName, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(separator_17, GroupLayout.PREFERRED_SIZE, 11, GroupLayout.PREFERRED_SIZE)))
                                .addGap(101)
                                .addGroup(gl_ajouterEtd.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(lblCin, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(gl_ajouterEtd.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(CINEtd, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lblFormation, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                                .addGroup(gl_ajouterEtd.createSequentialGroup()
                                                        .addGap(1)
                                                        .addComponent(FormationEtd, GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE))))
                                .addGap(6)
                                .addGroup(gl_ajouterEtd.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(separator_17_1, GroupLayout.PREFERRED_SIZE, 11, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(separator_17_2_1, GroupLayout.DEFAULT_SIZE, 11, Short.MAX_VALUE))
                                .addGap(64)
                                .addComponent(btnAjouterEtd, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                                .addGap(311))
        );
        this.setLayout(gl_ajouterEtd);

        this.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{etdName, CINEtd, AgeEtd, FormationEtd, btnAjouterEtd}));
        btnAjouterEtd.addActionListener(this);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==btnAjouterEtd) {
            String chN = etdName.getText();
            String chA = AgeEtd.getText();
            String chCIN = CINEtd.getText();
            String chF = FormationEtd.getSelectedItem().toString();
            try {
                if (chN.isEmpty() || chA.isEmpty() || chCIN.isEmpty() || chF.isEmpty()) {
                    throw new Exceptions("Il y a un champ vide ");
                }
                else if (!chA.matches("\\d+")) {
                    throw new Exceptions("age doit etre numerique");
                }
                else if (!chCIN.matches("\\d+")) {
                    throw new Exceptions("CIN doit etre numerique");
                }
                else if(chCIN.length()!=8)
                    throw new Exceptions("CIN doit avoir 8 chiffres");
                try{
                    Etudiant etd=new Etudiant(chCIN,chN,Integer.parseInt(chA),Formation.getFormation(chF));
                    bd.insertInto("Etudiant",etd);
                    bd.etudiants.add(etd);
                    JOptionPane.showMessageDialog(this,"l'Ajout est effectuée avec succès","Succès",JOptionPane.INFORMATION_MESSAGE);
                    etdName.setText("");
                    AgeEtd.setText("");
                    CINEtd.setText("");
                    FormationEtd.setSelectedIndex(0);
                }catch (Exception b){
                    System.out.println(b.getMessage());
                    throw new Exceptions("Etudiant existe deja");
                }
            }catch (Exceptions r){
                r.exec(this);
            }
        }
    }
}
