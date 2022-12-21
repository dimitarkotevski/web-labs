package mk.finki.ukim.mk.lab1.model;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class UserNameConverter implements AttributeConverter<UserFullname,String> {
    public String SEPARATOR=" ";
    @Override
    public String convertToDatabaseColumn(UserFullname userFullname) {
        return userFullname.getName()+" "+userFullname.getSurname();
    }

    @Override
    public UserFullname convertToEntityAttribute(String fullName) {
        String name=fullName.split(SEPARATOR)[0];
        String surname=fullName.split(SEPARATOR)[1];
        return new UserFullname(name,surname);
    }
}
