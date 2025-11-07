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

    // ✅ Add or update (save handles both)
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

    // ✅ Get size by Customer Phone Number
    public TrouserSize getTrouserByPhone(String phone) {
        return trouserRepo.findByCustomer_PhoneNumber(phone);
    }

    public SherwaniSize getSherwaniByPhone(String phone) {
        return sherwaniRepo.findByCustomer_PhoneNumber(phone);
    }

    public ShirtSize getShirtByPhone(String phone) {
        return shirtRepo.findByCustomer_PhoneNumber(phone);
    }

    public CoatSize getCoatByPhone(String phone) {
        return coatRepo.findByCustomer_PhoneNumber(phone);
    }

    public WaistcoatSize getWaistcoatByPhone(String phone) {
        return waistRepo.findByCustomer_PhoneNumber(phone);
    }

    public KurtaSize getKurtaByPhone(String phone) {
        return kurtaRepo.findByCustomer_PhoneNumber(phone);
    }

    public void updateTrouser(TrouserSize t) {
    TrouserSize existing = trouserRepo.findByCustomer_PhoneNumber(t.getCustomer().getPhoneNumber());
    if (existing != null) {
        t.setId(existing.getId());
    }
    trouserRepo.save(t);
}

public void updateSherwani(SherwaniSize s) {
    SherwaniSize existing = sherwaniRepo.findByCustomer_PhoneNumber(s.getCustomer().getPhoneNumber());
    if (existing != null) s.setId(existing.getId());
    sherwaniRepo.save(s);
}

public void updateShirt(ShirtSize s) {
    ShirtSize existing = shirtRepo.findByCustomer_PhoneNumber(s.getCustomer().getPhoneNumber());
    if (existing != null) s.setId(existing.getId());
    shirtRepo.save(s);
}

public void updateCoat(CoatSize s) {
    CoatSize existing = coatRepo.findByCustomer_PhoneNumber(s.getCustomer().getPhoneNumber());
    if (existing != null) s.setId(existing.getId());
    coatRepo.save(s);
}

public void updateWaistcoat(WaistcoatSize s) {
    WaistcoatSize existing = waistRepo.findByCustomer_PhoneNumber(s.getCustomer().getPhoneNumber());
    if (existing != null) s.setId(existing.getId());
    waistRepo.save(s);
}

public void updateKurta(KurtaSize s) {
    KurtaSize existing = kurtaRepo.findByCustomer_PhoneNumber(s.getCustomer().getPhoneNumber());
    if (existing != null) s.setId(existing.getId());
    kurtaRepo.save(s);
}

}
