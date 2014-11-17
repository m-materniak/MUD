package com.mud.Entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by krzysiek on 2014-11-09.
 */
public class GameWorld implements Serializable{
    private List<Person> peopleInGame = new ArrayList<Person>();

    public Cell getStartingCell() {
        return startingCell;
    }

    public void setStartingCell(Cell startingCell) {
        this.startingCell = startingCell;
    }

    private Cell startingCell;

    public void AddPerson(Person person){
        peopleInGame.add(person);
    }

    public void RemovePerson(Person person) {
       peopleInGame.remove(person);
   }

    public List<Person> GetPeople(){
        return peopleInGame;
    }

    public List<Person> GetPeopleFromRoom(Cell room) {
        List<Person> peopleInRoom = new ArrayList<Person>();
        for (Person person : peopleInGame){
            if (person.location == room){
                peopleInRoom.add(person);
            }
        }
        return  peopleInRoom;
    }

    public Person GetPerson(String name) {
        for (Person person : peopleInGame){
            if (person.Name.equals(name)) {
                return person;
            }
        }
        return null;
    }
}
