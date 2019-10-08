package com.khg.learningspring.scope;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS)
// Her instance alındığında yeni bir bağlantı açılması isteniyorsa proxyMode düzenlenleli
// Bu yapılmazsa üst classın scope değeri geçerli oalcaktır.
public class JdbcConnection {
    public JdbcConnection() {
        System.out.println("JDBC Connected.");
    }
}
