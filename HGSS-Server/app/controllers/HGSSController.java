package controllers;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import models.HGSSAction;
import models.HGSSStation;
import com.fasterxml.jackson.databind.JsonNode;
import models.HGSSUser;
import play.data.Form;
import play.Logger;
import play.libs.Json;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;

import play.data.FormFactory;

import javax.inject.Inject;

/**
 * Created by penic on 20.05.17..
 */
public class HGSSController extends Controller {

    @Inject
    FormFactory formFactory;

    private static final int UNKNOWN_USER_STATUS = 488;

    public Result getUsers(){
        Logger.debug("----------- Request: getUsers -----------");
        List<HGSSUser> users = HGSSUser.findAll();

        return ok(views.html.users.render(users));
    }

    public Result getStations(){
        Logger.debug("----------- Request: getStations -----------");
        List<HGSSStation> stations = HGSSStation.findAll();

        return ok(views.html.stations.render(stations));
    }

    public Result registerUser(){
        Logger.debug("----------- Request: registerUser -----------");
        Form<HGSSUser> userForm = formFactory.form(HGSSUser.class).bindFromRequest();

        if (userForm == null) return null;

        HGSSUser user = userForm.get();
        user.save();

        return ok(views.html.registerUser.render());
    }

    @BodyParser.Of(BodyParser.Json.class)
    public Result login(){
        Logger.debug("----------- Request: login -----------");

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

    @BodyParser.Of(BodyParser.Json.class)
    public Result initAction(){
        Logger.debug("----------- Request: initAction -----------");

        JsonNode json = request().body().asJson();
        String username = json.findPath("username").textValue();
        Double longitude = json.findPath("longitude").doubleValue();
        Double latitude = json.findPath("latitude").doubleValue();
        String description = json.findPath("description").textValue();

        Logger.debug("Received json: " + json);

        HGSSUser owner = HGSSUser.findUserByUsername(username);

        Logger.debug("User owner: " + owner);

        if(owner == null){
            Logger.debug("Return: " + UNKNOWN_USER_STATUS);
            return status(UNKNOWN_USER_STATUS);
        }

        HGSSStation station = owner.station;
        Logger.debug("User station: " + station);

        List<HGSSUser> users = HGSSUser.findAvailableUsers(station);
        HGSSAction action = new HGSSAction(owner, longitude, latitude, description);

        ArrayNode jsonUsers = Json.newArray();

        for(HGSSUser user : users){
            ObjectNode jsonUser = Json.newObject();
            jsonUser.put("username", user.username);
            jsonUser.put("firstName", user.firstName);
            jsonUser.put("lastName", user.lastName);
            jsonUser.put("skill", user.skill);
            jsonUser.put("role", user.role);
            jsonUsers.add(jsonUser);
        }

        Logger.debug("Creating a new action...");
        action.save();
        Logger.debug("Action created: " + action);

        Logger.debug("Return: " + jsonUsers);

        return ok(jsonUsers);
    }

    @BodyParser.Of(BodyParser.Json.class)
    public Result addUsersForAction(){
        Logger.debug("----------- Request: addUsersForAction -----------");

        JsonNode json = request().body().asJson();
        List<String> usernames = json.findValuesAsText("username");

        return badRequest();
    }

}
