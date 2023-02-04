package com.kennshi.gym_management.controller.v1;

import com.kennshi.gym_management.api.v1.model.VisitDto;
import com.kennshi.gym_management.service.VisitService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class VisitController {

    private final VisitService visitService;

    @GetMapping("/visits")
    @ResponseStatus(HttpStatus.OK)
    public List<VisitDto> getAllVisits() {
        return visitService.getAllVisits();
    }

    @GetMapping("/visits/{visitId}")
    @ResponseStatus(HttpStatus.OK)
    public VisitDto getVisitById(@PathVariable Long visitId) {
        return visitService.getVisitById(visitId);
    }

    @PostMapping("/clients/{clientId}/visits")
    @ResponseStatus(HttpStatus.CREATED)
    public VisitDto createNewVisit(@PathVariable Long clientId, @RequestBody VisitDto visitDto) {
        return visitService.createNewVisit(clientId, visitDto);
    }

    @PutMapping("/clients/{clientId}/visits/{visitId}")
    @ResponseStatus(HttpStatus.OK)
    public VisitDto updateVisit(@PathVariable Long clientId, @PathVariable Long visitId, @RequestBody VisitDto visitDto) {
        return visitService.updateVisit(clientId, visitId, visitDto);
    }

    @DeleteMapping({"/visits/{visitId}", "/clients/{clientId}/visits/{visitId}"})
    @ResponseStatus(HttpStatus.OK)
    public void deleteVisitById(@PathVariable Long visitId) {
        visitService.deleteVisitById(visitId);
    }

}
