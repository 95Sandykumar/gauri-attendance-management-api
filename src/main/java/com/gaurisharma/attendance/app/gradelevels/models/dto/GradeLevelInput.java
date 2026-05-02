package com.gaurisharma.attendance.app.gradelevels.models.dto;

import com.gaurisharma.attendance.app.strands.models.dto.StrandInput;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GradeLevelInput {

	private String name;
	private StrandInput strandInput;
}
