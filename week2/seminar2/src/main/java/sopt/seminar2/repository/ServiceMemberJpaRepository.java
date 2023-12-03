package sopt.seminar2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sopt.seminar2.domain.ServiceMember;

import java.util.Optional;

public interface ServiceMemberJpaRepository extends JpaRepository<ServiceMember, Long> {
    Optional<ServiceMember> findByNickname(String nickname);
}
