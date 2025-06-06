package com.rentacarapp.rentacarsystem.service;

import com.rentacarapp.rentacarsystem.entity.Manager;
import java.util.List;
import java.util.Optional;

public interface ManagerService {
    Manager createManager(Manager manager);
    Manager updateManager(Integer id, Manager manager);
    void deleteManager(Integer id);
    Optional<Manager> getManagerById(Integer id);
    List<Manager> getAllManagers();
}