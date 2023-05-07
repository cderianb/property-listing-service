package org._99co.listingservice.helper;

import org._99co.listingservice.models.Response;

public class ResponseHelper {
    public static<T> Response<T> ok(T data){
        return Response.<T>builder()
                .result(true)
                .data(data)
                .build();
    }
}
