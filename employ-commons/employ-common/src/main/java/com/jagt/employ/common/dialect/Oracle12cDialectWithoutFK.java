package com.jagt.employ.common.dialect;

import org.hibernate.dialect.Oracle12cDialect;
import org.hibernate.dialect.identity.IdentityColumnSupport;

public class Oracle12cDialectWithoutFK extends Oracle12cDialect{
	
	@Override
	public String getAddForeignKeyConstraintString(
			String constraintName,
			String foreignKeyDefinition) {
		return "";
//		return new StringBuilder( 30 )
//				.append( " add constraint " )
//				.append( quote( constraintName ) )
//				.append( " " )
//				.append( foreignKeyDefinition )
//				.toString();
	}

	@Override
	public String getAddForeignKeyConstraintString(
			String constraintName,
			String[] foreignKey,
			String referencedTable,
			String[] primaryKey,
			boolean referencesPrimaryKey) {
		return "";
//		final StringBuilder res = new StringBuilder( 30 );
//
//		res.append( " add constraint " )
//				.append( quote( constraintName ) )
//				.append( " foreign key (" )
//				.append( StringHelper.join( ", ", foreignKey ) )
//				.append( ") references " )
//				.append( referencedTable );
//
//		if ( !referencesPrimaryKey ) {
//			res.append( " (" )
//					.append( StringHelper.join( ", ", primaryKey ) )
//					.append( ')' );
//		}
//
//		return res.toString();
	}

	@Override
	public IdentityColumnSupport getIdentityColumnSupport() {
		return new Oracle12cIdentityColumnSupportWithoutIdentify();
	}
}
