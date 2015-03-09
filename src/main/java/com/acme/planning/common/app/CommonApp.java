/*
 * Copyright 2010 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.acme.planning.common.app;

import java.awt.Component;

import org.optaplanner.core.api.solver.Solver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.acme.planning.common.business.SolutionBusiness;
import com.acme.planning.common.persistence.AbstractSolutionExporter;
import com.acme.planning.common.persistence.AbstractSolutionImporter;
import com.acme.planning.common.persistence.SolutionDao;



public abstract class CommonApp extends LoggingMain {

    protected static final Logger logger = LoggerFactory.getLogger(CommonApp.class);

    /**
     * Some examples are not compatible with every native LookAndFeel.
     * For example, NurseRosteringPanel is incompatible with Mac.
     */


    protected final String name;
    protected final String description;
    protected final String iconResource;

    protected SolutionBusiness solutionBusiness;

    protected CommonApp(String name, String description, String iconResource) {
        this.name = name;
        this.description = description;
        this.iconResource = iconResource;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getIconResource() {
        return iconResource;
    }

    public void init() {
        init(null, true);
    }

    public void init(Component centerForComponent, boolean exitOnClose) {
        solutionBusiness = createSolutionBusiness();
    }

    public SolutionBusiness createSolutionBusiness() {
        SolutionBusiness solutionBusiness = new SolutionBusiness();
        solutionBusiness.updateDataDirs();
        solutionBusiness.setSolver(createSolver());
        return solutionBusiness;
    }
    protected abstract Solver createSolver();
}
