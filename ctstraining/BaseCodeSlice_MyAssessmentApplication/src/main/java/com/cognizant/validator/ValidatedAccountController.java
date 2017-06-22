package com.cognizant.validator;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
}
