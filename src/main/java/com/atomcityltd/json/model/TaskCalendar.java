package com.atomcityltd.json.model;

import com.google.common.collect.Lists;

import java.util.List;

public final class TaskCalendar {
    private List<Week> weeks = Lists.newArrayList();

    public List<Week> getWeeks() {
        return weeks;
    }

    public void setWeeks(List<Week> weeks) {
        this.weeks = weeks;
    }
    
    public TaskCalendar addWeek(Week week) {
        weeks.add(week);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TaskCalendar that = (TaskCalendar) o;

        if (weeks != null ? !weeks.equals(that.weeks) : that.weeks != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return weeks != null ? weeks.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "TaskCalendar{" +
                "weeks=" + weeks +
                '}';
    }
}
