package com.example.cooanhbaitap1.service;

import com.example.cooanhbaitap1.model.TbclassEntity;

import java.util.List;

public interface TbclassService {
    public void saveTbClass(TbclassEntity u);
    public void deleteTbClass(Integer id);
    public TbclassEntity findById(Integer id);
    public List<TbclassEntity> findAll();

    public List<TbclassEntity> findAllByName(String name);
}
