public class Schueler{
    private String vorname;
	private String nachname;
	private String geburtstag;
	private String spruch;
	private int schuelernummer = 0;
	
	public Schueler(String newVorname, String newNachname, String newGeburtstag, String newSpruch, int newSchuelernummer) {
		this.vorname = newVorname;
		this.nachname = newNachname;
		this.geburtstag = newGeburtstag;
		this.spruch = newSpruch;
		this.schuelernummer = newSchuelernummer;
	}
	public Schueler() {
		
	}

	public void setVorname(String newVorname) {
		vorname = newVorname;
	}
	public String getVorname() {
		if (vorname == null || vorname.isEmpty()) {
			return "Kein oder ungültiger Name eingegeben";
		} else {
			return vorname;
		}
	}
	
	public void setNachname(String newNachname) {
		nachname = newNachname;
	}
	public String getNachname() {
		if (nachname == null || nachname.isEmpty()) {
			return "Kein oder ungültiger Name eingegeben";
		} else {
			return nachname;
		}
	}
	
	public void setGeburtstag(String newGeburtstag) {
		geburtstag = newGeburtstag;
	}
	public String getGeburtstag() {
		if (geburtstag == null || geburtstag.isEmpty()) {
			return "Kein oder ungültiger Geburtstag eingegeben";
		} else {
			return geburtstag;
		}
	}
	
	public void setSpruch(String newSpruch) {
		spruch = newSpruch;
	}
	public String getSpruch() {
		if (spruch == null || spruch.isEmpty()) {
			return "Kein oder ungültiger Spruch eingegeben";
		} else {
			return spruch;
		}
	}
	public void setSchülernummer(int newSchuelernummer) {
		schuelernummer = newSchuelernummer;
	}
	public int getSchuelernummer() {
		return schuelernummer;
	}
}