package team3.meowie.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import team3.meowie.member.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
