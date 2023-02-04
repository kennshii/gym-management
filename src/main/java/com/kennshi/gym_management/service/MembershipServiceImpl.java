package com.kennshi.gym_management.service;

import com.kennshi.gym_management.api.v1.mapper.ClientMapper;
import com.kennshi.gym_management.api.v1.mapper.MembershipMapper;
import com.kennshi.gym_management.api.v1.model.ClientDto;
import com.kennshi.gym_management.api.v1.model.MembershipDto;
import com.kennshi.gym_management.domain.Client;
import com.kennshi.gym_management.domain.Membership;
import com.kennshi.gym_management.repositories.ClientRepository;
import com.kennshi.gym_management.repositories.MembershipRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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

    @Override
    public MembershipDto createNewMembership(Long clientId,MembershipDto membershipDto) {

        Membership membership = membershipMapper.toMembership(membershipDto);
        //saving membership
        membershipRepository.save(membership);
        //add membership to client id
        assignMembershipToClient(clientId, membership.getId());

        return membershipMapper.toMembershipDTO(membership);
    }

    //todo - fix bug with adding a membership without a assigned client
    @Override
    public MembershipDto updateMembership(Long clientId, MembershipDto membershipDto) {

        Membership updatedMembership = membershipMapper.toMembership(membershipDto);
        //saving membership
        membershipRepository.save(updatedMembership);
        assignMembershipToClient(clientId, updatedMembership.getId());

//        membershipRepository.findAll().forEach(membership -> {
//            if (membership.getClient() == null)
//                deleteById(membership.getId());
//            log.debug("Membership without client was deleted");
//        });

        return membershipDto;
    }

    @Override
    public void deleteById(Long id) {
        membershipRepository.deleteById(id);
    }

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
