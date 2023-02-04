package com.kennshi.gym_management.service;

import com.kennshi.gym_management.api.v1.model.MembershipDto;

import java.util.List;

public interface MembershipService {

    List<MembershipDto> getAllMemberships();

    MembershipDto getMembershipById(Long id);

    MembershipDto createNewMembership(Long id, MembershipDto membershipDto);

    MembershipDto updateMembership(Long clientId, Long membershipId, MembershipDto membershipDto);

//    MembershipDto patchMembership(Long id, MembershipDto membershipDto);

    void deleteById(Long id);
}
