package Lab_9_1.TestRace;

import Lab_9_1.AbstractAnimal.AnimalTemplate;

import java.util.*;

public class RaceControl {

    private final static double TRACK_LENGTH = 10_000.00D;
    private final static Random random = new Random();
    private final static int MAX_NUMBER_OF_SELECT_ANIMAL = 6;

    private static int countTigerWin = 0;
    private static int countHorseWin = 0;
    private static int countElephantWin = 0;

    private final HashMap<String, List<AnimalTemplate>> animalMap;
    private final List<AnimalTemplate> filterredList;

    public RaceControl(HashMap<String, List<AnimalTemplate>> animalMap) {
        this.animalMap = animalMap;
        this.filterredList = filterAnimalList();
    }

    /* filterAnimalList() traverses the HashMap animalMap then
     * return the list of animal allowed to join the race */
    private List<AnimalTemplate> filterAnimalList() {
        List<AnimalTemplate> filterredList = new ArrayList<>();
        AnimalTemplate animal;
        for (String mapKey : animalMap.keySet()) {
            for (int index = 0; index < animalMap.get(mapKey).size(); index++) {
                animal = animalMap.get(mapKey).get(index);
                if (animal.isAllowToRace()) { filterredList.add(animal); }
            }
        }
        return filterredList;
    }

    public String getFinalResult() {
        String winnerName = null;
        boolean isTigerWin = countTigerWin > Math.max(countHorseWin, countElephantWin);
        boolean isHorseWin = countHorseWin > Math.max(countTigerWin, countElephantWin);
        boolean isElephantWin = countElephantWin > Math.max(countTigerWin, countHorseWin);
        System.out.println("-------------------------------END THE RACE-------------------------------");
        if (isTigerWin) {
            System.out.println("The Tiger species win the race");
            winnerName = AnimalSpecies.TIGER.toString();
        } else if (isHorseWin) {
            System.out.println("The Horse species win the race");
            winnerName = AnimalSpecies.HORSE.toString();
        } else if (isElephantWin) {
            System.out.println("The Elephant species win the race");
            winnerName = AnimalSpecies.ELEPHANT.toString();
        }
        return winnerName;
    }

    /* startLapSimulator() will put a list of 6 random animals race for totalLaps
     * Each time, a new list of 6 random selected animals will be used */
    public void startLapSimulator(int totalLaps) {
        List<AnimalTemplate> selectedAnimalList;
        AnimalTemplate winner;
        String species;
        String message;
        int round = 0;
        System.out.println("-------------------------------START THE RACE-------------------------------");
        do {
            selectedAnimalList = randomSelectAnimalList(totalLaps);
            winner = findWinnerPerRound(selectedAnimalList);
            species = winner.getClass().getSimpleName().toUpperCase();
            countWinTimes(species);
            round++;
            message = String.format(" is win the " + round + " round with time %.2fs {join the race %d time(s)}.",
                    calcRunningTime(winner), winner.getRaceTime());
            System.out.println(winner + message);
        } while (round < totalLaps);
    }

    private void countWinTimes(String species) {
        switch (AnimalSpecies.valueOf(species)) {
            case TIGER -> countTigerWin++;
            case HORSE -> countHorseWin++;
            case ELEPHANT -> countElephantWin++;
        }
    }

    /* findWinnerPerRound() helps to find the fastest animal in a round */
    private AnimalTemplate findWinnerPerRound(List<AnimalTemplate> filterredList) {
        AnimalTemplate winner = null;
        for (AnimalTemplate animal : filterredList) {
            if (winner == null) {
                winner = animal;
            } else {
                if (calcRunningTime(winner) > calcRunningTime(animal)) {
                    winner = animal;
                }
            }
        }
        return winner;
    }

    private double calcRunningTime(AnimalTemplate animal) { return (TRACK_LENGTH / animal.getSpeed()); }

    /* randomSelectAnimalList() has this.filterredList shuffled and select a random animal
     * The selected animal will be put into the randomList and finally return for racing purpose */
    private List<AnimalTemplate> randomSelectAnimalList(int totalLaps) {
        List<AnimalTemplate> randomList = new ArrayList<>();
        String animalInstance;
        int countTiger = 0, countHorse = 0, countElephant = 0;
        int randomIndex;
        AnimalTemplate animal;
        boolean isSelecting = true;

        while (isSelecting) {
            if (randomList.size() == MAX_NUMBER_OF_SELECT_ANIMAL) {isSelecting = false;}
            Collections.shuffle(this.filterredList);
            randomIndex = random.nextInt(this.filterredList.size());
            animal = this.filterredList.get(randomIndex);
            animalInstance = animal.getClass().getSimpleName().toUpperCase();
            // One animal is not allowed to join more than one half (1/2) of total laps
            boolean isRejoin = animal.getRaceTime() < (totalLaps / 2);

            switch (AnimalSpecies.valueOf(animalInstance)) {
                case HORSE:
                    if (countHorse < 2) {
                        countHorse = countAddTimes(randomList , countHorse , animal , isRejoin);
                    }
                    break;
                case TIGER:
                    if (countTiger < 2) {
                        countTiger = countAddTimes(randomList , countTiger , animal , isRejoin);
                    }
                    break;
                case ELEPHANT:
                    if (countElephant < 2) {
                        countElephant = countAddTimes(randomList , countElephant , animal , isRejoin);
                    }
                    break;
            }
        }
        return randomList;
    }

    private int countAddTimes(List<AnimalTemplate> list , int countNum , AnimalTemplate animal , boolean isQualify) {
        if (!list.contains(animal) && isQualify) {
            list.add(animal);
            animal.setRaceTime();
            countNum++;
        }
        return countNum;
    }

    /* The Enum AnimalSpecies is for various usages purpose*/
    private enum AnimalSpecies {
        ELEPHANT,
        HORSE,
        TIGER
    }

}

