package sopt.seminar2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sopt.seminar2.dto.request.PostCreateRequest;
import sopt.seminar2.dto.request.PostUpdateRequest;
import sopt.seminar2.dto.response.PostGetResponse;
import sopt.seminar2.service.PostService;
import sopt.seminar2.service.PostServiceV2;

import java.net.URI;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/post")
@RequiredArgsConstructor
public class PostController {
    private static final String CUSTOM_AUTH_ID = "X-Auth-Id";
    private final PostService postService;
    private final PostServiceV2 postServiceV2;

//    생성
//    @PostMapping
//    public ResponseEntity<Void> createPost(@RequestHeader(CUSTOM_AUTH_ID)Long memberId,
//                                           @RequestBody PostCreateRequest request) {
//        URI location = URI.create("/api/post/"+postService.create(request, memberId));
//        return ResponseEntity.created(location).build();
//    }

//    하나 조회
    @GetMapping("{postId}")
    public ResponseEntity<PostGetResponse> getPostById(@PathVariable Long postId) {
        return ResponseEntity.ok(postService.getById(postId));
    }

//    전체 조회
    @GetMapping
    public ResponseEntity<List<PostGetResponse>> getPosts(@RequestHeader(CUSTOM_AUTH_ID) Long memberId) {
        return ResponseEntity.ok(postService.getPosts(memberId));
    }


    @PatchMapping("{postId}")
    public ResponseEntity<Void> updatePost(@PathVariable Long postId, @RequestBody PostUpdateRequest request) {
        postService.updateContent(postId, request);
        return ResponseEntity.noContent().build();
    }

//    @DeleteMapping("{postId}")
//    public ResponseEntity<Void> deletePost(@PathVariable Long postId) {
//        postService.deletePost(postId);
//        return ResponseEntity.noContent().build();
//    }

//    @PostMapping
//    public ResponseEntity<Void> createPostV2(@RequestHeader(CUSTOM_AUTH_ID) Long memberId, @RequestPart MultipartFile image, PostCreateRequest request) {
//        URI location = URI.create("/api/posts/v2" + postServiceV2.createV2(request, image, memberId));
//        return ResponseEntity.created(location).build();
//    }

    @PostMapping
    public ResponseEntity<Void> createPost(
            @RequestBody PostCreateRequest request, Principal principal) {

        Long memberId = Long.valueOf(principal.getName());
        URI location = URI.create("/api/posts/" + postService.create(request, memberId));

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("{postId}")
    public ResponseEntity<Void> deletePostV2(@PathVariable Long postId) {
        postServiceV2.deleteByIdV2(postId);
        return ResponseEntity.noContent().build();
    }


}
