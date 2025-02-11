package uk.ac.ebi.lipidhome.core.dao;

import uk.ac.ebi.lipidhome.core.model.CrossReference;
import uk.ac.ebi.lipidhome.core.model.Paper;
import uk.ac.ebi.lipidhome.core.model.SubSpecie;
import uk.ac.ebi.lipidhome.core.model.SubSpecieChain;
import uk.ac.ebi.lipidhome.service.result.model.BaseSearchItem;
import uk.ac.ebi.lipidhome.service.result.model.SimpleIsomer;

import java.util.List;

/**
 *
 * @author Antonio Fabregat <fabregat@ebi.ac.uk>
 * @author Joe Foster <jfoster@ebi.ac.uk>
 *
 * The SubSpecieDao defines all the necessary functions to retrieve information pertaining to a SubSpecie.
 *
 */
public interface SubSpecieDao<T> extends BaseDao<SubSpecie>{

	SubSpecie getSubSpecie(Long id);
	
	List<BaseSearchItem> getSubSpeciesByNameLike(String name, Long start, Long limit);

    List<BaseSearchItem> getSubSpeciesByNameLike(String name);
	
	List<BaseSearchItem> getSubSpecieParents(Long id);
	
	long getSubSpeciesCountByNameLike(String name);
	
	int getIsomerCountById(Long id);
	
	String getChainNameById(Long id);

    String geteCode(Long id);

    List<SubSpecieChain> getChainsById(Long id);
	
	List<CrossReference> getCrossReferencesList(Long id);
	
	List<Paper> getPapersList(Long id);
	
	List<SimpleIsomer> getSimpleIsomerList(Long id);
}
