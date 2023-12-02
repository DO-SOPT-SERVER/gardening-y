package sopt.seminar2.dto.response;

import sopt.seminar2.domain.Category;
import sopt.seminar2.domain.Post;
import sopt.seminar2.domain.SOPT;

public record PostGetResponse(
        Long id,
        String title,
        String content,
        String category
) {

    public static PostGetResponse of(Post post, Category category) {
        return new PostGetResponse(
                post.getPostId(),
                post.getTitle(),
                post.getContent(),
                category.getContent()
        );
    }

}

