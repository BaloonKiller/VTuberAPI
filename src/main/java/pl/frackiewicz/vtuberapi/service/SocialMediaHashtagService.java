package pl.frackiewicz.vtuberapi.service;

import pl.frackiewicz.vtuberapi.entity.SocialMediaHashtag;

import java.util.List;
import java.util.NoSuchElementException;

public interface SocialMediaHashtagService {
    List<SocialMediaHashtag> getAll();

    SocialMediaHashtag get(String socialMediaHashtag) throws NoSuchElementException;

    void save(SocialMediaHashtag socialMediaHashtag);

    void delete(SocialMediaHashtag socialMediaHashtag) throws NoSuchElementException;
}
