package com.trablock.demo.service.location;

import com.trablock.demo.domain.location.MemberLocation;
import com.trablock.demo.domain.member.Member;
import com.trablock.demo.repository.location.MemberLocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberLocationServiceImpl implements LocationService {

    private final MemberLocationRepository repository;

    @Transactional
    public Long enroll(MemberLocation memberLocation){

        repository.save(memberLocation);
        return memberLocation.getId();
    }

    public List<MemberLocation> findByMember(Member member){
        return repository.findByMember(member);
    }


}
