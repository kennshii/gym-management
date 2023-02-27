package com.kennshi.gym_management_rest.service;

import com.kennshi.gym_management_rest.api.v1.model.MembershipTypeDto;
import com.kennshi.gym_management_rest.domain.MembershipType;

import java.util.List;


public interface MembershipTypeService {

    List<MembershipTypeDto> getAllMemberships();
    MembershipType findByName(String name);
}
