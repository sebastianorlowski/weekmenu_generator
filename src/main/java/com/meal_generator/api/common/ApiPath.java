package com.meal_generator.api.common;

public class ApiPath {

    /** RECIPE ENDPOINTS **/

    public static final String CREATE_RECIPE = "/recipe";
    public static final String RETRIEVE_RECIPE = "/recipe/{id}";
    public static final String RETRIEVE_RECIPES = "/recipes";
    public static final String UPDATE_RECIPE = "/recipe/{id}";

    /** MEAL ENDPOINTS **/

    public static final String CREATE_MEAL = "/meal";
    public static final String RETRIEVE_MEAL = "/meal/{id}";
    public static final String RETRIEVE_MEALS= "/meals";
    public static final String UPDATE_MEAL = "/meal/{id}";
    public static final String CREATE_CONNECTION_TO_RECIPE = "/meal";
    public static final String UPDATE_CONNECTION_TO_RECIPE = "/meal";
}
