package com.example.cooanhbaitap1.repository;

import com.example.cooanhbaitap1.model.TbclassEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface TbclassRepository extends JpaRepository<TbclassEntity, Integer> {
    List<TbclassEntity> findAllByName(String name);

    List<TbclassEntity> findAllByNameContainsignoreCase(String name);

    List<TbclassEntity> findAllByNameAndEmail(String name, String email);

    List<TbclassEntity> findAllByNameOrderByEmailAsc(String name);

//    void saveTbClass(TbclassEntity a);
}
