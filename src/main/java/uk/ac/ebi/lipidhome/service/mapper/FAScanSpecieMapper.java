package uk.ac.ebi.lipidhome.service.mapper;

import org.springframework.jdbc.core.RowMapper;
import uk.ac.ebi.lipidhome.core.model.FAScanSpecie;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Antonio Fabregat <fabregat@ebi.ac.uk>
 * @author Joe Foster <jfoster@ebi.ac.uk>
 *
 * Implements the Spring RowMapper, capable of returning an appropriate object model from a result set.
 * This mapper returns objects that can be cast to a FAScanSpecie Object.
 *
 */
public class FAScanSpecieMapper implements RowMapper{

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		FAScanSpecie fass = new FAScanSpecie();
		fass.setItemId(rs.getLong("FA_scan_species_id"));
		fass.setName(rs.getString("name"));
		fass.setModel(rs.getString("model"));
		fass.setFormula(rs.getString("formula"));
		fass.setMass(rs.getDouble("exact_mass"));
		fass.setIdentified(rs.getBoolean("identified"));
		return fass;
	}

}
