package slo.slo_spring_server.domain;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseTimeEntity {

    @Column(name = "created_date", nullable = false)
    @CreatedDate
    private LocalDateTime createdDate;

    @Column(name = "updated_date", nullable = false)
    @LastModifiedDate
    private LocalDateTime updatedDate;

//    엔티티를 저장하기 이전에 실행
    @PrePersist
    public void onPrePersist() {
        this.createdDate = LocalDateTime.now();
        this.updatedDate = this.createdDate;
    }

//    엔티티를 업데이트 하기 이전에 실행
    @PreUpdate
    public void onPreUpdate() {
        this.updatedDate = LocalDateTime.now();
    }
}
