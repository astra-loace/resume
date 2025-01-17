package net.scit.resume.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import net.scit.resume.dto.UserDTO;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

@Builder
@Entity
@Table(name="test_user")
public class UserEntity {
	
	@Id
	@Column(name="user_id")
	private String userId;
	
	@Column(name="user_pwd", nullable = false)
	private String userPwd;
	
	@Column(name="user_nm", nullable = false)
	private String userNm;
	
	@Column(name="roles")
	@Builder.Default
	private String roles = "ROLE_USER";
	
	public static UserEntity toEntity(UserDTO dto) {
		return UserEntity.builder()
				.userId(dto.getUserId())
				.userPwd(dto.getUserPwd())
				.userNm(dto.getUserNm())
				.build();
	}

}
