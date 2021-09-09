package pl.frackiewicz.vtuberapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.frackiewicz.vtuberapi.service.SocialMediaHashtagService;

@RestController
@RequestMapping("/hashtags")
public class SocialMediaHashtagController {
    private SocialMediaHashtagService socialMediaHashtagService;

    public SocialMediaHashtagController(SocialMediaHashtagService socialMediaHashtagService) {
        this.socialMediaHashtagService = socialMediaHashtagService;
    }
}
