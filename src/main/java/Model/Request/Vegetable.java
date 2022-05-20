package Model.Request;


import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Vegetable {

    private int id;
    private String name;
    private float price;
    private int stock;

}
