package com.acme.planning.app;

import java.util.ArrayList;
import java.util.List;

import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;
import org.optaplanner.core.api.solver.event.BestSolutionChangedEvent;
import org.optaplanner.core.api.solver.event.SolverEventListener;

import com.acme.planning.model.Cleaner;
import com.acme.planning.model.CleaningSolution;
import com.acme.planning.model.DayOfWeek;
import com.acme.planning.model.House;
import com.acme.planning.model.HouseCleaningSpot;

public class CleaningSolutionApp {

	public static final String SOLVER_CONFIG = "com/acme/planner/solver/cleaningPlanSolverConfig.xml";

	public static void main(String[] args) {

		Solver solver = new CleaningSolutionApp().createSolver();
//okkkokoko
		CleaningSolution unsolvedCleaningSolution = createCleaningSolution();
		solver.solve(unsolvedCleaningSolution);
		CleaningSolution solvedCloudBalance = (CleaningSolution) solver.getBestSolution();
		System.out.println("\nSolved cloudBalance with 400 computers and 1200 processes:\n"+toDisplayString(solvedCloudBalance));

	}
    public static String toDisplayString(CleaningSolution cleaningSolution) {
        StringBuilder displayString = new StringBuilder();
        for (HouseCleaningSpot houseCleaningSpot : cleaningSolution.getHouseCleaningSpotList()) {
            Cleaner cleaner = houseCleaningSpot.getCleaner();
            displayString.append("  HCSpot:::").append(houseCleaningSpot.getCleaningSpotIndex()).append(" -> ")
            .append("  Day:::").append(houseCleaningSpot.getHouse().getDayOfWeek().getDayId()).append(" -> ")
            .append("  House:::").append(houseCleaningSpot.getHouse().getId()).append(" -> ")
            .append("  Cleaner:::").append(cleaner == null ? null : cleaner.getId()).append("\n");
        }
        return displayString.toString();
    }
	protected Solver createSolver() {
		SolverFactory solverFactory = SolverFactory
				.createFromXmlResource(SOLVER_CONFIG);
		Solver solver = solverFactory.buildSolver();
		solver.addEventListener(new SolverEventListener() {
			public void bestSolutionChanged(BestSolutionChangedEvent event) {
				CleaningSolution bestSolution = (CleaningSolution) event
						.getNewBestSolution();
			}
		});
		return solver;
	}

	private static CleaningSolution createCleaningSolution() {
		CleaningSolution unsolvedCleaningProblem = new CleaningSolution();
		
		List<Cleaner> clist = createCleaners();
		List<HouseCleaningSpot> hsclist = createHouseCleaningSpot();
		List<House> hslst =  createHouseList();

		unsolvedCleaningProblem.setCleanerList(clist);
		unsolvedCleaningProblem.setHouseCleaningSpotList(hsclist);

		return unsolvedCleaningProblem;

	}

	public static List<Cleaner> createCleaners() {
		// Random random = new Random(System.currentTimeMillis());
		List<Cleaner> cleanersList = new ArrayList<Cleaner>();
		
		DayOfWeek monday = new DayOfWeek("Monday");
		DayOfWeek tuesday = new DayOfWeek("Tuesday");
		DayOfWeek wednesday = new DayOfWeek("Wednesday");
		DayOfWeek thursday = new DayOfWeek("Thursday");
		DayOfWeek friday = new DayOfWeek("Friday");


		
		Cleaner cleaner1 = new Cleaner(1, monday);
		Cleaner cleaner2 = new Cleaner(2, tuesday);
		Cleaner cleaner3 = new Cleaner(3, wednesday);
		Cleaner cleaner4 = new Cleaner(4, thursday);
		Cleaner cleaner5 = new Cleaner(5, tuesday);
		Cleaner cleaner6 = new Cleaner(6, monday);
		Cleaner cleaner7 = new Cleaner(7, monday);

		cleanersList.add(cleaner1);
		cleanersList.add(cleaner2);
		cleanersList.add(cleaner3);
		cleanersList.add(cleaner4);
		cleanersList.add(cleaner5);
		cleanersList.add(cleaner6);
		cleanersList.add(cleaner7);
		System.out.println("Size of the cleaners list is ::: "+cleanersList.size());

		return cleanersList;
	}

	public static List<HouseCleaningSpot> createHouseCleaningSpot() {
		// Random random = new Random(System.currentTimeMillis());
		List<HouseCleaningSpot> houseCleaningSpotList = new ArrayList<HouseCleaningSpot>();
		
		DayOfWeek dayOfWeek1 = new DayOfWeek("Monday");
		House house1 = new House("A", dayOfWeek1);
		HouseCleaningSpot houseCleaningSpot11 = new HouseCleaningSpot(house1, 1);
		HouseCleaningSpot houseCleaningSpot12 = new HouseCleaningSpot(house1, 2);
		HouseCleaningSpot houseCleaningSpot13 = new HouseCleaningSpot(house1, 3);
		
		
		DayOfWeek dayOfWeek2 = new DayOfWeek("Tuesday");
		House house2 = new House("B", dayOfWeek2);
		HouseCleaningSpot houseCleaningSpot21 = new HouseCleaningSpot(house2, 1);
		HouseCleaningSpot houseCleaningSpot22 = new HouseCleaningSpot(house2, 2);	
	

		DayOfWeek dayOfWeek3 = new DayOfWeek("Wednesday");
		House house3 = new House("C", dayOfWeek3);
		HouseCleaningSpot houseCleaningSpot31 = new HouseCleaningSpot(house3, 1);
		HouseCleaningSpot houseCleaningSpot32 = new HouseCleaningSpot(house3, 2);
		
		houseCleaningSpotList.add(houseCleaningSpot11);
		houseCleaningSpotList.add(houseCleaningSpot12);
		houseCleaningSpotList.add(houseCleaningSpot13);
		houseCleaningSpotList.add(houseCleaningSpot21);
		houseCleaningSpotList.add(houseCleaningSpot22);
		houseCleaningSpotList.add(houseCleaningSpot31);
		houseCleaningSpotList.add(houseCleaningSpot32);
		
		System.out.println("Size of the houseCleaningSpotList list is ::: "+houseCleaningSpotList.size());

		return houseCleaningSpotList;
	}

	public static List<House> createHouseList() {

		List<House> houseList = new ArrayList<House>();
		
		House house1 = new House("A", new DayOfWeek("Monday"));
		House house2 = new House("B", new DayOfWeek("Monday"));
		House house3 = new House("C", new DayOfWeek("Monday"));
		
		houseList.add(house1);
		houseList.add(house2);
		houseList.add(house3);
		
		System.out.println("Size of the houseList list is ::: "+houseList.size());
		
		return houseList;
		
	}

}
