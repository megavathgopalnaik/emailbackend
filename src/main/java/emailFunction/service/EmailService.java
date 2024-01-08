package emailFunction.service;

import emailFunction.entity.CommonResponse;

public interface EmailService {

	CommonResponse mailSender();

	CommonResponse visitedStatusUpdate();

}
