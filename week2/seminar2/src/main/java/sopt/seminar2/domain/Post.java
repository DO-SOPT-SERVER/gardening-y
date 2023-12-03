package sopt.seminar2.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "post")
public class Post {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    private String title;
    @Column(columnDefinition = "TEXT")
    private String content;

    private String imageUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

//    논리적으로 관계만 맺어둠
    @Column(name = "category_id")
    private CategoryId categoryId;


//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "category_id")
//    private Category category;

    @Builder
    public Post(String title, String content, Member member, CategoryId categoryId) {
        this.title = title;
        this.content = content;
        this.member = member;
        this.categoryId = categoryId;
    }

//    builder 여러개 일 때 이름 추가 builderMethodName
    @Builder(builderMethodName = "builderWithImageUrl")
    public Post(String title, String content, String imageUrl, Member member) {
        this.title = title;
        this.content = content;
        this.member = member;
        this.imageUrl = imageUrl;
    }

    public void updateContent(String content) {
        this.content = content;
    }

    public void addCategory(CategoryId categoryId) {
        this.categoryId = categoryId;
    }
}
