
package com.dao;

import java.util.List;

import com.model.RejectEnquiry;
import com.model.RejectRfp;
import com.model.TrackerEnquiry;
import com.model.TrackerRfp;

public interface TrackerEnquiryDao {
	// we can access the model class in TrackerEnquiry pojoClass
	List<TrackerEnquiry> getEnquiry();

	List<RejectEnquiry> getEnquiryReject();

	List<TrackerEnquiry> getEnquiryApprove();

	List<RejectRfp> getConvertToRfp();

	List<RejectRfp> getRfpReject();

	List<RejectRfp> getRfpApprove();

	List<TrackerRfp> getCompleted();

}