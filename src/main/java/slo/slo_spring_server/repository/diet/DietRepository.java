package slo.slo_spring_server.repository.diet;

import org.springframework.data.jpa.repository.JpaRepository;
import slo.slo_spring_server.domain.diet.Diet;

public interface DietRepository extends JpaRepository<Diet, Long> {

}
