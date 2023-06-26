package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.service.PipelineService;

@Controller
public class TrackerEnquiryController {
	@Autowired
	private PipelineService pipelineservice;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getEnquiry(Model model) {

		return "Piplinejsp";

	}

}
