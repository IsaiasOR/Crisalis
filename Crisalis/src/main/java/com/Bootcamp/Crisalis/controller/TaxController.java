package com.Bootcamp.Crisalis.controller;

import com.Bootcamp.Crisalis.model.Tax;
import com.Bootcamp.Crisalis.model.dto.TaxDTO;
import com.Bootcamp.Crisalis.service.TaxService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tax")
@CrossOrigin(origins = {"localhost:8080", "localhost"})
public class TaxController {

    private final TaxService taxService;

    public TaxController(TaxService taxService) {
        this.taxService = taxService;
    }

    @PostMapping(value = "/new", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Tax saveTax(@RequestBody TaxDTO taxDTO) {
        return this.taxService.saveTax(taxDTO);
    }

    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TaxDTO> getListAllTaxesInBD() {
        return this.taxService.getListAllTaxesInBD();
    }

    @DeleteMapping(value = "/delete/name", produces = MediaType.APPLICATION_JSON_VALUE)
    public Tax deleteTaxByName(@RequestParam String name) {
        return this.taxService.deleteTaxByName(name);
    }

    @DeleteMapping(value = "/delete/id", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteTaxById(@RequestParam Integer id) {
        this.taxService.deleteTaxById(id);
    }

    @GetMapping(value = "/findTax", produces = MediaType.APPLICATION_JSON_VALUE)
    public TaxDTO findTaxByName(@RequestParam String name) {
        return this.taxService.findByName(name);
    }
}
