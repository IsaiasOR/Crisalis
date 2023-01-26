package com.Bootcamp.Crisalis.controller;

import com.Bootcamp.Crisalis.model.Tax;
import com.Bootcamp.Crisalis.model.dto.TaxDTO;
import com.Bootcamp.Crisalis.service.TaxService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tax")
@CrossOrigin(origins = {"localhost:8080", "localhost", "http://localhost:4200"})
public class TaxController {

    private final TaxService taxService;

    public TaxController(TaxService taxService) {
        this.taxService = taxService;
    }

    @PostMapping(value = "/new",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Tax saveTax(@RequestBody TaxDTO taxDTO) {
        return this.taxService.saveTax(taxDTO);
    }

    @GetMapping(value = "/list",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TaxDTO> getListAllTaxesInBD() {
        return this.taxService.getListAllTaxesInBD();
    }

    @DeleteMapping(value = "/delete/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String deleteTaxById(@PathVariable("id")  Integer id) {
        String msj = "Removal successful";
        this.taxService.deleteTaxById(id);
        return msj;
    }

    @GetMapping(value = "/findTax/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Tax findTaxById(@PathVariable("id")  Integer id) {
        return this.taxService.findTaxById(id);
    }

    @PutMapping(value = "/update/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Tax updateTax(@RequestBody TaxDTO taxDTO, @PathVariable("id") Integer id) {
        return this.taxService.updateTax(taxDTO, id);
    }
}
