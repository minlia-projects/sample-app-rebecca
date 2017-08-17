package com.minlia.apps.sample.rebecca.service.impl;

import com.minlia.apps.sample.rebecca.dao.AccountDao;
import com.minlia.apps.sample.rebecca.domain.Account;
import com.minlia.apps.sample.rebecca.service.AccountWriteOnlyService;
import com.minlia.cloud.service.AbstractWriteOnlyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Created by will on 8/17/17.
 */
@Service
@Slf4j
public class AccountWriteOnlyServiceImpl extends AbstractWriteOnlyService<AccountDao, Account, Long> implements AccountWriteOnlyService {

}
