package controllers;

import models.HGSSUser;
import models.enumerations.HGSSRole;
import models.enumerations.HGSSSkill;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by penic on 20.05.17..
 */
public class HGSSController extends Controller {

    public Result getUsers(){
        List<HGSSUser> users = new ArrayList<>();
        users.add(new HGSSUser("user1", "pass1", "Marko", "Markic",
                HGSSRole.ROLE_1, HGSSSkill.SKILL_1));
        users.add(new HGSSUser("user2", "pass2", "Ivan", "Ivic",
                HGSSRole.ROLE_2, HGSSSkill.SKILL_2));
        users.add(new HGSSUser("user3", "pass3", "Pero", "Peric",
                HGSSRole.ROLE_3, HGSSSkill.SKILL_3));

        return ok(Json.toJson(users));
    }

}
