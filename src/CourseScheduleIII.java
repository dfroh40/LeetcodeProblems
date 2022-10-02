import java.util.*;

public class CourseScheduleIII {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, Comparator.comparingInt(row -> row[1]));
        int currTotalTime = 0;
        int total = 0;
        for(int i = 0; i < courses.length; i++){
            if(currTotalTime + courses[i][0] <= courses[i][1]){
                total++;
                currTotalTime += courses[i][0];
            }
        }
        return total;
    }
}
