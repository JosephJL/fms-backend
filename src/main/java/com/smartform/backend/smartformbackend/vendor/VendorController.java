package com.smartform.backend.smartformbackend.vendor;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/vendor")
public class VendorController {
    @Autowired
    private VendorDAO vendorDAO;

    // anything you return is automatically coverted to JS
    @GetMapping("/all")
    public List<Vendor> getAllVendors() {
        return vendorDAO.findAll();
    }

    @RequestMapping("/toggleReminder/{id}")
    public ResponseEntity<String> toggleVendorReminder(@RequestBody Boolean status, @PathVariable String id) {
        vendorDAO.getVendor(id).setReminderStatus(status);
        return ResponseEntity
                .ok("Vendor " + vendorDAO.getVendor(id).getName() + " updated reminderStatus.");
    }

    // need to tell spring to send the id to the method
    @RequestMapping("/{id}")
    public Vendor getVendor(@PathVariable String id) {
        return vendorDAO.getVendor(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/")
    // getting the the request payload
    public void addVendor(@RequestBody Vendor vendor) {
        vendor.setJoinDate(new Date());
        vendor.setReminderStatus(true);
        vendorDAO.insertVendor(vendor);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public void updateVendor(@RequestBody Vendor vendor, @PathVariable String id) {
        vendorDAO.updateVendor(id, vendor);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void deleteVendor(@PathVariable String id) {
        vendorDAO.deleteVendor(id);
    }

    @GetMapping("/getJoinDates")
    public Map<Integer, JoinDateDTO> getJoinDates() {
        return vendorDAO.getJoinDates();
    }

    @GetMapping("/getAverageRejection")
    public Map<String, Double> getAverageRejection() {
        return vendorDAO.getAvgRejections();
    }

}
