package com.kennshi.gym_management_rest.api.v1.mapper;

import com.kennshi.gym_management_rest.api.v1.model.ClientDto;
import com.kennshi.gym_management_rest.domain.Client;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-16T09:50:07+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19.0.1 (Oracle Corporation)"
)
@Component
public class ClientMapperImpl implements ClientMapper {

    @Override
    public ClientDto toClientDto(Client client) {
        if ( client == null ) {
            return null;
        }

        ClientDto.ClientDtoBuilder clientDto = ClientDto.builder();

        clientDto.id( client.getId() );
        clientDto.name( client.getName() );
        clientDto.email( client.getEmail() );
        clientDto.birthday( client.getBirthday() );
        clientDto.phone( client.getPhone() );

        return clientDto.build();
    }

    @Override
    public Client toClient(ClientDto clientDto) {
        if ( clientDto == null ) {
            return null;
        }

        Client.ClientBuilder client = Client.builder();

        client.id( clientDto.getId() );
        client.name( clientDto.getName() );
        client.email( clientDto.getEmail() );
        client.birthday( clientDto.getBirthday() );
        client.phone( clientDto.getPhone() );

        return client.build();
    }
}
