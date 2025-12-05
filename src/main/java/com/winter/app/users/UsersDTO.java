package com.winter.app.users;

import java.sql.Date;
import java.util.List;

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
public class UsersDTO {
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
    
    private List<UsersFileDTO> profileDTOs;

}
