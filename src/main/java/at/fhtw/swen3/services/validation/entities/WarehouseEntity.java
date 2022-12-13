package at.fhtw.swen3.services.validation.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)    //for extending HopEntity
@Entity
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
//@Table(name = "warehouse")
public class WarehouseEntity extends HopEntity{
    /*@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;*/

    @Column
    private Integer level;

    //@OneToMany(mappedBy = "warehouse")
    @OneToMany(mappedBy = "hop")
    private List<WarehouseNextHopsEntity> nextHops = new ArrayList<>();
}
