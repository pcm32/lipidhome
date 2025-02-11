package uk.ac.ebi.lipidhome.service.result.model;

/**
 *
 * @author Antonio Fabregat <fabregat@ebi.ac.uk>
 * @author Joe Foster <jfoster@ebi.ac.uk>
 *
 * Implements ResultObject to gain access to name and id, this simple class extends it to model a simple specie
 * used for specie lists.
 *
 */
public class SimpleSpecie extends ResultObject{

	private boolean identified;
	
	private int carbons;
	
	private int doubleBonds;
	
	private String formula;
	
	private float mass;
	
	public SimpleSpecie(){
		
	}

	public boolean isIdentified() {
		return identified;
	}

	public void setIdentified(boolean identified) {
		this.identified = identified;
	}

	public int getCarbons() {
		return carbons;
	}

	public void setCarbons(int carbons) {
		this.carbons = carbons;
	}

	public int getDoubleBonds() {
		return doubleBonds;
	}

	public void setDoubleBonds(int doubleBonds) {
		this.doubleBonds = doubleBonds;
	}

	public String getFormula() {
		return formula;
	}

	public void setFormula(String formula) {
		this.formula = formula;
	}

	public float getMass() {
		return mass;
	}

	public void setMass(float mass) {
		this.mass = mass;
	}
}
