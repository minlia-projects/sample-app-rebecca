package org.minlia.apps.sample.rebecca;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by will on 8/26/17.
 * 单元测试父类
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})//,webEnvironment = WebEnvironment.RANDOM_PORT)
public class AbstractTest {

}
