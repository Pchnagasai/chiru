package com.model;

public class TrackerEnquiryDTO {
	private int enqr_id;
	private int enqr_cust_id;
	private String enqr_createdby;
	private String enqr_subject;
	private String enqr_assigned_to;
	private String enqr_luser;

	public int getEnqr_id() {
		return enqr_id;
	}

	public void setEnqr_id(int enqr_id) {
		this.enqr_id = enqr_id;
	}

	public int getEnqr_cust_id() {
		return enqr_cust_id;
	}

	public void setEnqr_cust_id(int enqr_cust_id) {
		this.enqr_cust_id = enqr_cust_id;
	}

	public String getEnqr_createdby() {
		return enqr_createdby;
	}

	public void setEnqr_createdby(String enqr_createdby) {
		this.enqr_createdby = enqr_createdby;
	}

	public String getEnqr_subject() {
		return enqr_subject;
	}

	public void setEnqr_subject(String enqr_subject) {
		this.enqr_subject = enqr_subject;
	}

	public String getEnqr_assigned_to() {
		return enqr_assigned_to;
	}

	public void setEnqr_assigned_to(String enqr_assigned_to) {
		this.enqr_assigned_to = enqr_assigned_to;
	}

	public String getEnqr_luser() {
		return enqr_luser;
	}

	public void setEnqr_luser(String enqr_luser) {
		this.enqr_luser = enqr_luser;
	}

	public static TrackerEnquiryDTO fromEntity(TrackerEnquiry trackerenquiry) {
		TrackerEnquiryDTO trackerenquirydto = new TrackerEnquiryDTO();

		trackerenquirydto.setEnqr_id(trackerenquiry.getEnqrid());
		trackerenquirydto.setEnqr_cust_id(trackerenquiry.getEnqcustid());
		trackerenquirydto.setEnqr_createdby(trackerenquiry.getEnqrcreatedby());
		trackerenquirydto.setEnqr_subject(trackerenquiry.getEnqrsubject());
		trackerenquirydto.setEnqr_assigned_to(trackerenquiry.getEnqrassignto());
		trackerenquirydto.setEnqr_luser(trackerenquiry.getEnqrluser());

		return trackerenquirydto;

	}

	@Override
	public String toString() {
		return "TrackerEnquiryDTO [enqr_id=" + enqr_id + ", enqr_cust_id=" + enqr_cust_id + ", enqr_createdby="
				+ enqr_createdby + ", enqr_subject=" + enqr_subject + ", enqr_assigned_to=" + enqr_assigned_to
				+ ", enqr_luser=" + enqr_luser + "]";
	}

}
