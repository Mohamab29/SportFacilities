package com.sports.sport.controllers;

import com.sports.sport.damage.Damage;
import com.sports.sport.service.DamageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author adam
 * @created 17:38
 */

//PM2020T25-171 Bil
@SuppressWarnings({"checkstyle:LineLength", "checkstyle:JavadocType"})
@RestController
@CrossOrigin
@RequestMapping("/damage")
public class DamageController {


    @SuppressWarnings("checkstyle:JavadocVariable")
    @Autowired
    private DamageService damageService;

    //Build Rest api -Back end - inspector I can fill a damage form and send it to the admin
    @SuppressWarnings({"checkstyle:WhitespaceAround", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    @PostMapping("/addDamage")
    public String addDamage(@RequestBody Damage damage) {

        return damageService.save(damage);
    }

    @SuppressWarnings({"checkstyle:WhitespaceAround", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    @DeleteMapping(path = "{id}")
    public void deleteDamage(@PathVariable String id) {
        damageService.deleteDamage(id);
    }


    @SuppressWarnings({"checkstyle:WhitespaceAround", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    @GetMapping("/getAllDamage")
    public List<Damage> getListDamage() {

        return damageService.findAll();
    }


}
