package com.boot.service;

import com.boot.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by wuzm on 2017/12/1.
 */
public interface PersonListRepository extends JpaRepository<Person, Long> {
    List<Person> findByName(String name);
}
