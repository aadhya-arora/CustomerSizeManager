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

    @Autowired
    private CustomerRepository customerRepo;
    
    private void ensureCustomerExists(String phoneNumber, String name) {
        if (phoneNumber == null || phoneNumber.trim().isEmpty()) return;

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

    // ---------------- SAVE ---------------- //

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

    // ---------------- GET ---------------- //

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

    // ---------------- UPDATE (PARTIAL UPDATE FIXED) ---------------- //

    public void updateTrouser(TrouserSize t) {
        ensureCustomerExists(t.getCustomerPhoneNumber(), t.getName());

        TrouserSize existing = trouserRepo.findByCustomerPhoneNumber(t.getCustomerPhoneNumber());

        if (existing != null) {
            if (t.getLength() != null) existing.setLength(t.getLength());
            if (t.getWaist() != null) existing.setWaist(t.getWaist());
            if (t.getIl() != null) existing.setIl(t.getIl());
            if (t.getHips() != null) existing.setHips(t.getHips());
            if (t.getThigh() != null) existing.setThigh(t.getThigh());
            if (t.getR() != null) existing.setR(t.getR());
            if (t.getKnee() != null) existing.setKnee(t.getKnee());
            if (t.getCalf() != null) existing.setCalf(t.getCalf());
            if (t.getBottom() != null) existing.setBottom(t.getBottom());
            if (t.getPleats() != null) existing.setPleats(t.getPleats());
            if (t.getName() != null) existing.setName(t.getName());

            trouserRepo.save(existing);
        }
    }

    public void updateSherwani(SherwaniSize s) {
        ensureCustomerExists(s.getCustomerPhoneNumber(), s.getName());

        SherwaniSize existing = sherwaniRepo.findByCustomerPhoneNumber(s.getCustomerPhoneNumber());

        if (existing != null) {
            if (s.getLength() != null) existing.setLength(s.getLength());
            if (s.getChest() != null) existing.setChest(s.getChest());
            if (s.getGap() != null) existing.setGap(s.getGap());
            if (s.getWaist() != null) existing.setWaist(s.getWaist());
            if (s.getHips() != null) existing.setHips(s.getHips());
            if (s.getShoulder() != null) existing.setShoulder(s.getShoulder());
            if (s.getSleeve() != null) existing.setSleeve(s.getSleeve());
            if (s.getBicep() != null) existing.setBicep(s.getBicep());
            if (s.getElbow() != null) existing.setElbow(s.getElbow());
            if (s.getCuff() != null) existing.setCuff(s.getCuff());
            if (s.getCb() != null) existing.setCb(s.getCb());
            if (s.getNeck() != null) existing.setNeck(s.getNeck());
            if (s.getName() != null) existing.setName(s.getName());

            sherwaniRepo.save(existing);
        }
    }

    public void updateShirt(ShirtSize s) {
        ensureCustomerExists(s.getCustomerPhoneNumber(), s.getName());

        ShirtSize existing = shirtRepo.findByCustomerPhoneNumber(s.getCustomerPhoneNumber());

        if (existing != null) {
            if (s.getLength() != null) existing.setLength(s.getLength());
            if (s.getChest() != null) existing.setChest(s.getChest());
            if (s.getGap() != null) existing.setGap(s.getGap());
            if (s.getWaist() != null) existing.setWaist(s.getWaist());
            if (s.getHips() != null) existing.setHips(s.getHips());
            if (s.getShoulder() != null) existing.setShoulder(s.getShoulder());
            if (s.getSleeve() != null) existing.setSleeve(s.getSleeve());
            if (s.getBicep() != null) existing.setBicep(s.getBicep());
            if (s.getElbow() != null) existing.setElbow(s.getElbow());
            if (s.getCuff() != null) existing.setCuff(s.getCuff());
            if (s.getCb() != null) existing.setCb(s.getCb());
            if (s.getNeck() != null) existing.setNeck(s.getNeck());
            if (s.getName() != null) existing.setName(s.getName());

            shirtRepo.save(existing);
        }
    }

    public void updateCoat(CoatSize s) {
        ensureCustomerExists(s.getCustomerPhoneNumber(), s.getName());

        CoatSize existing = coatRepo.findByCustomerPhoneNumber(s.getCustomerPhoneNumber());

        if (existing != null) {
            if (s.getLength() != null) existing.setLength(s.getLength());
            if (s.getChest() != null) existing.setChest(s.getChest());
            if (s.getGap() != null) existing.setGap(s.getGap());
            if (s.getWaist() != null) existing.setWaist(s.getWaist());
            if (s.getHips() != null) existing.setHips(s.getHips());
            if (s.getShoulder() != null) existing.setShoulder(s.getShoulder());
            if (s.getSleeve() != null) existing.setSleeve(s.getSleeve());
            if (s.getBicep() != null) existing.setBicep(s.getBicep());
            if (s.getElbow() != null) existing.setElbow(s.getElbow());
            if (s.getCuff() != null) existing.setCuff(s.getCuff());
            if (s.getCb() != null) existing.setCb(s.getCb());
            if (s.getNeck() != null) existing.setNeck(s.getNeck());
            if (s.getName() != null) existing.setName(s.getName());

            coatRepo.save(existing);
        }
    }

    public void updateWaistcoat(WaistcoatSize s) {
        ensureCustomerExists(s.getCustomerPhoneNumber(), s.getName());

        WaistcoatSize existing = waistRepo.findByCustomerPhoneNumber(s.getCustomerPhoneNumber());

        if (existing != null) {
            if (s.getLength() != null) existing.setLength(s.getLength());
            if (s.getChest() != null) existing.setChest(s.getChest());
            if (s.getGap() != null) existing.setGap(s.getGap());
            if (s.getWaist() != null) existing.setWaist(s.getWaist());
            if (s.getHips() != null) existing.setHips(s.getHips());
            if (s.getShoulder() != null) existing.setShoulder(s.getShoulder());
            if (s.getNeck() != null) existing.setNeck(s.getNeck());
            if (s.getName() != null) existing.setName(s.getName());

            waistRepo.save(existing);
        }
    }

    public void updateKurta(KurtaSize s) {
        ensureCustomerExists(s.getCustomerPhoneNumber(), s.getName());

        KurtaSize existing = kurtaRepo.findByCustomerPhoneNumber(s.getCustomerPhoneNumber());

        if (existing != null) {
            if (s.getLength() != null) existing.setLength(s.getLength());
            if (s.getChest() != null) existing.setChest(s.getChest());
            if (s.getGap() != null) existing.setGap(s.getGap());
            if (s.getWaist() != null) existing.setWaist(s.getWaist());
            if (s.getHips() != null) existing.setHips(s.getHips());
            if (s.getShoulder() != null) existing.setShoulder(s.getShoulder());
            if (s.getSleeve() != null) existing.setSleeve(s.getSleeve());
            if (s.getBicep() != null) existing.setBicep(s.getBicep());
            if (s.getElbow() != null) existing.setElbow(s.getElbow());
            if (s.getCuff() != null) existing.setCuff(s.getCuff());
            if (s.getCb() != null) existing.setCb(s.getCb());
            if (s.getNeck() != null) existing.setNeck(s.getNeck());
            if (s.getName() != null) existing.setName(s.getName());

            kurtaRepo.save(existing);
        }
    }
}