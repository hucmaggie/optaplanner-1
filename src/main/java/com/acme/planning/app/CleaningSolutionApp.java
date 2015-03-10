package com.acme.planning.app;

import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;
import org.optaplanner.core.api.solver.event.BestSolutionChangedEvent;
import org.optaplanner.core.api.solver.event.SolverEventListener;

import com.acme.planning.model.CleaningSolution;



public class CleaningSolutionApp {

	public static final String SOLVER_CONFIG = "com/acme/planner/solver/cleaningPlanSolverConfig.xml";

	public static void main(String[] args) {
		//new CleaningSolutionApp().init();
		new CleaningSolutionApp().createSolver();
	}

	protected Solver createSolver() {	
        SolverFactory solverFactory = SolverFactory.createFromXmlResource(SOLVER_CONFIG);
        Solver solver = solverFactory.buildSolver();
        solver.addEventListener(new SolverEventListener() {
            public void bestSolutionChanged(BestSolutionChangedEvent event) {
                CleaningSolution bestSolution = (CleaningSolution) event.getNewBestSolution();
            }
        });
		return solver;
	}
}