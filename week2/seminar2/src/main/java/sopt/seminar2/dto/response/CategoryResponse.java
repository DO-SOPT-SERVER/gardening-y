package sopt.seminar2.dto.response;

import sopt.seminar2.domain.Category;

public record CategoryResponse(
        String content
) {

    public static CategoryResponse of(Category category) {
        return new CategoryResponse(
                category.getContent()
        );
    }

}
