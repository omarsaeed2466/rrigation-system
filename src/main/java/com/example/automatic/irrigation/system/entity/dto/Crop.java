package com.example.automatic.irrigation.system.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "crop")
public class Crop {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id ;
    @Column(name = "crop_name")
    private String cropName;
    @Column(name = "water_per_feddan")
    private Long waterPerFeddan;
    @Column(name = "time_per_feddan")
    private Long timePerFeddan;
}
