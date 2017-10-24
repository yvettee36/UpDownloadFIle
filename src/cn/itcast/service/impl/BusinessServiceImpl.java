package cn.itcast.service.impl;

import cn.itcast.dao.UpfileDao;
import cn.itcast.domain.Upfile;
import cn.itcast.factory.DaoFactory;
import cn.itcast.service.BusinessService;

import java.util.List;

/**
 * Created by yvettee on 2017/10/19.
 */
public class BusinessServiceImpl implements BusinessService {
    private UpfileDao dao = DaoFactory.getInstance().createDao(UpfileDao.class);


    @Override
    public void addUpfile(Upfile upfile) {
        dao.add(upfile);
    }

    @Override
    public List<Upfile> getAllUpfile() {
        return dao.getAll();
    }

    @Override
    public Upfile findUpfile(String id) {
        return dao.find(id);
    }

}
