package org.csoft.coupen.restapi;

import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/coupens")
public class CoupenRestApi {

	@GetMapping(value = "/getcoupencode")
	public String getCoupenCode() {
		Random random =new Random();
		return "MaxCoup"+ random.nextInt(200);
	}
	
}
