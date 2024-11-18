
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

public class Menu extends JFrame implements ActionListener {

	private static BaseDonnee bd;
	private static final long serialVersionUID = 1L;
	private static JPanel contentPane, afficherEtd, afficherEns, afficherGrp, afficherPfe, afficherStn;

	private static JButton returnHome,btnParametre,imprimerEtd,imprimerEns,imprimerGrp,imprimerPfe,imprimerStn;
	private CardLayout layout;
	private JMenuItem afficherEnsBtn,ajouterEnsBtn,supprimerEnsBtn,
			ajouterEtdBtn,afficherEtdBtn,supprimerEtdBtn,
			ajouterGrpBtn,afficherGrpBtn,supprimerGrpBtn,
			ajouterPfeBtn,afficherPfeBtn,supprimerPfeBtn,
			afficherStnBtn,ajouterStnBtn,supprimerStnBtn,stnNoteBtn;

	private static JComboBox rechEtdMotif,rechEtdMotif1,rechEnsMotif,rechGrpMotif,rechPfeMotif,rechStnMotif;
	private static JTextField rechEtd,rechEtd1, rechEns, rechGrp,rechPfe,rechStn;
	private static JTable tableEtd,tableEns,tableGrp,tablePfe,tableStn;

	private static JScrollPane scrollEtd;

	public static void begin() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void actionStart(){
		returnHome.addActionListener(this);

		ajouterEtdBtn.addActionListener(this);

		supprimerEtdBtn.addActionListener(this);

		afficherEtdBtn.addActionListener(this);

		ajouterEnsBtn.addActionListener(this);

		supprimerEnsBtn.addActionListener(this);

		afficherEnsBtn.addActionListener(this);

		ajouterGrpBtn.addActionListener(this);

		supprimerGrpBtn.addActionListener(this);

		afficherGrpBtn.addActionListener(this);

		ajouterPfeBtn.addActionListener(this);

		supprimerPfeBtn.addActionListener(this);

		afficherPfeBtn.addActionListener(this);

		ajouterStnBtn.addActionListener(this);

		supprimerStnBtn.addActionListener(this);

		afficherStnBtn.addActionListener(this);

		stnNoteBtn.addActionListener(this);

		btnParametre.addActionListener(this);
	}

	private void panelADD(){

		contentPane.add(new Home(),"home");

		contentPane.add(new AjouterEtd(bd),"ajouterEtd");
		contentPane.add(new SupprimerEtd(bd),"supprimerEtd");

		contentPane.add(new AjouterEns(bd),"ajouterEns");
		contentPane.add(new SupprimerEns(bd),"supprimerEns");

		contentPane.add(new AjouterGrp(bd),"ajouterGrp");
		contentPane.add(new SupprimerGrp(bd),"supprimerGrp");

		contentPane.add(new AjouterPFE(bd),"ajouterPfe");
		contentPane.add(new SupprimerPFE(bd),"supprimerPfe");

		contentPane.add(new AjouterStn(bd),"ajouterStn");
		contentPane.add(new SupprimerStn(bd),"supprimerStn");
		contentPane.add(new NoterStn(bd),"stnNote");

		contentPane.add(new Parametre(bd),"parametre");
	}

