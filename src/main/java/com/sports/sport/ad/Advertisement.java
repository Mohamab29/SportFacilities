
package com.sports.sport.ad;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author adam
 * @created
 */
@SuppressWarnings({"ALL", "checkstyle:LineLength"})
@Document(collection = "Ad")
public class Advertisement {

    /**
     *
     *
     *
     */

    @SuppressWarnings("checkstyle:JavadocVariable")
    @Id
    private String id;

    @SuppressWarnings("checkstyle:JavadocVariable")
    private String type;
    @SuppressWarnings("checkstyle:JavadocVariable")
    private String name;
    @SuppressWarnings("checkstyle:JavadocVariable")
    private String street;
    @SuppressWarnings("checkstyle:JavadocVariable")
    private String houseNumber;
    @SuppressWarnings("checkstyle:JavadocVariable")
    private String neighborhood;
    @SuppressWarnings("checkstyle:JavadocVariable")
    private String operator;
    @SuppressWarnings("checkstyle:JavadocVariable")
    private String seats;
    @SuppressWarnings("checkstyle:JavadocVariable")
    private String activity;
    @SuppressWarnings("checkstyle:JavadocVariable")
    private String fencing;
    @SuppressWarnings("checkstyle:JavadocVariable")
    private String lighting;
    @SuppressWarnings("checkstyle:JavadocVariable")
    private String handicapped;
    @SuppressWarnings("checkstyle:JavadocVariable")
    private String condition;
    @SuppressWarnings("checkstyle:JavadocVariable")
    private String owner;
    @SuppressWarnings("checkstyle:JavadocVariable")
    private String forSchool;
    @SuppressWarnings("checkstyle:JavadocVariable")
    private String association;
    @SuppressWarnings("checkstyle:JavadocVariable")
    private String sportType;
    @SuppressWarnings("checkstyle:JavadocVariable")
    private String lat;
    @SuppressWarnings("checkstyle:JavadocVariable")
    private String lon;

    @SuppressWarnings("checkstyle:MissingJavadocMethod")
    public Advertisement() {
    }

    /**
     * @param type
     * @param name
     * @param street
     * @param houseNumber
     * @param neighborhood
     * @param operator
     * @param seats
     * @param activity
     * @param fencing
     * @param lighting
     * @param handicapped
     * @param condition
     * @param owner
     * @param forSchool
     * @param association
     * @param sportType
     * @param lat
     * @param lon
     */
    @SuppressWarnings({"checkstyle:HiddenField", "checkstyle:FinalParameters", "checkstyle:ParameterNumber", "checkstyle:MissingJavadocMethod", "checkstyle:LineLength"})
    public Advertisement(String type, String name, String street, String houseNumber, String neighborhood, String operator, String seats, String activity, String fencing, String lighting, String handicapped, String condition, String owner, String forSchool, String association, String sportType, String lat, String lon) {
        this.type = type;
        this.name = name;
        this.street = street;
        this.houseNumber = houseNumber;
        this.neighborhood = neighborhood;
        this.operator = operator;
        this.seats = seats;
        this.activity = activity;
        this.fencing = fencing;
        this.lighting = lighting;
        this.handicapped = handicapped;
        this.condition = condition;
        this.owner = owner;
        this.forSchool = forSchool;
        this.association = association;
        this.sportType = sportType;
        this.lat = lat;
        this.lon = lon;
    }

