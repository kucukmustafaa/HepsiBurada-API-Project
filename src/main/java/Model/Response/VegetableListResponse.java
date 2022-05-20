package Model.Response;


import Model.Request.Vegetable;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class VegetableListResponse {

    @SerializedName("data")
    public List<Vegetable> data;




}
