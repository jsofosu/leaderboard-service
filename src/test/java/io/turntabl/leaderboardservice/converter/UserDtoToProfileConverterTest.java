package io.turntabl.leaderboardservice.converter;

import io.turntabl.leaderboardservice.model.Profile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserDtoToProfileConverterTest {

    private UserDtoToProfileConverter underTest;

    private Profile p ;
    @BeforeEach
    void setUp() {
        p = new Profile();
        underTest = new UserDtoToProfileConverter();
    }

    @Test
    void shouldConvertUserDtoToProfile() {
        //given


        //when

        //then
    }
}
