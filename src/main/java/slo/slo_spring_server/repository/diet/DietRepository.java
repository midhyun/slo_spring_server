package slo.slo_spring_server.repository.diet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import slo.slo_spring_server.domain.diet.Diet;

import java.time.LocalDateTime;

@Repository
public interface DietRepository extends JpaRepository<Diet, Long> {
    Diet findOneByDietDate(LocalDateTime localDAteTime);

    Diet updateDiet(Diet diet);
    Diet createDiet(Diet diet);

}