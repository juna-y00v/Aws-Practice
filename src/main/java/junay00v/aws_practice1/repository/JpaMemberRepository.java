package junay00v.aws_practice1.repository;

import jakarta.persistence.EntityManager;
import junay00v.aws_practice1.domain.Member;

import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository {

    private final EntityManager em;

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findByUserId(String userId) {
        List<Member> result = em.createQuery("select m from Member m where m.userId = :userid", Member.class)
                .setParameter("userid", userId)
                .getResultList();

        return result.stream().findAny();
    }

    @Override
    public List<Member> findALl() {
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }
}