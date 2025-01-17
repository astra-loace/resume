package net.scit.resume.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import net.scit.resume.entity.UserEntity;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

@Builder
public class UserDTO {
	private String userId;
	private String userPwd;
	private String userNm;
	private String roles;
	
	public static UserDTO toDTO(UserEntity entity) {
		return UserDTO.builder()
				.userId(entity.getUserId())
				.userPwd(entity.getUserPwd())
				.userNm(entity.getUserNm())
				.build();
	}

}