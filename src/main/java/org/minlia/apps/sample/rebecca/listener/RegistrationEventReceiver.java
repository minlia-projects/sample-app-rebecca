package org.minlia.apps.sample.rebecca.listener;

import com.minlia.modules.rbac.domain.User;
import com.minlia.modules.rbac.event.RegistrationEvent;
import org.minlia.apps.sample.rebecca.domain.Account;
import org.minlia.apps.sample.rebecca.service.AccountWriteOnlyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * 注册事件监听器
 * 进行系统用户注册完成后的事件监听
 * 完成后费账户初始化工作
 * Created by will on 9/5/17.
 */
@Component
public class RegistrationEventReceiver {


  @Autowired
  AccountWriteOnlyService accountWriteOnlyService;

  /**
   * 当调用源有事务的时候才需要使用TransactionalEventListener, 无事务的时候是不会调用的, 需要使用EventListener
   *
   * @Async
   * @TransactionalEventListener
   */
  @EventListener
  public void onComplete(RegistrationEvent<User> event) {
//    Long userId = (Long) event.getSource();
    User user=(User)event.getSource();
    //绑定用户到Account
    //实际是创建一个新的Account
    Account account = new Account();
    account.setUser(user);
    accountWriteOnlyService.save(account);
  }

}
