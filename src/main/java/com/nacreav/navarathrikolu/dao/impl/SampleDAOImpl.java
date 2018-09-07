package com.nacreav.navarathrikolu.dao.impl;

import java.util.List;
import java.util.Map;

public class SampleDAOImpl {
	public String test() {
		List<Map<String, Object>> result = DBConnectionUtil.getInstance().getJdbcTemplate().queryForList("select sysdate()");
		return result.toString();
	}
}
