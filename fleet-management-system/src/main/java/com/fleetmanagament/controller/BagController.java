package com.fleetmanagament.controller;

import com.fleetmanagament.business.service.BagService;
import com.fleetmanagament.entity.dto.bag.CreateBagRequestDto;
import com.fleetmanagament.entity.dto.bag.CreateBagResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/bags")
public class BagController {
    private final BagService bagService;
    @Autowired
    public BagController(BagService bagService) {
        this.bagService = bagService;
    }

    @ResponseBody
    @PostMapping
    public ResponseEntity<CreateBagResponseDto> createBag(@RequestBody CreateBagRequestDto createBagRequestDto){
        return ResponseEntity.ok(this.bagService.createBag(createBagRequestDto));
    }
}
