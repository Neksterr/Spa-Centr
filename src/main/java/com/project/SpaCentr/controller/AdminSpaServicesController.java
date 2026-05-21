package com.project.SpaCentr.controller;

import com.project.SpaCentr.model.dto.request.CreateSpaServiceRequest;
import com.project.SpaCentr.model.dto.response.SpaServiceResponse;
import com.project.SpaCentr.service.SpaServicesService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/services")
public class AdminSpaServicesController {
    private final SpaServicesService spaServicesService;

    public AdminSpaServicesController(SpaServicesService spaServicesService) {
        this.spaServicesService = spaServicesService;
    }
    @PostMapping
    public SpaServiceResponse create(@Valid @RequestBody CreateSpaServiceRequest createSpaServiceRequest){
        return spaServicesService.addSpaService(createSpaServiceRequest);
    }
    @GetMapping
    public List<SpaServiceResponse> listOfServices(){
        return spaServicesService.list();
    }
}
