package com.trablock.demo.domain.location;

import com.trablock.demo.domain.member.Member;
import com.trablock.demo.domain.member.PersonInfo;
import com.trablock.demo.domain.member.Profile;
import com.trablock.demo.repository.member.MemberRepository;
import com.trablock.demo.service.member.MemberService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@Transactional
class MemberLocationTest {

    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberRepository memberRepository;

    @Mock Member member;
    @InjectMocks
    private MemberLocation memberLocation = memberLocation(member);

    @BeforeEach
    void setUp() {

        MockitoAnnotations.openMocks(this);
        assertThat(member).isNotNull();
    }

    @Test
    void 멤버Mock() {


        when(member.getId()).thenReturn(20L);
        when(member.getPassword()).thenReturn("password");
        when(member.getUsername()).thenReturn("testname");

        assertThat(member.getId()).isEqualTo(20L);
        assertThat(member.getPassword()).isEqualTo("password");
        assertThat(member.getUsername()).isEqualTo("testname");
    }

    @Test
    void 멤버생성() {
        //given
        Member member = member();

        /*when
        member.setUserId("test");
        member.setPassword("password");
        member.setUsername("testname");
         */


        //then
        assertThat(member.getUserId()).isEqualTo("test");
        assertThat(member.getPassword()).isEqualTo("password");
        assertThat(member.getUsername()).isEqualTo("testname");
    }

    @Test
    void 멤버로케이션생성() {

        //given
        Member member = member();
        MemberLocation memberLocation = memberLocation(member);

        //when


        //then
        assertThat(memberLocation.getMember()).isEqualTo(member);
        assertThat(memberLocation.getLocationType()).isEqualTo(LocationType.RESTAURANT);
        assertThat(memberLocation.getCoords().getLatitude()).isEqualTo(35.4456566431);
        assertThat(memberLocation.getCoords().getLongitude()).isEqualTo(137.6465343);
    }

    public static Member member() {
        return Member.builder()
                .userId("test")
                .password("password")
                .username("testname")
                .build();
    }

    public static MemberLocation memberLocation(Member member) {
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