package io.turntabl.leaderboardservice.controller;
import io.turntabl.leaderboardservice.controller.response.ProfileDto;
import io.turntabl.leaderboardservice.converter.ProfileToProfileDtoConverter;
import io.turntabl.leaderboardservice.model.Profile;
import io.turntabl.leaderboardservice.service.LeaderboardRepositoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class LeaderboardFacadeTest {
//    @Autowired
//    private LeaderboardFacade leaderboardFacade;
//
//    @MockBean
//    private LeaderboardRepositoryService leaderboardRepositoryService;
//
//    @MockBean
//    private ProfileToProfileDtoConverter profileToProfileDtoConverter;
//
//    @Test
//    void testGetLeaderboard() {
//        when(this.leaderboardRepositoryService.getProfiles()).thenReturn(new ArrayList<>());
//        assertTrue(this.leaderboardFacade.getLeaderboard().isEmpty());
//        verify(this.leaderboardRepositoryService).getProfiles();
//    }

    @Mock
    private LeaderboardRepositoryService leaderboardRepositoryService;

    @Mock
    ProfileToProfileDtoConverter profileToProfileDtoConverter;

 @Autowired
  private  LeaderboardFacade underTest;

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

           Profile profile = new Profile();
           profile.setClan("lalal");

       List<ProfileDto> expectedResponse = List.of(profileDto);
           List<Profile> expectedResponse1 = List.of(profile);

        /*when (leaderboardRepositoryService.getProfiles().stream()
                .map(profileToProfileDtoConverter::convert)
                .collect(toList())).thenReturn(expectedResponse);*/

           when (leaderboardRepositoryService.getProfiles()).thenReturn(List.of(profile));
        //when
        List<ProfileDto> result = underTest.getLeaderboard();


        System.out.println(result);
        //then
           List<ProfileDto> dtos = expectedResponse1.stream().map(profileToProfileDtoConverter::convert).toList();
         // assertThat(result).containsExactly(dtos);
           assertEquals(result, dtos);
//       assertEquals(result, expectedResponse, () -> "alalalalslas");

    }
    }






