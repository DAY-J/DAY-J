package com.capstone.projectname.plan;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;

@Entity
public class Plan {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(nullable = false)
    @ColumnDefault("0")
    private boolean isComplete;
    
    @Column(nullable = false)
    private LocalDate planAlarmDate;
    @Column(nullable = false)
    private LocalDate planCreateDate;
    
    @Column(nullable = false)
    private String planTag;
    @Column(nullable = false)
    private String goal;
    
    @Column(nullable = true)
    private String planPhoto;
    
    @Column(nullable = false)
    private LocalDate planTime;
    
    @Column(nullable = false)
    private LocalDate planDay;
    
    
    public Plan() {
    }
    
    public Plan(int id, boolean isComplete, LocalDate planAlarmDate, LocalDate planCreateDate, String planTag, String goal, String planPhoto, LocalDate planTime, LocalDate planDay) {
        this.id = id;
        this.isComplete = isComplete;
        this.planAlarmDate = planAlarmDate;
        this.planCreateDate = planCreateDate;
        this.planTag = planTag;
        this.goal = goal;
        this.planPhoto = planPhoto;
        this.planTime = planTime;
        this.planDay = planDay;
        
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public boolean isComplete() {
        return isComplete;
    }
    
    public void setComplete(boolean isComplete) {
        this.isComplete = isComplete;
    }
    
    public LocalDate getPlanAlarmDate() {
        return planAlarmDate;
    }
    
    public void setPlanAlarmDate(LocalDate planAlarmDate) {
        this.planAlarmDate = planAlarmDate;
    }
    
    public LocalDate getPlanCreateDate() {
        return planCreateDate;
    }
    
    public void setPlanCreateDate(LocalDate planCreateDate) {
        this.planCreateDate = planCreateDate;
    }
    
    public String getPlanTag() {
        return planTag;
    }
    
    public void setPlanTag(String planTag) {
        this.planTag = planTag;
    }
    
    public String getGoal() {
        return goal;
    }
    
    public void setGoal(String goal) {
        this.goal = goal;
    }
    
    public String getPlanPhoto() {
        return planPhoto;
    }
    
    public void setPlanPhoto(String planPhoto) {
        this.planPhoto = planPhoto;
    }
    
    public LocalDate getPlanTime() {
        return planTime;
    }
    
    public void setPlanTime(LocalDate planTime) {
        this.planTime = planTime;
    }
    
    public LocalDate getPlanDay() {
        return planDay;
    }
    
    public void setPlanDay(LocalDate planDay) {
        this.planDay = planDay;
    }
    
    @Override
    public String toString() {
        return "Plan{" +
                "id=" + id +
                ", isComplete=" + isComplete +
                ", planAlarmDate=" + planAlarmDate +
                ", planCreateDate=" + planCreateDate +
                ", planTag='" + planTag + '\'' +
                ", goal='" + goal + '\'' +
                ", planPhoto='" + planPhoto + '\'' +
                ", planTime=" + planTime +
                ", planDay=" + planDay +
                '}';
    }
}

