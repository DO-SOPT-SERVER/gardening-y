package sopt.seminar2.dto.request;
import sopt.seminar2.domain.Member;

public record PostUpdateRequest(
        String title,
        String content,
        Member member

) {

}
