package pl.frackiewicz.vtuberapi.service;

import pl.frackiewicz.vtuberapi.entity.SocialMediaHashtag;

import java.util.List;
import java.util.Optional;

public interface SocialMediaHashtagService {
    List<SocialMediaHashtag> getAll();

    Optional<SocialMediaHashtag> get(String socialMediaHashtag);

    void save(SocialMediaHashtag socialMediaHashtag);
}
