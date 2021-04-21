package com.switchfully.parksharkfisher.api.mappers;

import com.switchfully.parksharkfisher.api.dtos.ContactPersonDTOCreation;
import com.switchfully.parksharkfisher.domain.entities.ContactPerson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ContactPersonMapper {
    private static final Logger logger = LoggerFactory.getLogger(ContactPersonMapper.class);

    public ContactPerson toEntity(ContactPersonDTOCreation contactPersonDTOCreation) {
        logger.info("Mapping ContactPersonDTOCreation to ContactPersonEntity");
        return new ContactPerson(contactPersonDTOCreation.getFirstName(),
                contactPersonDTOCreation.getLastName(),
                contactPersonDTOCreation.getMobilePhone(),
                contactPersonDTOCreation.getTelephone(),
                contactPersonDTOCreation.getEmailAdress(),
                contactPersonDTOCreation.getAddress());
    }

}
