package at.fhtw.swen3.services.dto;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import javax.persistence.Column;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;


import javax.annotation.Generated;

/**
 * Parcel
 */
@Getter @Setter
@at.fhtw.swen3.persistence.entity.Parcel
@JsonTypeName("parcel")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-09-23T12:35:41.388911Z[Etc/UTC]")
public class Parcel {

  @Column
  @JsonProperty("weight")
  private Float weight;

  @Column
  @JsonProperty("recipient")
  private Recipient recipient;

  @Column
  @JsonProperty("sender")
  private Recipient sender;

  public Parcel weight(Float weight) {
    this.weight = weight;
    return this;
  }

  /**
   * Get weight
   * @return weight
  */
  @NotNull 
  @Schema(name = "weight", required = true)
  public Float getWeight() {
    return weight;
  }

  public void setWeight(Float weight) {
    this.weight = weight;
  }

  public Parcel recipient(Recipient recipient) {
    this.recipient = recipient;
    return this;
  }

  /**
   * Get recipient
   * @return recipient
  */
  @NotNull @Valid 
  @Schema(name = "recipient", required = true)
  public Recipient getRecipient() {
    return recipient;
  }

  public void setRecipient(Recipient recipient) {
    this.recipient = recipient;
  }

  public Parcel sender(Recipient sender) {
    this.sender = sender;
    return this;
  }

  /**
   * Get sender
   * @return sender
  */
  @NotNull @Valid 
  @Schema(name = "sender", required = true)
  public Recipient getSender() {
    return sender;
  }

  public void setSender(Recipient sender) {
    this.sender = sender;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Parcel parcel = (Parcel) o;
    return Objects.equals(this.weight, parcel.weight) &&
        Objects.equals(this.recipient, parcel.recipient) &&
        Objects.equals(this.sender, parcel.sender);
  }

  @Override
  public int hashCode() {
    return Objects.hash(weight, recipient, sender);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Parcel {\n");
    sb.append("    weight: ").append(toIndentedString(weight)).append("\n");
    sb.append("    recipient: ").append(toIndentedString(recipient)).append("\n");
    sb.append("    sender: ").append(toIndentedString(sender)).append("\n");
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

