package com.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class TrackerRfpCompleteRowMapper implements RowMapper<TrackerRfp> {

	@Override
	public TrackerRfp mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		TrackerRfp complete = new TrackerRfp();
		complete.setRfpr_id(rs.getInt("rfpr_id"));
		complete.setRpfd_reviewedby(rs.getString("rpfd_reviewedby"));
		complete.setRfpd_desc(rs.getString("rfpd_desc"));
		complete.setRpdf_status(rs.getString("rpdf_status"));
		complete.setRfpd_type(rs.getString("rfpd_type"));
		complete.setRfpd_sharedstatus(rs.getString("rfpd_sharedstatus"));
		return complete;
	}

}
