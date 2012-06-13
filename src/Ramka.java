
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.rmi.RemoteException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.alcatel.ServerHTTP.AlcEventsRessource;
import com.alcatel.ServerHTTP.ServerHttp;
import com.alcatel.xmlapi.common.AlcServiceException;
import com.alcatel.xmlapi.phone.Call;
import com.alcatel.xmlapi.phone.MakeCallInvoke;
import com.alcatel.xmlapi.phone.NomadMode;
import com.alcatel.xmlapi.phone.XmlPhoneEvents;
import com.alcatel.xmlapi.phonesetprogramming.types.AlcForwardTargetType;
import com.alcatel.xmlapi.phonesetprogramming.types.AlcForwardType;
import com.alcatel.xmlapi.phonesetprogramming.types.AlcOverflowType;
import com.alcatel.xmlapi.phonesetprogramming.types.AlcStaticState;
import javax.swing.JTable;
import javax.swing.SwingConstants;

//stworzenie glownej ramki oraz zdefiniowanie operacji zwiazanej z konkretnym Web Serwisem 
public class Ramka extends JFrame implements XmlPhoneEvents, WindowListener, ActionListener  
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JMenuBar pasekMenu;
	private JMenu menuProgram;
	private JMenuItem menuProgramZaloguj, menuProgramWyloguj, menuProgramZakoncz;
	
	
	private GridBagConstraints gbc;
	
	private Loging log;
