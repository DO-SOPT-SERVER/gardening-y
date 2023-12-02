package sopt.seminar2.dto.request;
import lombok.Data;
import sopt.seminar2.domain.SOPT;

@Data
public class MemberCreateRequest {
    private String name;
    private String nickname;
    private int age;
    private SOPT sopt;
}

//public record MemberCreateRequest(
//        String name,
//        String nickname,
//        int age,
//        SOPT sopt
//) {
//}
