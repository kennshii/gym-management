package com.kennshi.gym_management.api.v1.mapper;

import com.kennshi.gym_management.api.v1.model.VisitDto;
import com.kennshi.gym_management.domain.Visit;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;

class VisitMapperTest {

    VisitMapper visitMapper = VisitMapper.INSTANCE;

    @Test
    void toVisitDto() {
        //given
        Visit visit = Visit.builder()
                .id(1L)
                .date(LocalDate.now())
                .startTime(LocalTime.now())
                .build();

        //when
        VisitDto visitDto = visitMapper.toVisitDto(visit);

        //then
        assertThat(visitDto).isNotNull();
        assertThat(visitDto.getId()).isEqualTo(visit.getId());
        assertThat(visitDto.getDate()).isEqualTo(visit.getDate());
        assertThat(visitDto.getStartTime()).isEqualTo(visit.getStartTime());
    }

    @Test
    void toVisit() {
        //given
        VisitDto visitDto = VisitDto.builder()
                .id(1L)
                .date(LocalDate.now())
                .startTime(LocalTime.now())
                .build();

        //when
        Visit visit = visitMapper.toVisit(visitDto);

        //then
        assertThat(visit).isNotNull();
        assertThat(visit.getId()).isEqualTo(visitDto.getId());
        assertThat(visit.getDate()).isEqualTo(visitDto.getDate());
        assertThat(visit.getStartTime()).isEqualTo(visit.getStartTime());

    }
}