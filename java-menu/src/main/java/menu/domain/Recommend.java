package menu.domain;

import static menu.handler.ErrorStateHandler.CATEGORY_RECOMMEND_COUNT;
import static menu.util.Constants.CATEGORY_RECOMMEND_MAX_COUNT;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import menu.domain.enums.Category;
import menu.domain.enums.Day;
import menu.domain.generator.CategoryRandomIdGenerator;
import menu.util.ResultConverter;

public class Recommend {
    private final List<Category> recommendedCategories;
    private final Coaches coaches;

    public Recommend(Coaches coaches) {
        this.recommendedCategories = new ArrayList<>(List.of());
        this.coaches = coaches;
    }

    public Category recommendCategory() {
        int categoryId = pickCategoryId();
        Category recommendedCategory = Category.getById(categoryId);
        checkCategoryRecommendCount(recommendedCategory);
        recommendedCategories.add(recommendedCategory);
        return recommendedCategory;
    }

    private void checkCategoryRecommendCount(Category recommendedCategory) {
        if (recommendedCategories.stream().filter(recommendedCategory::equals).count() > CATEGORY_RECOMMEND_MAX_COUNT) {
            throw CATEGORY_RECOMMEND_COUNT.getException();
        }
    }

    private int pickCategoryId() {
        CategoryRandomIdGenerator randomIdGenerator = new CategoryRandomIdGenerator();
        return randomIdGenerator.generate();
    }

    @Override
    public String toString() {
        return ResultConverter.toString("구분", Day.getAllDayNames())
                + ResultConverter.toString("카테고리", getCategoryNames())
                + coaches.toString();
    }

    private List<String> getCategoryNames() {
        return recommendedCategories.stream()
                .map(Category::getName)
                .collect(Collectors.toUnmodifiableList());
    }

}
