
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frc.elo.ranking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.net.URL;
import java.net.HttpURLConnection;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.util.HashMap;
/**
 *
 * @author lburkowski
 */
public class TBA {
    private static String baseURL = "https://www.thebluealliance.com/api/v3/";
    private static String TBAKey = "Pza7G5kF9Ug9voiq58OZsUnXBw6tYEi9t261mXfGcUhGfzmZGcqfV92MrrstWUps";
    private static final JSONParser parser = new JSONParser();
    
    public static Object doRequest(String trgtUrl) throws Exception{
        HttpURLConnection con = null;
        try{    
            String uri = baseURL + trgtUrl;
            URL url = new URL(uri);
            con = (HttpURLConnection) url.openConnection();

            con.setRequestMethod("GET");

            con.setRequestProperty("User-Agent", "TBA-API-V3");
            con.setRequestProperty("X-TBA-Auth-Key", TBAKey);
            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            con.setRequestProperty("charset", "utf-8");
            con.setUseCaches(false);

            InputStream is = con.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = rd.readLine()) != null) {
                response.append(line);
                response.append('\r');
            }
            rd.close();
            return parser.parse(response.toString());
        } catch(Exception e) {
            // do nothing, should be handled somewhere else
        } finally {
            if(con != null) con.disconnect();
        }
        return null;
    }
    
    public static Team[] getEventTeams(String eventKey) throws Exception {
        JSONArray teams = (JSONArray) doRequest("event/"+eventKey+"/teams");
        Team[] teamlist = new Team[teams.size()];
        for(int i = 0; i < teams.size(); i++){
            HashMap hash = (HashMap) teams.get(i);
            teamlist[i] = new Team((String) hash.get("key"), 2500);
        }
        return teamlist;
    }
    
    public static Match[] getEventMatches(String eventKey) throws Exception{
        JSONArray matches = (JSONArray) doRequest("event/"+eventKey+"/matches");
        Match[] matchResults = new Match[matches.size()];
        for(int i = 0; i < matches.size(); i++){
            HashMap hash = (HashMap) matches.get(i);
            
            JSONObject alliances = (JSONObject) hash.get("alliances");
            JSONObject blueTeam = (JSONObject) alliances.get("blue");
            JSONObject redTeam = (JSONObject) alliances.get("red");
            
            String[] blueTeamTokens = blueTeam.get("team_keys").toString().replace("\"", "").replace("[", "").replace("]", "").split(",");
            String[] redTeamTokens = redTeam.get("team_keys").toString().replace("\"", "").replace("[", "").replace("]", "").split(",");
            
            long blueScore = (long) blueTeam.get("score");
            long redScore = (long) redTeam.get("score");
            
            matchResults[i] = new Match(blueTeamTokens, redTeamTokens, blueScore, redScore);
                
        }
        return matchResults;
    }
    
}
