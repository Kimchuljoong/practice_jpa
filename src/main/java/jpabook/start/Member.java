package jpabook.start;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data   // lombok getter, setter 자동으로 만들어줌 **너무 편함**
@Entity // 클래스를 테이블과 매핑한다
@Table(name="Member")   // 현재 클래스와 매핑되는 테이블의 명
public class Member {

    @Id // 테이블의 기본키에 매핑
    @Column(name = "ID")    // 해당 변수에 매핑되는 컬럼명
    private String id;

    @Column(name = "NAME")
    private String userName;

    private Integer age;    // 변수명과 동일한 컬럼명에 매핑

}
