package team3.meowie.member.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import team3.meowie.member.model.Role;
import team3.meowie.member.model.User;
import team3.meowie.member.repository.UserRepository;

@Service
public class MeowieUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if (user == null)
			throw new UsernameNotFoundException("User not found: " + username + "!");
		
		boolean enable = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;
		
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), 
				enable, accountNonExpired, credentialsNonExpired, accountNonLocked, getAuthorities(user.getRoles()));
	}
	
	private static List<GrantedAuthority> getAuthorities(Collection<Role> roles) {
		List<GrantedAuthority> authorities = new ArrayList<>();
//		for(Role role : roles)
//			authorities.add(new SimpleGrantedAuthority(role.getPrivileges()));
		return authorities;
	}


}
