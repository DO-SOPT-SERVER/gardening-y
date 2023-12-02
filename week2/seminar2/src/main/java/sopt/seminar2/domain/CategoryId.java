package sopt.seminar2.domain;

import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.io.Serializable;

@Embeddable
@Getter
@EqualsAndHashCode
//두 객체의 동등성과 동일성을 비교할 수 있는 equals& hashCode 자동 생성
public class CategoryId implements Serializable {

    private String categoryId;
}
