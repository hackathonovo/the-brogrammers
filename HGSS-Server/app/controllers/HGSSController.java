package controllers;


import models.HGSSStation;

import com.fasterxml.jackson.databind.JsonNode;

import models.HGSSUser;
import play.Logger;
import play.libs.Json;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;

/**
 * Created by penic on 20.05.17..
 */
public class HGSSController extends Controller {

    private static final int UNKNOWN_USER_STATUS = 488;

    public Result getUsers(){
        Logger.debug("Request: getUsers");
        List<HGSSUser> users = HGSSUser.findAll();

        return ok(views.html.users.render(users));
    }


    public Result getStations(){
        Logger.debug("Request: getStations");
        List<HGSSStation> stations = HGSSStation.findAll();

        return ok(views.html.stations.render(stations));
    }


    @BodyParser.Of(BodyParser.Json.class)
    public Result login(){
        Logger.debug("Request: login");

        // Get fields from the request
        JsonNode json = request().body().asJson();
        String username = json.findPath("username").textValue();
        String password = json.findPath("password").textValue();

        Logger.debug("Received json: " + json);
        Logger.debug("Checking user with credentials...");

        HGSSUser user = HGSSUser.checkUser(username, password);

        Logger.debug("User found: " + user);

        if(user == null){
            Logger.debug("Return: " + UNKNOWN_USER_STATUS);
            return status(UNKNOWN_USER_STATUS);
        }

        JsonNode jsonUser = Json.toJson(user);

        Logger.debug("Return: " + jsonUser);
        return ok(jsonUser);

    }

}
