package uk.ac.ebi.lipidhome.service.result.model;

import uk.ac.ebi.lipidhome.core.model.MainClass;
import uk.ac.ebi.lipidhome.core.model.MainClassProperties;

/**
 *
 * @author Antonio Fabregat <fabregat@ebi.ac.uk>
 * @author Joe Foster <jfoster@ebi.ac.uk>
 *
 * Implements ResultObject to gain access to name and id, this simple class extends it to model a main class summary
 *
 */
public class MainClassSummary extends ResultObject{
	
	private String code;
	
	private String model;
	
	private Integer subClasses;
	
	private Integer species;

    private Integer faScanSpecies;

	private Integer subSpecies;

	private Integer annotatedIsomers;
	
	public MainClassSummary(MainClass mainClass, MainClassProperties properties){
		super(mainClass);
		setCode(mainClass.getCode());
		setModel(mainClass.getModel());

        setSubClasses(properties.getSubClasses());
		setSpecies(properties.getSpecies());
        setFaScanSpecies(properties.getFaScanSpecies());
        setSubSpecies(properties.getSubSpecies());
        setAnnotatedIsomers(properties.getAnnotatedIsomers());
	}

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getSubClasses() {
        return subClasses;
    }

    public void setSubClasses(Integer subClasses) {
        this.subClasses = subClasses;
    }

    public Integer getSpecies() {
        return species;
    }

    public void setSpecies(Integer species) {
        this.species = species;
    }

    public Integer getFaScanSpecies() {
        return faScanSpecies;
    }

    public void setFaScanSpecies(Integer faScanSpecies) {
        this.faScanSpecies = faScanSpecies;
    }

    public Integer getSubSpecies() {
        return subSpecies;
    }

    public void setSubSpecies(Integer subSpecies) {
        this.subSpecies = subSpecies;
    }

    public Integer getAnnotatedIsomers() {
        return annotatedIsomers;
    }

    public void setAnnotatedIsomers(Integer annotatedIsomers) {
        this.annotatedIsomers = annotatedIsomers;
    }
}
