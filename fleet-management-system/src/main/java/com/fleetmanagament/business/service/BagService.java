package com.fleetmanagament.business.service;

import com.fleetmanagament.entity.dto.bag.CreateBagRequestDto;
import com.fleetmanagament.entity.dto.bag.CreateBagResponseDto;

public interface BagService {
    CreateBagResponseDto createBag(CreateBagRequestDto createBagRequestDto);
}
