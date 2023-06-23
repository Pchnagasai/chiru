package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.MainModelForm;
import com.model.RejectEnquiry;
import com.model.RejectRfp;
import com.model.TrackerEnquiry;

@Service
public class MainService {
	@Autowired
	private MainModelForm mainmodelform;

	public String checkEnquiryStatus(int id) {
		List<TrackerEnquiry> enquiries = mainmodelform.getTrackerenquiry();

		List<RejectEnquiry> rejects = mainmodelform.getRejectenquiry();

		List<TrackerEnquiry> approve = mainmodelform.getTrackerenquiry();

		List<TrackerEnquiry> converttorfo = mainmodelform.getConvertrfp();
		List<RejectRfp> rfpreject = mainmodelform.getRejectrfp();
		List<RejectRfp> rfpapprove = mainmodelform.getRfpapproive();

		boolean isRejected = false;
		for (RejectEnquiry reject : rejects) {
			if (reject.getEnqr_id() == id) {

				return "reject";

			}
		}

		String temp = "";

		for (TrackerEnquiry convertrfp : converttorfo) {
			if (convertrfp.getEnqrid() == id) {

			}
		}

		return null;
	}

}
