package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tracker_rfp")
public class TrackerRfp {
	@Id
	@Column(name = "rfpr_id")
	private int rfprid;
	@OneToOne
	@JoinColumn(name = "rfpr_enqr_id")
	private TrackerEnquiry rfprenqrid;
	@Column(name = "rfpr_created_ausr_id")
	private String rfpr_created_ausr_id;
	@Column(name = "rfpr_status")
	private String rfpr_status;
	@Column(name = "rfpr_assignedto")
	private String rfpr_assignedto;
	@Column(name = "rfpr_subject")
	private String rfpr_subject;
	@Column(name = "rfpr_intro_note")
	private String rfpr_intro_note;

	public String getRfpr_created_ausr_id() {
		return rfpr_created_ausr_id;
	}

	public void setRfpr_created_ausr_id(String rfpr_created_ausr_id) {
		this.rfpr_created_ausr_id = rfpr_created_ausr_id;
	}

	public String getRfpr_status() {
		return rfpr_status;
	}

	public void setRfpr_status(String rfpr_status) {
		this.rfpr_status = rfpr_status;
	}

	public String getRfpr_assignedto() {
		return rfpr_assignedto;
	}

	public void setRfpr_assignedto(String rfpr_assignedto) {
		this.rfpr_assignedto = rfpr_assignedto;
	}

	public String getRfpr_subject() {
		return rfpr_subject;
	}

	public void setRfpr_subject(String rfpr_subject) {
		this.rfpr_subject = rfpr_subject;
	}

	public String getRfpr_intro_note() {
		return rfpr_intro_note;
	}

	public void setRfpr_intro_note(String rfpr_intro_note) {
		this.rfpr_intro_note = rfpr_intro_note;
	}

	public int getRfprid() {
		return rfprid;
	}

	public void setRfprid(int rfprid) {
		this.rfprid = rfprid;
	}

	public TrackerEnquiry getRfprenqrid() {
		return rfprenqrid;
	}

	public void setRfprenqrid(TrackerEnquiry rfprenqrid) {
		this.rfprenqrid = rfprenqrid;
	}

	@Override
	public String toString() {
		return "TrackerRfp [rfprid=" + rfprid + ", rfprenqrid=" + rfprenqrid + ", rfpr_created_ausr_id="
				+ rfpr_created_ausr_id + ", rfpr_status=" + rfpr_status + ", rfpr_assignedto=" + rfpr_assignedto
				+ ", rfpr_subject=" + rfpr_subject + ", rfpr_intro_note=" + rfpr_intro_note + "]";
	}

}
