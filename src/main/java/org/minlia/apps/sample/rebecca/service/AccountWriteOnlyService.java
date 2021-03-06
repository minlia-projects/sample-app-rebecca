package org.minlia.apps.sample.rebecca.service;

import org.minlia.apps.sample.rebecca.dao.AccountDao;
import org.minlia.apps.sample.rebecca.domain.Account;
import com.minlia.cloud.service.WriteOnlyService;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by will on 8/17/17.
 */
@Transactional
public interface AccountWriteOnlyService extends WriteOnlyService<AccountDao, Account, Long> {

}
