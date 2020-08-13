package com.sports.sport.service;

import com.sports.sport.damage.Damage;
import com.sports.sport.repository.RepositoryDamage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author adam
 * @created 18:01
 */
@SuppressWarnings({"checkstyle:NoWhitespaceBefore", "checkstyle:JavadocType"})
@Service
public class DamageService {


    @SuppressWarnings("checkstyle:JavadocVariable")
    @Autowired
    private RepositoryDamage repositoryDamage;

    @SuppressWarnings("checkstyle:JavadocVariable")
    @Autowired
    private AdvertisementService advertisementService;


    @SuppressWarnings({"checkstyle:WhitespaceAround", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public List<Damage> findAll() {

        return repositoryDamage.findAll();
    }

    //insert damage and update status Advertisement to Off
    @SuppressWarnings({"checkstyle:LineLength", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public String save(Damage damage) {
        damage.setDate(new Date());

        repositoryDamage.save(damage);
        if (damage.getStatus().equals("High")) {
            advertisementService.updateAdvertisementStatusToOff(damage.getIdAdvertisement());
        }
        return "Thanks for reporting";
    }

    //delete damage and update status Advertisement to On
    @SuppressWarnings({"checkstyle:EmptyBlock", "checkstyle:LineLength", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public void deleteDamage(String id) {
        if (repositoryDamage.existsById(id)) {
            Damage damage = repositoryDamage.findById(id).get();
            advertisementService.updateAdvertisementStatusToON(damage.getIdAdvertisement());
            repositoryDamage.deleteById(damage.getId());
        } else {
        }

    }

    @SuppressWarnings({"checkstyle:WhitespaceAround", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public Damage findById(String id) {

        if (repositoryDamage.existsById(id)) {
            return repositoryDamage.findById(id).get();
        } else {
            return null;
        }


    }

    @SuppressWarnings({"checkstyle:WhitespaceAround", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public boolean existsById(String id) {

        return repositoryDamage.existsById(id);
    }
}
