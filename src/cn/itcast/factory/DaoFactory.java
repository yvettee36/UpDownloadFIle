package cn.itcast.factory;

import java.util.Properties;

/**
 * Created by yvettee on 2017/10/19.
 */
public class DaoFactory {
    private static Properties daoConfig = new Properties();

    static {
        try {
            daoConfig.load(DaoFactory.class.getClassLoader().getResourceAsStream("dao.properties"));
        } catch (Exception e) {
           throw new RuntimeException(e);
        }
    }

    private DaoFactory() {

    }

    private static final DaoFactory instance = new DaoFactory();

    public static DaoFactory getInstance() {
        return instance;

    }

    public <T> T createDao(Class interfaceClass) {
        String name = interfaceClass.getSimpleName();
        String daoClassname= daoConfig.getProperty(name);
        try {
            return (T) Class.forName(daoClassname).newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
