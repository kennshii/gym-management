package com.kennshi.gym_management.controller;

import com.kennshi.gym_management.api.v1.model.MembershipDto;
import com.kennshi.gym_management.service.MembershipService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class MembershipController {

    private final MembershipService membershipService;

    @GetMapping("/memberships")
    @ResponseStatus(HttpStatus.OK)
    public List<MembershipDto> getAllMemberships() {
        return membershipService.getAllMemberships();
    }

    @GetMapping("/memberships/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MembershipDto getById(@PathVariable Long id){
        return membershipService.getMembershipById(id);
    }

    @PostMapping("/clients/{clientId}/memberships")
    @ResponseStatus(HttpStatus.CREATED)
    public MembershipDto createNewMembership(@PathVariable Long clientId, @RequestBody MembershipDto membershipDto) {
        return membershipService.createNewMembership(clientId, membershipDto);
    }

    @PutMapping("/clients/{clientId}/memberships/{membershipId}")
    @ResponseStatus(HttpStatus.OK)
    public MembershipDto updateMembership(@PathVariable Long clientId, @PathVariable Long membershipId,
                                          @RequestBody MembershipDto membershipDto) {
        return membershipService.updateMembership(clientId, membershipDto);
    }

    @DeleteMapping("/clients/{clientId}/memberships/{membershipId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteMembershipById(@PathVariable Long clientId ,@PathVariable Long membershipId) {
        membershipService.deleteById(membershipId);
    }
}
