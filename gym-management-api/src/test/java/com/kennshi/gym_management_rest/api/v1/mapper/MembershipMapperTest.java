package com.kennshi.gym_management_rest.api.v1.mapper;

import com.kennshi.gym_management_rest.api.v1.model.MembershipDto;
import com.kennshi.gym_management_rest.domain.Client;
import com.kennshi.gym_management_rest.domain.Membership;
import com.kennshi.gym_management_rest.domain.MembershipType;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class MembershipMapperTest {

    MembershipMapper mapper = MembershipMapper.INSTANCE;

    @Test
    void toMembershipDTO() {
        //given
        Membership membership = Membership.builder()
                .id(1L)
                .client(new Client())
                .membershipType(new MembershipType())
                .startDate(LocalDate.now())
                .endDate(LocalDate.now().plusMonths(1))
                .build();

        //when
        MembershipDto membershipDto = mapper.toMembershipDTO(membership);

        //then
        assertThat(membershipDto).isNotNull();
        assertThat(membershipDto.getId()).isEqualTo(membership.getId());
        assertThat(membershipDto.getStartDate()).isEqualTo(membership.getStartDate());
        assertThat(membershipDto.getEndDate()).isEqualTo(membership.getEndDate());
    }

    @Test
    void toMembership() {
        MembershipDto membershipDto = MembershipDto.builder()
                .id(1L)
                .startDate(LocalDate.now())
                .endDate(LocalDate.now().plusMonths(1))
                .build();

        Membership membership = mapper.toMembership(membershipDto);

        assertThat(membership).isNotNull();
        assertThat(membership.getId()).isEqualTo(membership.getId());
        assertThat(membership.getStartDate()).isEqualTo(membershipDto.getStartDate());
        assertThat(membership.getEndDate()).isEqualTo(membershipDto.getEndDate());

    }
}