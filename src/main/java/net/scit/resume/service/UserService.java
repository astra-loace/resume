package net.scit.resume.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.scit.resume.dto.UserDTO;
import net.scit.resume.entity.UserEntity;
import net.scit.resume.repository.UserRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
	private final UserRepository userRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	/**
	 * "전달받은 userId가 DB에 존재하니?" 확인하렴
	 * @param userId
	 * @return
	 * */
	public boolean existId(String userId) {// 존재하니, 존재하지 않니?
		boolean result = userRepository.existsById(userId); // 가입하려면 false
		log.info("아이디 존재여부: {}", result); // 가입하려면 false
		
		return !result;
	}
	/**
	 * 회원가입 처리
	 * @param userDTO
	 * @return
	 * */
	public boolean joinProc(UserDTO userDTO) {
		
		userDTO.setUserPwd(bCryptPasswordEncoder.encode(userDTO.getUserPwd()));
		
		UserEntity entity = UserEntity.toEntity(userDTO);
		userRepository.save(entity); // 정보 저장 후 회원가입 완료
		
		boolean result = userRepository.existsById(userDTO.getUserId());
		
		return result;

	}

}
