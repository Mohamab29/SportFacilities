package com.sports.sport.complaint;

/**
 * @author adam
 * @created 20:13
 */
@SuppressWarnings({"checkstyle:WhitespaceAround", "checkstyle:JavadocType"})
public class ResponseComplaint {

    @SuppressWarnings("checkstyle:JavadocVariable")
    private String idComplaint;

    @SuppressWarnings("checkstyle:JavadocVariable")
    private String responseComplaint;

    @SuppressWarnings({"checkstyle:WhitespaceAround", "checkstyle:MissingJavadocMethod"})
    public ResponseComplaint() {
    }

    @SuppressWarnings({"checkstyle:HiddenField", "checkstyle:FinalParameters", "checkstyle:MissingJavadocMethod"})
    public ResponseComplaint(String idComplaint, String responseComplaint) {
        this.idComplaint = idComplaint;
        this.responseComplaint = responseComplaint;
    }

    @SuppressWarnings({"checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public String getIdComplaint() {
        return idComplaint;
    }

    @SuppressWarnings({"checkstyle:HiddenField", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public void setIdComplaint(String idComplaint) {
        this.idComplaint = idComplaint;
    }

    @SuppressWarnings({"checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public String getResponseComplaint() {
        return responseComplaint;
    }

    @SuppressWarnings({"checkstyle:HiddenField", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public void setResponseComplaint(String responseComplaint) {
        this.responseComplaint = responseComplaint;
    }

    @SuppressWarnings({"checkstyle:OperatorWrap", "checkstyle:DesignForExtension"})
    @Override
    public String toString() {
        return "ResponseComplaint{" +
                "idComplaint='" + idComplaint + '\'' +
                ", responseComplaint='" + responseComplaint + '\'' +
                '}';
    }
}
