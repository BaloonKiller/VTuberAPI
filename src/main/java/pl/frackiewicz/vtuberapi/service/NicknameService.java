package pl.frackiewicz.vtuberapi.service;

import pl.frackiewicz.vtuberapi.entity.Nickname;

import java.util.List;
import java.util.Optional;

public interface NicknameService {

    List<Nickname> getAll();

    Optional<Nickname> get(String nickname);

    void save(Nickname nickname);
}
