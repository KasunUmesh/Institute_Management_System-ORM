package views.tm;

public class CourseTm {
    private String programId;
    private String programDetail;
    private String duration;
    private double programFree;

    public CourseTm() {
    }

    public CourseTm(String programId, String programDetail, String duration, double programFree) {
        this.programId = programId;
        this.programDetail = programDetail;
        this.duration = duration;
        this.programFree = programFree;
    }

    public String getProgramId() {
        return programId;
    }

    public void setProgramId(String programId) {
        this.programId = programId;
    }

    public String getProgramDetail() {
        return programDetail;
    }

    public void setProgramDetail(String programDetail) {
        this.programDetail = programDetail;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public double getProgramFree() {
        return programFree;
    }

    public void setProgramFree(double programFree) {
        this.programFree = programFree;
    }

    @Override
    public String toString() {
        return "CourseTm{" +
                "programId='" + programId + '\'' +
                ", programDetail='" + programDetail + '\'' +
                ", duration='" + duration + '\'' +
                ", programFree=" + programFree +
                '}';
    }
}
