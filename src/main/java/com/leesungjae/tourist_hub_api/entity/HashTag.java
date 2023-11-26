package com.leesungjae.tourist_hub_api.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class HashTag extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long tagId;

    @ManyToOne //(fetch = FetchType.LAZY)
    @JoinColumn(name = "TOURIST_ID")
    @JsonIgnore
    private TouristAttraction touristAttraction;

    private String name;

}
