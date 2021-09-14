package pl.frackiewicz.vtuberapi.service;

import pl.frackiewicz.vtuberapi.entity.Nickname;

import java.util.List;
import java.util.NoSuchElementException;

public interface NicknameService {

    List<Nickname> getAll();

    Nickname get(String nickname) throws NoSuchElementException;

    void save(Nickname nickname);

    void delete(Nickname nickname) throws NoSuchElementException;
}
