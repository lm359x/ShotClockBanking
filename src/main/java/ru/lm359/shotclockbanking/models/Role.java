package ru.lm359.shotclockbanking.models;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "roles")
@Getter
@EqualsAndHashCode
@NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    @EqualsAndHashCode.Exclude
    private Long roleId;

    @Column(name = "role_name", length = 20, nullable = false)
    private String roleName;


}
