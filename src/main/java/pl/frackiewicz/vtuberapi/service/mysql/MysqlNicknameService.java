package pl.frackiewicz.vtuberapi.service.mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.frackiewicz.vtuberapi.entity.Nickname;
import pl.frackiewicz.vtuberapi.repository.NicknameRepository;
import pl.frackiewicz.vtuberapi.service.NicknameService;

import javax.validation.Validator;
import java.util.List;
import java.util.Optional;

@Component
public class MysqlNicknameService implements NicknameService {
    private NicknameRepository nicknameRepository;
    private Validator validator;

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
    public Optional<Nickname> get(String nickname) {
        return nicknameRepository.findById(nickname);
    }

    @Override
    public void save(Nickname nickname) {
        nicknameRepository.save(nickname);
    }

    @Override
    public void delete(Nickname nickname) {
        nicknameRepository.delete(nickname);
    }
}
