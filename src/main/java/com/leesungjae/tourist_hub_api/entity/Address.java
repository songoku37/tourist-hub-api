package com.leesungjae.tourist_hub_api.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Address extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long addressId;

    private int areaCode;// 시코드
    private int sigungucodeCode; // 시구군 코드

    private String areaName;
    private String sigungucodeName;

    @ManyToOne// (fetch = FetchType.LAZY)
    @JoinColumn(name = "TOURIST_ID")
    @JsonIgnore
    private TouristAttraction touristAttraction;

}
