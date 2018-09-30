package wy.addons.zcgl.biz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import wy.addons.zcgl.biz.service.ITestService;
import wy.common.constant.DSEnum;
import wy.common.persistence.dao.TestMapper;
import wy.common.persistence.model.Test;
import wy.core.mutidatasource.annotion.DataSource;

/**
 * 测试服务
 *
 * @author wyframe
 * @date 2017-06-23 23:02
 */
@Service
public class TestServiceImpl implements ITestService {


    @Autowired
    TestMapper testMapper;

    @Override
    @DataSource(name = DSEnum.DATA_SOURCE_BIZ)
    public void testBiz() {
        Test test = testMapper.selectById(1);
        test.setId(22);
        test.insert();
    }


    @Override
    @DataSource(name = DSEnum.DATA_SOURCE_GUNS)
    public void testGuns() {
        Test test = testMapper.selectById(1);
        test.setId(33);
        test.insert();
    }

    @Override
    @Transactional
    public void testAll() {
        testBiz();
        testGuns();
        //int i = 1 / 0;
    }

}
