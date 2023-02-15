package com.kennshi.gym_management_rest.api.v1.mapper;

import com.kennshi.gym_management_rest.api.v1.model.MembershipTypeDto;
import com.kennshi.gym_management_rest.domain.MembershipType;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MembershipTypeMapper {
    MembershipTypeMapper INSTANCE = Mappers.getMapper(MembershipTypeMapper.class);

    MembershipTypeDto toMembershipTypeDto(MembershipType membershipType);

    MembershipType toMembershipType(MembershipTypeDto membershipTypeDto);
}
