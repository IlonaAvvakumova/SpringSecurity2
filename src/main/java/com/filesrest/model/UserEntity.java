package com.filesrest.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users", schema = "flyway_db")
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @Enumerated(value = EnumType.STRING)
    private Role role;
    private String password;

    @Enumerated(value = EnumType.STRING)
    private Status status;

    @JsonManagedReference
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = EventEntity.class)
    private List<EventEntity> eventEntities;


}
