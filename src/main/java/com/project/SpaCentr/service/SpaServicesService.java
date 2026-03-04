package com.project.SpaCentr.service;

import com.project.SpaCentr.model.dto.CreateSpaServiceRequest;
import com.project.SpaCentr.model.dto.SpaServiceResponse;
import com.project.SpaCentr.model.entity.SpaServiceEntity;
import com.project.SpaCentr.repository.SpaServiceRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpaServicesService {

    @Autowired
    private final SpaServiceRepository spaServiceRepository;
    private final ModelMapper modelMapper;

    public SpaServicesService(SpaServiceRepository spaServiceRepository, ModelMapper modelMapper) {
        this.spaServiceRepository = spaServiceRepository;
        this.modelMapper = modelMapper;
    }
    public SpaServiceResponse addSpaService(CreateSpaServiceRequest createSpaServiceRequest){
        SpaServiceEntity newSpaService = modelMapper.map(createSpaServiceRequest, SpaServiceEntity.class);
        newSpaService.setStatusActive(true);
        spaServiceRepository .save(newSpaService);
        return modelMapper.map(newSpaService,SpaServiceResponse.class);
    }
    public void deleteSpaService(Long spaServiceId){
        if (!spaServiceRepository.existsById(spaServiceId)){
            return;
        }
        spaServiceRepository.deleteById(spaServiceId);
    }
    public void updateSpaService(Long id, String spaService, int duration, double price){
        SpaServiceEntity existing = spaServiceRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid spa service id: "));
        existing.setServiceName(spaService);
        existing.setDurationMinutes(duration);
        existing.setPrice(price);
        spaServiceRepository.save(existing);
    }
    public List<SpaServiceResponse> list() {
        List<SpaServiceEntity> services =spaServiceRepository.findAll();
        return services.stream()
                .map(s -> modelMapper.map(s, SpaServiceResponse.class))
                .toList();
    }

    //To-do
    //update method
    //seeding from a file
    //how to do certain services active for some period and unactive but kept in the db?
}
