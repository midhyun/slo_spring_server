package slo.slo_spring_server.domain.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import slo.slo_spring_server.domain.BaseTimeEntity;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "USERS")
public class User extends BaseTimeEntity {

    @JsonIgnore
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, length = 30, unique = true)
    private String username;

    @JsonIgnore
    @Column(length = 100)
    private String password;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false, length = 50, unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status = Status.ACT;
    private int weight;
    private int height;
    private int age;

//    회원정보 수정
    public void modifyInfo(String password, String nickName, int weight, int height, int age) {
        this.password = password;
        this.nickname = nickName;
        this.weight = weight;
        this.height = height;
        this.age = age;
    }

    public User updateModifiedDate() {
        this.onPreUpdate();
        return this;
    }

    public String getRoleValue() {
        return this.role.getValue();
    }
}
