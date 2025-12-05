package com.winter.app.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.winter.app.files.FileManager;

@Service
public class UsersService {

	@Autowired
	private UsersDAO usersDAO;
	
	@Autowired
	private FileManager fileManager;
	
	@Value("${app.upload.users}")
	private String uploadPath;
	
	public boolean getError(UsersDTO usersDTO, BindingResult bindingResult) {
		// check : true -> 검증 실패, error 존재 
		// check : false -> 검증 성공, error 존재 X 
		// 1. annotation 검증 결과
		boolean check = bindingResult.hasErrors();
		
		// 2. password 일치 하는지 검증
		if (!usersDTO.getPassword().equals(usersDTO.getPassword())) {
			check=true;
			bindingResult.rejectValue("passwordCheck", "user.password.equal");
		}
		
		// 3. ID 중복 체크
		if (!usersDTO.getUsername().equals(usersDTO.getUsername())) {
			check=true;
			bindingResult.rejectValue("username", "user.username.duplication");
		}
		
		return check;
	}
	
	public int register(UsersDTO usersDTO) throws Exception{
		return usersDAO.register(usersDTO);
	}
	
	public int update(UsersDTO usersDTO) throws Exception{
		return usersDAO.update(usersDTO);
	}
	
	public int delete(UsersDTO usersDTO) throws Exception{
		return usersDAO.delete(usersDTO);
	}
	
	public UsersDTO detail(UsersDTO usersDTO) throws Exception{
		UsersDTO loginDTO = usersDAO.detail(usersDTO);
		
		if (loginDTO != null) {
			if(loginDTO.getPassword().equals(usersDTO.getPassword())){
				return loginDTO; 
			}else {
				loginDTO = null;
			}
		}
	
		return loginDTO;
	}
	
}
