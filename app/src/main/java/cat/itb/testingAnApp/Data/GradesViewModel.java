package cat.itb.testingAnApp.Data;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class GradesViewModel extends ViewModel {
    public static List<Grade> gradings = new ArrayList<Grade>();

    Grade[] grades = {
            new Grade("Joan Puigcerver", "M7", false, 4.9, new Date()),
            new Grade("Jordi Cido", "M7", true, 10, new Date()),
            new Grade("Montse Madridejos", "M7", true, 9.9, new Date()),
            new Grade("Dani Santiago", "M7", false, 5, new Date()),
            new Grade("Marc Vives", "M7", true, 7.5, new Date()),
            new Grade("Laura Villalba", "M7", true, 8, new Date()),
            new Grade("Eduard Fornés", "M7", false, 5.5, new Date()),
            new Grade("Javier Amaya", "M7", true, 8.9, new Date()),
            new Grade("Montse Calopa", "M7", true, 9.9, new Date()),
            new Grade("Victor Marquina", "M7", false, 6.8, new Date()),
            new Grade("Jordi Cido", "M6", true, 10, new Date()),
            new Grade("Jordi Cido", "M8", false, 10, new Date()),
            new Grade("Jordi Cido", "M9", true, 10, new Date()),
            new Grade("Jordi Cido", "M16", true, 10, new Date()),
            new Grade("Jordi Cido", "M3", true, 10, new Date()),
    };

    public GradesViewModel() {
        Collections.addAll(gradings, grades);
    }
}
