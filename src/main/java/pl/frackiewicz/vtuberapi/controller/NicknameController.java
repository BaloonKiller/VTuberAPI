package pl.frackiewicz.vtuberapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.frackiewicz.vtuberapi.entity.Nickname;
import pl.frackiewicz.vtuberapi.service.NicknameService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/nicknames")
public class NicknameController {
    private NicknameService nicknameService;

    public NicknameController(NicknameService nicknameService) {
        this.nicknameService = nicknameService;
    }

    @GetMapping
    public List<Nickname> getList() {
        return nicknameService.getAll();
    }

    @PostMapping("")
    public void addNickname(@RequestBody Nickname nickname) {
        nicknameService.save(nickname);
    }

    @GetMapping("/{nickname}")
    public Nickname getNickname(@PathVariable String nickname) {
        try {
            return nicknameService.get(nickname);
        } catch (NoSuchElementException noSuchElementException) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");
        }
    }

    @DeleteMapping("/{nickname}")
    public void removeNickname(@PathVariable String nickname) {
        try {
            nicknameService.delete(nicknameService.get(nickname));
        } catch (NoSuchElementException noSuchElementException) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");
        }
    }

    @PutMapping("")
    public void updateNickname(@RequestBody Nickname nickname) {
        nicknameService.save(nickname);
    }
}
