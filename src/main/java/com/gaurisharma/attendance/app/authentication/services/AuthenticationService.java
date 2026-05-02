

package com.gaurisharma.attendance.app.authentication.services;

import com.gaurisharma.attendance.app.authentication.models.dto.LoginDTO;
import com.gaurisharma.attendance.app.users.models.entities.User;

public interface AuthenticationService {

	User createUser(User user);

	User signIn(LoginDTO loginDTO);

	User changePassword(User user, String newPassword);

	User resetPassword(User user);
}