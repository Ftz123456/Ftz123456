package com.example.springscuritybasic.service;

import com.example.springscuritybasic.entity.Authority;
import com.example.springscuritybasic.entity.Customer;
import com.example.springscuritybasic.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ftz
 * 创建时间:6/12/2023 下午12:05
 * 描述: TODO
 */
@Service
@CacheConfig(cacheNames = "customer")
public class CustomerService {
    @Autowired
    CustomerMapper customerMapper;
    //获取用户对象
    @Cacheable(key = "#username",unless = "#result==null")
    public Customer findCustomerByUsername(String username){
        return customerMapper.findCustomerByUsername(username);
    }
    //获取指定用户的权限列表，拼接生成key
    @Cacheable(key = "'authority'+#username",unless = "#result==null")
    public List<Authority> getCusomerAuthority(String username){
        return customerMapper.getCusomerAuthority(username);
    }
}
