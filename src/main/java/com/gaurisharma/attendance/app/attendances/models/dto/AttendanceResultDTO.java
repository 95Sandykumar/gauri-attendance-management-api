

package com.gaurisharma.attendance.app.attendances.models.dto;

import com.gaurisharma.attendance.app.students.models.dto.StudentDTO;
import com.gaurisharma.attendance.enums.AttendanceStatus;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AttendanceResultDTO implements Serializable {

	private StudentDTO student;
	private LocalDate date;
	private LocalTime time;
	private LocalTime timeOut;
	private AttendanceStatus attendanceStatus;
	private String message;
	private String hashedLrn;
}