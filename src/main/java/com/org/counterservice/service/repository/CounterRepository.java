package com.org.counterservice.service.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.org.counterservice.service.entity.Counter;

@Repository
public interface CounterRepository extends CrudRepository<Counter, Long> {
}
