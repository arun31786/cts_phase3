package com.cognizant.validator;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ValidatedAccountController {

//	http://localhost:8080/BaseCodeSlice_MyAssessmentApplication/mvc/validateAccount
	@RequestMapping(value="/validateAccount", method=RequestMethod.GET)
    public String loadFormPage(Model m) {
        m.addAttribute("validatedAccount", new ValidatedAccount());
        return "accountHome";
    }

//	http://localhost:8080/BaseCodeSlice_MyAssessmentApplication/mvc/validateAccount
	@RequestMapping(value="/validateAccount", method=RequestMethod.POST)
    public String submitForm(@Valid ValidatedAccount validatedAccount, BindingResult result, Model m) {
        if(result.hasErrors()) {
            return "accountHome";
        }
        m.addAttribute("message", "Successfully saved account: " + validatedAccount);
        return "validAccount";
    }   
	
//	http://localhost:8080/BaseCodeSlice_MyAssessmentApplication/mvc/validateAccount1
	@RequestMapping(value="/validateAccount1", method=RequestMethod.POST)
    public ModelAndView submitForm1(@Valid ValidatedAccount validatedAccount, BindingResult result) {
		System.out.println("hello");
        if(result.hasErrors()) {
            return new ModelAndView("accountHome");
        }
        ModelAndView modelAndView = new ModelAndView("validAccount");
        modelAndView.addObject("message", "Successfully saved account: " + validatedAccount);
//        m.addAttribute("message", "Successfully saved account: " + validatedAccount);
		return modelAndView;
    }
}
