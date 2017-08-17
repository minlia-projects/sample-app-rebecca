package com.minlia.apps.sample.rebecca.dao;

import com.minlia.apps.sample.rebecca.domain.Account;
import com.minlia.cloud.dao.Dao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mybatis.repository.annotation.Query;

/**
 * Created by will on 8/17/17.
 */
public interface AccountDao extends Dao<Account, Long> {

    /**
     * 手写SQL查询出分页结果
     * 注意: 以下的@Query为必须注解项
     *
     * @param name
     * @param pageable
     * @return
     */
    @Query
    Page<Account> findAllAccountsByXmlWithSort(String name, Pageable pageable);


    /**
     * 手写SQL查询出分页结果
     * 注意: 以下的@Query为必须注解项
     *
     * @param name
     * @param pageable
     * @return
     */
    @Query
    Page<Account> findAllAccountsByXml(String name, Pageable pageable);

}
