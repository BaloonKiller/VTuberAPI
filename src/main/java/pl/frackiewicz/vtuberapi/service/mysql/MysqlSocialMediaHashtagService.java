package pl.frackiewicz.vtuberapi.service.mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.frackiewicz.vtuberapi.entity.SocialMediaHashtag;
import pl.frackiewicz.vtuberapi.repository.SocialMediaHashtagRepository;
import pl.frackiewicz.vtuberapi.service.SocialMediaHashtagService;

import javax.validation.Validator;
import java.util.List;
import java.util.Optional;

@Component
public class MysqlSocialMediaHashtagService implements SocialMediaHashtagService {
    private SocialMediaHashtagRepository socialMediaHashtagRepository;
    private Validator validator;

    @Autowired
    public MysqlSocialMediaHashtagService(SocialMediaHashtagRepository socialMediaHashtagRepository, Validator validator) {
        this.socialMediaHashtagRepository = socialMediaHashtagRepository;
        this.validator = validator;
    }

    @Override
    public List<SocialMediaHashtag> getAll() {
        return socialMediaHashtagRepository.findAll();
    }

    @Override
    public Optional<SocialMediaHashtag> get(String socialMediaHashtag) {
        return socialMediaHashtagRepository.findById(socialMediaHashtag);
    }

    @Override
    public void save(SocialMediaHashtag socialMediaHashtag) {
        socialMediaHashtagRepository.save(socialMediaHashtag);
    }

    @Override
    public void delete(SocialMediaHashtag socialMediaHashtag) {
        socialMediaHashtagRepository.delete(socialMediaHashtag);
    }
}
