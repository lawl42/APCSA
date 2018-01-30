import java.util.*;
/**
 * Store details of club memberships.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Club
{
    private ArrayList<Membership> member;  
    
    /**
     * Constructor for objects of class Club
     */
    public Club()
    {
        // Initialise any fields here ...
        member = new ArrayList<Membership>();
    }

    /**
     * Add a new member to the club's list of members.
     * @param member The member object to be added.
     */
    public void join(Membership member)
    {
        this.member.add(member);
    }

    /**
     * @return The number of members (Membership objects) in
     *         the club.
     */
    public int numberOfMembers()
    {
        return member.size();
    }
    
    /**
     * Determine the number of members who joined in the given month.
     * @param month The month we are interested in.
     * @return The number of members who joined in that month.
     */
    public int joinedInMonth(int month) {
        int num = 0;
        Iterator<Membership> it = member.iterator();
        while(it.hasNext()) {
            Membership m = it.next();
            int mes = m.getMonth();
            if (mes == month) num++;
        }
        
        return num;
    }
    
    /**
     * PURGE
     */
    public ArrayList<Membership> purge(int month, int year) {
        ArrayList<Membership> ret = new ArrayList<Membership>();
        Iterator<Membership> it = member.iterator();
        while(it.hasNext()) {
            Membership m = it.next();
            if (m.getMonth() == month && m.getYear() == year) {
                ret.add(m);
                it.remove();
            }
        }
        
        return ret;
    }
}
