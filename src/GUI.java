import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GUI extends JFrame {

    JPanel panel;
	
	JButton anlegen;
	JButton ausgabe;
	
	JLabel lblVorname;
	JLabel lblNachname;
	JLabel lblGeburtstag;
	JLabel lblSpruch;
	JLabel lblSchuelernummer;
	
	JTextField txtVorname;
	JTextField txtNachname;
	JTextField txtGeburtstag;
	JTextField txtSpruch;
	JTextArea  txtAusgabe;
	JTextField txtSchuelernummer;
	
	Jahrbuch newJahrbuch;

    public GUI(String title, int x, int y) {
		super.setTitle(title);
		setSize(x,y);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addWindowListener(new WindowAdapter(){
			public void windowOpened(WindowEvent e) {
				File newFile = new File();
				newJahrbuch = newFile.readFile("src/test.ser");
			}
			public void windowClosing(WindowEvent e) {
				File newFile = new File();
				newFile.saveFile("test", newJahrbuch);
			}
		  });
		setLayout(null);
		panel = new JPanel();
		
		createElements();

		add(panel);
		
	}
	private void createElements(){
		lblVorname = new JLabel("Vorname:");
		lblNachname = new JLabel("Nachname:");
		lblGeburtstag = new JLabel("Geburtstag:");
		lblSpruch = new JLabel("Spruch:");
		lblSchuelernummer = new JLabel("Schülernummer:");
		
		txtVorname = new JTextField();
		txtNachname = new JTextField();
		txtGeburtstag = new JTextField();
		txtSpruch = new JTextField();
		txtAusgabe = new JTextArea();
		txtSchuelernummer = new JTextField();
		
		anlegen = new JButton("Hinzufügen");
		anlegen();

		ausgabe = new JButton("Ausgeben:");
		ausgeben();
		
		lblVorname.setBounds(10, 10, 100, 25);
		lblNachname.setBounds(10, 40, 100, 25);
		lblGeburtstag.setBounds(10, 70, 100, 25);
		lblSpruch.setBounds(10, 100, 100, 25);
		lblSchuelernummer.setBounds(10, 130, 150, 25);
		
		txtVorname.setBounds(150, 10, 100, 25);
		txtNachname.setBounds(150, 40, 100, 25);
		txtGeburtstag.setBounds(150, 70, 100, 25);
		txtSpruch.setBounds(150, 100, 100, 25);
		txtAusgabe.setBounds(10, 200, 190, 100);
		txtSchuelernummer.setBounds(150, 130, 100, 25);
		
		anlegen.setBounds(10, 160, 200, 25);
		ausgabe.setBounds(10, 310, 200, 25);
		
		add(lblVorname);
		add(lblNachname);
		add(lblGeburtstag);
		add(lblSpruch);
		add(lblSchuelernummer);
		
		add(txtVorname);
		add(txtNachname);
		add(txtGeburtstag);
		add(txtSpruch);
		add(txtAusgabe);
		add(txtSchuelernummer);
		
		add(anlegen);
		add(ausgabe);
	}

	private void anlegen(){
		anlegen.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
                if (newJahrbuch.schuelernummerExistent(Integer.parseInt(txtSchuelernummer.getText()))) {
                    JOptionPane.showMessageDialog(null, "Die eingegebene Schülernummer existiert bereits oder ist ungültig");
                } else {
			    	newJahrbuch.eintragen(txtVorname.getText(), txtNachname.getText(), txtGeburtstag.getText(), Integer.parseInt(txtSchuelernummer.getText()));
				    newJahrbuch.spruchAnpassen(newJahrbuch.getCurrentSchueler(), txtSpruch.getText());
                }
			}
		});
	}

	private void ausgeben(){
		ausgabe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                if (newJahrbuch.schuelernummerExistent(Integer.parseInt(txtSchuelernummer.getText()))) {
                    txtAusgabe.setText(newJahrbuch.ausgeben(Integer.parseInt(txtSchuelernummer.getText())));
                } else {
                    JOptionPane.showMessageDialog(null, "Die eingegebene Schülernummer existiert nicht oder ist ungültig");
                }
                
			}
			
		});
	}
    public static void main(String[] args) {
        GUI newGUI = new GUI("Jahrbuch", 500,500);
		newGUI.newJahrbuch = new Jahrbuch(100);
		newGUI.setVisible(true);
        
    }
}