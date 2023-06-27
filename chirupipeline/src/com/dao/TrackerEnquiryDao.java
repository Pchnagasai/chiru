
package com.dao;

import java.util.List;

import com.model.RejectEnquiry;
import com.model.RejectRfp;
import com.model.TrackerEnquiry;
import com.model.TrackerRfp;

public interface TrackerEnquiryDao {

	List<TrackerEnquiry> getEnquiryById();

	List<RejectEnquiry> getenquiryreject();

	List<TrackerEnquiry> getenquiryapprove();

	List<RejectRfp> getconverttorfp();

	List<RejectRfp> getrfpreject();

	List<RejectRfp> getRfpApprove();

	List<TrackerRfp> getcompleted();

}