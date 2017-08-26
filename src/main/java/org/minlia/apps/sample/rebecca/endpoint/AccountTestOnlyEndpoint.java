//package com.minlia.apps.sample.rebecca.endpoint;
//
//import AccountQueryRequestBody;
//import AccountDao;
//import AccountReadOnlyService;
//import com.minlia.cloud.body.StatefulBody;
//import com.minlia.cloud.body.impl.SuccessResponseBody;
//import com.minlia.cloud.constant.ApiPrefix;
//import com.minlia.cloud.query.specification.batis.body.ApiQueryRequestBody;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.web.PageableDefault;
//import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * Created by will on 8/17/17.
// */
//@RestController
//@RequestMapping(value =  ApiPrefix.V1+"account/test")
//@Api(tags = "Account Test", description = "账户测试接口")
//public class AccountTestOnlyEndpoint {
//
//    @Autowired
//    private AccountReadOnlyService accountReadOnlyService;
//    @Autowired
//    private AccountDao accountDao;
//
//    //    @PreAuthorize(value = "hasAnyAuthority('account.findAll')")
//    @ApiOperation(value = "手写SQL查询出分页带排序结果", notes = "手写SQL查询出分页带排序结果", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
//    @PostMapping(value = "findAllPageWithSort", produces = MediaType.APPLICATION_JSON_VALUE)
//    public StatefulBody findAllPageWithSort(@RequestBody ApiQueryRequestBody<AccountQueryRequestBody> body, @PageableDefault Pageable pageable) {
//        Page found = accountDao.findAllAccountsByXmlWithSort("%x%", pageable);
//        return SuccessResponseBody.builder().payload(found).build();
//    }
//
//    //    @PreAuthorize(value = "hasAnyAuthority('account.findAll')")
//    @ApiOperation(value = "手写SQL查询出分页结果", notes = "手写SQL查询出分页结果", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
//    @PostMapping(value = "findAllPage", produces = MediaType.APPLICATION_JSON_VALUE)
//    public StatefulBody findAllPage(@RequestBody ApiQueryRequestBody<AccountQueryRequestBody> body, @PageableDefault Pageable pageable) {
//        Page found = accountDao.findAllAccountsByXml("%x%", pageable);
//        return SuccessResponseBody.builder().payload(found).build();
//    }
//
//
//}
