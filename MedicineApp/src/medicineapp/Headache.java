package medicineapp;


public class Headache extends Medicine{
    
    public Headache(String genericName,String brandName, String medicineType,double price, int stock){
        super(genericName,brandName,medicineType,price,stock);
    }
    
    public Headache(int id, String genericName,String brandName, String medicineType,double price, int stock){
        super(id, genericName,brandName,medicineType,price,stock);
    }
    
    
    public Headache(Medicine info){
        this(info.getGenericName(),info.getBrandName(),info.getMedicineType(),info.getPrice(),info.getStock());
    }
    
    public Headache(){
        this(new Headache());
    }
    
    public Headache(int size, Medicine e){
        super(size,e.getGenericName(), e.getBrandName(), e.getMedicineType(),e.getPrice(), e.getStock());
    }
    
    @Override
    public String toString() {
        return String.format("Generic name: %s \nBrand Name: %s\nMedicine Type: %s\nPrice: %.2f\nStock: %d",super.getGenericName(),super.getBrandName(),super.getMedicineType(),super.getPrice(),super.getStock());
    }
    
}
