package com.kennshi.gym_management_rest.service;

import com.kennshi.gym_management_rest.domain.MembershipType;

public interface MembershipTypeService {

    MembershipType findByName(String name);
}
