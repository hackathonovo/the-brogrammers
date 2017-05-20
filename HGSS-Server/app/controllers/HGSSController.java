package controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.HGSSAction;
import models.HGSSStation;
import com.fasterxml.jackson.databind.JsonNode;
import models.HGSSUser;
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
        Logger.debug("Request: getUsers");
        List<HGSSUser> users = HGSSUser.findAll();

        return ok(views.html.users.render(users));
    }

    public Result getStations(){
        Logger.debug("Request: getStations");
        List<HGSSStation> stations = HGSSStation.findAll();

        return ok(views.html.stations.render(stations));
    }

    public Result saveUser() {
        DynamicForm userForm = formFactory.form().bindFromRequest();

        if (userForm == null) return null;

        String username = userForm.get("username");
        String password = userForm.get("password");
        String firstName = userForm.get("firstName");
        String lastName = userForm.get("lastName");
        String role = userForm.get("role");
        String skill = userForm.get("skill");

        HGSSUser user = new HGSSUser(username,password,firstName,lastName,role,skill);
        user.save();

        flash("success", "Korisnik dodan!");
        return redirect(routes.HGSSController.getUsers());
    }

    public Result user(){
        return ok(views.html.registerUser.render(null));
    }

    public Result setAvailibility(){
        Logger.debug("Request: login");

        JsonNode json = request().body().asJson();
        String username = json.findPath("username").textValue();
        String isAvailableStr = json.findPath("isAvailable").textValue();
        Boolean isAvailable = (isAvailableStr.equalsIgnoreCase("true")) ? true : false;

        Logger.debug("Received json: " + json);

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


    public Result getActions() {
        List<HGSSAction> actions = HGSSAction.findAll();
        return ok(views.html.actions.render(actions));
    }

    public Result action() {
        return ok(views.html.action.render(null));
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

//    /* Right now used only for ajax calls*/
//    public Result saveSWTYear() {
//        return SUDrequest(true, request().body().asJson());
//    }
//
//    /* Right now used only for ajax calls*/
//    public Result deleteSWTYear() {
//        return SUDrequest(false, request().body().asJson());
//    }
//
//    private Result SUDrequest(boolean save, JsonNode node) {
//        String agency;
//        Integer year;
//        Long userId;
//        String nodeString;
//        try {
//            nodeString = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(node);
//        } catch (Exception ex) {
//            logger.error(ex.getMessage());
//            return badRequest();
//        }
//        logger.debug("Got request to do year (save:" + save + "): " + nodeString);
//
//        try {
//            agency = node.get("agency").asText();
//            year = Integer.parseInt(node.get("year").asText());
//            userId = Long.parseLong(node.get("userId").asText());
//        } catch (Exception e) {
//            return badRequest(e.getMessage());
//        }
//        SWTYear swtYear = SWTYear.findYear(agency, year, userId);
//        if (save) {
//            if (swtYear != null) {
//                return badRequest("Want to save swtYear but there is already one");
//            }
//            swtYear = new SWTYear(year, agency, SWTUser.findUserById(userId));
//            swtYear.save();
//        } else {
//            if (swtYear == null) {
//                return badRequest("Want to delete swtYear but there is none like it");
//            }
//            swtYear.delete();
//        }
//        return ok();
//    }


}
