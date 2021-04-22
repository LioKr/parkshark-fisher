package com.switchfully.parksharkfisher.service;

import com.switchfully.parksharkfisher.domain.entities.Member;

import java.util.List;

public interface MemberService {
    Member save(Member member);

    List<Member> getAll();
}
