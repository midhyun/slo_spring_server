package slo.slo_spring_server.domain.diet;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import slo.slo_spring_server.domain.BaseTimeEntity;
import slo.slo_spring_server.domain.user.Users;

import java.time.LocalDateTime;

@Entity
@Getter @Setter
@NoArgsConstructor
@Table(indexes = {
        @Index(name = "idx_diet_table", columnList = "diet_date, user_id")
})
public class Diet extends BaseTimeEntity {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private Users users;

    @Column(name = "diet_date")
    private LocalDateTime dietDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "diet_type")
    private DietType dietType;
}
