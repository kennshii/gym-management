package com.kennshi.gym_management_rest.api.v1.mapper;

import com.kennshi.gym_management_rest.api.v1.model.MembershipTypeDto;
import com.kennshi.gym_management_rest.domain.MembershipType;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class MembershipTypeMapperTest {

    MembershipTypeMapper mapper = MembershipTypeMapper.INSTANCE;

    @Test
    void toMembershipTypeDto() {
        //given
        MembershipType membershipType = MembershipType.builder()
                .id(1L)
                .name("test")
                .price(BigDecimal.valueOf(999))
                .maxVisits(10)
                .build();

        //when
        MembershipTypeDto membershipTypeDto = mapper.toMembershipTypeDto(membershipType);

        //then
        assertThat(membershipTypeDto).isNotNull();
        assertThat(membershipTypeDto.getId()).isEqualTo(membershipType.getId());
        assertThat(membershipTypeDto.getName()).isEqualTo(membershipType.getName());
        assertThat(membershipTypeDto.getPrice()).isEqualTo(membershipType.getPrice());
        assertThat(membershipTypeDto.getMaxVisits()).isEqualTo(membershipType.getMaxVisits());
    }

    @Test
    void toMembershipType() {
        //given
        MembershipTypeDto membershipTypeDto = MembershipTypeDto.builder()
                .id(1L)
                .name("test")
                .price(BigDecimal.valueOf(999))
                .maxVisits(10)
                .build();

        //when
        MembershipType mType = mapper.toMembershipType(membershipTypeDto);

        //then
        assertThat(mType).isNotNull();
        assertThat(mType.getId()).isEqualTo(membershipTypeDto.getId());
        assertThat(mType.getName()).isEqualTo(membershipTypeDto.getName());
        assertThat(mType.getPrice()).isEqualTo(membershipTypeDto.getPrice());
        assertThat(mType.getMaxVisits()).isEqualTo(membershipTypeDto.getMaxVisits());

    }
}