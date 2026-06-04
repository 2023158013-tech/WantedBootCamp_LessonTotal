package com.wanted.aop.section02;

import lombok.*;

//@Data
@NoArgsConstructor //기본 생성자
@AllArgsConstructor //모든 필드 초기화 생성자
@Getter
@Setter
@ToString
public class MemberDTO {

    private String email;
    private String password;
    private String name;
    private String phone;
    private String role;

}
