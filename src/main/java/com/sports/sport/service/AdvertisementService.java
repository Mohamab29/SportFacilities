package com.sports.sport.service;

import com.sports.sport.ad.Advertisement;
import com.sports.sport.repository.AdvertisementRepository;
import com.sports.sport.reservation.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author adam
 * @created 18:13
 */
@SuppressWarnings("checkstyle:JavadocType")
@Service
public class AdvertisementService {


    @SuppressWarnings("checkstyle:JavadocVariable")
    @Autowired
    private AdvertisementRepository advertisementRepository;

    @SuppressWarnings({"checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
            public List<Advertisement> findAll() {
                return advertisementRepository.findAll();

            }

    //PM2020T25-174
    @SuppressWarnings({"checkstyle:WhitespaceAround", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public String update(Advertisement advertisement) {

        if (advertisementRepository.existsById(advertisement.getId())) {

            advertisementRepository.save(advertisement);
            return "Done!";
        } else {

            return "Advertisement not found";
        }
    }

    @SuppressWarnings({"checkstyle:WhitespaceAround", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public String insert(Advertisement advertisement) {

        if (advertisementRepository.existsById(advertisement.getId())) {

            return "the advertisement already exists";
        } else {

            advertisementRepository.save(advertisement);

            return "add new advertisement with id " + advertisement.getId();
        }
    }

    ////PM2020T25-173
    @SuppressWarnings({"checkstyle:WhitespaceAround", "checkstyle:RightCurly", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public String delete(String id) {
        if (advertisementRepository.existsById(id)) {

            advertisementRepository.deleteById(id);

            return "the advertisement with id : " + id + " is delete";
        } else {
            return id + ": not found";
        }


    }

    @SuppressWarnings({"checkstyle:WhitespaceAround", "checkstyle:EmptyBlock", "checkstyle:LineLength", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public void updateAdvertisementStatusToOff(String idAdvertisement) {
        if (advertisementRepository.existsById(idAdvertisement)) {

            Advertisement advertisement = advertisementRepository.findById(idAdvertisement).get();
            advertisement.setCondition("לא תקין ולא פעיל");
            advertisementRepository.save(advertisement);
        } else {
        }
    }

    @SuppressWarnings({"checkstyle:WhitespaceAround", "checkstyle:EmptyBlock", "checkstyle:WhitespaceAfter", "checkstyle:LineLength", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public void updateAdvertisementStatusToON(String idAdvertisement) {

        if (advertisementRepository.existsById(idAdvertisement)) {

            Advertisement advertisement = advertisementRepository.findById(idAdvertisement).get();
            advertisement.setCondition("תקין ופעיל");//change
            advertisementRepository.save(advertisement);
        } else {
        }

    }

    @SuppressWarnings({"checkstyle:WhitespaceAround", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public Advertisement findById(String id) {

        if (advertisementRepository.existsById(id)) {
            return advertisementRepository.findById(id).get();
        } else {
            return null;
        }

    }

    @SuppressWarnings({"checkstyle:WhitespaceAround", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public boolean existsById(String id) {

        return advertisementRepository.existsById(id);
    }

    @SuppressWarnings({"checkstyle:RightCurly", "checkstyle:WhitespaceAround", "checkstyle:SimplifyBooleanReturn", "checkstyle:LineLength", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public boolean checkAdvertisementAvailable(String id) {

        if (this.existsById(id)) {

            return !advertisementRepository.findById(id).get().getCondition().equals("לא תקין ולא פעיל");
        } else {
            return false;
        }

    }

}
