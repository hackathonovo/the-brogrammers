package controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import models.HGSSAction;
import models.HGSSChatMessage;
import models.HGSSStation;
import com.fasterxml.jackson.databind.JsonNode;
import models.HGSSUser;
import models.geo.HGSSLocation;
import models.geo.HGSSUserLocation;
import play.data.DynamicForm;
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



    public Result updateLocation() {

        JsonNode json = request().body().asJson();

        Logger.debug("Recieved json: " + json);

        String username = json.findPath("username").textValue();
        Double longitude = json.findPath("longitude").doubleValue();
        Double latitude = json.findPath("latitude").doubleValue();

        HGSSUserLocation location = new HGSSUserLocation(longitude, latitude);

        Logger.debug("Location to be added: long:" + location.longitude + " lat: " + location.latitude);

        HGSSUser user = HGSSUser.findUserByUsername(username);

        if (user == null) {
            Logger.debug("Return: " + UNKNOWN_USER_STATUS);
            return status(UNKNOWN_USER_STATUS);
        }

        user.currentLocations.add(location);

        user.update();

        Logger.debug("Location added to user: " + user.username);

        return ok();
    }

    public Result getActionsApp(){
        Logger.debug("----------- Request: getActionsApp -----------");

        List<HGSSAction> actions = HGSSAction.findActiveActions();

        ArrayNode jsonUsers = Json.newArray();

        for(HGSSAction action : actions){
            ObjectNode jsonAction = Json.newObject();
            jsonAction.put("id", action.id);
            jsonAction.put("title", action.title);
            jsonUsers.add(jsonAction);
        }

        return ok(Json.toJson(jsonUsers));
    }

    public Result getAction(Long id){
        Logger.debug("----------- Request: getAction(id) -----------");
        Logger.debug("Received id: " + id);

        HGSSAction action = HGSSAction.findById(id);

        JsonNode jsonAction = Json.toJson(action);
        ((ObjectNode) jsonAction).put("owner", action.owner.username);
        Logger.debug("Response action: " + jsonAction);

        return ok(jsonAction);
    }

    public Result saveUser() {
        Logger.debug("----------- Request: registerUser -----------");
        DynamicForm userForm = formFactory.form().bindFromRequest();

        if (userForm == null) return null;

        String username = userForm.get("username");
        String password = userForm.get("password");
        String firstName = userForm.get("firstName");
        String lastName = userForm.get("lastName");
        String role = userForm.get("role");
        String location = userForm.get("location");
        String skill = userForm.get("skill");
        String stationName = userForm.get("station");
        String phoneNumber = userForm.get("phoneNumber");
        String availableFrom = userForm.get("availableFrom");
        String availableUntil = userForm.get("availableUntil");
        Double stationLng = Double.parseDouble(userForm.get("station-lng"));
        Double stationLat = Double.parseDouble(userForm.get("station-lat"));
        HGSSStation station = new HGSSStation(stationName, stationLng, stationLat);
        station.save();

        HGSSUser user = new HGSSUser(username, password, firstName, lastName, role, skill, location,
                phoneNumber, availableFrom, availableUntil, station);

        if (HGSSUser.findUserByPhoneNumber(phoneNumber) != null) {
            user.update();
        } else {
        user.save();
        }

        flash("success", "Korisnik dodan!");
        return redirect(routes.HGSSController.getUsers());
    }

    public Result user(Long id){
        if (id == null) {
            return ok(views.html.registerUser.render(null));
        }
        HGSSUser user = HGSSUser.findUserById(id);
        return ok(views.html.registerUser.render(user));
    }

    public Result setAvailibility(){
        Logger.debug("----------- Request: setAvailability -----------");

        JsonNode json = request().body().asJson();

        Logger.debug("Received json: " + json);

        String username = json.findPath("username").textValue();
        Boolean isAvailable = json.findPath("isAvailable").booleanValue();

        HGSSUser user = HGSSUser.findUserByUsername(username);

        Logger.debug("User found: " + user);

        if(user == null){
            Logger.debug("Return: " + UNKNOWN_USER_STATUS);
            return status(UNKNOWN_USER_STATUS);
        }


        user.isAvailable = isAvailable;

        Logger.debug("Is available: " + user.isAvailable);
        user.update();

        return ok();

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

    public Result getActions() {
        Logger.debug("----------- Request: Actions -----------");
        List<HGSSAction> actions = HGSSAction.findAll();
        return ok(views.html.actions.render(actions));
    }

    public Result action() {
        return ok(views.html.action.render(null));
    }

    @BodyParser.Of(BodyParser.Json.class)
    public Result initAction(){
        Logger.debug("----------- Request: initAction -----------");

        JsonNode json = request().body().asJson();
        String username = json.findPath("username").textValue();
        String title = json.findPath("title").textValue();
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
        HGSSAction action = new HGSSAction(owner, title, longitude, latitude, description);

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

    public Result saveAction() {
        return ok();
    }

    public Result saveMap() {
        JsonNode node = request().body().asJson();
        String nodeString;
        try {
            nodeString = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(node);
        } catch (Exception ex) {
            Logger.error(ex.getMessage());
            return badRequest();
        }
        Logger.debug(nodeString);
        return ok();

    }

    @BodyParser.Of(BodyParser.Json.class)
    public Result updateAction(Long id) {
        Logger.debug("----------- Request: updateAction -----------");

        return ok();
    }


}
