package com.barkie.barkie.view;


        import com.barkie.barkie.controller.service.TeamService;
        import com.barkie.barkie.domein.Team;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.*;

        import java.util.ArrayList;
        import java.util.Iterator;
        import java.util.List;

@RestController
@RequestMapping(value = "team")
public class TeamEndpoint {
    private final TeamService teamService;

    @Autowired
    public TeamEndpoint(TeamService teamService){this.teamService = teamService;}



    @GetMapping(value =  "/")
    public List<Team> getAllTeams() {
        Iterator<Team> iterator = teamService.getAll().iterator();
        List<Team> teams = new ArrayList<>();
        while (iterator.hasNext()) {
            teams.add(iterator.next());
        }
        return teams;
    }
}
