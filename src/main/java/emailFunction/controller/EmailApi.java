package emailFunction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;

import emailFunction.entity.CommonResponse;
import emailFunction.service.EmailService;



@RestController
public class EmailApi {
	
	@Autowired 
	private EmailService emailService;

	  @PostMapping(value="/RSUpdateVisitedStatus")
	   public CommonResponse visitedStatusUpdate(@RequestBody JsonNode reqObj) {
		   CommonResponse commonResponse=null;
		   try {
			  // JsonNode userData = reqObj.get("BookingStatusOperation").get("rs_add_recin");
			   commonResponse=emailService.visitedStatusUpdate();
		   }catch (Exception e) {
				commonResponse = new CommonResponse() ;
				commonResponse. setResponseCode (1) ;
				commonResponse.setResponseMessage("Exception occured in Controller"); 
				commonResponse. setResponseStatus ("Failure") ;
		}
		   return commonResponse;
}
}