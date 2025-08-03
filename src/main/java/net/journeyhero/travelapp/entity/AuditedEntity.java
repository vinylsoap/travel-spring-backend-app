package net.journeyhero.travelapp.entity;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;
import java.util.UUID;

@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
abstract class AuditedEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    protected UUID id;

    @CreatedBy
    @Column(nullable = false)
    protected String createdBy;

    @CreatedDate
    @Column(nullable = false)
    protected Instant createDate;

    public UUID getId() {
        return id;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public Instant getCreateDate() {
        return createDate;
    }
}
