package workout;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Workout {
    private String type;
    private int exerciseCount;
    private List<Exercise> exercises;

    public Workout(String type, int exerciseCount) {
        this.type = type;
        this.exerciseCount = exerciseCount;
        this.exercises = new ArrayList<>();
    }

    //•	Method addExercise(Exercise exercise) – adds an entity to the exercises If there is still space on the workout sheet (exerciseCount).
    public void addExercise(Exercise exercise){
        if (exercises.size() < exerciseCount){
            exercises.add(exercise);
        }
    }
    //•	Method removeExercise(String name, String muscle) – removes the exercise by given name and muscle, if such exists, and returns boolean.
    public boolean removeExercise(String name, String muscle){
        for (Exercise exercise : exercises) {
            if (exercise.getName().equals(name) && exercise.getMuscle().equals(muscle)){
                this.exercises.remove(exercise);
                return true;
            }
        }
        return false;
    }
    //•	Method getExercise(String name, String muscle) – returns the exercise with the given name and muscle or null if there is no such exercise.
    public Exercise getExercise(String name, String muscle){
        for (Exercise exercise : exercises) {
            if (exercise.getName().equals(name) && exercise.getMuscle().equals(muscle)){
                return exercise;
            }
        }
        return null;
    }
    //•	Method getMostBurnedCaloriesExercise() – returns the exercise which is burned the most calories or null if there are no exercises.
    public Exercise getMostBurnedCaloriesExercise() {
        return exercises.stream()
                .max(Comparator.comparingInt(Exercise::getBurnedCalories))
                .orElse(null);
    }
    //•	Getter getExerciseCount() – returns the number of exercises.
    public int getExerciseCount(){
        return exercises.size();
    }
    //•	getStatistics() – returns a String in the following format:
    //o	"Workout type: {workout type}
    //Exercise: {Exercise1}
    //Exercise: {Exercise2}
    //(…)"

    public String getStatistics(){
        StringBuilder statistics = new StringBuilder();
        statistics.append("Workout type: ").append(type).append("\n");
        for (Exercise exercise : exercises) {
            statistics.append(exercise.toString()).append("\n");
        }
        return statistics.toString().trim();
    }
}
