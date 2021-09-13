package pl.frackiewicz.vtuberapi.service.mysql;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.frackiewicz.vtuberapi.entity.Branch;
import pl.frackiewicz.vtuberapi.entity.SocialMediaHashtag;
import pl.frackiewicz.vtuberapi.repository.SocialMediaHashtagRepository;
import pl.frackiewicz.vtuberapi.service.SocialMediaHashtagService;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Component
public class MysqlSocialMediaHashtagService implements SocialMediaHashtagService {
    private SocialMediaHashtagRepository socialMediaHashtagRepository;
    private Validator validator;
    private static final Logger logger = LogManager.getLogger(MysqlSocialMediaHashtagService.class);

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
        Set<ConstraintViolation<SocialMediaHashtag>> violations = validator.validate(socialMediaHashtag);
        if (!violations.isEmpty()) {
            for (ConstraintViolation<SocialMediaHashtag> constraintViolation : violations) {
                logger.debug(constraintViolation.getPropertyPath() + " "
                        + constraintViolation.getMessage()); }
        } else {
            socialMediaHashtagRepository.save(socialMediaHashtag);
        }

    }

    @Override
    public void delete(SocialMediaHashtag socialMediaHashtag) {
        socialMediaHashtagRepository.delete(socialMediaHashtag);
    }
}
