package com.web.ifocus.dto.default_category;

public class DefaultCategoryResponseDto {
    private Long defaultCategoryId;
    private String name;
    private String icon;
    private String description;

    public DefaultCategoryResponseDto(Long defaultCategoryId, String name, String icon, String description) {
        this.defaultCategoryId = defaultCategoryId;
        this.name = name;
        this.icon = icon;
        this.description = description;
    }

    public Long getDefaultCategoryId() {
        return defaultCategoryId;
    }

    public void setDefaultCategoryId(Long defaultCategoryId) {
        this.defaultCategoryId = defaultCategoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
