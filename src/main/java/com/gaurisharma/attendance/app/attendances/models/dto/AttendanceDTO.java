

package com.gaurisharma.attendance.app.attendances.models.dto;

import com.gaurisharma.attendance.app.students.models.dto.StudentDTO;
import com.gaurisharma.attendance.app.attendances.models.entities.Attendance;
import com.gaurisharma.attendance.enums.AttendanceStatus;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

/**
 * DTO for {@link Attendance}
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AttendanceDTO implements Serializable {
	private Integer id;
	private StudentDTO student;
	private AttendanceStatus attendanceStatus;
	private LocalDate date;
	private LocalTime time;
	private LocalTime timeOut;

	public Attendance toEntity() {
		return new Attendance(
			id,
			student.toEntity(),
			attendanceStatus,
			date,
			time,
			timeOut
		);
	}
}