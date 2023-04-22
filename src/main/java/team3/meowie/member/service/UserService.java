package team3.meowie.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team3.meowie.member.dto.UserDto;
import team3.meowie.member.exception.EmailExistedException;
import team3.meowie.member.exception.UserAlreadyRegisteredException;
import team3.meowie.member.model.User;
import team3.meowie.member.repository.UserRepository;


@Service
public class UserService implements IUserService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public User registerNewUser(UserDto userDto) {
		if(userExists(userDto.getUsername()))
			throw new UserAlreadyRegisteredException("There is an username: " + userDto.getUsername() + "already used!");
		
		if(emailExists(userDto.getEmail()))
			throw new EmailExistedException("There is an email: " + userDto.getEmail() + "already used!");
		
		User user = new User();
		
		user.setName(userDto.getName());
		user.setUsername(userDto.getUsername());
		user.setPassowrd(userDto.getPassowrd());
		user.setEmail(userDto.getEmail());
		return userRepository.save(user);
	}

	@Override
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	private boolean userExists(String username) {
		return userRepository.findByUsername(username) != null;
	}

	private boolean emailExists(String email) {
		return userRepository.findByEmail(email) != null;
	}
	

}
