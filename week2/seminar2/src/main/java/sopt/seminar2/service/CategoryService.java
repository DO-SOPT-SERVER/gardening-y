package sopt.seminar2.service;


import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sopt.seminar2.domain.Category;
import sopt.seminar2.domain.CategoryId;
import sopt.seminar2.dto.response.CategoryResponse;
import sopt.seminar2.repository.CategoryJpaRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CategoryService {

    private final CategoryJpaRepository categoryJpaRepository;

    public Category getByCategoryId(CategoryId categoryId) {
        return categoryJpaRepository.findById(Short.valueOf(categoryId.getCategoryId()))
                .orElseThrow(() -> new EntityNotFoundException("해당하는 카테고리가 없습니다."));
    }

    public CategoryResponse getById(Short id) {
        return CategoryResponse.of(categoryJpaRepository.findById(id)
                        .orElseThrow(() -> new EntityNotFoundException("해당하는 카테고리가 없습니다.")));
    }
}
