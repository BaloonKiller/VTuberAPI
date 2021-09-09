package pl.frackiewicz.vtuberapi.service.mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.frackiewicz.vtuberapi.entity.SocialMediaHashtag;
import pl.frackiewicz.vtuberapi.repository.SocialMediaHashtagRepository;
import pl.frackiewicz.vtuberapi.service.SocialMediaHashtagService;

import java.util.List;
import java.util.Optional;

@Component
public class MysqlSocialMediaHashtagService implements SocialMediaHashtagService {
    private SocialMediaHashtagRepository socialMediaHashtagRepository;

    @Autowired
    public MysqlSocialMediaHashtagService(SocialMediaHashtagRepository socialMediaHashtagRepository) {
        this.socialMediaHashtagRepository = socialMediaHashtagRepository;
    }

    @Override
    public List<SocialMediaHashtag> getAll() {
        return socialMediaHashtagRepository.findAll();
    }

    @Override
    public Optional<SocialMediaHashtag> get(String socialMediaHashtag) {
        return socialMediaHashtagRepository.findById(socialMediaHashtag);
    }
}
