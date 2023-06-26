package com.model;

public class RejectEnquiryDTO {
	private int rid;
	private int e_id;

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public int getE_id() {
		return e_id;
	}

	public void setE_id(int e_id) {
		this.e_id = e_id;
	}

	public static RejectEnquiryDTO formEntity(RejectEnquiry rejectenquiry) {
		RejectEnquiryDTO rejectenquirydto = new RejectEnquiryDTO();
		rejectenquirydto.setE_id(rejectenquiry.getE_id().getEnqrid());

		return rejectenquirydto;
	}

	@Override
	public String toString() {
		return "RejectEnquiryDTO [rid=" + rid + ", e_id=" + e_id + "]";
	}

}
