package com.gaurisharma.attendance.models;

import com.gaurisharma.attendance.enums.ExecutionStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MessageResponse {

	private String message;
	private ExecutionStatus status;
}