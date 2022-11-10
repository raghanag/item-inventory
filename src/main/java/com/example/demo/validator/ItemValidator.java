package com.example.demo.validator;

import com.example.demo.model.ItemVO;
import com.example.demo.service.NormalizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Map;

public class ItemValidator implements
        ConstraintValidator<ItemValidatorConstraint, ItemVO> {

    @Autowired
    NormalizationService normalizationService;

    @Override
    public void initialize(ItemValidatorConstraint itemValidatorConstraint) {
    }

    @Override
    public boolean isValid(ItemVO itemVO, ConstraintValidatorContext constraintValidatorContext) {
        boolean isValid = true;
        constraintValidatorContext.disableDefaultConstraintViolation();
        if(itemVO.getSiteId() > 1 && itemVO.getSiteId() < 100) {
            if(itemVO.getTitle().length() > 85) {
                constraintValidatorContext.
                        buildConstraintViolationWithTemplate("Title should be less than 85 chars").
                        addConstraintViolation();
                isValid = false;
            }
            if(itemVO.getItemSpecifics().size() < 2 || itemVO.getItemSpecifics().size() > 10){
                constraintValidatorContext.
                        buildConstraintViolationWithTemplate("Item Specs should be between 2 and 10").
                        addConstraintViolation();
                isValid = false;
            }
            //call external service to normalize item specifics
            Map<String, String> itemSpecifics = normalizationService.normalize(itemVO.getItemSpecifics());
            itemVO.setItemSpecifics(itemSpecifics);
            if(!itemVO.getItemSpecifics().containsKey("Model")) {
                constraintValidatorContext.
                        buildConstraintViolationWithTemplate("Item Specs should contain \"Model\" as key").
                        addConstraintViolation();
                isValid = false;
            }
            if (!StringUtils.hasLength(itemVO.getItemSpecifics().get("Model"))){
                constraintValidatorContext.
                        buildConstraintViolationWithTemplate("\"Model\" value should be non-empty").
                        addConstraintViolation();
                isValid = false;
            }

            return isValid;
        }
        return true;
    }
}
