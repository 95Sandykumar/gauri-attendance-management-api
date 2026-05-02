

package com.gaurisharma.attendance.app.rfid_credentials.models.dto;

import com.gaurisharma.attendance.app.rfid_credentials.models.entities.RFIDCredential;
import com.gaurisharma.attendance.app.students.models.dto.StudentDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link RFIDCredential}
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RFIDCredentialDTO implements Serializable {
	private Integer id;
	private StudentDTO lrn;
	private String hashedLrn;
	private String salt;

	public RFIDCredential toEntity() {
		return new RFIDCredential(
			id,
			lrn.toEntity(),
			hashedLrn,
			salt
		);
	}
}