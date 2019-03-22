package com.practice.algo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LazadaAccountInfoDto {

  @JsonProperty("id")
  private Long meberId;
  @JsonProperty("email")
  private String email;
  @JsonProperty("phone")
  private String phone;

  public Long getMeberId() {
    return meberId;
  }

  public void setMeberId(Long meberId) {
    this.meberId = meberId;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }
}
