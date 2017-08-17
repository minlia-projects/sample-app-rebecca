package com.minlia.apps.sample.rebecca.service.impl;

import com.minlia.apps.sample.rebecca.dao.AccountDao;
import com.minlia.apps.sample.rebecca.domain.Account;
import com.minlia.apps.sample.rebecca.service.AccountReadOnlyService;
import com.minlia.cloud.service.AbstractReadOnlyService;
import org.springframework.stereotype.Service;

/**
 * Created by will on 8/17/17.
 */
@Service
public class AccountReadOnlyServiceImpl extends AbstractReadOnlyService<AccountDao, Account, Long> implements AccountReadOnlyService {

}
