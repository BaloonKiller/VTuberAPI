package pl.frackiewicz.vtuberapi.service.mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.frackiewicz.vtuberapi.repository.GenerationRepository;
import pl.frackiewicz.vtuberapi.service.GenerationService;

@Component
public class MysqlGenerationService implements GenerationService {
    private GenerationRepository generationRepository;

    @Autowired
    public MysqlGenerationService(GenerationRepository generationRepository) {
        this.generationRepository = generationRepository;
    }
}
