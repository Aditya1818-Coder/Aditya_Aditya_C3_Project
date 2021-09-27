import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Restaurant {
    private String name;
    private String location;
    public LocalTime openingTime;
    public LocalTime closingTime;
    private List<Item> menu = new ArrayList<Item>();


    public Restaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        this.name = name;
        this.location = location;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
    }


    public LocalTime getOpeningTime() {
        return openingTime;
    }

    public LocalTime getClosingTime() {
        return closingTime;
    }

    public boolean isRestaurantOpen() {
        if(getCurrentTime().compareTo(getClosingTime())<0 && getCurrentTime().compareTo(getOpeningTime())>0){
            return true;
        }
        return false;
        //DELETE ABOVE STATEMENT AND WRITE CODE HERE
    }

    public LocalTime getCurrentTime(){ return  LocalTime.now(); }

    public List<Item> getMenu() {
        return menu;
        //DELETE ABOVE RETURN STATEMENT AND WRITE CODE HERE
    }
    private Item findItemByName(String itemName){
        for(Item item: menu) {
            if(item.getName().equals(itemName))
                return item;
        }
        return null;
    }

    public void addToMenu(String name, int price) {
        Item newItem = new Item(name,price);
        menu.add(newItem);
    }
    
    public void removeFromMenu(String itemName) throws itemNotFoundException {

        Item itemToBeRemoved = findItemByName(itemName);
        if (itemToBeRemoved == null)
            throw new itemNotFoundException(itemName);

        menu.remove(itemToBeRemoved);
    }
    public void displayDetails(){
        System.out.println("Restaurant:"+ name + "\n"
                +"Location:"+ location + "\n"
                +"Opening time:"+ openingTime +"\n"
                +"Closing time:"+ closingTime +"\n"
                +"Menu:"+"\n"+getMenu());

    }

    @Override
    public String toString(){
        return "Restaurant:"+ name + "\n"
                +"Location:"+ location + "\n"
                +"Opening time:"+ openingTime +"\n"
                +"Closing time:"+ closingTime +"\n"
                +"Menu:"+"\n"+getMenu();

    }

    public int getItemPriceForGivenItems(List<String> itemNames){
        Map<String, Integer> itemMap = new HashMap<>();
        for(Item item: menu) {
            itemMap.put(item.getName(), item.getPrice());
        }
        int itemPrice = 0;
        for(String name: itemNames){
            if(itemMap.containsKey(name)){
                itemPrice += itemMap.get(name);
            }
        }
        return itemPrice;
    }

    public String getName() {
        return name;
    }

}
