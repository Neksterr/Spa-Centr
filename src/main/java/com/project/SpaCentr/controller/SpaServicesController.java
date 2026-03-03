package com.project.SpaCentr.controller;


import com.project.SpaCentr.model.entity.SpaServiceEntity;
import com.project.SpaCentr.repository.SpaServiceRepository;
import com.project.SpaCentr.service.SpaServicesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
public class SpaServicesController {

    private final SpaServicesService spaServicesService;
    private final SpaServiceRepository spaServiceRepository;


    public SpaServicesController(SpaServicesService spaServicesService, SpaServiceRepository spaServiceRepository) {
        this.spaServicesService = spaServicesService;
        this.spaServiceRepository = spaServiceRepository;
    }

    @RequestMapping("/spaServices")
    public String getSpaServices(Model model){
        List<SpaServiceEntity> allSpaServices = spaServiceRepository.findAll();
        model.addAttribute("spaServices", allSpaServices);
        return "spaServices";
    }
    @GetMapping("/spaServices/addService")
    public String addSpaService(Model model){
        model.addAttribute("newSpaService", new SpaServicesDTO());
        return "addSpaServices";
    }

    @PostMapping("/spaServices/addService")
    public String addSpaService(@ModelAttribute SpaServicesDTO spaServicesDTO){
        spaServicesService.addSpaService(spaServicesDTO);
        return "redirect:/spaServices";
    }

    @PostMapping("/spaServices/delete/{id}")
    public String deleteSpaService(@PathVariable("id") Long id){
        spaServiceRepository.deleteById(id);
        return "redirect:/spaServices";
    }
    @PostMapping("/spaServices/edit/{id}")
    public String editSpaService(@PathVariable("id") Long id,
                                 @RequestParam String serviceName,
                                 @RequestParam int durationMinutes,
                                 @RequestParam double price){
    spaServicesService.updateSpaService(id,serviceName,durationMinutes,price);
    return "redirect:/spaServices";
    }
}
