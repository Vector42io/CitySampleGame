import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Game {
    ArrayList<String> cities;
    ArrayList<String> history = new ArrayList<>();
    int level;

    public static void main(String[] args) {
        Game g = new Game();
        g.findMeCity("");
    }

    public Game() {
        updateCities();
    }

    private void updateCities(){
        cities = new ArrayList<>();
        File file = new File(".\\test.txt");
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String cityFromFile;
            while (( cityFromFile = br.readLine()) != null)
                cities.add(cityFromFile.trim());

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public String findMeCity(String city){
        char lastChar = (char) (city.charAt( city.length() - 1 ) | 32);
        cities.remove(city);
        history.add(city);
        for (int i = 0; i < cities.size(); i++) {
            String c = cities.get(i);
            if (c.charAt(0) == lastChar){
                cities.remove(c);
                history.add(c);
                return c;
            }
        }

        return "";
    }

    public void restart(){

    }

    public void levelUp(){
        level++;
    }

    public boolean isCity(String city) {
        return cities.contains(city);
    }

}



