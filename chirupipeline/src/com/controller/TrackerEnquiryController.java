
package com.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dao.TrackerEnquiryDao;
import com.google.gson.Gson;
import com.model.MainModelForm;
import com.model.RejectEnquiry;
import com.model.RejectRfp;
import com.model.TrackerEnquiry;
import com.model.TrackerRfp;
import com.service.MainService;

@Controller
public class TrackerEnquiryController {

	@Autowired
	private TrackerEnquiryDao trackerenquirydao;
	@Autowired
	private MainModelForm mainmodelform;
	@Autowired
	private MainService mainservice;
	// log4j2
	private static final Logger logger = LoggerFactory.getLogger(TrackerEnquiryController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getEnquiryid(Model model) {
		// all enquiry's details are comes to the list
		logger.info("sucess");

		List<TrackerEnquiry> enquiry = trackerenquirydao.getEnquiry();

		model.addAttribute("enquiry", enquiry);
		logger.info("enquiry");

		// all the reject data we will access a list
		List<RejectEnquiry> reject = trackerenquirydao.getEnquiryReject();

		model.addAttribute("reject", reject);
		logger.info("enquiryreject");
		// all the approve details are comes to the list
		List<TrackerEnquiry> approve = trackerenquirydao.getEnquiryApprove();

		model.addAttribute("approve", approve);
		logger.info("enquiry approve");
		// all the convert to rfp's details are comes to the list
		List<RejectRfp> converttorfo = trackerenquirydao.getConvertToRfp();

		model.addAttribute("converttorfo", converttorfo);
		logger.info("convert to rfp");
		// all the rfp's rejects are comes to and access the list
		List<RejectRfp> rfpreject = trackerenquirydao.getRfpReject();

		model.addAttribute("rfpreject", rfpreject);
		logger.info("rfp reject");
		// all the rfp's approve comes to the list
		List<RejectRfp> rfpapprove = trackerenquirydao.getRfpApprove();

		model.addAttribute("rfpapprove", rfpapprove);
		logger.info("rfp approve");
		// all the rfp's completed are comes to the list
		List<TrackerRfp> rfpcompleted = trackerenquirydao.getCompleted();

		// this model we can access the user interface access the addAttribute and getAttributes
		model.addAttribute("rfpcompleted", rfpcompleted);
		logger.info("rfp completed");
		// The List of data will be set to the Data Transfer Object we will access the data in a service Class
		mainmodelform.setTrackerenquiry(enquiry);
		mainmodelform.setRejectenjuiry(reject);
		mainmodelform.setApproveenquiry(approve);
		mainmodelform.setConvertrfp(converttorfo);
		mainmodelform.setRejectrfp(rfpreject);
		mainmodelform.setRfpapproive(rfpapprove);
		mainmodelform.setRfpcompleted(rfpcompleted);
		model.addAttribute("viewmodel", mainmodelform);

		return "Enquirystage";

	}
	// Request will be goes to the service class this method will be return the map access the data in a object

	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public ResponseEntity<String> getForm(@RequestParam("id") String id, Model model) {
		logger.info("sucess id");
		// String data = mainservice.checkEnquiryStatus(Integer.parseInt(id.trim()));

		Map<String, Object> enquiryStatus = mainservice.checkEnquiryStatu(Integer.parseInt(id.trim()));
		System.out.println(enquiryStatus);
		logger.info("status object");

		new Gson().toJson(enquiryStatus);

		return ResponseEntity.ok(new Gson().toJson(enquiryStatus));

	}

}