	public Menu() {
		bd=new BaseDonnee();
		setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/image/pfe.jpg")));
		setTitle("Gestion de PFE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 650);
		/**MENUBAR**/
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JSeparator separator_5 = new JSeparator();
		separator_5.setOrientation(SwingConstants.VERTICAL);
		menuBar.add(separator_5);
		returnHome = new JButton("");
		returnHome.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		returnHome.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		returnHome.setBounds(new Rectangle(0, 0, 20, 0));
		returnHome.setBorder(null);
		returnHome.setIcon(new ImageIcon(Menu.class.getResource("/image/home3.png")));
		returnHome.setBackground(new Color(240, 240, 240));
		menuBar.add(returnHome);

		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		menuBar.add(separator_2);

		JMenu mnNewMenu = new JMenu("Personnes");
		mnNewMenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnNewMenu.setFont(new Font("Century Gothic", Font.BOLD, 12));
		menuBar.add(mnNewMenu);

		JSeparator separator_28 = new JSeparator();
		mnNewMenu.add(separator_28);

		JMenu mnNewMenu_2 = new JMenu("Etudiants");
		mnNewMenu_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnNewMenu_2.setFont(new Font("Century Gothic", Font.BOLD, 12));
		mnNewMenu_2.setIcon(new ImageIcon(Menu.class.getResource("/image/etudiant4.png")));
		mnNewMenu.add(mnNewMenu_2);

		JSeparator separator_26 = new JSeparator();
		mnNewMenu_2.add(separator_26);

		afficherEtdBtn = new JMenuItem("Afficher");
		afficherEtdBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		afficherEtdBtn.setIcon(new ImageIcon(Menu.class.getResource("/image/afficher.png")));
		afficherEtdBtn.setFont(new Font("Century Gothic", Font.BOLD, 12));
		mnNewMenu_2.add(afficherEtdBtn);

		JSeparator separator_7 = new JSeparator();
		mnNewMenu_2.add(separator_7);

		ajouterEtdBtn = new JMenuItem("Ajouter");
		ajouterEtdBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ajouterEtdBtn.setIcon(new ImageIcon(Menu.class.getResource("/image/ajouter2.png")));
		ajouterEtdBtn.setFont(new Font("Century Gothic", Font.BOLD, 12));
		mnNewMenu_2.add(ajouterEtdBtn);

		JSeparator separator_8 = new JSeparator();
		mnNewMenu_2.add(separator_8);

		supprimerEtdBtn = new JMenuItem("Supprimer");
		supprimerEtdBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		supprimerEtdBtn.setIcon(new ImageIcon(Menu.class.getResource("/image/supprimer.png")));
		supprimerEtdBtn.setFont(new Font("Century Gothic", Font.BOLD, 12));
		mnNewMenu_2.add(supprimerEtdBtn);

		JSeparator separator_6 = new JSeparator();
		mnNewMenu.add(separator_6);

		JMenu mnNewMenu_4 = new JMenu("Enseignants");
		mnNewMenu_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnNewMenu_4.setFont(new Font("Century Gothic", Font.BOLD, 12));
		mnNewMenu_4.setIcon(new ImageIcon(Menu.class.getResource("/image/eng2.png")));
		mnNewMenu.add(mnNewMenu_4);

		JSeparator separator_25 = new JSeparator();
		mnNewMenu_4.add(separator_25);

		afficherEnsBtn = new JMenuItem("Afficher");
		afficherEnsBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		afficherEnsBtn.setIcon(new ImageIcon(Menu.class.getResource("/image/afficher.png")));
		afficherEnsBtn.setFont(new Font("Century Gothic", Font.BOLD, 12));
		mnNewMenu_4.add(afficherEnsBtn);

		JSeparator separator_9 = new JSeparator();
		mnNewMenu_4.add(separator_9);

		ajouterEnsBtn = new JMenuItem("Ajouter");
		ajouterEnsBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ajouterEnsBtn.setIcon(new ImageIcon(Menu.class.getResource("/image/ajouter2.png")));
		ajouterEnsBtn.setFont(new Font("Century Gothic", Font.BOLD, 12));
		mnNewMenu_4.add(ajouterEnsBtn);

		JSeparator separator_10 = new JSeparator();
		mnNewMenu_4.add(separator_10);

		supprimerEnsBtn = new JMenuItem("Supprimer");
		supprimerEnsBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		supprimerEnsBtn.setIcon(new ImageIcon(Menu.class.getResource("/image/supprimer.png")));
		supprimerEnsBtn.setFont(new Font("Century Gothic", Font.BOLD, 12));
		mnNewMenu_4.add(supprimerEnsBtn);

		JSeparator separator_18 = new JSeparator();
		mnNewMenu_4.add(separator_18);

		JSeparator separator_22 = new JSeparator();
		mnNewMenu.add(separator_22);

		JMenu mnNewMenu_2_1 = new JMenu("Groups");
		mnNewMenu_2_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnNewMenu_2_1.setIcon(new ImageIcon(Menu.class.getResource("/image/grp.png")));
		mnNewMenu_2_1.setFont(new Font("Century Gothic", Font.BOLD, 12));
		mnNewMenu.add(mnNewMenu_2_1);

		JSeparator separator_24 = new JSeparator();
		mnNewMenu_2_1.add(separator_24);

		afficherGrpBtn = new JMenuItem("Afficher");
		afficherGrpBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		afficherGrpBtn.setIcon(new ImageIcon(Menu.class.getResource("/image/afficher.png")));
		afficherGrpBtn.setFont(new Font("Century Gothic", Font.BOLD, 12));
		mnNewMenu_2_1.add(afficherGrpBtn);

		JSeparator separator_7_1 = new JSeparator();
		mnNewMenu_2_1.add(separator_7_1);

		ajouterGrpBtn = new JMenuItem("Ajouter");
		ajouterGrpBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ajouterGrpBtn.setIcon(new ImageIcon(Menu.class.getResource("/image/ajouter2.png")));
		ajouterGrpBtn.setFont(new Font("Century Gothic", Font.BOLD, 12));
		mnNewMenu_2_1.add(ajouterGrpBtn);

		JSeparator separator_8_1 = new JSeparator();
		mnNewMenu_2_1.add(separator_8_1);

		supprimerGrpBtn = new JMenuItem("Supprimer");
		supprimerGrpBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		supprimerGrpBtn.setIcon(new ImageIcon(Menu.class.getResource("/image/supprimer.png")));
		supprimerGrpBtn.setFont(new Font("Century Gothic", Font.BOLD, 12));
		mnNewMenu_2_1.add(supprimerGrpBtn);

		JSeparator separator_23 = new JSeparator();
		mnNewMenu_2_1.add(separator_23);

		JSeparator separator_27 = new JSeparator();
		mnNewMenu.add(separator_27);

		JSeparator separator_3 = new JSeparator();
		separator_3.setOrientation(SwingConstants.VERTICAL);
		menuBar.add(separator_3);

		JMenu mnNewMenu_1 = new JMenu("PFE et Soutenance");
		mnNewMenu_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnNewMenu_1.setFont(new Font("Century Gothic", Font.BOLD, 12));
		menuBar.add(mnNewMenu_1);

		JSeparator separator_31 = new JSeparator();
		mnNewMenu_1.add(separator_31);

		JMenu mnNewMenu_5 = new JMenu("PFE");
		mnNewMenu_5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnNewMenu_5.setIcon(new ImageIcon(Menu.class.getResource("/image/graduation.png")));
		mnNewMenu_5.setFont(new Font("Century Gothic", Font.BOLD, 12));
		mnNewMenu_1.add(mnNewMenu_5);

		JSeparator separator_34 = new JSeparator();
		mnNewMenu_5.add(separator_34);

		afficherPfeBtn = new JMenuItem("Afficher");
		afficherPfeBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		afficherPfeBtn.setIcon(new ImageIcon(Menu.class.getResource("/image/afficher.png")));
		afficherPfeBtn.setFont(new Font("Century Gothic", Font.BOLD, 12));
		mnNewMenu_5.add(afficherPfeBtn);

		JSeparator separator_13 = new JSeparator();
		mnNewMenu_5.add(separator_13);

		ajouterPfeBtn = new JMenuItem("Ajouter");
		ajouterPfeBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ajouterPfeBtn.setIcon(new ImageIcon(Menu.class.getResource("/image/ajouter2.png")));
		ajouterPfeBtn.setFont(new Font("Century Gothic", Font.BOLD, 12));
		mnNewMenu_5.add(ajouterPfeBtn);

		JSeparator separator_14 = new JSeparator();
		mnNewMenu_5.add(separator_14);

		supprimerPfeBtn = new JMenuItem("Supprimer");
		supprimerPfeBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		supprimerPfeBtn.setIcon(new ImageIcon(Menu.class.getResource("/image/supprimer.png")));
		supprimerPfeBtn.setFont(new Font("Century Gothic", Font.BOLD, 12));
		mnNewMenu_5.add(supprimerPfeBtn);

		JSeparator separator_35 = new JSeparator();
		mnNewMenu_5.add(separator_35);

		JSeparator separator_29 = new JSeparator();
		mnNewMenu_1.add(separator_29);

		JMenu mnNewMenu_3 = new JMenu("Soutenance");
		mnNewMenu_3.setIcon(new ImageIcon(Menu.class.getResource("/image/stn3.png")));
		mnNewMenu_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnNewMenu_3.setFont(new Font("Century Gothic", Font.BOLD, 12));
		mnNewMenu_1.add(mnNewMenu_3);

		JSeparator separator_33 = new JSeparator();
		mnNewMenu_3.add(separator_33);

		afficherStnBtn = new JMenuItem("Afficher");
		afficherStnBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		afficherStnBtn.setIcon(new ImageIcon(Menu.class.getResource("/image/afficher.png")));
		afficherStnBtn.setFont(new Font("Century Gothic", Font.BOLD, 12));
		mnNewMenu_3.add(afficherStnBtn);

		JSeparator separator_11 = new JSeparator();
		mnNewMenu_3.add(separator_11);

		ajouterStnBtn = new JMenuItem("Ajouter");
		ajouterStnBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ajouterStnBtn.setIcon(new ImageIcon(Menu.class.getResource("/image/ajouter2.png")));
		ajouterStnBtn.setFont(new Font("Century Gothic", Font.BOLD, 12));
		mnNewMenu_3.add(ajouterStnBtn);

		JSeparator separator_12 = new JSeparator();
		mnNewMenu_3.add(separator_12);

		supprimerStnBtn = new JMenuItem("Supprimer");
		supprimerStnBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		supprimerStnBtn.setIcon(new ImageIcon(Menu.class.getResource("/image/supprimer.png")));
		supprimerStnBtn.setFont(new Font("Century Gothic", Font.BOLD, 12));
		mnNewMenu_3.add(supprimerStnBtn);

		JSeparator separator_32 = new JSeparator();
		mnNewMenu_3.add(separator_32);

		stnNoteBtn = new JMenuItem("Note");
		stnNoteBtn.setIcon(new ImageIcon(Menu.class.getResource("/image/nte.png")));
		stnNoteBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		stnNoteBtn.setFont(new Font("Century Gothic", Font.BOLD, 12));
		mnNewMenu_3.add(stnNoteBtn);

		JSeparator separator_36 = new JSeparator();
		mnNewMenu_3.add(separator_36);

		JSeparator separator_30 = new JSeparator();
		mnNewMenu_1.add(separator_30);

		JSeparator separator_4 = new JSeparator();
		separator_4.setOrientation(SwingConstants.VERTICAL);
		menuBar.add(separator_4);

		btnParametre = new JButton();
		btnParametre.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnParametre.setFont(new Font("Century Gothic", Font.BOLD, 12));
		btnParametre.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		btnParametre.setBounds(new Rectangle(0, 0, 20, 0));
		btnParametre.setBorder(null);
		btnParametre.setBackground(new Color(240, 240, 240));
		btnParametre.setIcon(new ImageIcon(Menu.class.getResource("/image/parametre.png")));
		menuBar.add(btnParametre);

		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		menuBar.add(separator);

		Component horizontalStrut = Box.createHorizontalStrut(1259);
		menuBar.add(horizontalStrut);
	/**contentPane**/
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));

