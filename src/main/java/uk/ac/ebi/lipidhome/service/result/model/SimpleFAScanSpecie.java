/**
 * Implements ResultObject to gain access to name and id, this simple class extends it to model a simple FA scan specie
 * used for FA scan specie lists.
 */
package uk.ac.ebi.lipidhome.service.result.model;

public class SimpleFAScanSpecie extends ResultObject {
	
	private boolean identified;
	
	private double score;

	public SimpleFAScanSpecie() {

	}

	public boolean isIdentified() {
		return identified;
	}

	public void setIdentified(boolean identified) {
		this.identified = identified;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

}