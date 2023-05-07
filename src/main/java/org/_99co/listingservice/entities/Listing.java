package org._99co.listingservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import org._99co.listingservice.models.enums.ListingType;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "listings")
@EntityListeners(AuditingEntityListener.class)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Listing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("user_id")
    private Integer userId;

    @JsonProperty("price")
    private Integer price;

    @JsonProperty("listing_type")
    @Enumerated(value = EnumType.STRING)
    private ListingType listingType;

    @CreatedDate
    @JsonProperty("created_at")
    private Long createdAt;

    @LastModifiedDate
    @JsonProperty("updated_at")
    private Long updatedAt;

}
