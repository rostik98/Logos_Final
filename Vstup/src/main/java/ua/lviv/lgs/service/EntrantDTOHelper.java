package ua.lviv.lgs.service;

import java.io.IOException;
import java.util.Base64;

import org.springframework.web.multipart.MultipartFile;

import ua.lviv.lgs.domain.Entrant;

public class EntrantDTOHelper {

	public static Entrant createEntity(MultipartFile file, String firstName, String lastName, String email,
			String password, String passwordConfirm) throws IOException {

		Entrant entrant = new Entrant();
		entrant.setFirstName(firstName);
		entrant.setLastName(lastName);
		entrant.setEmail(email);
		entrant.setPassword(password);
		entrant.setPasswordConfirm(passwordConfirm);
		entrant.setEncodedImage(Base64.getEncoder().encodeToString(file.getBytes()));
		return entrant;
	}
}
