package ru.aragats.sdm.business.dto;

import ru.aragats.sdm.business.dto.SomeDTO;

import java.util.List;

/**
 * Created by Aragats.Amirkhanyan on 30.04.2015.
 */
public class ResponseResult {

    private List<SomeDTO> someDTOs;
    private int size;

    public ResponseResult() {
    }

    public ResponseResult(List<SomeDTO> someDTOs, int size) {
        this.someDTOs = someDTOs;
        this.size = size;
    }

    public List<SomeDTO> getSomeDTOs() {
        return someDTOs;
    }

    public void setSomeDTOs(List<SomeDTO> someDTOs) {
        this.someDTOs = someDTOs;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
