package com.kennshi.gym_management_rest.api.v1.mapper;

import com.kennshi.gym_management_rest.api.v1.model.ClientFullDto;
import com.kennshi.gym_management_rest.domain.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClientFullMapper {
    ClientFullMapper INSTANCE = Mappers.getMapper(ClientFullMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "birthday", target = "birthday")
    @Mapping(source = "phone", target = "phone")
    @Mapping(source = "client.memberships", target = "memberships")
    @Mapping(source = "client.visits", target = "visits")
    ClientFullDto toClientFullDto(Client client);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "birthday", target = "birthday")
    @Mapping(source = "phone", target = "phone")
    Client toClient(ClientFullDto clientFullDto);
}
