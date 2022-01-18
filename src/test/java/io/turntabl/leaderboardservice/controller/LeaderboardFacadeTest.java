package io.turntabl.leaderboardservice.controller;

import io.turntabl.leaderboardservice.controller.response.LanguageLevelDto;
import io.turntabl.leaderboardservice.controller.response.ProfileDto;
import io.turntabl.leaderboardservice.converter.ProfileToProfileDtoConverter;
import io.turntabl.leaderboardservice.model.LanguageLevel;
import io.turntabl.leaderboardservice.repository.ProfileRepository;
import io.turntabl.leaderboardservice.service.LeaderboardRepositoryService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.stream.Collectors;


import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LeaderboardFacadeTest {
    @Mock
    private ProfileRepository profileRepository;

    @InjectMocks
    private LeaderboardRepositoryService leaderboardRepositoryService;

    @Mock
    ProfileToProfileDtoConverter profileToProfileDtoConverter;


    LeaderboardFacade underTest;

    @BeforeEach
    void setUp(){
        underTest = new LeaderboardFacade(leaderboardRepositoryService, profileToProfileDtoConverter);
    }

    @Test
    void shouldGetLeaderBoard(){

        //given a profileDto
        ProfileDto profileDto = ProfileDto.builder()
                .username("laimeraatt")
                .name("Ana Lameira")
                .clan("lalal")
                .honour(34)
                .overallRank(23)
                .build();

        List<ProfileDto> expectedResponse = List.of(profileDto);

        when (profileRepository.findAll().stream()
                .map(profileToProfileDtoConverter::convert).toList()).thenReturn(expectedResponse);

        //when
       // List<ProfileDto> result = underTest.getLeaderboard();
        List<ProfileDto> result = leaderboardRepositoryService.getProfiles()
                .stream().map(profileToProfileDtoConverter::convert).toList();

        System.out.println(result);
        //then
        //assertThat(result).containsExactly(profileDto);
       assertEquals(result, expectedResponse, () -> "alalalalslas");

    }

}
