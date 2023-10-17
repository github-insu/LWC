package com.example.securitytest.config;

import com.example.securitytest.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException{
        Optional<Member> op = memberRepository.findById(username);
        if (!op.isPresent()) {
            throw new UsernameNotFoundException("사용자 없음");
        }
        Member member = op.get();

        return new SecurityUser(member);
    }
}
