package profile;

import java.util.ArrayList;
import java.util.Collections;

/*
    TODO
    Make UI for profile creation


 */

//make a friend class that extends this?
public class Profile implements Comparable<Profile>{

    private String _firstName;      //first name
    private String _lastName;       //last name
    private String _email;          //email
    private int _age;               //used to filter appropiate
    //location?


    private ArrayList<Profile> friendsList  = new ArrayList<Profile>();
    private ArrayList<Interest> interestList = new ArrayList<Interest>();

    //constructor
    public Profile(String firstName, String lastName, String email, int age){
        this._firstName = firstName;
        this._lastName = lastName;
        this._email = email;
        this._age = age;
    }

    /*friendsList methods*/
    public void addFriend(Profile newFriend){
        this.friendsList.add(newFriend);
        Collections.sort(this.friendsList);
    }

    public void removeFriend(Profile badFriend){
        this.friendsList.remove(badFriend);
    }


    /*compareTo
        compares Profiles by name
        Meant to sort friend's list
        @returns: -1 this preceeds other
            1 this follows other
            0 both names are the same
     */
    public int compareTo(Profile other){
        final int LAST_NAME = (this._lastName.compareTo(other._lastName));
        final int FIRST_NAME = (this._firstName.compareTo(other._firstName));

        int nameCompare = LAST_NAME;

        if(LAST_NAME == 0){
            nameCompare = FIRST_NAME;
        }

        if(nameCompare < 0)
            return -1;
        else if(nameCompare > 0)
            return 1;
        else
            return 0;
    }



    //getters & setters
    public String getName(){
        return this._firstName + " " + this._lastName;
    }
    public void setName(String s){
        this._firstName = s;
    }

    public int getAge(){ return this._age;}
    public void setAge(int x){ this._age = x;}

}
