
import java.awt.event.*;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.WindowEvent;
import javax.swing.*;

import java.net.InetAddress;
import java.rmi.RemoteException;

import com.alcatel.xmlapi.phone.*;
import com.alcatel.xmlapi.phonesetprogramming.types.*;

import com.alcatel.ServerHTTP.ServerHttp;
import com.alcatel.ServerHTTP.AlcEventsRessource;

//stworzenie glownej ramki oraz zdefiniowanie operacji zwiazanej z konkretnym Web Serwisem 
public class GlownaRamka extends JFrame implements XmlPhoneEvents, WindowListener, ActionListener  
{
	private JMenuBar pasekMenu;
	private JMenu menuProgram;
	private JMenuItem menuProgramZaloguj, menuProgramWyloguj, menuProgramZakoncz;
	private JButton przyciskStanPol, przyciskKonferencja;
	private JCheckBox dodatkowaOpcja;
	private JTextField poleNrTel;
	
	private boolean sprPol = false;
	
	private GridBagConstraints gbc;
	private GridBagLayout gbl;
	
	private Log logowanie_wylogowywanie;
	private AlcLogonResult alr = null;
	private XmlPhone xmlPhone = null;
	private JMenuBar menuBar;
	private JMenu mnProgram;
	private JMenuItem mntmLogin;
	private JMenuItem mntmLogout;
	private JSeparator separator;
	private JMenuItem mntmExit;
	
	//inicjalizacja modulu logowania i wylogowywania oraz stworzenie GUI
    public GlownaRamka() 
    {
    	//wlasciwosci ramki
    	addWindowListener(this);
		setTitle("Stan polaczenia");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600, 400);
		setVisible(true);
    	
    	//modul logowania i wylogowywania
    	String[] tabWS = {"XMLPhone"};
    	logowanie_wylogowywanie = new Log();
    	
    	//GUI
    	gbc = new GridBagConstraints();
		gbc.insets = new Insets(0, 5, 5, 5);
		gbl = new GridBagLayout();
		
		Container powZawartosci = getContentPane();
		powZawartosci.setLayout(gbl);
		powZawartosci.setPreferredSize(new Dimension(600, 400));
		powZawartosci.setVisible(true);
		
		//Menu
		pasekMenu = new JMenuBar();
		setJMenuBar(pasekMenu);
		
		menuProgram = new JMenu("Program");
		pasekMenu.add(menuProgram);
		
		menuProgramZaloguj = new JMenuItem("Login");
		menuProgram.add(menuProgramZaloguj);
		
		menuProgramWyloguj = new JMenuItem("Logout");
		menuProgram.add(menuProgramWyloguj);
		
		separator = new JSeparator();
		menuProgram.add(separator);
		
		menuProgramZakoncz = new JMenuItem("Exit");
		menuProgram.add(menuProgramZakoncz);
		
		menuProgramZaloguj.addActionListener(this);
		menuProgramWyloguj.addActionListener(this);
		menuProgramZakoncz.addActionListener(this);
		
		//gbc.gridx = 0;
		//gbc.gridy = 0;
		//gbl.setConstraints(pasekMenu, gbc);
		//powZawartosci.add(pasekMenu);
		
		//opcja automatycznego polaczenia na podany numer po podniesieniu sluchawki
		//dodatkowaOpcja = new JCheckBox("Autom. pol.");
		//dodatkowaOpcja.addActionListener(this);
		//JLabel etykieta = new JLabel("Nr tel.: ");
		//poleNrTel = new JTextField(5);
		//poleNrTel.setMaximumSize(poleNrTel.getPreferredSize());
		//poleNrTel.setEditable(false);
		//gbc.gridx = 0;
		//gbc.gridy = 1;
		//gbc.gridwidth = 1;
		//gbl.setConstraints(dodatkowaOpcja, gbc);
		//powZawartosci.add(dodatkowaOpcja);
		//gbc.gridx = 1;
		//gbc.gridy = 1;
		//gbc.gridwidth = 1;
		//gbc.anchor = GridBagConstraints.EAST;
		//gbl.setConstraints(etykieta, gbc);
		//powZawartosci.add(etykieta);
		//gbc.gridx = 2;
		//gbc.gridy = 1;
		//gbc.gridwidth = 1;
		//gbc.anchor = GridBagConstraints.WEST;
		///gbl.setConstraints(poleNrTel, gbc);
		//powZawartosci.add(poleNrTel);
		
