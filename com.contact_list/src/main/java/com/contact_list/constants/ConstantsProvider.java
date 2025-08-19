package com.contact_list.constants;

import com.contact_list.utils.ConfigReader;

public class ConstantsProvider {
    public static final String configPath = "src/main/resources/config/config.properties";
    public static final String screenshotsDirPath = System.getProperty("user.dir") + "/screenshots";
    public static final String jsonSchemasDir = "src/test/resources/jsonschemas";
    /**
     * The below constants are defined for backend APIs. These include
     * various endpoints
     */
    public static final String BASE_URI = ConfigReader.getInstance().getProperty("base.uri");
    public static final String SIGN_IN_ENDPOINT = BASE_URI;
    public static final String SIGN_UP_ENDPOINT = BASE_URI + "addUser";
    public static final String CONTACT_LIST_ENDPOINT = BASE_URI +"contactList";
}
