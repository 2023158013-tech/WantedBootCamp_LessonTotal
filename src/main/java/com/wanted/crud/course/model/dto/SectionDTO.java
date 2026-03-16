package com.wanted.crud.course.model.dto;

public class SectionDTO {
    private Long sectionId;
    private Long courseId;
    private String title;
    private int sectionOrder;

    public SectionDTO() {
    }



    public SectionDTO(Long sectionId, Long courseId, String title, int sectionOder) {
        this.sectionId = sectionId;
        this.courseId = courseId;
        this.title = title;
        this.sectionOrder = sectionOder;
    }

    public Long getSectionId() {
        return sectionId;
    }

    public void setSectionId(Long sectionId) {
        this.sectionId = sectionId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getSectionOrder() {
        return sectionOrder;
    }

    public void setSectionOder(int sectionOder) {
        this.sectionOrder = sectionOder;
    }

    @Override
    public String toString() {
        return "CourseSectionDTO{" +
                "sectionId=" + sectionId +
                ", courseId=" + courseId +
                ", title='" + title + '\'' +
                ", sectionOder=" + sectionOrder +
                '}';
    }

}
