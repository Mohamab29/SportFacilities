package com.sports.sport.controllers;

import com.sports.sport.ad.Advertisement;
import com.sports.sport.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author adam
 * @created
 */
@CrossOrigin
@RequestMapping("/category")
@RestController
public class AdvertisementController {

    @SuppressWarnings("checkstyle:JavadocVariable")
    @Autowired
    private AdvertisementService advertisementService;

    //PM2020T25-172
    //PM2020T25-182
    //Build Rest api -Back end - admin I can view advertisement of Sport facilities
    //Build Rest api -Back end -inspector I can view the sport facilities
    //Build Rest api -Back end -Client I can view the sport facilities
    @SuppressWarnings({"checkstyle:WhitespaceAround", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod", "checkstyle:LineLength"})
    @GetMapping("/getCategoryAd")
    public List<Advertisement> getAllAdvertisement() {
        return advertisementService.findAll();
    }


    @SuppressWarnings({"checkstyle:WhitespaceAround", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    @GetMapping("/{id}")
    public Advertisement getAdvertisementById(@PathVariable String id) {

        return advertisementService.findById(id);
    }

    //PM2020T25-174
//        Build Rest api -Back end -admin I can Edit advertisements information of Sport facilities with an Edit button displayed besides the advertisement
    @SuppressWarnings({"checkstyle:WhitespaceAround", "checkstyle:FinalParameters", "checkstyle:LineLength", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    @PostMapping("/updateAdvertisement")
    public String updateAdvertisement(@RequestBody Advertisement advertisement) {

        return advertisementService.update(advertisement);

    }

    //PM2020T25-173
    //Build Rest api -Back end - admin I can delete advertisement of Sport facilities with a delete button displayed besides the advertisement
    @SuppressWarnings({"checkstyle:WhitespaceAround", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod", "checkstyle:LineLength"})
    @DeleteMapping("/delete/{id}")
    public String deleteAdvertisement(@PathVariable String id) {

        return advertisementService.delete(id);
    }

    //PM2020T25-175
    //Build Rest api -Back end - Admin I can Add An advertisement of a new sports facility
    @SuppressWarnings({"checkstyle:WhitespaceAround", "checkstyle:FinalParameters", "checkstyle:LineLength", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    @PostMapping("/addAdvertisement")
    public String addAdvertisement(@RequestBody Advertisement advertisement) {

        return advertisementService.insert(advertisement);
    }

}


