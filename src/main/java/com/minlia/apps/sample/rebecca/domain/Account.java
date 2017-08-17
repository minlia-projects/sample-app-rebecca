package com.minlia.apps.sample.rebecca.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.minlia.cloud.entity.AbstractEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;

/**
 * Created by will on 8/17/17.
 */
@Entity
@Data
@ApiModel(value = "账户")
public class Account extends AbstractEntity {

    @ApiModelProperty("账户名称")
    @JsonProperty
    private String name;


}
