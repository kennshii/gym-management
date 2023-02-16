package com.kennshi.gym_management_rest.service;

import com.kennshi.gym_management_rest.api.v1.mapper.ClientMapper;
import com.kennshi.gym_management_rest.api.v1.mapper.MembershipMapper;
import com.kennshi.gym_management_rest.repositories.ClientRepository;
import com.kennshi.gym_management_rest.repositories.MembershipRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class MembershipServiceImplTest {

    @Mock
    ClientRepository clientRepository;

    ClientMapper clientMapper = ClientMapper.INSTANCE;

    @Mock
    MembershipRepository membershipRepository;

    MembershipMapper membershipMapper = MembershipMapper.INSTANCE;

    MembershipService membershipService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        membershipService = new MembershipServiceImpl(clientRepository, membershipRepository, clientMapper, membershipMapper);
    }

    @Test
    void createNewMembership() {

    }
}