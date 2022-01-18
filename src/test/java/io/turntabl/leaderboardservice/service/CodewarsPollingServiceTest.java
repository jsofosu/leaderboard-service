package io.turntabl.leaderboardservice.service;

import io.turntabl.leaderboardservice.client.CodewarsClient;
import io.turntabl.leaderboardservice.converter.UserDtoToProfileConverter;
import io.turntabl.leaderboardservice.model.Profile;
import io.turntabl.leaderboardservice.repository.ProfileRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.Objects;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CodewarsPollingServiceTest {
    @Mock
    CodewarsClient codewarsClient;

    @Mock
    UserDtoToProfileConverter userDtoToProfileConverter;

    @Mock
    ProfileRepository profileRepository;

    CodewarsPollingService underTest;

    @BeforeEach
    void  setUp(){
        underTest = new CodewarsPollingService(codewarsClient, userDtoToProfileConverter,profileRepository);
    }

//    @Test
//    void shouldUpdateProfiles(){
//        //given
//        Profile profile1 = mock(Profile.class);
//        Profile profile2 = mock(Profile.class);
//
//        when(profileRepository.findAll().stream()
//                .map(Profile::getId)
//                .map(codewarsClient::getUser)
//                .filter(Objects::nonNull)
//                .map(userDtoToProfileConverter::convert)
//                //.forEach(profileRepository::save)
//        ).thenReturn()
        //when

        //then
    //}

}
