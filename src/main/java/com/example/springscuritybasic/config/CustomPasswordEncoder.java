package com.example.springscuritybasic.config;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author ftz
 * 创建时间:6/12/2023 上午11:10
 * 描述: TODO
 */
public class CustomPasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence charSequence) {
        return charSequence.toString();
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return s.equals(charSequence.toString());
    }
}