    /**
     * @return
     */
    @SuppressWarnings({"checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    @SuppressWarnings({"checkstyle:HiddenField", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public void setId(String id) {
        this.id = id;
    }

    @SuppressWarnings({"checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public String getType() {
        return type;
    }

    @SuppressWarnings({"checkstyle:HiddenField", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public void setType(String type) {
        this.type = type;
    }

    @SuppressWarnings({"checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public String getName() {
        return name;
    }

    @SuppressWarnings({"checkstyle:HiddenField", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public void setName(String name) {
        this.name = name;
    }

    @SuppressWarnings({"checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public String getStreet() {
        return street;
    }

    @SuppressWarnings({"checkstyle:HiddenField", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public void setStreet(String street) {
        this.street = street;
    }

    @SuppressWarnings({"checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public String getHouseNumber() {
        return houseNumber;
    }

    @SuppressWarnings({"checkstyle:HiddenField", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    @SuppressWarnings({"checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public String getNeighborhood() {
        return neighborhood;
    }

    @SuppressWarnings({"checkstyle:HiddenField", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    @SuppressWarnings({"checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public String getOperator() {
        return operator;
    }

    @SuppressWarnings({"checkstyle:HiddenField", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public void setOperator(String operator) {
        this.operator = operator;
    }

    @SuppressWarnings({"checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public String getSeats() {
        return seats;
    }

    @SuppressWarnings({"checkstyle:HiddenField", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public void setSeats(String seats) {
        seats = seats;
    }

    @SuppressWarnings({"checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public String getActivity() {
        return activity;
    }

    @SuppressWarnings({"checkstyle:HiddenField", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public void setActivity(String activity) {
        activity = activity;
    }

    @SuppressWarnings({"checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public String getFencing() {
        return fencing;
    }

    @SuppressWarnings({"checkstyle:HiddenField", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public void setFencing(String fencing) {
        this.fencing = fencing;
    }

    @SuppressWarnings({"checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public String getLighting() {
        return lighting;
    }

    @SuppressWarnings({"checkstyle:HiddenField", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public void setLighting(String lighting) {
        this.lighting = lighting;
    }

    @SuppressWarnings({"checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public String getHandicapped() {
        return handicapped;
    }

    @SuppressWarnings({"checkstyle:HiddenField", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public void setHandicapped(String handicapped) {
        this.handicapped = handicapped;
    }

    @SuppressWarnings({"checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public String getCondition() {
        return condition;
    }

    @SuppressWarnings({"checkstyle:HiddenField", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public void setCondition(String condition) {
        this.condition = condition;
    }

    @SuppressWarnings({"checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public String getOwner() {
        return owner;
    }

    @SuppressWarnings({"checkstyle:HiddenField", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public void setOwner(String owner) {
        this.owner = owner;
    }

    @SuppressWarnings({"checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public String getForSchool() {
        return forSchool;
    }

    @SuppressWarnings({"checkstyle:HiddenField", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public void setForSchool(String forSchool) {
        this.forSchool = forSchool;
    }

    @SuppressWarnings({"checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public String getAssociation() {
        return association;
    }

    @SuppressWarnings({"checkstyle:HiddenField", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public void setAssociation(String association) {
        this.association = association;
    }

    @SuppressWarnings({"checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public String getSportType() {
        return sportType;
    }

    @SuppressWarnings({"checkstyle:HiddenField", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public void setSportType(String sportType) {
        this.sportType = sportType;
    }

    @SuppressWarnings({"checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public String getLat() {
        return lat;
    }

    @SuppressWarnings({"checkstyle:HiddenField", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public void setLat(String lat) {
        this.lat = lat;
    }

    @SuppressWarnings({"checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public String getLon() {
        return lon;
    }

    @SuppressWarnings({"checkstyle:HiddenField", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public void setLon(String lon) {
        this.lon = lon;
    }


    @SuppressWarnings({"checkstyle:OperatorWrap", "checkstyle:DesignForExtension"})
    @Override
    public String toString() {
        return "Ad{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", street='" + street + '\'' +
                ", houseNumber='" + houseNumber + '\'' +
                ", neighborhood='" + neighborhood + '\'' +
                ", operator='" + operator + '\'' +
                ", Seats='" + seats + '\'' +
                ", Activity='" + activity + '\'' +
                ", fencing='" + fencing + '\'' +
                ", lighting='" + lighting + '\'' +
                ", handicapped='" + handicapped + '\'' +
                ", condition='" + condition + '\'' +
                ", owner='" + owner + '\'' +
                ", forSchool='" + forSchool + '\'' +
                ", association='" + association + '\'' +
                ", sportType='" + sportType + '\'' +
                ", lat='" + lat + '\'' +
                ", lon='" + lon + '\'' +
                '}';
    }
}
