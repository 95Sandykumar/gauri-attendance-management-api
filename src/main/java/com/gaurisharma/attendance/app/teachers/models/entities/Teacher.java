

package com.gaurisharma.attendance.app.teachers.models.entities;

import com.gaurisharma.attendance.app.students.enums.Sex;
import com.gaurisharma.attendance.app.teachers.models.dto.TeacherDTO;
import com.gaurisharma.attendance.app.users.models.dto.UserDTO;
import com.gaurisharma.attendance.app.users.models.entities.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "teachers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Teacher {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teachers_id_gen")
	@SequenceGenerator(name = "teachers_id_gen", sequenceName = "teachers_id_seq", allocationSize = 1)
	@Column(name = "id", nullable = false)
	private Integer id;

	@Column(name = "first_name", length = 32)
	private String firstName;

	@Column(name = "last_name", length = 32)
	private String lastName;

	@Column(name = "sex", length = 8)
	@Enumerated(EnumType.STRING)
	private Sex sex;

	@JoinColumn(name = "user_id", referencedColumnName = "id")
	@OneToOne(fetch = FetchType.EAGER)
	private User user;

	public TeacherDTO toDTO() {
		return new TeacherDTO(id, firstName, lastName, sex, (user != null) ? user.toDTO() : new UserDTO());
	}
}