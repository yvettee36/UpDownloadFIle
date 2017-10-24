package cn.itcast.dao;

import cn.itcast.domain.Upfile;

import java.util.List;

/**
 * Created by yvettee on 2017/10/19.
 */
public interface UpfileDao {
    //上传文件到数据库
    public void add(Upfile upfile);

    public List<Upfile> getAll();

    public Upfile find(String id);

    public void delete(String id);

    public void update(Upfile upfile);

}
