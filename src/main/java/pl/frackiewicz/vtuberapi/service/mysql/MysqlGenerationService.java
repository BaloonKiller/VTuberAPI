package pl.frackiewicz.vtuberapi.service.mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.frackiewicz.vtuberapi.entity.Generation;
import pl.frackiewicz.vtuberapi.repository.GenerationRepository;
import pl.frackiewicz.vtuberapi.service.GenerationService;

import javax.validation.Validator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class MysqlGenerationService implements GenerationService {
    private GenerationRepository generationRepository;
    private Validator validator;

    @Autowired
    public MysqlGenerationService(GenerationRepository generationRepository, Validator validator) {
        this.generationRepository = generationRepository;
        this.validator = validator;
    }

    @Override
    public List<Generation> getAll() {
        return generationRepository.findAll();
    }

    @Override
    public Optional<Generation> get(UUID id) {
        return generationRepository.findById(id);
    }

    @Override
    public void save(Generation generation) {
        generationRepository.save(generation);
    }

    @Override
    public void delete(Generation generation) {
        generationRepository.delete(generation);
    }
}
