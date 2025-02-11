package uk.ac.ebi.lipidhome.service.result.model;

/**
 *
 * @author Antonio Fabregat <fabregat@ebi.ac.uk>
 * @author Joe Foster <jfoster@ebi.ac.uk>
 *
 * Implements ResultObject to gain access to name and id, this simple class extends it to model a simple sub class
 * used for sub class lists.
 *
 */
public class SimpleSubClass extends ResultObject {

	private String code;
	
	private Integer radylChains;
	
	public SimpleSubClass(){
		
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getRadylChains() {
		return radylChains;
	}

	public void setRadylChains(Integer radylChains) {
		this.radylChains = radylChains;
	}
}
