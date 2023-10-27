package sopt.seminar2.repository;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import sopt.seminar2.domain.Member;

public interface MemberJpaRepository extends JpaRepository<Member, Long> {
    default Member findByIdOrThrow(Long id) {
        return findById(id).orElseThrow(
                () -> new EntityNotFoundException("존재하지 않는 회원입니다.")
        );
    }
}
