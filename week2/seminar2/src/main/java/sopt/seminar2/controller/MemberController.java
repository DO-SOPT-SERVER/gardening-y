package sopt.seminar2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import sopt.seminar2.domain.Member;
import sopt.seminar2.dto.request.MemberCreateRequest;
import sopt.seminar2.dto.request.MemberProfileUpdateRequest;
import sopt.seminar2.dto.response.MemberGetResponse;
import sopt.seminar2.repository.MemberJpaRepository;
import sopt.seminar2.service.MemberService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/{memberId}")
    public ResponseEntity<MemberGetResponse> getMemberProfileV1(@PathVariable Long memberId) {
        return ResponseEntity.ok(memberService.getByIdV1(memberId));
    }

    @GetMapping(value = "{memberId}/v2", produces = MediaType.APPLICATION_JSON_VALUE)
    // 일치하는 경우에는 ParhVariable 뒤에 안적어줘도 된다.
    public ResponseEntity<MemberGetResponse> getMemberProfileV2(@PathVariable Long memberId) {
        return ResponseEntity.ok(memberService.getByIdV2(memberId));
    }

    @GetMapping
    public ResponseEntity<List<MemberGetResponse>> getMembersProfile() {
        return ResponseEntity.ok(memberService.getMembers());
    }

    @PostMapping
    public ResponseEntity<Void> createMember(@RequestBody MemberCreateRequest requset) {
        URI location = URI.create("api/member/" + memberService.create(requset));
        //파라미터 URI 넣어줘야함
        return ResponseEntity.created(location).build();
    }

    @PatchMapping("/{memberId}")
    public ResponseEntity<Void> updateMemberSoptInfo(@PathVariable Long memberId, @RequestBody MemberProfileUpdateRequest request) {
        memberService.updateSOPT(memberId, request);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{memberId}")
    public ResponseEntity deleteMember(@PathVariable Long memberId) {
        memberService.deleteMember(memberId);
        return ResponseEntity.noContent().build();
    }
}
