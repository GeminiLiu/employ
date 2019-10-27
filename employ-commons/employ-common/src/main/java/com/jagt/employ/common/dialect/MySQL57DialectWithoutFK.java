package com.jagt.employ.common.dialect;

import java.sql.Types;

import org.hibernate.dialect.MySQL55Dialect;
import org.hibernate.dialect.function.SQLFunction;
import org.hibernate.dialect.function.StaticPrecisionFspTimestampFunction;

/**
 * @author Gail Badner
 */
public class MySQL57DialectWithoutFK extends MySQL55Dialect {
	public MySQL57DialectWithoutFK() {
		super();
		registerColumnType( Types.TIMESTAMP, "datetime(6)" );
		registerColumnType( Types.JAVA_OBJECT, "json" );
		final SQLFunction currentTimestampFunction = new StaticPrecisionFspTimestampFunction("now", 6 );
		registerFunction( "now", currentTimestampFunction );
		registerFunction( "current_timestamp", currentTimestampFunction );
		registerFunction( "localtime", currentTimestampFunction );
		registerFunction( "localtimestamp", currentTimestampFunction );
		registerFunction( "sysdate", new StaticPrecisionFspTimestampFunction( "sysdate", 6 ) );
	}

	/**
	 * @see <a href="https://dev.mysql.com/worklog/task/?id=7019">MySQL 5.7 work log</a>
	 * @return supports IN clause row value expressions
	 */
	public boolean supportsRowValueConstructorSyntaxInInList() {
		return true;
	}
	
	@Override
	public String getAddForeignKeyConstraintString(
			String constraintName,
			String[] foreignKey,
			String referencedTable,
			String[] primaryKey,
			boolean referencesPrimaryKey) {
		return ""; 
//		final String cols = StringHelper.join( ", ", foreignKey );
//		final String referencedCols = StringHelper.join( ", ", primaryKey );
//		return String.format(
//				" add constraint %s foreign key (%s) references %s (%s)",
//				constraintName,
//				cols,
//				referencedTable,
//				referencedCols
//		);
	}
}
