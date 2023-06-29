package com.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.TrackerEnquiryDao;
import com.model.RejectEnquiry;
import com.model.RejectRfp;
import com.model.TrackerEnquiry;
import com.model.TrackerRfp;

@Service
public class MainService {

	@Autowired
	private TrackerEnquiryDao trackerenquiry;

	// All the data will be in a list of a class I want to use a In map There is no dublicate's values in a map we can
	// access the
	// only one key one value is coming to the the key will be unique
	// In my requirement the value is will be change every time but the key never change the key is a unique
	// identification of a enquiry's
	public Map<String, Object> checkEnquiryStatu(int id) {

		Map<String, Object> statusMap = new HashMap<>();

		List<RejectEnquiry> rejects = trackerenquiry.getEnquiryReject();

		List<RejectRfp> converttorfo = trackerenquiry.getConvertToRfp();
		List<RejectRfp> rfpreject = trackerenquiry.getRfpReject();
		List<RejectRfp> rfpapprove = trackerenquiry.getRfpApprove();
		List<TrackerEnquiry> enqrapp = trackerenquiry.getEnquiryApprove();
		List<TrackerRfp> rfpcompleted = trackerenquiry.getCompleted();

		// In this condition write every time latest value we can access a data

		for (RejectEnquiry reject : rejects) {
			if (reject.getEnqr_id() == id) {
				statusMap.put("status", "reject");
				statusMap.put("data", reject);
				System.out.println(reject.getEnqid());

				return statusMap;
			}
		}
		for (TrackerEnquiry enqapprove : enqrapp) {
			if (enqapprove.getEnqrid() == id) {
				statusMap.put("status", "Approve");
				statusMap.put("data", enqapprove);
				System.out.println(enqapprove.getEnqrid());

			}
		}

		for (RejectRfp convertrfp : converttorfo) {
			if (convertrfp.getRfprenqrid() == id) {
				statusMap.put("status", "convertrfp");
				statusMap.put("data", convertrfp);

			}
		}

		for (RejectRfp rfprejec : rfpreject) {
			if (rfprejec.getRfprenqrid() == id) {
				statusMap.put("status", "rfpreject");
				statusMap.put("data", rfprejec);
				return statusMap;
			}
		}

		for (RejectRfp rfpapprov : rfpapprove) {
			if (rfpapprov.getRfprenqrid() == id) {
				statusMap.put("status", "rfpapprove");
				statusMap.put("data", rfpapprov);

			}
		}

		for (TrackerRfp rfpcomplete : rfpcompleted) {
			if (rfpcomplete.getRfpr_id() == id) {
				statusMap.put("status", "rfpcomplete");
				statusMap.put("data", rfpcomplete);
				return statusMap;
			}
		}

		return statusMap;
	}
}
