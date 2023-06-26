package com.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;

import com.model.RejectEnquiry;
import com.model.RejectEnquiryDTO;
import com.model.RejectRfp;
import com.model.RejectRfpDTO;
import com.model.TrackerEnquiry;
import com.model.TrackerEnquiryDTO;
import com.model.TrackerRfp;
import com.model.TrackerRfpDTO;

@Component
public class TrackerEnquiryDaoImpl implements TrackerEnquiryDao {

	@PersistenceContext
	private EntityManager entityManagerFactory;

	@Override
	public List<TrackerEnquiryDTO> getEnquiryId(int enqid) {
		// TODO Auto-generated method stub
		TypedQuery<TrackerEnquiry> enquiry = entityManagerFactory
				.createQuery("select enqr_id from tracker_enquiries where enqr_id=:enqid", TrackerEnquiry.class);
		enquiry.setParameter("enqid", enqid);
		List<TrackerEnquiry> tracenq = enquiry.getResultList();
		System.out.println(enqid);

		List<TrackerEnquiryDTO> trackerenquirylist = new ArrayList<>();

		return trackerenquirylist;

	}

	@Override
	public List<RejectEnquiryDTO> getEnquiryReject(int rejid) {
		// TODO Auto-generated method stub
		TypedQuery<RejectEnquiry> rejectenquiry = entityManagerFactory.createQuery(
				"select rd.e_id ,te.enqr_id,te.enqr_cust_id,te.enqr_createdby,te.enqr_subject,te.enqr_luser  from tracker_enquiries te join rejectedenquiries rd on te.enqr_id=rd.e_id where rd.e_id =:rejid",
				RejectEnquiry.class);
		List<RejectEnquiry> rejectenq = rejectenquiry.getResultList();
		rejectenquiry.setParameter("rejid", rejid);

		List<RejectEnquiryDTO> rejectenquirylist = new ArrayList<>();

		return rejectenquirylist;
	}

	@Override
	public List<TrackerRfpDTO> getEnquiryApprove(int enqapprid) {
		// TODO Auto-generated method stub
		TypedQuery<TrackerRfp> enqapprove = entityManagerFactory.createQuery(
				"select enqr_id,enqr_cust_id,enqr_createdby,enqr_subject,enqr_assigned_to,enqr_luser from tracker_enquiries where enqr_status='ENQR_COMPLETED' where  enqr_id=:enqapprid",
				TrackerRfp.class);
		List<TrackerRfp> enqapprov = enqapprove.getResultList();
		enqapprove.setParameter("enqapprid", enqapprid);
		List<TrackerRfpDTO> trackerrfpdtolist = new ArrayList<>();

		return trackerrfpdtolist;
	}

	@Override
	public List<TrackerRfpDTO> getConvertToRfp(int convertrfpid) {
		// TODO Auto-generated method stub
		TypedQuery<TrackerRfp> convertrfp = entityManagerFactory.createQuery(
				"select rfpr_enqr_id,rfpr_created_ausr_id,rfpr_status,rfpr_assignedto,rfpr_subject,rfpr_intro_note from tracker_rfp where rfpr_enqr_id=:convertrfpid",
				TrackerRfp.class);
		List<TrackerRfp> convertrfpp = convertrfp.getResultList();
		convertrfp.setParameter("convertrfpid", convertrfpid);
		List<TrackerRfpDTO> trackerrfpdtolist = new ArrayList<>();

		return trackerrfpdtolist;
	}

	@Override
	public List<RejectRfpDTO> getRfpReject(int rfprid) {
		// TODO Auto-generated method stub
		TypedQuery<RejectRfp> rfpreject = entityManagerFactory.createQuery(
				"select tr.rfpr_enqr_id,tr.rfpr_created_ausr_id,tr.rfpr_status,tr.rfpr_assignedto,tr.rfpr_subject,tr.rfpr_intro_note from  tracker_rfp tr join rejected_rfps rr on rfpr_enqr_id=rej_rfpr_id where rfpr_enqr_id=:rfprid",
				RejectRfp.class);

		List<RejectRfp> rejectrfp = rfpreject.getResultList();
		rfpreject.setParameter("rfprid", rfprid);
		List<RejectRfpDTO> rejectrfplist = new ArrayList<>();

		return rejectrfplist;

	}

	@Override
	public List<TrackerRfpDTO> getRfpApprove(int rfpappid) {
		// TODO Auto-generated method stub

		TypedQuery<TrackerRfp> rfptracker = entityManagerFactory.createQuery(
				"select rfpr_enqr_id,rfpr_created_ausr_id,rfpr_status,rfpr_assignedto,rfpr_subject,rfpr_intro_note from  tracker_rfp  where rfpr_status='RFPR_COMPLETED' and rfpr_enqr_id=: rfpappid",
				TrackerRfp.class);
		List<TrackerRfp> rfpappro = rfptracker.getResultList();
		rfptracker.setParameter("rfpappid", rfpappid);
		List<TrackerRfpDTO> trackerrfpdtolist = new ArrayList<>();

		return trackerrfpdtolist;
	}

}
