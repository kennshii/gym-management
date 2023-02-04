package com.kennshi.gym_management.api.v1.mapper;

import com.kennshi.gym_management.api.v1.model.ClientFullDto;
import com.kennshi.gym_management.domain.Client;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClientFullMapper {

    ClientFullMapper clientFullMapper = Mappers.getMapper(ClientFullMapper.class);

    ClientFullDto toClientFullDto(Client client);

    Client toClientFull(ClientFullDto clientFullDto);
}
