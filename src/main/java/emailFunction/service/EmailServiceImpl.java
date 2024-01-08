package emailFunction.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import emailFunction.entity.AppointmentStatus;
import emailFunction.entity.BookingAppointment;
import emailFunction.entity.CommonResponse;
import emailFunction.repository.BookingRepository;
import jakarta.transaction.Transactional;



@Service
@Transactional
public class EmailServiceImpl implements EmailService{
   
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private BookingRepository bookingRepo;
	
	@Scheduled(initialDelay=3000,fixedDelay = 60000)
	@Override
public CommonResponse mailSender() {
		
		CommonResponse response=new CommonResponse();
		
		try {
			System.out.print("running");
			List<BookingAppointment> booking=bookingRepo.finByAppointmentDate(); 
			System.out.print(booking);
			 for(BookingAppointment b:booking) {
				 
				 
				 System.out.println(b);
				 
	                	 SimpleMailMessage message=new SimpleMailMessage();
	                	 message.setFrom("aag281@gmail.com");
	                	 message.setTo(b.getEmail());
	            	     message.setText("Hi "+b.getFirstName()+" "+b.getLastName() +","+ "\n"
	            	     		+ "Your appointment has been confirmed.\n"
	            	    	        + "Booking Date: " + b.getAppointmentDate() + "\n"
	            	    	        + "Booking Time: " + b.getAppointmentTime());
	                	 message.setSubject("Rosa Healthcare Appointment Confirmation");
	                	 mailSender.send (message);
	                	 response.setResponseCode(1);
	            		 response.setResponseMessage("Mail  is Sent");
	            		 response.setResponseStatus("Success");
	            		 
	                }	
			 
			
}catch (Exception e) {
	e.printStackTrace();
	response.setResponseCode(1);
	response.setResponseMessage("Exception Occured while Sending Mail");
	response.setResponseStatus("Failure");
}
		return response;
}

	@Scheduled(initialDelay=3000,fixedDelay = 90000)
	@Override
	public CommonResponse visitedStatusUpdate() {
		// TODO Auto-generated method stub
		CommonResponse response=new CommonResponse();
		try {
			
			List<BookingAppointment>booking=bookingRepo.findyByEndTime();
			booking.stream()
            .filter(book -> book.getAppointmentStatus() == AppointmentStatus.Pending)
            .forEach(b -> {
                b.setAppointmentStatus(AppointmentStatus.Notvisited);
                bookingRepo.save(b);
            });

			
				response.setResponseCode(0);
				response.setResponseMessage("Status marked has not Visited");
				response.setResponseStatus("Success");
			
		} catch (Exception e) {
			// TODO: handle exception
		      
					e.printStackTrace();
					response.setResponseCode(1);
					response.setResponseMessage("Exception Occured Updating Appointment Status");
					response.setResponseStatus("Failure");
				
		}
		return response;
	}

	
}
