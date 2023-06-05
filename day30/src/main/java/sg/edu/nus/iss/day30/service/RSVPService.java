package sg.edu.nus.iss.day30.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.nus.iss.day30.model.AggregrationRSVP;
import sg.edu.nus.iss.day30.model.RSVP;
import sg.edu.nus.iss.day30.repository.RSVPRepository;

@Service
public class RSVPService {
    
    @Autowired
    private RSVPRepository repo;

    public RSVP insertRSVP(final RSVP rsvp) {
        return this.repo.insertRSVP(rsvp);
    }

    public List<AggregrationRSVP> aggregateByFoodType(){
        return this.repo.aggregateByFoodType();
    }
    
}
