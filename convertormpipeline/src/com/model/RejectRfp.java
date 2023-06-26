package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "rejected_rfps")
public class RejectRfp {
	@Id
	@Column(name = "rej_id")
	private int rej_id;
	@JoinColumn(name = "rej_rfpr_id")
	private TrackerRfp rej_rfpr_id;

	public int getRej_id() {
		return rej_id;
	}

	public void setRej_id(int rej_id) {
		this.rej_id = rej_id;
	}

	public void setRej_rfpr_id(TrackerRfp rej_rfpr_id) {
		this.rej_rfpr_id = rej_rfpr_id;
	}

	public TrackerRfp getRej_rfpr_id() {
		return rej_rfpr_id;
	}

	@Override
	public String toString() {
		return "RejectRfp [rej_id=" + rej_id + ", rej_rfpr_id=" + rej_rfpr_id + "]";
	}

}
