package com.kennshi.gym_management_rest.service;

import com.kennshi.gym_management_rest.api.v1.mapper.MembershipTypeMapper;
import com.kennshi.gym_management_rest.api.v1.model.MembershipTypeDto;
import com.kennshi.gym_management_rest.domain.MembershipType;
import com.kennshi.gym_management_rest.repositories.MembershipTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class MembershipTypeServiceImpl implements MembershipTypeService {

    private final MembershipTypeRepository membershipTypeRepository;
    private final MembershipTypeMapper mapper;

    @Override
    public List<MembershipTypeDto> getAllMemberships() {
        return membershipTypeRepository.findAll()
                .stream()
                .map(mapper::toMembershipTypeDto)
                .toList();
    }

    @Override
    public MembershipType findByName(String name) {
        return membershipTypeRepository.findAll()
                .stream()
                .filter(m -> m.getName().equals(name))
                .findFirst().
                orElseThrow(ResourceNotFoundException::new);
    }
}
