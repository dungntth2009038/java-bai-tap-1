package com.example.cooanhbaitap1.service;

import com.example.cooanhbaitap1.model.TbclassEntity;
import com.example.cooanhbaitap1.repository.TbclassRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TbclassServiceImpl implements  TbclassService{
    @Autowired
    TbclassRepository tbclassRepository;

    @Override
    public void saveTbClass(TbclassEntity a) {
        tbclassRepository.save(a);
    }

    @Override
    public void deleteTbClass(Integer id) {
        tbclassRepository.deleteById(id);
    }

    @Override
    public TbclassEntity findById(Integer id) {
        return tbclassRepository.findById(id).get();
    }

    @Override
    public List<TbclassEntity> findAll() {
        return tbclassRepository.findAll();
    }

    @Override
    public List<TbclassEntity> findAllByName(String name) {
        return tbclassRepository.findAllByNameContainsignoreCase(name);
    }
}