package at.fhtw.swen3.services.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import org.springframework.format.annotation.DateTimeFormat;

import javax.annotation.Generated;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.OffsetDateTime;
import java.util.Objects;

/**
 * HopArrival
 */

@JsonTypeName("hopArrival")
@Builder
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-09-22T13:39:57.022856Z[Etc/UTC]")
public class HopArrival {

  @JsonProperty("code")
  @Pattern(regexp = " ^[A-Z]{4}\\d{1,4}$", message = "must match postal code regex")
  private String code;

  @JsonProperty("description")
  @Pattern(regexp = " ^[A-Za-z0-9\\s\\-]$", message = "text")
  private String description;

  @JsonProperty("dateTime")
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime dateTime;

  public HopArrival code(String code) {
    this.code = code;
    return this;
  }

  /**
   * Unique CODE of the hop.
   * @return code
   */
  @NotNull @Pattern(regexp = "^[A-Z]{4}\\d{1,4}$")
  @Schema(name = "code", description = "Unique CODE of the hop.", required = true)
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public HopArrival description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Description of the hop.
   * @return description
   */
  @NotNull
  @Schema(name = "description", description = "Description of the hop.", required = true)
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public HopArrival dateTime(OffsetDateTime dateTime) {
    this.dateTime = dateTime;
    return this;
  }

  /**
   * The date/time the parcel arrived at the hop.
   * @return dateTime
   */
  @NotNull @Valid
  @Schema(name = "dateTime", description = "The date/time the parcel arrived at the hop.", required = true)
  public OffsetDateTime getDateTime() {
    return dateTime;
  }

  public void setDateTime(OffsetDateTime dateTime) {
    this.dateTime = dateTime;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    HopArrival hopArrival = (HopArrival) o;
    return Objects.equals(this.code, hopArrival.code) &&
            Objects.equals(this.description, hopArrival.description) &&
            Objects.equals(this.dateTime, hopArrival.dateTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, description, dateTime);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class HopArrival {\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    dateTime: ").append(toIndentedString(dateTime)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

