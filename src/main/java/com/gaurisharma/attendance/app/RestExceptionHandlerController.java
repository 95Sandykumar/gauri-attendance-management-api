package com.gaurisharma.attendance.app;

import com.gaurisharma.attendance.models.MessageResponse;
import com.gaurisharma.attendance.enums.ExecutionStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestController
public class RestExceptionHandlerController {

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<?> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
		return ResponseEntity.badRequest().body(
			new MessageResponse(
				ex.getMessage(),
				ExecutionStatus.FAILED
			)
		);
	}

	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<?> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex) {
		return ResponseEntity.badRequest().body(
			new MessageResponse(
				ex.getMessage(),
				ExecutionStatus.FAILED
			)
		);
	}
}