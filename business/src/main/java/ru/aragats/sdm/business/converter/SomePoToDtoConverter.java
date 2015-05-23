package ru.aragats.sdm.business.converter;

import org.springframework.stereotype.Component;
import ru.aragats.sdm.business.dto.SomeDTO;
import ru.aragats.sdm.persistence.po.SomePO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aragats on 17/05/15.
 */

@Component
public class SomePoToDtoConverter {
    public SomePoToDtoConverter() {
    }

    public SomeDTO convert(SomePO somePO) {
        if (somePO == null || somePO.getId() == null) {
            return null;
        }

        SomeDTO result = new SomeDTO();
        result.setId(somePO.getId());

        return result;

//        Arrays.asList(somePO.getId()
    }

    public List<SomeDTO> convertList(List<SomePO> somePOs) {
        List<SomeDTO> result = new ArrayList<>();
        for (SomePO somePO : somePOs) {
            SomeDTO someDTO = convert(somePO);
            if (someDTO != null) {
                result.add(someDTO);
            }

        }
        return result;
    }


    // You can also add converter to other direction. From someDTO to somePO.

}