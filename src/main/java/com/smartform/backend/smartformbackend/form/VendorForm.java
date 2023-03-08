package com.smartform.backend.smartformbackend.form;

import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "forms")
public class VendorForm {
    @Id
    private String id;
    private String vendorName;
    private String creationDate;
    private String vendorId;
    private Map<String, Object> content;

    public VendorForm(String vendorName, String creationDate, Map<String, Object> content,
            String vendorId) {
        this.vendorName = vendorName;
        this.creationDate = creationDate;
        this.vendorId = vendorId;
        this.content = content;
    }

    public Map<String, Object> getContent() {
        return content;
    }

    public void setContent(Map<String, Object> content) {
        this.content = content;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVendorName() {
        return this.vendorName;
    }

    public void getVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getCreateDate() {
        return this.creationDate;
    }

    public void setCreateDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getVendorId() {
        return this.vendorId;
    }

    public void setVendorId(String id) {
        this.vendorId = id;
    }

}
