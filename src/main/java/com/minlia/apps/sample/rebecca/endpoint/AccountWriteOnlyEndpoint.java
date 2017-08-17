package com.minlia.apps.sample.rebecca.endpoint;

import com.minlia.apps.sample.rebecca.domain.Account;
import com.minlia.apps.sample.rebecca.service.AccountWriteOnlyService;
import com.minlia.cloud.body.StatefulBody;
import com.minlia.cloud.body.impl.SuccessResponseBody;
import com.minlia.cloud.endpoint.ApiWriteOnlyEndpoint;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by will on 8/17/17.
 */
@RestController
@RequestMapping(value = "/api/account/write")
@Api(tags = "Account Write", description = "账户操作接口")
public class AccountWriteOnlyEndpoint implements ApiWriteOnlyEndpoint<Account, Long> {

    @Autowired
    private AccountWriteOnlyService accountWriteOnlyService;

    //    @PreAuthorize(value = "hasAnyAuthority('account.create')")
    @ApiOperation(value = "创建", notes = "创建", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping(value = "create", produces = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public StatefulBody create(@RequestBody Account account) {
        Account created = accountWriteOnlyService.save(account);
        return SuccessResponseBody.builder().payload(created).build();
    }

    //    @PreAuthorize(value = "hasAnyAuthority('account.update')")
    @ApiOperation(value = "更新", notes = "更新", httpMethod = "PUT", produces = MediaType.APPLICATION_JSON_VALUE)
    @PutMapping(value = "update", produces = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public StatefulBody update(@RequestBody Account account) {
        Account updated = accountWriteOnlyService.update(account);
        return SuccessResponseBody.builder().payload(updated).build();
    }

    //    @PreAuthorize(value = "hasAnyAuthority('account.delete')")
    @ApiOperation(value = "删除", notes = "删除", httpMethod = "DELETE", produces = MediaType.APPLICATION_JSON_VALUE)
    @DeleteMapping(value = "delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public StatefulBody delete(@PathVariable Long id) {
        accountWriteOnlyService.delete(id);
        return SuccessResponseBody.builder().build();
    }

}
