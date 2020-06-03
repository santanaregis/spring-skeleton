package com.regissantana.spring.skeleton.engine;

import com.regissantana.spring.skeleton.domain.dto.AddressDto;
import com.regissantana.spring.skeleton.infrastructure.service.AddressService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component(value = "exampleDelegate")
public class ExampleDelegate implements JavaDelegate {

    private final AddressService addressService;

    public ExampleDelegate(AddressService addressService) {
        this.addressService = addressService;
    }

    public void execute(DelegateExecution execution) {
        final AddressDto addressDto = addressService.saveFromViaCep("94470100");
        execution.setVariable("CEP", addressDto);
    }

}
