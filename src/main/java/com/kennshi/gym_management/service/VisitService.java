package com.kennshi.gym_management.service;

import com.kennshi.gym_management.api.v1.model.VisitDto;

import java.util.List;

public interface VisitService {

    List<VisitDto> getAllVisits();

    VisitDto getVisitById(Long id);

    VisitDto createNewVisit(Long id, VisitDto visitDto);

    VisitDto updateVisit(Long clientId, Long visitId, VisitDto visitDto);

//    MembershipDto patchMembership(Long id, MembershipDto membershipDto);

    void deleteVisitById(Long id);
}
