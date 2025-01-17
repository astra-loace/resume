package net.scit.resume.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.scit.resume.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, String>{

}
