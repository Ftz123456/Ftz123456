package com.example.springscuritybasic.service;


import com.example.springscuritybasic.entity.Authority;
import com.example.springscuritybasic.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ftz
 * 创建时间:6/12/2023 下午12:14
 * 描述: TODO
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    CustomerService customerService;
    //重写接口方法
    @Override
     public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //获取用户对象
        Customer customer = customerService.findCustomerByUsername(username);

        //判断用户是否存在
        if(customer!=null){
            //获取用户权限列表
            List<Authority> authority = customerService.getCusomerAuthority(username);
            List<SimpleGrantedAuthority> list = authority.stream().map(authority1 -> new SimpleGrantedAuthority(authority1.getAuthority())).collect(Collectors.toList());
            //创建UserDetails对象，设置用户名、密码、权限列表
            return new User(customer.getUsername(),customer.getPassword(),list);


        }else {
            throw new UsernameNotFoundException("用户不存在");


    }
}
}
