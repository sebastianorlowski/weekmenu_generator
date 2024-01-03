package com.meal_generator.api.validation;

public class RecipeDtoValidationMessage {

    /** 400 **/
    public static final String RECIPE_NAME_REQUIRED_ERROR = "Recipe name is required.";
    public static final String RECIPE_NAME_LENGTH_ERROR = "The name of the recipe should be between 3 and 100 characters.";

    public static final String RECIPE_DAYS_REQUIRED_ERROR = "Recipe days are required.";
    public static final String RECIPE_DAYS_MIN_ERROR = "The minimum number of recipe days must be 1.";
    public static final String RECIPE_DAYS_MAX_ERROR = "The maximum number of recipe days must be 7.";

    public static final String RECIPE_INGREDIENTS_REQUIRED_ERROR = "You must provide the ingredients for the recipe.";

    public static final String RECIPE_INSTRUCTION_REQUIRED_ERROR = "Recipe instruction is required.";
    public static final String RECIPE_INSTRUCTION_LENGTH_ERROR = "Recipe instruction should be between 10 and 10000 characters.";

    public static final String RECIPE_ESTIMATED_TIME_REQUIRED_ERROR = "Estimated recipe time is required.";
    public static final String RECIPE_ESTIMATED_TIME_MIN_ERROR = "The minimum estimated recipe time must be 5 minutes.";
    public static final String RECIPE_ESTIMATED_TIME_MAX_ERROR = "The maximum estimated recipe time must be 1200 minutes.";

    public static final String RECIPE_INGREDIENT_NAME_REQUIRED_ERROR = "Ingredient name is required.";
    public static final String RECIPE_INGREDIENT_NAME_LENGTH_ERROR = "The name of the ingredient should be between 3 and 100 characters.";
    public static final String RECIPE_INGREDIENT_WORTH_REQUIRED_ERROR = "Ingredient worth is required.";
    public static final String RECIPE_INGREDIENT_WORTH_MIN_ERROR = "The minimum number of worth is 0g.";
    public static final String RECIPE_INGREDIENT_WORTH_MAX_ERROR = "The maximum number of worth is 1000000g.";
    public static final String RECIPE_INGREDIENT_EXTRA_INFO_LENGTH_ERROR = "The extra info of the ingredient should be between 0 and 1000 characters.;";

    /** 404 **/
    public static final String RECIPE_NOT_FOUND_ERROR = "Recipe with %s id not found.";
}
