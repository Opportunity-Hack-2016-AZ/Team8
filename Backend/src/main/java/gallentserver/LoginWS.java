package gallentserver;
import beans.AccountID;
import beans.Profile;
import beans.Team;
import mongohandler.MongoException;
import mongohandler.MongoHandler;
import mongohandler.MongoOperator;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jettison.json.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by vishal on 01/10/16.
 */

@Path("login")
public class LoginWS {


    MongoOperator mongoOperator = new MongoHandler();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String loginUser(final InputStream incomingData){

        Object result = null;
        JSONObject jobject = null;
        String status = null;
        StringBuilder sb = new StringBuilder();

        StringBuilder crunchifyBuilder = new StringBuilder();

        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
            String line = null;
            while ((line = in.readLine()) != null) {
                crunchifyBuilder.append(line);
            }
        } catch (Exception e) {
            System.out.println("Error Parsing: - ");
        }

        System.out.println("Data Received: " + crunchifyBuilder.toString());
        String callStatus = "";

        try {
            ObjectMapper mapper = new ObjectMapper();
            Profile profile = mapper.readValue(crunchifyBuilder.toString(), Profile.class);

            AccountID accountID = new AccountID(profile.getId());
            if(!mongoOperator.exists(accountID)){

                mongoOperator.populateProfile(profile);
            }else{

                profile = mongoOperator.getProfile(accountID);
            }
            callStatus = mapper.writeValueAsString(profile);

        }  catch (JsonParseException e) {

            e.printStackTrace();
        } catch (JsonMappingException e) {
            callStatus = "jsonError";
            e.printStackTrace();
        } catch (IOException e) {
            callStatus = "IOError";
            e.printStackTrace();
        } catch (MongoException e) {
            callStatus = "mongoError";
            e.printStackTrace();
        }


        return callStatus;

    }





}
