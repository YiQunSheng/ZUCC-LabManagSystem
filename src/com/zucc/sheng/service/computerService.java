package com.zucc.sheng.service;

import com.zucc.sheng.model.computer;

import java.util.List;

public interface computerService {
    public void addComputer(computer computer);

    public List<computer> getAllComputer();

    public List<computer> getAllComputerByLabId(String labId);

    List<computer> getComputerByLabIdAndStatus (String labId);
    boolean deleteComputer(String computerId);

    boolean updateComputer(computer  computer);

    computer getComputerById(String computerId);

    public computer getComputerByLadIdAndComputerId(String labId,String computerId);

}
