package slo.slo_spring_server.domain.diet;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import slo.slo_spring_server.domain.BaseTimeEntity;
import slo.slo_spring_server.domain.user.User;

import java.time.LocalDateTime;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Diet extends BaseTimeEntity {

    @Id
    @GeneratedValue
    private Long id;

    @JoinColumn(name = "user_id")
    @ManyToOne
    private User user;

    @Column(name = "diet_date")
    private LocalDateTime dietDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "diet_type")
    private DietType dietType;
}
