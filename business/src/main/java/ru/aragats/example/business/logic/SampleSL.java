package ru.aragats.example.business.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.aragats.example.business.dto.ResponseResult;
import ru.aragats.example.business.context.SomeContext;
import ru.aragats.example.business.converter.SomePoToDtoConverter;
import ru.aragats.example.business.dto.SomeDTO;
import ru.aragats.example.persistence.dao.SomeDAO;
import ru.aragats.example.persistence.po.SomePO;

import java.util.List;

/**
 * Created by Aragats.Amirkhanyan on 05.02.2015.
 */
@Component
public class SampleSL {

    @Autowired
    private SomeDAO someDAO;

    @Autowired
    private SomePoToDtoConverter converter;

    @Autowired
    private SomeContext context;


    public SampleSL() {

    }


    public ResponseResult sampleMethod(long longParam, String stringParam, boolean booleanParam) {
        List<SomePO> somePOs = this.someDAO.someMethod(longParam, stringParam, booleanParam);
        List<SomeDTO> someDTOs = this.converter.convertList(somePOs);
        return new ResponseResult(someDTOs, 11);
    }


    public List<SomeDTO> sampleMethod2(long longParam, String stringParam, boolean booleanParam) {
        List<SomePO> somePOs = this.someDAO.someMethod2(stringParam);
        return this.converter.convertList(somePOs);
    }


}
