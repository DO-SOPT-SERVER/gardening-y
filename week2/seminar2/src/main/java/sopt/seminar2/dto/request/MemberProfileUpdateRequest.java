package sopt.seminar2.dto.request;

import lombok.Data;
import sopt.seminar2.domain.Part;

@Data
public class MemberProfileUpdateRequest {
    private int generation;
    private Part part;
}