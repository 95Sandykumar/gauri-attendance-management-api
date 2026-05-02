

package com.gaurisharma.attendance.app.users.models.dto;

import com.gaurisharma.attendance.app.users.models.entities.User;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * DTO for {@link User}
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO implements Serializable {
	private Integer id;
	@NotBlank(message = "Username is required")
	private String username;
	private String email;
	private String role;
	private Instant lastLogin;
	private Instant createdAt;

	public User toEntity() {
		new User();
		return User.builder()
			.id(id)
			.username(username)
			.email(email)
			.role(role)
			.lastLogin(lastLogin)
			.createdAt(createdAt)
			.build();
	}
}