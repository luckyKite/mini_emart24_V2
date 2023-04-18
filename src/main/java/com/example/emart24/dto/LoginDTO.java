package com.example.emart24.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
public class LoginDTO {
//  @NotEmpty(message = "이메일은 필수 입력 값입니다.")
//  @Email(message = "이메일 형식으로 입력해주세요.")
  private String email;

//  @NotEmpty(message = "비밀번호는 필수 입력 값입니다.")
//  @Length(min=8, max=16, message = "비밀번호는 8자 이상, 16자 이하로 입력해주세요")
  private String password;
}
