package sg.edu.nus.iss.day22.respository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.springframework.jdbc.core.RowMapper;

import sg.edu.nus.iss.day22.model.RSVP;

public class RSVPRowMapper implements RowMapper<RSVP> {
    
    @Override
    public RSVP mapRow(ResultSet rs, int rowNum) throws SQLException {
        RSVP rsvp = new RSVP();

        rsvp.setId(rs.getInt("id"));
        rsvp.setName(rs.getString("name"));
        rsvp.setEmail(rs.getString("email"));
        rsvp.setPhone(rs.getString("phone"));
        rsvp.setConfirmationDate(new DateTime(DateTimeFormat.forPattern("dd/MM/yyyy").parseDateTime(rs.getString("confirmation_date"))));
        rsvp.setComments(rs.getString("comments"));
        
        return rsvp;
    }
}
