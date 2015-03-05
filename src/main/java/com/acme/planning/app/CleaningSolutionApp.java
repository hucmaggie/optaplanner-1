package com.acme.planning.app;

import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;

import com.acme.planning.common.app.CommonApp;
import com.acme.planning.common.persistence.SolutionDao;
import com.acme.planning.common.swingui.SolutionPanel;
import com.acme.planning.util.CleaningSolutionDao;



public class CleaningSolutionApp extends CommonApp {

	public static final String SOLVER_CONFIG = "/com/acme/planner/cleaningPlanSolverConfig.xml";

	public static void main(String[] args) {
		//fixateLookAndFeel();
		new CleaningSolutionApp().init();
	}

	public CleaningSolutionApp() {
		super(
				"Cloud balancing",
				"Assign processes to computers.\n\n"
						+ "Each computer must have enough hardware to run all of it's processes.\n"
						+ "Each used computer inflicts a maintenance cost.",
				CloudBalancingPanel.LOGO_PATH);
	}

	@Override
	protected Solver createSolver() {
		
        SolverFactory solverFactory = SolverFactory.createFromXmlResource(SOLVER_CONFIG);
        Solver solver = solverFactory.buildSolver();
		return solver;
	}

	@Override
	protected SolutionPanel createSolutionPanel() {
		return new CloudBalancingPanel();
	}

	@Override
	protected SolutionDao createSolutionDao() {
		return new CleaningSolutionDao();
	}

}
