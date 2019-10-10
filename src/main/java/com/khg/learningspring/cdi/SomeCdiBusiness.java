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

    public int findGreatest() {
        int greatest = Integer.MIN_VALUE;
        int[] data = someCdiDao.getData();

        for (int value :
                data) {
            if (greatest < value) greatest = value;
        }
        return greatest;
    }
}
