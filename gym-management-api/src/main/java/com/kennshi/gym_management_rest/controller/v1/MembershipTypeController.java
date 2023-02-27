package com.kennshi.gym_management_rest.controller.v1;

import com.kennshi.gym_management_rest.api.v1.model.MembershipTypeDto;
import com.kennshi.gym_management_rest.service.MembershipTypeServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class MembershipTypeController {

    private final MembershipTypeServiceImpl membershipTypeService;

    @GetMapping("/membershipTypes")
    @ResponseStatus(HttpStatus.OK)
    public List<MembershipTypeDto> getAllMembershipTypes() {
        return membershipTypeService.getAllMemberships();
    }
}
