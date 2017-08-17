package com.minlia.apps.sample.rebecca.service;

import com.minlia.apps.sample.rebecca.dao.AccountDao;
import com.minlia.apps.sample.rebecca.domain.Account;
import com.minlia.cloud.service.ReadOnlyService;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by will on 8/17/17.
 */
@Transactional(readOnly = true)
public interface AccountReadOnlyService extends ReadOnlyService<AccountDao, Account, Long> {

}
