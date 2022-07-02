package com.org.counterservice.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.counterservice.service.entity.Counter;
import com.org.counterservice.service.repository.CounterRepository;

@Service
public class CounterImplService {

    @Autowired
    private CounterRepository counterRepository;

    // getting all records
    public List<Counter> getAllCounters() {
        List<Counter> accounts = new ArrayList<Counter>();
        counterRepository.findAll().forEach(account -> accounts.add(account));
        return accounts;
    }

    // getting a specific record
    public Counter getCounterById(long id) {
        return counterRepository.findById(id).get();
    }

    public Counter saveOrUpdate(Counter counter) {
        return counterRepository.save(counter);
    }

    // deleting a specific record
    public void delete(long id) {
        counterRepository.deleteById(id);
    }
}
