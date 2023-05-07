package org._99co.listingservice.models;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PagingRequest {
    private Integer pageNum = 1;
    private Integer pageSize = 10;
}
