package com.project.SpaCentr.service;

import com.project.SpaCentr.model.dto.SpaServicesDTO;
import com.project.SpaCentr.model.entity.SpaServiceEntity;
import com.project.SpaCentr.repository.SpaServiceRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpaServicesService {

    @Autowired
    private final SpaServiceRepository spaServiceRepository;
    private final ModelMapper modelMapper;

    public SpaServicesService(SpaServiceRepository spaServiceRepository, ModelMapper modelMapper) {
        this.spaServiceRepository = spaServiceRepository;
        this.modelMapper = modelMapper;
    }
    public void addSpaService(SpaServicesDTO spaServicesDTO){
        SpaServiceEntity newSpaService = modelMapper.map(spaServicesDTO, SpaServiceEntity.class);
        spaServiceRepository .save(newSpaService);
    }
    public void deleteSpaService(Long spaServiceId){
        if (!spaServiceRepository.existsById(spaServiceId)){
            return;
        }
        spaServiceRepository.deleteById(spaServiceId);
    }

    //To-do
    //update method
    //seeding from a file
    //how to do certain services active for some period and unactive but kept in the db?
}
