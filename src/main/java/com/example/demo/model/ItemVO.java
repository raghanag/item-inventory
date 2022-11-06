package com.example.demo.model;

import com.example.demo.validator.ItemValidatorConstraint;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Size;
import java.util.List;
import java.util.Map;

@Data
@ItemValidatorConstraint
public class ItemVO {
    private int siteId;
    private int categoryId;
    private String title;
    private ConditionEnum condition;
    private double price;
    private long quantity;
    private List<String> imageUrl;
    private Map<String, String> itemSpecifics;
}
