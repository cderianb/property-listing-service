package org._99co.listingservice.repositories;

import org._99co.listingservice.entities.Listing;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ListingRepository extends JpaRepository<Listing, Integer> {
    Page<Listing> findAllByOrderByCreatedAtDesc(Example<Listing> parameter, PageRequest pageRequest);
}
