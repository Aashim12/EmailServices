package com.example.instaSearch.service;


import com.example.instaSearch.dto.ProfileDTO;
import com.example.instaSearch.entity.Profile;
import com.example.instaSearch.repository.ProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProfileService {


    @Autowired
    private ProfileRepo profileRepo;


    public void saveProfile(ProfileDTO profileDTO){
        Profile profile = new Profile();
        profile.setUserId(profileDTO.getUserId());
        profile.setUserName(profileDTO.getUserName());
        profile.setName(profileDTO.getName());
        profile.setBio(profileDTO.getBio());

        profileRepo.save(profile);
    }

    public List<ProfileDTO> display(){
        Iterable<Profile> profile = profileRepo.findAll();
        List<ProfileDTO> profileDTOS =  new ArrayList<>();
        profile.forEach(profilee -> {
            ProfileDTO profileDTO = ProfileDTO.builder().
                    userId(profilee.getUserId()).
                    userName(profilee.getUserName()).
                    name(profilee.getName()).
                    bio(profilee.getBio()).build();
            profileDTOS.add(profileDTO);

        });
        return profileDTOS;
    }


    public List<Profile> findByName(String text){
        String searchText = "";
        for(int i=0;i<text.length();i++){
            searchText += text.charAt(i) + "*";
        }
        return profileRepo.findByName(searchText);

    }

}
