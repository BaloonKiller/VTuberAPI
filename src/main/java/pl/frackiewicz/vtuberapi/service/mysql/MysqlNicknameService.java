package pl.frackiewicz.vtuberapi.service.mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.frackiewicz.vtuberapi.entity.Nickname;
import pl.frackiewicz.vtuberapi.repository.NicknameRepository;
import pl.frackiewicz.vtuberapi.service.NicknameService;

import java.util.List;
import java.util.Optional;

@Component
public class MysqlNicknameService implements NicknameService {
    private NicknameRepository nicknameRepository;

    @Autowired
    public MysqlNicknameService(NicknameRepository nicknameRepository) {
        this.nicknameRepository = nicknameRepository;
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
