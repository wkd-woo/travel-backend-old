package com.trablock.demo.repository.location;

import com.trablock.demo.domain.location.MemberLocation;
import com.trablock.demo.domain.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@Repository
public interface MemberLocationRepository extends JpaRepository<MemberLocation, Long> {

    @Transactional
    MemberLocation save(MemberLocation memberLocation);

    @Query("select m from member_location m where m.member =: member")
    List<MemberLocation> findByMember(@Param("member") Member member);



}
