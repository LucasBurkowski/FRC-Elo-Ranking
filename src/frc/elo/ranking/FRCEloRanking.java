/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frc.elo.ranking;

/**
 *
 * @author lburkowski
 */
public class FRCEloRanking {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        Team[] teamList = TBA.getEventTeams("2017onto1");
        
        for (Team teamList1 : teamList) {
            System.out.println(teamList1.number);
        }
    }
    
}
