package jbxq_tzdb.modules.codegen.codegenerator.utils;

import jbxq_tzdb.core.utils.PropertiesUtil;

public class CodeGenUtils {

	public static String getDbType() {
		PropertiesUtil propertiesUtil = new PropertiesUtil("dbconfig.properties");
		String dbType = propertiesUtil.getString("connection.dbType");
		return dbType.toLowerCase();
	}
}
