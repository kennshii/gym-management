package com.kennshi.gym_management.api.v1.mapper;

import com.kennshi.gym_management.api.v1.model.VisitDto;
import com.kennshi.gym_management.domain.Visit;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface VisitMapper {

    VisitMapper INSTANCE = Mappers.getMapper(VisitMapper.class);

    VisitDto toVisitDto(Visit visit);

    Visit toVisit(VisitDto visitDto);
}
