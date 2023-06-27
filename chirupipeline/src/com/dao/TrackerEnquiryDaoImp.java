
package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.model.EnquiryRowMapper;
import com.model.RejectEnquiry;
import com.model.RejectRfp;
import com.model.RejectRfpRowMapper;
import com.model.RejectRowMapper;
import com.model.TrackerEnquiry;
import com.model.TrackerRfp;
import com.model.TrackerRfpCompleteRowMapper;

public class TrackerEnquiryDaoImp implements TrackerEnquiryDao {

	@Autowired
	private JdbcTemplate jdbctemplate;

	@Override
	public List<TrackerEnquiry> getEnquiryById() {
		// TODO Auto-generated method stub
		String trackerenquiry = "SELECT DISTINCT te.enqr_id, te.enqr_cust_id, te.enqr_createdby, te.enqr_subject, te.enqr_assigned_to, te.enqr_luser FROM tracker_enquiries te  JOIN rejectedenquiries rd ON te.enqr_id != rd.e_id ORDER BY te.enqr_id ";
		return jdbctemplate.query(trackerenquiry, new EnquiryRowMapper());
	}

	@Override
	public List<RejectEnquiry> getenquiryreject() {
		// TODO Auto-generated method stub
		String enquiryreject = "select rd.e_id ,te.enqr_id,te.enqr_cust_id,te.enqr_createdby,te.enqr_subject,te.enqr_luser  from tracker_enquiries te join rejectedenquiries rd on te.enqr_id=rd.e_id  ";
		return jdbctemplate.query(enquiryreject, new RejectRowMapper());
	}

	@Override
	public List<TrackerEnquiry> getenquiryapprove() {
		// TODO Auto-generated method stub
		String enquiryapprove = "select enqr_id,enqr_cust_id,enqr_createdby,enqr_subject,enqr_assigned_to,enqr_luser from tracker_enquiries where enqr_id not in (select e_id from rejectedenquiries)";
		return jdbctemplate.query(enquiryapprove, new EnquiryRowMapper());
	}

	@Override
	public List<RejectRfp> getconverttorfp() {
		// TODO Auto-generated method stub
		String convertrfp = "select rfpr_enqr_id,rfpr_created_ausr_id,rfpr_status,rfpr_assignedto,rfpr_subject,rfpr_intro_note from tracker_rfp";
		return jdbctemplate.query(convertrfp, new RejectRfpRowMapper());
	}

	@Override
	public List<RejectRfp> getrfpreject() {
		// TODO Auto-generated method stub
		String rfpreject = "select rfpr_enqr_id,rfpr_created_ausr_id,rfpr_status,rfpr_assignedto,rfpr_subject,rfpr_intro_note from  tracker_rfp  where rfpr_id  in  (select rej_rfpr_id from rejected_rfps)";
		return jdbctemplate.query(rfpreject, new RejectRfpRowMapper());
	}

	@Override
	public List<RejectRfp> getRfpApprove() {
		// TODO Auto-generated method stub
		String rfpapprove = "select rfpr_enqr_id,rfpr_created_ausr_id,rfpr_status,rfpr_assignedto,rfpr_subject,rfpr_intro_note from  tracker_rfp  where rfpr_status='RFPR_COMPLETED'";
		return jdbctemplate.query(rfpapprove, new RejectRfpRowMapper());
	}

	@Override
	public List<TrackerRfp> getcompleted() {
		// TODO Auto-generated method stub
		String complete = "select rfpr_id,rpfd_reviewedby,rfpd_desc,rpdf_status,rfpd_type,rfpd_sharedstatus from tracker_rfpr_documents where rpdf_status='Completed'";
		return jdbctemplate.query(complete, new TrackerRfpCompleteRowMapper());
	}

}