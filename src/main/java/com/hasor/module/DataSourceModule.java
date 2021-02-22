package com.hasor.module;

import lombok.extern.slf4j.Slf4j;
import net.hasor.core.ApiBinder;
import net.hasor.core.DimModule;
import net.hasor.db.JdbcModule;
import net.hasor.db.Level;
import net.hasor.spring.SpringModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * 配置基于Spring的数据源模块
 * @author qinhuajiao
 * @date 2021年02月22日 09:07:21
 */
@Slf4j
@DimModule
@Component
public class DataSourceModule implements SpringModule {

    @Autowired
    private DataSource dataSource;

    /**
     * 配置数据源模块到Hasor
     * @param apiBinder
     * @throws Throwable
     */
    @Override
    public void loadModule(ApiBinder apiBinder) throws Throwable {
        apiBinder.installModule(new JdbcModule(Level.Full,this.dataSource));
    }
}
