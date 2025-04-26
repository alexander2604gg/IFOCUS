package com.web.ifocus.service.default_category;

import com.web.ifocus.dto.default_category.DefaultCategoryResponseDto;
import com.web.ifocus.entity.DefaultCategory;
import com.web.ifocus.repository.DefaultCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DefaultCategoryService {

    private final DefaultCategoryRepository defaultCategoryRepository;

    public DefaultCategoryService(DefaultCategoryRepository defaultCategoryRepository) {
        this.defaultCategoryRepository = defaultCategoryRepository;
    }

    public List<DefaultCategoryResponseDto> getAll() {
        List<DefaultCategory> categories = defaultCategoryRepository.findAll();
        return categories.stream()
                .map(category -> new DefaultCategoryResponseDto(
                        category.getDefaultCategoryId(),
                        category.getName(),
                        category.getIcon(),
                        category.getDescription()
                ))
                .collect(Collectors.toList());
    }
}
