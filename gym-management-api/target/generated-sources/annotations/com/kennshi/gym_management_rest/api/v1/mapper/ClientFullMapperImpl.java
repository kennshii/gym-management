package com.kennshi.gym_management_rest.api.v1.mapper;

import com.kennshi.gym_management_rest.api.v1.model.ClientFullDto;
import com.kennshi.gym_management_rest.api.v1.model.MembershipDto;
import com.kennshi.gym_management_rest.api.v1.model.VisitDto;
import com.kennshi.gym_management_rest.domain.Client;
import com.kennshi.gym_management_rest.domain.Membership;
import com.kennshi.gym_management_rest.domain.Visit;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-16T09:50:07+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19.0.1 (Oracle Corporation)"
)
@Component
public class ClientFullMapperImpl implements ClientFullMapper {

    @Override
    public ClientFullDto toClientFullDto(Client client) {
        if ( client == null ) {
            return null;
        }

        ClientFullDto.ClientFullDtoBuilder clientFullDto = ClientFullDto.builder();

        clientFullDto.id( client.getId() );
        clientFullDto.name( client.getName() );
        clientFullDto.email( client.getEmail() );
        clientFullDto.birthday( client.getBirthday() );
        clientFullDto.phone( client.getPhone() );
        clientFullDto.memberships( membershipSetToMembershipDtoSet( client.getMemberships() ) );
        clientFullDto.visits( visitSetToVisitDtoSet( client.getVisits() ) );

        return clientFullDto.build();
    }

    @Override
    public Client toClient(ClientFullDto clientFullDto) {
        if ( clientFullDto == null ) {
            return null;
        }

        Client.ClientBuilder client = Client.builder();

        client.id( clientFullDto.getId() );
        client.name( clientFullDto.getName() );
        client.email( clientFullDto.getEmail() );
        client.birthday( clientFullDto.getBirthday() );
        client.phone( clientFullDto.getPhone() );
        client.memberships( membershipDtoSetToMembershipSet( clientFullDto.getMemberships() ) );
        client.visits( visitDtoSetToVisitSet( clientFullDto.getVisits() ) );

        return client.build();
    }

    protected MembershipDto membershipToMembershipDto(Membership membership) {
        if ( membership == null ) {
            return null;
        }

        MembershipDto.MembershipDtoBuilder membershipDto = MembershipDto.builder();

        membershipDto.id( membership.getId() );
        membershipDto.startDate( membership.getStartDate() );
        membershipDto.endDate( membership.getEndDate() );

        return membershipDto.build();
    }

    protected Set<MembershipDto> membershipSetToMembershipDtoSet(Set<Membership> set) {
        if ( set == null ) {
            return null;
        }

        Set<MembershipDto> set1 = new LinkedHashSet<MembershipDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Membership membership : set ) {
            set1.add( membershipToMembershipDto( membership ) );
        }

        return set1;
    }

    protected VisitDto visitToVisitDto(Visit visit) {
        if ( visit == null ) {
            return null;
        }

        VisitDto.VisitDtoBuilder visitDto = VisitDto.builder();

        visitDto.id( visit.getId() );
        visitDto.date( visit.getDate() );
        visitDto.startTime( visit.getStartTime() );

        return visitDto.build();
    }

    protected Set<VisitDto> visitSetToVisitDtoSet(Set<Visit> set) {
        if ( set == null ) {
            return null;
        }

        Set<VisitDto> set1 = new LinkedHashSet<VisitDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Visit visit : set ) {
            set1.add( visitToVisitDto( visit ) );
        }

        return set1;
    }

    protected Membership membershipDtoToMembership(MembershipDto membershipDto) {
        if ( membershipDto == null ) {
            return null;
        }

        Membership.MembershipBuilder membership = Membership.builder();

        membership.id( membershipDto.getId() );
        membership.startDate( membershipDto.getStartDate() );
        membership.endDate( membershipDto.getEndDate() );

        return membership.build();
    }

    protected Set<Membership> membershipDtoSetToMembershipSet(Set<MembershipDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<Membership> set1 = new LinkedHashSet<Membership>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( MembershipDto membershipDto : set ) {
            set1.add( membershipDtoToMembership( membershipDto ) );
        }

        return set1;
    }

    protected Visit visitDtoToVisit(VisitDto visitDto) {
        if ( visitDto == null ) {
            return null;
        }

        Visit.VisitBuilder visit = Visit.builder();

        visit.id( visitDto.getId() );
        visit.date( visitDto.getDate() );
        visit.startTime( visitDto.getStartTime() );

        return visit.build();
    }

    protected Set<Visit> visitDtoSetToVisitSet(Set<VisitDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<Visit> set1 = new LinkedHashSet<Visit>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( VisitDto visitDto : set ) {
            set1.add( visitDtoToVisit( visitDto ) );
        }

        return set1;
    }
}
