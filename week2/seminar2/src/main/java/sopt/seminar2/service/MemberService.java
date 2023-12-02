package sopt.seminar2.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sopt.seminar2.domain.Member;
import sopt.seminar2.dto.request.MemberCreateRequest;
import sopt.seminar2.dto.response.MemberGetResponse;
import sopt.seminar2.repository.MemberJpaRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {
    private final MemberJpaRepository memberJpaRepository;

    public MemberGetResponse getByIdV1(Long memberId) {

        Member member = memberJpaRepository.findById(memberId).get();
        return MemberGetResponse.of(member);
    }

    public MemberGetResponse getByIdV2(Long memberId) {
        return MemberGetResponse.of(memberJpaRepository.findById(memberId).orElseThrow(
                () -> new EntityNotFoundException("존재하지 않는 회원입니다.")
        ));
    }

    //직접 메소드 만들어 줄 수 있음
    private  Member findById(Long memberId) {
        return memberJpaRepository.findById(memberId).orElseThrow(
                () -> new EntityNotFoundException("존재하는 회원이 없습니다")
        );
    }

    public List<MemberGetResponse> getMembers() {
//        List<MemberGetResponse> members = memberJpaRepository.findAll()
//                .stream()
//                .map(member -> MemberGetResponse.of(member))
//                .collect(Collectors.toList());

        return memberJpaRepository.findAll()
                .stream()
                .map(MemberGetResponse::of)
                .collect(Collectors.toList());
    }

    @Transactional
    public String create(MemberCreateRequest request) {
//        Member member = Member.builder()
//                .name(request.getName())
//                .nickName(request.getNickname())
//                .age(request.getAge())
//                .sopt(request.getSopt())
//                .build();
        Member member = Member.builder()
                .name(request.getName())
                .nickname(request.getNickname())
                .age(request.getAge())
                .sopt(request.getSopt())
                .build();
        //저장한 애 문자열로 바꿔주고 그다음 URI로 바꿔준다.
        return memberJpaRepository.save(member).getId().toString();
    }


}
