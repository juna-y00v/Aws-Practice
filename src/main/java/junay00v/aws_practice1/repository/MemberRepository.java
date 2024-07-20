package junay00v.aws_practice1.repository;

import junay00v.aws_practice1.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Member save(Member member);

    Optional<Member> findByUserId(String userId);

    List<Member> findALl();
}
