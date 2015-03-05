package com.acme.planning.util;

import com.acme.planning.common.persistence.XStreamSolutionDao;
import com.acme.planning.model.CleaningSolution;


public class CleaningSolutionDao extends XStreamSolutionDao {

    public CleaningSolutionDao() {
        super("planning", CleaningSolution.class);
    }

}
