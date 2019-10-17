package pl.salon.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.salon.model.CosmeticProcedure;
import pl.salon.repositories.CosmeticProcedureRepository;

public class CosmeticProcedureConverter implements Converter<String, CosmeticProcedure> {
    @Autowired
    CosmeticProcedureRepository cosmeticProcedureRepository;

    @Override
    public CosmeticProcedure convert(String source) {
        return cosmeticProcedureRepository.findOne(Long.parseLong(source));
    }
}
