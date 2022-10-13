/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (6.1.1-SNAPSHOT).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package at.fhtw.swen3.services;

import at.fhtw.swen3.services.dto.Error;
import at.fhtw.swen3.services.dto.Hop;
import at.fhtw.swen3.services.dto.Warehouse;
import at.fhtw.swen3.services.impl.ApiUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.Optional;
import javax.annotation.Generated;

import static org.springframework.http.MediaType.*;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-09-23T12:35:41.388911Z[Etc/UTC]")
@Validated
@Tag(name = "warehouse", description = "Operations for the warehouse management.")
@RequestMapping("${openapi.parcelLogisticsService.base-path:}")
public interface WarehouseApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /warehouse : Exports the hierarchy of Warehouse and Truck objects. 
     *
     * @return Successful response (status code 200)
     *         or The operation failed due to an error. (status code 400)
     *         or No hierarchy loaded yet. (status code 404)
     */
    @Operation(
        operationId = "exportWarehouses",
        summary = "Exports the hierarchy of Warehouse and Truck objects. ",
        tags = { "warehouse-management" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful response", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Warehouse.class))
            }),
            @ApiResponse(responseCode = "400", description = "The operation failed due to an error.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))
            }),
            @ApiResponse(responseCode = "404", description = "No hierarchy loaded yet.")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/warehouse",
        produces = { "application/json" }
    )
    default ResponseEntity<Warehouse> exportWarehouses(
        
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(valueOf("application/json"))) {
                    String exampleString = "null";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /warehouse/{code} : Get a certain warehouse or truck by code
     *
     * @param code  (required)
     * @return Successful response (status code 200)
     *         or The operation failed due to an error. (status code 400)
     *         or No hop with the specified id could be found. (status code 404)
     */
    @Operation(
        operationId = "getWarehouse",
        summary = "Get a certain warehouse or truck by code",
        tags = { "warehouse-management" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful response", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Hop.class))
            }),
            @ApiResponse(responseCode = "400", description = "The operation failed due to an error.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))
            }),
            @ApiResponse(responseCode = "404", description = "No hop with the specified id could be found.")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/warehouse/{code}",
        produces = { "application/json" }
    )
    default ResponseEntity<Hop> getWarehouse(
        @Parameter(name = "code", description = "", required = true) @PathVariable("code") String code
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(valueOf("application/json"))) {
                    String exampleString = "{ \"code\" : \"code\", \"locationName\" : \"locationName\", \"processingDelayMins\" : 0, \"hopType\" : \"hopType\", \"description\" : \"description\", \"locationCoordinates\" : { \"lon\" : 1.4658129805029452, \"lat\" : 6.027456183070403 } }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /warehouse : Imports a hierarchy of Warehouse and Truck objects. 
     *
     * @param warehouse  (required)
     * @return Successfully loaded. (status code 200)
     *         or The operation failed due to an error. (status code 400)
     */
    @Operation(
        operationId = "importWarehouses",
        summary = "Imports a hierarchy of Warehouse and Truck objects. ",
        tags = { "warehouse-management" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Successfully loaded."),
            @ApiResponse(responseCode = "400", description = "The operation failed due to an error.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/warehouse",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<Void> importWarehouses(
        @Parameter(name = "Warehouse", description = "", required = true) @Valid @RequestBody Warehouse warehouse
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
