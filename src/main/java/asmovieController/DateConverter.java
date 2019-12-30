package asmovieController;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

@Converter(autoApply = true)
public class DateConverter implements AttributeConverter<LocalDate, Date> {

    @Override
    public LocalDate convertToEntityAttribute(Date date) {
        return LocalDate.from(date.toInstant());
    }

    @Override
    public Date convertToDatabaseColumn(LocalDate localDate) {
        return Date.from(Instant.from(localDate));
    }
}
