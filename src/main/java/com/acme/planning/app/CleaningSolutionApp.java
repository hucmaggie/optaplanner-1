package com.acme.planning.app;

import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;

import com.acme.planning.common.app.CommonApp;



public class CleaningSolutionApp extends CommonApp {

	public static final String SOLVER_CONFIG = "com/acme/planner/solver/cleaningPlanSolverConfig.xml";

	public static void main(String[] args) {
		new CleaningSolutionApp().init();
	}

	public CleaningSolutionApp() {
		super("a", "a", "a");
	}

	@Override
	protected Solver createSolver() {
		
        SolverFactory solverFactory = SolverFactory.createFromXmlResource(SOLVER_CONFIG);
        Solver solver = solverFactory.buildSolver();
		return solver;
	}
}