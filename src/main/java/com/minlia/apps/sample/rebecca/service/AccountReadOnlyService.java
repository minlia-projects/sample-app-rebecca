package com.minlia.apps.sample.rebecca.service;

import com.minlia.apps.sample.rebecca.dao.AccountDao;
import com.minlia.apps.sample.rebecca.domain.Account;
import com.minlia.cloud.service.ReadOnlyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by will on 8/17/17.
 */
@Transactional(readOnly = true)
public interface AccountReadOnlyService extends ReadOnlyService<AccountDao, Account, Long> {


    /**
     * 手写SQL查询出分页结果
     * @param name
     * @param pageable
     * @return
     */
    Page<Account> findAllAccountsByXmlWithSort(String name, Pageable pageable);



    /**
     * 手写SQL查询出分页结果
     * @param name
     * @param pageable
     * @return
     */
    Page<Account> findAllAccountsByXml(String name, Pageable pageable);

}
