package pl.frackiewicz.vtuberapi.service.mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.frackiewicz.vtuberapi.entity.VTuber;
import pl.frackiewicz.vtuberapi.repository.VTuberRepository;
import pl.frackiewicz.vtuberapi.service.VTuberService;

import javax.validation.Validator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class MysqlVTuberService implements VTuberService {
    private VTuberRepository vTuberRepository;
    private Validator validator;

    @Autowired
    public MysqlVTuberService(VTuberRepository vTuberRepository, Validator validator) {
        this.vTuberRepository = vTuberRepository;
        this.validator = validator;
    }

    @Override
    public List<VTuber> getAll() {
        return vTuberRepository.findAll();
    }

    @Override
    public Optional<VTuber> get(UUID id) {
        return vTuberRepository.findById(id);
    }

    @Override
    public void save(VTuber vTuber) {
        vTuberRepository.save(vTuber);
    }

    @Override
    public void delete(VTuber vTuber) {
        vTuberRepository.delete(vTuber);
    }
}
