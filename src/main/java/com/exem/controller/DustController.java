package com.exem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.exem.service.DustInfoInsertService;
import com.exem.util.DustInfo;

@Controller
public class DustController {

	@Autowired
	DustInfoInsertService dustService;
	
	@RequestMapping(value="/insertDustInfo.moon", method = RequestMethod.GET)
	public String insertDustInfo() {
		DustInfo dustInfo = new DustInfo();
		dustService.insertDustMeasurement(dustInfo.dustInfo());
		return "home";
	}
	
}
