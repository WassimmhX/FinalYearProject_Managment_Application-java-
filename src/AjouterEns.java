import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class AjouterEns extends JPanel implements ActionListener {
    private BaseDonnee bd;
    private static JButton btnAjouterEns;
    private static JTextField EnsName, EnsCIN, EnsAge, EnsSp;
    public AjouterEns(BaseDonnee bd){
        this.bd=bd;
        this.setBackground(new Color(36, 47, 65));

        JLabel lblNewLabel_2_1 = new JLabel("Ajouter Enseignant");
        lblNewLabel_2_1.setForeground(Color.WHITE);
        lblNewLabel_2_1.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 22));
        lblNewLabel_2_1.setBackground(Color.WHITE);

        JSeparator separator_15_1 = new JSeparator();

        JSeparator separator_16_1 = new JSeparator();

        btnAjouterEns = new JButton();
        btnAjouterEns.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnAjouterEns.setText("Ajouter");
        btnAjouterEns.setForeground(Color.WHITE);
        btnAjouterEns.setFont(new Font("Century Gothic", Font.BOLD, 14));
        btnAjouterEns.setBackground(new Color(97, 212, 195));

        JSeparator separator_17_3 = new JSeparator();
        separator_17_3.setForeground(new Color(97, 212, 195));
        separator_17_3.setBackground(new Color(97, 212, 195));

        JLabel jLabel6_1 = new JLabel();
        jLabel6_1.setText("Full Name :");
        jLabel6_1.setForeground(new Color(97, 212, 195));
        jLabel6_1.setFont(new Font("Century Gothic", Font.BOLD, 16));

        EnsName = new JTextField();
        EnsName.setForeground(Color.WHITE);
        EnsName.setFont(new Font("Century Gothic", Font.BOLD, 13));
        EnsName.setDisabledTextColor(Color.WHITE);
        EnsName.setBorder(null);
        EnsName.setBackground(new Color(36, 47, 65));
        EnsName.addFocusListener(new FocusTextField(EnsName));
        EnsName.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    btnAjouterEns.doClick();
                }
            }
        });

        JLabel lblCin_1 = new JLabel();
        lblCin_1.setText("CIN :");
        lblCin_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblCin_1.setForeground(new Color(97, 212, 195));
        lblCin_1.setFont(new Font("Century Gothic", Font.BOLD, 16));

        EnsCIN = new JTextField();
        EnsCIN.setForeground(Color.WHITE);
        EnsCIN.setFont(new Font("Century Gothic", Font.BOLD, 13));
        EnsCIN.setDisabledTextColor(Color.WHITE);
        EnsCIN.setBorder(null);
        EnsCIN.setBackground(new Color(36, 47, 65));
        EnsCIN.addFocusListener(new FocusTextField(EnsCIN));
        EnsCIN.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    btnAjouterEns.doClick();
                }
            }
        });

        JSeparator separator_17_1_1 = new JSeparator();
        separator_17_1_1.setForeground(new Color(97, 212, 195));
        separator_17_1_1.setBackground(new Color(97, 212, 195));

        JLabel lblAge_1 = new JLabel();
        lblAge_1.setText("Age :");
        lblAge_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblAge_1.setForeground(new Color(97, 212, 195));
        lblAge_1.setFont(new Font("Century Gothic", Font.BOLD, 16));

        EnsAge = new JTextField();
        EnsAge.setForeground(Color.WHITE);
        EnsAge.setFont(new Font("Century Gothic", Font.BOLD, 13));
        EnsAge.setDisabledTextColor(Color.WHITE);
        EnsAge.setBorder(null);
        EnsAge.setBackground(new Color(36, 47, 65));
        EnsAge.addFocusListener(new FocusTextField(EnsAge));
        EnsAge.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    btnAjouterEns.doClick();
                }
            }
        });

        JSeparator separator_17_2_2 = new JSeparator();
        separator_17_2_2.setForeground(new Color(97, 212, 195));
        separator_17_2_2.setBackground(new Color(97, 212, 195));

        JLabel lblSpcialit = new JLabel();
        lblSpcialit.setText("Spécialité:");
        lblSpcialit.setHorizontalAlignment(SwingConstants.CENTER);
        lblSpcialit.setForeground(new Color(97, 212, 195));
        lblSpcialit.setFont(new Font("Century Gothic", Font.BOLD, 16));

        JSeparator separator_17_2_1_1 = new JSeparator();
        separator_17_2_1_1.setForeground(new Color(97, 212, 195));
        separator_17_2_1_1.setBackground(new Color(97, 212, 195));

        EnsSp = new JTextField();
        EnsSp.setForeground(Color.WHITE);
        EnsSp.setFont(new Font("Century Gothic", Font.BOLD, 13));
        EnsSp.setDisabledTextColor(Color.WHITE);
        EnsSp.setBorder(null);
        EnsSp.setBackground(new Color(36, 47, 65));
        EnsSp.addFocusListener(new FocusTextField(EnsSp));
        EnsSp.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    btnAjouterEns.doClick();
                }
            }
        });

        GroupLayout gl_ajouterEns = new GroupLayout(this);
        gl_ajouterEns.setHorizontalGroup(
                gl_ajouterEns.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 2313, Short.MAX_VALUE)
                        .addGroup(gl_ajouterEns.createSequentialGroup()
                                .addGroup(gl_ajouterEns.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(gl_ajouterEns.createSequentialGroup()
                                                .addGap(440)
                                                .addComponent(lblNewLabel_2_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(9))
                                        .addGroup(gl_ajouterEns.createSequentialGroup()
                                                .addGap(431)
                                                .addComponent(separator_15_1, GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE))
                                        .addGroup(gl_ajouterEns.createSequentialGroup()
                                                .addGap(463)
                                                .addComponent(separator_16_1, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                                                .addGap(29)))
                                .addGap(1672))
                        .addGroup(gl_ajouterEns.createSequentialGroup()
                                .addGap(159)
                                .addGroup(gl_ajouterEns.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(gl_ajouterEns.createSequentialGroup()
                                                .addGap(312)
                                                .addComponent(btnAjouterEns, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                                .addGap(308))
                                        .addGroup(gl_ajouterEns.createSequentialGroup()
                                                .addGroup(gl_ajouterEns.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(separator_17_3, GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
                                                        .addGroup(gl_ajouterEns.createSequentialGroup()
                                                                .addComponent(jLabel6_1, GroupLayout.PREFERRED_SIZE, 90, Short.MAX_VALUE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(EnsName, 192, 192, 192))
                                                        .addGroup(gl_ajouterEns.createSequentialGroup()
                                                                .addComponent(lblCin_1, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                                                .addGap(10)
                                                                .addComponent(EnsCIN, GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE))
                                                        .addComponent(separator_17_1_1, GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE))
                                                .addGap(176)
                                                .addGroup(gl_ajouterEns.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(gl_ajouterEns.createSequentialGroup()
                                                                .addComponent(lblAge_1, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                                                .addGap(10)
                                                                .addComponent(EnsAge, GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE))
                                                        .addComponent(separator_17_2_2, GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
                                                        .addGroup(gl_ajouterEns.createSequentialGroup()
                                                                .addComponent(lblSpcialit, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(EnsSp, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(7))
                                                        .addComponent(separator_17_2_1_1, GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE))))
                                .addGap(1394))
        );
        gl_ajouterEns.setVerticalGroup(
                gl_ajouterEns.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGap(0, 772, Short.MAX_VALUE)
                        .addGroup(gl_ajouterEns.createSequentialGroup()
                                .addGap(48)
                                .addComponent(lblNewLabel_2_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(separator_15_1, GroupLayout.PREFERRED_SIZE, 6, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(separator_16_1, GroupLayout.PREFERRED_SIZE, 11, GroupLayout.PREFERRED_SIZE)
                                .addGap(65)
                                .addGroup(gl_ajouterEns.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(gl_ajouterEns.createSequentialGroup()
                                                .addGroup(gl_ajouterEns.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(lblAge_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(EnsAge, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
                                                .addGap(6)
                                                .addComponent(separator_17_2_2, GroupLayout.PREFERRED_SIZE, 11, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(gl_ajouterEns.createSequentialGroup()
                                                .addGroup(gl_ajouterEns.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel6_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(EnsName, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(separator_17_3, GroupLayout.PREFERRED_SIZE, 11, GroupLayout.PREFERRED_SIZE)))
                                .addGap(96)
                                .addGroup(gl_ajouterEns.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(lblCin_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(gl_ajouterEns.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(EnsCIN, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lblSpcialit, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(EnsSp, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
                                .addGap(6)
                                .addGroup(gl_ajouterEns.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(separator_17_1_1, GroupLayout.PREFERRED_SIZE, 11, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(separator_17_2_1_1, GroupLayout.DEFAULT_SIZE, 11, Short.MAX_VALUE))
                                .addGap(64)
                                .addComponent(btnAjouterEns, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                                .addGap(311))
        );
        this.setLayout(gl_ajouterEns);
        btnAjouterEns.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==btnAjouterEns){
            String chN = EnsName.getText();
            String chA = EnsAge.getText();
            String chCIN = EnsCIN.getText();
            String chF = EnsSp.getText();
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
                    Enseignant etd=new Enseignant(chCIN,chN,Integer.parseInt(chA),chF,new ArrayList<Integer>());
                    bd.insertInto("Enseignant",etd);
                    bd.enseignants.add(etd);
                    JOptionPane.showMessageDialog(this,"l'Ajout est effectuée avec succès","Succès",JOptionPane.INFORMATION_MESSAGE);
                    EnsName.setText("");
                    EnsAge.setText("");
                    EnsCIN.setText("");
                    EnsSp.setText("");
                }catch (Exception b){
                    System.out.println(b.getMessage());
                    throw new Exceptions("Enseignant existe deja");
                }
            }catch (Exceptions r){
                r.exec(this);
            }
        }
    }
}
