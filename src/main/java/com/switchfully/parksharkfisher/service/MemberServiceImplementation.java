package com.switchfully.parksharkfisher.service;

import com.switchfully.parksharkfisher.domain.entities.member.Member;
import com.switchfully.parksharkfisher.domain.repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
class MemberServiceImplementation implements MemberService {
    private final MemberRepository memberRepository;

    @Autowired
    public MemberServiceImplementation(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public Member save(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public List<Member> getAll() {
        return memberRepository.findAll();
    }
}
