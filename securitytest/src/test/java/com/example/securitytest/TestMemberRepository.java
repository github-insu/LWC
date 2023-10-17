package com.example.securitytest;

import com.example.securitytest.domain.Role;
import com.example.securitytest.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Commit;

@RunWith(SpringRunner.class)
@Slf4j
@Commit
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestMemberRepository {
    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void insert_member(){

        Member member = new Member();
        member.setId("admin");
        member.setPassword(passwordEncoder.encode("admin"));
        member.setDname("admin 부서");
        member.setEnabled(true);
        member.setRole(ROLE.ROLE_ADMIN);
        memberRepository.save(member);

        Member member = new Member();
        member.setId("manager");
        member.setPassword(passwordEncoder.encode("manager"));
        member.setDname("manager 부서");
        member.setEnabled(true);
        member.setRole(Role.ROLE_MANAGER);
        memberRepository.save(member);

        Member member = new Member();
        member.setId("member");
        member.setPassword(passwordEncoder.encode("member"));
        member.setDname("member 부서");
        member.setEnabled(true);
        member.setRole(Role.ROLE_MEMBER);
        memberRepository.save(member);

    }
}
