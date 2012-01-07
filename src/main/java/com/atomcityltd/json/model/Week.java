package com.atomcityltd.json.model;

import com.google.common.collect.Lists;

import java.util.List;

public final class Week {
    private List<Task> tasks = Lists.newArrayList();
    private Week linked;

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public Week getLinked() {
        return linked;
    }

    public void setLinked(Week week) {
        this.linked = week;
    }
    
    public Week addTask(Task task) {
        tasks.add(task);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Week week = (Week) o;

        if (linked != null ? !linked.equals(week.linked) : week.linked != null) return false;
        if (tasks != null ? !tasks.equals(week.tasks) : week.tasks != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tasks != null ? tasks.hashCode() : 0;
        result = 31 * result + (linked != null ? linked.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Week{" +
                "tasks=" + tasks +
                ", linked=" + linked +
                '}';
    }
}
