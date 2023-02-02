package com.kennshi.gym_management.api.v1.mapper;

import com.kennshi.gym_management.api.v1.model.MembershipDto;
import com.kennshi.gym_management.domain.Membership;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MembershipMapper {
    MembershipMapper INSTANCE = Mappers.getMapper(MembershipMapper.class);

    MembershipDto toMembershipDTO(Membership membership);

    Membership toMembership(MembershipDto membershipDto);
}
