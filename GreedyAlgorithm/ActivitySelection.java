package GreedyAlgorithm;

import java.util.ArrayList;
import java.util.List;

class Activity {
    int start, finish;

    // Constructor
    public Activity(int start, int finish) {
        this.start = start;
        this.finish = finish;
    }

    @Override
    public String toString() {
        return "(" + start + ", " + finish + ")";
    }
}

public class ActivitySelection {

    public static void sortActivity(Activity[] activities) {
        int n = activities.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n-1-i; j++) {
                if (activities[j].finish > activities[j+1].finish) {
                    Activity temp = activities[j];
                    activities[j] = activities[j+1];
                    activities[j+1] = temp;
                }
            }
        }
    }

    // Function to select the maximum number of activities
    public static List<Activity> selectActivities(Activity[] activities) {
        // Sort activities based on finish time
        sortActivity(activities);

        // List to store selected activities
        List<Activity> selectedActivities = new ArrayList<>();

        // Select the first activity
        selectedActivities.add(activities[0]);
        int lastFinishTime = activities[0].finish;

        // Iterate through the remaining activities
        for (int i = 1; i < activities.length; i++) {
            // If the current activity's start time is greater than or equal to the last finish time
            if (activities[i].start >= lastFinishTime) {
                selectedActivities.add(activities[i]);
                lastFinishTime = activities[i].finish; // Update the last finish time
            }
        }

        return selectedActivities;
    }

    public static void main(String[] args) {
        // Array of activities with start and finish times
        Activity[] activities = {
                new Activity(1, 4),
                new Activity(3, 5),
                new Activity(0, 6),
                new Activity(5, 7),
                new Activity(3, 8),
                new Activity(5, 9),
                new Activity(6, 10),
                new Activity(8, 11),
                new Activity(8, 12),
                new Activity(2, 13),
                new Activity(12, 14)
        };

        // Select the maximum number of activities
        List<Activity> selectedActivities = selectActivities(activities);

        // Print the selected activities
        System.out.println("Selected Activities:");
        for (Activity activity : selectedActivities) {
            System.out.println(activity);
        }
    }
}