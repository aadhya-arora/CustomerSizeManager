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
    private WaistCoatRepository waistRepo;

    @Autowired
    private KurtaRepository kurtaRepo;

    public int addOrUpdateTrouser(TrouserSize t) {
        TrouserSize existing = trouserRepo.findByPhone(t.getPhoneNumber());
        if (existing == null) return trouserRepo.save(t);
        else return trouserRepo.update(t);
    }

    public TrouserSize getTrouser(String phone) {
        return trouserRepo.findByPhone(phone);
    }


    public int addOrUpdateSherwani(SherwaniSize s) {
        SherwaniSize existing = sherwaniRepo.findByPhone(s.getPhoneNumber());
        if (existing == null) return sherwaniRepo.save(s);
        else return sherwaniRepo.update(s);
    }

    public SherwaniSize getSherwani(String phone) {
        return sherwaniRepo.findByPhone(phone);
    }

    public int addOrUpdateShirt(ShirtSize s) {
        ShirtSize existing = shirtRepo.findByPhone(s.getPhoneNumber());
        if (existing == null) return shirtRepo.save(s);
        else return shirtRepo.update(s);
    }

    public ShirtSize getShirt(String phone) {
        return shirtRepo.findByPhone(phone);
    }

    public int addOrUpdateCoat(CoatSize s) {
        CoatSize existing = coatRepo.findByPhone(s.getPhoneNumber());
        if (existing == null) return coatRepo.save(s);
        else return coatRepo.update(s);
    }

    public CoatSize getCoat(String phone) {
        return coatRepo.findByPhone(phone);
    }

    public int addOrUpdateWaistcoat(WaistCoatSize s) {
        WaistCoatSize existing = waistRepo.findByPhone(s.getPhoneNumber());
        if (existing == null) return waistRepo.save(s);
        else return waistRepo.update(s);
    }

    public WaistCoatSize getWaistcoat(String phone) {
        return waistRepo.findByPhone(phone);
    }

    public int addOrUpdateKurta(KurtaSize s) {
        KurtaSize existing = kurtaRepo.findByPhone(s.getPhoneNumber());
        if (existing == null) return kurtaRepo.save(s);
        else return kurtaRepo.update(s);
    }

    public KurtaSize getKurta(String phone) {
        return kurtaRepo.findByPhone(phone);
    }
}
