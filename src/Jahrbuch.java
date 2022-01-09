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
}
