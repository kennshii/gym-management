package com.kennshi.gym_management_rest.service;

import com.kennshi.gym_management_rest.api.v1.mapper.ClientMapper;
import com.kennshi.gym_management_rest.api.v1.mapper.MembershipMapper;
import com.kennshi.gym_management_rest.api.v1.model.ClientDto;
import com.kennshi.gym_management_rest.api.v1.model.MembershipDto;
import com.kennshi.gym_management_rest.domain.Client;
import com.kennshi.gym_management_rest.domain.Membership;
import com.kennshi.gym_management_rest.repositories.ClientRepository;
import com.kennshi.gym_management_rest.repositories.MembershipRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class MembershipServiceImpl implements MembershipService {

    private final ClientRepository clientRepository;
    private final MembershipRepository membershipRepository;
    private final ClientMapper clientMapper;
    private final MembershipMapper membershipMapper;
    private final MembershipTypeService membershipTypeService;

    @Override
    public List<MembershipDto> getAllMemberships() {
        return membershipRepository.findAll()
                .stream()
                .map(membershipMapper::toMembershipDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MembershipDto getMembershipById(Long id) {
        return membershipRepository.findById(id)
                .map(membershipMapper::toMembershipDTO)
                .orElseThrow(RuntimeException::new);
    }

    //todo - or enhance methods, maybe put and post implementation need to be different
    @Override
    public MembershipDto createNewMembership(Long clientId,MembershipDto membershipDto) {

        //setting membership
        Membership membership = membershipMapper.toMembership(membershipDto);
        membership.setMembershipType(membershipTypeService.findByName(membershipDto.getMembershipTypeName()));

        if(membership.getMembershipType().getName().equals("12 MONTHS")) {
            membership.setStartDate(LocalDate.now());
            membership.setEndDate(LocalDate.now().plusMonths(12));
        }
        if(membership.getMembershipType().getName().equals("3 MONTHS")) {
            membership.setStartDate(LocalDate.now());
            membership.setEndDate(LocalDate.now().plusMonths(3));
        }
        if(membership.getMembershipType().getName().equals("1 MONTH")) {
            membership.setStartDate(LocalDate.now());
            membership.setEndDate(LocalDate.now().plusMonths(1));
        }
        if(membership.getMembershipType().getName().equals("12 VISITS")) {
            membership.setStartDate(LocalDate.now());
            membership.setEndDate(LocalDate.now().plusMonths(1));
        }

        //saving membership
        membershipRepository.save(membership);
        //add membership to client id
        assignMembershipToClient(clientId, membership.getId());

        return membershipMapper.toMembershipDTO(membership);
    }

    //todo - fix bug when adding a membership without an assigned client
    @Override
    public MembershipDto updateMembership(Long clientId, Long membershipId, MembershipDto membershipDto) {

        Membership membership = membershipRepository.findById(membershipId)
                .orElseThrow(() -> new EntityNotFoundException("Membership not found with id " + membershipId));

        Membership membershipToUpdate = membershipMapper.toMembership(membershipDto);
        membershipToUpdate.setMembershipType(membershipTypeService.findByName(membershipDto.getMembershipTypeName()));

        //checking if if from dto equals with id from repo for further update
        if (membershipToUpdate.getId().equals(membership.getId())) {
            //saving membership
            membershipRepository.save(membershipToUpdate);
            assignMembershipToClient(clientId, membershipToUpdate.getId());
        } else {
            throw new RuntimeException();
        }

        return membershipMapper.toMembershipDTO(membershipToUpdate);
    }

    @Override
    public void deleteById(Long id) {
        membershipRepository.deleteById(id);
    }

    //todo - better exception handling. Clearer error in json
    private ClientDto assignMembershipToClient(Long clientId, Long membershipId) {

        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new EntityNotFoundException("Client not found with id " + clientId));
        Membership membership = membershipRepository.findById(membershipId)
                .orElseThrow(() -> new EntityNotFoundException("Membership not found with id " + membershipId));
        client.getMemberships().add(membership);
        membership.setClient(client);
        clientRepository.save(client);
        membershipRepository.save(membership);

        return clientMapper.toClientDto(client);
    }
}
