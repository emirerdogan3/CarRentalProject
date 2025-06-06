package com.rentacarapp.rentacarsystem.service;

import com.rentacarapp.rentacarsystem.dto.ManagerDashboardStatsDTO;
import com.rentacarapp.rentacarsystem.entity.User; // Or just userId

public interface ManagerDashboardService {
    ManagerDashboardStatsDTO getDashboardStats(User managerUser);
    // Alternative: ManagerDashboardStatsDTO getDashboardStats(Integer managerUserId);
}