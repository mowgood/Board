package com.project.board.member.enumeration.converter;

import com.project.board.member.enumeration.MemberStatus;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class MemberStatusConverter implements AttributeConverter<MemberStatus, String> {
    @Override
    public String convertToDatabaseColumn(MemberStatus attribute) {
        return attribute.getTitle();
    }

    @Override
    public MemberStatus convertToEntityAttribute(String dbData) {
        return MemberStatus.ofString(dbData);
    }
}
