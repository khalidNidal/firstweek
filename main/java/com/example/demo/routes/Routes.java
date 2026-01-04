package com.example.demo.routes;

public final class Routes {

    private Routes() {}

    public static final String API_BASE = "/api";
    public static final String V0 = "/v0";

    public static final String ITEMS = API_BASE + V0 + "/items";

    public static final String ID = "/{id}";
    public static final String VALUE = "/value";
    public static final String SEARCH = "/search";
}
