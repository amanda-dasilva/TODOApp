package model;

import java.util.Date;

/**
 *
 * @author amandasilva
 */
public class Task {
    
    private int id;
    private int project_id;
    private String name;
    private String description;
    private boolean status;
    private String notes;
    private Date dueDate;
    private Date createdAt;
    private Date updatedAt;

    public Task(int id, int project_id, String name, String description, boolean status, String notes, Date dueDate, Date createdAt, Date updatedAt) {
        this.id = id;
        this.project_id = project_id;
        this.name = name;
        this.description = description;
        this.status = status;
        this.notes = notes;
        this.dueDate = dueDate;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Task() {
        this.createdAt = new Date();
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Task{" + "name=" + name + ", description=" + description + ", dueDate=" + dueDate + ", status=" + status + ", updatedAt=" + updatedAt + '}';
    }
    
    
    
}
