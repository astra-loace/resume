package net.scit.resume.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.scit.resume.dto.UserDTO;
import net.scit.resume.service.UserService;

@Slf4j
@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
	
	private final UserService userService;
	
	/**
	 * 회원가입 화면 요청
	 * @return
	 * */
	@GetMapping("/join")
	public String join() {
		return "user/join";
	}
	
	@PostMapping("/idCheck")
	@ResponseBody
	public boolean idCheck(
			@RequestParam(name="userId") String userId) {
		
		boolean result = userService.existId(userId);
		
		return result;	
	}
	
	/**
	 * 회원가입 처리 요청
	 * @return
	 * */
	@PostMapping("/joinProc")
	public String joinProc(@ModelAttribute UserDTO userDTO) {
		log.info("회원정보: {}", userDTO.toString());
		boolean result = userService.joinProc(userDTO);
		return "redirect:/";
		
	}
	
	/**
	 * 1) 로그인 화면 요청
	 * 2) 에러 발생시 이 로그인 페이지로 다시 돌아와(redirect)!
	 * @return
	 * */
	@GetMapping("/login")
	public String login(Model model,
			@RequestParam(name="error", required = false) String error
			) {
		model.addAttribute("error", error);
		model.addAttribute("errMessage", "아이디와 비밀번호를 확인하세요.");
		
		return "user/login";
	}
	
}
