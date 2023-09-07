package bbsWs.ws.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {

	@GetMapping("/getDocker")
	public String getDocker()
	{
		return "this is docker";
	}
}
