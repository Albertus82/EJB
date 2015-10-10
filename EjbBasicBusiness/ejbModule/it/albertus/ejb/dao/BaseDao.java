package it.albertus.ejb.dao;

import javax.annotation.Resource;
import javax.sql.DataSource;

public class BaseDao {

	@Resource(lookup = "java:/MyDataSource")
	private DataSource dataSource;

	public DataSource getDataSource() {
		return this.dataSource;
	}

}
