package cn.itcast.dao.impl;

import cn.itcast.dao.UpfileDao;
import cn.itcast.domain.Upfile;
import cn.itcast.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by yvettee on 2017/10/19.
 */
public class UpfileDaoImpl implements UpfileDao {
    @Override
    public void add(Upfile upfile) {
        try {
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "insert into upfile(id,uuidname,filename,savepath,uptime,description,username) values(?,?,?,?,?,?,?)";
            Object params[] = {upfile.getId(), upfile.getUuidName(), upfile.getFileName(), upfile.getSavePath(), upfile.getUpTime(), upfile.getDescription(), upfile.getUserName()};
            runner.update(sql, params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Upfile> getAll() {
        try {
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "select * from upfile";
            return runner.query(sql, new BeanListHandler<Upfile>(Upfile.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Upfile find(String id) {
        try {
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "select * from upfile where id=?";
            return runner.query(sql, id,new BeanHandler<Upfile>(Upfile.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void update(Upfile upfile) {

    }
}
