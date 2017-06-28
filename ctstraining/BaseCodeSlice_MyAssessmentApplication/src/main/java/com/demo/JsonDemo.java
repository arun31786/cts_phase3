package com.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cognizant.entity.Employee;

@Controller
public class JsonDemo {
	
//	http://localhost:8080/BaseCodeSlice_MyAssessmentApplication/mvc/jsonDemo
	@RequestMapping(value="/jsonDemo", method=RequestMethod.GET)
		public String getHomePage(Model model){
		model.addAttribute("title", "HomePage");
		return "jsonConsumer";
	}

	@RequestMapping(value="/getJson",method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody  List<String> getJsonEmployees(){
		return this.JsonResponse();
	}
	
	private List<String> JsonResponse(){
		List<String> list = new ArrayList<String>();
		list.add("Mohan");
		list.add("Ramesh");
		list.add("Miley");
		list.add("Carl");
		return list;
	}

}
