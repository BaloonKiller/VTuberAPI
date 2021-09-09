package pl.frackiewicz.vtuberapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.frackiewicz.vtuberapi.entity.VTuber;
import pl.frackiewicz.vtuberapi.service.VTuberService;

import java.util.List;

@RestController
@RequestMapping("/vtubers")
public class VTuberController {
    private VTuberService vTuberService;

    public VTuberController(VTuberService vTuberService) {
        this.vTuberService = vTuberService;
    }

    @GetMapping("")
    public List<VTuber> getAllVTubers() {
        return vTuberService.getAll();
    }
}
