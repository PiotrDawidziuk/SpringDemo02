package pl.piotrdawidziuk.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ParamController {
	
	@GetMapping("/api/foos")
	@ResponseBody
	public String getFoos(@RequestParam String id) {
	    return "ID: " + id;
	}
	
	@PostMapping("/api/foos")
	@ResponseBody
	public String addFoo(@RequestParam(name = "id") String fooId, @RequestParam String name) { 
	    return "ID: " + fooId + " Name: " + name;
	}
	
	@GetMapping("/api/optionalfoos")
	@ResponseBody
	public String getOptionalFoos(@RequestParam(required = false) String id) { 
	    return "ID: " + id;
	}
	
	@GetMapping("/api/defaultfoos")
	@ResponseBody
	public String getDefaultFoos(@RequestParam(defaultValue = "test") String id) {
	    return "ID: " + id;
	}
	
	@PostMapping("/api/mapoffoos")
	@ResponseBody
	public String updateFoos(@RequestParam Map<String,String> allParams) {
	    return "Parameters are " + allParams.entrySet();
	}
	
	@GetMapping("/api/listoffoos")
	@ResponseBody
	public String getFoos(@RequestParam List<String> id) {
	    return "IDs are " + id;
	}
	
	@GetMapping("test/params")
	@ResponseBody
	public String getParams(@RequestParam(name = "losowo", defaultValue = "0") int random, 
			@RequestParam(name = "rozdzielczosc") String res, 
			@RequestParam (name="zdjecia") List<String> links) {
				
		return "Params are: \n is random: " + random+"\n resolution: "+res+ "\n links are: " +links;
	}

}
