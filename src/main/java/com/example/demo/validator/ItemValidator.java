package com.example.demo.validator;

import com.example.demo.model.ItemVO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ItemValidator implements
        ConstraintValidator<ItemValidatorConstraint, ItemVO> {

    @Override
    public void initialize(ItemValidatorConstraint itemValidatorConstraint) {
    }

    @Override
    public boolean isValid(ItemVO itemVO, ConstraintValidatorContext constraintValidatorContext) {
        if(itemVO.getSiteId() > 1 && itemVO.getSiteId() < 100){
            if(itemVO.getTitle().length() > 85) {
                return false;
            }
            if(itemVO.getItemSpecifics().size() < 1 && itemVO.getItemSpecifics().size() > 11){
                return false;
            }
            itemVO.getItemSpecifics()
                    .entrySet()
                    .parallelStream()
                    .forEach(entry -> {
                        try {
                            Thread.sleep(1000);
                            //changing the key to first letter to Capital and calling external service
                            //is not recommended from here.
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    });
            if(!itemVO.getItemSpecifics().containsKey("Model")
                    && itemVO.getItemSpecifics().get("Model") == null) {
                return false;
            }
            return true;
        }
        return true;
    }
}
