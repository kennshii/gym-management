package com.kennshi.gym_management_rest.api.v1.mapper;

import com.kennshi.gym_management_rest.api.v1.model.MembershipTypeDto;
import com.kennshi.gym_management_rest.domain.MembershipType;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-14T19:32:08+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19.0.1 (Oracle Corporation)"
)
@Component
public class MembershipTypeMapperImpl implements MembershipTypeMapper {

    @Override
    public MembershipTypeDto toMembershipTypeDto(MembershipType membershipType) {
        if ( membershipType == null ) {
            return null;
        }

        MembershipTypeDto.MembershipTypeDtoBuilder membershipTypeDto = MembershipTypeDto.builder();

        membershipTypeDto.id( membershipType.getId() );
        membershipTypeDto.name( membershipType.getName() );
        membershipTypeDto.price( membershipType.getPrice() );
        membershipTypeDto.maxVisits( membershipType.getMaxVisits() );

        return membershipTypeDto.build();
    }

    @Override
    public MembershipType toMembershipType(MembershipTypeDto membershipTypeDto) {
        if ( membershipTypeDto == null ) {
            return null;
        }

        MembershipType.MembershipTypeBuilder membershipType = MembershipType.builder();

        membershipType.id( membershipTypeDto.getId() );
        membershipType.name( membershipTypeDto.getName() );
        membershipType.price( membershipTypeDto.getPrice() );
        membershipType.maxVisits( membershipTypeDto.getMaxVisits() );

        return membershipType.build();
    }
}
