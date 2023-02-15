package com.kennshi.gym_management_rest.service;

import com.kennshi.gym_management_rest.api.v1.mapper.VisitMapper;
import com.kennshi.gym_management_rest.api.v1.model.VisitDto;
import com.kennshi.gym_management_rest.domain.Client;
import com.kennshi.gym_management_rest.domain.Visit;
import com.kennshi.gym_management_rest.repositories.ClientRepository;
import com.kennshi.gym_management_rest.repositories.VisitRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class VisitServiceImpl implements VisitService {

    private final ClientRepository clientRepository;
    private final VisitRepository visitRepository;
    private final VisitMapper visitMapper;

    @Override
    public List<VisitDto> getAllVisits() {
        return visitRepository.findAll().stream()
                .map(visitMapper::toVisitDto)
                .collect(Collectors.toList());
    }

    @Override
    public VisitDto getVisitById(Long visitId) {
        return visitRepository.findById(visitId)
                .map(visitMapper::toVisitDto)
                .orElseThrow(() -> new EntityNotFoundException("Visit not found"));
    }

    @Override
    public VisitDto createNewVisit(Long clientId, VisitDto visitDto) {

        Visit visit = visitMapper.toVisit(visitDto);
        visitRepository.save(visit);

        assignVisitToClient(clientId, visit.getId());

        return visitMapper.toVisitDto(visit);
    }

    //todo - better exception handling
    @Override
    public VisitDto updateVisit(Long clientId, Long visitId, VisitDto visitDto) {

        //check if visit exist
        Visit visit = visitRepository.findById(visitId)
                .orElseThrow(() -> new EntityNotFoundException("Visit not found with id " + visitId));

        Visit visitToUpdate = visitMapper.toVisit(visitDto);

        //checking if id from dto equals to id what need to be updated
        if (visitToUpdate.getId().equals(visit.getId())) {
            visitRepository.save(visitToUpdate);
            assignVisitToClient(clientId, visitId);
        } else {
            throw new RuntimeException();
        }

        return visitMapper.toVisitDto(visitToUpdate);
    }

    @Override
    public void deleteVisitById(Long visitId) {
        visitRepository.deleteById(visitId);
    }

    //todo - better exception handling.
    private void assignVisitToClient(Long clientId, Long visitId) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new EntityNotFoundException("Client not found with id " + clientId));
        Visit visit = visitRepository.findById(visitId)
                .orElseThrow(() -> new EntityNotFoundException("Visit not found with id " + visitId));

        client.getVisits().add(visit);
        visit.setClient(client);
        clientRepository.save(client);
        visitRepository.save(visit);
    }
}
