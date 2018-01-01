package org.minlia.apps.sample.rebecca.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestMapperTest {

	@Autowired
  private TestMapper testMapper;

	@Test
	public void testInsert() throws Exception {
		testMapper.count( );
//		testMapper.insert(new UserEntity("bb", "b123456", UserSexEnum.WOMAN));
//		testMapper.insert(new UserEntity("cc", "b123456", UserSexEnum.WOMAN));

//		Assert.assertEquals(3, testMapper.getAll().size());
	}

//	@Test
//	public void testQuery() throws Exception {
//		List<UserEntity> users = testMapper.getAll();
//		System.out.println(users.toString());
//	}
//
//	@Test
//	public void testUpdate() throws Exception {
//		UserEntity user = testMapper.getOne(3l);
//		System.out.println(user.toString());
//		user.setNickName("neo");
//		testMapper.update(user);
//		Assert.assertTrue(("neo".equals(testMapper.getOne(3l).getNickName())));
//	}
}