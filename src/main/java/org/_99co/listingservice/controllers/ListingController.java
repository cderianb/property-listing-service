package org._99co.listingservice.controllers;

import org._99co.listingservice.entities.Listing;
import org._99co.listingservice.helper.ResponseHelper;
import org._99co.listingservice.models.PagingRequest;
import org._99co.listingservice.models.Response;
import org._99co.listingservice.models.enums.ListingType;
import org._99co.listingservice.services.ListingService;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/listings", produces = MediaType.APPLICATION_JSON_VALUE)
public class ListingController {

    private final ListingService listingService;
    public ListingController(ListingService listingService) {
        this.listingService = listingService;
    }

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<List<Listing>> getAllListing(@RequestParam(value = "user_id", required = false) Integer userId
                                                , @RequestParam(value = "page_num", defaultValue = "1") Integer page
                                                , @RequestParam(value = "page_size", defaultValue = "10") Integer size){
        List<Listing> allListing = listingService.getAllListing(userId, page, size);
        return ResponseHelper.ok(allListing);
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<Listing> postListing(@RequestBody MultiValueMap<String, String> paramMap){
        Integer userId = Integer.parseInt((String) paramMap.get("user_id").get(0));
        Integer price = Integer.parseInt((String) paramMap.get("price").get(0));
        ListingType listingType = ListingType.valueOf(paramMap.get("listing_type").get(0).toLowerCase());

        Listing listing = listingService.createListing(userId, price, listingType);
        return ResponseHelper.ok(listing);
    }

}
