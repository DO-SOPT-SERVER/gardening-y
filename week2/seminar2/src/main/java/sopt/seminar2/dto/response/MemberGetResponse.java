package sopt.seminar2.dto.response;

import sopt.seminar2.domain.Member;
import sopt.seminar2.domain.SOPT;

public record MemberGetResponse(
        String name,
        String nickname,
        int age,
        SOPT sopt
) {

    public static MemberGetResponse of(Member member) {
        return new MemberGetResponse(
                member.getName(),
                member.getNickname(),
                member.getAge(),
                member.getSopt()
        );
    }
}
