package cat.itb.testingAnApp.Data;

import java.io.Serializable;
import java.util.Date;

public class Grade implements Serializable {
    String studentName;
    String module;
    boolean assistance;
    double grade;
    Date dateOfGrading;

    public Grade(String studentName, String module, boolean assistance, double grade, Date dateOfGrading) {
        this.studentName = studentName;
        this.module = module;
        this.assistance = assistance;
        this.grade = grade;
        this.dateOfGrading = dateOfGrading;
    }

    public Grade() {
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public boolean isAssistance() {
        return assistance;
    }

    public void setAssistance(boolean assistance) {
        this.assistance = assistance;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Date getDateOfGrading() {
        return dateOfGrading;
    }

    public void setDateOfGrading(Date dateOfGrading) {
        this.dateOfGrading = dateOfGrading;
    }
}
