package com.example.instaSearch.controller;


import com.example.instaSearch.dto.ProfileDTO;
import com.example.instaSearch.entity.Profile;
import com.example.instaSearch.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/insta")
public class ProfileController {

    @Autowired
    private ProfileService profileService ;

    @GetMapping
    public List<ProfileDTO> getAllProducts() {
        return profileService.display();
    }

    @PostMapping("/addprofile")
    public void saveProduct(@RequestBody ProfileDTO profileDTO) {
        profileService.saveProfile(profileDTO);
    }

    @GetMapping("/search")
    public List<Profile> findProductsByNameAndSort(@RequestParam String text) {
        return profileService.findByName(text);
    }


}
