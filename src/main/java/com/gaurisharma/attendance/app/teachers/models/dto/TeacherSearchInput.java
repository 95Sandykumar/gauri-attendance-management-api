package com.gaurisharma.attendance.app.teachers.models.dto;

import com.gaurisharma.attendance.app.students.enums.Sex;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TeacherSearchInput {

	private String firstName;
	private String lastName;
	private Sex sex;
	
}
