package com.dao;

import java.util.List;

import com.model.RejectEnquiryDTO;
import com.model.RejectRfpDTO;
import com.model.TrackerEnquiryDTO;
import com.model.TrackerRfpDTO;

public interface TrackerEnquiryDao {
	List<TrackerEnquiryDTO> getEnquiryId(int enqid);

	List<RejectEnquiryDTO> getEnquiryReject(int rejid);

	List<TrackerRfpDTO> getEnquiryApprove(int enqapprid);

	List<TrackerRfpDTO> getConvertToRfp(int convertrfpid);

	List<RejectRfpDTO> getRfpReject(int rfprid);

	List<TrackerRfpDTO> getRfpApprove(int rfpappid);
}
