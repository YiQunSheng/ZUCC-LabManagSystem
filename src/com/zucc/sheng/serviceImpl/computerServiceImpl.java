package com.zucc.sheng.serviceImpl;

import com.zucc.sheng.dao.computerDao;
import com.zucc.sheng.model.computer;
import com.zucc.sheng.service.computerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("computerService")
public class computerServiceImpl implements computerService {
    @Resource(name="computerDao")
    private computerDao computerDao;

    public computerDao getComputerDao() {
        return computerDao;
    }

    public void setComputerDao(computerDao computerDao) {
        this.computerDao = computerDao;
    }

    @Override
    public void addComputer(computer computer) {
              this.computerDao.addComputer(computer);
    }

    @Override
    public List<computer> getAllComputerByLabId(String labId) {
        return this.computerDao.getComputerInLab(labId);
    }

    @Override
    public List<computer> getAllComputer() {
        return this.computerDao.getAllComputers();
    }

    @Override
    public boolean deleteComputer(String computerId) {
        return this.computerDao.deleteComputer(computerId);
    }

    @Override
    public boolean updateComputer(computer computer) {
        return this.computerDao.updateComputer(computer);
    }

    @Override
    public computer getComputerById(String computerId) {

        return this.computerDao.getComputerById(computerId);

    }


    public List<computer> getComputerByLabIdAndStatus(String labId) {
        return this.computerDao.getComputerByLabIdAndStatus(labId);
    }


    public computer getComputerByLadIdAndComputerId(String labId, String computerId) {
        return this.computerDao.getComputerByLabIdAndComputerId(labId,computerId);
    }
}
