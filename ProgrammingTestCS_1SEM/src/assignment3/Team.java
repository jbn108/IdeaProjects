package assignment3;

import java.util.ArrayList;
import java.util.List;

public class Team {
   private ArrayList<TeamMember> members = new ArrayList<>();

    /**
     * 
     * @param m an instance of TeamMember
     * Adds a teammember to the instance field members
     */
    public void addTeamMember(TeamMember m) {
        members.add(m);
    }
    
    // Nothing to do here!
    public void addTeamMembers(ArrayList<TeamMember> t) {
        members.addAll(t);
    }
    
    // Nothing to do here!
    public ArrayList<TeamMember> getAllMembers() {
       return members;
    }
    
    /**
     * 
     * @param m the TeamMember to remove
     * @return if a TeamMember was removed
     */
    public boolean removeTeamMember(TeamMember m){
        return members.remove(m);
    }

    /**
     * 
     * @return the next available id
     * The id must start at 0. If a members is removed from the list, 
     * the id must be freed for the next member.
     * The next id must always be the smallest possible id number
     */
    
    public int getNextId() {
        for (int i = 0; i < members.size(); i++){
            if(i < members.get(i).getId()){
                return i;
            }
        }
        return members.size();
    }

    /**
     * 
     * @param role, a String representing the role of the TeamMember
     * @return an ArrayList of all TeamMember that has the specified role
     */
    public ArrayList<TeamMember> retriveMembersByRole(String role) {
        ArrayList<TeamMember> mems = new ArrayList<>();
        for (TeamMember mem : this.members){
            if (mem.getRole().equals(role)){
                mems.add(mem);
            }
        }
        return mems;
    }

    /**
     * Sort the TeamMember list in ascending order by name
     */
    public void sortByNameAsc() {
        TeamMember temp;
        for (int i = 0; i< members.size(); i++){

        }
    }

    /**
     * Sort the TeamMember list in descending order by role
     */
    public void sortByRoleDesc() {
        //TODO Delete line below, and implement this method.
        throw new UnsupportedOperationException();
    }
    
}
