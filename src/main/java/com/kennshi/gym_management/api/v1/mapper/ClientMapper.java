package com.kennshi.gym_management.api.v1.mapper;

import com.kennshi.gym_management.api.v1.model.ClientDto;
import com.kennshi.gym_management.domain.Client;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClientMapper {
    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    ClientDto toClientDto(Client client);

    Client toClient(ClientDto clientDto);
}
