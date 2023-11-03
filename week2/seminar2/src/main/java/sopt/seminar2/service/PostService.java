package sopt.seminar2.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sopt.seminar2.domain.Member;
import sopt.seminar2.domain.Post;
import sopt.seminar2.dto.request.PostCreateRequest;
import sopt.seminar2.dto.request.PostUpdateRequest;
import sopt.seminar2.dto.response.PostGetResponse;
import sopt.seminar2.repository.MemberJpaRepository;
import sopt.seminar2.repository.PostJpaRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {
    private final PostJpaRepository postJpaRepository;
    private final MemberJpaRepository memberJpaRepository;

    @Transactional
    public String create(PostCreateRequest request, Long memberId) {
        Member member = memberJpaRepository.findByIdOrThrow(memberId);
        Post post = postJpaRepository.save(
                Post.builder()
                .member(member)
                .title(request.title())
                .content(request.content())
                .build()
        );
        return post.getPostId().toString();
    }

    public PostGetResponse getById(Long postId) {
        Post post = postJpaRepository.findById(postId).orElseThrow(
                () -> new EntityNotFoundException("해당하는 게시글이 없습니다.")
        );
        return PostGetResponse.of(post);
    }


    public List<PostGetResponse> getPosts(Long memberId) {
        return postJpaRepository.findAllByMemberId(memberId)
                .stream()
//                .map(post -> PostGetResponse.of(post))
                .map(PostGetResponse::of)
                .toList();
    }

    @Transactional
    public void updateContent(Long postId, PostUpdateRequest request) {
        Post post = postJpaRepository.findById(postId)
                .orElseThrow(() -> new EntityNotFoundException("해당하는 게시글이 없습니다."));
        post.updateContent(request.content());
    }

    @Transactional
    public void deletePost(Long postId) {
        Post post = postJpaRepository.findById(postId)
                .orElseThrow(() -> new EntityNotFoundException("해당하는 게시글이 없습니다."));
        postJpaRepository.delete(post);
    }
}
