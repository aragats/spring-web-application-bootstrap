package ru.aragats.example.business.context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.aragats.example.business.converter.SomePoToDtoConverter;
import ru.aragats.example.business.dto.SomeDTO;
import ru.aragats.example.persistence.dao.SomeDAO;
import ru.aragats.example.persistence.po.SomePO;

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
