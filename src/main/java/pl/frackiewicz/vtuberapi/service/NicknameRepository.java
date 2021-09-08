package pl.frackiewicz.vtuberapi.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.frackiewicz.vtuberapi.entity.Nickname;

@Repository
public interface NicknameRepository extends JpaRepository<Nickname, String> {
}
