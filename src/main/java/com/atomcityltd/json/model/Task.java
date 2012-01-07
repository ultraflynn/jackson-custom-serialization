package com.atomcityltd.json.model;

public final class Task {
    private String description;
    private int estimateDuration;
    private String notes;
    private String confidential;

    public Task(String description, int estimateDuration, String notes, String confidential) {
        this.description = description;
        this.estimateDuration = estimateDuration;
        this.notes = notes;
        this.confidential = confidential;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getEstimateDuration() {
        return estimateDuration;
    }

    public void setEstimateDuration(int estimateDuration) {
        this.estimateDuration = estimateDuration;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getConfidential() {
        return confidential;
    }

    public void setConfidential(String confidential) {
        this.confidential = confidential;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        if (estimateDuration != task.estimateDuration) return false;
        if (description != null ? !description.equals(task.description) : task.description != null) return false;
        if (notes != null ? !notes.equals(task.notes) : task.notes != null) return false;
        if (confidential != null ? !confidential.equals(task.confidential) : task.confidential != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = description != null ? description.hashCode() : 0;
        result = 31 * result + estimateDuration;
        result = 31 * result + (notes != null ? notes.hashCode() : 0);
        result = 31 * result + (confidential != null ? confidential.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Task{" +
                "description='" + description + '\'' +
                ", estimateDuration=" + estimateDuration +
                ", notes='" + notes + '\'' +
                ", confidential='" + confidential + '\'' +
                '}';
    }
}
