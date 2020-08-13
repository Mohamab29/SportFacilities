package com.sports.sport.controllers;

import com.sports.sport.complaint.Complaint;
import com.sports.sport.complaint.ResponseComplaint;
import com.sports.sport.repository.ComplaintRepository;
import com.sports.sport.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.List;

/**
 * @author adam
 * @created 20:23
 */
@SuppressWarnings("checkstyle:JavadocType")
@CrossOrigin
@RequestMapping("/complaint")
@RestController
public class ComplaintController {

    @SuppressWarnings("checkstyle:JavadocVariable")
    @Autowired
    private ComplaintService complaintService;

    //PM2020T25-218
    //Actions (Type . to access issue actions)
    @SuppressWarnings({"checkstyle:FinalParameters", "checkstyle:LineLength", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    @PostMapping("/addComplaint")
    public String addComplaint(@RequestBody Complaint complaint) throws MessagingException {

        return complaintService.save(complaint);

    }

    //PM2020T25-227
    //Actions (Type . to access issue actions)
    //PM2020T25-221
    //Actions (Type . to access issue actions)
    //PM2020T25-212
    //Actions (Type . to access issue actions)
    @SuppressWarnings({"checkstyle:FinalParameters", "checkstyle:LineLength", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    @PostMapping("/addResponseComplaint")
    public String setResponse(@RequestBody ResponseComplaint responseComplaint) throws MessagingException {

        return complaintService.setResponse(responseComplaint);
    }

    @SuppressWarnings({"checkstyle:WhitespaceAround", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    @DeleteMapping("/deleteComplaint/{id}")
    public String deleteComplaint(@PathVariable String id) {
        return complaintService.deleteComplaint(id);
    }

    //PM2020T25-209
    //Actions (Type . to access issue actions)
    @SuppressWarnings({"checkstyle:WhitespaceAround", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    @GetMapping("/findAllComplaint")
    public List<Complaint> findAll() {

        return complaintService.findAll();
    }

    @SuppressWarnings({"checkstyle:WhitespaceAround", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    @GetMapping("/findById/{idUser}")
    public List<Complaint> findByIdUser(@PathVariable String idUser) {

        return complaintService.findByIdUser(idUser);

    }
}
