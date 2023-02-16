package com.kennshi.gym_management_rest.api.v1.mapper;

import com.kennshi.gym_management_rest.api.v1.model.VisitDto;
import com.kennshi.gym_management_rest.domain.Visit;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-16T09:50:07+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19.0.1 (Oracle Corporation)"
)
@Component
public class VisitMapperImpl implements VisitMapper {

    @Override
    public VisitDto toVisitDto(Visit visit) {
        if ( visit == null ) {
            return null;
        }

        VisitDto.VisitDtoBuilder visitDto = VisitDto.builder();

        visitDto.id( visit.getId() );
        visitDto.date( visit.getDate() );
        visitDto.startTime( visit.getStartTime() );

        return visitDto.build();
    }

    @Override
    public Visit toVisit(VisitDto visitDto) {
        if ( visitDto == null ) {
            return null;
        }

        Visit.VisitBuilder visit = Visit.builder();

        visit.id( visitDto.getId() );
        visit.date( visitDto.getDate() );
        visit.startTime( visitDto.getStartTime() );

        return visit.build();
    }
}
