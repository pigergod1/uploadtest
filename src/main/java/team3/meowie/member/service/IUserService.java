package team3.meowie.member.service;

import team3.meowie.member.dto.UserDto;
import team3.meowie.member.model.User;

public interface IUserService {
	User registerNewUser(UserDto userdto);
}
