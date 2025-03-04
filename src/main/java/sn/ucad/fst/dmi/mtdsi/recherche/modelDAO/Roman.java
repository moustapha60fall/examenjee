package sn.ucad.fst.dmi.mtdsi.recherche.modelDAO;
// Generated 8 juil. 2024, 01:00:08 by Hibernate Tools 5.6.15.Final

/**
 * Roman generated by hbm2java
 */
public class Roman implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idDocument;
	private String typeDocument;
	private Integer numenreg;
	private String titre;
	private String typeLivre;
	private Integer autre;
	private Integer nbrpages;
	private String genre;

	public Roman() {
	}

	public Roman(String typeDocument, String typeLivre, String genre) {
		this.typeDocument = typeDocument;
		this.typeLivre = typeLivre;
		this.genre = genre;
	}

	public Roman(String typeDocument, Integer numenreg, String titre, String typeLivre, Integer autre, Integer nbrpages,
			String genre) {
		this.typeDocument = typeDocument;
		this.numenreg = numenreg;
		this.titre = titre;
		this.typeLivre = typeLivre;
		this.autre = autre;
		this.nbrpages = nbrpages;
		this.genre = genre;
	}

	public Integer getIdDocument() {
		return this.idDocument;
	}

	public void setIdDocument(Integer idDocument) {
		this.idDocument = idDocument;
	}

	public String getTypeDocument() {
		return this.typeDocument;
	}

	public void setTypeDocument(String typeDocument) {
		this.typeDocument = typeDocument;
	}

	public Integer getNumenreg() {
		return this.numenreg;
	}

	public void setNumenreg(Integer numenreg) {
		this.numenreg = numenreg;
	}

	public String getTitre() {
		return this.titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getTypeLivre() {
		return this.typeLivre;
	}

	public void setTypeLivre(String typeLivre) {
		this.typeLivre = typeLivre;
	}

	public Integer getAutre() {
		return this.autre;
	}

	public void setAutre(Integer autre) {
		this.autre = autre;
	}

	public Integer getNbrpages() {
		return this.nbrpages;
	}

	public void setNbrpages(Integer nbrpages) {
		this.nbrpages = nbrpages;
	}

	public String getGenre() {
		return this.genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

}
