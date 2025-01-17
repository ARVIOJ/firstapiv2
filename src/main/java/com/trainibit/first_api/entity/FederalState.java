package com.trainibit.first_api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "federal_states")
public class FederalState {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, length = Integer.MAX_VALUE)
    private String name;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created_date", nullable = false)
    private Instant createdDate;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "updated_date", nullable = false)
    private Instant updatedDate;

    @Column(name = "uuid", nullable = false)
    private UUID uuid;

}