package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tracker_enquiries")
public class TrackerEnquiry {
	@Id
	@Column(name = "enqr_id")
	private int enqrid;

	@Column(name = "enqr_cust_id")
	private int enqcustid;
	@Column(name = "enqr_createdby")
	private String enqrcreatedby;
	@Column(name = "enqr_subject")
	private String enqrsubject;
	@Column(name = "enqr_assigned_to")
	private String enqrassignto;
	@Column(name = "enqr_luser")
	private String enqrluser;

	public int getEnqrid() {
		return enqrid;
	}

	public void setEnqrid(int enqrid) {
		this.enqrid = enqrid;
	}

	public int getEnqcustid() {
		return enqcustid;
	}

	public void setEnqcustid(int enqcustid) {
		this.enqcustid = enqcustid;
	}

	public String getEnqrcreatedby() {
		return enqrcreatedby;
	}

	public void setEnqrcreatedby(String enqrcreatedby) {
		this.enqrcreatedby = enqrcreatedby;
	}

	public String getEnqrsubject() {
		return enqrsubject;
	}

	public void setEnqrsubject(String enqrsubject) {
		this.enqrsubject = enqrsubject;
	}

	public String getEnqrassignto() {
		return enqrassignto;
	}

	public void setEnqrassignto(String enqrassignto) {
		this.enqrassignto = enqrassignto;
	}

	public String getEnqrluser() {
		return enqrluser;
	}

	public void setEnqrluser(String enqrluser) {
		this.enqrluser = enqrluser;
	}

	@Override
	public String toString() {
		return "TrackerEnquiry [enqrid=" + enqrid + ", enqcustid=" + enqcustid + ", enqrcreatedby=" + enqrcreatedby
				+ ", enqrsubject=" + enqrsubject + ", enqrassignto=" + enqrassignto + ", enqrluser=" + enqrluser + "]";
	}

}
