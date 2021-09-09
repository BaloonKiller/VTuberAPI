package pl.frackiewicz.vtuberapi.service;

import pl.frackiewicz.vtuberapi.entity.VTuber;

import java.util.List;

public interface VTuberService {
    List<VTuber> getAll();
}
