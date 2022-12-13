package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.services.dto.HopArrival;
import at.fhtw.swen3.services.validation.entities.HopArrivalEntity;

public class HopArrivalMapper  extends AbstractMapper<HopArrivalEntity, HopArrival>{
    @Override
    public HopArrival mapToTarget(HopArrivalEntity object) {
        return HopArrival.builder().code(object.getCode()).description(object.getDescription()).dateTime(object.getDateTime()).build();
    }

    @Override
    public HopArrivalEntity mapToSource(HopArrival object) {
        return HopArrivalEntity.builder().code(object.getCode()).description(object.getDescription()).dateTime(object.getDateTime()).build();
    }
}
