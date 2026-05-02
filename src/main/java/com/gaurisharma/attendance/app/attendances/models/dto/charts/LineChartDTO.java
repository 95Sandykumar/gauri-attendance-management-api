package com.gaurisharma.attendance.app.attendances.models.dto.charts;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LineChartDTO {

	private List<String> labels;
	private List<Integer> data;
}