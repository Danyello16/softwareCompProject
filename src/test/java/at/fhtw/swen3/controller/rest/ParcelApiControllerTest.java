package at.fhtw.swen3.controller.rest;

import at.fhtw.swen3.services.impl.controller.rest.ParcelApiController;
import at.fhtw.swen3.persistence.entities.*;
import at.fhtw.swen3.persistence.repositories.ParcelRepository;
import at.fhtw.swen3.services.dto.NewParcelInfo;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.dto.Recipient;
import at.fhtw.swen3.services.dto.TrackingInformation;
import at.fhtw.swen3.services.mapper.ParcelMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
@Transactional
@Slf4j
class ParcelApiControllerTest {
    @Autowired
    ParcelApiController parcelApiController;
    @Autowired
    ParcelRepository parcelRepository;
    @Autowired
    ParcelMapper parcelMapper;

    private ParcelEntity parcelEntity;
    private Parcel parcel;

    @BeforeEach
    void setUp() {
        RecipientEntity recipient = RecipientEntity.builder().name("recipientname").street("Landstraße 27a").postalCode("A-3500").city("Krems an der Donau").country("Austria").build();
        RecipientEntity sender = RecipientEntity.builder().name("sendername").street("Engerthstraße 228/6").postalCode("A-1020").city("Wien").country("Austria").build();

        final List<HopArrivalEntity> fakeHops = Arrays.asList(null, null, null);

        parcelEntity = ParcelEntity.builder()
                .weight(0.6f)
                .recipient(recipient)
                .sender(sender)
                .trackingId("PYJRB4HZ6")
                .deliveryStatus(TrackingInformation.StateEnum.INTRANSPORT)
                .visitedHops(fakeHops)
                .futureHops(fakeHops)
                .build();

        parcel = Parcel.builder()
                .weight(0.6f)
                .recipient(Recipient.builder().name("recipientname").street("Landstraße 27a").postalCode("A-3500").city("Krems an der Donau").country("Austria").build())
                .sender(Recipient.builder().name("sendername").street("Engerthstraße 228/6").postalCode("A-1020").city("Wien").country("Austria").build())
                .build();
    }

    @Test
    void reportParcelDelivery() {
        parcelApiController.transitionParcel(parcelEntity.getTrackingId(),parcelMapper.toParcelDto(parcelEntity));
        ResponseEntity<Void> delivery = parcelApiController.reportParcelDelivery(parcelEntity.getTrackingId());
        assertEquals(new ResponseEntity<>( HttpStatus.CREATED), delivery);
        try {
            assertEquals(parcelRepository.findByTrackingId(parcelEntity.getTrackingId()).getDeliveryStatus(), TrackingInformation.StateEnum.DELIVERED);
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
    }


    @Test
    void submitParcel() {
        ResponseEntity<NewParcelInfo> testResponse = parcelApiController.submitParcel(parcel);
        //System.out.println(testResponse);
        assertEquals(testResponse, new ResponseEntity<NewParcelInfo>(NewParcelInfo.builder().trackingId(testResponse.getBody().getTrackingId()).build(), HttpStatus.CREATED));

    }

    @Test
    void trackParcel() {
        ParcelEntity parcelForTracking = parcelRepository.save(parcelEntity);
        ResponseEntity<TrackingInformation> trackParcel = parcelApiController.trackParcel(parcelForTracking.getTrackingId());
        //System.out.println(trackParcel);
        assertEquals(trackParcel, new ResponseEntity<TrackingInformation>(parcelMapper.toTrackingInfoDto(parcelEntity),HttpStatus.OK));

    }

    @Test
    void transitionParcel() {
        ResponseEntity<NewParcelInfo> transitionParcel = parcelApiController.transitionParcel(parcelEntity.getTrackingId(),parcelMapper.toParcelDto(parcelEntity));
        //System.out.println(transitionParcel);
        assertEquals(transitionParcel, new ResponseEntity<NewParcelInfo>(parcelMapper.toParcelInfoDto(parcelEntity),HttpStatus.OK));

    }

}