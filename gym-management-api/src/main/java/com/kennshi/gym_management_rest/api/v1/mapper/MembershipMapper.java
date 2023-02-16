package com.kennshi.gym_management_rest.api.v1.mapper;

import com.kennshi.gym_management_rest.api.v1.model.MembershipDto;
import com.kennshi.gym_management_rest.domain.Membership;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MembershipMapper {
    MembershipMapper INSTANCE = Mappers.getMapper(MembershipMapper.class);

    @Mapping(source = "membership.id", target = "id")
    @Mapping(source = "membership.client.id", target = "clientId")
    @Mapping(source = "membership.client.name", target = "clientName")
    @Mapping(source = "membershipType.name", target = "membershipTypeName")
    @Mapping(source = "membership.startDate", target = "startDate")
    @Mapping(source = "membership.endDate", target = "endDate")
    MembershipDto toMembershipDTO(Membership membership);

    @Mapping(source = "clientId", target = "client.id")
    @Mapping(source = "startDate", target = "startDate")
    @Mapping(source = "endDate", target = "endDate")
    Membership toMembership(MembershipDto membershipDto);
}