//	private XmlPhoneSetProgramming xmlPhoneSetProgramming=null;
	private JSeparator separator;	
	private JLabel lblStatus;
	private JSeparator separator_1;
	private JLabel label;
	private JLabel label_1;
	private JLabel lblNumeryWewntrzne;
	private JSeparator separator_2;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel labelStatus;
	private JLabel label_4;
	private JLabel lblDyrektorDrzymaa;
	private JLabel label_5;
	private JLabel lblDepartamentHr;
	private JLabel label_6;
	private JLabel label_7;;
	private JTextField textField;
	private JButton btnCall;
	private JLabel lblLoggedIn;
	private JMenuItem menuProgramNrTelefonu;
	private JMenu menuOptions;
	private JLabel lblDziaReklamacji;
	private JLabel label_8;

	//--------------OBIEKTTY LOGIKI APLIKACJI ----------------------------------
			
	private Vector telephones ;
	
	private Telephone acctualTele;
	private JLabel lblNumerTelefonu;
	private JLabel lblNazwa;
	private JLabel lblIloOdebranychPocze;
	private JLabel lblStan;
	private JLabel lblDodatkoweInformacje;
	private JLabel lblLblszefnr;
	private JLabel lblLblhrnr;
	private JLabel lblLblreknr;
	private JLabel lblLblreknr_1;
	private JLabel lblLblszefname;
	private JLabel lblLblszefilpol;
	private JLabel lblLblszefstate;
	private JLabel lblLblszefmore;
	private JLabel lblLblhrname;
	private JLabel lblLblhrilpol;
	private JLabel lblLblhrstate;
	private JLabel lblLblhrmore;
	private JLabel lblLblrekname;
	private JLabel lblLblrekilpol;
	private JLabel lblLblrekstate;
	private JLabel lblLblrekmore;
	private JLabel lblLblrekname_1;
	private JLabel lblLblrekilpol_1;
	private JLabel lblLblrekstate_1;
	private JLabel lblLblrekmore_1;
	private JSeparator separator_3;
	private JLabel label_9;
	private JSeparator separator_4;
	private JSeparator separator_5;
	private JSeparator separator_6;
	private JSeparator separator_7;
	private JSeparator separator_8;
	private JSeparator separator_9;
	private JSeparator separator_10;
	private JSeparator separator_11;
	private JLabel label_10;
	private JLabel emptylabel1;
	//inicjalizacja modulu logowania i wylogowywania oraz stworzenie GUI
    public Ramka() 
    {
    	//----------------------GRAFIKA--------------------------------------
    	//wlasciwosci ramki
    	addWindowListener(this);
		setTitle("Stan polaczenia");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(900, 458);
		setVisible(true);
    	    	
    	//GUI
    	gbc = new GridBagConstraints();
		gbc.insets = new Insets(0, 5, 5, 5);
		
		//Menu
		pasekMenu = new JMenuBar();
		setJMenuBar(pasekMenu);
		
		menuProgram = new JMenu("Program");
		pasekMenu.add(menuProgram);
		
		menuProgramZaloguj = new JMenuItem("Login");
		menuProgram.add(menuProgramZaloguj);
		
		menuProgramWyloguj = new JMenuItem("Logout");
		menuProgram.add(menuProgramWyloguj);
		
		menuOptions = new JMenu("Options");
		pasekMenu.add(menuOptions);
				
		menuProgramNrTelefonu = new JMenuItem("Phone nr");
		menuOptions.add(menuProgramNrTelefonu);
		
		separator = new JSeparator();
		menuProgram.add(separator);
		
		menuProgramZakoncz = new JMenuItem("Exit");
		menuProgram.add(menuProgramZakoncz);
		
		menuProgramZaloguj.addActionListener(this);
		menuProgramWyloguj.addActionListener(this);
		menuProgramZakoncz.addActionListener(this);

		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 3;
		gbc.anchor = GridBagConstraints.CENTER;
		
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JPanel panel_2 = new JPanel();
		panel_2.setPreferredSize(new Dimension(700,600));
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 0, 5);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 0;
		getContentPane().add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 29};
		gbl_panel_2.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0};
		panel_2.setLayout(gbl_panel_2);
		
		emptylabel1 = new JLabel("                    ");
		GridBagConstraints gbc_lblEmptylabel = new GridBagConstraints();
		gbc_lblEmptylabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmptylabel.gridx = 0;
		gbc_lblEmptylabel.gridy = 0;
		panel_2.add(emptylabel1, gbc_lblEmptylabel);
		
		lblStatus = new JLabel("Status");
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblStatus = new GridBagConstraints();
		gbc_lblStatus.gridwidth = 11;
		gbc_lblStatus.insets = new Insets(0, 0, 5, 5);
		gbc_lblStatus.gridx = 3;
		gbc_lblStatus.gridy = 1;
		panel_2.add(lblStatus, gbc_lblStatus);
		
		separator_1 = new JSeparator();
		separator_1.setBackground(Color.BLACK);
		separator_1.setForeground(Color.BLACK);
		GridBagConstraints gbc_separator_1 = new GridBagConstraints();
		gbc_separator_1.fill = GridBagConstraints.BOTH;
		gbc_separator_1.gridwidth = 17;
		gbc_separator_1.insets = new Insets(0, 0, 5, 5);
		gbc_separator_1.gridx = 3;
		gbc_separator_1.gridy = 2;
		panel_2.add(separator_1, gbc_separator_1);
		
		label_7 = new JLabel("                                                                     ");
		GridBagConstraints gbc_label_7 = new GridBagConstraints();
		gbc_label_7.gridwidth = 11;
		gbc_label_7.insets = new Insets(0, 0, 5, 5);
		gbc_label_7.gridx = 9;
		gbc_label_7.gridy = 3;
		panel_2.add(label_7, gbc_label_7);
		
		label = new JLabel("            ");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 0);
		gbc_label.gridx = 22;
		gbc_label.gridy = 3;
		panel_2.add(label, gbc_label);
		
		labelStatus = new JLabel("Waiting for call...");
		GridBagConstraints gbc_lblWaitingForCall = new GridBagConstraints();
		gbc_lblWaitingForCall.anchor = GridBagConstraints.WEST;
		gbc_lblWaitingForCall.gridwidth = 17;
		gbc_lblWaitingForCall.insets = new Insets(0, 0, 5, 5);
		gbc_lblWaitingForCall.gridx = 3;
		gbc_lblWaitingForCall.gridy = 4;
		panel_2.add(labelStatus, gbc_lblWaitingForCall);
		
		label_6 = new JLabel("    ");
		GridBagConstraints gbc_label_6 = new GridBagConstraints();
		gbc_label_6.insets = new Insets(0, 0, 5, 5);
		gbc_label_6.gridx = 21;
		gbc_label_6.gridy = 4;
		panel_2.add(label_6, gbc_label_6);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 6;
		gbc_textField.insets = new Insets(8, 0, 5, 100);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 3;
		gbc_textField.gridy = 5;
		panel_2.add(textField, gbc_textField);
		textField.setColumns(10);
		
		textField.getDocument().addDocumentListener(
				new DocumentListener() {
					public void changedUpdate(DocumentEvent e) {
						btnCall.setEnabled(true);
					}

					public void removeUpdate(DocumentEvent e) {
						if (!textField.getText().isEmpty())
							btnCall.setEnabled(true);
						else
							btnCall.setEnabled(false);
					}

					public void insertUpdate(DocumentEvent e) {
						btnCall.setEnabled(true);
					}
				});
		
		btnCall = new JButton("Call");
		GridBagConstraints gbc_btnCall = new GridBagConstraints();
		gbc_btnCall.gridwidth = 3;
		gbc_btnCall.insets = new Insets(0, 0, 200, 5);
		gbc_btnCall.gridx = 3;
		gbc_btnCall.gridy = 6;
		btnCall.setEnabled(false);
		btnCall.addActionListener(this);
		panel_2.add(btnCall, gbc_btnCall);
		
		separator_10 = new JSeparator();
		separator_10.setBackground(Color.BLACK);
		separator_10.setForeground(Color.BLACK);
		GridBagConstraints gbc_separator_10 = new GridBagConstraints();
		gbc_separator_10.insets = new Insets(0, 5, 0, 0);
		gbc_separator_10.gridwidth = 12;
		gbc_separator_10.fill = GridBagConstraints.BOTH;
		gbc_separator_10.gridx = 2;
		gbc_separator_10.gridy = 7;
		panel_2.add(separator_10, gbc_separator_10);
		
		separator_8 = new JSeparator();
		separator_8.setOrientation(SwingConstants.VERTICAL);
		separator_8.setForeground(Color.BLACK);
		separator_8.setBackground(Color.BLACK);
		GridBagConstraints gbc_separator_8 = new GridBagConstraints();
		gbc_separator_8.fill = GridBagConstraints.BOTH;
		gbc_separator_8.gridheight = 6;
		gbc_separator_8.gridx = 14;
		gbc_separator_8.gridy = 8;
		panel_2.add(separator_8, gbc_separator_8);
		
		label_10 = new JLabel("       ");
		GridBagConstraints gbc_label_10 = new GridBagConstraints();
		gbc_label_10.insets = new Insets(0, 0, 5, 5);
		gbc_label_10.gridx = 15;
		gbc_label_10.gridy = 8;
		panel_2.add(label_10, gbc_label_10);
		
		separator_11 = new JSeparator();
		separator_11.setBackground(Color.BLACK);
		separator_11.setForeground(Color.BLACK);
		GridBagConstraints gbc_separator_11 = new GridBagConstraints();
		gbc_separator_11.gridwidth = 12;
		gbc_separator_11.fill = GridBagConstraints.BOTH;
		gbc_separator_11.insets = new Insets(0, 5, 0, 0);
		gbc_separator_11.gridx = 2;
		gbc_separator_11.gridy = 14;
		panel_2.add(separator_11, gbc_separator_11);
		
		separator_9 = new JSeparator();
		separator_9.setBackground(Color.BLACK);
		separator_9.setForeground(Color.BLACK);
		separator_9.setOrientation(SwingConstants.VERTICAL);
		GridBagConstraints gbc_separator_9 = new GridBagConstraints();
		gbc_separator_9.gridheight = 6;
		gbc_separator_9.fill = GridBagConstraints.BOTH;
		gbc_separator_9.insets = new Insets(0, 5, 0, 5);
		gbc_separator_9.gridx = 2;
		gbc_separator_9.gridy = 8;
		panel_2.add(separator_9, gbc_separator_9);
		
		lblNumerTelefonu = new JLabel("Numer telefonu");
		GridBagConstraints gbc_lblNumerTelefonu = new GridBagConstraints();
		gbc_lblNumerTelefonu.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumerTelefonu.gridx = 5;
		gbc_lblNumerTelefonu.gridy = 8;
		panel_2.add(lblNumerTelefonu, gbc_lblNumerTelefonu);
		
		separator_4 = new JSeparator();
		separator_4.setOrientation(SwingConstants.VERTICAL);
		separator_4.setBackground(Color.BLACK);
		separator_4.setForeground(Color.BLACK);
		GridBagConstraints gbc_separator_4 = new GridBagConstraints();
		gbc_separator_4.fill = GridBagConstraints.BOTH;
		gbc_separator_4.insets = new Insets(0, 5, 0, 5);
		gbc_separator_4.gridx = 6;
		gbc_separator_4.gridy = 8;
		gbc_separator_4.gridheight=6;
		panel_2.add(separator_4, gbc_separator_4);
		
		lblNazwa = new JLabel("Nazwa");
		GridBagConstraints gbc_lblNazwa = new GridBagConstraints();
		gbc_lblNazwa.insets = new Insets(0, 0, 5, 5);
		gbc_lblNazwa.gridx = 7;
		gbc_lblNazwa.gridy = 8;
		panel_2.add(lblNazwa, gbc_lblNazwa);
		
		separator_5 = new JSeparator();
		separator_5.setOrientation(SwingConstants.VERTICAL);
		separator_5.setForeground(Color.BLACK);
		separator_5.setBackground(Color.BLACK);
		GridBagConstraints gbc_separator_5 = new GridBagConstraints();
		gbc_separator_5.gridheight = 6;
		gbc_separator_5.fill = GridBagConstraints.BOTH;
		gbc_separator_5.insets = new Insets(0,5, 0, 5);
		gbc_separator_5.gridx = 8;
		gbc_separator_5.gridy = 8;
		panel_2.add(separator_5, gbc_separator_5);
		
		lblIloOdebranychPocze = new JLabel("Ilo\u015B\u0107 odebranych po\u0142\u0105cze\u0144");
		GridBagConstraints gbc_lblIloOdebranychPocze = new GridBagConstraints();
		gbc_lblIloOdebranychPocze.insets = new Insets(0, 0, 5, 5);
		gbc_lblIloOdebranychPocze.gridx = 9;
		gbc_lblIloOdebranychPocze.gridy = 8;
		panel_2.add(lblIloOdebranychPocze, gbc_lblIloOdebranychPocze);
		
		separator_6 = new JSeparator();
		separator_6.setOrientation(SwingConstants.VERTICAL);
		separator_6.setBackground(Color.BLACK);
		separator_6.setForeground(Color.BLACK);
		GridBagConstraints gbc_separator_6 = new GridBagConstraints();
		gbc_separator_6.gridheight = 6;
		gbc_separator_6.fill = GridBagConstraints.BOTH;
		gbc_separator_6.insets = new Insets(0, 5, 0, 5);
		gbc_separator_6.gridx = 10;
		gbc_separator_6.gridy = 8;
		panel_2.add(separator_6, gbc_separator_6);
		
		lblStan = new JLabel("Stan");
		GridBagConstraints gbc_lblStan = new GridBagConstraints();
		gbc_lblStan.insets = new Insets(0, 0, 5, 5);
		gbc_lblStan.gridx = 11;
		gbc_lblStan.gridy = 8;
		panel_2.add(lblStan, gbc_lblStan);
		
		separator_7 = new JSeparator();
		separator_7.setBackground(Color.BLACK);
		separator_7.setForeground(Color.BLACK);
		separator_7.setOrientation(SwingConstants.VERTICAL);
		GridBagConstraints gbc_separator_7 = new GridBagConstraints();
		gbc_separator_7.fill = GridBagConstraints.BOTH;
		gbc_separator_7.gridheight = 6;
		gbc_separator_7.insets = new Insets(0, 5, 0, 5);
		gbc_separator_7.gridx = 12;
		gbc_separator_7.gridy = 8;
		panel_2.add(separator_7, gbc_separator_7);
		
		lblDodatkoweInformacje = new JLabel("Dodatkowe informacje");
		GridBagConstraints gbc_lblDodatkoweInformacje = new GridBagConstraints();
		gbc_lblDodatkoweInformacje.insets = new Insets(0, 0, 5, 0);
		gbc_lblDodatkoweInformacje.gridx = 13;
		gbc_lblDodatkoweInformacje.gridy = 8;
		panel_2.add(lblDodatkoweInformacje, gbc_lblDodatkoweInformacje);
		
		separator_3 = new JSeparator();
		separator_3.setBackground(Color.BLACK);
		separator_3.setForeground(Color.BLACK);
		GridBagConstraints gbc_separator_3 = new GridBagConstraints();
		gbc_separator_3.fill = GridBagConstraints.BOTH;
		gbc_separator_3.gridwidth = 12;
		gbc_separator_3.insets = new Insets(0, 5, 0, 0);
		gbc_separator_3.gridx = 2;
		gbc_separator_3.gridy = 9;
		panel_2.add(separator_3, gbc_separator_3);
		
		lblLblszefnr = new JLabel("lbl_szef_nr");
		GridBagConstraints gbc_lblLblszefnr = new GridBagConstraints();
		gbc_lblLblszefnr.insets = new Insets(0, 0, 5, 5);
		gbc_lblLblszefnr.gridx = 5;
		gbc_lblLblszefnr.gridy = 10;
		panel_2.add(lblLblszefnr, gbc_lblLblszefnr);
		
		lblLblszefname = new JLabel("lbl_szef_name");
		GridBagConstraints gbc_lblLblszefname = new GridBagConstraints();
		gbc_lblLblszefname.insets = new Insets(0, 0, 5, 5);
		gbc_lblLblszefname.gridx = 7;
		gbc_lblLblszefname.gridy = 10;
		panel_2.add(lblLblszefname, gbc_lblLblszefname);
		
		lblLblszefilpol = new JLabel("lbl_szef_il_pol");
		GridBagConstraints gbc_lblLblszefilpol = new GridBagConstraints();
		gbc_lblLblszefilpol.insets = new Insets(0, 0, 5, 5);
		gbc_lblLblszefilpol.gridx = 9;
		gbc_lblLblszefilpol.gridy = 10;
		panel_2.add(lblLblszefilpol, gbc_lblLblszefilpol);
		
		lblLblszefstate = new JLabel("lbl_szef_state");
		GridBagConstraints gbc_lblLblszefstate = new GridBagConstraints();
		gbc_lblLblszefstate.insets = new Insets(0, 0, 5, 5);
		gbc_lblLblszefstate.gridx = 11;
		gbc_lblLblszefstate.gridy = 10;
		panel_2.add(lblLblszefstate, gbc_lblLblszefstate);
		
		lblLblszefmore = new JLabel("lbl_szef_more");
		GridBagConstraints gbc_lblLblszefmore = new GridBagConstraints();
		gbc_lblLblszefmore.insets = new Insets(0, 0, 5, 0);
		gbc_lblLblszefmore.gridx = 13;
		gbc_lblLblszefmore.gridy = 10;
		panel_2.add(lblLblszefmore, gbc_lblLblszefmore);
		
		lblLblhrnr = new JLabel("lbl_hr_nr");
		GridBagConstraints gbc_lblLblhrnr = new GridBagConstraints();
		gbc_lblLblhrnr.insets = new Insets(0, 0, 5, 5);
		gbc_lblLblhrnr.gridx = 5;
		gbc_lblLblhrnr.gridy = 11;
		panel_2.add(lblLblhrnr, gbc_lblLblhrnr);
		
		lblLblhrname = new JLabel("lbl_hr_name");
		GridBagConstraints gbc_lblLblhrname = new GridBagConstraints();
		gbc_lblLblhrname.insets = new Insets(0, 0, 5, 5);
		gbc_lblLblhrname.gridx = 7;
		gbc_lblLblhrname.gridy = 11;
		panel_2.add(lblLblhrname, gbc_lblLblhrname);
		
		lblLblhrilpol = new JLabel("lbl_hr_il_pol");
		GridBagConstraints gbc_lblLblhrilpol = new GridBagConstraints();
		gbc_lblLblhrilpol.insets = new Insets(0, 0, 5, 5);
		gbc_lblLblhrilpol.gridx = 9;
		gbc_lblLblhrilpol.gridy = 11;
		panel_2.add(lblLblhrilpol, gbc_lblLblhrilpol);
		
		lblLblhrstate = new JLabel("lbl_hr_state");
		GridBagConstraints gbc_lblLblhrstate = new GridBagConstraints();
		gbc_lblLblhrstate.insets = new Insets(0, 0, 5, 5);
		gbc_lblLblhrstate.gridx = 11;
		gbc_lblLblhrstate.gridy = 11;
		panel_2.add(lblLblhrstate, gbc_lblLblhrstate);
		
		lblLblhrmore = new JLabel("lbl_hr_more");
		GridBagConstraints gbc_lblLblhrmore = new GridBagConstraints();
		gbc_lblLblhrmore.insets = new Insets(0, 0, 5, 0);
		gbc_lblLblhrmore.gridx = 13;
		gbc_lblLblhrmore.gridy = 11;
		panel_2.add(lblLblhrmore, gbc_lblLblhrmore);
		
		lblLblreknr = new JLabel("lbl_rek1_nr");
		GridBagConstraints gbc_lblLblreknr = new GridBagConstraints();
		gbc_lblLblreknr.insets = new Insets(0, 0, 5, 5);
		gbc_lblLblreknr.gridx = 5;
		gbc_lblLblreknr.gridy = 12;
		panel_2.add(lblLblreknr, gbc_lblLblreknr);
		
		lblLblrekname = new JLabel("lbl_rek1_name");
		GridBagConstraints gbc_lblLblrekname = new GridBagConstraints();
		gbc_lblLblrekname.insets = new Insets(0, 0, 5, 5);
		gbc_lblLblrekname.gridx = 7;
		gbc_lblLblrekname.gridy = 12;
		panel_2.add(lblLblrekname, gbc_lblLblrekname);
		
		lblLblrekilpol = new JLabel("lbl_rek1_il_pol");
		GridBagConstraints gbc_lblLblrekilpol = new GridBagConstraints();
		gbc_lblLblrekilpol.insets = new Insets(0, 0, 5, 5);
		gbc_lblLblrekilpol.gridx = 9;
		gbc_lblLblrekilpol.gridy = 12;
		panel_2.add(lblLblrekilpol, gbc_lblLblrekilpol);
		
		lblLblrekstate = new JLabel("lbl_rek1_state");
		GridBagConstraints gbc_lblLblrekstate = new GridBagConstraints();
		gbc_lblLblrekstate.insets = new Insets(0, 0, 5, 5);
		gbc_lblLblrekstate.gridx = 11;
		gbc_lblLblrekstate.gridy = 12;
		panel_2.add(lblLblrekstate, gbc_lblLblrekstate);
		
		lblLblrekmore = new JLabel("lbl_rek1_more");
		GridBagConstraints gbc_lblLblrekmore = new GridBagConstraints();
		gbc_lblLblrekmore.insets = new Insets(0, 0, 5, 0);
		gbc_lblLblrekmore.gridx = 13;
		gbc_lblLblrekmore.gridy = 12;
		panel_2.add(lblLblrekmore, gbc_lblLblrekmore);
		
		lblLblreknr_1 = new JLabel("lbl_rek2_nr");
		GridBagConstraints gbc_lblLblreknr_1 = new GridBagConstraints();
		gbc_lblLblreknr_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblLblreknr_1.gridx = 5;
		gbc_lblLblreknr_1.gridy = 13;
		panel_2.add(lblLblreknr_1, gbc_lblLblreknr_1);
		
		lblLblrekname_1 = new JLabel("lbl_rek2_name");
		GridBagConstraints gbc_lblLblrekname_1 = new GridBagConstraints();
		gbc_lblLblrekname_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblLblrekname_1.gridx = 7;
		gbc_lblLblrekname_1.gridy = 13;
		panel_2.add(lblLblrekname_1, gbc_lblLblrekname_1);
		
		lblLblrekilpol_1 = new JLabel("lbl_rek2_il_pol");
		GridBagConstraints gbc_lblLblrekilpol_1 = new GridBagConstraints();
		gbc_lblLblrekilpol_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblLblrekilpol_1.gridx = 9;
		gbc_lblLblrekilpol_1.gridy = 13;
		panel_2.add(lblLblrekilpol_1, gbc_lblLblrekilpol_1);
		
		lblLblrekstate_1 = new JLabel("lbl_rek2_state");
		GridBagConstraints gbc_lblLblrekstate_1 = new GridBagConstraints();
		gbc_lblLblrekstate_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblLblrekstate_1.gridx = 11;
		gbc_lblLblrekstate_1.gridy = 13;
		panel_2.add(lblLblrekstate_1, gbc_lblLblrekstate_1);
		
		lblLblrekmore_1 = new JLabel("lbl_rek2_more");
		GridBagConstraints gbc_lblLblrekmore_1 = new GridBagConstraints();
		gbc_lblLblrekmore_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblLblrekmore_1.gridx = 13;
		gbc_lblLblrekmore_1.gridy = 13;
		panel_2.add(lblLblrekmore_1, gbc_lblLblrekmore_1);
		
		label_9 = new JLabel("        ");
		GridBagConstraints gbc_label_9 = new GridBagConstraints();
		gbc_label_9.insets = new Insets(0, 0, 0, 5);
		gbc_label_9.gridx = 5;
		gbc_label_9.gridy = 15;
		panel_2.add(label_9, gbc_label_9);
		
		JPanel panel_1 = new JPanel();
		panel_1.setPreferredSize(new Dimension(300,600));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 0;
		getContentPane().add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		label_1 = new JLabel("          ");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 0;
		panel_1.add(label_1, gbc_label_1);
		
		lblNumeryWewntrzne = new JLabel("Numery wewn\u0119trzne");
		lblNumeryWewntrzne.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblNumeryWewntrzne = new GridBagConstraints();
		gbc_lblNumeryWewntrzne.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumeryWewntrzne.gridx = 2;
		gbc_lblNumeryWewntrzne.gridy = 1;
		panel_1.add(lblNumeryWewntrzne, gbc_lblNumeryWewntrzne);
		
		separator_2 = new JSeparator();
		separator_2.setForeground(Color.BLACK);
		separator_2.setBackground(Color.BLACK);
		GridBagConstraints gbc_separator_2 = new GridBagConstraints();
		gbc_separator_2.gridwidth = 3;
		gbc_separator_2.insets = new Insets(0, 0, 5, 5);
		gbc_separator_2.fill = GridBagConstraints.BOTH;
		gbc_separator_2.gridx = 1;
		gbc_separator_2.gridy = 2;
		panel_1.add(separator_2, gbc_separator_2);
		
		label_3 = new JLabel("   ");
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 3;
		gbc_label_3.gridy = 3;
		panel_1.add(label_3, gbc_label_3);
		
		label_2 = new JLabel("    ");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.insets = new Insets(0, 0, 5, 0);
		gbc_label_2.gridx = 4;
		gbc_label_2.gridy = 3;
		panel_1.add(label_2, gbc_label_2);
		
		label_4 = new JLabel("1");
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.anchor = GridBagConstraints.WEST;
		gbc_label_4.insets = new Insets(0, 0, 5, 5);
		gbc_label_4.gridx = 1;
		gbc_label_4.gridy = 4;
		panel_1.add(label_4, gbc_label_4);
		
		lblDyrektorDrzymaa = new JLabel("Dyrektor Drzyma\u0142a");
		GridBagConstraints gbc_lblDyrektorDrzymaa = new GridBagConstraints();
		gbc_lblDyrektorDrzymaa.anchor = GridBagConstraints.WEST;
		gbc_lblDyrektorDrzymaa.insets = new Insets(0, 0, 5, 5);
		gbc_lblDyrektorDrzymaa.gridx = 2;
		gbc_lblDyrektorDrzymaa.gridy = 4;
		panel_1.add(lblDyrektorDrzymaa, gbc_lblDyrektorDrzymaa);
		
		label_5 = new JLabel("2");
		GridBagConstraints gbc_label_5 = new GridBagConstraints();
		gbc_label_5.anchor = GridBagConstraints.WEST;
		gbc_label_5.insets = new Insets(0, 0, 5, 5);
		gbc_label_5.gridx = 1;
		gbc_label_5.gridy = 5;
		panel_1.add(label_5, gbc_label_5);
		
		label_8 = new JLabel("3");
		GridBagConstraints gbc_label_8 = new GridBagConstraints();
		gbc_label_8.anchor = GridBagConstraints.WEST;
		gbc_label_8.insets = new Insets(0, 0, 5, 5);
		gbc_label_8.gridx = 1;
		gbc_label_8.gridy = 6;
		panel_1.add(label_8, gbc_label_8);
		
		lblDepartamentHr = new JLabel("Departament HR");
		GridBagConstraints gbc_lblDepartamentHr = new GridBagConstraints();
		gbc_lblDepartamentHr.anchor = GridBagConstraints.WEST;
		gbc_lblDepartamentHr.insets = new Insets(0, 0, 5, 5);
		gbc_lblDepartamentHr.gridx = 2;
		gbc_lblDepartamentHr.gridy = 5;
		panel_1.add(lblDepartamentHr, gbc_lblDepartamentHr);
		
		lblDziaReklamacji = new JLabel("Departament Reklamacji");
		GridBagConstraints gbc_lblDziaReklamacji = new GridBagConstraints();
		gbc_lblDziaReklamacji.anchor = GridBagConstraints.WEST;
		gbc_lblDziaReklamacji.insets = new Insets(0, 0, 5, 5);
		gbc_lblDziaReklamacji.gridx = 2;
		gbc_lblDziaReklamacji.gridy = 6;
		panel_1.add(lblDziaReklamacji, gbc_lblDziaReklamacji);
		
		JPanel panel_3 = new JPanel();
		panel_3.setPreferredSize(new Dimension(50, 25));
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 0, 5);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 1;
		gbc_panel_3.gridwidth = 2;
		getContentPane().add(panel_3, gbc_panel_3);
		
		
		lblLoggedIn = new JLabel("Not logged in");
		lblLoggedIn.setForeground(Color.RED);
		lblLoggedIn.setFont(new Font("Tahoma",Font.BOLD,14));
		
		panel_3.add(lblLoggedIn);

		//----------------------GRAFIKA--------------------------------------
		//----------------------LOGIKA APLIKACJI--------------------------------------
		// Creation of the instance of ServerHttp
    	
		ServerHttp lServerHttp = ServerHttp.instance(CallProperties.NOTIF_SERV_PORT);
		
		// creation of event ressource
		AlcEventsRessource lEventsRessource = new AlcEventsRessource(this, CallProperties.EVENT_CONTEXT);
		
		// Logowanie sekretarki
		log= new Loging("user" + CallProperties.SECRETARY_NUM, "123");
		//logowanie pozostalych numerów
		initializedTelephones();
		emptylabel1.setText("                    ");
	}
    






	//przypisanie przyciskom konkretnych akcji
    public void actionPerformed(ActionEvent zdarzenie) 
    {
    	System.out.println("\nDB zdarzenie : " + zdarzenie.getActionCommand());
		if (zdarzenie.getActionCommand().equals("Login")){
			log.logIn(CallProperties.getNotifUrl());
			logInTelephones();			
			//TODO dorobic logike logowania
			boolean isLogged = true;
			if (isLogged) {
				lblLoggedIn.setForeground(Color.GREEN);
				lblLoggedIn.setText("Logged in");
			}
			System.out.println("\nDB po zdarzeniu : " + zdarzenie.getActionCommand());
			System.out.println("session id of sekretarrka is" +log.getAlr().getSessionId());
		}
		else if (zdarzenie.getActionCommand().equals("Call")) {
			System.out.println("Wcisnales Call");
			if(textField.getText().matches("\\d")){
				
				String number = textField.getText();
				if(number.contentEquals("1")){
					//SZEF
					System.out.println("Naciśnięto 1");
					acctualTele= findTelephone(CallProperties.SZEF_NUM);
					if(acctualTele.getState().equals(CallProperties.TELE_BUSY)){
						this.labelStatus.setText(acctualTele.getName()+" jest zajęty przykro mi");
						acctualTele=null;
					}
					
				}
				else if(number.contentEquals("2")){
				//HR
					System.out.println("Naciśnięto 2");
					acctualTele= findTelephone(CallProperties.HR_NUM);
					if(acctualTele.getState().equals(CallProperties.TELE_BUSY)){
						this.labelStatus.setText(acctualTele.getName()+"  jest zajęty przykro mi");
						acctualTele=null;
					}
					
				}
				else if(number.contentEquals("3")){
				//REKLAMACJA
					Telephone [] nr = new Telephone[2];
					nr[0]=findTelephone(CallProperties.REKLAMACJA_1_NUM);
					nr[1]=findTelephone(CallProperties.REKLAMACJA_2_NUM);
					acctualTele=  getRarelyUsedNumberAndFree(nr);
					if(acctualTele==null){
						this.labelStatus.setText("Wszyscy z dzialu reklamacji są zajęci");
					}
				}else{
					acctualTele= null;
					this.labelStatus.setText("This number is not used, choose diffrent");
				}
				
				
				if(acctualTele!=null){
					System.out.println("transfer call nr is =" + acctualTele);
					this.labelStatus.setText("Trying to transfer call to: "+acctualTele);
					try {
						System.out.println("session id of sekretarrka is" +log.getAlr().getSessionId());
						log.getXmlPhoneSerwis().holdCurrentCall(log.getAlr().getSessionId());
						log.getXmlPhoneSerwis().holdCurrentCall(log.getAlr().getSessionId());
						//TODO logika forwardingu
						MakeCallInvoke mci = new MakeCallInvoke();
						mci.setCallee(acctualTele.getNumber());
						mci.setSessionId(log.getAlr().getSessionId());
						log.getXmlPhoneSerwis().makeCall(mci);
					} catch (AlcServiceException e) {
						e.printStackTrace();
					} catch (RemoteException e) {
						e.printStackTrace();
					}	
				}
				
				
			}
			else{
				this.labelStatus.setText("Type correct number");
			}

		}
		else if (zdarzenie.getActionCommand().equals("Logout")) {
			log.logOut();
			logOutTelephones();
		}
			
		else if (zdarzenie.getActionCommand().equals("Exit")) 
		{
			log.logOut();
			logOutTelephones();
			System.exit(0);
		}
	}
		

	private Telephone getRarelyUsedNumberAndFree(Telephone[] nrs) {
		nrs = getFreeTele(nrs);
		if(nrs==null){
			return null;
		}
		else{
			Telephone rareNumber=nrs[0];
			for(int i=1; i<nrs.length;i++){
				if(rareNumber.getActivity()>nrs[i].getActivity())
					rareNumber=nrs[i];
			}
			return rareNumber;
		}

	}
	private Telephone[] getFreeTele(Telephone[] nrs){
		Vector freeTele = new Vector();
		for(int i=0; i<nrs.length;i++){
			if(nrs[i].getState().equals(CallProperties.TELE_FREE)){
				freeTele.add(nrs[i]);
			}
		}
			if(freeTele.size()==0)
				return null;
			else{
				System.out.println("size of free tele =" +freeTele.size());
				return (Telephone[]) freeTele.toArray(new Telephone[freeTele.size()]) ;
			}

	}
	private void initializedTelephones() {
		telephones= new Vector();
		telephones.add(new Telephone(CallProperties.SZEF_NAME,CallProperties.SZEF_NUM));
		telephones.add(new Telephone(CallProperties.HR_NAME,CallProperties.HR_NUM));
		telephones.add(new Telephone(CallProperties.REKLAMACJA_1_NAME,CallProperties.REKLAMACJA_1_NUM));
		telephones.add(new Telephone(CallProperties.REKLAMACJA_2_NAME,CallProperties.REKLAMACJA_2_NUM));
		System.out.println("zinicjalizowany telefony");
	}
	
	private void logInTelephones(){
		for(int i=0;i<telephones.size();i++){
			((Telephone) telephones.get(i)).logIn();
		}
	}
	private void logOutTelephones(){
		for(int i=0;i<telephones.size();i++){
			((Telephone) telephones.get(i)).logOut();
		}
	}
	private Telephone findTelephone(String number){
		Telephone tele = null;
		for(int i=0;i<telephones.size();i++){
			if(((Telephone) telephones.get(i)).getNumber().equals(number))
				tele=(Telephone) telephones.get(i);
		}
		return tele;
	}
	private Telephone getTeleBySession(String sessionId){
		Telephone tele = null;
		for(int i=0;i<telephones.size();i++){
			if(((Telephone) telephones.get(i)).getLog()==null)
				continue;
			if(((Telephone) telephones.get(i)).getLog().getAlr().getSessionId().equals(sessionId))
				tele=(Telephone) telephones.get(i);
		}
		return tele;
	}
	
	

	//metody okreslone w interfejsie XmlPhoneEvents
	public void onCallState(java.lang.String sessionId, Call[] calls) throws java.rmi.RemoteException 
	{	
		System.out.println("onCallStateEvent\n------------------------------------------------------------");
		
		if (sessionId.equals(log.getAlr().getSessionId())) {
			System.out.println("Połączenie do pani sekretarki");
			if (calls == null) 
			{
				this.labelStatus.setText("Waiting for call...");
			}
			else {
				for (int i = 0; i < calls.length; i++) {
					System.out.print("\t" + (i+1) + " - ref=" + calls[i].getCallRef() + " / state=" + calls[i].getState().toString() + " (" + calls[i].getName() + " - " + calls[i].getNumber() + ")");
					
					/////////////////////////////
					if (calls[i].getState().toString().equals("dialing")) 
					{
						System.out.println("SEKRETARKA - Dialing");
					}
					
					if (calls[i].getState().toString().equals("waiting") || calls[i].getState().toString().equals("held"))
					{
						System.out.println("SEKRETARKA - Waiting");
					}
					if (calls[i].getState().toString().equals("ringingIncoming"))
					{
						this.labelStatus.setText("SEKRETARKA - Ringing incoming from: "+calls[i].getNumber());
					}
					if (calls[i].getState().toString().equals("active"))
					{
						this.labelStatus.setText("SEKRETARKA -Connection established with number: "+calls[i].getNumber());
					}
					if (calls[i].getState().toString().equals("releasing"))
					{
						this.labelStatus.setText("SEKRETARKA -Number: "+calls[i].getNumber() + " is releasing");
					}
					if (calls[i].getState().toString().equals("ringingOutgoing"))
					{
						this.labelStatus.setText("SEKRETARKA - Transfering call to: "+calls[i].getNumber());
						Telephone tele = findTelephone(calls[i].getNumber());
						tele.setActivity(tele.getActivity()+1);
						tele.setState(CallProperties.TELE_BUSY);
						tele.setStatus("BUSY");
						log.getXmlPhoneSerwis().transferCurrentCall(log.getAlr().getSessionId());
					}
					if ((calls[i].getCorrelator() != null) && (!calls[i].getCorrelator().equals(""))) {
						System.out.println(" [Correlator = " + org.apache.axis.types.HexBinary.encode(calls[i].getCorrelator()) + "]");
					}
					else {
						System.out.println("");
					}
				}
			}
				
			}
		else{
			System.out.println("Połączenie do innych telefonów");
			Telephone tele = getTeleBySession(sessionId);
			if (calls == null) {
				System.out.println("Brak połączeń");
				
				if(tele.getState().equals(CallProperties.TELE_BUSY)){
					System.out.println("telefon "+tele.getNumber()+" "+tele.getName()+" zakończył połączenie");
					tele.setState(CallProperties.TELE_FREE);
					tele.setStatus("end call - free");
				}
			}else{
				for (int i = 0; i < calls.length; i++) {
					System.out.println("The state of tele"+ tele.getName() + " is "+ calls[i].getState().toString());
					if (calls[i].getState().toString().equals("dialing")) 
					{
						tele.setState(CallProperties.TELE_BUSY);
						tele.setStatus("dialing");
					}
					
					if (calls[i].getState().toString().equals("waiting") || calls[i].getState().toString().equals("held"))
					{
						tele.setStatus("waiting or held");
					}
					if (calls[i].getState().toString().equals("ringingIncoming"))
					{
						tele.setStatus("ringingIncoming");
					}
					if (calls[i].getState().toString().equals("active"))
					{
						tele.setStatus("Conn established with number: "+calls[i].getNumber());
					}
					if (calls[i].getState().toString().equals("releasing"))
					{
						tele.setState(CallProperties.TELE_FREE);
						tele.setStatus("releasing");
					}
					if (calls[i].getState().toString().equals("ringingOutgoing"))
					{
						
					}
				}
			}

			
			
		}

		System.out.println("------------------------------------------------------------\n");
	}

	public void onNewSession(java.lang.String sessionId) throws java.rmi.RemoteException 
	{
		System.out.println("onNewSession\n------------------------------------------------------------");
	}

	public void onSessionClosed(java.lang.String sessionId) throws java.rmi.RemoteException 
	{
		System.out.println("onSessionClosed\n------------------------------------------------------------");
	}

	public void onConnectionDown() throws java.rmi.RemoteException 
	{
		System.out.println("onConnectionDown\n------------------------------------------------------------");
//		AlcForwardState state2= new AlcForwardState();
//		state2.setFirstName("llal");
//		state2.setTargetNumber("400");
//		state2.setTargetType(AlcForwardTargetType.NUMBER);
//		state2.setType(AlcForwardType.IMMEDIATE);
//		xmlPhoneSetProgramming.setForwardState(state2);
	}

	public void onPhoneSetStaticState(String sessionId, AlcStaticState state) throws RemoteException 
	{
		System.out.println("onPhoneSetStaticState\n------------------------------------------------------------");
		if ((state.getForwardState() != null) && (state.getForwardState().getType() != null)) {
			if (state.getForwardState().getType() == AlcForwardType.NO_FORWARD) {
				System.out.println("\tNo forward");
			}
			else {
				if (state.getForwardState().getType() == AlcForwardType.IMMEDIATE) {
					System.out.print("\tImmediate forward ");
				}
				else if (state.getForwardState().getType() == AlcForwardType.ON_BUSY) {
					System.out.print("\tForward on busy ");
				}
				else if (state.getForwardState().getType() == AlcForwardType.ON_NO_ANSWER) {
					System.out.print("\tForward on no answer ");
				}
				else if (state.getForwardState().getType() == AlcForwardType.ON_BUSY_OR_NO_ANSWER) {
					System.out.print("\tForward on busy or no answer ");
				}
				
				if (state.getForwardState().getTargetType() == AlcForwardTargetType.VOICE_MAIL) {
					System.out.println("to voicemail");
				}
				else if (state.getForwardState().getTargetType() == AlcForwardTargetType.ROUTING_SERVICE) {
					System.out.println("to routing service");
				}
				else {
					System.out.println("to " + state.getForwardState().getTargetNumber() + "(" + state.getForwardState().getFirstName() + " " + state.getForwardState().getName() + ")");
				}
			}
		}
		else {
			System.out.println("\tNo forward");
		}
		
		if (state.getOverflowType() == AlcOverflowType.NO_OVERFLOW) {
			System.out.println("\tNo overflow");	
		}
		else if (state.getOverflowType() == AlcOverflowType.ON_BUSY) {
			System.out.println("\tOverflow on busy");	
		}
		else if (state.getOverflowType() == AlcOverflowType.ON_NO_ANSWER) {
			System.out.println("\tOverflow on no answer");	
		}
		else if (state.getOverflowType() == AlcOverflowType.ON_BUSY_OR_NO_ANSWER) {
			System.out.println("\tOverflow on busy or no answer");	
		}
		
		System.out.println("\tLock " + (state.isLocked() ? "enabled" : "disabled"));
		System.out.println("\tDo not disturb " + (state.isDoNotDisturbActivated() ? "enabled" : "disabled"));
		System.out.println("\tCamp on " + (state.isCampOnActivated() ? "enabled" : "disabled"));
		System.out.println("------------------------------------------------------------\n");
	}

	public void onUnansweredCall(String sessionId) throws RemoteException 
	{
		System.out.println("onUnansweredCall\n------------------------------------------------------------");
	}

    public void onNomadState(String sessionId, NomadMode mode, String homeNumber) throws RemoteException 
    {
		System.out.println("onNomadState\n------------------------------------------------------------");
		if (mode == NomadMode.local) {
			System.out.println("\tLOCAL");
		}
		else {
			System.out.println("\tPRIVATE PHONE : " + homeNumber);
		}
		System.out.println("------------------------------------------------------------\n");
    }
	
	
	//metody okreslone w interfejsie WindowListener
	 
	public void windowActivated(WindowEvent zdarzenie){}
	
	public void windowClosed(WindowEvent zdarzenie){}
	
	public void windowClosing(WindowEvent zdarzenie) 
	{
		log.logOut();
		logOutTelephones();
	}

	public void windowDeactivated(WindowEvent zdarzenie){}
	
	public void windowDeiconified(WindowEvent zdarzenie){}
	
	public void windowIconified(WindowEvent zdarzenie){}
	
	public void windowOpened(WindowEvent zdarzenie){}

}