package com.gucarsoft.kesingez.service.security;


import com.gucarsoft.kesingez.model.user.User;
import com.gucarsoft.kesingez.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    /** bununda
     * ismini degistir, interface ile somut sinif ayni isimde olmaz
     * DefaultUserDetailService
     * UserDetailServiceImpl gibi falan falan, degistir iste.
     * tesekkur ederim cok saol abi
     *
     * sadece onemli nokta su.
     * ortak kutuphaneye aldigin siniflar, eger baska bir bagimligiga sahipse
     * misal bu sinif gibi
     * UserRepository bean'ine ihtiyac duyuyor.
     * yanlis bilmiyorsam, spring bunuda halledebiliyor ama dene bi, emin olamadim
     * yani direk UserDetailService'i inject edip edemedigini denersin bi
     * tammamdr /( ahaahah sorun yok, turkce klavye degil, ondan sorun yasadin xd buyr yaz :)
     */

    @Autowired
    UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);
        /*System.out.println("------------------------------------------");
        System.out.println("--- user: --- " + user.toString());
        System.out.println("------------------------------------------");*/
        if (user == null) {
            throw new UsernameNotFoundException("");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), true,
                true, true, true, getAuthorities(user));
    }

    private Collection<? extends GrantedAuthority> getAuthorities(User user) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole().toString()));
        return authorities;
    }

}
