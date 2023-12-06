package com.example.springscuritybasic.config;




import com.example.springscuritybasic.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author ftz
 * 创建时间:6/12/2023 上午10:54
 * 描述: TODO
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserDetailsServiceImpl userDetailsService;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        //设置自定义的userDetailsService以及密码编码器

        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());

    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                //设置不需要验证的路径
                .antMatchers("/").permitAll()
                .antMatchers("/detail/common/**").hasRole("common")
                .antMatchers("/detal/vip/**").hasRole("vip")
                .antMatchers("/login/**").permitAll()
                //其他路径需要验证
                .anyRequest().authenticated()
                .and()
                //设置登录页面
               .formLogin()
                .loginPage("/login").permitAll()

                .usernameParameter("username").passwordParameter("password")
                //设置登录成功跳转页面
                .defaultSuccessUrl("/")
                .failureUrl("/login?error");
        http.logout().logoutUrl("/logout").logoutSuccessUrl("/login");

    }

}
