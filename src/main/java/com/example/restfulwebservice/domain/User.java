package com.example.restfulwebservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@JsonIgnoreProperties(value = {"password"})  //클래스 블록에서 사용하는방법
//@JsonFilter("UserInfo")
public class User {
    private Integer id;

    @Size(min = 2, message = "Name은 2글자 이상 입력해주세요.")    //2자 이상
    private String name;
    @Past   //과거입력 안됨
    private Date joinDate;

    //외부에 노출시키고 싶지 않은 데이터 제어하기
//    @JsonIgnore
    private String password;
    private String ssn; //주민등록번호
}
