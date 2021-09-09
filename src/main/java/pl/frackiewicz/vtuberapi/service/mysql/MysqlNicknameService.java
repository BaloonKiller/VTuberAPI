package pl.frackiewicz.vtuberapi.service.mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.frackiewicz.vtuberapi.entity.Nickname;
import pl.frackiewicz.vtuberapi.repository.NicknameRepository;
import pl.frackiewicz.vtuberapi.service.NicknameService;

import java.util.List;

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
}
