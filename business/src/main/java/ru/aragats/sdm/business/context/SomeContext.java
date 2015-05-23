package ru.aragats.sdm.business.context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.aragats.sdm.business.converter.SomePoToDtoConverter;
import ru.aragats.sdm.business.dto.SomeDTO;
import ru.aragats.sdm.persistence.dao.SomeDAO;
import ru.aragats.sdm.persistence.po.SomePO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aragats.Amirkhanyan on 24.03.2015.
 */
//Some context class for caching.
@Component
public class SomeContext {

    @Autowired
    private SomeDAO someDAO;

    @Autowired
    private SomePoToDtoConverter converter;

    //Some list to store someDTO.
    private List<SomeDTO> someDTOs;

    public SomeContext() {
        this.someDTOs = new ArrayList<>();
    }

    public void initContext() {
        List<SomePO> somePOs = this.someDAO.someMethod2("stringParam");
        this.someDTOs = converter.convertList(somePOs);
    }

}
