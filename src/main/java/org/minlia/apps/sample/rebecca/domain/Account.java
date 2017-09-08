package org.minlia.apps.sample.rebecca.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.minlia.cloud.entity.AbstractEntity;
import com.minlia.modules.rbac.domain.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import lombok.Data;

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

//  /**
//   * 第1种使用方式, 推荐使用, 在关系较复杂的业务时比较方便灵活性的控制哪些属性需要赋值
//   */
//  @ApiModelProperty("系统用户ID")
//  @JsonIgnore
//  private Long userId;
//
//  /**
//   * 查询时用于承载userId查询出来的结果
//   */
//  @JsonIgnore
//  @Transient
//  private User user;
//
//  public User getUser() {
//    return user;
//  }
//
//  public void setUser(User user) {
//    this.user = user;
//  }

  /**
   * 第2种使用方式, 简单业务场景下使用
   */
  @OneToOne(targetEntity = User.class)
  @JoinColumn(name = "user_id")
  @ApiModelProperty("系统用户ID")
  @JsonIgnore
  private User user;



}
