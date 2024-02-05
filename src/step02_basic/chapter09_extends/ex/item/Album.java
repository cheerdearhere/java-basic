package step02_basic.chapter09_extends.ex.item;

public class Album extends Item{
    private String artist;
    public Album(String name, int price, String artist){
        super(name,price);
        this.artist=artist;
    }

    public String getArtist() {
        return artist;
    }

    @Override
    public void print(){
        super.print();
        System.out.println("- 아티스트: "+artist);
    }
}
