package com.raanjhana.service;

import com.raanjhana.model.*;
import com.raanjhana.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    // ✅ Save methods (Works for both Insert and Update in MongoDB)
    public TrouserSize saveTrouser(TrouserSize t) {
        return trouserRepo.save(t);
    }

    public SherwaniSize saveSherwani(SherwaniSize s) {
        return sherwaniRepo.save(s);
    }

    public ShirtSize saveShirt(ShirtSize s) {
        return shirtRepo.save(s);
    }

    public CoatSize saveCoat(CoatSize s) {
        return coatRepo.save(s);
    }

    public WaistcoatSize saveWaistcoat(WaistcoatSize s) {
        return waistRepo.save(s);
    }

    public KurtaSize saveKurta(KurtaSize s) {
        return kurtaRepo.save(s);
    }

    // ✅ Get methods - Updated to match the new field name 'customerPhoneNumber'
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

    // ✅ Update logic - Uses String IDs and matches MongoDB field naming
    public void updateTrouser(TrouserSize t) {
        TrouserSize existing = trouserRepo.findByCustomerPhoneNumber(t.getCustomerPhoneNumber());
        if (existing != null) {
            t.setId(existing.getId()); // existing.getId() is now a String
        }
        trouserRepo.save(t);
    }

    public void updateSherwani(SherwaniSize s) {
        SherwaniSize existing = sherwaniRepo.findByCustomerPhoneNumber(s.getCustomerPhoneNumber());
        if (existing != null) s.setId(existing.getId());
        sherwaniRepo.save(s);
    }

    public void updateShirt(ShirtSize s) {
        ShirtSize existing = shirtRepo.findByCustomerPhoneNumber(s.getCustomerPhoneNumber());
        if (existing != null) s.setId(existing.getId());
        shirtRepo.save(s);
    }

    public void updateCoat(CoatSize s) {
        CoatSize existing = coatRepo.findByCustomerPhoneNumber(s.getCustomerPhoneNumber());
        if (existing != null) s.setId(existing.getId());
        coatRepo.save(s);
    }

    public void updateWaistcoat(WaistcoatSize s) {
        WaistcoatSize existing = waistRepo.findByCustomerPhoneNumber(s.getCustomerPhoneNumber());
        if (existing != null) s.setId(existing.getId());
        waistRepo.save(s);
    }

    public void updateKurta(KurtaSize s) {
        KurtaSize existing = kurtaRepo.findByCustomerPhoneNumber(s.getCustomerPhoneNumber());
        if (existing != null) s.setId(existing.getId());
        kurtaRepo.save(s);
    }
}