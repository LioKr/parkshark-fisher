package com.switchfully.parksharkfisher.domain.entities;

import com.switchfully.parksharkfisher.domain.entities.member.LicensePlate;
import com.switchfully.parksharkfisher.domain.entities.member.Member;
import com.switchfully.parksharkfisher.domain.entities.member.Membership;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class MemberTest {

    @Test
    void whenCreatingANewMemberWithBronzeMemberShip_thenAssertMembershipIsActuallyBronze() {
        //when
        Member newMember = new Member("first",
                "last",
                "0012345678",
                "mail@mail.com",
                new Address("Street", "2", "3000", "Leuven"),
                new LicensePlate("plate", "country"),
                LocalDate.now(),
                Membership.BRONZE);

        //then
        Assertions.assertEquals(Membership.BRONZE, newMember.getMembership());
    }

    @Test
    void whenCreatingANewMemberWithGoldMemberShip_thenAssertMembershipIsActuallyGold() {
        //when
        Member newMember = new Member("first",
                "last",
                "0012345678",
                "mail@mail.com",
                new Address("Street", "2", "3000", "Leuven"),
                new LicensePlate("plate", "country"),
                LocalDate.now(),
                Membership.GOLD);

        //then
        Assertions.assertEquals(Membership.GOLD, newMember.getMembership());
    }

    @Test
    void whenCreatingANewMemberWithNoMemberShip_thenAssertMembershipIsBronze() {
        //when
        Member newMember = new Member("first",
                "last",
                "0012345678",
                "mail@mail.com",
                new Address("Street", "2", "3000", "Leuven"),
                new LicensePlate("plate", "country"),
                LocalDate.now(),
                null);

        //then
        Assertions.assertEquals(Membership.BRONZE, newMember.getMembership());
    }

}