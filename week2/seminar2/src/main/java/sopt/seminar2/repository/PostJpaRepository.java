package sopt.seminar2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sopt.seminar2.domain.Member;
import sopt.seminar2.domain.Post;

import java.util.Arrays;
import java.util.List;

public interface PostJpaRepository extends JpaRepository<Post, Long> {

    List<Post> findAllByMemberId(Long memberId);
//    List<Post> findAllByMember(Member member);
//    위 아래 둘다 동일
}
