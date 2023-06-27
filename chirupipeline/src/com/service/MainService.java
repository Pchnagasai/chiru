package com.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.TrackerEnquiryDao;
import com.model.MainModelForm;
import com.model.RejectEnquiry;
import com.model.RejectRfp;
import com.model.TrackerEnquiry;
import com.model.TrackerRfp;

@Service
public class MainService {
	@Autowired
	private MainModelForm mainmodelform;

	@Autowired
	private TrackerEnquiryDao trackerenquiry;

	public Map<String, Object> checkEnquiryStatu(int id) {
		Map<String, Object> statusMap = new HashMap<>();

		List<RejectEnquiry> rejects = trackerenquiry.getenquiryreject();

		List<RejectRfp> converttorfo = trackerenquiry.getconverttorfp();
		List<RejectRfp> rfpreject = trackerenquiry.getrfpreject();
		List<RejectRfp> rfpapprove = trackerenquiry.getRfpApprove();
		List<TrackerEnquiry> enqrapp = trackerenquiry.getenquiryapprove();
		List<TrackerRfp> rfpcompleted = trackerenquiry.getcompleted();

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
