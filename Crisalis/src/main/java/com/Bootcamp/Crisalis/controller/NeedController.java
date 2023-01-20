package com.Bootcamp.Crisalis.controller;

import com.Bootcamp.Crisalis.model.Need;
import com.Bootcamp.Crisalis.model.dto.NeedDTO;
import com.Bootcamp.Crisalis.service.NeedService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/need")
@CrossOrigin(origins = {"localhost:8080", "localhost", "http://localhost:4200"})
public class NeedController {

/*    private final NeedService needService;

    public NeedController(NeedService needService) {
        this.needService = needService;
    }

    @PostMapping(value = "/new", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Need saveNeed(@RequestBody NeedDTO needDTO) {
        return this.needService.saveNeed(needDTO);
    }

    @DeleteMapping(value = "/deleteById/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteNeedById(@RequestParam Integer id) {
        this.needService.deleteNeedById(id);
    }

    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<NeedDTO> getListAllNeedsInBD() {
        return this.needService.getListAllNeedsInBD();
    }

    @GetMapping(value = "/findNeed/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Need> findNeedById(@RequestBody Integer id) {
        return this.needService.findNeedById(id);
    }*/
}