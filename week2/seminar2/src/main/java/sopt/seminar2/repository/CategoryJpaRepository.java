package sopt.seminar2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sopt.seminar2.domain.Category;

public interface CategoryJpaRepository extends JpaRepository<Category, Short> {
}
