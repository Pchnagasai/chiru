package com.model;

public class TrackerRfp {

	private int rfpr_id;
	private String rpfd_reviewedby;
	private String rfpd_desc;
	private String rpdf_status;
	private String rfpd_type;
	private String rfpd_sharedstatus;

	public int getRfpr_id() {
		return rfpr_id;
	}

	public void setRfpr_id(int rfpr_id) {
		this.rfpr_id = rfpr_id;
	}

	public String getRpfd_reviewedby() {
		return rpfd_reviewedby;
	}

	public void setRpfd_reviewedby(String rpfd_reviewedby) {
		this.rpfd_reviewedby = rpfd_reviewedby;
	}

	public String getRfpd_desc() {
		return rfpd_desc;
	}

	public void setRfpd_desc(String rfpd_desc) {
		this.rfpd_desc = rfpd_desc;
	}

	public String getRpdf_status() {
		return rpdf_status;
	}

	public void setRpdf_status(String rpdf_status) {
		this.rpdf_status = rpdf_status;
	}

	public String getRfpd_type() {
		return rfpd_type;
	}

	public void setRfpd_type(String rfpd_type) {
		this.rfpd_type = rfpd_type;
	}

	public String getRfpd_sharedstatus() {
		return rfpd_sharedstatus;
	}

	public void setRfpd_sharedstatus(String rfpd_sharedstatus) {
		this.rfpd_sharedstatus = rfpd_sharedstatus;
	}

	@Override
	public String toString() {
		return "TrackerRfp [rfpr_id=" + rfpr_id + ", rpfd_reviewedby=" + rpfd_reviewedby + ", rfpd_desc=" + rfpd_desc
				+ ", rpdf_status=" + rpdf_status + ", rfpd_type=" + rfpd_type + ", rfpd_sharedstatus="
				+ rfpd_sharedstatus + "]";
	}

}