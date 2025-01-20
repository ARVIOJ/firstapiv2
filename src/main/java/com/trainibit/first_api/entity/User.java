package com.trainibit.first_api.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "birthday")
    private LocalDate birthday;

    @Column(name = "created_date" , nullable = false)
    private Timestamp createdDate;

    @Column(name = "updated_date" , nullable = false)
    private Timestamp updatedDate;

    @Column(name = "uuid", nullable = true)
    private UUID uuid;

    @Column(name = "planet")
    private String planet;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "federal_state_id", nullable = false)
    private FederalState federalState;

    //mapeo entre User y rolesbyuser
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<RolesByUser> rolesByUser;
}
