package pl.frackiewicz.vtuberapi.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.frackiewicz.vtuberapi.entity.SocialMediaHashtag;

@Repository
public interface SocialMediaHashtagRepository extends JpaRepository<SocialMediaHashtag, String> {
}
