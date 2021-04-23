package com.switchfully.parksharkfisher.domain.repositories;

import com.switchfully.parksharkfisher.domain.entities.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MemberRepository extends JpaRepository<Member, UUID> {
    Member getMemberByMail(String mail);
    Member getMemberById(UUID id);
}
