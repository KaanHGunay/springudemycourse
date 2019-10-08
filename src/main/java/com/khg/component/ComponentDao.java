package com.khg.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class ComponentDao {
    @Autowired
    private ComponentJdbcConnection componentJdbcConnection;

    public ComponentJdbcConnection getJdbcConnection() {
        return componentJdbcConnection;
    }

    public void setJdbcConnection(ComponentJdbcConnection componentJdbcConnection) {
        this.componentJdbcConnection = componentJdbcConnection;
    }
}
