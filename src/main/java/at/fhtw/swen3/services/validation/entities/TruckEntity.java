package at.fhtw.swen3.services.validation.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@EqualsAndHashCode(callSuper = true)    //for extending HopEntity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
//@Table(name = "truck")
public class TruckEntity extends HopEntity{
    /*@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;*/
    @Column
    private String regionGeoJson;
    @Column
    private String numberPlate;
}
