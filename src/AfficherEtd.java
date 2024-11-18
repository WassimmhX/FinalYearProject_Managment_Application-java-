import com.lowagie.text.*;
import com.lowagie.text.pdf.GrayColor;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class AfficherEtd extends JPanel {
    private static JButton imprimerEtd;
    private static JComboBox rechEtdMotif,rechEtdMotif1;
    private static JTextField rechEtd,rechEtd1;
    private static JTable tableEtd;
    private static JScrollPane scrollEtd;
    public AfficherEtd(BaseDonnee bd) {
        setBackground(new Color(36, 47, 65));
        setLayout(null);

        JLabel lblNewLabel_5 = new JLabel("Les Etudiants");
        lblNewLabel_5.setForeground(new Color(255, 255, 255));
        lblNewLabel_5.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 22));
        lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_5.setBounds(439, 38, 191, 34);
        add(lblNewLabel_5);

        JSeparator separator_22 = new JSeparator();
        separator_22.setForeground(new Color(255, 255, 255));
        separator_22.setBounds(439, 70, 191, 16);
        add(separator_22);

        JSeparator separator_23 = new JSeparator();
        separator_23.setForeground(new Color(255, 255, 255));
        separator_23.setBounds(460, 84, 154, 16);
        add(separator_23);

        JLabel lblNewLabel_6 = new JLabel("Recherche : ");
        lblNewLabel_6.setForeground(new Color(97, 212, 195));
        lblNewLabel_6.setFont(new Font("Century Gothic", Font.BOLD, 16));
        lblNewLabel_6.setBounds(27, 113, 96, 23);
        add(lblNewLabel_6);

        imprimerEtd = new JButton();
        imprimerEtd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        imprimerEtd.setText("Imprimer");
        imprimerEtd.setForeground(Color.WHITE);
        imprimerEtd.setIcon(new ImageIcon(Menu.class.getResource("/image/imprimente.png")));
        imprimerEtd.setFont(new Font("Century Gothic", Font.BOLD, 14));
        imprimerEtd.setBackground(new Color(97, 212, 195));
        imprimerEtd.setBounds(500, 520, 130, 50);
        imprimerEtd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Document document = new Document(PageSize.A4, 30, 30, 30, 30);
                try {
                    JFileChooser file = new JFileChooser();
                    int x = file.showSaveDialog(AfficherEtd.this);
                    if (x == JFileChooser.APPROVE_OPTION) {
                        String path = file.getSelectedFile().getPath();
                        try {
                            if (file.getSelectedFile().getName().isEmpty() || file.getSelectedFile().getName().contains("."))
                                throw new Exceptions("Le nom de fichier ne peut pas etre vide el il ne peut pas admet une '.'");
                            PdfWriter.getInstance(document, new FileOutputStream(path + ".pdf"));
                            document.open();
                            Paragraph p = new Paragraph(file.getSelectedFile().getName(), new com.lowagie.text.Font(com.lowagie.text.Font.getFamilyIndex("TIMES_ROMAN"), 18, com.lowagie.text.Font.BOLD));
                            p.setAlignment("center");
                            document.add(p);
                            document.add(Chunk.NEWLINE);
                            PdfPTable table = new PdfPTable(tableEtd.getColumnCount());
                            table.setHeaderRows(1);
                            for (int i = 0; i < tableEtd.getColumnCount(); i++) {
                                PdfPCell cell = new PdfPCell(new Phrase(tableEtd.getColumnName(i)));
                                cell.setBackgroundColor(new GrayColor(0.7f));
                                table.addCell(cell);
                            }
                            for (int i = 0; i < tableEtd.getRowCount(); i++) {
                                for (int j = 0; j < tableEtd.getColumnCount(); j++) {
                                    table.addCell(tableEtd.getModel().getValueAt(i, j).toString());
                                }
                            }
                            document.add(table);
                            document.close();
                            JOptionPane.showMessageDialog(AfficherEtd.this, "pdf créer avec succées");
                        } catch (Exceptions r) {
                            r.exec(file);
                        }
                    }
                } catch (Exception r) {
                    JOptionPane.showMessageDialog(AfficherEtd.this, "vous devez fermer le fichier PDF d'aboard", "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        add(imprimerEtd);

        rechEtd = new JTextField();
        rechEtd.setBorder(null);
        rechEtd.setBackground(new Color(36, 47, 65));
        rechEtd.setForeground(new Color(255, 255, 255));
        rechEtd.setFont(new Font("Century Gothic", Font.BOLD, 15));
        rechEtd.setBounds(128, 117, 154, 19);
        rechEtd.addFocusListener(new FocusTextField(rechEtd));
        rechEtd.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String ch = rechEtd.getText();
                if (ch.isEmpty())
                    tableEtd.setModel(new DefaultTableModel(bd.getTable(bd.ETUDIANTS), bd.ETUDIANTHEADER));
                else {
                    String motif = (String) rechEtdMotif.getSelectedItem();
                    if (motif.equalsIgnoreCase("CIN")) {
                        ArrayList<Etudiant> x = new ArrayList<>();
                        for (Etudiant i : bd.etudiants) {
                            if (i.getCIN().startsWith(ch))
                                x.add(i);
                        }
                        String[][] y = new String[x.size()][4];
                        for (int i = 0; i < x.size(); i++) {
                            Etudiant b = x.get(i);
                            y[i][0] = b.getCIN();
                            y[i][1] = b.getFullName();
                            y[i][2] = ((Integer) b.getAge()).toString();
                            y[i][3] = b.getEd();
                        }
                        tableEtd.setModel(new DefaultTableModel(y, bd.ETUDIANTHEADER));
                    }
                    else if (motif.equalsIgnoreCase("NOM")) {
                        ArrayList<Etudiant> x = new ArrayList<>();
                        for (Etudiant i : bd.etudiants) {
                            if (i.getFullName().toUpperCase().contains(ch.toUpperCase()))
                                x.add(i);
                        }
                        String[][] y = new String[x.size()][4];
                        for (int i = 0; i < x.size(); i++) {
                            Etudiant b = x.get(i);
                            y[i][0] = b.getCIN();
                            y[i][1] = b.getFullName();
                            y[i][2] = ((Integer) b.getAge()).toString();
                            y[i][3] = b.getEd();
                        }
                        tableEtd.setModel(new DefaultTableModel(y, bd.ETUDIANTHEADER));
                    }
                    else if (motif.equalsIgnoreCase("age") && ch.matches("\\d+")) {
                        ArrayList<Etudiant> x = new ArrayList<>();
                        for (Etudiant i : bd.etudiants) {
                            if (i.getAge() == Integer.parseInt(ch))
                                x.add(i);
                        }
                        String[][] y = new String[x.size()][4];
                        for (int i = 0; i < x.size(); i++) {
                            Etudiant b = x.get(i);
                            y[i][0] = b.getCIN();
                            y[i][1] = b.getFullName();
                            y[i][2] = ((Integer) b.getAge()).toString();
                            y[i][3] = b.getEd();
                        }
                        tableEtd.setModel(new DefaultTableModel(y, bd.ETUDIANTHEADER));
                    }
                    else if (motif.equalsIgnoreCase("Formation")) {
                        ArrayList<Etudiant> x = new ArrayList<>();
                        for (Etudiant i : bd.etudiants) {
                            if (i.getEd().toUpperCase().contains(ch.toUpperCase()))
                                x.add(i);
                        }
                        String[][] y = new String[x.size()][4];
                        for (int i = 0; i < x.size(); i++) {
                            Etudiant b = x.get(i);
                            y[i][0] = b.getCIN();
                            y[i][1] = b.getFullName();
                            y[i][2] = ((Integer) b.getAge()).toString();
                            y[i][3] = b.getEd();
                        }
                        tableEtd.setModel(new DefaultTableModel(y, bd.ETUDIANTHEADER));
                    }
                }
            }
        });
        add(rechEtd);
        rechEtd.setColumns(10);
        /*rechEtd1 = new JTextField();
        rechEtd1.setBorder(null);
        rechEtd1.setBackground(new Color(36, 47, 65));
        rechEtd1.setForeground(new Color(255, 255, 255));
        rechEtd1.setFont(new Font("Century Gothic", Font.BOLD, 15));
        rechEtd1.setBounds(404, 117, 154, 19);
        rechEtd1.addFocusListener(new FocusTextField(rechEtd1));
        rechEtd1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String ch = rechEtd.getText();
                if (ch.isEmpty())
                    tableEtd.setModel(new DefaultTableModel(bd.getTable(bd.ETUDIANTS), bd.ETUDIANTHEADER));
                else {
                    String motif = (String) rechEtdMotif1.getSelectedItem();
                    if (motif.equalsIgnoreCase("CIN")) {
                        ArrayList<Etudiant> x = new ArrayList<>();
                        for (Etudiant i : bd.etudiants) {
                            if (i.getCIN().startsWith(ch))
                                x.add(i);
                        }
                        String[][] y = new String[x.size()][4];
                        for (int i = 0; i < x.size(); i++) {
                            Etudiant b = x.get(i);
                            y[i][0] = b.getCIN();
                            y[i][1] = b.getFullName();
                            y[i][2] = ((Integer) b.getAge()).toString();
                            y[i][3] = b.getEd();
                        }
                        tableEtd.setModel(new DefaultTableModel(y, bd.ETUDIANTHEADER));
                    }
                    else if (motif.equalsIgnoreCase("NOM")) {
                        ArrayList<Etudiant> x = new ArrayList<>();
                        for (Etudiant i : bd.etudiants) {
                            if (i.getFullName().toUpperCase().contains(ch.toUpperCase()))
                                x.add(i);
                        }
                        String[][] y = new String[x.size()][4];
                        for (int i = 0; i < x.size(); i++) {
                            Etudiant b = x.get(i);
                            y[i][0] = b.getCIN();
                            y[i][1] = b.getFullName();
                            y[i][2] = ((Integer) b.getAge()).toString();
                            y[i][3] = b.getEd();
                        }
                        tableEtd.setModel(new DefaultTableModel(y, bd.ETUDIANTHEADER));
                    }
                    else if (motif.equalsIgnoreCase("age") && ch.matches("\\d+")) {
                        ArrayList<Etudiant> x = new ArrayList<>();
                        for (Etudiant i : bd.etudiants) {
                            if (i.getAge() == Integer.parseInt(ch))
                                x.add(i);
                        }
                        String[][] y = new String[x.size()][4];
                        for (int i = 0; i < x.size(); i++) {
                            Etudiant b = x.get(i);
                            y[i][0] = b.getCIN();
                            y[i][1] = b.getFullName();
                            y[i][2] = ((Integer) b.getAge()).toString();
                            y[i][3] = b.getEd();
                        }
                        tableEtd.setModel(new DefaultTableModel(y, bd.ETUDIANTHEADER));
                    }
                    else if (motif.equalsIgnoreCase("Formation")) {
                        ArrayList<Etudiant> x = new ArrayList<>();
                        for (Etudiant i : bd.etudiants) {
                            if (i.getEd().toUpperCase().contains(ch.toUpperCase()))
                                x.add(i);
                        }
                        String[][] y = new String[x.size()][4];
                        for (int i = 0; i < x.size(); i++) {
                            Etudiant b = x.get(i);
                            y[i][0] = b.getCIN();
                            y[i][1] = b.getFullName();
                            y[i][2] = ((Integer) b.getAge()).toString();
                            y[i][3] = b.getEd();
                        }
                        tableEtd.setModel(new DefaultTableModel(y, bd.ETUDIANTHEADER));
                    }
                }
            }
        });
        add(rechEtd1);
        rechEtd1.setColumns(10);*/

        JSeparator separator_24 = new JSeparator();
        separator_24.setBackground(new Color(97, 212, 195));
        separator_24.setForeground(new Color(97, 212, 195));
        separator_24.setBounds(25, 139, 257, 10);
        add(separator_24);
        /*JSeparator separator_25 = new JSeparator();
        separator_25.setBackground(new Color(97, 212, 195));
        separator_25.setForeground(new Color(97, 212, 195));
        separator_25.setBounds(404, 139, 157, 10);
        add(separator_25);*/

        rechEtdMotif = new JComboBox();
        rechEtdMotif.setModel(new DefaultComboBoxModel(new String[]{"", "CIN", "NOM", "FORMATION", "AGE"}));
        rechEtdMotif.setForeground(new Color(255, 255, 255));
        rechEtdMotif.setFont(new Font("Century Gothic", Font.BOLD, 14));
        rechEtdMotif.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        rechEtdMotif.setBackground(new Color(36, 47, 65));
        rechEtdMotif.setBorder(null);
        rechEtdMotif.setBounds(294, 116, 96, 23);
        add(rechEtdMotif);
        /*rechEtdMotif1 = new JComboBox();
        rechEtdMotif1.setModel(new DefaultComboBoxModel(new String[]{"", "CIN", "NOM", "FORMATION", "AGE"}));
        rechEtdMotif1.setForeground(new Color(255, 255, 255));
        rechEtdMotif1.setFont(new Font("Century Gothic", Font.BOLD, 14));
        rechEtdMotif1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        rechEtdMotif1.setBackground(new Color(36, 47, 65));
        rechEtdMotif1.setBorder(null);
        rechEtdMotif1.setBounds(570, 116, 96, 23);
        add(rechEtdMotif1);*/
        tableEtd = new JTable(bd.getTable(bd.ETUDIANTS), bd.ETUDIANTHEADER);
        tableEtd.setForeground(new Color(255, 255, 255));
        tableEtd.setGridColor(new Color(255, 255, 255));
        tableEtd.setBackground(new Color(36, 47, 65));
        tableEtd.setColumnSelectionAllowed(true);
        tableEtd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        tableEtd.setFont(new Font("Century Gothic", Font.BOLD, 14));
        tableEtd.setRowHeight(30);
        JTableHeader tableHeaderEtd = tableEtd.getTableHeader();
        tableHeaderEtd.setBackground(new Color(36, 47, 65));
        tableHeaderEtd.setForeground(new Color(97, 212, 195));
        tableHeaderEtd.setFont(new Font("Century Gothic", Font.BOLD, 16));
        scrollEtd = new JScrollPane(tableEtd);
        scrollEtd.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollEtd.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollEtd.setBackground(new Color(36, 47, 65));
        scrollEtd.setFont(new Font("Century Gothic", Font.BOLD, 14));
        scrollEtd.setForeground(new Color(36, 47, 65));
        scrollEtd.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        scrollEtd.setBounds(50, 196, 1000, 300);
        add(scrollEtd);
    }
}
