/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.company.secure.repositories;

import com.company.secure.models.CustomUser;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author George.Pasparakis
 */
@Repository
public interface CustomUserRepository extends CrudRepository<CustomUser, Long> {
    CustomUser findByUsername(String username);
    List<CustomUser> findAll();
}
