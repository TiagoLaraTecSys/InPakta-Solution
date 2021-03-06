package com.laratecsys.inpaktaService.Resource;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.laratecsys.inpaktaService.Dto.EmailDTO;
import com.laratecsys.inpaktaService.Security.JWTUtil;
import com.laratecsys.inpaktaService.Security.UserSS;
import com.laratecsys.inpaktaService.Service.AuthService;
import com.laratecsys.inpaktaService.Service.UserService;

@RestController
@RequestMapping(value = "/auth")
public class authResource {

	@Autowired
	JWTUtil jwtUtil;
	
	@Autowired
	private AuthService auth;
	
	@RequestMapping(value = "refresh_token", method = RequestMethod.POST)
	public ResponseEntity<Void> refreshToken(HttpServletResponse response){
		
		UserSS user = UserService.authenticated();
		String token = jwtUtil.generateToke(user.getUsername());
		response.addHeader("Authorization", "Bearer " + token);	
		response.addHeader("access-control-expose-headers", "Authorization");
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "forgot", method = RequestMethod.POST)
	public ResponseEntity<Void> forgotPassword(@Valid @RequestBody EmailDTO objDTO){
		
		auth.sendNewPassword(objDTO.getEmail());	
		return ResponseEntity.noContent().build();
	}
}
