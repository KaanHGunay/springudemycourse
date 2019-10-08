package com.khg.learningspring.cdi;

import javax.inject.Inject;
import javax.inject.Named;

// @Component
@Named
public class SomeCdiBusiness {

    // @Autowired
    @Inject
    private SomeCdiDao someCdiDao;

    public SomeCdiDao getSomeCdiDao() {
        return someCdiDao;
    }

    public void setSomeCdiDao(SomeCdiDao someCdiDao) {
        this.someCdiDao = someCdiDao;
    }
}
