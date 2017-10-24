package cn.itcast.service;

import cn.itcast.domain.Upfile;

import java.util.List;

/**
 * Created by yvettee on 2017/10/19.
 */
public interface BusinessService {
    public void addUpfile(Upfile upfile);

    public List<Upfile> getAllUpfile();

    public Upfile findUpfile(String id);
}
