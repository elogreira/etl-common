package com.millenium.etl.common.util.hibernate.dialect;

import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import org.hibernate.dialect.PostgreSQL92Dialect;
import org.hibernate.engine.jdbc.env.spi.IdentifierCaseStrategy;
import org.hibernate.engine.jdbc.env.spi.IdentifierHelper;
import org.hibernate.engine.jdbc.env.spi.IdentifierHelperBuilder;

public class PostgreSQL92EtlDialect extends PostgreSQL92Dialect {

	/**
	 * Sobreescribe este método para aplicar la estrategia LOWER en los nombres de las tablas
	 * Útil cuando la propiedad hibernate.temp.use_jdbc_metadata_defaults=false ya que omite esta configuración
	 */
	@Override
	public IdentifierHelper buildIdentifierHelper(IdentifierHelperBuilder builder, DatabaseMetaData dbMetaData)
			throws SQLException {
		builder.setUnquotedCaseStrategy( IdentifierCaseStrategy.LOWER );
		builder.setQuotedCaseStrategy( IdentifierCaseStrategy.LOWER );
		return super.buildIdentifierHelper(builder, dbMetaData);
	}

}
