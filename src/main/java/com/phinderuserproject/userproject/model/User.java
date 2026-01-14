package com.phinderuserproject.userproject.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter @Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuarios")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String patSurname;

    private String matSurname;

    private LocalDate birthDate;

    private String gender;

    private String curp;

    private String rfc;

    @Column(nullable = false)
    private Boolean active;

    @OneToOne(cascade = CascadeType.ALL,
                        fetch = FetchType.LAZY,
                        optional = false,
                        orphanRemoval = true)
    @JoinColumn(name = "direccion_id", referencedColumnName = "id")
    private Direction direction;

}
