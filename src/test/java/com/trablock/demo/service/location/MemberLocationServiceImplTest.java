package com.trablock.demo.service.location;

import com.trablock.demo.domain.location.Coords;
import com.trablock.demo.domain.location.LocationType;
import com.trablock.demo.domain.location.MemberLocation;
import com.trablock.demo.domain.location.MemberLocations;
import com.trablock.demo.domain.member.Member;
import com.trablock.demo.dto.location.MemberLocationDto;
import com.trablock.demo.repository.location.MemberLocationRepository;
import com.trablock.demo.repository.member.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@Transactional
@ExtendWith(MockitoExtension.class)
class MemberLocationServiceImplTest {

    private MemberRepository memberRepository;

    private static MemberLocationDto memberLocationDto = new MemberLocationDto();


    @Mock
    private MemberLocationRepository memberLocationRepository;

    @InjectMocks
    private MemberLocationServiceImpl memberLocationService = new MemberLocationServiceImpl(memberLocationRepository);


    @BeforeEach
    void setUp(){

        MockitoAnnotations.openMocks(this);
        assertThat(memberLocationService).isNotNull();
    }

    @Test
    void 등록확인(){
        //given
        Member member = member();
        MemberLocation memberLocation = memberLocation(member);

        //when
        MemberLocationDto.Request.toEntity();
        memberLocation

        Member member1 = memberRepository.save(member);
        MemberLocation memberLocation1 = memberLocationRepository.save(memberLocation);

        //then
//        assertThat()


    }

    private Member member() {
        return Member.builder()
                .userId("test")
                .password("password")
                .username("testname")
                .build();
    }

    private MemberLocation memberLocation(Member member) {
        return MemberLocation.builder()
                .name("location")
                .address1("add1")
                .address2("add2")
                .member(member)
                .coords(new Coords(35.4456566431, 137.6465343))
                .locationType(LocationType.RESTAURANT)
                .build();
    }

}