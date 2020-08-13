package com.sports.sport.service;

import com.sports.sport.complaint.Complaint;
import com.sports.sport.complaint.ResponseComplaint;
import com.sports.sport.message.SendEmail;
import com.sports.sport.repository.ComplaintRepository;
import com.sports.sport.security.UserService;
import com.sports.sport.security.userDetails.ApplicationUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.Date;
import java.util.List;

/**
 * @author adam
 * @created 19:31
 */
@SuppressWarnings({"checkstyle:LineLength", "checkstyle:JavadocType"})
@Service
public class ComplaintService {

    @SuppressWarnings("checkstyle:JavadocVariable")
    @Autowired
    private ComplaintRepository complaintRepository;

    @SuppressWarnings("checkstyle:JavadocVariable")
    @Autowired
    private UserService userService;


    @SuppressWarnings({"checkstyle:WhitespaceAround", "checkstyle:LineLength", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public String save(Complaint complaint) throws MessagingException {
        if (userService.existsById(complaint.getIdUser())) {

            ApplicationUser applicationUser = userService.findById(complaint.getIdUser());

            complaint.setStatus("wait for answer");
            complaint.setCreated(new Date());

            complaintRepository.save(complaint);
            SendEmail.sendMail(applicationUser.getUsername(), complaint.getSubject(), complaint.getBody());
            return "Thank you , Your complaint Sending ";
        } else {

            return "user not found";
        }

    }

    @SuppressWarnings({"checkstyle:WhitespaceAround", "checkstyle:WhitespaceAfter", "checkstyle:LineLength", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public String setResponse(ResponseComplaint responseComplaint) throws MessagingException {
        if (complaintRepository.existsById(responseComplaint.getIdComplaint())) {

            Complaint complaint = complaintRepository.findById(responseComplaint.getIdComplaint()).get();
            ApplicationUser applicationUser = userService.findById(complaint.getIdUser());
            complaint.setStatus("answer");
            complaint.setResponseAdmin(responseComplaint.getResponseComplaint());
            complaintRepository.save(complaint);
            SendEmail.sendMail(applicationUser.getUsername(), complaint.getSubject(), responseComplaint.getResponseComplaint());
            return "your response sending";
        } else {

            return "Complaint not found";
        }


    }

    @SuppressWarnings({"checkstyle:WhitespaceAround", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public List<Complaint> findAll() {


        return complaintRepository.findAll();
    }

    @SuppressWarnings({"checkstyle:WhitespaceAround", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public boolean existsById(String id) {
        return complaintRepository.existsById(id);
    }

    @SuppressWarnings({"checkstyle:WhitespaceAround", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public List<Complaint> findByIdUser(String idUser) {

        if (userService.existsById(idUser)) {

            return complaintRepository.findByIdUser(idUser);

        } else {
            return null;
        }
    }

    @SuppressWarnings({"checkstyle:WhitespaceAround", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public String deleteComplaint(String id) {

        if (complaintRepository.existsById(id)) {
            complaintRepository.deleteById(id);
            return "complaint Deleted";
        } else {

            return "complaint not found";
        }
    }
}
