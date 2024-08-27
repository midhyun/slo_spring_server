package slo.slo_spring_server.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import slo.slo_spring_server.domain.diet.DietType;
import slo.slo_spring_server.exception.ValidEnum;

import java.time.LocalDateTime;


@Valid
@Data
@Builder
@AllArgsConstructor
public class DietDTO {

    private Long id;

    @NotBlank
    private Long userId;

    @NotBlank
    private LocalDateTime dateTime;

    @NotBlank
    @ValidEnum(enumClass = DietType.class)
    private DietType dietType;

}
