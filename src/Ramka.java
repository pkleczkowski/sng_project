
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
	
	private String acctualNumber;
	//inicjalizacja modulu logowania i wylogowywania oraz stworzenie GUI
    public Ramka() 
    {
    	//----------------------GRAFIKA--------------------------------------
    	//wlasciwosci ramki
    	addWindowListener(this);
		setTitle("Stan polaczenia");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600, 400);
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
		panel_2.setPreferredSize(new Dimension(600,600));
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 0, 5);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 0;
		getContentPane().add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JLabel emptylabel1 = new JLabel("                      ");
		GridBagConstraints gbc_lblEmptylabel = new GridBagConstraints();
		gbc_lblEmptylabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmptylabel.gridx = 0;
		gbc_lblEmptylabel.gridy = 0;
		panel_2.add(emptylabel1, gbc_lblEmptylabel);
		
		lblStatus = new JLabel("Status");
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblStatus = new GridBagConstraints();
		gbc_lblStatus.gridwidth = 7;
		gbc_lblStatus.insets = new Insets(0, 0, 5, 5);
		gbc_lblStatus.gridx = 1;
		gbc_lblStatus.gridy = 1;
		panel_2.add(lblStatus, gbc_lblStatus);
		
		separator_1 = new JSeparator();
		separator_1.setBackground(Color.BLACK);
		separator_1.setForeground(Color.BLACK);
		GridBagConstraints gbc_separator_1 = new GridBagConstraints();
		gbc_separator_1.fill = GridBagConstraints.BOTH;
		gbc_separator_1.gridwidth = 8;
		gbc_separator_1.insets = new Insets(0, 0, 5, 5);
		gbc_separator_1.gridx = 1;
		gbc_separator_1.gridy = 2;
		panel_2.add(separator_1, gbc_separator_1);
		
		label_7 = new JLabel("                                                                     ");
		GridBagConstraints gbc_label_7 = new GridBagConstraints();
		gbc_label_7.gridwidth = 4;
		gbc_label_7.insets = new Insets(0, 0, 5, 5);
		gbc_label_7.gridx = 5;
		gbc_label_7.gridy = 3;
		panel_2.add(label_7, gbc_label_7);
		
		label = new JLabel("            ");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 0);
		gbc_label.gridx = 11;
		gbc_label.gridy = 3;
		panel_2.add(label, gbc_label);
		
		labelStatus = new JLabel("Waiting for call...");
		GridBagConstraints gbc_lblWaitingForCall = new GridBagConstraints();
		gbc_lblWaitingForCall.anchor = GridBagConstraints.WEST;
		gbc_lblWaitingForCall.gridwidth = 8;
		gbc_lblWaitingForCall.insets = new Insets(0, 0, 5, 5);
		gbc_lblWaitingForCall.gridx = 1;
		gbc_lblWaitingForCall.gridy = 4;
		panel_2.add(labelStatus, gbc_lblWaitingForCall);
		
		label_6 = new JLabel("    ");
		GridBagConstraints gbc_label_6 = new GridBagConstraints();
		gbc_label_6.insets = new Insets(0, 0, 5, 5);
		gbc_label_6.gridx = 10;
		gbc_label_6.gridy = 4;
		panel_2.add(label_6, gbc_label_6);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 7;
		gbc_textField.insets = new Insets(8, 0, 5, 120);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
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
		gbc_btnCall.insets = new Insets(0, 0, 0, 5);
		gbc_btnCall.gridx = 1;
		gbc_btnCall.gridy = 6;
		btnCall.setEnabled(false);
		btnCall.addActionListener(this);
		panel_2.add(btnCall, gbc_btnCall);
		
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
			if(textField.getText().matches("\\d")){
				acctualNumber = translateNumber(textField.getText());
				if(acctualNumber.contentEquals("-1")){
					this.labelStatus.setText("This number is not used, choose diffrent");
				}else{
					System.out.println("transfer call nr is =" + acctualNumber);
					this.labelStatus.setText("Trying to transfer call to: "+acctualNumber);
					try {
						System.out.println("session id of sekretarrka is" +log.getAlr().getSessionId());
						log.getXmlPhoneSerwis().holdCurrentCall(log.getAlr().getSessionId());
						log.getXmlPhoneSerwis().holdCurrentCall(log.getAlr().getSessionId());
						//TODO logika forwardingu
						MakeCallInvoke mci = new MakeCallInvoke();
						mci.setCallee(acctualNumber);
						mci.setSessionId(log.getAlr().getSessionId());
						log.getXmlPhoneSerwis().makeCall(mci);
					} catch (AlcServiceException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
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
	
	private String translateNumber(String number) {
		
		if(number.contentEquals("1")){
		//SZEF
			return CallProperties.SZEF_NUM;
		}
		else if(number.contentEquals("2")){
		//HR
			return CallProperties.HR_NUM;
		}
		else if(number.contentEquals("3")){
		//REKLAMACJA
			Telephone [] nr = new Telephone[2];
			nr[0]=findTelephone(CallProperties.REKLAMACJA_1_NUM);
			nr[1]=findTelephone(CallProperties.REKLAMACJA_2_NUM);
			return getRarelyUsedNumber(nr).getNumber();
		}else
			return "-1";
	}

	
	private Telephone getRarelyUsedNumber(Telephone[] nrs) {
		Telephone rareNumber=nrs[0];
		for(int i=1; i<nrs.length;i++){
			if(rareNumber.getActivity()>nrs[i].getActivity())
				rareNumber=nrs[i];
		}
		return rareNumber;
	}
	private void initializedTelephones() {
		telephones= new Vector();
//		telephones.add(new Telephone(CallProperties.SZEF_NUM));
//		telephones.add(new Telephone(CallProperties.HR_NUM));
		telephones.add(new Telephone(CallProperties.REKLAMACJA_1_NUM));
		telephones.add(new Telephone(CallProperties.REKLAMACJA_2_NUM));
		
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
	
	

	//metody okreslone w interfejsie XmlPhoneEvents
	public void onCallState(java.lang.String sessionId, Call[] calls) throws java.rmi.RemoteException 
	{	
		System.out.println("onCallStateEvent\n------------------------------------------------------------");
		
		if (sessionId.equals(log.getAlr().getSessionId())) {
			System.out.println("Połączenie do pani sekretarki");
			if (calls == null) 
			{
				this.labelStatus.setText("Waiting for call...");
				
				System.out.println("\tNo calls");
				
				try
				{
					log.getXmlPhoneSerwis().clearCurrentCall(log.getAlr().getSessionId());
				}
				catch(Exception w)
				{
					System.out.println("Wystapill jakis blad");
					w.printStackTrace();
				}
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
						findTelephone(calls[i].getNumber()).setActivity(findTelephone(calls[i].getNumber()).getActivity()+1);
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
			for (int i = 0; i < calls.length; i++) {
				//TODO tutaj sie wywala błąd
				System.out.println("Call state jednego z numerów : "+ calls[i].getNumber());	
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