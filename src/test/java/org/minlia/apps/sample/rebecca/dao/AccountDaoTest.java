package org.minlia.apps.sample.rebecca.dao;

import org.minlia.apps.sample.rebecca.AbstractTest;
import org.minlia.apps.sample.rebecca.domain.Account;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * Created by will on 8/26/17.
 */
@Slf4j
public class AccountDaoTest extends AbstractTest {


  @Autowired
  AccountDao accountDao;


  @Before
  public void setUp() throws Exception {
  }

  @After
  public void tearDown() throws Exception {
  }



  @Test
  public void findAllAccountsByXmlWithSort() throws Exception {
    Page<Account> pageFound = accountDao.findAllAccountsByXmlWithSort("x", new PageRequest(0, 10));
    log.debug("xxx {}", pageFound);

  }

  @Test
  public void findAllAccountsByXml() throws Exception {
  }

}