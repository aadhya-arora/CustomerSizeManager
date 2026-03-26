package com.raanjhana.service;

import com.raanjhana.model.*;
import com.raanjhana.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.raanjhana.repository.TrouserRepository;
import com.raanjhana.repository.SherwaniRepository;
import com.raanjhana.repository.ShirtRepository;
import com.raanjhana.repository.CoatRepository;
import com.raanjhana.repository.WaistcoatRepository;
import com.raanjhana.repository.KurtaRepository;
import com.raanjhana.repository.CustomerRepository;

@Service
public class SizeService {

    @Autowired
    private TrouserRepository trouserRepo;

    @Autowired
    private SherwaniRepository sherwaniRepo;

    @Autowired
    private ShirtRepository shirtRepo;

    @Autowired
    private CoatRepository coatRepo;

    @Autowired
    private WaistcoatRepository waistRepo;

    @Autowired
    private KurtaRepository kurtaRepo;

    @Autowired
    private CustomerRepository customerRepo; // Added to manage customer records

    private void ensureCustomerExists(String phoneNumber, String name) {

        if (phoneNumber == null || phoneNumber.trim().isEmpty()) {
            return;
        }

        Customer existing = customerRepo.findById(phoneNumber).orElse(null);

        if (existing == null) {
            Customer newCustomer = new Customer();
            newCustomer.setCustomerPhoneNumber(phoneNumber);
            newCustomer.setName(name != null ? name : "Unknown");
            customerRepo.save(newCustomer);
        } else {
            if (name != null && !name.isEmpty()) {
                existing.setName(name);
                customerRepo.save(existing);
            }
        }
    }

    public TrouserSize saveTrouser(TrouserSize t) {
        ensureCustomerExists(t.getCustomerPhoneNumber(), t.getName());
        return trouserRepo.save(t);
    }

    public SherwaniSize saveSherwani(SherwaniSize s) {
        ensureCustomerExists(s.getCustomerPhoneNumber(), s.getName());
        return sherwaniRepo.save(s);
    }

    public ShirtSize saveShirt(ShirtSize s) {
        ensureCustomerExists(s.getCustomerPhoneNumber(), s.getName());
        return shirtRepo.save(s);
    }

    public CoatSize saveCoat(CoatSize s) {
        ensureCustomerExists(s.getCustomerPhoneNumber(), s.getName());
        return coatRepo.save(s);
    }

    public WaistcoatSize saveWaistcoat(WaistcoatSize s) {
        ensureCustomerExists(s.getCustomerPhoneNumber(), s.getName());
        return waistRepo.save(s);
    }

    public KurtaSize saveKurta(KurtaSize s) {
        ensureCustomerExists(s.getCustomerPhoneNumber(), s.getName());
        return kurtaRepo.save(s);
    }

    public TrouserSize getTrouserByPhone(String phone) {
        return trouserRepo.findByCustomerPhoneNumber(phone);
    }

    public SherwaniSize getSherwaniByPhone(String phone) {
        return sherwaniRepo.findByCustomerPhoneNumber(phone);
    }

    public ShirtSize getShirtByPhone(String phone) {
        return shirtRepo.findByCustomerPhoneNumber(phone);
    }

    public CoatSize getCoatByPhone(String phone) {
        return coatRepo.findByCustomerPhoneNumber(phone);
    }

    public WaistcoatSize getWaistcoatByPhone(String phone) {
        return waistRepo.findByCustomerPhoneNumber(phone);
    }

    public KurtaSize getKurtaByPhone(String phone) {
        return kurtaRepo.findByCustomerPhoneNumber(phone);
    }

    // ✅ Update logic
    public void updateTrouser(TrouserSize t) {
        ensureCustomerExists(t.getCustomerPhoneNumber(), "Trouser");
        TrouserSize existing = trouserRepo.findByCustomerPhoneNumber(t.getCustomerPhoneNumber());
        if (existing != null) {
            t.setId(existing.getId());
        }
        trouserRepo.save(t);
    }

    public void updateSherwani(SherwaniSize s) {
        ensureCustomerExists(s.getCustomerPhoneNumber(), "Sherwani");
        SherwaniSize existing = sherwaniRepo.findByCustomerPhoneNumber(s.getCustomerPhoneNumber());
        if (existing != null) s.setId(existing.getId());
        sherwaniRepo.save(s);
    }

    public void updateShirt(ShirtSize s) {
        ensureCustomerExists(s.getCustomerPhoneNumber(), "Shirt");
        ShirtSize existing = shirtRepo.findByCustomerPhoneNumber(s.getCustomerPhoneNumber());
        if (existing != null) s.setId(existing.getId());
        shirtRepo.save(s);
    }

    public void updateCoat(CoatSize s) {
        ensureCustomerExists(s.getCustomerPhoneNumber(), "Coat");
        CoatSize existing = coatRepo.findByCustomerPhoneNumber(s.getCustomerPhoneNumber());
        if (existing != null) s.setId(existing.getId());
        coatRepo.save(s);
    }

    public void updateWaistcoat(WaistcoatSize s) {
        ensureCustomerExists(s.getCustomerPhoneNumber(), "Waistcoat");
        WaistcoatSize existing = waistRepo.findByCustomerPhoneNumber(s.getCustomerPhoneNumber());
        if (existing != null) s.setId(existing.getId());
        waistRepo.save(s);
    }

    public void updateKurta(KurtaSize s) {
        ensureCustomerExists(s.getCustomerPhoneNumber(), "Kurta");
        KurtaSize existing = kurtaRepo.findByCustomerPhoneNumber(s.getCustomerPhoneNumber());
        if (existing != null) s.setId(existing.getId());
        kurtaRepo.save(s);
    }
}