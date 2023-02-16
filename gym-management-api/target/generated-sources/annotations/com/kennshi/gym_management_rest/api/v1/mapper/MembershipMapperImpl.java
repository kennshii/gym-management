package com.kennshi.gym_management_rest.api.v1.mapper;

import com.kennshi.gym_management_rest.api.v1.model.MembershipDto;
import com.kennshi.gym_management_rest.domain.Client;
import com.kennshi.gym_management_rest.domain.Membership;
import com.kennshi.gym_management_rest.domain.MembershipType;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-16T09:50:07+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19.0.1 (Oracle Corporation)"
)
@Component
public class MembershipMapperImpl implements MembershipMapper {

    @Override
    public MembershipDto toMembershipDTO(Membership membership) {
        if ( membership == null ) {
            return null;
        }

        MembershipDto.MembershipDtoBuilder membershipDto = MembershipDto.builder();

        membershipDto.id( membership.getId() );
        membershipDto.clientId( membershipClientId( membership ) );
        membershipDto.clientName( membershipClientName( membership ) );
        membershipDto.membershipTypeName( membershipMembershipTypeName( membership ) );
        membershipDto.startDate( membership.getStartDate() );
        membershipDto.endDate( membership.getEndDate() );

        return membershipDto.build();
    }

    @Override
    public Membership toMembership(MembershipDto membershipDto) {
        if ( membershipDto == null ) {
            return null;
        }

        Membership.MembershipBuilder membership = Membership.builder();

        membership.client( membershipDtoToClient( membershipDto ) );
        membership.startDate( membershipDto.getStartDate() );
        membership.endDate( membershipDto.getEndDate() );
        membership.id( membershipDto.getId() );

        return membership.build();
    }

    private Long membershipClientId(Membership membership) {
        if ( membership == null ) {
            return null;
        }
        Client client = membership.getClient();
        if ( client == null ) {
            return null;
        }
        Long id = client.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String membershipClientName(Membership membership) {
        if ( membership == null ) {
            return null;
        }
        Client client = membership.getClient();
        if ( client == null ) {
            return null;
        }
        String name = client.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private String membershipMembershipTypeName(Membership membership) {
        if ( membership == null ) {
            return null;
        }
        MembershipType membershipType = membership.getMembershipType();
        if ( membershipType == null ) {
            return null;
        }
        String name = membershipType.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    protected Client membershipDtoToClient(MembershipDto membershipDto) {
        if ( membershipDto == null ) {
            return null;
        }

        Client.ClientBuilder client = Client.builder();

        client.id( membershipDto.getClientId() );

        return client.build();
    }
}
