package com.example.apijokenpo.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;


import javax.persistence.*;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
@Entity
public class InputEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private long id;

    @ManyToOne
    @JoinColumn(name = "player_entity_id")
    private PlayerEntity playerEntity;








}
