package com.totospizza.api.entity;

import com.totospizza.api.entity.enums.Area;
import com.totospizza.api.entity.enums.StaffState;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder
@NoArgsConstructor @AllArgsConstructor
@Entity @Table(name = "staff")
public class Staff {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person person;
    @Enumerated(EnumType.STRING) @Column(nullable = false)
    private Area area;
    @Enumerated(EnumType.STRING) @Column(nullable = false)
    private StaffState state;
}
