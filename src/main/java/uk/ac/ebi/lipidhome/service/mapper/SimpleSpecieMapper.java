package uk.ac.ebi.lipidhome.service.mapper;

import org.springframework.jdbc.core.RowMapper;
import uk.ac.ebi.lipidhome.service.result.model.SimpleSpecie;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Antonio Fabregat <fabregat@ebi.ac.uk>
 * @author Joe Foster <jfoster@ebi.ac.uk>
 *
 * Implements the Spring RowMapper, capable of returning an appropriate object model from a result set.
 * This mapper returns objects that can be cast to a SimpleSpecie Object.
 *
 */
public class SimpleSpecieMapper implements RowMapper{

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		SimpleSpecie ss = new SimpleSpecie();
		ss.setItemId(rs.getLong("species_id"));
		ss.setName(rs.getString("name"));
		ss.setIdentified(rs.getBoolean("identified"));
		ss.setCarbons(rs.getInt("fa_carbons"));
		ss.setDoubleBonds(rs.getInt("fa_double_bonds"));
		ss.setFormula(rs.getString("formula"));
		ss.setMass(rs.getFloat("exact_mass"));
		return ss;
	}

}
