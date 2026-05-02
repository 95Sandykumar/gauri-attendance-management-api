

package com.gaurisharma.attendance.app.rfid_credentials.models.entities;

import com.gaurisharma.attendance.app.rfid_credentials.models.dto.RFIDCredentialDTO;
import com.gaurisharma.attendance.app.students.models.entities.Student;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "rfid_credentials")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RFIDCredential {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rfid_credentials_id_gen")
	@SequenceGenerator(name = "rfid_credentials_id_gen", sequenceName = "rfid_credentials_id_seq", allocationSize = 1)
	@Column(name = "id", nullable = false)
	private Integer id;

	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "lrn", nullable = false)
	private Student lrn;

	@Column(name = "hashed_lrn", nullable = false, length = 32)
	private String hashedLrn;

	@Column(name = "salt", nullable = false, length = 16)
	private String salt;

	public RFIDCredentialDTO toDTO() {
		return new RFIDCredentialDTO(id, lrn.toDTO(), hashedLrn, salt);
	}
}