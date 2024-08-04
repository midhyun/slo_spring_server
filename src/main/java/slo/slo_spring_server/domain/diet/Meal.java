package slo.slo_spring_server.domain.diet;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import slo.slo_spring_server.domain.BaseTimeEntity;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Meal extends BaseTimeEntity {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    @JoinColumn(nullable = false, name = "food_id")
    private Food food;

    @ManyToOne
    @Column(nullable = false, name = "diet_id")
    private Diet diet;

    // 0: quantity gram, 1: quantity 인분
    private int servingType;

    private int quantity;

    }
