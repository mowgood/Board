package com.project.board.member.enumeration.converter;

import com.project.board.member.enumeration.Role;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class RoleConverter implements AttributeConverter<Role, String> {

    @Override
    public String convertToDatabaseColumn(Role attribute) {
        return attribute.getTitle();
    }

    @Override
    public Role convertToEntityAttribute(String dbData) {
        return Role.ofString(dbData);
    }
}
