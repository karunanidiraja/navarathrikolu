package com.nacreav.navarathrikolu.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nacreav.navarathrikolu.dao.impl.SampleDAOImpl;

@RestController
public class SampleController {
	@RequestMapping(path = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
	public String getXML() {
		SampleDAOImpl dao = new SampleDAOImpl();
		return "<user>" + dao.test() + "</user>";
	}

}
