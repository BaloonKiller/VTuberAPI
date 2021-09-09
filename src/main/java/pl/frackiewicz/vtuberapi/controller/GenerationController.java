package pl.frackiewicz.vtuberapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.frackiewicz.vtuberapi.service.GenerationService;

@RestController
@RequestMapping("/generations")
public class GenerationController {
    private GenerationService generationService;

    public GenerationController(GenerationService generationService) {
        this.generationService = generationService;
    }
}
