package com.sparta.spring01test.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
public class MemoRequestDto {
    public String username;
    public String contents;
    public String title;
    public String password;

    public MemoRequestDto(String username, String contents, String title, String password){
        this.username = username;
        this.contents = contents;
        this.title = title;
        this.password = password;
    }
}
