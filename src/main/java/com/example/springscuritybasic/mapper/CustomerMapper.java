package com.example.springscuritybasic.mapper;

import com.example.springscuritybasic.entity.Authority;
import com.example.springscuritybasic.entity.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author ftz
 * 创建时间:6/12/2023 上午11:27
 * 描述: TODO
 */
@Mapper
public interface CustomerMapper {
//查询用户信息
    @Select("select * from t_customer where username=#{username}")
    public Customer findCustomerByUsername(String username);
    //查询用户权限
    @Select("select a.* from t_customer c,t_authority a,t_customer_authority ca where c.id=ca.customer_id and a.id=ca.authority_id and c.username=#{username}")
    List<Authority> getCusomerAuthority(String username);
}
