public class Jahrbuch {
    private Schueler[] schuelerliste;
	private int groesse;

    public Jahrbuch() {
		
	}
	public Jahrbuch(int groesse) {
		schuelerliste = new Schueler[groesse];
		this.groesse = 0;
	}

    public Schueler[] getSchuelerliste() {
		return schuelerliste;
	}
	public Schueler getCurrentSchueler() {
		return schuelerliste[groesse-1];
	}
	public int getGroesse(){
		return groesse;
	}

    public void eintragen(String vorname, String nachname, String geburtstag, String spruch, int schuelernummer) {
		Schueler newSchueler = new Schueler(vorname, nachname, geburtstag, spruch, schuelernummer);
		schuelerliste[groesse] = newSchueler;
		groesse++;
	}
	public void eintragen(String vorname, String nachname, String geburtstag, int schuelernummer) {
		Schueler newSchueler = new Schueler(vorname, nachname, geburtstag, null, schuelernummer);
		schuelerliste[groesse] = newSchueler;
		groesse++;
	}
	
	public void spruchAnpassen(Schueler schueler, String newSpruch) {
		schueler.setSpruch(newSpruch);
	}
	
	public String ausgeben(int schuelernummer) {
		    return schuelerliste[linearSearch(schuelernummer)].ausgabe();
	}
	public boolean schuelernummerExistent(int schuelernummer) {
        if (linearSearch(schuelernummer) != -1) {
            return true;
        } else {
            return false;
        }
    }
	private int linearSearch(int target) {
		for (int i = 0; i < groesse; i++) {
			if (schuelerliste[i].getSchuelernummer() == target) {
				return i;
			}
		}
		return -1;
	}
	
	
}
