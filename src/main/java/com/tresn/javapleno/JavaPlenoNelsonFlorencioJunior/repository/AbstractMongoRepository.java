package com.tresn.javapleno.JavaPlenoNelsonFlorencioJunior.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.GenericTypeResolver;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.repository.support.PageableExecutionUtils;

public class AbstractMongoRepository<T> {

    @Autowired
    private MongoTemplate mongoTemplate;

    public T findById(String id) {
        return mongoTemplate.findById(id, getGenericClass());
    }
    
    public T findByOne(Criteria criteria) {
    	Query query =  new Query();
        query.addCriteria(criteria);
        return mongoTemplate.findOne(query, getGenericClass());
    }
    
    public boolean findExists(Criteria criteria) {
    	Query query =  new Query();
        query.addCriteria(criteria);
    	return mongoTemplate.exists(query, getGenericClass());
    }
    
    public List<T> findAll() {
        return mongoTemplate.findAll(getGenericClass());
    }
    
    public List<T> findAll(Criteria criteria) {
        Query query = new Query(criteria);
        return mongoTemplate.find(query, getGenericClass());
    }
    
    public Page<T> getPage(Criteria criteria, Pageable pageable) {
    	Query query =  new Query().with(pageable);
        query.addCriteria(criteria);
        List<T> list = mongoTemplate.find(query, getGenericClass());
        return PageableExecutionUtils.getPage(list, pageable, () -> mongoTemplate.count(query, getGenericClass()));
    }
   
    public T save(T entity) {
        mongoTemplate.save(entity);
        return entity;
    }   

    public void delete(T entity) {
        mongoTemplate.remove(entity);
    }

    @SuppressWarnings("unchecked")
	private Class<T> getGenericClass() {
        return (Class<T>) GenericTypeResolver.resolveTypeArgument(getClass(), AbstractMongoRepository.class);
    }
    
    
}
