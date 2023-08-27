package com.totospizza.api.entity;

import com.totospizza.api.entity.enums.Document;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data @Builder
@NoArgsConstructor @AllArgsConstructor
@Entity @Table(name = "persons")
public class Person extends EntityBase{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    @Column(length = 100, nullable = false)
    private String name;
    @Column(length = 100, nullable = false)
    private String lastname;
    @Enumerated(EnumType.STRING) @Column(nullable = false)
    private Document document;
    @Column(length = 12, nullable = false)
    private String documentNumber;
    @Column(nullable = false)
    private String email;
    @Column(length = 15, nullable = false)

    private String phone;
    @Temporal(TemporalType.DATE) @Column(nullable = false)
    private Date birthdate;
    @Column(length = 15, nullable = false)
    private String gender;

}
