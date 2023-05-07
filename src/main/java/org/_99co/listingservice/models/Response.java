package org._99co.listingservice.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Builder
public class Response<T> {
    @JsonProperty("result")
    private Boolean result;

    @JsonProperty("data")
    private T data;

}
