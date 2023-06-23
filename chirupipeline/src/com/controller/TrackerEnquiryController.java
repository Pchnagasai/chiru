
package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dao.TrackerEnquiryDao;
import com.model.MainModelForm;
import com.model.RejectEnquiry;
import com.model.RejectRfp;
import com.model.TrackerEnquiry;
import com.service.MainService;

@Controller
public class TrackerEnquiryController {
	@Autowired
	private TrackerEnquiryDao trackerenquirydao;
	@Autowired
	private MainModelForm mainmodelform;
	@Autowired
	private MainService mainservice;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getEnquiryid(Model model) {

		List<TrackerEnquiry> enquiry = trackerenquirydao.getEnquiryById();

		for (TrackerEnquiry x : enquiry) {
			System.out.println(x);
		}
		model.addAttribute("enquiry", enquiry);

		List<RejectEnquiry> reject = trackerenquirydao.getenquiryreject();
		for (RejectEnquiry x : reject) {
			System.out.println(x);
		}

		model.addAttribute("reject", reject);

		List<TrackerEnquiry> approve = trackerenquirydao.getenquiryapprove();
		for (TrackerEnquiry x : approve) {
			System.out.println(x);
		}
		model.addAttribute("approve", approve);

		List<TrackerEnquiry> converttorfo = trackerenquirydao.getconverttorfp();

		for (TrackerEnquiry x : converttorfo) {
			System.out.println(x);
		}
		model.addAttribute("converttorfo", converttorfo);

		List<RejectRfp> rfpreject = trackerenquirydao.getrfpreject();
		for (RejectRfp x : rfpreject) {
			System.out.println(x);
		}
		model.addAttribute("rfpreject", rfpreject);

		List<RejectRfp> rfpapprove = trackerenquirydao.getRfpApprove();
		for (RejectRfp x : rfpapprove) {
			System.out.println(x);
		}
		model.addAttribute("rfpapprove", rfpapprove);

		mainmodelform.setTrackerenquiry(enquiry);

		return "Enquirystage";

	}

	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public ResponseEntity<String> getform(@RequestParam("id") String id) {
		System.out.println(id);
		String data = mainservice.checkEnquiryStatus(Integer.parseInt(id.trim()));
		return ResponseEntity.ok(data);
	}

}
