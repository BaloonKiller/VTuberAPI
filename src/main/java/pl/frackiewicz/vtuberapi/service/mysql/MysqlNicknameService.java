package pl.frackiewicz.vtuberapi.service.mysql;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.frackiewicz.vtuberapi.entity.Nickname;
import pl.frackiewicz.vtuberapi.repository.NicknameRepository;
import pl.frackiewicz.vtuberapi.service.NicknameService;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

@Component
public class MysqlNicknameService implements NicknameService {
    private final NicknameRepository nicknameRepository;
    private final Validator validator;
    private static final Logger logger = LogManager.getLogger(MysqlNicknameService.class);

    @Autowired
    public MysqlNicknameService(NicknameRepository nicknameRepository, Validator validator) {
        this.nicknameRepository = nicknameRepository;
        this.validator = validator;
    }

    @Override
    public List<Nickname> getAll() {
        return nicknameRepository.findAll();
    }

    @Override
    public Nickname get(String nickname) throws NoSuchElementException {
        return nicknameRepository.findById(nickname).orElseThrow();
    }

    @Override
    public void save(Nickname nickname) {
        Set<ConstraintViolation<Nickname>> violations = validator.validate(nickname);
        if (!violations.isEmpty()) {
            for (ConstraintViolation<Nickname> constraintViolation : violations) {
                logger.debug(constraintViolation.getPropertyPath() + " "
                        + constraintViolation.getMessage()); }
        } else {
            nicknameRepository.save(nickname);
        }
    }

    @Override
    public void delete(Nickname nickname) {
        nicknameRepository.delete(nickname);
    }
}
