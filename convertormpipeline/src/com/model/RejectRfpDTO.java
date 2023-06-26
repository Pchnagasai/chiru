package com.model;

public class RejectRfpDTO {
	private int rej_id;
	private int rej_rfpr_id;

	public int getRej_id() {
		return rej_id;
	}

	public void setRej_id(int rej_id) {
		this.rej_id = rej_id;
	}

	public int getRej_rfpr_id() {
		return rej_rfpr_id;
	}

	public void setRej_rfpr_id(int rej_rfpr_id) {
		this.rej_rfpr_id = rej_rfpr_id;
	}

	public static RejectRfpDTO formEntity(RejectRfp rejectrfp) {
		RejectRfpDTO rejectrfpdto = new RejectRfpDTO();

		rejectrfpdto.setRej_rfpr_id(rejectrfp.getRej_rfpr_id().getRfprid());

		return rejectrfpdto;
	}

	@Override
	public String toString() {
		return "RejectRfpDTO [rej_id=" + rej_id + ", rej_rfpr_id=" + rej_rfpr_id + "]";
	}

}
