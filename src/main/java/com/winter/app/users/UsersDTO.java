package com.winter.app.users;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.security.auth.login.AccountExpiredException;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UsersDTO implements UserDetails, OAuth2User{
   @NotBlank(groups = {RegisterGroup.class})
   private String username;
   @NotBlank(groups = {RegisterGroup.class})
    private String password;
    private String passwordCheck;
    
    @NotBlank(groups = {RegisterGroup.class, UpdateGroup.class})
    private String name;
    @Email(groups = {RegisterGroup.class, UpdateGroup.class})
    @NotBlank(groups = {RegisterGroup.class})
    private String email;
    private String phone;
    @Past(groups = {RegisterGroup.class, UpdateGroup.class})
    private Date birth;
    private UsersFileDTO usersFileDTO;
    
    private List<RoleDTO> roleDTOs;
    
    private List<UsersFileDTO> profileDTOs;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> list = new ArrayList<>();

        if (roleDTOs != null) {
            for (RoleDTO role : roleDTOs) {
                list.add(new SimpleGrantedAuthority(role.getRoleName()));
            }
        }

        return list;
    }

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
//		AccountExpiredException
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Map<String, Object> getAttributes() {
		// TODO Auto-generated method stub
		return null;
	}


}
