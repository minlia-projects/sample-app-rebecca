package com.minlia.apps.sample.rebecca.endpoint;

import com.minlia.apps.sample.rebecca.body.AccountQueryRequestBody;
import com.minlia.apps.sample.rebecca.domain.Account;
import com.minlia.apps.sample.rebecca.service.AccountReadOnlyService;
import com.minlia.cloud.body.StatefulBody;
import com.minlia.cloud.body.impl.SuccessResponseBody;
import com.minlia.cloud.endpoint.ApiReadOnlyEndpoint;
import com.minlia.cloud.query.specification.batis.body.ApiQueryRequestBody;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by will on 8/17/17.
 */
@RestController
@RequestMapping(value = "/api/account/read")
@Api(tags = "账户查询接口", description = "账户查询接口")
public class AccountReadOnlyEndpoint implements ApiReadOnlyEndpoint<AccountQueryRequestBody, Account, Long> {

    @Autowired
    private AccountReadOnlyService accountReadOnlyService;

    @PreAuthorize(value = "hasAnyAuthority('account.findAll')")
    @ApiOperation(value = "根据条件查询分页结果", notes = "根据条件查询分页结果", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping(value = "findAllPage", produces = MediaType.APPLICATION_JSON_VALUE)
    public StatefulBody findAll(@RequestBody ApiQueryRequestBody<AccountQueryRequestBody> body, Pageable pageable) {
        Page found = accountReadOnlyService.findAll(body, pageable);
        return SuccessResponseBody.builder().payload(found).build();
    }

    @PreAuthorize(value = "hasAnyAuthority('account.findAll')")
    @ApiOperation(value = "根据条件查询集合结果", notes = "根据条件查询集合结果", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping(value = "findAllList", produces = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public SuccessResponseBody findAll(ApiQueryRequestBody<AccountQueryRequestBody> body) {
//        List found = accountReadOnlyService.findAll(body);
//        return SuccessResponseBody.builder().payload(found).build();
        return SuccessResponseBody.builder().build();
    }

    @PreAuthorize(value = "hasAnyAuthority('account.findOne')")
    @ApiOperation(value = "根据条件查询单个结果", notes = "根据条件查询单个结果", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping(value = "findOne", produces = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public StatefulBody findOne(Long id) {
        Account found = accountReadOnlyService.getOne(id);
        return SuccessResponseBody.builder().payload(found).build();
    }

}
