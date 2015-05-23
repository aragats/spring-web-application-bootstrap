package ru.aragats.sdm.server.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.aragats.sdm.business.dto.ResponseResult;
import ru.aragats.sdm.business.dto.SomeDTO;
import ru.aragats.sdm.business.logic.SampleSL;

import java.util.List;

/**
 * Created by Aragats.Amirkhanyan on 05.02.2015.
 */
@RestController
@RequestMapping("api/sample")
public class SampleController {

    @Autowired
    private SampleSL sampleSL;



    //TODO surround try and catch.
    @RequestMapping(value = "/sampleMethod", method = RequestMethod.GET)
    public ResponseResult sampleMethod(@RequestParam(required = true, value = "lp") long longParam,
                                       @RequestParam(required = true, value = "sp") String stringParam,
                                       @RequestParam(required = true, value = "bp") boolean booleanParam) {
        return this.sampleSL.sampleMethod(longParam, stringParam, booleanParam);

    }

    //TODO surround try and catch.
    @RequestMapping(value = "/sampleMethod2", method = RequestMethod.GET)
    public List<SomeDTO> sampleMethod2(@RequestParam(required = true, value = "lp") long longParam,
                                       @RequestParam(required = true, value = "sp") String stringParam,
                                       @RequestParam(required = true, value = "bp") boolean booleanParam) {
        return this.sampleSL.sampleMethod2(longParam, stringParam, booleanParam);
    }


}
