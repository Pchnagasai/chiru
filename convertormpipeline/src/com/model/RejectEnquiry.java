package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "rejectedenquiries")
public class RejectEnquiry {

	@Id
	@Column(name = "rid")
	private int rid;
	@OneToOne
	@JoinColumn(name = "e_id")
	private TrackerEnquiry e_id;

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public TrackerEnquiry getE_id() {
		return e_id;
	}

	public void setE_id(TrackerEnquiry e_id) {
		this.e_id = e_id;
	}

	@Override
	public String toString() {
		return "RejectEnquiry [rid=" + rid + ", e_id=" + e_id + "]";
	}

}
