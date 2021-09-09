package pl.frackiewicz.vtuberapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.frackiewicz.vtuberapi.service.VTuberService;

@RestController
@RequestMapping("/vtubers")
public class VTuberController {
    private VTuberService vTuberService;

    public VTuberController(VTuberService vTuberService) {
        this.vTuberService = vTuberService;
    }
}
