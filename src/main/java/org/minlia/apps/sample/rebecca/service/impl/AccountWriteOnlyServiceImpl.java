package org.minlia.apps.sample.rebecca.service.impl;

import org.minlia.apps.sample.rebecca.dao.AccountDao;
import org.minlia.apps.sample.rebecca.domain.Account;
import org.minlia.apps.sample.rebecca.service.AccountWriteOnlyService;
import com.minlia.cloud.service.AbstractWriteOnlyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Created by will on 8/17/17.
 */
@Service
@Slf4j
public class AccountWriteOnlyServiceImpl extends AbstractWriteOnlyService<AccountDao, Account, Long> implements
    AccountWriteOnlyService {

}
