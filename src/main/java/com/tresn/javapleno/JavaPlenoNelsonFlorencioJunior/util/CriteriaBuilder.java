package com.tresn.javapleno.JavaPlenoNelsonFlorencioJunior.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

import org.springframework.data.mongodb.core.query.Criteria;

public class CriteriaBuilder {

    private List<Criteria> listaCriteria =  new ArrayList<>();

    public CriteriaBuilder is(String property, Optional<?> optionalValue) {
        optionalValue.ifPresent(value -> listaCriteria.add(Criteria.where(property)
        		.is(value)));
        return this;
    }
    
    public CriteriaBuilder regex(String property, Optional<String> optionalValue) {
        optionalValue.ifPresent(value -> listaCriteria.add(Criteria.where(property)
        		.regex(value)));
        return this;
    }
    
    public CriteriaBuilder regexCaseSensitive(String property, Optional<String> optionalValue) {
        optionalValue.ifPresent(value -> listaCriteria.add(Criteria.where(property)
        		.regex(Pattern.compile(value, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE))));
        return this;
    }
    

    public Criteria build() {
        return listaCriteria.stream().reduce(Criteria::andOperator).orElse(new Criteria());
    }
}
