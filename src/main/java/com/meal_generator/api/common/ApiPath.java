package com.meal_generator.api.common;

public class ApiPath {

    /** RECIPE ENDPOINTS **/

    public static final String CREATE_RECIPE = "/recipes";
    public static final String RETRIEVE_RECIPE = "/recipes/{id}";
    public static final String RETRIEVE_RECIPES = "/recipes/list";
    public static final String UPDATE_RECIPE = "/recipes/{id}";

    /** MEAL ENDPOINTS **/

    public static final String CREATE_MEAL = "/meals";
    public static final String RETRIEVE_MEAL = "/meals/{id}";
    public static final String RETRIEVE_MEALS= "/meals/list";
    public static final String UPDATE_MEAL = "/meals/{id}";
    public static final String CREATE_CONNECTION_TO_RECIPE = "/meals/link";
    public static final String UPDATE_CONNECTION_TO_RECIPE = "/meals/link";

    /** MENU ENDPOINTS **/
    public static final String CREATE_DAY_MENU = "/menus/days";
    public static final String CREATE_WEEK_MENU = "/menu/weeks";
}
