package com.example.automatic.irrigation.system.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "land_plot")
public class LandPlot {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id ;
    @Column(name = "area_in_feddan")
    private Integer areaInFeddan;
    @OneToOne
    private Crop crop ;
    @Column(name = "time_slot")
    private LocalTime timeSlot ;
    @Column(name = "x_coordinate")
    private int  xCoordinate ;
    @Column(name = "y_coordinate")
    private int  yCoordinate ;



}
