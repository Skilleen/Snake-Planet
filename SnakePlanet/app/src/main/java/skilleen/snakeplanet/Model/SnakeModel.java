package skilleen.snakeplanet.Model;

import android.widget.ImageView;

/**
 * Created by Scilleen on 9/26/2015.
 */
public class SnakeModel {

    int id;
    int picture;
    String name;
    String danger;
    String location;
    String disc;
    String food;
    String predators;
    String firstAid;
    String created_at;

    // constructors
    public SnakeModel() {
    }

    public SnakeModel(String name)
    {
        this.name = name;
    }

    public SnakeModel(int id, int picture, String name, String danger, String location, String disc, String food, String predators, String firstAid) {
        this.id = id;
        this.picture = picture;
        this.name = name;
        this.danger = danger;
        this.location = location;
        this.disc = disc;
        this.food = food;
        this.predators = predators;
        this.firstAid = firstAid;

    }

    // setters
    public void setId(int id) {
        this.id = id;
    }

    public void setPicture(int picture) {

        this.picture = picture;
    }
    public void setName(String name) {

        this.name = name;
    }
    public void setDanger(String danger) {

        this.danger = danger;
    }
    public void setLocation(String location) {

        this.location = location;
    }
    public void setDisc(String disc) {

        this.disc = disc;
    }
    public void setFood(String food) {

        this.food = food;
    }
    public void setPredators(String predators) {

        this.predators = predators;
    }
    public void setFirstAid(String firstAid) {

        this.firstAid = firstAid;
    }


    // getters
    public long getId()
    {
        return this.id;
    }

    public int getPicture()
    {
        return this.picture;
    }

    public String getName()
    {
        return this.name;
    }

    public String getDanger()
    {
        return this.danger;
    }

    public String getLocation()
    {
        return this.location;
    }

    public String getDisc()
    {
        return this.disc;
    }

    public String getFood()
    {
        return this.food;
    }

    public String getPredators()
    {
        return this.predators;
    }

    public String getFirstAid()
    {
        return this.firstAid;
    }


}
