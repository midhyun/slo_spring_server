package slo.slo_spring_server.domain.diet;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import slo.slo_spring_server.domain.BaseTimeEntity;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Food extends BaseTimeEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String foodName;
    private int servingSize;
    private int calorie;
    private int carbohydrate;
    private int protein;
    private int fat;
    private int sodium;

}
