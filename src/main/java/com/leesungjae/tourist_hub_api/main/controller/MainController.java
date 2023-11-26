package com.leesungjae.tourist_hub_api.main.controller;

import com.leesungjae.tourist_hub_api.entity.Address;
import com.leesungjae.tourist_hub_api.entity.HashTag;
import com.leesungjae.tourist_hub_api.entity.TouristAttraction;
import com.leesungjae.tourist_hub_api.entity.TouristImage;
import com.leesungjae.tourist_hub_api.main.repository.TouristAttractionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller()
public class MainController {

    @Autowired
    TouristAttractionRepository touristAttractionRepository;

    @GetMapping("/data")
    @ResponseBody
    public Map<String, Object> getData(@RequestParam(name = "pageNum", defaultValue = "0") int pageNum, @RequestParam(name="order", defaultValue = "good") String order) {

        String orderType = "like";

        if(order.equals("good"))  orderType = "like";
        else if(order.equals("ganada")) orderType = "title";

        System.out.println("pageNum : " + pageNum);
        Map<String, Object> map =  new HashMap<>();

        List<TouristAttraction> tt = touristAttractionRepository.findAll();

        PageRequest pageRequest = PageRequest.of(pageNum, 9, Sort.by(Sort.Direction.DESC, orderType));

        Page<TouristAttraction> page = touristAttractionRepository.findAllBy(pageRequest);
        List<TouristAttraction> touristAttractions = page.getContent();
        long total = Optional.ofNullable(page.getTotalElements()).orElseGet(()->0L);

        List<TouristImage> touristImages = touristAttractions.size() > 0 ? touristAttractions.get(0).getTouristImages() : new ArrayList<>();
        List<Address> addresses = touristAttractions.size() > 0 ? touristAttractions.get(0).getAddressList() : new ArrayList<>();
        List<HashTag> hashTags = touristAttractions.size() > 0 ? touristAttractions.get(0).getHashTags() : new ArrayList<>();


        map.put("total",total);
        map.put("result",touristAttractions);

        return map;

    }

//    @GetMapping()
//    @ResponseBody
//    public Map<String, Object> getData() {
//
//        Map<String, Object> map =  new HashMap<>();
//
//        List<TouristAttraction> tt = touristAttractionRepository.findAll();
//
//        PageRequest pageRequest = PageRequest.of(0, 9, Sort.by(Sort.Direction.DESC, "title"));
//
//        Page<TouristAttraction> page = touristAttractionRepository.findAllBy(pageRequest);
//        List<TouristAttraction> touristAttractions = page.getContent();
//        long total = Optional.ofNullable(page.getTotalElements()).orElseGet(()->0L);
//
//        List<TouristImage> touristImages = touristAttractions.get(0).getTouristImages();
//        List<Address> addresses = touristAttractions.get(0).getAddressList();
//        List<HashTag> hashTags = touristAttractions.get(0).getHashTags();
//
//
//        map.put("total",total);
//        map.put("result",touristAttractions);
//
//        return map;
//
//    }
}
