package spand0x;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Songs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Song> songList = new ArrayList<>();

        for(int i = 0; i < n ; i++){
            String[] data = scanner.nextLine().split("_");

            Song song = new Song();

            song.setTypeList(data[0]);
            song.setName(data[1]);
            song.setTime(data[2]);

            songList.add(song);

        }
        String typeList = scanner.nextLine();
        if(typeList.equals("all")){
            for (Song song :
                    songList) {
                System.out.println(song.getName());
            }
        }else{
            for(Song song : songList){
                if(song.getTypeList().equals(typeList)){
                    System.out.println(song.getName());
                }
            }
        }
    }
}

class Song{
    private String typeList;
    private String name;
    private String time;

    public String getTypeList() {
        return typeList;
    }

    public void setTypeList(String typeList) {
        this.typeList = typeList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
