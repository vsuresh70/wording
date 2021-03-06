package com.geogrep.wording;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.geogrep.wording.NumberToWordService;
/**
 * REST service provider
 * 
 * Only GET and POST will return values
 * PUT and DELETE will not.
 * 
 * @author svelusamy
 */

@Controller
public class NumberToWordController {

	protected static Logger logger = Logger.getLogger("controller");
	
	@Resource(name="numberToWordService")
	private NumberToWordService numberToWordService;
	

    @RequestMapping(value = "/{id}", 
			method = RequestMethod.GET, 
			headers="Accept=application/html, application/xhtml+xml")
	public String getWord(@PathVariable("id") String id, Model model) {
		logger.info("Provider has received request to get person with id: " + id);
		String num2Word = "";
		long param = 0;
		try  {  
			param = Long.parseLong(id);  
		  }  
		catch(NumberFormatException nfe) {  
			model.addAttribute("num2word"," not a valid number");
			return "num2word";
		  } 
			// Call service to here
		num2Word = numberToWordService.convert(param);
		logger.info("The returned word :"+num2Word);
		model.addAttribute("num2word",num2Word);
		
		// This will resolve to /WEB-INF/jsp/num2word.jsp
		return "num2word";
	}

}
