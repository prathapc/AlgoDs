package com.practice.algo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LazadaAccountInfoResponseDto {

  @JsonProperty("module")
  private LazadaAccountInfoDto lazadaAccountInfoDto;

  public LazadaAccountInfoDto getLazadaAccountInfoDto() {
    return lazadaAccountInfoDto;
  }

  public void setLazadaAccountInfoDto(LazadaAccountInfoDto lazadaAccountInfoDto) {
    this.lazadaAccountInfoDto = lazadaAccountInfoDto;
  }

  @Override
  public String toString() {
    return "LazadaAccountInfoResponseDto{"
        + "lazadaAccountInfoDto=" + lazadaAccountInfoDto
        + '}';
  }
}
