package sn.ucad.fst.dmi.mtdsi.recherche.modelDAO;
// Generated 8 juil. 2024, 01:00:08 by Hibernate Tools 5.6.15.Final

/**
 * Dictionnaire generated by hbm2java
 */
public class Dictionnaire implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idDocument;
	private String typeDocument;
	private Integer numenreg;
	private String titre;
	private String langue;

	public Dictionnaire() {
	}

	public Dictionnaire(String typeDocument) {
		this.typeDocument = typeDocument;
	}

	public Dictionnaire(String typeDocument, Integer numenreg, String titre, String langue) {
		this.typeDocument = typeDocument;
		this.numenreg = numenreg;
		this.titre = titre;
		this.langue = langue;
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

	public String getLangue() {
		return this.langue;
	}

	public void setLangue(String langue) {
		this.langue = langue;
	}

}
