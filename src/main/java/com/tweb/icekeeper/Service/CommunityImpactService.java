package com.tweb.icekeeper.Service;

import com.tweb.icekeeper.Model.CommunityImpact;
import com.tweb.icekeeper.Repository.CommunityImpactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommunityImpactService {

    @Autowired
    private CommunityImpactRepository communityImpactRepository;


    // Metodo per ottenere tutti gli impatti comunitari associati a un progetto specifico
    public List<CommunityImpact> getCommunityImpactsByProjectId(Long projectId) {
        return communityImpactRepository.findByProjectId(projectId);
    }


    // Metodo per creare un nuovo impatto comunitario
    public CommunityImpact createCommunityImpact(CommunityImpact communityImpact) {
        return communityImpactRepository.save(communityImpact);
    }

    //devo aggiungere altri metodi
}