		//Przycisk "Pobieranie stanu polaczen"
		przyciskStanPol = new JButton("Pobieranie stanu polaczen");
		przyciskStanPol.setBorder(BorderFactory.createEtchedBorder());
		przyciskStanPol.addActionListener(this);
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 3;
		gbc.anchor = GridBagConstraints.CENTER;
		gbl.setConstraints(przyciskStanPol, gbc);
		powZawartosci.add(przyciskStanPol);
	
		//Przycisk "Konferencja"
		//przyciskKonferencja = new JButton("Konferencja");
		//przyciskKonferencja.setEnabled(false);
		//przyciskKonferencja.setBorder(BorderFactory.createEtchedBorder());
		//przyciskKonferencja.addActionListener(this);
		//gbc.gridx = 0;
		//gbc.gridy = 3;
		//gbc.gridwidth = 3;
		//gbl.setConstraints(przyciskKonferencja, gbc);
		//powZawartosci.add(przyciskKonferencja);
		
		// Creation of the instance of ServerHttp
		ServerHttp lServerHttp = ServerHttp.instance(/*m_httpServerPort*/"10101");
		
		// creation of event ressource
		AlcEventsRessource lEventsRessource = new AlcEventsRessource(this, /*EVENT_CONTEXT*/"/phone/events");
		
		
		//System.out.println("\nDB koniec G³ówna Ramka");
	}
    
    //przypisanie przyciskom konkretnych akcji
    public void actionPerformed(ActionEvent zdarzenie) 
    {
    	System.out.println("\nDB zdarzenie : " + zdarzenie.getActionCommand());
		if (zdarzenie.getActionCommand().equals("Login"))
		{
			logowanie_wylogowywanie.zaloguj();
		System.out.println("\nDB po zdarzeniu : " + zdarzenie.getActionCommand());
		}
		else if (zdarzenie.getActionCommand().equals("Logout")) 
			logowanie_wylogowywanie.wyloguj();
		else if (zdarzenie.getActionCommand().equals("Exit")) 
		{
			logowanie_wylogowywanie.wyloguj();
			System.exit(0);
		}
		else if (zdarzenie.getActionCommand().equals("Pobieranie stanu polaczen")) 
		{
			aktywujPobStPol();
		}
		else if (zdarzenie.getActionCommand().equals("Konferencja")) 
		{
			rozpocznijKonferencje();
		}
		else if (dodatkowaOpcja.isSelected()) 
		{
			poleNrTel.setText("403");
			poleNrTel.setEditable(true);
		}
		else if (!dodatkowaOpcja.isSelected()) 
		{
			poleNrTel.setText("");
			poleNrTel.setEditable(false);
		}
	}
	
	//aktywowanie pobierania stanu polaczen
	private void aktywujPobStPol()
	{
		
		xmlPhone = logowanie_wylogowywanie.getXmlPhoneSerwis();
		alr = logowanie_wylogowywanie.getAlr();
		
		//System.out.println("\nactionSubscribeEvents");
		//if ((!m_bLoggedToSvc) || (m_svcSessionId == null) || (m_svcSessionId.equals(""))) {
		//	return;
		//}
		System.out.println("\nDB Events----------------------------------------");
		
		if (xmlPhone != null) 
		{
			String localHost = null;
			try 
			{
				localHost = "194.29.169.twoja koncowka ip";//InetAddress.getLocalHost().getHostAddress();
				System.out.println("DB xxx loc-host:" + localHost);
			}
			catch (Exception e) 
			{
				System.out.println("java.net.InetAddress.getLocalHost failed : " + e.getMessage());
			}
			
			try 
			{
				String lNotificationUrl = "http://" + localHost + ":" + /*m_httpServerPort*/"10101" + /*EVENT_CONTEXT*/"/phone/events";
				System.out.println("DB notification ULR=" + lNotificationUrl);
				//if (!m_subscribe) {
					xmlPhone.subscribe(alr.getSessionId(), lNotificationUrl);
					//m_subscribe = true;
				//}2
				//else {
				//	xmlPhoneService.unsubscribe(m_svcSessionId);
				//	m_subscribe = false;
				//}
			}
			catch (RemoteException e) {
				System.out.println("subscribe RemoteException : " + e);
			}	
			
			/*if (!m_subscribe) {
				m_jBtSubscribeEvents.setToolTipText("subsribe to events");
				m_jBtSubscribeEvents.setIcon(new javax.swing.ImageIcon("res\\subscribe.gif"));
			}
			else {
				m_jBtSubscribeEvents.setToolTipText("unsubsribe to events");
				m_jBtSubscribeEvents.setIcon(new javax.swing.ImageIcon("res\\unsubscribe.gif"));
			}*/
		}
		
	}

	
	//metody okreslone w interfejsie XmlPhoneEvents
	public void onCallState(java.lang.String sessionId, Call[] calls) throws java.rmi.RemoteException 
	{	
		System.out.println("onCallStateEvent\n------------------------------------------------------------");
		if (calls == null) 
		{
			System.out.println("\tNo calls");
			sprPol = false;
			
			try
			{
				xmlPhone.clearCurrentCall(alr.getSessionId());
			}
			catch(Exception w)
			{
				w.printStackTrace();
			}
		}
		else {
			if(calls.length == 1)
				//przyciskKonferencja.setEnabled(false);
			for (int i = 0; i < calls.length; i++) {
				System.out.print("\t" + (i+1) + " - ref=" + calls[i].getCallRef() + " / state=" + calls[i].getState().toString() + " (" + calls[i].getName() + " - " + calls[i].getNumber() + ")");
				
				/////////////////////////////
				if (calls[i].getState().toString().equals("dialing")) 
				{
					/*if(dodatkowaOpcja.isSelected())
					{
						if(!sprPol)
						{
							MakeCallInvoke mci = new MakeCallInvoke();
							mci.setCallee(poleNrTel.getText());
							mci.setSessionId(alr.getSessionId());
							try
							{
								xmlPhone.makeCall(mci);
							}
							catch(Exception w)
							{
								w.printStackTrace();
							}
							sprPol = true;
						}
					}*/
					System.out.println("Dialing");
				}
				
				if (calls[i].getState().toString().equals("waiting") || calls[i].getState().toString().equals("held"))
				{
					//przyciskKonferencja.setEnabled(true);
					System.out.println("Waiting");
				}
				
				//
				if (calls[i].getState().toString().equals("ringingIncoming"))
				{
					//przyciskKonferencja.setEnabled(true);
					System.out.println("RingingIncoming");
				}				
				
				////////////////////////////	
				
				
				if ((calls[i].getCorrelator() != null) && (!calls[i].getCorrelator().equals(""))) {
					System.out.println(" [Correlator = " + org.apache.axis.types.HexBinary.encode(calls[i].getCorrelator()) + "]");
					
				}
				else {
					System.out.println("");
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
	
	//rozpoczecie konferencji
	private void rozpocznijKonferencje()
	{
		try
		{
			xmlPhone.conferenceCurrentCall(alr.getSessionId());
		}
		catch(Exception w)
		{
			w.printStackTrace();
		}
	}
	
	//metody okreslone w interfejsie WindowListener
	 
	public void windowActivated(WindowEvent zdarzenie){}
	
	public void windowClosed(WindowEvent zdarzenie){}
	
	public void windowClosing(WindowEvent zdarzenie) 
	{
		logowanie_wylogowywanie.wyloguj();
	}

	public void windowDeactivated(WindowEvent zdarzenie){}
	
	public void windowDeiconified(WindowEvent zdarzenie){}
	
	public void windowIconified(WindowEvent zdarzenie){}
	
	public void windowOpened(WindowEvent zdarzenie){}
}