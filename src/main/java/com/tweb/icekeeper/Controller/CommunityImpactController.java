package com.tweb.icekeeper.Controller;

import com.tweb.icekeeper.Model.CommunityImpact;
import com.tweb.icekeeper.Service.CommunityImpactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/community-impacts")
public class CommunityImpactController {
    @Autowired
    private CommunityImpactService communityImpactService;

    @GetMapping("/project/{projectId}")
    public List<CommunityImpact> getCommunityImpactsByProjectId(@PathVariable Long projectId) {
        return communityImpactService.getCommunityImpactsByProjectId(projectId);
    }

    @PostMapping
    public CommunityImpact createCommunityImpact(@RequestBody CommunityImpact communityImpact) {
        return communityImpactService.createCommunityImpact(communityImpact);
    }

}
