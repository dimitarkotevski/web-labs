package mk.finki.ukim.mk.lab1.model;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class UserNameConverter implements AttributeConverter<UserFullname,String> {
    @Override
    public String convertToDatabaseColumn(UserFullname attribute) {
        return null;
    }

    @Override
    public UserFullname convertToEntityAttribute(String dbData) {
        return null;
    }
}
