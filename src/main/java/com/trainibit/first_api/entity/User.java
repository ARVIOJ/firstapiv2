package com.trainibit.first_api.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDate;
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

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public LocalDate getBirthday() {
//        return birthday;
//    }
//
//    public void setBirthday(LocalDate birthday) {
//        this.birthday = birthday;
//    }
//
//    public Timestamp getCreatedDate() {
//        return createdDate;
//    }
//
//    public void setCreatedDate(Timestamp createdDate) {
//        this.createdDate = createdDate;
//    }
//
//    public Timestamp getUpdatedDate() {
//        return updatedDate;
//    }
//
//    public void setUpdatedDate(Timestamp updatedDate) {
//        this.updatedDate = updatedDate;
//    }
//
//    public UUID getUuid() {
//        return uuid;
//    }
//
//    public void setUuid(UUID uuid) {
//        this.uuid = uuid;
//    }
}
