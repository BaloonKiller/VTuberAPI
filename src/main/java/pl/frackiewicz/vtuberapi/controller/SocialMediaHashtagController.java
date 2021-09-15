package pl.frackiewicz.vtuberapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.frackiewicz.vtuberapi.entity.Nickname;
import pl.frackiewicz.vtuberapi.entity.SocialMediaHashtag;
import pl.frackiewicz.vtuberapi.service.SocialMediaHashtagService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/hashtags")
public class SocialMediaHashtagController {
    private SocialMediaHashtagService socialMediaHashtagService;

    public SocialMediaHashtagController(SocialMediaHashtagService socialMediaHashtagService) {
        this.socialMediaHashtagService = socialMediaHashtagService;
    }

    @GetMapping
    public List<SocialMediaHashtag> getList() {
        return socialMediaHashtagService.getAll();
    }

    @PostMapping("")
    public void addSocialMediaHashtag(@RequestBody SocialMediaHashtag socialMediaHashtag) {
        socialMediaHashtagService.save(socialMediaHashtag);
    }

    @GetMapping("/{hashtag}")
    public SocialMediaHashtag getSocialMediaHashtag(@PathVariable String hashtag) {
        try {
            return socialMediaHashtagService.get(hashtag);
        } catch (NoSuchElementException noSuchElementException) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");
        }
    }

    @DeleteMapping("/{hashtag}")
    public void removeSocialMediaHashtag(@PathVariable String hashtag) {
        try {
            socialMediaHashtagService.delete(socialMediaHashtagService.get(hashtag));
        } catch (NoSuchElementException noSuchElementException) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");
        }
    }

    @PutMapping("")
    public void updateSocialMediaHashtag(@RequestBody SocialMediaHashtag socialMediaHashtag) {
        socialMediaHashtagService.save(socialMediaHashtag);
    }
}
