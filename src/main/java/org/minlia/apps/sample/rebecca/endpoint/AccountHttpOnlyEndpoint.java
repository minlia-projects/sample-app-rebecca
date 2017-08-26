package org.minlia.apps.sample.rebecca.endpoint;

import org.minlia.apps.sample.rebecca.body.AccountQueryRequestBody;
import org.minlia.apps.sample.rebecca.dao.AccountDao;
import org.minlia.apps.sample.rebecca.domain.Account;
import org.minlia.apps.sample.rebecca.service.AccountReadOnlyService;
import org.minlia.apps.sample.rebecca.service.AccountWriteOnlyService;
import com.minlia.cloud.body.StatefulBody;
import com.minlia.cloud.body.impl.SuccessResponseBody;
import com.minlia.cloud.constant.ApiPrefix;
import com.minlia.cloud.query.specification.batis.body.ApiQueryRequestBody;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by will on 8/17/17.
 */
@RestController
@RequestMapping(value = ApiPrefix.V1+"account/http")
@Api(tags = "Account", description = "账户接口")
@Slf4j
public class AccountHttpOnlyEndpoint {

    @Autowired
    private AccountReadOnlyService accountReadOnlyService;

    @Autowired
    private AccountWriteOnlyService accountWriteOnlyService;

    @Autowired
    private AccountDao accountDao;

//    @Autowired
//    private RestTemplate restTemplate;

    //    @PreAuthorize(value = "hasAnyAuthority('account.findAll')")
    @ApiOperation(value = "手写SQL查询出分页带排序结果", notes = "手写SQL查询出分页带排序结果", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping(value = "findAllPageWithSort", produces = MediaType.APPLICATION_JSON_VALUE)
    public StatefulBody findAllPageWithSort(@RequestBody ApiQueryRequestBody<AccountQueryRequestBody> body, @PageableDefault Pageable pageable) {

        Account account = new Account();
        account.setName("XXLLSLSK");
        accountWriteOnlyService.save(account);

        //生成一个设置了连接超时时间、请求超时时间、异常最大重试次数的httpClient
        RequestConfig config = RequestConfig.custom().setConnectionRequestTimeout(10000).setConnectTimeout(10000).setSocketTimeout(30000).build();
        HttpClientBuilder builder = HttpClientBuilder.create().setDefaultRequestConfig(config).setRetryHandler(new DefaultHttpRequestRetryHandler(5, false));
        HttpClient httpClient = builder.build();
        //使用httpClient创建一个ClientHttpRequestFactory的实现
        ClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
        //ClientHttpRequestFactory作为参数构造一个使用作为底层的RestTemplate
        RestTemplate restTemplate = new RestTemplate(requestFactory);
//        restTemplate.getInterceptors().add(new AccessTokenInterceptor());

//        RestTemplate restTemplate=new RestTemplate();
        StatefulBody ret = restTemplate.postForObject("http://127.0.0.1:10001/api/account/read/findOne/1", null, StatefulBody.class);
//        return SuccessResponseBody.builder().payload(ret).build();
        log.debug("RequestRestTemplate with result: {}", ret);

        return ret;
    }

    //    @PreAuthorize(value = "hasAnyAuthority('account.findAll')")
    @ApiOperation(value = "手写SQL查询出分页结果", notes = "手写SQL查询出分页结果", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping(value = "findAllPage", produces = MediaType.APPLICATION_JSON_VALUE)
    public StatefulBody findAllPage(@RequestBody ApiQueryRequestBody<AccountQueryRequestBody> body, @PageableDefault Pageable pageable) {
        Page found = accountDao.findAllAccountsByXml("%x%", pageable);
        return SuccessResponseBody.builder().payload(found).build();
    }


}
