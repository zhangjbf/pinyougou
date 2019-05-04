package com.pinyougou.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.pinyougou.itf.SellerService;
import com.pinyougou.model.ServiceResult;
import com.pinyougou.pojo.TbSeller;

/**
 * 自定义认证类
 *
 * @Version: 1.0
 * @Author: jiabin.zhang 张佳宾
 * @Email: jiabin.zhang@rograndec.com
 * @CreateDate 2019/5/4
 */
public class UserDetailServiceImpl implements UserDetailsService {

    private SellerService sellerService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        List<GrantedAuthority> grantedAuths = new ArrayList<>();
        grantedAuths.add(new SimpleGrantedAuthority("ROLE_SELLER"));

        ServiceResult<TbSeller> serviceResult = sellerService.findOne(userName);
        if (!serviceResult.getSuccess()) {
            return null;
        }
        if (null == serviceResult.getResult()) {
            return null;
        }
        if ("1".equals(serviceResult.getResult().getStatus())) {
            return new User(userName, serviceResult.getResult().getPassword(), grantedAuths);
        }

        return null;
    }

    public SellerService getSellerService() {
        return sellerService;
    }

    public void setSellerService(SellerService sellerService) {
        this.sellerService = sellerService;
    }
}
