package pl.frackiewicz.vtuberapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.frackiewicz.vtuberapi.service.BranchService;

@RestController
@RequestMapping("/branches")
public class BranchController {
    private BranchService branchService;

    public BranchController(BranchService branchService) {
        this.branchService = branchService;
    }
}
