package junay00v.aws_practice1;

import jakarta.persistence.EntityManager;
import junay00v.aws_practice1.repository.JpaMemberRepository;
import junay00v.aws_practice1.repository.MemberRepository;
import junay00v.aws_practice1.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    private final EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new JpaMemberRepository(em);
    }
}