package com.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dao.TrackerEnquiryDao;

@Component
public class PipelineService {
	@Autowired
	private TrackerEnquiryDao trackerenquirydao;

	public Map<String, Object> checkEnquiryStatu() {

		Map<String, Object> statusMap = new HashMap<>();

		return statusMap;

	}

}
