package com.org.counterservice.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.counterservice.service.entity.Counter;
import com.org.counterservice.service.repository.CounterRepository;

import io.micrometer.core.annotation.Timed;

@Service
public class CounterImplService {

    @Autowired
    private CounterRepository counterRepository;

    // getting all records
    @Timed(value = "AllCounters.time", description = "Time taken to return get getAllCounters")
    public List<Counter> getAllCounters() {
        List<Counter> accounts = new ArrayList<Counter>();
        counterRepository.findAll().forEach(account -> accounts.add(account));
        return accounts;
    }

    // getting a specific record
    @Timed(value = "CounterById.time", description = "Time taken to return get CounterById")
    public Counter getCounterById(long id) {
        return counterRepository.findById(id).get();
    }

    @Timed(value = "saveOrUpdate.time", description = "Time taken to return get saveOrUpdate")
    public Counter saveOrUpdate(Counter counter) {
        return counterRepository.save(counter);
    }

    // deleting a specific record
    public void delete(long id) {
        counterRepository.deleteById(id);
    }
}
