package team3.meowie.member.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDto {
	
	@NotNull
	@Size(min = 1)
	private String name;
	
	@NotNull
	@Size(min = 1)
	private String username;
	
	private String passowrd;
	
	@NotNull
	@Size(min = 1)
	private String email;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassowrd() {
		return passowrd;
	}

	public void setPassowrd(String passowrd) {
		this.passowrd = passowrd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
