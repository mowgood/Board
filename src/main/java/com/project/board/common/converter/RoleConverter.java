package com.project.board.common.converter;

import com.project.board.common.enumeration.Role;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

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
