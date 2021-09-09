package pl.frackiewicz.vtuberapi.service.mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.frackiewicz.vtuberapi.entity.VTuber;
import pl.frackiewicz.vtuberapi.repository.VTuberRepository;
import pl.frackiewicz.vtuberapi.service.VTuberService;

import java.util.List;

@Component
public class MysqlVTuberService implements VTuberService {
    private VTuberRepository vTuberRepository;

    @Autowired
    public MysqlVTuberService(VTuberRepository vTuberRepository) {
        this.vTuberRepository = vTuberRepository;
    }

    @Override
    public List<VTuber> getAll() {
        return vTuberRepository.findAll();
    }
}
