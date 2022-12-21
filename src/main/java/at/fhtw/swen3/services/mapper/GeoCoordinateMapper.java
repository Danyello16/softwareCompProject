package at.fhtw.swen3.services.mapper;

import at.fhtw.swen3.services.dto.GeoCoordinate;
import at.fhtw.swen3.services.validation.entities.GeoCoordinateEntity;

public class GeoCoordinateMapper extends AbstractMapper<GeoCoordinateEntity, GeoCoordinate>{
    @Override
    public GeoCoordinate mapToTarget(GeoCoordinateEntity entity) {
        return GeoCoordinate.builder().lat(entity.getLat()).lon(entity.getLon()).build();
    }

    @Override
    public GeoCoordinateEntity mapToSource(GeoCoordinate dto) {
        return GeoCoordinateEntity.builder().lat(dto.getLat()).lon(dto.getLon()).build();
    }
}