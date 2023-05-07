package org._99co.listingservice.services;

import lombok.AllArgsConstructor;
import org._99co.listingservice.entities.Listing;
import org._99co.listingservice.models.enums.ListingType;
import org._99co.listingservice.repositories.ListingRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ListingService {
    private ListingRepository listingRepository;

    public List<Listing> getAllListing(Integer userId, Integer page, Integer size){
        Listing parameter = Listing.builder().userId(userId).build();
        Page<Listing> listings = listingRepository.findAll(Example.of(parameter), PageRequest.of(page-1, size, Sort.by(Sort.Direction.DESC, "createdAt")));
        return listings.stream().toList();
    }

    public Listing createListing(Integer userId, Integer price, ListingType listingType){
        Listing listing = Listing.builder()
                .userId(userId)
                .price(price)
                .listingType(listingType)
                .build();
        return listingRepository.save(listing);
    }
}
