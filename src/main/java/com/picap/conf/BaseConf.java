package com.picap.conf;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.Filter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.util.EnvironmentVariables;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class BaseConf {

    protected Actor picapActor;
    private EnvironmentVariables environmentVariables;

    @Managed
    WebDriver browser;

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
        picapActor = theActorCalled("Miguel");

        picapActor.can(BrowseTheWeb.with(browser));

        picapActor.can(CallAnApi
                .at(
                        EnvironmentSpecificConfiguration.from(environmentVariables)
                                .getProperty("service.base.url")
                ));
        SerenityRest.setDefaultRequestSpecification(defaultRequestSpecification());

        browser.manage().window().maximize();
        picapActor.remember("baseUrl",
                EnvironmentSpecificConfiguration.from(environmentVariables)
                        .getProperty("webdriver.base.url"));
    }

    private RequestSpecification defaultRequestSpecification() {
        List<Filter> filters = new ArrayList<>();
        filters.add(new RequestLoggingFilter());
        filters.add(new ResponseLoggingFilter());
        return new RequestSpecBuilder()
                .addFilters(filters).build();
    }
}
