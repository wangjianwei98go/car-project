package cn.lnj.project.car.data;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="Carid")
public class carId {
    @Id
    private String id;

    @Column(name = "carId")
    private String carId;
private String getid(){
    return id;
}
private void setId(String id){
    this.id=id;
}
    private String getcarId(){
        return carId;
    }
    private void setcarId(String carId){
        this.carId=carId;
    }
}
