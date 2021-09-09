package pl.frackiewicz.vtuberapi.service.mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.frackiewicz.vtuberapi.repository.SocialMediaHashtagRepository;
import pl.frackiewicz.vtuberapi.service.SocialMediaHashtagService;

@Component
public class MysqlSocialMediaHashtagService implements SocialMediaHashtagService {
    private SocialMediaHashtagRepository socialMediaHashtagRepository;

    @Autowired
    public MysqlSocialMediaHashtagService(SocialMediaHashtagRepository socialMediaHashtagRepository) {
        this.socialMediaHashtagRepository = socialMediaHashtagRepository;
    }
}
