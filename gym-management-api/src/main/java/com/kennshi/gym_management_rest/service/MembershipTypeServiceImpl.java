package com.kennshi.gym_management_rest.service;

import com.kennshi.gym_management_rest.domain.MembershipType;
import com.kennshi.gym_management_rest.repositories.MembershipTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class MembershipTypeServiceImpl implements MembershipTypeService {

    private final MembershipTypeRepository membershipTypeRepository;

    @Override
    public MembershipType findByName(String name) {
        return membershipTypeRepository.findAll()
                .stream()
                .filter(m -> m.getName().equals(name))
                .findFirst().
                orElseThrow(ResourceNotFoundException::new);
    }
}
