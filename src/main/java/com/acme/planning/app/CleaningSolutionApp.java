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

		CleaningSolution unsolvedCleaningSolution = createCleaningSolution();
		solver.solve(unsolvedCleaningSolution);
		CleaningSolution solvedCloudBalance = (CleaningSolution) solver.getBestSolution();
		System.out.println("\nSolved CleaningProblem with 5 houses with 15 house cleaning spots and 7 cleaners for a week:\n"+toDisplayString(solvedCloudBalance));

	}
    public static String toDisplayString(CleaningSolution cleaningSolution) {
        StringBuilder displayString = new StringBuilder();
        for (HouseCleaningSpot houseCleaningSpot : cleaningSolution.getHouseCleaningSpotList()) {
            Cleaner cleaner = houseCleaningSpot.getCleaner();
            displayString.append("  House:::").append(houseCleaningSpot.getHouse().getId()).append(" -> ")
            .append("  HCSpot:::").append(houseCleaningSpot.getCleaningSpotIndex()).append(" -> ")
            .append("  Day:::").append(houseCleaningSpot.getHouse().getDayOfWeek().getDayId()).append(" -> ")
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
		//List<House> hslst =  createHouseList();

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


		
		Cleaner cleaner1 = new Cleaner(new Long(111), monday);
		Cleaner cleaner2 = new Cleaner(new Long(112), tuesday);
		Cleaner cleaner3 = new Cleaner(new Long(113), wednesday);
		Cleaner cleaner4 = new Cleaner(new Long(114), thursday);
		Cleaner cleaner5 = new Cleaner(new Long(115), thursday);
		Cleaner cleaner6 = new Cleaner(new Long(116), thursday);
		Cleaner cleaner7 = new Cleaner(new Long(117), thursday);

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
		
		DayOfWeek dayOfWeek1 = new DayOfWeek(new Long(1), "Monday");
		House house1 = new House(new Long(1111), "A", dayOfWeek1);
		HouseCleaningSpot houseCleaningSpot11 = new HouseCleaningSpot(new Long(11),house1, 101);
		HouseCleaningSpot houseCleaningSpot12 = new HouseCleaningSpot(new Long(12),house1, 102);
		HouseCleaningSpot houseCleaningSpot13 = new HouseCleaningSpot(new Long(13),house1, 103);
		
		
		DayOfWeek dayOfWeek2 = new DayOfWeek(new Long(2), "Tuesday");
		House house2 = new House(new Long(2222), "B", dayOfWeek1);
		HouseCleaningSpot houseCleaningSpot21 = new HouseCleaningSpot(new Long(21),house2, 201);
		HouseCleaningSpot houseCleaningSpot22 = new HouseCleaningSpot(new Long(22),house2, 202);	
	

		DayOfWeek dayOfWeek3 = new DayOfWeek(new Long(3), "Wednesday");
		House house3 = new House(new Long(3333), "C", dayOfWeek3);
		HouseCleaningSpot houseCleaningSpot31 = new HouseCleaningSpot(new Long(31),house3, 301);
		HouseCleaningSpot houseCleaningSpot32 = new HouseCleaningSpot(new Long(32),house3, 302);
		HouseCleaningSpot houseCleaningSpot33 = new HouseCleaningSpot(new Long(33),house3, 303);
		HouseCleaningSpot houseCleaningSpot34 = new HouseCleaningSpot(new Long(34),house3, 304);
		HouseCleaningSpot houseCleaningSpot35 = new HouseCleaningSpot(new Long(35),house3, 305);

		
		DayOfWeek dayOfWeek4 = new DayOfWeek(new Long(4), "Thursday");
		House house4 = new House(new Long(4444), "D", dayOfWeek4);
		HouseCleaningSpot houseCleaningSpot41 = new HouseCleaningSpot(new Long(41),house4, 401);
		HouseCleaningSpot houseCleaningSpot42 = new HouseCleaningSpot(new Long(42),house4, 402);
		
		DayOfWeek dayOfWeek5 = new DayOfWeek(new Long(5), "Friday");
		House house5 = new House(new Long(5555), "E", dayOfWeek3);
		HouseCleaningSpot houseCleaningSpot51 = new HouseCleaningSpot(new Long(51),house5, 501);
		HouseCleaningSpot houseCleaningSpot52 = new HouseCleaningSpot(new Long(52),house5, 502);
		HouseCleaningSpot houseCleaningSpot53 = new HouseCleaningSpot(new Long(53),house5, 503);
		
		houseCleaningSpotList.add(houseCleaningSpot11);
		houseCleaningSpotList.add(houseCleaningSpot12);
		houseCleaningSpotList.add(houseCleaningSpot13);
		
		houseCleaningSpotList.add(houseCleaningSpot21);
		houseCleaningSpotList.add(houseCleaningSpot22);
		
		houseCleaningSpotList.add(houseCleaningSpot31);
		houseCleaningSpotList.add(houseCleaningSpot32);
		houseCleaningSpotList.add(houseCleaningSpot33);
		houseCleaningSpotList.add(houseCleaningSpot34);
		houseCleaningSpotList.add(houseCleaningSpot35);
		
		houseCleaningSpotList.add(houseCleaningSpot41);
		houseCleaningSpotList.add(houseCleaningSpot42);
		
		houseCleaningSpotList.add(houseCleaningSpot51);
		houseCleaningSpotList.add(houseCleaningSpot52);
		houseCleaningSpotList.add(houseCleaningSpot53);

		
		System.out.println("Size of the houseCleaningSpotList list is ::: "+houseCleaningSpotList.size());

		return houseCleaningSpotList;
	}
/*
	public static List<House> createHouseList() {

		List<House> houseList = new ArrayList<House>();
		
		House house1 = new House("A", new DayOfWeek("Monday"));
		House house2 = new House("B", new DayOfWeek("Monday"));
		House house3 = new House("C", new DayOfWeek("Monday"));
		House house4 = new House("D", new DayOfWeek("Monday"));
		
		houseList.add(house1);
		houseList.add(house2);
		houseList.add(house3);
		houseList.add(house4);
		
		System.out.println("Size of the houseList list is ::: "+houseList.size());
		
		return houseList;
		
	}*/

}
