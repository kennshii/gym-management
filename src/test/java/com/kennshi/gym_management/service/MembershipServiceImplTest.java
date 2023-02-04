package com.kennshi.gym_management.service;

import com.kennshi.gym_management.api.v1.mapper.ClientMapper;
import com.kennshi.gym_management.api.v1.mapper.MembershipMapper;
import com.kennshi.gym_management.api.v1.model.MembershipDto;
import com.kennshi.gym_management.domain.Client;
import com.kennshi.gym_management.domain.Membership;
import com.kennshi.gym_management.domain.MembershipType;
import com.kennshi.gym_management.repositories.ClientRepository;
import com.kennshi.gym_management.repositories.MembershipRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

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
        //given
        Client client = new Client();
        client.setId(1L);
        client.setName("Busuioc Eduard");
        client.setEmail("anymail@gmail.com");
        client.setBirthday(LocalDate.of(2004, 1, 30));
        client.setPhone("123456789");
        clientRepository.save(client);

        Membership membership = new Membership(client, new MembershipType());
        membershipRepository.save(membership);

        when(clientRepository.findById(anyLong())).thenReturn(Optional.of(client));

        MembershipDto savedMembership = membershipService.createNewMembership(1L, membershipMapper.toMembershipDTO(membership));

        //return client with assigned membership


    }
}