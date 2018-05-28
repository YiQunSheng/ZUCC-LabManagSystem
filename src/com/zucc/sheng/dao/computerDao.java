package com.zucc.sheng.dao;

import com.zucc.sheng.model.computer;

import java.util.List;

public interface computerDao {
    computer getComputerById (String computerId);
    List<computer> getComputerByLabIdAndStatus (String labId);

    List<computer> getComputerInLab(String labId);

    boolean addComputer(computer computer);

    boolean deleteComputer(String computerId);

    boolean updateComputer(computer computer);

    List<computer> getAllComputers();
    computer getComputerByLabIdAndComputerId(String labId,String computerId);
}
