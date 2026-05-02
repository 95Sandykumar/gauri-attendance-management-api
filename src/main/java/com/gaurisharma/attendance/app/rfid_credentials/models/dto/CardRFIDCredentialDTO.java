

package com.gaurisharma.attendance.app.rfid_credentials.models.dto;

import com.gaurisharma.attendance.enums.Mode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CardRFIDCredentialDTO {

	private String hashedLrn;
	private Mode mode;
}