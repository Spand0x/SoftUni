package com.spand0x.trafficlights;

import java.time.Year;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TrafficLight[] trafficLights = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(TrafficLight::valueOf)
                .toArray(TrafficLight[]::new);
        int n = Integer.parseInt(scanner.nextLine());

        TrafficLight[] lights = TrafficLight.values();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <trafficLights.length; j++) {
                int index = (trafficLights[j].ordinal() + 1) % lights.length;
                trafficLights[j] = lights[index];
                sb.append(trafficLights[j].toString()).append(" ");
            }
            sb.append(System.lineSeparator());
        }
        System.out.println(sb.toString());
    }
}