		setContentPane(contentPane);
		layout=new CardLayout(0, 0);
		contentPane.setLayout(layout);
		panelADD();
		actionStart();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==returnHome){
			layout.show(contentPane,"home");
		}

		else if (e.getSource()==ajouterEtdBtn) {
			layout.show(contentPane,"ajouterEtd");
		}

		else if(e.getSource()==supprimerEtdBtn){
			layout.show(contentPane,"supprimerEtd");
		}

		else if(e.getSource()==afficherEtdBtn){
			afficherEtd=new AfficherEtd(bd);
			contentPane.add(afficherEtd, "afficherEtd");
			layout.show(contentPane,"afficherEtd");
		}

		else if (e.getSource()==ajouterEnsBtn){
			layout.show(contentPane,"ajouterEns");
		}


		else if(e.getSource()==supprimerEnsBtn){
			layout.show(contentPane,"supprimerEns");
		}

		else if(e.getSource()==afficherEnsBtn){
			afficherEns=Construire.afficherEns();
			contentPane.add(afficherEns, "afficherEns");
			layout.show(contentPane,"afficherEns");
		}

		else if(e.getSource()==ajouterGrpBtn){
			layout.show(contentPane,"ajouterGrp");
		}

		else if(e.getSource()==supprimerGrpBtn){
			layout.show(contentPane,"supprimerGrp");
		}

		else if(e.getSource()==afficherGrpBtn){
			afficherGrp=Construire.afficherGrp();
			contentPane.add(afficherGrp,"afficherGrp");
			layout.show(contentPane,"afficherGrp");
		}

		else if(e.getSource()==ajouterPfeBtn){
			layout.show(contentPane,"ajouterPfe");
		}

		else if(e.getSource()==supprimerPfeBtn){
			layout.show(contentPane,"supprimerPfe");
		}

		else if(e.getSource()==afficherPfeBtn){
			afficherPfe=Construire.afficherPfe();
			contentPane.add(afficherPfe,"afficherPfe");
			layout.show(contentPane,"afficherPfe");
		}

		else if(e.getSource()==ajouterStnBtn){
			layout.show(contentPane,"ajouterStn");
		}

		else if(e.getSource()==supprimerStnBtn){
			layout.show(contentPane,"supprimerStn");
		}

		else if(e.getSource()==afficherStnBtn){
			afficherStn=Construire.afficherStn();
			contentPane.add(afficherStn,"afficherStn");
			layout.show(contentPane,"afficherStn");
		}

		else if(e.getSource()==stnNoteBtn){
			layout.show(contentPane,"stnNote");
		}
		else if(e.getSource()==btnParametre)
			layout.show(contentPane,"parametre");
	}

	private static class Construire{
		public static JPanel afficherEns(){
			JPanel panel = new JPanel();
			panel.setBackground(new Color(36, 47, 65));
			panel.setLayout(null);

			JLabel lblNewLabel_5 = new JLabel("Les Enseignants");
			lblNewLabel_5.setForeground(new Color(255, 255, 255));
			lblNewLabel_5.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 22));
			lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_5.setBounds(439, 38, 191, 34);
			panel.add(lblNewLabel_5);

			JSeparator separator_22 = new JSeparator();
			separator_22.setForeground(new Color(255, 255, 255));
			separator_22.setBounds(439, 70, 191, 16);
			panel.add(separator_22);

			JSeparator separator_23 = new JSeparator();
			separator_23.setForeground(new Color(255, 255, 255));
			separator_23.setBounds(460, 84, 154, 16);
			panel.add(separator_23);

			JLabel lblNewLabel_6 = new JLabel("Recherche : ");
			lblNewLabel_6.setForeground(new Color(97, 212, 195));
			lblNewLabel_6.setFont(new Font("Century Gothic", Font.BOLD, 16));
			lblNewLabel_6.setBounds(27, 113, 96, 23);
			panel.add(lblNewLabel_6);

			imprimerEns = new JButton();
			imprimerEns.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			imprimerEns.setText("Imprimer");
			imprimerEns.setForeground(Color.WHITE);
			imprimerEns.setIcon(new ImageIcon(Menu.class.getResource("/image/imprimente.png")));
			imprimerEns.setFont(new Font("Century Gothic", Font.BOLD, 14));
			imprimerEns.setBackground(new Color(97, 212, 195));
			imprimerEns.setBounds(500,520,130,50);
			imprimerEns.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					Document document=new Document(PageSize.A4,30,30,30,30);
					try {
						JFileChooser file=new JFileChooser();
						int x=file.showSaveDialog(contentPane);
						if(x==JFileChooser.APPROVE_OPTION) {
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
								PdfPTable table = new PdfPTable(tableEns.getColumnCount());
								table.setHeaderRows(1);
								for (int i = 0; i < tableEns.getColumnCount(); i++) {
									PdfPCell cell = new PdfPCell(new Phrase(tableEns.getColumnName(i)));
									cell.setBackgroundColor(new GrayColor(0.7f));
									table.addCell(cell);
								}
								for (int i = 0; i < tableEns.getRowCount(); i++) {
									for (int j = 0; j < tableEns.getColumnCount(); j++) {
										table.addCell(tableEns.getModel().getValueAt(i, j).toString());
									}
								}
								document.add(table);
								document.close();
								JOptionPane.showMessageDialog(contentPane, "pdf créer avec succées");
							} catch (Exceptions r) {
								r.exec(file);
							}
						}
					} catch (Exception r){
						JOptionPane.showMessageDialog(contentPane,"vous devez fermer le fichier PDF d'aboard","Erreur",JOptionPane.ERROR_MESSAGE);
					}
				}
			});
			panel.add(imprimerEns);

			rechEns = new JTextField();
			rechEns.setBorder(null);
			rechEns.setBackground(new Color(36, 47, 65));
			rechEns.setForeground(new Color(255, 255, 255));
			rechEns.setFont(new Font("Century Gothic", Font.BOLD, 15));
			rechEns.setBounds(128, 117, 154, 19);
			rechEns.addFocusListener(new FocusTextField(rechEns));
			rechEns.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					String ch=rechEns.getText();
					if(ch.isEmpty())
						tableEns.setModel(new DefaultTableModel(bd.getTable(bd.ENSEIGNANTS),bd.ENSEIGNANTHEADER));
					else {
						String motif=(String) rechEnsMotif.getSelectedItem();
						if (motif.equalsIgnoreCase("CIN")) {
							ArrayList<Enseignant> x = new ArrayList<>();
							for (Enseignant i : bd.enseignants) {
								if (i.getCIN().startsWith(ch))
									x.add(i);
							}
							String[][] y = new String[x.size()][5];
							for (int i = 0; i < x.size(); i++) {
								Enseignant b = x.get(i);
								y[i][0] = b.getCIN();
								y[i][1] = b.getFullName();
								y[i][2] = ((Integer) b.getAge()).toString();
								y[i][3] = b.getSpecialite();
								y[i][4] = b.getgEncadrer()!=null?b.getgEncadrer().toString():"{}";
							}
							tableEns.setModel(new DefaultTableModel(y, bd.ENSEIGNANTHEADER));
						}
						else if (motif.equalsIgnoreCase("nom")) {
							ArrayList<Enseignant> x = new ArrayList<>();
							for (Enseignant i : bd.enseignants) {
								if (i.getFullName().toUpperCase().contains(ch.toUpperCase()))
									x.add(i);
							}
							String[][] y = new String[x.size()][5];
							for (int i = 0; i < x.size(); i++) {
								Enseignant b = x.get(i);
								y[i][0] = b.getCIN();
								y[i][1] = b.getFullName();
								y[i][2] = ((Integer) b.getAge()).toString();
								y[i][3] = b.getSpecialite();
								y[i][4] = b.getgEncadrer()!=null?b.getgEncadrer().toString():"{}";
							}
							tableEns.setModel(new DefaultTableModel(y, bd.ENSEIGNANTHEADER));
						}
						else if (motif.equalsIgnoreCase("age") && ch.matches("\\d+")) {
							ArrayList<Enseignant> x = new ArrayList<>();
							for (Enseignant i : bd.enseignants) {
								if (i.getAge()==Integer.parseInt(ch))
									x.add(i);
							}
							String[][] y = new String[x.size()][5];
							for (int i = 0; i < x.size(); i++) {
								Enseignant b = x.get(i);
								y[i][0] = b.getCIN();
								y[i][1] = b.getFullName();
								y[i][2] = ((Integer) b.getAge()).toString();
								y[i][3] = b.getSpecialite();
								y[i][4] = b.getgEncadrer()!=null?b.getgEncadrer().toString():"{}";
							}
							tableEns.setModel(new DefaultTableModel(y, bd.ENSEIGNANTHEADER));
						}
						else if (motif.equalsIgnoreCase("specialite")) {
							ArrayList<Enseignant> x = new ArrayList<>();
							for (Enseignant i : bd.enseignants) {
								if (i.getSpecialite().toUpperCase().contains(ch.toUpperCase()))
									x.add(i);
							}
							String[][] y = new String[x.size()][5];
							for (int i = 0; i < x.size(); i++) {
								Enseignant b = x.get(i);
								y[i][0] = b.getCIN();
								y[i][1] = b.getFullName();
								y[i][2] = ((Integer) b.getAge()).toString();
								y[i][3] = b.getSpecialite();
								y[i][4] = b.getgEncadrer()!=null?b.getgEncadrer().toString():"{}";;
							}
							tableEns.setModel(new DefaultTableModel(y, bd.ENSEIGNANTHEADER));
						}
					}
				}
			});
			panel.add(rechEns);
			rechEns.setColumns(10);

			JSeparator separator_24 = new JSeparator();
			separator_24.setBackground(new Color(97, 212, 195));
			separator_24.setForeground(new Color(97, 212, 195));
			separator_24.setBounds(25, 139, 257, 10);
			panel.add(separator_24);

			rechEnsMotif = new JComboBox();
			rechEnsMotif.setModel(new DefaultComboBoxModel(new String[] {"", "CIN", "NAME", "SPECIALITE", "AGE"}));
			rechEnsMotif.setForeground(new Color(255, 255, 255));
			rechEnsMotif.setFont(new Font("Century Gothic", Font.BOLD, 14));
			rechEnsMotif.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			rechEnsMotif.setBackground(new Color(36, 47, 65));
			rechEnsMotif.setBorder(null);
			rechEnsMotif.setBounds(294, 116, 96, 23);
			panel.add(rechEnsMotif);
			tableEns=new JTable(bd.getTable(bd.ENSEIGNANTS),bd.ENSEIGNANTHEADER);
			tableEns.setForeground(new Color(255, 255, 255));
			tableEns.setGridColor(new Color(255, 255, 255));
			tableEns.setBackground(new Color(36, 47, 65));
			tableEns.setColumnSelectionAllowed(true);
			tableEns.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			tableEns.setFont(new Font("Century Gothic", Font.BOLD, 14));
			tableEns.setRowHeight(30);
			JTableHeader tableHeaderEns=tableEns.getTableHeader();
			tableHeaderEns.setBackground(new Color(36, 47, 65));
			tableHeaderEns.setForeground(new Color(97, 212, 195));
			tableHeaderEns.setFont(new Font("Century Gothic", Font.BOLD, 16));
			JScrollPane scrollEns=new JScrollPane(tableEns);
			scrollEns.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			scrollEns.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
			scrollEns.setBackground(new Color(36, 47, 65));
			scrollEns.setFont(new Font("Century Gothic", Font.BOLD, 14));
			scrollEns.setForeground(new Color(36, 47, 65));
			scrollEns.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			scrollEns.setBounds(50, 196, 1000, 300);
			panel.add(scrollEns);
			return panel;
		}
		public static JPanel afficherGrp(){
			JPanel panel = new JPanel();
			panel.setBackground(new Color(36, 47, 65));
			panel.setLayout(null);

			JLabel lblNewLabel_5 = new JLabel("Les Groups");
			lblNewLabel_5.setForeground(new Color(255, 255, 255));
			lblNewLabel_5.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 22));
			lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_5.setBounds(439, 38, 191, 34);
			panel.add(lblNewLabel_5);

			JSeparator separator_22 = new JSeparator();
			separator_22.setForeground(new Color(255, 255, 255));
			separator_22.setBounds(439, 70, 191, 16);
			panel.add(separator_22);

			JSeparator separator_23 = new JSeparator();
			separator_23.setForeground(new Color(255, 255, 255));
			separator_23.setBounds(460, 84, 154, 16);
			panel.add(separator_23);

			JLabel lblNewLabel_6 = new JLabel("Recherche : ");
			lblNewLabel_6.setForeground(new Color(97, 212, 195));
			lblNewLabel_6.setFont(new Font("Century Gothic", Font.BOLD, 16));
			lblNewLabel_6.setBounds(27, 113, 96, 23);
			panel.add(lblNewLabel_6);

			imprimerGrp = new JButton();
			imprimerGrp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			imprimerGrp.setText("Imprimer");
			imprimerGrp.setForeground(Color.WHITE);
			imprimerGrp.setIcon(new ImageIcon(Menu.class.getResource("/image/imprimente.png")));
			imprimerGrp.setFont(new Font("Century Gothic", Font.BOLD, 14));
			imprimerGrp.setBackground(new Color(97, 212, 195));
			imprimerGrp.setBounds(500,520,130,50);
			imprimerGrp.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					Document document=new Document(PageSize.A4,30,30,30,30);
					try {
						JFileChooser file=new JFileChooser();
						int x=file.showSaveDialog(contentPane);
						if(x==JFileChooser.APPROVE_OPTION) {
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
								PdfPTable table = new PdfPTable(tableGrp.getColumnCount());
								table.setHeaderRows(1);
								for (int i = 0; i < tableGrp.getColumnCount(); i++) {
									PdfPCell cell = new PdfPCell(new Phrase(tableGrp.getColumnName(i)));
									cell.setBackgroundColor(new GrayColor(0.7f));
									table.addCell(cell);
								}
								for (int i = 0; i < tableGrp.getRowCount(); i++) {
									for (int j = 0; j < tableGrp.getColumnCount(); j++) {
										table.addCell(tableGrp.getModel().getValueAt(i, j).toString());
									}
								}
								document.add(table);
								document.close();
								JOptionPane.showMessageDialog(contentPane, "pdf créer avec succées");
							} catch (Exceptions r) {
								r.exec(file);
							}
						}
					} catch (Exception r){
						JOptionPane.showMessageDialog(contentPane,"vous devez fermer le fichier PDF d'aboard","Erreur",JOptionPane.ERROR_MESSAGE);
					}
				}
			});
			panel.add(imprimerGrp);

			rechGrp = new JTextField();
			rechGrp.setBorder(null);
			rechGrp.setBackground(new Color(36, 47, 65));
			rechGrp.setForeground(new Color(255, 255, 255));
			rechGrp.setFont(new Font("Century Gothic", Font.BOLD, 15));
			rechGrp.setBounds(128, 117, 154, 19);
			rechGrp.addFocusListener(new FocusTextField(rechGrp));
			rechGrp.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					String ch=rechGrp.getText();
					if(ch.isEmpty())
						tableGrp.setModel(new DefaultTableModel(bd.getTable(bd.GROUPS),bd.GROUPHEADER));
					else {
						String motif=(String) rechGrpMotif.getSelectedItem();
						if (motif.equalsIgnoreCase("etudiant")) {
							ArrayList<Group> x = new ArrayList<>();
							for (Group i : bd.groups) {
								Boolean b=false;
								for(String j:i.getEtds()){
									if(j.startsWith(ch)){
										x.add(i);
										b=true;
										break;
									}
								}
								if(b)
									break;
							}
							String[][] y = new String[x.size()][3];
							for (int i = 0; i < x.size(); i++) {
								Group b = x.get(i);
								y[i][0] = Integer.toString(b.getNb());
								y[i][1] = b.getEtds()!=null? Arrays.toString(b.getEtds()) :"{}";
								y[i][2] = b.getEncadreur();
							}
							tableGrp.setModel(new DefaultTableModel(y, bd.GROUPHEADER));
						}
						else if (motif.equalsIgnoreCase("encadreur")) {
							ArrayList<Group> x = new ArrayList<>();
							for (Group i : bd.groups) {
								if (i.getEncadreur().startsWith(ch))
									x.add(i);
							}
							String[][] y = new String[x.size()][5];
							for (int i = 0; i < x.size(); i++) {
								Group b = x.get(i);
								y[i][0] = Integer.toString(b.getNb());
								y[i][1] = b.getEtds()!=null? Arrays.toString(b.getEtds()) :"{}";
								y[i][2] = b.getEncadreur();
							}
							tableGrp.setModel(new DefaultTableModel(y, bd.GROUPHEADER));
						}
						else if (motif.equalsIgnoreCase("numero") && ch.matches("\\d+")) {
							ArrayList<Group> x = new ArrayList<>();
							for (Group i : bd.groups) {
								if (i.getNb()==Integer.parseInt(ch))
									x.add(i);
							}
							String[][] y = new String[x.size()][5];
							for (int i = 0; i < x.size(); i++) {
								Group b = x.get(i);
								y[i][0] = Integer.toString(b.getNb());
								y[i][1] = b.getEtds()!=null? Arrays.toString(b.getEtds()) :"{}";
								y[i][2] = b.getEncadreur();
							}
							tableGrp.setModel(new DefaultTableModel(y, bd.GROUPHEADER));
						}
					}
				}
			});
			panel.add(rechGrp);
			rechGrp.setColumns(10);

			JSeparator separator_24 = new JSeparator();
			separator_24.setBackground(new Color(97, 212, 195));
			separator_24.setForeground(new Color(97, 212, 195));
			separator_24.setBounds(25, 139, 257, 10);
			panel.add(separator_24);

			rechGrpMotif = new JComboBox();
			rechGrpMotif.setModel(new DefaultComboBoxModel(new String[] {"", "NUMERO", "ETUDIANT", "ENCADREUR"}));
			rechGrpMotif.setForeground(new Color(255, 255, 255));
			rechGrpMotif.setFont(new Font("Century Gothic", Font.BOLD, 14));
			rechGrpMotif.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			rechGrpMotif.setBackground(new Color(36, 47, 65));
			rechGrpMotif.setBorder(null);
			rechGrpMotif.setBounds(294, 116, 96, 23);
			panel.add(rechGrpMotif);
			tableGrp=new JTable(bd.getTable(bd.GROUPS),bd.GROUPHEADER);
			tableGrp.setForeground(new Color(255, 255, 255));
			tableGrp.setGridColor(new Color(255, 255, 255));
			tableGrp.setBackground(new Color(36, 47, 65));
			tableGrp.setColumnSelectionAllowed(true);
			tableGrp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			tableGrp.setFont(new Font("Century Gothic", Font.BOLD, 14));
			tableGrp.setRowHeight(30);
			tableGrp.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int row=tableGrp.rowAtPoint(e.getPoint());
					int column=tableGrp.columnAtPoint(e.getPoint());
					if(column==1) {
						Group g=bd.groups.stream().filter((Group a)->a.getNb()==Integer.parseInt(tableGrp.getModel().getValueAt(row, 0).toString())).findAny().orElse(null);
						if (tableGrp.getModel().getValueAt(row, column).toString().equals(Arrays.toString(g.getEtds())))
							tableGrp.getModel().setValueAt(Arrays.toString(g.getEtdsName(bd.etudiants)), row, column);
						else
							tableGrp.getModel().setValueAt(Arrays.toString(g.getEtds()), row, column);
					}
					else if(column==2){
						Group g=bd.groups.stream().filter((Group a)->a.getNb()==Integer.parseInt(tableGrp.getModel().getValueAt(row, 0).toString())).findAny().orElse(null);
						String a=tableGrp.getModel().getValueAt(row,column).toString();
						if(a.matches("\\d+"))
							tableGrp.getModel().setValueAt(bd.enseignants.stream().filter((Enseignant ens)->ens.getCIN().equals(a)).findAny().orElse(null).getFullName(), row, column);
						else
							tableGrp.getModel().setValueAt(g.getEncadreur(),row,column);
					}
				}
			});
			JTableHeader tableHeaderEns=tableGrp.getTableHeader();
			tableHeaderEns.setBackground(new Color(36, 47, 65));
			tableHeaderEns.setForeground(new Color(97, 212, 195));
			tableHeaderEns.setFont(new Font("Century Gothic", Font.BOLD, 16));
			JScrollPane scrollEns=new JScrollPane(tableGrp);
			scrollEns.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			scrollEns.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
			scrollEns.setBackground(new Color(36, 47, 65));
			scrollEns.setFont(new Font("Century Gothic", Font.BOLD, 14));
			scrollEns.setForeground(new Color(36, 47, 65));
			scrollEns.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			scrollEns.setBounds(50, 196, 1000, 300);
			panel.add(scrollEns);
			return panel;
		}
		public static JPanel afficherPfe(){
			JPanel panel = new JPanel();
			panel.setBackground(new Color(36, 47, 65));
			panel.setLayout(null);

			JLabel lblNewLabel_5 = new JLabel("Les PFEs");
			lblNewLabel_5.setForeground(new Color(255, 255, 255));
			lblNewLabel_5.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 22));
			lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_5.setBounds(439, 38, 191, 34);
			panel.add(lblNewLabel_5);

			JSeparator separator_22 = new JSeparator();
			separator_22.setForeground(new Color(255, 255, 255));
			separator_22.setBounds(439, 70, 191, 16);
			panel.add(separator_22);

			JSeparator separator_23 = new JSeparator();
			separator_23.setForeground(new Color(255, 255, 255));
			separator_23.setBounds(460, 84, 154, 16);
			panel.add(separator_23);

			JLabel lblNewLabel_6 = new JLabel("Recherche : ");
			lblNewLabel_6.setForeground(new Color(97, 212, 195));
			lblNewLabel_6.setFont(new Font("Century Gothic", Font.BOLD, 16));
			lblNewLabel_6.setBounds(27, 113, 96, 23);
			panel.add(lblNewLabel_6);

			imprimerPfe = new JButton();
			imprimerPfe.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			imprimerPfe.setText("Imprimer");
			imprimerPfe.setForeground(Color.WHITE);
			imprimerPfe.setIcon(new ImageIcon(Menu.class.getResource("/image/imprimente.png")));
			imprimerPfe.setFont(new Font("Century Gothic", Font.BOLD, 14));
			imprimerPfe.setBackground(new Color(97, 212, 195));
			imprimerPfe.setBounds(500,520,130,50);
			imprimerPfe.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					Document document=new Document(PageSize.A4,5,5,10,10);
					try {
						JFileChooser file=new JFileChooser();
						int x=file.showSaveDialog(contentPane);
						if(x==JFileChooser.APPROVE_OPTION) {
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
								PdfPTable table = new PdfPTable(tablePfe.getColumnCount());
								table.setHeaderRows(1);
								for (int i = 0; i < tablePfe.getColumnCount(); i++) {
									PdfPCell cell = new PdfPCell(new Phrase(tablePfe.getColumnName(i)));
									cell.setBackgroundColor(new GrayColor(0.7f));
									table.addCell(cell);
								}
								for (int i = 0; i < tablePfe.getRowCount(); i++) {
									for (int j = 0; j < tablePfe.getColumnCount(); j++) {
										table.addCell(tablePfe.getModel().getValueAt(i, j).toString());
									}
								}
								document.add(table);
								document.close();
								JOptionPane.showMessageDialog(contentPane, "pdf créer avec succées");
							} catch (Exceptions r) {
								r.exec(file);
							}
						}
					} catch (Exception r){
						JOptionPane.showMessageDialog(contentPane,"vous devez fermer le fichier PDF d'aboard","Erreur",JOptionPane.ERROR_MESSAGE);
					}
				}
			});
			panel.add(imprimerPfe);

			rechPfe = new JTextField();
			rechPfe.setBorder(null);
			rechPfe.setBackground(new Color(36, 47, 65));
			rechPfe.setForeground(new Color(255, 255, 255));
			rechPfe.setFont(new Font("Century Gothic", Font.BOLD, 15));
			rechPfe.setBounds(128, 117, 154, 19);
			rechPfe.addFocusListener(new FocusTextField(rechPfe));
			rechPfe.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					String ch=rechPfe.getText();
					if(ch.isEmpty())
						tablePfe.setModel(new DefaultTableModel(bd.getTable(bd.PFES),bd.PFEHEADER));
					else {
						String motif=(String) rechPfeMotif.getSelectedItem();
						if (motif.equalsIgnoreCase("nom")) {
							ArrayList<Pfe> x = new ArrayList<>();
							for (Pfe i : bd.pfes) {
								if(i.getName().toUpperCase().startsWith(ch.toUpperCase()))
									x.add(i);
							}
							String[][] y = new String[x.size()][3];
							for (int i = 0; i < x.size(); i++) {
								Pfe b = x.get(i);
								y[i][0] = b.getName();
								y[i][1] = Integer.toString(b.getGrp());
								y[i][2] = b.getEncadreur();
							}
							tablePfe.setModel(new DefaultTableModel(y, bd.PFEHEADER));
						}
						else if (motif.equalsIgnoreCase("encadreur")) {
							ArrayList<Pfe> x = new ArrayList<>();
							for (Pfe i : bd.pfes) {
								if (i.getEncadreur().startsWith(ch))
									x.add(i);
							}
							String[][] y = new String[x.size()][3];
							for (int i = 0; i < x.size(); i++) {
								Pfe b = x.get(i);
								y[i][0] = b.getName();
								y[i][1] = Integer.toString(b.getGrp());
								y[i][2] = b.getEncadreur();
							}
							tablePfe.setModel(new DefaultTableModel(y, bd.PFEHEADER));
						}
						else if (motif.equalsIgnoreCase("Group") && ch.matches("\\d+")) {
							ArrayList<Pfe> x = new ArrayList<>();
							for (Pfe i : bd.pfes) {
								if (i.getGrp()==Integer.parseInt(ch))
									x.add(i);
							}
							String[][] y = new String[x.size()][3];
							for (int i = 0; i < x.size(); i++) {
								Pfe b = x.get(i);
								y[i][0] = b.getName();
								y[i][1] = Integer.toString(b.getGrp());
								y[i][2] = b.getEncadreur();
							}
							tablePfe.setModel(new DefaultTableModel(y, bd.PFEHEADER));
						}
					}
				}
			});
			panel.add(rechPfe);
			rechPfe.setColumns(10);

			JSeparator separator_24 = new JSeparator();
			separator_24.setBackground(new Color(97, 212, 195));
			separator_24.setForeground(new Color(97, 212, 195));
			separator_24.setBounds(25, 139, 257, 10);
			panel.add(separator_24);

			rechPfeMotif = new JComboBox();
			rechPfeMotif.setModel(new DefaultComboBoxModel(new String[] {"", "NOM", "GROUP", "ENCADREUR"}));
			rechPfeMotif.setForeground(new Color(255, 255, 255));
			rechPfeMotif.setFont(new Font("Century Gothic", Font.BOLD, 14));
			rechPfeMotif.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			rechPfeMotif.setBackground(new Color(36, 47, 65));
			rechPfeMotif.setBorder(null);
			rechPfeMotif.setBounds(294, 116, 96, 23);
			panel.add(rechPfeMotif);
			tablePfe=new JTable(bd.getTable(bd.PFES),bd.PFEHEADER);
			tablePfe.setForeground(new Color(255, 255, 255));
			tablePfe.setGridColor(new Color(255, 255, 255));
			tablePfe.setBackground(new Color(36, 47, 65));
			tablePfe.setColumnSelectionAllowed(true);
			tablePfe.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			tablePfe.setFont(new Font("Century Gothic", Font.BOLD, 14));
			tablePfe.setRowHeight(30);
			tablePfe.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int row=tablePfe.rowAtPoint(e.getPoint());
					int column=tablePfe.columnAtPoint(e.getPoint());
					if(column==1) {
						Pfe p=bd.pfes.stream().filter((Pfe a)->a.getName().equals(tablePfe.getModel().getValueAt(row, 0).toString())).findAny().orElse(null);
						String grp=tablePfe.getModel().getValueAt(row, column).toString();
						if (grp.matches("\\d+")) {
							tablePfe.getModel().setValueAt(Arrays.toString(bd.groups.stream().filter((Group g)->g.getNb()==Integer.parseInt(grp)).findAny().orElse(null).getEtdsName(bd.etudiants)), row, column);
						}
						else
							tablePfe.getModel().setValueAt(Integer.toString(p.getGrp()), row, column);
					}
					else if(column==2){
						Pfe p=bd.pfes.stream().filter((Pfe a)->a.getName().equals(tablePfe.getModel().getValueAt(row, 0).toString())).findAny().orElse(null);
						String a=tablePfe.getModel().getValueAt(row,column).toString();
						if(a.matches("\\d+"))
							tablePfe.getModel().setValueAt(bd.enseignants.stream().filter((Enseignant ens)->ens.getCIN().equals(a)).findAny().orElse(null).getFullName(), row, column);
						else
							tablePfe.getModel().setValueAt(p.getEncadreur(),row,column);
					}
				}
			});
			JTableHeader tableHeaderEns=tablePfe.getTableHeader();
			tableHeaderEns.setBackground(new Color(36, 47, 65));
			tableHeaderEns.setForeground(new Color(97, 212, 195));
			tableHeaderEns.setFont(new Font("Century Gothic", Font.BOLD, 16));
			JScrollPane scrollEns=new JScrollPane(tablePfe);
			scrollEns.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			scrollEns.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
			scrollEns.setBackground(new Color(36, 47, 65));
			scrollEns.setFont(new Font("Century Gothic", Font.BOLD, 14));
			scrollEns.setForeground(new Color(36, 47, 65));
			scrollEns.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			scrollEns.setBounds(50, 196, 1000, 300);
			panel.add(scrollEns);
			return panel;
		}
		public static JPanel afficherStn(){
			JPanel panel = new JPanel();
			panel.setBackground(new Color(36, 47, 65));
			panel.setLayout(null);

			JLabel lblNewLabel_5 = new JLabel("Les Soutenances");
			lblNewLabel_5.setForeground(new Color(255, 255, 255));
			lblNewLabel_5.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 22));
			lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_5.setBounds(439, 38, 191, 34);
			panel.add(lblNewLabel_5);

			JSeparator separator_22 = new JSeparator();
			separator_22.setForeground(new Color(255, 255, 255));
			separator_22.setBounds(439, 70, 191, 16);
			panel.add(separator_22);

			JSeparator separator_23 = new JSeparator();
			separator_23.setForeground(new Color(255, 255, 255));
			separator_23.setBounds(460, 84, 154, 16);
			panel.add(separator_23);

			JLabel lblNewLabel_6 = new JLabel("Recherche : ");
			lblNewLabel_6.setForeground(new Color(97, 212, 195));
			lblNewLabel_6.setFont(new Font("Century Gothic", Font.BOLD, 16));
			lblNewLabel_6.setBounds(27, 113, 96, 23);
			panel.add(lblNewLabel_6);

			imprimerStn = new JButton();
			imprimerStn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			imprimerStn.setText("Imprimer");
			imprimerStn.setForeground(Color.WHITE);
			imprimerStn.setIcon(new ImageIcon(Menu.class.getResource("/image/imprimente.png")));
			imprimerStn.setFont(new Font("Century Gothic", Font.BOLD, 14));
			imprimerStn.setBackground(new Color(97, 212, 195));
			imprimerStn.setBounds(500,520,130,50);
			imprimerStn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					Document document=new Document(PageSize.A4,0,0,10,10);
					try {
						JFileChooser file=new JFileChooser();
						int x=file.showSaveDialog(contentPane);
						if(x==JFileChooser.APPROVE_OPTION) {
							String path = file.getSelectedFile().getPath();
							try {
								if(file.getSelectedFile().getName().isEmpty()||file.getSelectedFile().getName().contains("."))
									throw new Exceptions("Le nom de fichier ne peut pas etre vide el il ne peut pas admet une '.'");
								PdfWriter.getInstance(document, new FileOutputStream(path + ".pdf"));
								document.open();
								Paragraph p = new Paragraph(file.getSelectedFile().getName(), new com.lowagie.text.Font(com.lowagie.text.Font.getFamilyIndex("TIMES_ROMAN"), 18, com.lowagie.text.Font.BOLD));
								p.setAlignment("center");
								document.add(p);
								document.add(Chunk.NEWLINE);
								PdfPTable table = new PdfPTable(tableStn.getColumnCount());
								table.setHeaderRows(1);
								for (int i = 0; i < tableStn.getColumnCount(); i++) {
									PdfPCell cell = new PdfPCell(new Phrase(tableStn.getColumnName(i)));
									cell.setBackgroundColor(new GrayColor(0.7f));
									table.addCell(cell);
								}
								for (int i = 0; i < tableStn.getRowCount(); i++) {
									for (int j = 0; j < tableStn.getColumnCount(); j++) {
										table.addCell(tableStn.getModel().getValueAt(i, j).toString());
									}
								}
								document.add(table);
								document.close();
								JOptionPane.showMessageDialog(contentPane, "pdf créer avec succées");
							}catch (Exceptions r){
								System.out.println(r.msg);
								r.exec(file);
							}
						}
					} catch (Exception r){
						JOptionPane.showMessageDialog(contentPane,"vous devez fermer le fichier PDF d'aboard","Erreur",JOptionPane.ERROR_MESSAGE);
					}
				}
			});
			panel.add(imprimerStn);

			rechStn = new JTextField();
			rechStn.setBorder(null);
			rechStn.setBackground(new Color(36, 47, 65));
			rechStn.setForeground(new Color(255, 255, 255));
			rechStn.setFont(new Font("Century Gothic", Font.BOLD, 15));
			rechStn.setBounds(128, 117, 154, 19);
			rechStn.addFocusListener(new FocusTextField(rechStn));
			rechStn.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					String ch=rechStn.getText();
					if(ch.isEmpty())
						tableStn.setModel(new DefaultTableModel(bd.getTable(bd.SOUTENANCES),bd.SOUTENANCEHEADER));
					else {
						Date d = null;
						Boolean t=true;
						try {
							SimpleDateFormat f=new SimpleDateFormat("dd/MM/yyyy");
							d=new Date((f.parse(ch)).getTime());
						}catch (Exception r){
							t=false;
						}
						String motif=(String) rechStnMotif.getSelectedItem();
						if (motif.equalsIgnoreCase("date")) {
							ArrayList<Soutenance> x = new ArrayList<>();

							for (Soutenance i : bd.soutenances) {
								if(i.getDate().equals(d))
									x.add(i);
							}
							String[][] y = new String[x.size()][11];
							for (int i = 0; i < x.size(); i++) {
								Soutenance b=x.get(i);
								y[i][0]=b.getDate().toString();
								y[i][1]=Integer.toString(b.getHeure());
								y[i][2]=b.getLocale();
								y[i][3]=b.getPresident();
								y[i][4]=b.getRapporteur();
								y[i][5]=b.getExaminateur();
								y[i][6]=b.getEncadreur()!=null?Arrays.toString(b.getEncadreur()):"{}";
								y[i][7]=Integer.toString(b.getGrp());
								y[i][8]=b.getPfeName();
								y[i][9]=b.getPassee();
								y[i][10]=Double.toString(b.getNote());
							}
							tableStn.setModel(new DefaultTableModel(y, bd.SOUTENANCEHEADER));
						}
						else if (motif.equalsIgnoreCase("group")&&ch.matches("\\d+")) {
							ArrayList<Soutenance> x = new ArrayList<>();
							for (Soutenance i : bd.soutenances) {
								if (i.getGrp()==Integer.parseInt(ch))
									x.add(i);
							}
							String[][] y = new String[x.size()][11];
							for (int i = 0; i < x.size(); i++) {
								Soutenance b=x.get(i);
								y[i][0]=b.getDate().toString();
								y[i][1]=Integer.toString(b.getHeure());
								y[i][2]=b.getLocale();
								y[i][3]=b.getPresident();
								y[i][4]=b.getRapporteur();
								y[i][5]=b.getExaminateur();
								y[i][6]=b.getEncadreur()!=null?Arrays.toString(b.getEncadreur()):"{}";
								y[i][7]=Integer.toString(b.getGrp());
								y[i][8]=b.getPfeName();
								y[i][9]=b.getPassee();
								y[i][10]=Double.toString(b.getNote());
							}
							tableStn.setModel(new DefaultTableModel(y, bd.SOUTENANCEHEADER));
						}
						else if (motif.equalsIgnoreCase("cin") && ch.matches("\\d+")) {
							ArrayList<Soutenance> x = new ArrayList<>();
							for (Soutenance i : bd.soutenances) {
								Boolean k=false;
								for(String j:i.getEncadreur()) {
									if (j.startsWith(ch)) {
										k = true;
										break;
									}
								}
								if (i.getPresident().startsWith(ch)||i.getRapporteur().startsWith(ch)||i.getExaminateur().startsWith(ch)||k)
									x.add(i);
							}
							String[][] y = new String[x.size()][11];
							for (int i = 0; i < x.size(); i++) {
								Soutenance b=x.get(i);
								y[i][0]=b.getDate().toString();
								y[i][1]=Integer.toString(b.getHeure());
								y[i][2]=b.getLocale();
								y[i][3]=b.getPresident();
								y[i][4]=b.getRapporteur();
								y[i][5]=b.getExaminateur();
								y[i][6]=b.getEncadreur()!=null?Arrays.toString(b.getEncadreur()):"{}";
								y[i][7]=Integer.toString(b.getGrp());
								y[i][8]=b.getPfeName();
								y[i][9]=b.getPassee();
								y[i][10]=Double.toString(b.getNote());
							}
							tableStn.setModel(new DefaultTableModel(y, bd.SOUTENANCEHEADER));
						}
						else if (motif.equalsIgnoreCase("heure")&&ch.matches("\\d+")) {
							ArrayList<Soutenance> x = new ArrayList<>();
							for (Soutenance i : bd.soutenances) {
								if (i.getHeure()==Integer.parseInt(ch)) {
									System.out.println(i);
									x.add(i);
								}
							}
							System.out.println(x);
							String[][] y = new String[x.size()][11];
							for (int i = 0; i < x.size(); i++) {
								Soutenance b=x.get(i);
								y[i][0]=b.getDate().toString();
								y[i][1]=Integer.toString(b.getHeure());
								y[i][2]=b.getLocale();
								y[i][3]=b.getPresident();
								y[i][4]=b.getRapporteur();
								y[i][5]=b.getExaminateur();
								y[i][6]=b.getEncadreur()!=null?Arrays.toString(b.getEncadreur()):"{}";
								y[i][7]=Integer.toString(b.getGrp());
								y[i][8]=b.getPfeName();
								y[i][9]=b.getPassee();
								y[i][10]=Double.toString(b.getNote());
							}
							tableStn.setModel(new DefaultTableModel(y, bd.SOUTENANCEHEADER));
						}
						else if (motif.equalsIgnoreCase("etat(v/n/a)")) {
							ArrayList<Soutenance> x = new ArrayList<>();
							if(ch.equalsIgnoreCase("v")) {
								for (Soutenance i : bd.soutenances) {
									if(i.getPassee().startsWith("v"))
										x.add(i);
								}
							}
							else if(ch.equalsIgnoreCase("n")) {
								for (Soutenance i : bd.soutenances) {
									if(i.getPassee().startsWith("n"))
										x.add(i);
								}
							}
							else if(ch.equalsIgnoreCase("a")) {
								for (Soutenance i : bd.soutenances) {
									if(i.getPassee().startsWith("e"))
										x.add(i);
								}
							}
							String[][] y = new String[x.size()][11];
							for (int i = 0; i < x.size(); i++) {
								Soutenance b=x.get(i);
								y[i][0]=b.getDate().toString();
								y[i][1]=Integer.toString(b.getHeure());
								y[i][2]=b.getLocale();
								y[i][3]=b.getPresident();
								y[i][4]=b.getRapporteur();
								y[i][5]=b.getExaminateur();
								y[i][6]=b.getEncadreur()!=null?Arrays.toString(b.getEncadreur()):"{}";
								y[i][7]=Integer.toString(b.getGrp());
								y[i][8]=b.getPfeName();
								y[i][9]=b.getPassee();
								y[i][10]=Double.toString(b.getNote());
							}
							tableStn.setModel(new DefaultTableModel(y, bd.SOUTENANCEHEADER));
						}
						else if(motif.equalsIgnoreCase("locale")){
							ArrayList<Soutenance> x = new ArrayList<>();
							for (Soutenance i : bd.soutenances) {
								if (i.getLocale().toUpperCase().contains(ch.toUpperCase()))
									x.add(i);
							}
							String[][] y = new String[x.size()][11];
							for (int i = 0; i < x.size(); i++) {
								Soutenance b=x.get(i);
								y[i][0]=b.getDate().toString();
								y[i][1]=Integer.toString(b.getHeure());
								y[i][2]=b.getLocale();
								y[i][3]=b.getPresident();
								y[i][4]=b.getRapporteur();
								y[i][5]=b.getExaminateur();
								y[i][6]=b.getEncadreur()!=null?Arrays.toString(b.getEncadreur()):"{}";
								y[i][7]=Integer.toString(b.getGrp());
								y[i][8]=b.getPfeName();
								y[i][9]=b.getPassee();
								y[i][10]=Double.toString(b.getNote());
							}
							tableStn.setModel(new DefaultTableModel(y, bd.SOUTENANCEHEADER));
						}
					}
				}
			});
			panel.add(rechStn);
			rechStn.setColumns(10);

			JSeparator separator_24 = new JSeparator();
			separator_24.setBackground(new Color(97, 212, 195));
			separator_24.setForeground(new Color(97, 212, 195));
			separator_24.setBounds(25, 139, 257, 10);
			panel.add(separator_24);

			rechStnMotif = new JComboBox();
			rechStnMotif.setModel(new DefaultComboBoxModel(new String[] {"", "DATE", "HEURE", "LOCALE","CIN","GROUP","ETAT(V/N/A)"}));
			rechStnMotif.setForeground(new Color(255, 255, 255));
			rechStnMotif.setFont(new Font("Century Gothic", Font.BOLD, 14));
			rechStnMotif.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			rechStnMotif.setBackground(new Color(36, 47, 65));
			rechStnMotif.setBorder(null);
			rechStnMotif.setBounds(294, 116, 96, 23);
			panel.add(rechStnMotif);
			tableStn=new JTable(bd.getTable(bd.SOUTENANCES),bd.SOUTENANCEHEADER);
			tableStn.setForeground(new Color(255, 255, 255));
			tableStn.setGridColor(new Color(255, 255, 255));
			tableStn.setBackground(new Color(36, 47, 65));
			tableStn.setColumnSelectionAllowed(true);
			tableStn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			tableStn.setFont(new Font("Century Gothic", Font.BOLD, 14));
			tableStn.setRowHeight(30);
			tableStn.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int row=tableStn.rowAtPoint(e.getPoint());
					int column=tableStn.columnAtPoint(e.getPoint());
					if(column==7) {
						Soutenance p=bd.soutenances.stream().filter((Soutenance a)-> {
							return compDate(a.getDate().toString(),tableStn.getModel().getValueAt(row, 0).toString())
									&& Integer.toString(a.getHeure()).equals(tableStn.getModel().getValueAt(row, 1).toString())
									&& a.getLocale().equals(tableStn.getModel().getValueAt(row, 2).toString());
						}).findAny().orElse(null);
						String grp=tableStn.getModel().getValueAt(row, column).toString();
						if (grp.matches("\\d+")) {
							tableStn.getModel().setValueAt(Arrays.toString(bd.groups.stream().filter((Group g)->g.getNb()==Integer.parseInt(grp)).findAny().orElse(null).getEtdsName(bd.etudiants)), row, column);
						}
						else
							tableStn.getModel().setValueAt(Integer.toString(p.getGrp()), row, column);
					}
					else if(column==3){
						Soutenance p=bd.soutenances.stream().filter((Soutenance a)-> {
							return compDate(a.getDate().toString(),tableStn.getModel().getValueAt(row, 0).toString())
									&& Integer.toString(a.getHeure()).equals(tableStn.getModel().getValueAt(row, 1).toString())
									&& a.getLocale().equals(tableStn.getModel().getValueAt(row, 2).toString());
						}).findAny().orElse(null);
						String a=tableStn.getModel().getValueAt(row,column).toString();
						if(a.matches("\\d+"))
							tableStn.getModel().setValueAt(bd.enseignants.stream().filter((Enseignant ens)->ens.getCIN().equals(a)).findAny().orElse(null).getFullName(), row, column);
						else
							tableStn.getModel().setValueAt(p.getPresident(),row,column);
					}
					else if(column==4){
						Soutenance p=bd.soutenances.stream().filter((Soutenance a)-> {
							return compDate(a.getDate().toString(),tableStn.getModel().getValueAt(row, 0).toString())
									&& Integer.toString(a.getHeure()).equals(tableStn.getModel().getValueAt(row, 1).toString())
									&& a.getLocale().equals(tableStn.getModel().getValueAt(row, 2).toString());
						}).findAny().orElse(null);
						String a=tableStn.getModel().getValueAt(row,column).toString();
						if(a.matches("\\d+"))
							tableStn.getModel().setValueAt(bd.enseignants.stream().filter((Enseignant ens)->ens.getCIN().equals(a)).findAny().orElse(null).getFullName(), row, column);
						else
							tableStn.getModel().setValueAt(p.getRapporteur(),row,column);
					}
					else if(column==5){
						Soutenance p=bd.soutenances.stream().filter((Soutenance a)-> {
							return compDate(a.getDate().toString(),tableStn.getModel().getValueAt(row, 0).toString())
									&& Integer.toString(a.getHeure()).equals(tableStn.getModel().getValueAt(row, 1).toString())
									&& a.getLocale().equals(tableStn.getModel().getValueAt(row, 2).toString());
						}).findAny().orElse(null);
						String a=tableStn.getModel().getValueAt(row,column).toString();
						if(a.matches("\\d+"))
							tableStn.getModel().setValueAt(bd.enseignants.stream().filter((Enseignant ens)->ens.getCIN().equals(a)).findAny().orElse(null).getFullName(), row, column);
						else
							tableStn.getModel().setValueAt(p.getExaminateur(),row,column);
					}
					if(column==6) {
						Soutenance p=bd.soutenances.stream().filter((Soutenance a)-> {
							return compDate(a.getDate().toString(),tableStn.getModel().getValueAt(row, 0).toString())
									&& Integer.toString(a.getHeure()).equals(tableStn.getModel().getValueAt(row, 1).toString())
									&& a.getLocale().equals(tableStn.getModel().getValueAt(row, 2).toString());
						}).findAny().orElse(null);
						if (tableStn.getModel().getValueAt(row, column).toString().equals(Arrays.toString(p.getEncadreur())))
							tableStn.getModel().setValueAt(Arrays.toString(p.getEncadreursNames(bd.enseignants)), row, column);
						else
							tableStn.getModel().setValueAt(Arrays.toString(p.getEncadreur()), row, column);
					}
				}
			});
			JTableHeader tableHeaderEns=tableStn.getTableHeader();
			tableHeaderEns.setBackground(new Color(36, 47, 65));
			tableHeaderEns.setForeground(new Color(97, 212, 195));
			tableHeaderEns.setFont(new Font("Century Gothic", Font.BOLD, 16));
			JScrollPane scrollEns=new JScrollPane(tableStn);
			scrollEns.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			scrollEns.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
			scrollEns.setBackground(new Color(36, 47, 65));
			scrollEns.setFont(new Font("Century Gothic", Font.BOLD, 14));
			scrollEns.setForeground(new Color(36, 47, 65));
			scrollEns.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			scrollEns.setBounds(50, 196, 1000, 300);
			panel.add(scrollEns);
			return panel;
		}
	}
	public static boolean checkDate(String ch){
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

	public static boolean compDate(String d1, String d2){
		String[]t1=d1.split("-");
		String[]t2=d2.split("/");
		for(int i=0;i<3;i++)
			if(!t1[i].equals(t2[2-i]))
				return false;
		return true;
	}
}
