package com.raanjhana.controller;

import com.raanjhana.model.*;
import com.raanjhana.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sizes")
public class SizeController {

    @Autowired
    private SizeService sizeService;

    // ---------- Trouser ---------- //

    @PostMapping("/trouser/add")
    public String addTrouser(@RequestBody TrouserSize t) {
        // MongoDB save() handles both insert and initial field setting
        sizeService.saveTrouser(t);
        return "Trouser size saved";
    }

    @PutMapping("/trouser/update")
    public String updateTrouser(@RequestBody TrouserSize t) {
        // Uses the service logic that finds by customerPhoneNumber and sets the ID
        sizeService.updateTrouser(t);
        return "Trouser size updated";
    }

    @GetMapping("/trouser/{phone}")
    public TrouserSize getTrouser(@PathVariable String phone) {
        return sizeService.getTrouserByPhone(phone);
    }

    // ---------- Sherwani ---------- //

    @PostMapping("/sherwani/add")
    public String addSherwani(@RequestBody SherwaniSize s) {
        sizeService.saveSherwani(s);
        return "Sherwani size saved";
    }

    @PutMapping("/sherwani/update")
    public String updateSherwani(@RequestBody SherwaniSize s) {
        sizeService.updateSherwani(s);
        return "Sherwani size updated";
    }

    @GetMapping("/sherwani/{phone}")
    public SherwaniSize getSherwani(@PathVariable String phone) {
        return sizeService.getSherwaniByPhone(phone);
    }

    // ---------- Shirt ---------- //

    @PostMapping("/shirt/add")
    public String addShirt(@RequestBody ShirtSize s) {
        sizeService.saveShirt(s);
        return "Shirt size saved";
    }

    @PutMapping("/shirt/update")
    public String updateShirt(@RequestBody ShirtSize s) {
        sizeService.updateShirt(s);
        return "Shirt size updated";
    }

    @GetMapping("/shirt/{phone}")
    public ShirtSize getShirt(@PathVariable String phone) {
        return sizeService.getShirtByPhone(phone);
    }

    // ---------- Coat ---------- //

    @PostMapping("/coat/add")
    public String addCoat(@RequestBody CoatSize s) {
        sizeService.saveCoat(s);
        return "Coat size saved";
    }

    @PutMapping("/coat/update")
    public String updateCoat(@RequestBody CoatSize s) {
        sizeService.updateCoat(s);
        return "Coat size updated";
    }

    @GetMapping("/coat/{phone}")
    public CoatSize getCoat(@PathVariable String phone) {
        return sizeService.getCoatByPhone(phone);
    }

    // ---------- Waistcoat ---------- //

    @PostMapping("/waistcoat/add")
    public String addWaistcoat(@RequestBody WaistcoatSize s) {
        sizeService.saveWaistcoat(s);
        return "Waistcoat size saved";
    }

    @PutMapping("/waistcoat/update")
    public String updateWaistcoat(@RequestBody WaistcoatSize s) {
        sizeService.updateWaistcoat(s);
        return "Waistcoat size updated";
    }

    @GetMapping("/waistcoat/{phone}")
    public WaistcoatSize getWaistcoat(@PathVariable String phone) {
        return sizeService.getWaistcoatByPhone(phone);
    }

    // ---------- Kurta ---------- //

    @PostMapping("/kurta/add")
    public String addKurta(@RequestBody KurtaSize s) {
        sizeService.saveKurta(s);
        return "Kurta size saved";
    }

    @PutMapping("/kurta/update")
    public String updateKurta(@RequestBody KurtaSize s) {
        sizeService.updateKurta(s);
        return "Kurta size updated";
    }

    @GetMapping("/kurta/{phone}")
    public KurtaSize getKurta(@PathVariable String phone) {
        return sizeService.getKurtaByPhone(phone);
    }
}