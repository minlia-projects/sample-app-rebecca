package org.minlia.apps.sample.rebecca.body;

import com.minlia.cloud.body.query.QueryOperator;
import com.minlia.cloud.query.body.QueryRequestBody;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * Created by will on 8/13/17.
 * 前端传入搜索参数时的请求体
 */
@ApiModel(value = "账户搜索")
@Data
public class AccountQueryRequestBody implements QueryRequestBody {

    private String name;
    private QueryOperator nameOperator;

}
