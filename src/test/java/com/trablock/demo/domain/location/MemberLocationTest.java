package com.trablock.demo.domain.location;

import com.trablock.demo.domain.member.Member;
import com.trablock.demo.repository.member.MemberRepository;
import com.trablock.demo.service.member.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@Transactional
class MemberLocationTest {

    @Autowired
    MemberService memberService;

    @Autowired
    MemberRepository memberRepository;

    @Test
    void 멤버생성(){
        Member member = Member.builder()
                .userId("test")
                .password("password")
                .username("testname")
                .build();

        assertThat(member.getUserId()).isEqualTo("test");
        assertThat(member.getPassword()).isEqualTo("password");
        assertThat(member.getUsername()).isEqualTo("testname");
    }

    @Test
    void 멤버로케이션생성(){

        Member member = Member.builder()
                .userId("test")
                .password("password")
                .username("testname")
                .build();

        MemberLocation memberLocation = MemberLocation.builder()
                .name("location")
                .address1("add1")
                .address2("add2")
                .member(member)
                .coords(new Coords(35.4456566431, 137.6465343))
                .locationType(LocationType.Restaurant)
                .build();

        assertThat(memberLocation.getMember()).isEqualTo(member);
        assertThat(memberLocation.getLocationType()).isEqualTo(LocationType.Restaurant);
        assertThat(memberLocation.getCoords().getLatitude()).isEqualTo(35.4456566431);
        assertThat(memberLocation.getCoords().getLongitude()).isEqualTo(137.6465343);
    }

    
}